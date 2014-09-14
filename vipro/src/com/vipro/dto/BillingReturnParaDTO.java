package com.vipro.dto;

import java.io.Serializable;

public class BillingReturnParaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2795242806330829896L;
	private Boolean isSucessfull = true;
	private String invoiceNo = "";
	private String invoiceNo2 ="";
	
	public BillingReturnParaDTO() {
		
	}

	public Boolean getIsSucessfull() {
		return isSucessfull;
	}

	public void setIsSucessfull(Boolean isSucessfull) {
		this.isSucessfull = isSucessfull;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getInvoiceNo2() {
		return invoiceNo2;
	}

	public void setInvoiceNo2(String invoiceNo2) {
		this.invoiceNo2 = invoiceNo2;
	}

}
