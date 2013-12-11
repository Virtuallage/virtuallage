package com.vipro.data;

// Generated Feb 7, 2013 12:56:10 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**Case
 * Case generated by hbm2java
 */
public class Case implements java.io.Serializable {

	private Long caseId;
	private UserProfile sender;
	private Customer customer;
	private UserProfile creator;
	private UserProfile assignee;
	private Date creationDate;
	private String caseType;
	private String subject;
	private Long projectId;
	private String unitNo;
	private String groupId;
	private Date dueDate;
	private boolean notification;
	private String status;
	private String message;
	private Set caseActivities = new HashSet(0);

	public Case() {
	}

	public Case(UserProfile userProfileBySenderId, Customer customer,
			UserProfile creator, UserProfile assignee) {
		this.sender = sender;
		this.customer = customer;
		this.creator = creator;
		this.assignee = assignee;
	}

	public Case(UserProfile sender, Customer customer, UserProfile creator,
			UserProfile assignee, Date creationDate, String caseType,
			String subject, Long projectId, String unitNo, String groupId,
			Date dueDate, boolean notification, String status,
			Set caseActivities) {
		this.sender = sender;
		this.customer = customer;
		this.creator = creator;
		this.assignee = assignee;
		this.creationDate = creationDate;
		this.caseType = caseType;
		this.subject = subject;
		this.projectId = projectId;
		this.unitNo = unitNo;
		this.groupId = groupId;
		this.dueDate = dueDate;
		this.notification = notification;
		this.status = status;
		this.caseActivities = caseActivities;
	}

	public Long getCaseId() {
		return this.caseId;
	}

	public void setCaseId(Long caseId) {
		this.caseId = caseId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public UserProfile getSender() {
		return sender;
	}

	public void setSender(UserProfile sender) {
		this.sender = sender;
	}

	public UserProfile getCreator() {
		return creator;
	}

	public void setCreator(UserProfile creator) {
		this.creator = creator;
	}

	public UserProfile getAssignee() {
		return assignee;
	}

	public void setAssignee(UserProfile assignee) {
		this.assignee = assignee;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getCaseType() {
		return this.caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Long getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getUnitNo() {
		return this.unitNo;
	}

	public void setUnitNo(String unitNo) {
		this.unitNo = unitNo;
	}

	public String getGroupId() {
		return this.groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public boolean getNotification() {
		return this.notification;
	}

	public void setNotification(boolean notification) {
		this.notification = notification;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set getCaseActivities() {
		return this.caseActivities;
	}

	public void setCaseActivities(Set caseActivities) {
		this.caseActivities = caseActivities;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
