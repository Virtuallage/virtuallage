/**
 * Vipro - Virtuallage Property Development System 
 * Copyright(C) 2013 Virtuallage Team  http://www.virtuallage.com 
 * ---------------------------------------------------------------
 */
package com.vipro.constant;

public interface ProgressiveBillingConst extends CommonConst {
	
	public static final String STAGE_PENDING = "Pending";	
	public static final String STAGE_BILLED= "Billed";	
	public static final String STAGE_PAID = "Paid";
	public static final String STAGE_RENOTICED = "Renoticed";
	
	public static final String PB_INVOICE_SEQ_TYPE = "SNPRG";
	public static final String RB_INVOICE_SEQ_TYPE = "SNRNB";
	
	public static final String PB_STATUS_BILL = "PBBIL";
	public static final String PB_STATUS_CANCEL = "PBCXN";
	public static final String PB_STATUS_FULL_PAYMENT = "PBPAI";
	public static final String PB_STATUS_PARTIAL_PAYMENT = "PBPAR";
	public static final String PB_STATUS_REVERSAL = "PBREV";
	public static final String STATUS_ACTIVE = "SSACT";

}
