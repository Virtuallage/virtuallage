package com.vipro.data;

// Generated Feb 3, 2013 6:50:08 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * SalesCommission generated by hbm2java
 */
public class SalesCommission implements java.io.Serializable {

	private Long commissionId;
	private String description;
	private Date effectiveDate;
	private String type;
	private BigDecimal amountOrRate;
	private Date createdOn;
	private String status;
	private Project project;

	public SalesCommission() {
	}

	public SalesCommission(String description, Date effectiveDate, String type,
			BigDecimal amountOrRate, Date createdOn, String status) {
		this.description = description;
		this.effectiveDate = effectiveDate;
		this.type = type;
		this.amountOrRate = amountOrRate;
		this.createdOn = createdOn;
		this.status = status;
	}

	public Long getCommissionId() {
		return this.commissionId;
	}

	public void setCommissionId(Long commissionId) {
		this.commissionId = commissionId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEffectiveDate() {
		return this.effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getAmountOrRate() {
		return this.amountOrRate;
	}

	public void setAmountOrRate(BigDecimal amountOrRate) {
		this.amountOrRate = amountOrRate;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
