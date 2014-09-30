package com.vipro.dao;

import java.math.BigDecimal;
import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.ProgressiveBilling;

public interface ProgressiveBillingDao extends Dao<ProgressiveBilling>{

	public List<ProgressiveBilling> findByAccountId(Long accountId);
	
	public List<ProgressiveBilling> findByAccountIdStatusAndInvoiceNo(Long accountId, String[] statuses, String invoiceNo);
	public List<ProgressiveBilling> findByAccountIdStatusAndFInvoiceNo(Long accountId, String[] statuses, String invoiceNo);

	public BigDecimal getRemaingPaymentAmountByAccountIdStatusAndInvoiceNo(Long accountId, String[] statuses, String invoiceNo);
	public BigDecimal getRemaingPaymentAmountByAccountIdStatusAndFInvoiceNo(Long accountId, String[] statuses, String invoiceNo);
	
	public boolean isInvoiceFullyPaid(Long accountId, String invoiceNo);
	public boolean isFInvoiceFullyPaid(Long accountId, String invoiceNo);
	
	public boolean updateProgressiveBillingStatus(Long accountId, String to, String[] from, String[] stagesNos, Long txReversalId);
		
	public ProgressiveBilling findById(Long id);
	
	public ProgressiveBilling findByStageAndAccountId(Long accountId, String stageNo);
	
}
