package io.seyon.invoice.repository;

public class ProfomaMonthWiseResultMap {
	
	String monthName;
	
	Integer count;
	
	

	public ProfomaMonthWiseResultMap(String monthName, Integer count) {
		this.monthName = monthName;
		this.count = count;
	}

	public String getMonthName() {
		return monthName;
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	

}
