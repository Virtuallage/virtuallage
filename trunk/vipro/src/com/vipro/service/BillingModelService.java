package com.vipro.service;

import java.util.List;

import com.vipro.data.BillingModel;

public interface BillingModelService {
	
	public void insert(BillingModel c);
	
	public void update(BillingModel c);
	
	public void delete(Long c);
	
	public BillingModel findById(Long id);
	
	public List<BillingModel> findAllActive();
	
	public List<BillingModel> findAll();
	
	public List<BillingModel> findByBillingModelCode(String modelCode) ;

}
