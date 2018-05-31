package io.seyon.invoice.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Invoice implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2295915883765052507L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String invoiceId;
	
	//PI-number/facialyear
	@Column(unique=true,nullable=false)
	private String performaId;
	
	@Column
	private Long companyId;
	@Column
	private Long clientId;
	
	@Column 
	private String sacCode;
	
	@Column
	private Date invoiceDate;
	
	@Column
	private Date performaDate=new Date();
	
	@Column
	private Integer cgstPerfomaPercent;
	@Column
	private Integer sgstPerfomaPercent;
	@Column
	private Integer igstPerfomaPercent;
	@Column
	private Integer cgstInvoicePercent;
	@Column
	private Integer sgstInvoicePercent;
	@Column
	private Integer igstInvoicePercent;
	@Column
	private Double totalPerfomaAmount;
	@Column
	private Double totalInvoiceAmount;
	@Enumerated(EnumType.STRING)
	@Column
	private InvoiceStatus status = InvoiceStatus.NEW;
	@Column
	private String createdBy;
	@Column
	private Date createdDate = new Date();
	@Enumerated(EnumType.STRING)
	@Column
	private InvoiceType type = InvoiceType.PERFORMA;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}
	public String getPerformaId() {
		return performaId;
	}
	public void setPerformaId(String performaId) {
		this.performaId = performaId;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public String getSacCode() {
		return sacCode;
	}
	public void setSacCode(String sacCode) {
		this.sacCode = sacCode;
	}
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public Date getPerformaDate() {
		return performaDate;
	}
	public void setPerformaDate(Date performaDate) {
		this.performaDate = performaDate;
	}
	public Integer getCgstPerfomaPercent() {
		return cgstPerfomaPercent;
	}
	public void setCgstPerfomaPercent(Integer cgstPerfomaPercent) {
		this.cgstPerfomaPercent = cgstPerfomaPercent;
	}
	public Integer getSgstPerfomaPercent() {
		return sgstPerfomaPercent;
	}
	public void setSgstPerfomaPercent(Integer sgstPerfomaPercent) {
		this.sgstPerfomaPercent = sgstPerfomaPercent;
	}
	public Integer getIgstPerfomaPercent() {
		return igstPerfomaPercent;
	}
	public void setIgstPerfomaPercent(Integer igstPerfomaPercent) {
		this.igstPerfomaPercent = igstPerfomaPercent;
	}
	public Integer getCgstInvoicePercent() {
		return cgstInvoicePercent;
	}
	public void setCgstInvoicePercent(Integer cgstInvoicePercent) {
		this.cgstInvoicePercent = cgstInvoicePercent;
	}
	public Integer getSgstInvoicePercent() {
		return sgstInvoicePercent;
	}
	public void setSgstInvoicePercent(Integer sgstInvoicePercent) {
		this.sgstInvoicePercent = sgstInvoicePercent;
	}
	public Integer getIgstInvoicePercent() {
		return igstInvoicePercent;
	}
	public void setIgstInvoicePercent(Integer igstInvoicePercent) {
		this.igstInvoicePercent = igstInvoicePercent;
	}
	public Double getTotalPerfomaAmount() {
		return totalPerfomaAmount;
	}
	public void setTotalPerfomaAmount(Double totalPerfomaAmount) {
		this.totalPerfomaAmount = totalPerfomaAmount;
	}
	public Double getTotalInvoiceAmount() {
		return totalInvoiceAmount;
	}
	public void setTotalInvoiceAmount(Double totalInvoiceAmount) {
		this.totalInvoiceAmount = totalInvoiceAmount;
	}
	public InvoiceStatus getStatus() {
		return status;
	}
	public void setStatus(InvoiceStatus status) {
		this.status = status;
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
	public InvoiceType getType() {
		return type;
	}
	public void setType(InvoiceType type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Invoice [id=" + id + ", invoiceId=" + invoiceId + ", performaId=" + performaId + ", companyId="
				+ companyId + ", clientId=" + clientId + ", sacCode=" + sacCode + ", invoiceDate=" + invoiceDate
				+ ", performaDate=" + performaDate + ", cgstPerfomaPercent=" + cgstPerfomaPercent
				+ ", sgstPerfomaPercent=" + sgstPerfomaPercent + ", igstPerfomaPercent=" + igstPerfomaPercent
				+ ", cgstInvoicePercent=" + cgstInvoicePercent + ", sgstInvoicePercent=" + sgstInvoicePercent
				+ ", igstInvoicePercent=" + igstInvoicePercent + ", totalPerfomaAmount=" + totalPerfomaAmount
				+ ", totalInvoiceAmount=" + totalInvoiceAmount + ", status=" + status + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", type=" + type + "]";
	}
	
	
	
}
