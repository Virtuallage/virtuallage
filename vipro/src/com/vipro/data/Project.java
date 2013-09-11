package com.vipro.data;

// Generated Feb 3, 2013 6:50:08 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.vipro.service.BusinessPartnerService;
import com.vipro.utils.spring.SpringBeanUtil;

/**
 * Project generated by hbm2java
 */
public class Project implements java.io.Serializable {

	private Long projectId;
	private Account account;
	private Institution institution;
	private Long developerId;
	private Long landProprietorId;
	private String developerName;
	private String landProprietorName;
	private String projectName;
	private String projectCode;
	private String propertyType;
	private String reportGroup;
	private String address1;
	private String address2;
	private String address3;
	private String address4;
	private String postcode;
	private String city;
	private String state;
	private String country;	
	private String projectOfficeTelNo;
	private String projectOfficeFaxNo;
	private String personInCharge;
	private String picMobileNo;
	private String locationLongtitude;
	private String locationLatitude;
	private String locationCity;
	private String locationState;
	private String locationCountry;
	private BigDecimal collectionInterestRate;
	private BigDecimal staffBookingFee;
	private BigDecimal publicBookingFee;
	private BigDecimal maintenanceFeeRate;
	private BigDecimal discountRate;
	private BigDecimal salesCommission;
	private BigDecimal latePymtIntRate;
	private BigDecimal latePymtFee;
	private Date startDate;	
	private Date launchDate;
	private Date endDate;
	private BigDecimal taxPercentage;
	private String billingModelCode;
	private Long changedBy;
	private Date dateChanged;
	private String status;
	private Set<ProjectInventory> projectInventories = new HashSet(0);
	private Set<SalesCommission> salesCommissions = new HashSet(0);
	private Set<Discount> discounts = new HashSet(0);

	public Project() {
	}

	public Project(Account account, Institution institution) {
		this.account = account;
		this.institution = institution;
	}

	public Project(Account account, Institution institution,
			String projectName, String projectCode, String propertyType,
			String reportGroup, String address1, String address2,
			String address3, String address4, String projectOfficeTelNo,
			String projectOfficeFaxNo, String personInCharge,
			String picMobileNo, String locationLongtitude,
			String locationLatitude, String locationCity, String locationState,
			String locationCountry, BigDecimal collectionInterestRate,
			BigDecimal staffBookingFee, BigDecimal publicBookingFee,
			BigDecimal maintenanceFeeRate, Date launchDate,
			BigDecimal taxPercentage, Set projectInventories) {
		this.account = account;
		this.institution = institution;
		this.projectName = projectName;
		this.projectCode = projectCode;
		this.propertyType = propertyType;
		this.reportGroup = reportGroup;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.address4 = address4;
		this.projectOfficeTelNo = projectOfficeTelNo;
		this.projectOfficeFaxNo = projectOfficeFaxNo;
		this.personInCharge = personInCharge;
		this.picMobileNo = picMobileNo;
		this.locationLongtitude = locationLongtitude;
		this.locationLatitude = locationLatitude;
		this.locationCity = locationCity;
		this.locationState = locationState;
		this.locationCountry = locationCountry;
		this.collectionInterestRate = collectionInterestRate;
		this.staffBookingFee = staffBookingFee;
		this.publicBookingFee = publicBookingFee;
		this.maintenanceFeeRate = maintenanceFeeRate;
		this.launchDate = launchDate;
		this.taxPercentage = taxPercentage;
		this.projectInventories = projectInventories;
	}

