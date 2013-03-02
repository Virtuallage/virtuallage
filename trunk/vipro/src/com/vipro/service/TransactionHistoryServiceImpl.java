package com.vipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipro.dao.TransactionHistoryDao;
import com.vipro.data.TransactionHistory;

@Service("com.vipro.service.TransactionHistoryService")
public class TransactionHistoryServiceImpl implements TransactionHistoryService {
	
	@Autowired
	private TransactionHistoryDao transactionHistoryDao;
	
	

	public TransactionHistoryDao getTransactionHistoryDao() {
		return transactionHistoryDao;
	}

	public void setTransactionHistoryDao(TransactionHistoryDao transactionHistoryDao) {
		this.transactionHistoryDao = transactionHistoryDao;
	}

	@Override
	public void insert(TransactionHistory t) {
		transactionHistoryDao.insert(t);
		
	}

	@Override
	public void update(TransactionHistory t) {
		transactionHistoryDao.update(t);
		
	}

	@Override
	public List<TransactionHistory> findByAccountId(Long accountId) {
		return transactionHistoryDao.findByAccountId(accountId);
	}

	@Override
	public void delete(Long trxId) {
		TransactionHistory h = transactionHistoryDao.findById(trxId);
		transactionHistoryDao.delete(h);
		
	}

}
