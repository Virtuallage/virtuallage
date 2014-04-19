package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.BillingModel;
import com.vipro.data.BillingModelHeader;

/**
 * 
 * @author cvl
 *
 */
public interface BillingModelHeaderDao extends Dao<BillingModelHeader>{

	public List<BillingModelHeader> findAllModel();

	public List<BillingModelHeader> findById(Long headerId);
	
	public BillingModelHeader findModel(Long headerId);
	
	public List<BillingModelHeader> findByModel(String modelCode);
	
}
