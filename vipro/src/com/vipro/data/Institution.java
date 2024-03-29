package com.vipro.data;

// Generated Feb 3, 2013 6:50:08 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Institution generated by hbm2java
 */
public class Institution implements java.io.Serializable {

	private Long institutionId;
	private String institutionName;
	private String initial;
	private String officeTel;
	private String contactPerson;
	private String contactPersonTitle;
	private String contactPersonMobile;
	private String contactPersonEmail;
	private String currencySymbol;
	private Byte decimalPoints;
	private String status;
	private Set projects = new HashSet(0);
	private Set holidaies = new HashSet(0);
	private Set userProfiles = new HashSet(0);
	private Set customers = new HashSet(0);
	private Set businessPartners = new HashSet(0);

	public Institution() {
	}

	public Institution(String institutionName, String initial,
			String officeTel, String contactPerson, String contactPersonTitle,
			String contactPersonMobile, String contactPersonEmail,
			String currencySymbol, Byte decimalPoints, String status,
			Set projects, Set holidaies, Set userProfiles, Set customers,
			Set businessPartners) {
		this.institutionName = institutionName;
		this.initial = initial;
		this.officeTel = officeTel;
		this.contactPerson = contactPerson;
		this.contactPersonTitle = contactPersonTitle;
		this.contactPersonMobile = contactPersonMobile;
		this.contactPersonEmail = contactPersonEmail;
		this.currencySymbol = currencySymbol;
		this.decimalPoints = decimalPoints;
		this.status = status;
		this.projects = projects;
		this.holidaies = holidaies;
		this.userProfiles = userProfiles;
		this.customers = customers;
		this.businessPartners = businessPartners;
	}

//	public Institution(Long institutionId) {
//		this.institutionId = institutionId;
//	}

	public Long getInstitutionId() {
		return this.institutionId;
	}

	public void setInstitutionId(Long institutionId) {
		this.institutionId = institutionId;
	}

	public String getInstitutionName() {
		return this.institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getInitial() {
		return this.initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}

	public String getOfficeTel() {
		return this.officeTel;
	}

	public void setOfficeTel(String officeTel) {
		this.officeTel = officeTel;
	}

	public String getContactPerson() {
		return this.contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactPersonTitle() {
		return this.contactPersonTitle;
	}

	public void setContactPersonTitle(String contactPersonTitle) {
		this.contactPersonTitle = contactPersonTitle;
	}

	public String getContactPersonMobile() {
		return this.contactPersonMobile;
	}

	public void setContactPersonMobile(String contactPersonMobile) {
		this.contactPersonMobile = contactPersonMobile;
	}

	public String getContactPersonEmail() {
		return this.contactPersonEmail;
	}

	public void setContactPersonEmail(String contactPersonEmail) {
		this.contactPersonEmail = contactPersonEmail;
	}

	public String getCurrencySymbol() {
		return this.currencySymbol;
	}

	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}

	public Byte getDecimalPoints() {
		return this.decimalPoints;
	}

	public void setDecimalPoints(Byte decimalPoints) {
		this.decimalPoints = decimalPoints;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set getProjects() {
		return this.projects;
	}

	public void setProjects(Set projects) {
		this.projects = projects;
	}

	public Set getHolidaies() {
		return this.holidaies;
	}

	public void setHolidaies(Set holidaies) {
		this.holidaies = holidaies;
	}

	public Set getUserProfiles() {
		return this.userProfiles;
	}

	public void setUserProfiles(Set userProfiles) {
		this.userProfiles = userProfiles;
	}

	public Set getCustomers() {
		return this.customers;
	}

	public void setCustomers(Set customers) {
		this.customers = customers;
	}

	public Set getBusinessPartners() {
		return this.businessPartners;
	}

	public void setBusinessPartners(Set businessPartners) {
		this.businessPartners = businessPartners;
	}

}
