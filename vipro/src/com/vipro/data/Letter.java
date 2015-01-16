package com.vipro.data;

import java.util.Date;

public class Letter implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4257225080872710871L;
	private Long letterId;
	private Project project;
	private String letterCode;	
	private String jasperName;
	private Long createdBy;
	private Date dateCreated;
	private Long changedBy;
	private Date dateChanged;
	private String status;

	public Letter() {
	}

	public Letter(Project project) {
		this.project = project;
	}

	public Letter(Project project, String letterCode, String jasperName,
			Long createdBy, Date dateCreated, Long changedBy, 
			Date dateChanged, String status) {
		this.project = project;
		this.letterCode = letterCode;
		this.jasperName = jasperName;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.changedBy = changedBy;
		this.dateChanged = dateChanged;
		this.status = status;
	}

	public Long getLetterId() {
		return letterId;
	}

	public void setLetterId(Long letterId) {
		this.letterId = letterId;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getLetterCode() {
		return letterCode;
	}

	public void setLetterCode(String letterCode) {
		this.letterCode = letterCode;
	}

	public String getJasperName() {
		return jasperName;
	}

	public void setJasperName(String jasperName) {
		this.jasperName = jasperName;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Long getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(Long changedBy) {
		this.changedBy = changedBy;
	}

	public Date getDateChanged() {
		return dateChanged;
	}

	public void setDateChanged(Date dateChanged) {
		this.dateChanged = dateChanged;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
