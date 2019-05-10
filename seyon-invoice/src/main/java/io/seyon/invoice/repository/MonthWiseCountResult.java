package io.seyon.invoice.repository;

import java.util.Arrays;

public class MonthWiseCountResult {
	
	Integer[] data = new Integer[12]; 
	
	String label ;

	public Integer[] getData() {
		return data;
	}

	public void setData(Integer[] data) {
		this.data = data;
	}



	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public MonthWiseCountResult(Integer[] data, String label) {
		this.data = data;
		this.label = label;
	}
	
	
	@Override
	public String toString() {
		return "MonthWiseCountResult [data=" + Arrays.toString(data) + ", label=" + label + "]";
	}
	
	
	

}
