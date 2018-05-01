package io.seyon.invoice.model;

import java.util.List;

import io.seyon.invoice.entity.Invoice;
import io.seyon.invoice.entity.Particulars;

public class InvoiceData {

	private Invoice invoice;
	private List<Particulars> particulars;
	
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	public List<Particulars> getParticulars() {
		return particulars;
	}
	public void setParticulars(List<Particulars> particulars) {
		this.particulars = particulars;
	}
	
	@Override
	public String toString() {
		return "InvoiceData [invoice=" + invoice + ", particulars=" + particulars + "]";
	}
	
	
}
