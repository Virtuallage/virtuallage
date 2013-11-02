package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.BillingModel;

/**
 * 
 * @author cvl
 *
 */
public interface BillingModelDao extends Dao<BillingModel>{

	public BillingModel findById(Long id);
	
	public List<BillingModel> findAllActive();
	
	public List<BillingModel> findAll();
	
	public List<BillingModel> findByBillingModelCode(String modelCode) ;
	
}
