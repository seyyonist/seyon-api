package io.seyon.voucher.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Voucher implements Serializable {

	private static final long serialVersionUID = 2295915883765052507L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private Long companyId;

	@Column
	private String voucherId;
	
	@Column
	private Long vendorId;
	
	
	@Column
	private String headOfAccount;
	
	
	@Column
	private String particulars; // Field for description or Narration

	@Column
	private Double totalAmount; // Gross Amount
	
	@Column
	private Double cgstPercent;
	
	@Column
	private Double sgstPercent;
	
	@Column
	private Double igstPercent;
	
	@Column
	private Double netAmount; // Net Amount
	
	@Column
	private Double tdsPercent; // TDS Percent
	
	@Column
	private Double netPayable; // Net payable
	
	@Column
	private Date voucherDate;

	@Column
	private String createdBy;

	@Column
	private Date createdDate;

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

	public String getVoucherId() {
		return voucherId;
	}

	public void setVoucherId(String voucherId) {
		this.voucherId = voucherId;
	}


	public String getHeadOfAccount() {
		return headOfAccount;
	}

	public void setHeadOfAccount(String headOfAccount) {
		this.headOfAccount = headOfAccount;
	}

	public String getParticulars() {
		return particulars;
	}

	public void setParticulars(String particulars) {
		this.particulars = particulars;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getCgstPercent() {
		return cgstPercent;
	}

	public void setCgstPercent(Double cgstPercent) {
		this.cgstPercent = cgstPercent;
	}

	public Double getSgstPercent() {
		return sgstPercent;
	}

	public void setSgstPercent(Double sgstPercent) {
		this.sgstPercent = sgstPercent;
	}

	public Double getIgstPercent() {
		return igstPercent;
	}

	public void setIgstPercent(Double igstPercent) {
		this.igstPercent = igstPercent;
	}

	public Double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
	}

	public Double getTdsPercent() {
		return tdsPercent;
	}

	public void setTdsPercent(Double tdsPercent) {
		this.tdsPercent = tdsPercent;
	}

	public Double getNetPayable() {
		return netPayable;
	}

	public void setNetPayable(Double netPayable) {
		this.netPayable = netPayable;
	}

	public Date getVoucherDate() {
		return voucherDate;
	}

	public void setVoucherDate(Date voucherDate) {
		this.voucherDate = voucherDate;
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


	@Override
	public String toString() {
		return "Voucher [id=" + id + ", companyId=" + companyId + ", voucherId=" + voucherId + ", vendorId=" + vendorId
				+ ", headOfAccount=" + headOfAccount + ", particulars=" + particulars + ", totalAmount=" + totalAmount
				+ ", cgstPercent=" + cgstPercent + ", sgstPercent=" + sgstPercent + ", igstPercent=" + igstPercent
				+ ", netAmount=" + netAmount + ", tdsPercent=" + tdsPercent + ", netPayable=" + netPayable
				+ ", voucherDate=" + voucherDate + ", createdBy=" + createdBy + ", createdDate=" + createdDate + "]";
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}



	
	

}
