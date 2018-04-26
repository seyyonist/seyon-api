package io.seyon.invoice.entity;

public class Particulars {

	private Long id;
	private Long invoiceId;
	private String item;
	private String itemTaxCategory;
	private Integer quantity;
	private Integer cgstPercent;
	private Integer sgstPercent;
	private Integer igstPercent;
	private Double calculatedAmount;
	
}
