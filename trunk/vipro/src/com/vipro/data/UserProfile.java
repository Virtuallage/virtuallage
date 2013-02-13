package com.vipro.data;

// Generated Feb 3, 2013 6:50:08 PM by Hibernate Tools 3.4.0.CR1

/**
 * UserProfile generated by hbm2java
 */
public class UserProfile implements java.io.Serializable {

	private Long userId;
	private Institution institution;
	private UserGroup userGroup;
	private String username;
	private String password;
	private String name;
	private String address;
	private String staffNo;
	private String department;
	private String email;
	private String mobileNo;
	private String officeNo;
	private Integer invalidPasswordCount;
	private Character specialHandling;
	private String status;

	public UserProfile() {
	}

	public UserProfile(Institution institution, UserGroup userGroup) {
		this.institution = institution;
		this.userGroup = userGroup;
	}

	public UserProfile(Institution institution, UserGroup userGroup,
			String username, String password, String name, String address,
			String staffNo, String email, String mobileNo, String officeNo,
			Integer invalidPasswordCount, Character specialHandling,
			String status) {
		this.institution = institution;
		this.userGroup = userGroup;
		this.username = username;
		this.password = password;
		this.name = name;
		this.address = address;
		this.staffNo = staffNo;
		this.email = email;
		this.mobileNo = mobileNo;
		this.officeNo = officeNo;
		this.invalidPasswordCount = invalidPasswordCount;
		this.specialHandling = specialHandling;
		this.status = status;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public UserGroup getUserGroup() {
		return this.userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStaffNo() {
		return this.staffNo;
	}

	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getOfficeNo() {
		return this.officeNo;
	}

	public void setOfficeNo(String officeNo) {
		this.officeNo = officeNo;
	}

	public Integer getInvalidPasswordCount() {
		return this.invalidPasswordCount;
	}

	public void setInvalidPasswordCount(Integer invalidPasswordCount) {
		this.invalidPasswordCount = invalidPasswordCount;
	}

	public Character getSpecialHandling() {
		return this.specialHandling;
	}

	public void setSpecialHandling(Character specialHandling) {
		this.specialHandling = specialHandling;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}