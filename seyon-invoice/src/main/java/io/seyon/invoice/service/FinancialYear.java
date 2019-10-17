package io.seyon.invoice.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
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
	
	public String getTodayInYearMonthDay() {
		LocalDate date=LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedString = date.format(formatter);
		return formattedString;
	}
	
}
