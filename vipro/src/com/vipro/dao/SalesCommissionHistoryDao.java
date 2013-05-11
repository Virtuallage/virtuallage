package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.SalesCommissionHistory;

public interface SalesCommissionHistoryDao extends Dao<SalesCommissionHistory> {


	public List<SalesCommissionHistory> findAll();
	public SalesCommissionHistory findById(Long commissionId);
}
