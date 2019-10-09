package io.seyon.invoice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SequenceGenerator {

	@Id
	Long Id=1L;
	
	@Column
	Long serviceInvoiceId;
	
	@Column
	Long ManuInvoiceid;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getServiceInvoiceId() {
		return serviceInvoiceId;
	}

	public void setServiceInvoiceId(Long serviceInvoiceId) {
		this.serviceInvoiceId = serviceInvoiceId;
	}

	public Long getManuInvoiceid() {
		return ManuInvoiceid;
	}

	public void setManuInvoiceid(Long manuInvoiceid) {
		ManuInvoiceid = manuInvoiceid;
	}

	@Override
	public String toString() {
		return "SequenceGenerator [Id=" + Id + ", serviceInvoiceId=" + serviceInvoiceId + ", ManuInvoiceid="
				+ ManuInvoiceid + "]";
	}

	
	
}
