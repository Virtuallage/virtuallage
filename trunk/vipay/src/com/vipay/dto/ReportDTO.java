package com.vipay.dto;

import java.io.Serializable;

public class ReportDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4053825111460251164L;
	private Long reportFormatId;
	private Long projectId;
	private String blocksTitle = "";
	private String projectName = "";
	private String institutionName = "";
	
	public ReportDTO() {
		
	}

	public Long getReportFormatId() {
		return reportFormatId;
	}

	public void setReportFormatId(Long reportFormatId) {
		this.reportFormatId = reportFormatId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getBlocksTitle() {
		return blocksTitle;
	}

	public void setBlocksTitle(String blocksTitle) {
		this.blocksTitle = blocksTitle;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

}
