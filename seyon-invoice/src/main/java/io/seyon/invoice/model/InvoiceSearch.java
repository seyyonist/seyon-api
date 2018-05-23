package io.seyon.invoice.model;

import java.util.Date;

import io.seyon.invoice.entity.InvoiceStatus;

public class InvoiceSearch {

	private Long id;
	private Long clientId;
	private Date invoiceStDate;
	private Date invoiceEdDate;
	private InvoiceStatus status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public Date getInvoiceStDate() {
		return invoiceStDate;
	}
	public void setInvoiceStDate(Date invoiceStDate) {
		this.invoiceStDate = invoiceStDate;
	}
	public Date getInvoiceEdDate() {
		return invoiceEdDate;
	}
	public void setInvoiceEdDate(Date invoiceEdDate) {
		this.invoiceEdDate = invoiceEdDate;
	}
	public InvoiceStatus getStatus() {
		return status;
	}
	public void setStatus(InvoiceStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "InvoiceSearch [id=" + id + ", clientId=" + clientId + ", invoiceStDate=" + invoiceStDate
				+ ", invoiceEdDate=" + invoiceEdDate + ", status=" + status + "]";
	}
	
}
