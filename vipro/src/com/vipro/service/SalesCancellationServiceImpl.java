package com.vipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipro.dao.SalesCancellationHistoryDao;
import com.vipro.data.SalesCancellationHistory;

@Service("com.vipro.service.SalesCancellationService")
public class SalesCancellationServiceImpl implements SalesCancellationService {
	@Autowired
	private SalesCancellationHistoryDao salesCancellationHistoryDao;
	
	public SalesCancellationHistoryDao getSalesCancellationHistoryDao() {
		return salesCancellationHistoryDao;
	}

	public void setSalesCancellationHistoryDao(SalesCancellationHistoryDao salesCancellationHistoryDao) {
		this.salesCancellationHistoryDao = salesCancellationHistoryDao;
	}
	
	@Override
	public List<SalesCancellationHistory> findAll() {
		return salesCancellationHistoryDao.findAll();
	}
	
	@Override
	public List<SalesCancellationHistory> findByInventoryId(Long inventoryId) {
		return salesCancellationHistoryDao.findByInventoryId(inventoryId);
	}

	@Override
	public void insert(SalesCancellationHistory c) {
		salesCancellationHistoryDao.insert(c);
	}

	@Override
	public void update(SalesCancellationHistory a) {
		salesCancellationHistoryDao.update(a);
	}

	@Override
	public void delete(Long cancellationId) {
		SalesCancellationHistory c = salesCancellationHistoryDao.findById(cancellationId);
		salesCancellationHistoryDao.delete(c);
	}

	@Override
	public SalesCancellationHistory findById(Long cancellationId) {
		return salesCancellationHistoryDao.findById(cancellationId);
	}

}
