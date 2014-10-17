package com.vipro.data;

import java.math.BigDecimal;
import java.util.Date;

// Generated Oct 8, 2014 by BILL Manually For Virtuallage Sdn Bhd

public class BankAccount implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -845835411584082199L;
	private Long bankAccountId;
	private Project project;	
	private String billTo;
	private String topText;
	private String bottomText;
	private String holderName;
	private Long holderAddressId;
	private String bank1Name;
	private String bank1AccountNo;
	private String bank1SwiftCode;
	private String bank1BranchAddress;
	private String bank2Name;
	private String bank2AccountNo;
	private String bank2SwiftCode;
	private String bank2BranchAddress;
	private Long changedBy;
	private Date dateChanged;
	private String status;

	public BankAccount() {
	}

	public BankAccount(Project project) {
		this.setProject(project);
	}
	
	public BankAccount(Long bankAccountId, Project project, String billTo, 
			String topText, String bottomText, 	String holderName,
			Long holderAddressId, String bank1Name, String bank1AccountNo,
			String bank1SwiftCode, String bank1BranchAddress, String bank2Name, 
			String bank2AccountNo, String bank2SwiftCode, String bank2BranchAddress, 
			Long changedBy, Date dateChanged, String status) {
		this.setBankAccountId(bankAccountId);
		this.setProject (project);
		this.setBillTo (billTo);
		this.setTopText (topText);
		this.setBottomText (bottomText);
		this.setHolderName (holderName);
		this.setHolderAddressId (holderAddressId);
		this.setBank1Name (bank1Name);
		this.setBank1AccountNo (bank1AccountNo);
		this.setBank1SwiftCode (bank1SwiftCode);
		this.setBank1BranchAddress (bank1BranchAddress);
		this.setBank2Name (bank2Name);
		this.setBank2AccountNo (bank2AccountNo);
		this.setBank2SwiftCode (bank2SwiftCode);
		this.setBank2BranchAddress (bank2BranchAddress);
		this.setChangedBy (changedBy);
		this.setDateChanged (dateChanged);
		this.setStatus (status);
	}	

	public Long getBankAccountId() {
		return bankAccountId;
	}

	public void setBankAccountId(Long bankAccountId) {
		this.bankAccountId = bankAccountId;
	}

	public String getBillTo() {
		return billTo;
	}

	public void setBillTo(String billTo) {
		this.billTo = billTo;
	}

	public String getTopText() {
		return topText;
	}

	public void setTopText(String topText) {
		this.topText = topText;
	}

	public String getBottomText() {
		return bottomText;
	}

	public void setBottomText(String bottomText) {
		this.bottomText = bottomText;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public Long getHolderAddressId() {
		return holderAddressId;
	}

	public void setHolderAddressId(Long holderAddressId) {
		this.holderAddressId = holderAddressId;
	}

	public String getBank1Name() {
		return bank1Name;
	}

	public void setBank1Name(String bank1Name) {
		this.bank1Name = bank1Name;
	}

	public String getBank1AccountNo() {
		return bank1AccountNo;
	}

	public void setBank1AccountNo(String bank1AccountNo) {
		this.bank1AccountNo = bank1AccountNo;
	}

	public String getBank1SwiftCode() {
		return bank1SwiftCode;
	}

	public void setBank1SwiftCode(String bank1SwiftCode) {
		this.bank1SwiftCode = bank1SwiftCode;
	}

	public String getBank1BranchAddress() {
		return bank1BranchAddress;
	}

	public void setBank1BranchAddress(String bank1BranchAddress) {
		this.bank1BranchAddress = bank1BranchAddress;
	}

	public String getBank2Name() {
		return bank2Name;
	}

	public void setBank2Name(String bank2Name) {
		this.bank2Name = bank2Name;
	}

	public String getBank2AccountNo() {
		return bank2AccountNo;
	}

	public void setBank2AccountNo(String bank2AccountNo) {
		this.bank2AccountNo = bank2AccountNo;
	}

	public String getBank2SwiftCode() {
		return bank2SwiftCode;
	}

	public void setBank2SwiftCode(String bank2SwiftCode) {
		this.bank2SwiftCode = bank2SwiftCode;
	}

	public String getBank2BranchAddress() {
		return bank2BranchAddress;
	}

	public void setBank2BranchAddress(String bank2BranchAddress) {
		this.bank2BranchAddress = bank2BranchAddress;
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
