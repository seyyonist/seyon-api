package io.seyon;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.catalina.filters.RemoteAddrFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class SeyonApiApplication {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SeyonApiProperties seyonProperties;
	
	public static void main(String[] args) {
		SpringApplication.run(SeyonApiApplication.class, args);
	}

	@Bean
	public Docket productApi() {
		log.debug("Creating swagger docket");
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("io.seyon.resource")).build().apiInfo(metaData());
	}

	@Bean
	public WebMvcConfigurer interceptorConfigurer() {
		return new WebMvcConfigurer() {
			@Autowired
			HandlerInterceptor securityInterceptor;

			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				registry.addInterceptor(securityInterceptor).excludePathPatterns(seyonProperties.getAuthExcludeUrl());
				WebMvcConfigurer.super.addInterceptors(registry);
			}
		};
	}

	private ApiInfo metaData() {
		Collection<VendorExtension> coll = new ArrayList<VendorExtension>();
		log.debug("Swagger API info");
		ApiInfo apiInfo = new ApiInfo("Rest API For Seyon", "REST API For Seyon App", "1.0", "Terms of service",
				new Contact("ramlaxmi", "https://github.com/ramlaxmi/", "krithika6686@gmail.com"), "MIT",
				"https://opensource.org/licenses/MIT", coll);
		return apiInfo;
	}

	//@Bean  // deactivating the ip based restriction
	public FilterRegistrationBean<RemoteAddrFilter> remoteAddressFilter() {

	    FilterRegistrationBean<RemoteAddrFilter> filterRegistrationBean = new FilterRegistrationBean<>();
	    RemoteAddrFilter filter = new RemoteAddrFilter();
	    
	    filter.setAllow(seyonProperties.getRestrictIp());
	    filter.setDenyStatus(404);

	    filterRegistrationBean.setFilter(filter);
	    filterRegistrationBean.addUrlPatterns("/*");

	    return filterRegistrationBean;

	}

}
