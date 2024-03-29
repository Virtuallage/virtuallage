package com.vipro.data;

// Generated Feb 3, 2013 6:50:08 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * ProjectInventory generated by hbm2java
 */
public class AdjHeader implements java.io.Serializable {

	private Long adjHeaderId;
	private Project project;
	private String adjType;
	private BigDecimal adjAmount;
	private BigDecimal adjPercent;
	private Long totalUnitAdj; 
	private BigDecimal totalBefAdj;
	private BigDecimal totalAftAdj;
	private Long submittedBy; 
	private Date dateSubmitted;
	private Long approvedBy;
	private Date dateApproved;
    private String status;

	public AdjHeader() {
	}

	public AdjHeader(Project project) {
		this.project = project;
	}

	public AdjHeader(Long adjHeaderId, Project project, String adjType, BigDecimal adjAmount, BigDecimal adjPercent,
			Long totalUnitAdj, BigDecimal totalBefAdj, BigDecimal totalAftAdj) {
		this.adjHeaderId = adjHeaderId;
		this.project = project;
		this.adjType = adjType;
		this.adjAmount = adjAmount;
		this.adjPercent = adjPercent;
		this.totalUnitAdj = totalUnitAdj; 
		this.totalBefAdj = totalBefAdj;
		this.totalAftAdj = totalAftAdj;
	}
	
	public Long getAdjHeaderId() {
		return adjHeaderId;
	}

	public void setAdjHeaderId(Long adjHeaderId) {
		this.adjHeaderId = adjHeaderId;
	}
	
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	public String getAdjType() {
		return this.adjType;
	}

	public void setAdjType(String adjType) {
		this.adjType = adjType;
	}
	
	public BigDecimal getAdjAmount() {
		return this.adjAmount;
	}

	public void setAdjAmount(BigDecimal adjAmount) {
		this.adjAmount = adjAmount;
	}
	
	public BigDecimal getAdjPercent() {
		return this.adjPercent;
	}

	public void setAdjPercent(BigDecimal adjPercent) {
		this.adjPercent = adjPercent;
	}
	
	public Long getTotalUnitAdj() {
		return totalUnitAdj;
	}

	public void setTotalUnitAdj(Long totalUnitAdj) {
		this.totalUnitAdj = totalUnitAdj;
	}
	
	public BigDecimal getTotalBefAdj() {
		return this.totalBefAdj;
	}

	public void setTotalBefAdj(BigDecimal totalBefAdj) {
		this.totalBefAdj = totalBefAdj;
	}
	
	public BigDecimal getTotalAftAdj() {
		return this.totalAftAdj;
	}

	public void setTotalAftAdj(BigDecimal totalAftAdj) {
		this.totalAftAdj = totalAftAdj;
	}

	public Long getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(Long submittedBy) {
		this.submittedBy = submittedBy;
	}

	public Date getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public Long getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(Long approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Date getDateApproved() {
		return dateApproved;
	}

	public void setDateApproved(Date dateApproved) {
		this.dateApproved = dateApproved;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
		
}
