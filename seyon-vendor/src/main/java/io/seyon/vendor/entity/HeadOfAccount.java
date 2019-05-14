package io.seyon.vendor.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="head_of_account")
public class HeadOfAccount implements Serializable {

	
	private static final long serialVersionUID = -5177866691681294817L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	
	@Column
	private Long companyId;
	
	@Column
	private String headOfAccountName;	
	
	@Column
	private String subGroup;
	
	@Column
	private String mainGroup;
	
	@Column
	private String balanceSheet;
	
	@Column
	private String createdBy;

	@Column
	private Date createdDate;
	
	@Column
	private String updatedBy;
	

	@Column
	private Date updatedDate;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getCompanyId() {
		return companyId;
	}


	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}


	public String getHeadOfAccountName() {
		return headOfAccountName;
	}


	public void setHeadOfAccountName(String headOfAccountName) {
		this.headOfAccountName = headOfAccountName;
	}


	public String getSubGroup() {
		return subGroup;
	}


	public void setSubGroup(String subGroup) {
		this.subGroup = subGroup;
	}


	public String getMainGroup() {
		return mainGroup;
	}


	public void setMainGroup(String mainGroup) {
		this.mainGroup = mainGroup;
	}


	public String getBalanceSheet() {
		return balanceSheet;
	}


	public void setBalanceSheet(String balanceSheet) {
		this.balanceSheet = balanceSheet;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public String getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}


	public Date getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


	@Override
	public String toString() {
		return "HeadOfAccount [id=" + id + ", companyId=" + companyId + ", headOfAccountName=" + headOfAccountName
				+ ", subGroup=" + subGroup + ", mainGroup=" + mainGroup + ", balanceSheet=" + balanceSheet
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy
				+ ", updatedDate=" + updatedDate + "]";
	}
	
	

}
