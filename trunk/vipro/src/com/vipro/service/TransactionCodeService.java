package com.vipro.service;

import java.util.List;

import com.vipro.data.BusinessPartner;
import com.vipro.data.TransactionCode;

/**
 * 
 * @author cvl
 *
 */
public interface TransactionCodeService {

	public List<TransactionCode> findActiveTransactionCodes();
	public TransactionCode findByTC(String transactionCode);

}
