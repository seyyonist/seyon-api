package io.seyon.invoice.model;

import java.util.List;

import io.seyon.invoice.repository.MonthWiseCountResult;

public class InvoiceAndProfomaCountResult {
	
	List<MonthWiseCountResult> monthWiseResults;

	public List<MonthWiseCountResult> getMonthWiseResults() {
		return monthWiseResults;
	}

	public void setMonthWiseResults(List<MonthWiseCountResult> monthWiseResults) {
		this.monthWiseResults = monthWiseResults;
	}

	@Override
	public String toString() {
		return "InvoiceAndProfomaCountResult [monthWiseResults=" + monthWiseResults + "]";
	}

	
	
}
