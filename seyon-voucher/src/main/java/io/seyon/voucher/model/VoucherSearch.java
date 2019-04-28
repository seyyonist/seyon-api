package io.seyon.voucher.model;

import java.util.Date;

public class VoucherSearch {
	
	private String voucherId;
	
	private Long vendorId;

	private Date startDate;

	private Date endDate;

	public String getVoucherId() {
		return voucherId;
	}

	public void setVoucherId(String voucherId) {
		this.voucherId = voucherId;
	}

	

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "VoucherSearch [voucherId=" + voucherId + ", vendorId=" + vendorId + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}
	
	

}
