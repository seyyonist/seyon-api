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
	
	String clientId;
	String clientSecret;
	String tokenUrl;
	String userProfileUrl;
	String redirecturi;
	String proxyHost;
	String proxyPort;
	String proxyUser;
	String proxyPass;
	
	private boolean continueOnError = false;
	private String separator = ";";
	private Charset sqlScriptEncoding;
	
	String allowOriginDomain; 
	
		
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

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getTokenUrl() {
		return tokenUrl;
	}

	public void setTokenUrl(String tokenUrl) {
		this.tokenUrl = tokenUrl;
	}

	public String getUserProfileUrl() {
		return userProfileUrl;
	}

	public void setUserProfileUrl(String userProfileUrl) {
		this.userProfileUrl = userProfileUrl;
	}

	public String getProxyHost() {
		return proxyHost;
	}

	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	public String getProxyPort() {
		return proxyPort;
	}

	public void setProxyPort(String proxyPort) {
		this.proxyPort = proxyPort;
	}

	public String getProxyUser() {
		return proxyUser;
	}

	public void setProxyUser(String proxyUser) {
		this.proxyUser = proxyUser;
	}

	public String getProxyPass() {
		return proxyPass;
	}

	public void setProxyPass(String proxyPass) {
		this.proxyPass = proxyPass;
	}

	public String getAllowOriginDomain() {
		return allowOriginDomain;
	}

	public void setAllowOriginDomain(String allowOriginDomain) {
		this.allowOriginDomain = allowOriginDomain;
	}

	public String getRedirecturi() {
		return redirecturi;
	}

	public void setRedirecturi(String redirecturi) {
		this.redirecturi = redirecturi;
	}

}
