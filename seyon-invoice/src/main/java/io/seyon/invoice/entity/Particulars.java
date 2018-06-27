package io.seyon.invoice.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Particulars implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4832964801051024812L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private Long invoiceTableId;
	@Column(name="particular_index")
	private String index;
	@Column
	private String itemDescription;
	@Column
	private Integer quantity;
	@Column
	private String performaRate;
	@Column
	private String invoiceRate;
	@Column
	private Double calculatedInvoiceAmount;
	@Column
	private Double calculatedPerformaAmount;
	@Column
	private Long companyId;
	@Column
	private String createdBy;
	@Column
	private Date createdDate = new Date();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getInvoiceTableId() {
		return invoiceTableId;
	}
	public void setInvoiceTableId(Long invoiceTableId) {
		this.invoiceTableId = invoiceTableId;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getCalculatedInvoiceAmount() {
		return calculatedInvoiceAmount;
	}
	public void setCalculatedInvoiceAmount(Double calculatedInvoiceAmount) {
		this.calculatedInvoiceAmount = calculatedInvoiceAmount;
	}
	public Double getCalculatedPerformaAmount() {
		return calculatedPerformaAmount;
	}
	public void setCalculatedPerformaAmount(Double calculatedPerformaAmount) {
		this.calculatedPerformaAmount = calculatedPerformaAmount;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
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
		return "Particulars [id=" + id + ", invoiceTableId=" + invoiceTableId + ", index=" + index
				+ ", itemDescription=" + itemDescription + ", quantity=" + quantity + ", performaRate=" + performaRate
				+ ", invoiceRate=" + invoiceRate + ", calculatedInvoiceAmount=" + calculatedInvoiceAmount
				+ ", calculatedPerformaAmount=" + calculatedPerformaAmount + ", companyId=" + companyId + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + "]";
	}
	public String getInvoiceRate() {
		return invoiceRate;
	}
	public void setInvoiceRate(String invoiceRate) {
		this.invoiceRate = invoiceRate;
	}
	public String getPerformaRate() {
		return performaRate;
	}
	public void setPerformaRate(String performaRate) {
		this.performaRate = performaRate;
	}

	
}
