package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.ProgressiveBilling;

public interface ProgressiveBillingDao extends Dao<ProgressiveBilling>{

	public List<ProgressiveBilling> findByInventoryId(Long inventoryId);
		
	public ProgressiveBilling findById(Long id);
	
}
