package com.vipro.data;

// Generated Feb 3, 2013 6:50:08 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * ProgressiveBilling generated by hbm2java
 */
public class ProgressiveBilling implements java.io.Serializable {

	private Long scheduleId;
	private Account account;
	private Byte seqNo;
	private String stageNo;
	private String stageDescription;
	private String invoiceNo;	
	private BigDecimal percentage;
	private Date dueDate;
	private BigDecimal interestRate;
	private BigDecimal amountBilled;
	private Date dateBilled;
	private Date paymentDueDate;
	private Date datePaid;
	private BigDecimal overdueInterest;
	private String status;

	public ProgressiveBilling() {
	}

	public ProgressiveBilling(Account account) {
		this.account = account;
	}

	public ProgressiveBilling(Account account, Byte seqNo,
			String stageNo, String stageDescription, BigDecimal percentage,
			Date dueDate, BigDecimal interestRate, BigDecimal amountBilled,
			Date dateBilled, Date paymentDueDate, Date datePaid,
			BigDecimal overdueInterest, String status) {
		this.account = account;
		this.seqNo = seqNo;
		this.stageNo = stageNo;
		this.stageDescription = stageDescription;
		this.percentage = percentage;
		this.dueDate = dueDate;
		this.interestRate = interestRate;
		this.amountBilled = amountBilled;
		this.dateBilled = dateBilled;
		this.paymentDueDate = paymentDueDate;
		this.datePaid = datePaid;
		this.overdueInterest = overdueInterest;
		this.status = status;
	}

	public Long getScheduleId() {
		return this.scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Byte getSeqNo() {
		return this.seqNo;
	}

	public void setSeqNo(Byte seqNo) {
		this.seqNo = seqNo;
	}

	public String getStageNo() {
		return this.stageNo;
	}

	public void setStageNo(String stageNo) {
		this.stageNo = stageNo;
	}

	public String getStageDescription() {
		return this.stageDescription;
	}

	public void setStageDescription(String stageDescription) {
		this.stageDescription = stageDescription;
	}

	public BigDecimal getPercentage() {
		return this.percentage;
	}

	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public BigDecimal getInterestRate() {
		return this.interestRate;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}

	public BigDecimal getAmountBilled() {
		return this.amountBilled;
	}

	public void setAmountBilled(BigDecimal amountBilled) {
		this.amountBilled = amountBilled;
	}

	public Date getDateBilled() {
		return this.dateBilled;
	}

	public void setDateBilled(Date dateBilled) {
		this.dateBilled = dateBilled;
	}

	public Date getPaymentDueDate() {
		return this.paymentDueDate;
	}

	public void setPaymentDueDate(Date paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}

	public Date getDatePaid() {
		return this.datePaid;
	}

	public void setDatePaid(Date datePaid) {
		this.datePaid = datePaid;
	}

	public BigDecimal getOverdueInterest() {
		return this.overdueInterest;
	}

	public void setOverdueInterest(BigDecimal overdueInterest) {
		this.overdueInterest = overdueInterest;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

}
