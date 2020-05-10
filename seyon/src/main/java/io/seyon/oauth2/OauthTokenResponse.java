package io.seyon.oauth2;

public class OauthTokenResponse {

	String access_token;
	String scope;
	String token_type;
	String refresh_token;
	Integer expires_in;
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	public Integer getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}
	@Override
	public String toString() {
		return "OauthTokenResponse [access_token=" + access_token + ", scope=" + scope + ", token_type=" + token_type
				+ ", refresh_token=" + refresh_token + ", expires_in=" + expires_in + "]";
	}
	
}
