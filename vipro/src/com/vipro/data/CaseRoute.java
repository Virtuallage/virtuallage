package com.vipro.data;

import java.util.Date;

import com.sun.jmx.snmp.Timestamp;

public class CaseRoute implements java.io.Serializable {

	private Long caseId;
	private String caseType;
	private String status;
	private Long projectId;
	private String groupId;
	private Long userId;
	private Integer dueDay;
	private String tGroupId;
	private Long tUserId;
	private String nextAction;
	private Long changedBy;
	private Date lastChanged;

	public CaseRoute() {

	}

	public CaseRoute(Long caseId, 
			String caseType, 
			String status, 
			Long projectId,
			String groupId,
			Long userId,
			Integer dueDay,
			String tGroupId,
			Long tUserId,
			String nextAction,
			Long changedBy,
			Date lastChanged
			) {
		this.caseId = caseId;
		this.caseType = caseType;
		this.status = status;
		this.projectId = projectId;
		this.groupId = groupId;
		this.userId = userId;
		this.dueDay = dueDay;
		this.tGroupId = tGroupId;
		this.tUserId = tUserId;
		this.nextAction = nextAction;
		this.changedBy = changedBy;
		this.lastChanged = lastChanged;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getDueDay() {
		return dueDay;
	}

	public void setDueDay(Integer dueDay) {
		this.dueDay = dueDay;
	}

	public String gettGroupId() {
		return tGroupId;
	}

	public void settGroupId(String tGroupId) {
		this.tGroupId = tGroupId;
	}

	public Long gettUserId() {
		return tUserId;
	}

	public void settUserId(Long tUserId) {
		this.tUserId = tUserId;
	}

	public String getNextAction() {
		return nextAction;
	}

	public void setNextAction(String nextAction) {
		this.nextAction = nextAction;
	}

	public Long getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(Long changedBy) {
		this.changedBy = changedBy;
	}

	public Date getLastChanged() {
		return lastChanged;
	}

	public void setLastChanged(Date lastChanged) {
		this.lastChanged = lastChanged;
	}
}
