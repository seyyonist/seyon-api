package io.seyon.user.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_COMPANY_XREF")
public class UserCompanyXref implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2856878499678004433L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long Id;
	
	@Column
	String email;
	
	@Column
	Long companyId;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "UserCompanyXref [email=" + email + ", companyId=" + companyId + "]";
	}
}
