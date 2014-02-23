package com.vipro.data;

// Generated Feb 3, 2013 6:50:08 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Account generated by hbm2java
 */
public class Account implements java.io.Serializable {

	private Long accountId;
	private Customer customer;
	private Customer customer2;
	private Customer customer3;
	private Customer customer4;
	private Customer customer5;
	private ProjectInventory projectInventory;
	private String accountType;
	private String accountStatus;
	private BigDecimal accountBalance;
	private Long attendedBy;
	private BigDecimal registrationFee;
	private String registrationNo;
	private Date datePurchased;
	private BigDecimal purchasePrice;
	private BigDecimal discountedAmount;
	private BigDecimal commissionAmount;
	private Date commissionPaidDate;
	private BigDecimal netPrice;
	private String purchaseType;
	private Long panelBankId;
	private BigDecimal loanAmount;
	private BigDecimal latePymtIntRate;
	private BigDecimal latePymtFee;
	private BigDecimal accrualInterest;
	private BigDecimal totalPaymentTodate;
	private Long redemptionBankId;
	private BigDecimal bankRedemptionSum;
	private BigDecimal bankRedemptionTodate;
	private Date spaSignedDate;
	private Date spaStampedDate;
	private Long spaVerifiedBy;
	private Date spaVerifiedDate;
	private Long spaSolicitorId;
	private Date loSignedDate;
	private Date loVerifiedDate;
	private Long loVerifiedBy;
	private Date laSignedDate;
	private Date laStampedDate;
	private Long laVerifiedBy;
	private Date laVerifiedDate;
	private Long laSolicitorId;
	private Date adviseSignedDate;
	private Date adviseStampedDate;
	private Long adviseVerifiedBy;
	private Date adviseVerifiedDate;
	private Date maintenanceStartDate;
	private Date maintenanceEndDate;
	private BigDecimal maintenanceFee;
	private Character maintenanceBilingAddress;
	private String maintenanceFeeFreq;
	private Date fireInsuranceDueDate;
	private BigDecimal fireInsuranceAmount;
	private Long fireInsuranceCompanyId;
	private Date lastPaymentMadeDate;
	private String maintenanceBilingCycle;
	private String cancelledReason;
	private String remark;
	private Long changedBy;
	private Date dateChanged;
	private String source;
	private String salesPerson;
	private Long corrAddrCustId;
	private BigDecimal bookPymtAmount;
	private String bookPymtMethod;
	private String bookPymtCardChqNo;
	private String bookPymtBank;
	private Long borrowerId1;
	private Long borrowerId2;
	
	private BigDecimal cancelFee;
	private BigDecimal cancelTax;
	private BigDecimal cancelNetRefundAmt;
	private Set waterBillings = new HashSet(0);
	private Set projects = new HashSet(0);
	private Set addresses = new HashSet(0);
	private Set emails = new HashSet(0);
	private Set postdatedCheques = new HashSet(0);
	private Set mobilePhones = new HashSet(0);
	private Set joinAccounts = new HashSet(0);
	private Set transactionHistories = new HashSet(0);
	private Set accountAgings = new HashSet(0);
	
	private Long cancelDocId;
	private Long financierId;
	private String spaRefNo;
	private String laRefNo;
	private String campaignCode;
	private String financierRef;
	private String debtorAccount;

	public Account() {
	}

	public Account(Customer customer, ProjectInventory projectInventory) {
		this.customer = customer;
		this.projectInventory = projectInventory;
	}

