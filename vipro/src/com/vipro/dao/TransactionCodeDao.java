package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.BusinessPartner;
import com.vipro.data.TransactionCode;

/**
 * 
 * @author cvl
 *
 */
public interface TransactionCodeDao extends Dao<TransactionCode>{

	public List<TransactionCode> findActiveTransactionCodes();
	public TransactionCode findByTC(String transactionCode);
	
}
