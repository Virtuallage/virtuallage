package com.vipro.data;

// Generated Feb 3, 2013 6:50:08 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * DocumentReference generated by hbm2java
 */
public class DocumentReference implements java.io.Serializable {

	private Long id;
	private String docType;
	private byte[] fileContent;
	private Date createdOn;
	private String createdBy;

	public DocumentReference() {
	}

	public DocumentReference(String docType, byte[] fileContent,
			Date createdOn, String createdBy) {
		this.docType = docType;
		this.fileContent = fileContent;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocType() {
		return this.docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public byte[] getFileContent() {
		return this.fileContent;
	}

	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}