package com.vipro.data;

// Generated Feb 3, 2013 6:50:08 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;

/**
 * TransactionGroup generated by hbm2java
 */
public class TransactionGroup implements java.io.Serializable {

	private Long transactionGroupId;
	private TransactionCode transactionCode;
	private Date transactionDate;
	private String groupType;
	private BigDecimal totalAmount;
	private BigDecimal totalTransaction;

	public TransactionGroup() {
	}

	public TransactionGroup(TransactionCode transactionCode) {
		this.transactionCode = transactionCode;
	}

	public TransactionGroup(TransactionCode transactionCode,
			Date transactionDate, String groupType, BigDecimal totalAmount,
			BigDecimal totalTransaction) {
		this.transactionCode = transactionCode;
		this.transactionDate = transactionDate;
		this.groupType = groupType;
		this.totalAmount = totalAmount;
		this.totalTransaction = totalTransaction;
	}

	public Long getTransactionGroupId() {
		return this.transactionGroupId;
	}

	public void setTransactionGroupId(Long transactionGroupId) {
		this.transactionGroupId = transactionGroupId;
	}

	public TransactionCode getTransactionCode() {
		return this.transactionCode;
	}

	public void setTransactionCode(TransactionCode transactionCode) {
		this.transactionCode = transactionCode;
	}

	public Date getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getGroupType() {
		return this.groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public BigDecimal getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getTotalTransaction() {
		return this.totalTransaction;
	}

	public void setTotalTransaction(BigDecimal totalTransaction) {
		this.totalTransaction = totalTransaction;
	}

}
