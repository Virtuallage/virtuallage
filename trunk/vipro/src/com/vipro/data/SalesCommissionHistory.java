package com.vipro.data;

// Generated Feb 3, 2013 6:50:08 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

/**
 * Account generated by hbm2java
 */
public class SalesCommissionHistory implements java.io.Serializable {

	private Long commissionId;
	private Account account;
	
	public SalesCommissionHistory() {
	}

	public SalesCommissionHistory(Account account) {
		this.account = account;
	}

	public Long getCommissionId() {
		return commissionId;
	}

	public void setCommissionId(Long commissionId) {
		this.commissionId = commissionId;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	
}