package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.SalesCancellationHistory;

public interface SalesCancellationHistoryDao extends Dao<SalesCancellationHistory> {


	public List<SalesCancellationHistory> findAll();
	public SalesCancellationHistory findById(Long accountId);
}
