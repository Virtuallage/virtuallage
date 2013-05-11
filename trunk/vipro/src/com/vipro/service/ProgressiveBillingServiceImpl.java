package com.vipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipro.dao.ProgressiveBillingDao;
import com.vipro.data.ProgressiveBilling;

@Service("com.vipro.service.ProgressiveBillingService")
public class ProgressiveBillingServiceImpl implements ProgressiveBillingService {

	@Autowired
	private ProgressiveBillingDao progressiveBillingDao;

	public ProgressiveBillingDao getProgressiveBillingDao() {
		return progressiveBillingDao;
	}

	public void setProgressiveBillingDao(ProgressiveBillingDao progressiveBillingDao) {
		this.progressiveBillingDao = progressiveBillingDao;
	}

	@Override
	public List<ProgressiveBilling> getProgressiveBilling(Long inventoryId) {
		return progressiveBillingDao.findByInventoryId(inventoryId);
	}

	@Override
	public void insert(ProgressiveBilling p) {
		progressiveBillingDao.insert(p);

	}

	@Override
	public void update(ProgressiveBilling p) {
		progressiveBillingDao.update(p);

	}

	@Override
	public void delete(Long inventoryId) {
		ProgressiveBilling o = progressiveBillingDao.findById(inventoryId);
		progressiveBillingDao.delete(o);

	}


}
