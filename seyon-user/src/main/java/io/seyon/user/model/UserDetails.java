package io.seyon.user.model;


import io.seyon.user.entity.UserCompanyXref;
import io.seyon.user.entity.UserInfo;
import io.seyon.user.entity.UserRole;

public class UserDetails {
	
	private UserInfo userInfo;
	
	private UserRole userRole;
	
	private UserCompanyXref userCompanyXref;
	

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public UserCompanyXref getUserCompanyXref() {
		return userCompanyXref;
	}

	public void setUserCompanyXref(UserCompanyXref userCompanyXref) {
		this.userCompanyXref = userCompanyXref;
	}



}
