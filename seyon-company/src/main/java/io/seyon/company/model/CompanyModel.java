package io.seyon.company.model;

import io.seyon.company.entity.Company;

import io.seyon.user.entity.UserInfo;

public class CompanyModel {
	
	private UserInfo userInfo;
	
	private Company company;

	
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "NewCompany [userInfo=" + userInfo + ", company=" + company + "]";
	}

}
