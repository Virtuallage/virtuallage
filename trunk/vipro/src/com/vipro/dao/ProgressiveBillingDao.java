package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.ProgressiveBilling;

public interface ProgressiveBillingDao extends Dao<ProgressiveBilling>{

	public List<ProgressiveBilling> findByAccountId(Long accountId);
		
	public ProgressiveBilling findById(Long id);
	
	public ProgressiveBilling findByStageAndAccountId(Long accountId, String stageNo);
	
}
