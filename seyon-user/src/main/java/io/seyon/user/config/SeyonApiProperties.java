package io.seyon.user.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("seyonProps")
@ConfigurationProperties(prefix="seyon.api")
public class SeyonApiProperties {

	List<String> roleCodes;

	public List<String> getRoleCodes() {
		return roleCodes;
	}

	public void setRoleCodes(List<String> roleCodes) {
		this.roleCodes = roleCodes;
	}
	

}
