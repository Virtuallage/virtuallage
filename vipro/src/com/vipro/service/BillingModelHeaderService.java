package com.vipro.service;

import java.util.List;

import com.vipro.data.BillingModelHeader;

public interface BillingModelHeaderService {
	
	public void insert(BillingModelHeader c);
	
	public void update(BillingModelHeader c);
	
	public void delete(Long c);
	
	public List<BillingModelHeader> findAllModel();
	
	public List<BillingModelHeader> findById(Long headerId);
	
	public BillingModelHeader findModel(Long headerId);

}
