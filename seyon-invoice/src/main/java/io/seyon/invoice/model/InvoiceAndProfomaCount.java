package io.seyon.invoice.model;

import java.util.TreeMap;

public class InvoiceAndProfomaCount {
	
	TreeMap<Integer, Integer> invoiceCountMapMonthWise;
	
	TreeMap<Integer, Integer> profomaCountMapMonthWise;

	public TreeMap<Integer, Integer> getInvoiceCountMapMonthWise() {
		return invoiceCountMapMonthWise;
	}

	public void setInvoiceCountMapMonthWise(TreeMap<Integer, Integer> invoiceCountMapMonthWise) {
		this.invoiceCountMapMonthWise = invoiceCountMapMonthWise;
	}

	public TreeMap<Integer, Integer> getProfomaCountMapMonthWise() {
		return profomaCountMapMonthWise;
	}

	public void setProfomaCountMapMonthWise(TreeMap<Integer, Integer> profomaCountMapMonthWise) {
		this.profomaCountMapMonthWise = profomaCountMapMonthWise;
	}
	
	
	
}
