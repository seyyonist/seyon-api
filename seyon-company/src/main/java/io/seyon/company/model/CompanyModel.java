package io.seyon.company.model;

import io.seyon.company.entity.Company;
import io.seyon.company.entity.User;

public class CompanyModel {
	
	private User userInfo;
	
	private Company company;

	
	public User getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(User userInfo) {
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