	public Long getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectCode() {
		return this.projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getPropertyType() {
		return this.propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getReportGroup() {
		return this.reportGroup;
	}

	public void setReportGroup(String reportGroup) {
		this.reportGroup = reportGroup;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getAddress4() {
		return address4;
	}

	public void setAddress4(String address4) {
		this.address4 = address4;
	}

	public String getProjectOfficeTelNo() {
		return this.projectOfficeTelNo;
	}

	public void setProjectOfficeTelNo(String projectOfficeTelNo) {
		this.projectOfficeTelNo = projectOfficeTelNo;
	}

	public String getProjectOfficeFaxNo() {
		return this.projectOfficeFaxNo;
	}

	public void setProjectOfficeFaxNo(String projectOfficeFaxNo) {
		this.projectOfficeFaxNo = projectOfficeFaxNo;
	}

	public String getPersonInCharge() {
		return this.personInCharge;
	}

	public void setPersonInCharge(String personInCharge) {
		this.personInCharge = personInCharge;
	}

	public String getPicMobileNo() {
		return this.picMobileNo;
	}

	public void setPicMobileNo(String picMobileNo) {
		this.picMobileNo = picMobileNo;
	}

	public String getLocationLongtitude() {
		return this.locationLongtitude;
	}

	public void setLocationLongtitude(String locationLongtitude) {
		this.locationLongtitude = locationLongtitude;
	}

	public String getLocationLatitude() {
		return this.locationLatitude;
	}

	public void setLocationLatitude(String locationLatitude) {
		this.locationLatitude = locationLatitude;
	}

	public String getLocationCity() {
		return this.locationCity;
	}

	public void setLocationCity(String locationCity) {
		this.locationCity = locationCity;
	}

	public String getLocationState() {
		return this.locationState;
	}

	public void setLocationState(String locationState) {
		this.locationState = locationState;
	}

	public String getLocationCountry() {
		return this.locationCountry;
	}

	public void setLocationCountry(String locationCountry) {
		this.locationCountry = locationCountry;
	}

	public BigDecimal getCollectionInterestRate() {
		return this.collectionInterestRate;
	}

	public void setCollectionInterestRate(BigDecimal collectionInterestRate) {
		this.collectionInterestRate = collectionInterestRate;
	}

	public BigDecimal getStaffBookingFee() {
		return this.staffBookingFee;
	}

	public void setStaffBookingFee(BigDecimal staffBookingFee) {
		this.staffBookingFee = staffBookingFee;
	}

	public BigDecimal getPublicBookingFee() {
		return this.publicBookingFee;
	}

	public void setPublicBookingFee(BigDecimal publicBookingFee) {
		this.publicBookingFee = publicBookingFee;
	}

	public BigDecimal getMaintenanceFeeRate() {
		return this.maintenanceFeeRate;
	}

	public void setMaintenanceFeeRate(BigDecimal maintenanceFeeRate) {
		this.maintenanceFeeRate = maintenanceFeeRate;
	}

	public Date getLaunchDate() {
		return this.launchDate;
	}

	public void setLaunchDate(Date launchDate) {
		this.launchDate = launchDate;
	}

	public BigDecimal getTaxPercentage() {
		return this.taxPercentage;
	}

	public void setTaxPercentage(BigDecimal taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	public Set<ProjectInventory> getProjectInventories() {
		return projectInventories;
	}

	public void setProjectInventories(Set<ProjectInventory> projectInventories) {
		this.projectInventories = projectInventories;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<SalesCommission> getSalesCommissions() {
		return salesCommissions;
	}

	public void setSalesCommissions(Set<SalesCommission> salesCommissions) {
		this.salesCommissions = salesCommissions;
	}

	public Set<Discount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(Set<Discount> discounts) {
		this.discounts = discounts;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public BigDecimal getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(BigDecimal discountRate) {
		this.discountRate = discountRate;
	}

	public BigDecimal getSalesCommission() {
		return salesCommission;
	}

	public void setSalesCommission(BigDecimal salesCommission) {
		this.salesCommission = salesCommission;
	}

	public Long getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(Long developerId) {
		this.developerId = developerId;
	}

	public Long getLandProprietorId() {
		return landProprietorId;
	}

	public void setLandProprietorId(Long landProprietorId) {
		this.landProprietorId = landProprietorId;
	}

	public String getDeveloperName() {
		BusinessPartnerService businessPartnerService = (BusinessPartnerService) SpringBeanUtil
				.lookup(BusinessPartnerService.class.getName());
		setDeveloperName(businessPartnerService.findById(developerId)
				.getCompanyName());
		return developerName;
	}

	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}

	public String getLandProprietorName() {
		BusinessPartnerService businessPartnerService = (BusinessPartnerService) SpringBeanUtil
				.lookup(BusinessPartnerService.class.getName());
		setLandProprietorName(businessPartnerService.findById(landProprietorId)
				.getCompanyName());
		return landProprietorName;
	}

	
	public Long getBussinessPartnerId() {
		BusinessPartnerService businessPartnerService = (BusinessPartnerService) SpringBeanUtil
				.lookup(BusinessPartnerService.class.getName());
		 return businessPartnerService.findById(landProprietorId).getPartnerId();
	}
	
	
	public void setLandProprietorName(String landProprietorName) {
		this.landProprietorName = landProprietorName;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public BigDecimal getLatePymtIntRate() {
		return latePymtIntRate;
	}

	public void setLatePymtIntRate(BigDecimal latePymtIntRate) {
		this.latePymtIntRate = latePymtIntRate;
	}

	public BigDecimal getLatePymtFee() {
		return latePymtFee;
	}

	public void setLatePymtFee(BigDecimal latePymtFee) {
		this.latePymtFee = latePymtFee;
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

	public String getBillingModelCode() {
		return billingModelCode;
	}

	public void setBillingModelCode(String billingModelCode) {
		this.billingModelCode = billingModelCode;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
