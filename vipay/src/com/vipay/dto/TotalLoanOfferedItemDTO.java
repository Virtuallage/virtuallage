package com.vipay.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class TotalLoanOfferedItemDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2122257188727931844L;
	
	private String bankName;
	private Long loanCount;
	private BigDecimal totalAmount;
	private boolean isTotalRow;

	public TotalLoanOfferedItemDTO() {
		
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Long getLoanCount() {
		if(loanCount == null){
			loanCount = new Long(0l);
		}
		return loanCount;
	}

	public void setLoanCount(Long loanCount) {
		this.loanCount = loanCount;
	}

	public BigDecimal getTotalAmount() {
		if(totalAmount == null){
			totalAmount = BigDecimal.ZERO;
		}
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public boolean getIsTotalRow() {
		return isTotalRow;
	}

	public void setIsTotalRow(boolean isTotalRow) {
		this.isTotalRow = isTotalRow;
	}
	
}