	public Account(Customer customer, ProjectInventory projectInventory,
			String accountType, String accountStatus, Long attendedBy,
			BigDecimal registrationFee, String registrationNo,
			Date datePurchased, BigDecimal purchasePrice,
			BigDecimal discountedAmount, BigDecimal commissionAmount,
			Date commissionPaidDate, BigDecimal netPrice, String purchaseType,
			Long panelBankId, BigDecimal loanAmount,
			BigDecimal totalPaymentTodate, Long redemptionBankId,
			BigDecimal bankRedemptionSum, BigDecimal bankRedemptionTodate,
			Date spaSignedDate, Date spaStampedDate, Long spaVerifiedBy,
			Date spaVerifiedDate, Long spaSolicitorId, Date loSignedDate,
			Date loVerifiedDate, Long loVerifiedBy, Date laSignedDate,
			Date laStampedDate, Long laVerifiedBy, Date laVerifiedDate,
			Long laSolicitorId, Date adviseSignedDate, Date adviseStampedDate,
			Long adviseVerifiedBy, Date adviseVerifiedDate,
			Date maintenanceStartDate, Date maintenanceEndDate,
			BigDecimal maintenanceFee, Character maintenanceBilingAddress,
			String maintenanceFeeFreq, Date fireInsuranceDueDate,
			BigDecimal fireInsuranceAmount, Long fireInsuranceCompanyId,
			Date lastPaymentMadeDate, String maintenanceBilingCycle,
			String cancelledReason, String remark, String source, String salesPerson,
			Set waterBillings, Set projects,
			Set addresses, Set emails, Set postdatedCheques, Set mobilePhones,
			Set joinAccounts, Set transactionHistories, Set accountAgings) {
		this.customer = customer;
		this.projectInventory = projectInventory;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
		this.attendedBy = attendedBy;
		this.registrationFee = registrationFee;
		this.registrationNo = registrationNo;
		this.datePurchased = datePurchased;
		this.purchasePrice = purchasePrice;
		this.discountedAmount = discountedAmount;
		this.commissionAmount = commissionAmount;
		this.commissionPaidDate = commissionPaidDate;
		this.netPrice = netPrice;
		this.purchaseType = purchaseType;
		this.panelBankId = panelBankId;
		this.loanAmount = loanAmount;
		this.totalPaymentTodate = totalPaymentTodate;
		this.redemptionBankId = redemptionBankId;
		this.bankRedemptionSum = bankRedemptionSum;
		this.bankRedemptionTodate = bankRedemptionTodate;
		this.spaSignedDate = spaSignedDate;
		this.spaStampedDate = spaStampedDate;
		this.spaVerifiedBy = spaVerifiedBy;
		this.spaVerifiedDate = spaVerifiedDate;
		this.spaSolicitorId = spaSolicitorId;
		this.loSignedDate = loSignedDate;
		this.loVerifiedDate = loVerifiedDate;
		this.loVerifiedBy = loVerifiedBy;
		this.laSignedDate = laSignedDate;
		this.laStampedDate = laStampedDate;
		this.laVerifiedBy = laVerifiedBy;
		this.laVerifiedDate = laVerifiedDate;
		this.laSolicitorId = laSolicitorId;
		this.adviseSignedDate = adviseSignedDate;
		this.adviseStampedDate = adviseStampedDate;
		this.adviseVerifiedBy = adviseVerifiedBy;
		this.adviseVerifiedDate = adviseVerifiedDate;
		this.maintenanceStartDate = maintenanceStartDate;
		this.maintenanceEndDate = maintenanceEndDate;
		this.maintenanceFee = maintenanceFee;
		this.maintenanceBilingAddress = maintenanceBilingAddress;
		this.maintenanceFeeFreq = maintenanceFeeFreq;
		this.fireInsuranceDueDate = fireInsuranceDueDate;
		this.fireInsuranceAmount = fireInsuranceAmount;
		this.fireInsuranceCompanyId = fireInsuranceCompanyId;
		this.lastPaymentMadeDate = lastPaymentMadeDate;
		this.maintenanceBilingCycle = maintenanceBilingCycle;
		this.cancelledReason = cancelledReason;
		this.remark = remark;
		this.source = source;
		this.salesPerson = salesPerson;
		this.waterBillings = waterBillings;
		this.projects = projects;
		this.addresses = addresses;
		this.emails = emails;
		this.postdatedCheques = postdatedCheques;
		this.mobilePhones = mobilePhones;
		this.joinAccounts = joinAccounts;
		this.transactionHistories = transactionHistories;
		this.accountAgings = accountAgings;
	}

