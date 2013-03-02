package com.vipro.service;

import java.util.List;

import com.vipro.data.TransactionHistory;

public interface TransactionHistoryService {

	public void insert(TransactionHistory t);
	public void update(TransactionHistory t);
	public void delete(Long trxId);
	public List<TransactionHistory> findByAccountId(Long accountId);
	
}
