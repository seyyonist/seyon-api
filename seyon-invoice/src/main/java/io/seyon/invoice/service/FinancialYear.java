package io.seyon.invoice.service;

import java.time.LocalDate;

public class FinancialYear {

  
	public static String getFinancialYearOf() {
		LocalDate cutOffMonth=LocalDate.now().withMonth(3);
		LocalDate currentDate=LocalDate.now();
		int endYear=currentDate.getYear();
		if(currentDate.isAfter(cutOffMonth)) {
			endYear++;
		}
		
		return (endYear-1)+"-"+endYear;
	}
	
}
