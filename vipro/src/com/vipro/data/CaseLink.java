package com.vipro.data;

public class CaseLink implements java.io.Serializable {

	private Long caseId;
	private String caseType;
	private String caseLink;
	private String caseStatus;
	
	public CaseLink() {

	}
	
	public CaseLink(Long caseId, String caseType, String caseLink, String caseStatus) {
		this.caseId = caseId;
		this.caseType = caseType;
		this.caseLink = caseLink;
		this.caseStatus = caseStatus;
	}
	
	public Long getCaseId() {
		return this.caseId;
	}

	public void setCaseId(Long caseId) {
		this.caseId = caseId;
	}
	
	public String getCaseType() {
		return this.caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}
	
	public String getCaseLink() {
		return this.caseLink;
	}

	public void setCaseLink(String caseLink) {
		this.caseLink = caseLink;
	}

	public String getCaseStatus() {
		return caseStatus;
	}

	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}
}
