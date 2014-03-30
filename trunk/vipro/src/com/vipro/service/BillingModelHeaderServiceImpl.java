package com.vipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipro.dao.BillingModelHeaderDao;
import com.vipro.data.BillingModelHeader;


@Service("com.vipro.service.BillingModelHeaderService")
public class BillingModelHeaderServiceImpl implements BillingModelHeaderService {

	@Autowired
	private BillingModelHeaderDao billingModelHeaderDao;

	@Override
	public List<BillingModelHeader> findAllModel() {
		return billingModelHeaderDao.findAllModel();
	}
	
	@Override
	public List<BillingModelHeader> findById(Long headerId) {
		return billingModelHeaderDao.findById(headerId);
	}

	@Override
	public BillingModelHeader findModel(Long headerId) {
		return billingModelHeaderDao.findModel(headerId);
	}

	@Override
	public void insert(BillingModelHeader c) {
		billingModelHeaderDao.insert(c);
	}

	@Override
	public void update(BillingModelHeader c) {
		billingModelHeaderDao.update(c);
	}

	@Override
	public void delete(Long c) {
		BillingModelHeader b = billingModelHeaderDao.findModel(c);
		billingModelHeaderDao.delete(b);
	}

}
