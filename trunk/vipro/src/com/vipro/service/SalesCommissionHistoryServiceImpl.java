package com.vipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipro.dao.SalesCommissionHistoryDao;
import com.vipro.data.SalesCommissionHistory;

@Service("com.vipro.service.SalesCommissionHistoryService")
public class SalesCommissionHistoryServiceImpl implements SalesCommissionHistoryService {
	@Autowired
	private SalesCommissionHistoryDao salesCommissionHistoryDao;
	
	
	public SalesCommissionHistoryDao getSalesCommissionHistoryDao() {
		return salesCommissionHistoryDao;
	}

	public void setAccountDao(SalesCommissionHistoryDao salesCommissionHistoryDao) {
		this.salesCommissionHistoryDao = salesCommissionHistoryDao;
	}
	
	@Override
	public List<SalesCommissionHistory> findByAccountId(Long accountId) {
		return salesCommissionHistoryDao.findByAccountId(accountId);
	}
	
	@Override
	public List<SalesCommissionHistory> findByBatchNo(Long batchNo) {
		return salesCommissionHistoryDao.findByBatchNo(batchNo);
	}
	
	@Override
	public List<SalesCommissionHistory> findAll() {
		return salesCommissionHistoryDao.findAll();
	}

	@Override
	public void insert(SalesCommissionHistory a) {
		salesCommissionHistoryDao.insert(a);
		
	}

	@Override
	public void update(SalesCommissionHistory a) {
		salesCommissionHistoryDao.update(a);
		
	}

	@Override
	public void delete(Long commissionId) {
		SalesCommissionHistory a = salesCommissionHistoryDao.findById(commissionId);
		salesCommissionHistoryDao.delete(a);
		
	}

	@Override
	public SalesCommissionHistory findById(Long commissionId) {
		return salesCommissionHistoryDao.findById(commissionId);
	}

}
