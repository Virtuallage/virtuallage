package com.vipro.data;

import java.util.Date;


public class BillingModelHeader implements java.io.Serializable {

	private Long headerId;
	private String billingModelCode;
	private String description;
	private Long changedBy;
	private Date dateChanged;
	private String status;

	public BillingModelHeader(){
		
	}
	
	public BillingModelHeader(String billingModelCode, String description, 
			Long changedBy, Date dateChanged, String status) {
		this.setBillingModelCode(billingModelCode);
		this.setDescription(description);
		this.setChangedBy(changedBy);
		this.setDateChanged(dateChanged);
		this.setStatus(status);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getHeaderId() {
		return headerId;
	}

	public void setHeaderId(Long headerId) {
		this.headerId = headerId;
	}

	public Date getDateChanged() {
		return dateChanged;
	}

	public void setDateChanged(Date dateChanged) {
		this.dateChanged = dateChanged;
	}

	public String getBillingModelCode() {
		return billingModelCode;
	}

	public void setBillingModelCode(String billingModelCode) {
		this.billingModelCode = billingModelCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(Long changedBy) {
		this.changedBy = changedBy;
	}

}
