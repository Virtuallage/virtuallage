package com.vipro.data;

// Generated Feb 3, 2013 6:50:08 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Transient;

/**
 * Customer generated by hbm2java
 */
public class Customer implements java.io.Serializable {

	private Long customerId;
	private Institution institution;
	private String customerCategory;
	private String identityType;
	private String identityNo;
	private String title;
	private String fullName;
	private String contactPerson;
	private String specialHandling;
	private Long businessPartner;
	private String race;
	private String bumiIndicator;
	private String sex;
	private String maritalStatus;
	private String employerName;
	private String incomeGroup;
	private String houseTelNo;
	private String officeTelNo;
	private String faxNo;
	private String communicationType;
	private String language;
	private Date dateOfBirth;
	private String ageGroup;
	private String marketingCode;
	private String pdpaDisclaimer;
	private Long createdBy;
	private Date dateCreated;
	private String customerStatus;
	private Set addresses = new HashSet(0);
	private Set accounts = new HashSet(0);
	private Set joinAccounts = new HashSet(0);
	private Set contacts = new HashSet(0);
	private Set vouchers = new HashSet(0);

	private Long addressId;

	private String email;
	private String mobileNo;
	private String remarks;
	private String citizenship;

	public Customer() {
	}

	public Customer(Institution institution) {
		this.institution = institution;
	}

	public Customer(Institution institution, String customerCategory,
			String identityType, String identityNo, String title,
			String fullName, String specialHandling, String race,
			String bumiIndicator, String sex, String maritalStatus,
			String employerName, String houseTelNo, String officeTelNo,
			String faxNo, String communicationType, String language,
			Date dateOfBirth, Long createdBy, Date dateCreated,
			Set addresses, Set accounts, Set joinAccounts, Set contacts,
			Set vouchers) {
		this.institution = institution;
		this.customerCategory = customerCategory;
		this.identityType = identityType;
		this.identityNo = identityNo;
		this.title = title;
		this.fullName = fullName;
		this.specialHandling = specialHandling;
		this.race = race;
		this.bumiIndicator = bumiIndicator;
		this.sex = sex;
		this.maritalStatus = maritalStatus;
		this.employerName = employerName;
		this.houseTelNo = houseTelNo;
		this.officeTelNo = officeTelNo;
		this.faxNo = faxNo;
		this.communicationType = communicationType;
		this.language = language;
		this.dateOfBirth = dateOfBirth;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.addresses = addresses;
		this.accounts = accounts;

		this.joinAccounts = joinAccounts;

		this.contacts = contacts;
		this.vouchers = vouchers;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Long getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public String getCustomerCategory() {
		return this.customerCategory;
	}

	public void setCustomerCategory(String customerCategory) {
		this.customerCategory = customerCategory;
	}

	public String getIdentityType() {
		return this.identityType;
	}

	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}

	public String getIdentityNo() {
		return this.identityNo;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getSpecialHandling() {
		return this.specialHandling;
	}

	public void setSpecialHandling(String specialHandling) {
		this.specialHandling = specialHandling;
	}

	public String getRace() {
		return this.race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getBumiIndicator() {
		return this.bumiIndicator;
	}

	public void setBumiIndicator(String bumiIndicator) {
		this.bumiIndicator = bumiIndicator;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMaritalStatus() {
		return this.maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getEmployerName() {
		return this.employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getHouseTelNo() {
		return this.houseTelNo;
	}

	public void setHouseTelNo(String houseTelNo) {
		this.houseTelNo = houseTelNo;
	}

	public String getOfficeTelNo() {
		return this.officeTelNo;
	}

	public void setOfficeTelNo(String officeTelNo) {
		this.officeTelNo = officeTelNo;
	}

	public String getFaxNo() {
		return this.faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	public String getCommunicationType() {
		return this.communicationType;
	}

	public void setCommunicationType(String communicationType) {
		this.communicationType = communicationType;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Set getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set addresses) {
		this.addresses = addresses;
	}

	public Set getAccounts() {
		return this.accounts;
	}

	public void setAccounts(Set accounts) {
		this.accounts = accounts;
	}

	public Set getJoinAccounts() {
		return this.joinAccounts;
	}

	public void setJoinAccounts(Set joinAccounts) {
		this.joinAccounts = joinAccounts;
	}

	public Set getContacts() {
		return this.contacts;
	}

	public void setContacts(Set contacts) {
		this.contacts = contacts;
	}

	public Set getVouchers() {
		return this.vouchers;
	}

	public void setVouchers(Set vouchers) {
		this.vouchers = vouchers;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public Long getBusinessPartner() {
		return businessPartner;
	}

	public void setBusinessPartner(Long businessPartner) {
		this.businessPartner = businessPartner;
	}

	@Override
	public String toString() {
		return "Customer ["
				+ (customerId != null ? "customerId=" + customerId + ", " : "")
				+ (customerCategory != null ? "customerCategory="
						+ customerCategory + ", " : "")
				+ (identityType != null ? "identityType=" + identityType + ", "
						: "")
				+ (identityNo != null ? "identityNo=" + identityNo + ", " : "")
				+ (title != null ? "title=" + title + ", " : "")
				+ (fullName != null ? "fullName=" + fullName + ", " : "")
				+ (contactPerson != null ? "contactPerson=" + contactPerson
						+ ", " : "")
				+ (specialHandling != null ? "specialHandling="
						+ specialHandling + ", " : "")
				+ (businessPartner != null ? "businessPartner="
						+ businessPartner + ", " : "")
				+ (race != null ? "race=" + race + ", " : "")
				+ (bumiIndicator != null ? "bumiIndicator=" + bumiIndicator
						+ ", " : "")
				+ (sex != null ? "sex=" + sex + ", " : "")
				+ (maritalStatus != null ? "maritalStatus=" + maritalStatus
						+ ", " : "")
				+ (employerName != null ? "employerName=" + employerName + ", "
						: "")
				+ (houseTelNo != null ? "houseTelNo=" + houseTelNo + ", " : "")
				+ (officeTelNo != null ? "officeTelNo=" + officeTelNo + ", "
						: "")
				+ (faxNo != null ? "faxNo=" + faxNo + ", " : "")
				+ (communicationType != null ? "communicationType="
						+ communicationType + ", " : "")
				+ (language != null ? "language=" + language + ", " : "")
				+ (dateOfBirth != null ? "dateOfBirth=" + dateOfBirth + ", "
						: "")
				+ (createdBy != null ? "createdBy=" + createdBy + ", " : "")
				+ (dateCreated != null ? "dateCreated=" + dateCreated + ", "
						: "")
				+ (addressId != null ? "addressId=" + addressId + ", " : "")
				+ (email != null ? "email=" + email + ", " : "")
				+ (mobileNo != null ? "mobileNo=" + mobileNo + ", " : "")
				+ (remarks != null ? "remarks=" + remarks + ", " : "")
				+ (citizenship != null ? "citizenship=" + citizenship : "")
				+ "]";
	}

	public String getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
	}

	public String getIncomeGroup() {
		return incomeGroup;
	}

	public void setIncomeGroup(String incomeGroup) {
		this.incomeGroup = incomeGroup;
	}

	public String getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(String ageGroup) {
		this.ageGroup = ageGroup;
	}

	public String getMarketingCode() {
		return marketingCode;
	}

	public void setMarketingCode(String marketingCode) {
		this.marketingCode = marketingCode;
	}

	public String getPdpaDisclaimer() {
		return pdpaDisclaimer;
	}

	public void setPdpaDisclaimer(String pdpaDisclaimer) {
		this.pdpaDisclaimer = pdpaDisclaimer;
	}
	
	
	
}