	public Long getCancelDocId() {
		return cancelDocId;
	}

	public void setCancelDocId(Long cancelDocId) {
		this.cancelDocId = cancelDocId;
	}

	public BigDecimal getCancelFee() {
		return cancelFee;
	}

	public void setCancelFee(BigDecimal cancelFee) {
		this.cancelFee = cancelFee;
	}

	public BigDecimal getCancelTax() {
		return cancelTax;
	}

	public void setCancelTax(BigDecimal cancelTax) {
		this.cancelTax = cancelTax;
	}

	public BigDecimal getCancelNetRefundAmt() {
		return cancelNetRefundAmt;
	}

	public void setCancelNetRefundAmt(BigDecimal cancelNetRefundAmt) {
		this.cancelNetRefundAmt = cancelNetRefundAmt;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public BigDecimal getAccountBalanceNotNull() {
		if(accountBalance == null)
			return BigDecimal.ZERO;
		return accountBalance;
	}
	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Customer getCustomer2() {
		return customer2;
	}

	public void setCustomer2(Customer customer2) {
		this.customer2 = customer2;
	}

	public Customer getCustomer3() {
		return customer3;
	}

	public void setCustomer3(Customer customer3) {
		this.customer3 = customer3;
	}

	public Customer getCustomer4() {
		return customer4;
	}

	public void setCustomer4(Customer customer4) {
		this.customer4 = customer4;
	}

	public Customer getCustomer5() {
		return customer5;
	}

	public void setCustomer5(Customer customer5) {
		this.customer5 = customer5;
	}

	public Long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ProjectInventory getProjectInventory() {
		return this.projectInventory;
	}

	public void setProjectInventory(ProjectInventory projectInventory) {
		this.projectInventory = projectInventory;
	}

	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountStatus() {
		return this.accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Long getAttendedBy() {
		return this.attendedBy;
	}

	public void setAttendedBy(Long attendedBy) {
		this.attendedBy = attendedBy;
	}

	public BigDecimal getRegistrationFee() {
		return this.registrationFee;
//		if (registrationFee != null) {
//			System.out.println("not null");
//			DecimalFormat df = new DecimalFormat();
//			df.setMaximumFractionDigits(2);
//			return new BigDecimal(df.format(this.registrationFee));
//		} else {
//			return new BigDecimal(0.00);
//		}
	}

	public void setRegistrationFee(BigDecimal registrationFee) {
		this.registrationFee = registrationFee;
	}

	public String getRegistrationNo() {
		return this.registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public Date getDatePurchased() {
		return this.datePurchased;
	}

	public void setDatePurchased(Date datePurchased) {
		this.datePurchased = datePurchased;
	}

	public BigDecimal getPurchasePrice() {
		return this.purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public BigDecimal getDiscountedAmount() {
		return this.discountedAmount;
	}

	public void setDiscountedAmount(BigDecimal discountedAmount) {
		this.discountedAmount = discountedAmount;
	}

	public BigDecimal getCommissionAmount() {
		return this.commissionAmount;
	}

	public void setCommissionAmount(BigDecimal commissionAmount) {
		this.commissionAmount = commissionAmount;
	}

	public Date getCommissionPaidDate() {
		return this.commissionPaidDate;
	}

	public void setCommissionPaidDate(Date commissionPaidDate) {
		this.commissionPaidDate = commissionPaidDate;
	}

	public BigDecimal getNetPrice() {
		return this.netPrice;
	}

	public void setNetPrice(BigDecimal netPrice) {
		this.netPrice = netPrice;
	}

	public String getPurchaseType() {
		return this.purchaseType;
	}

	public void setPurchaseType(String purchaseType) {
		this.purchaseType = purchaseType;
	}

	public Long getPanelBankId() {
		return this.panelBankId;
	}

	public void setPanelBankId(Long panelBankId) {
		this.panelBankId = panelBankId;
	}

	public BigDecimal getLoanAmount() {
		return this.loanAmount;
	}

	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	public BigDecimal getTotalPaymentTodate() {
		return this.totalPaymentTodate;
	}
	
	public BigDecimal getTotalPaymentTodateNotNull() {
		if(totalPaymentTodate == null)
			return BigDecimal.ZERO;
		return totalPaymentTodate;
	}

	public void setTotalPaymentTodate(BigDecimal totalPaymentTodate) {
		this.totalPaymentTodate = totalPaymentTodate;
	}

	public Long getRedemptionBankId() {
		return this.redemptionBankId;
	}

	public void setRedemptionBankId(Long redemptionBankId) {
		this.redemptionBankId = redemptionBankId;
	}

	public BigDecimal getBankRedemptionSum() {
		return this.bankRedemptionSum;
	}
	public BigDecimal getBankRedemptionSumNotNull() {
		if(bankRedemptionSum == null)
			return BigDecimal.ZERO;
		return this.bankRedemptionSum;
	}

	public void setBankRedemptionSum(BigDecimal bankRedemptionSum) {
		this.bankRedemptionSum = bankRedemptionSum;
	}

	public BigDecimal getBankRedemptionTodate() {
		return this.bankRedemptionTodate;
	}
	
	public BigDecimal getBankRedemptionTodateNotNull() {
		if(bankRedemptionTodate == null)
			return BigDecimal.ZERO;
		return bankRedemptionTodate;
	}

	public void setBankRedemptionTodate(BigDecimal bankRedemptionTodate) {
		this.bankRedemptionTodate = bankRedemptionTodate;
	}

	public Date getSpaSignedDate() {
		return this.spaSignedDate;
	}

	public void setSpaSignedDate(Date spaSignedDate) {
		this.spaSignedDate = spaSignedDate;
	}

	public Date getSpaStampedDate() {
		return this.spaStampedDate;
	}

	public void setSpaStampedDate(Date spaStampedDate) {
		this.spaStampedDate = spaStampedDate;
	}

	public Long getSpaVerifiedBy() {
		return this.spaVerifiedBy;
	}

	public void setSpaVerifiedBy(Long spaVerifiedBy) {
		this.spaVerifiedBy = spaVerifiedBy;
	}

	public Date getSpaVerifiedDate() {
		return this.spaVerifiedDate;
	}

	public void setSpaVerifiedDate(Date spaVerifiedDate) {
		this.spaVerifiedDate = spaVerifiedDate;
	}

	public Long getSpaSolicitorId() {
		return this.spaSolicitorId;
	}

	public void setSpaSolicitorId(Long spaSolicitorId) {
		this.spaSolicitorId = spaSolicitorId;
	}

	public Date getLoSignedDate() {
		return this.loSignedDate;
	}

	public void setLoSignedDate(Date loSignedDate) {
		this.loSignedDate = loSignedDate;
	}

	public Date getLoVerifiedDate() {
		return this.loVerifiedDate;
	}

	public void setLoVerifiedDate(Date loVerifiedDate) {
		this.loVerifiedDate = loVerifiedDate;
	}

	public Long getLoVerifiedBy() {
		return this.loVerifiedBy;
	}

	public void setLoVerifiedBy(Long loVerifiedBy) {
		this.loVerifiedBy = loVerifiedBy;
	}

	public Date getLaSignedDate() {
		return this.laSignedDate;
	}

	public void setLaSignedDate(Date laSignedDate) {
		this.laSignedDate = laSignedDate;
	}

	public Date getLaStampedDate() {
		return this.laStampedDate;
	}

	public void setLaStampedDate(Date laStampedDate) {
		this.laStampedDate = laStampedDate;
	}

	public Long getLaVerifiedBy() {
		return this.laVerifiedBy;
	}

	public void setLaVerifiedBy(Long laVerifiedBy) {
		this.laVerifiedBy = laVerifiedBy;
	}

	public Date getLaVerifiedDate() {
		return this.laVerifiedDate;
	}

	public void setLaVerifiedDate(Date laVerifiedDate) {
		this.laVerifiedDate = laVerifiedDate;
	}

	public Long getLaSolicitorId() {
		return this.laSolicitorId;
	}

	public void setLaSolicitorId(Long laSolicitorId) {
		this.laSolicitorId = laSolicitorId;
	}

	public Date getAdviseSignedDate() {
		return this.adviseSignedDate;
	}

	public void setAdviseSignedDate(Date adviseSignedDate) {
		this.adviseSignedDate = adviseSignedDate;
	}

	public Date getAdviseStampedDate() {
		return this.adviseStampedDate;
	}

	public void setAdviseStampedDate(Date adviseStampedDate) {
		this.adviseStampedDate = adviseStampedDate;
	}

	public Long getAdviseVerifiedBy() {
		return this.adviseVerifiedBy;
	}

	public void setAdviseVerifiedBy(Long adviseVerifiedBy) {
		this.adviseVerifiedBy = adviseVerifiedBy;
	}

	public Date getAdviseVerifiedDate() {
		return this.adviseVerifiedDate;
	}

	public void setAdviseVerifiedDate(Date adviseVerifiedDate) {
		this.adviseVerifiedDate = adviseVerifiedDate;
	}

	public Date getMaintenanceStartDate() {
		return this.maintenanceStartDate;
	}

	public void setMaintenanceStartDate(Date maintenanceStartDate) {
		this.maintenanceStartDate = maintenanceStartDate;
	}

	public Date getMaintenanceEndDate() {
		return this.maintenanceEndDate;
	}

	public void setMaintenanceEndDate(Date maintenanceEndDate) {
		this.maintenanceEndDate = maintenanceEndDate;
	}

	public BigDecimal getMaintenanceFee() {
		return this.maintenanceFee;
	}

	public void setMaintenanceFee(BigDecimal maintenanceFee) {
		this.maintenanceFee = maintenanceFee;
	}

	public Character getMaintenanceBilingAddress() {
		return this.maintenanceBilingAddress;
	}

	public void setMaintenanceBilingAddress(Character maintenanceBilingAddress) {
		this.maintenanceBilingAddress = maintenanceBilingAddress;
	}

	public String getMaintenanceFeeFreq() {
		return this.maintenanceFeeFreq;
	}

	public void setMaintenanceFeeFreq(String maintenanceFeeFreq) {
		this.maintenanceFeeFreq = maintenanceFeeFreq;
	}

	public Date getFireInsuranceDueDate() {
		return this.fireInsuranceDueDate;
	}

	public void setFireInsuranceDueDate(Date fireInsuranceDueDate) {
		this.fireInsuranceDueDate = fireInsuranceDueDate;
	}

	public BigDecimal getFireInsuranceAmount() {
		return this.fireInsuranceAmount;
	}

	public void setFireInsuranceAmount(BigDecimal fireInsuranceAmount) {
		this.fireInsuranceAmount = fireInsuranceAmount;
	}

	public Long getFireInsuranceCompanyId() {
		return this.fireInsuranceCompanyId;
	}

	public void setFireInsuranceCompanyId(Long fireInsuranceCompanyId) {
		this.fireInsuranceCompanyId = fireInsuranceCompanyId;
	}

	public Date getLastPaymentMadeDate() {
		return this.lastPaymentMadeDate;
	}

	public void setLastPaymentMadeDate(Date lastPaymentMadeDate) {
		this.lastPaymentMadeDate = lastPaymentMadeDate;
	}

	public String getMaintenanceBilingCycle() {
		return this.maintenanceBilingCycle;
	}

	public void setMaintenanceBilingCycle(String maintenanceBilingCycle) {
		this.maintenanceBilingCycle = maintenanceBilingCycle;
	}

	public String getCancelledReason() {
		return this.cancelledReason;
	}

	public void setCancelledReason(String cancelledReason) {
		this.cancelledReason = cancelledReason;
	}

	public Set getWaterBillings() {
		return this.waterBillings;
	}

	public void setWaterBillings(Set waterBillings) {
		this.waterBillings = waterBillings;
	}

	public Set getProjects() {
		return this.projects;
	}

	public void setProjects(Set projects) {
		this.projects = projects;
	}

	public Set getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set addresses) {
		this.addresses = addresses;
	}

	public Set getEmails() {
		return this.emails;
	}

	public void setEmails(Set emails) {
		this.emails = emails;
	}

	public Set getPostdatedCheques() {
		return this.postdatedCheques;
	}

	public void setPostdatedCheques(Set postdatedCheques) {
		this.postdatedCheques = postdatedCheques;
	}

	public Set getMobilePhones() {
		return this.mobilePhones;
	}

	public void setMobilePhones(Set mobilePhones) {
		this.mobilePhones = mobilePhones;
	}

	public Set getJoinAccounts() {
		return this.joinAccounts;
	}

	public void setJoinAccounts(Set joinAccounts) {
		this.joinAccounts = joinAccounts;
	}

	public Set getTransactionHistories() {
		return this.transactionHistories;
	}

	public void setTransactionHistories(Set transactionHistories) {
		this.transactionHistories = transactionHistories;
	}

	public Set getAccountAgings() {
		return this.accountAgings;
	}

	public void setAccountAgings(Set accountAgings) {
		this.accountAgings = accountAgings;
	}

	public Long getCorrAddrCustId() {
		return corrAddrCustId;
	}

	public void setCorrAddrCustId(Long corrAddrCustId) {
		this.corrAddrCustId = corrAddrCustId;
	}

	public BigDecimal getBookPymtAmount() {
		return bookPymtAmount;
	}

	public void setBookPymtAmount(BigDecimal bookPymtAmount) {
		this.bookPymtAmount = bookPymtAmount;
	}

	public String getBookPymtMethod() {
		return bookPymtMethod;
	}

	public void setBookPymtMethod(String bookPymtMethod) {
		this.bookPymtMethod = bookPymtMethod;
	}

	public String getBookPymtCardChqNo() {
		return bookPymtCardChqNo;
	}

	public void setBookPymtCardChqNo(String bookPymtCardChqNo) {
		this.bookPymtCardChqNo = bookPymtCardChqNo;
	}

	public String getBookPymtBank() {
		return bookPymtBank;
	}

	public void setBookPymtBank(String bookPymtBank) {
		this.bookPymtBank = bookPymtBank;
	}

	public String getSalesPerson() {
		return salesPerson;
	}

	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Date getDateChanged() {
		return dateChanged;
	}

	public void setDateChanged(Date dateChanged) {
		this.dateChanged = dateChanged;
	}

	public Long getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(Long changedBy) {
		this.changedBy = changedBy;
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

	public BigDecimal getAccrualInterest() {
		return accrualInterest;
	}

	public void setAccrualInterest(BigDecimal accrualInterest) {
		this.accrualInterest = accrualInterest;
	}

	public String getCampaignCode() {
		return campaignCode;
	}

	public void setCampaignCode(String campaignCode) {
		this.campaignCode = campaignCode;
	}

	public String getFinancierRef() {
		return financierRef;
	}

	public void setFinancierRef(String financierRef) {
		this.financierRef = financierRef;
	}

	public String getSpaRefNo() {
		return spaRefNo;
	}

	public void setSpaRefNo(String spaRefNo) {
		this.spaRefNo = spaRefNo;
	}

	public Long getFinancierId() {
		return financierId;
	}

	public void setFinancierId(Long financierId) {
		this.financierId = financierId;
	}

	public String getLaRefNo() {
		return laRefNo;
	}

	public void setLaRefNo(String laRefNo) {
		this.laRefNo = laRefNo;
	}

	@Override
	public String toString() {
		return "Account ["
				+ (accountId != null ? "accountId=" + accountId + ", " : "")
				+ (accountType != null ? "accountType=" + accountType + ", "
						: "")
				+ (accountStatus != null ? "accountStatus=" + accountStatus
						+ ", " : "")
				+ (accountBalance != null ? "accountBalance=" + accountBalance
						+ ", " : "")
				+ (attendedBy != null ? "attendedBy=" + attendedBy + ", " : "")
				+ (registrationFee != null ? "registrationFee="
						+ registrationFee + ", " : "")
				+ (registrationNo != null ? "registrationNo=" + registrationNo
						+ ", " : "")
				+ (datePurchased != null ? "datePurchased=" + datePurchased
						+ ", " : "")
				+ (purchasePrice != null ? "purchasePrice=" + purchasePrice
						+ ", " : "")
				+ (discountedAmount != null ? "discountedAmount="
						+ discountedAmount + ", " : "")
				+ (commissionAmount != null ? "commissionAmount="
						+ commissionAmount + ", " : "")
				+ (commissionPaidDate != null ? "commissionPaidDate="
						+ commissionPaidDate + ", " : "")
				+ (netPrice != null ? "netPrice=" + netPrice + ", " : "")
				+ (purchaseType != null ? "purchaseType=" + purchaseType + ", "
						: "")
				+ (panelBankId != null ? "panelBankId=" + panelBankId + ", "
						: "")
				+ (loanAmount != null ? "loanAmount=" + loanAmount + ", " : "")
				+ (latePymtIntRate != null ? "latePymtIntRate="
						+ latePymtIntRate + ", " : "")
				+ (latePymtFee != null ? "latePymtFee=" + latePymtFee + ", "
						: "")
				+ (accrualInterest != null ? "accrualInterest="
						+ accrualInterest + ", " : "")
				+ (totalPaymentTodate != null ? "totalPaymentTodate="
						+ totalPaymentTodate + ", " : "")
				+ (redemptionBankId != null ? "redemptionBankId="
						+ redemptionBankId + ", " : "")
				+ (bankRedemptionSum != null ? "bankRedemptionSum="
						+ bankRedemptionSum + ", " : "")
				+ (bankRedemptionTodate != null ? "bankRedemptionTodate="
						+ bankRedemptionTodate + ", " : "")
				+ (spaSignedDate != null ? "spaSignedDate=" + spaSignedDate
						+ ", " : "")
				+ (spaStampedDate != null ? "spaStampedDate=" + spaStampedDate
						+ ", " : "")
				+ (spaVerifiedBy != null ? "spaVerifiedBy=" + spaVerifiedBy
						+ ", " : "")
				+ (spaVerifiedDate != null ? "spaVerifiedDate="
						+ spaVerifiedDate + ", " : "")
				+ (spaSolicitorId != null ? "spaSolicitorId=" + spaSolicitorId
						+ ", " : "")
				+ (loSignedDate != null ? "loSignedDate=" + loSignedDate + ", "
						: "")
				+ (loVerifiedDate != null ? "loVerifiedDate=" + loVerifiedDate
						+ ", " : "")
				+ (loVerifiedBy != null ? "loVerifiedBy=" + loVerifiedBy + ", "
						: "")
				+ (laSignedDate != null ? "laSignedDate=" + laSignedDate + ", "
						: "")
				+ (laStampedDate != null ? "laStampedDate=" + laStampedDate
						+ ", " : "")
				+ (laVerifiedBy != null ? "laVerifiedBy=" + laVerifiedBy + ", "
						: "")
				+ (laVerifiedDate != null ? "laVerifiedDate=" + laVerifiedDate
						+ ", " : "")
				+ (laSolicitorId != null ? "laSolicitorId=" + laSolicitorId
						+ ", " : "")
				+ (adviseSignedDate != null ? "adviseSignedDate="
						+ adviseSignedDate + ", " : "")
				+ (adviseStampedDate != null ? "adviseStampedDate="
						+ adviseStampedDate + ", " : "")
				+ (adviseVerifiedBy != null ? "adviseVerifiedBy="
						+ adviseVerifiedBy + ", " : "")
				+ (adviseVerifiedDate != null ? "adviseVerifiedDate="
						+ adviseVerifiedDate + ", " : "")
				+ (maintenanceStartDate != null ? "maintenanceStartDate="
						+ maintenanceStartDate + ", " : "")
				+ (maintenanceEndDate != null ? "maintenanceEndDate="
						+ maintenanceEndDate + ", " : "")
				+ (maintenanceFee != null ? "maintenanceFee=" + maintenanceFee
						+ ", " : "")
				+ (maintenanceBilingAddress != null ? "maintenanceBilingAddress="
						+ maintenanceBilingAddress + ", "
						: "")
				+ (maintenanceFeeFreq != null ? "maintenanceFeeFreq="
						+ maintenanceFeeFreq + ", " : "")
				+ (fireInsuranceDueDate != null ? "fireInsuranceDueDate="
						+ fireInsuranceDueDate + ", " : "")
				+ (fireInsuranceAmount != null ? "fireInsuranceAmount="
						+ fireInsuranceAmount + ", " : "")
				+ (fireInsuranceCompanyId != null ? "fireInsuranceCompanyId="
						+ fireInsuranceCompanyId + ", " : "")
				+ (lastPaymentMadeDate != null ? "lastPaymentMadeDate="
						+ lastPaymentMadeDate + ", " : "")
				+ (maintenanceBilingCycle != null ? "maintenanceBilingCycle="
						+ maintenanceBilingCycle + ", " : "")
				+ (cancelledReason != null ? "cancelledReason="
						+ cancelledReason + ", " : "")
				+ (remark != null ? "remark=" + remark + ", " : "")
				+ (changedBy != null ? "changedBy=" + changedBy + ", " : "")
				+ (dateChanged != null ? "dateChanged=" + dateChanged + ", "
						: "")
				+ (source != null ? "source=" + source + ", " : "")
				+ (salesPerson != null ? "salesPerson=" + salesPerson + ", "
						: "")
				+ (corrAddrCustId != null ? "corrAddrCustId=" + corrAddrCustId
						+ ", " : "")
				+ (bookPymtAmount != null ? "bookPymtAmount=" + bookPymtAmount
						+ ", " : "")
				+ (bookPymtMethod != null ? "bookPymtMethod=" + bookPymtMethod
						+ ", " : "")
				+ (bookPymtCardChqNo != null ? "bookPymtCardChqNo="
						+ bookPymtCardChqNo + ", " : "")
				+ (bookPymtBank != null ? "bookPymtBank=" + bookPymtBank + ", "
						: "")
				+ (cancelFee != null ? "cancelFee=" + cancelFee + ", " : "")
				+ (cancelTax != null ? "cancelTax=" + cancelTax + ", " : "")
				+ (cancelNetRefundAmt != null ? "cancelNetRefundAmt="
						+ cancelNetRefundAmt + ", " : "")
				+ (cancelDocId != null ? "cancelDocId=" + cancelDocId + ", "
						: "")
				+ (financierId != null ? "financierId=" + financierId + ", "
						: "")
				+ (spaRefNo != null ? "spaRefNo=" + spaRefNo + ", " : "")
				+ (laRefNo != null ? "laRefNo=" + laRefNo + ", " : "")
				+ (campaignCode != null ? "campaignCode=" + campaignCode + ", "
						: "")
				+ (financierRef != null ? "financierRef=" + financierRef : "")
				+ "]";
	}

	public Long getBorrowerId1() {
		return borrowerId1;
	}

	public void setBorrowerId1(Long borrowerId1) {
		this.borrowerId1 = borrowerId1;
	}

	public Long getBorrowerId2() {
		return borrowerId2;
	}

	public void setBorrowerId2(Long borrowerId2) {
		this.borrowerId2 = borrowerId2;
	}

	public String getDebtorAccount() {
		return debtorAccount;
	}

	public void setDebtorAccount(String debtorAccount) {
		this.debtorAccount = debtorAccount;
	}

}
