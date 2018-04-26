package io.seyon.invoice.entity;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Invoice {

	private Long id;
	private Long companyId;
	private Long clientId;
	private Date invoiceDate;
	private Double totalAmount;
	@Enumerated(EnumType.STRING)
	private InvoiceStatus status=InvoiceStatus.NEW; //
	private String createdBy;
	private Date createdDate;
}
