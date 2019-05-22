package io.seyon.voucher.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

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
	private String invoiceId;
	
	@Column
	private Long vendorId;
	
	@Column
	private Long headOfAccountId;// head of account
	
	
	@Column
	private String particulars; // Field for description or Narration

	@Column
	private Double cgstAmount; // cgst Amount
	
	@Column
	private Double sgstAmount;// sgst Amount
	
	@Column
	private Double igstAmount;// igst Amount
	
	@Column
	private Double netAmount;// Net Amount
	
	@Column
	private Double tdsPercent; // TDS Percent
	
	@Column
	private Double tdsAmount; // TDS Amount
	
	@Column
	private Double others; // Other Amount
	
	@Column
	private Double reimbursement; // Reimbursement
	
	@Column
	private Double totalNetAmount; // Total Net Amount
	
	@Column
	private Double totalAmount; // Total Amount
	
	@Column
	private String deductionRemark; //Deductions remarks
	
	@Column
	private Date voucherDate;
	
	@Column
	private Date invoiceDate;

	@Column
	private String createdBy;

	@Column
	private Date createdDate;
	
	@Column
	private String updatedBy;

	@Column
	private Date updatedDate;
	
	@Lob
	String voucherImg;

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

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	

	public Long getHeadOfAccountId() {
		return headOfAccountId;
	}

	public void setHeadOfAccountId(Long headOfAccountId) {
		this.headOfAccountId = headOfAccountId;
	}

	public String getParticulars() {
		return particulars;
	}

	public void setParticulars(String particulars) {
		this.particulars = particulars;
	}

	public Double getCgstAmount() {
		return cgstAmount;
	}

	public void setCgstAmount(Double cgstAmount) {
		this.cgstAmount = cgstAmount;
	}

	public Double getSgstAmount() {
		return sgstAmount;
	}

	public void setSgstAmount(Double sgstAmount) {
		this.sgstAmount = sgstAmount;
	}

	public Double getIgstAmount() {
		return igstAmount;
	}

	public void setIgstAmount(Double igstAmount) {
		this.igstAmount = igstAmount;
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

	public Double getTdsAmount() {
		return tdsAmount;
	}

	public void setTdsAmount(Double tdsAmount) {
		this.tdsAmount = tdsAmount;
	}

	public Double getOthers() {
		return others;
	}

	public void setOthers(Double others) {
		this.others = others;
	}

	public Double getReimbursement() {
		return reimbursement;
	}

	public void setReimbursement(Double reimbursement) {
		this.reimbursement = reimbursement;
	}

	public Double getTotalNetAmount() {
		return totalNetAmount;
	}

	public void setTotalNetAmount(Double totalNetAmount) {
		this.totalNetAmount = totalNetAmount;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getDeductionRemark() {
		return deductionRemark;
	}

	public void setDeductionRemark(String deductionRemark) {
		this.deductionRemark = deductionRemark;
	}

	public Date getVoucherDate() {
		return voucherDate;
	}

	public void setVoucherDate(Date voucherDate) {
		this.voucherDate = voucherDate;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
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

	
	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	
	public String getVoucherImg() {
		return voucherImg;
	}

	public void setVoucherImg(String voucherImg) {
		this.voucherImg = voucherImg;
	}

	@Override
	public String toString() {
		return "Voucher [id=" + id + ", companyId=" + companyId + ", voucherId=" + voucherId + ", invoiceId="
				+ invoiceId + ", vendorId=" + vendorId + ", headOfAccountId=" + headOfAccountId + ", particulars="
				+ particulars + ", cgstAmount=" + cgstAmount + ", sgstAmount=" + sgstAmount + ", igstAmount="
				+ igstAmount + ", netAmount=" + netAmount + ", tdsPercent=" + tdsPercent + ", tdsAmount=" + tdsAmount
				+ ", others=" + others + ", reimbursement=" + reimbursement + ", totalNetAmount=" + totalNetAmount
				+ ", totalAmount=" + totalAmount + ", deductionRemark=" + deductionRemark + ", voucherDate="
				+ voucherDate + ", invoiceDate=" + invoiceDate + ", createdBy=" + createdBy + ", createdDate="
				+ createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + "]";
	}


	

}
