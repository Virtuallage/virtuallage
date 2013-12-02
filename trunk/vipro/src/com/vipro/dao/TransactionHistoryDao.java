package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.TransactionHistory;

public interface TransactionHistoryDao extends Dao<TransactionHistory>{

	
	public List<TransactionHistory> findByAccountId(Long accountId);
	
	public List<TransactionHistory> findTransactionHistoryByAccountIdAndTcode(Long accountId, String transcationCode);
	
	public TransactionHistory findById(Long id);
}
