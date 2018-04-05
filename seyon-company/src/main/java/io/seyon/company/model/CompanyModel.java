package io.seyon.company.model;

import io.seyon.company.entity.Company;
import io.seyon.company.entity.User;

public class CompanyModel {
	
	private User user;
	
	private Company company;

	public User getUser() {
		return user;
	}

	public void setUser(User userInfo) {
		this.user = userInfo;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "NewCompany [userInfo=" + user + ", company=" + company + "]";
	}

}
