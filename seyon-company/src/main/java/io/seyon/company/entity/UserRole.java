package io.seyon.company.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class UserRole {
	
	@Id	
	private Long id;
	
	@Column
	private String email;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getRoleCode() {
		return roleCode;
	}


	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}


	@Column
	private String roleCode;


}
