package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.SalesCommission;

public interface SalesCommissionDao extends Dao<SalesCommission>{

	public List<SalesCommission> findByProjectId(Long projectId);
	public SalesCommission findById(Long id);
	public SalesCommission findCurrentEffectiveSalesCommission(Long projectId);
}
