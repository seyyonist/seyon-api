package io.seyon.voucher.model;

import java.util.Date;

public class VoucherSearch {
	
	private String voucherId;
	
	private String vendorName;

	private Date startDate;

	private Date endDate;

	public String getVoucherId() {
		return voucherId;
	}

	public void setVoucherId(String voucherId) {
		this.voucherId = voucherId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
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
		return "VoucherSearch [voucherId=" + voucherId + ", vendorName=" + vendorName + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	
	

}
