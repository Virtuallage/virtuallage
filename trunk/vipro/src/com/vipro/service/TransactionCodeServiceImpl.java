package com.vipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipro.dao.TransactionCodeDao;
import com.vipro.data.BusinessPartner;
import com.vipro.data.TransactionCode;

/**
 * 
 * @author cvl
 *
 */
@Service("com.vipro.service.TransactionCodeService")
public class TransactionCodeServiceImpl implements TransactionCodeService {

	@Autowired
	private TransactionCodeDao transactionCodeDao;

	public TransactionCodeDao getTransactionCodeDao() {
		return transactionCodeDao;
	}

	public void setTransactionCodeDao(TransactionCodeDao transactionCodeDao) {
		this.transactionCodeDao = transactionCodeDao;
	}

	@Override
	public List<TransactionCode> findActiveTransactionCodes() {
		return transactionCodeDao.findActiveTransactionCodes();
	}
	
	@Override
	public TransactionCode findByTC(String transactionCode) {
		return transactionCodeDao.findByTC(transactionCode);
	}

}
