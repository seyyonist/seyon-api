package io.seyon.oauth2;

public class OauthUserInfo {
	
	String id;
	String email;
	String name;
	String given_name;
	String picture;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGiven_name() {
		return given_name;
	}
	public void setGiven_name(String given_name) {
		this.given_name = given_name;
	}
	@Override
	public String toString() {
		return "OauthUserInfo [id=" + id + ", email=" + email + ", name=" + name + ", given_name=" + given_name + "]";
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
}
