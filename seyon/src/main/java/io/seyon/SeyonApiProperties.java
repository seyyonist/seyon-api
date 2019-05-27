package io.seyon;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="seyon.api")
public class SeyonApiProperties {

	List<String> authExcludeUrl= new ArrayList<>();
	String restrictIp;
	String appId;
	List<String> sqlFiles;
	
	private boolean continueOnError = false;
	private String separator = ";";
	private Charset sqlScriptEncoding;
		
	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}
	
	public List<String> getAuthExcludeUrl() {
		return authExcludeUrl;
	}

	public void setAuthExcludeUrl(List<String> authExcludeUrl) {
		this.authExcludeUrl = authExcludeUrl;
	}

	public String getRestrictIp() {
		return restrictIp;
	}

	public void setRestrictIp(String restrictIp) {
		this.restrictIp = restrictIp;
	}

	public List<String> getSqlFiles() {
		return sqlFiles;
	}

	public void setSqlFiles(List<String> sqlFiles) {
		this.sqlFiles = sqlFiles;
	}

	public boolean isContinueOnError() {
		return continueOnError;
	}

	public void setContinueOnError(boolean continueOnError) {
		this.continueOnError = continueOnError;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public Charset getSqlScriptEncoding() {
		return sqlScriptEncoding;
	}

	public void setSqlScriptEncoding(Charset sqlScriptEncoding) {
		this.sqlScriptEncoding = sqlScriptEncoding;
	}

}
