package com.vipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipro.dao.BillingModelDao;
import com.vipro.data.BillingModel;

@Service("com.vipro.service.BillingModelService")
public class BillingModelServiceImpl implements BillingModelService {
	@Autowired
	private BillingModelDao billingModelDao;
	
	@Override
	public void insert(BillingModel c) {
		billingModelDao.insert(c);
	}

	@Override
	public void update(BillingModel c) {
		billingModelDao.update(c);
	}

	@Override
	public void delete(Long c) {
		BillingModel b = billingModelDao.findById(c);
		billingModelDao.delete(b);
	}

	@Override
	public BillingModel findById(Long id) {
		return billingModelDao.findById(id);
	}

	@Override
	public List<BillingModel> findAllActive() {
		return billingModelDao.findAllActive();
	}

	@Override
	public List<BillingModel> findAll() {
		return billingModelDao.findAll();
	}

	@Override
	public List<BillingModel> findByBillingModelCode(String modelCode) {
		return billingModelDao.findByBillingModelCode(modelCode);
	}
}
