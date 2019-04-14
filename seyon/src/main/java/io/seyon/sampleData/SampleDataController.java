package io.seyon.sampleData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.config.SortedResourcesFactoryBean;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.seyon.SeyonApiProperties;

@RestController
@RequestMapping("/api/sample")
@Profile("default")
public class SampleDataController {

	@Autowired
	SeyonApiProperties props;
	
	@Autowired
	DataSource dataSource;
	
	@GetMapping
	public void generateSampleData() {
		List<Resource> scripts = getScripts(props.getSqlFiles());
		if (!scripts.isEmpty()) {
			runScripts(scripts);
		}
	}
	
	private List<Resource> getScripts(List<String> resources) {
		if (resources != null) {
			return getResources(resources, true);
		}else {
			throw new IllegalArgumentException("Please specify the sql files");
		}
		
	}
	
	private List<Resource> getResources(List<String> locations,boolean validate) {
		List<Resource> resources = new ArrayList<>();
		for (String location : locations) {
			for (Resource resource : doGetResources(location)) {
				if (resource.exists()) {
					resources.add(resource);
				}
				else if (validate) {
					throw new InvalidConfigurationPropertyValueException(null,resource, "The specified resource does not exist.");
				}
			}
		}
		return resources;
	}

	private Resource[] doGetResources(String location) {
		try {
			SortedResourcesFactoryBean factory = new SortedResourcesFactoryBean(Collections.singletonList(location));
			factory.afterPropertiesSet();
			return factory.getObject();
		}
		catch (Exception ex) {
			throw new IllegalStateException("Unable to load resources from " + location,ex);
		}
	}
	
	private void runScripts(List<Resource> resources) {
		if (resources.isEmpty()) {
			return;
		}
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.setContinueOnError(props.isContinueOnError());
		populator.setSeparator(props.getSeparator());
		if (props.getSqlScriptEncoding() != null) {
			populator.setSqlScriptEncoding(props.getSqlScriptEncoding().name());
		}
		for (Resource resource : resources) {
			populator.addScript(resource);
		}
		DatabasePopulatorUtils.execute(populator, dataSource);
	}
}
