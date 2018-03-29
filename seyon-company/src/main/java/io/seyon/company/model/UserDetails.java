package io.seyon.company.model;

import io.seyon.company.entity.Company;
import io.seyon.company.entity.UserInfo;
import io.seyon.company.entity.UserRole;

public class UserDetails {
	
	private UserInfo userInfo;
	
	private UserRole userRole;
	
	private Company company;

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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
