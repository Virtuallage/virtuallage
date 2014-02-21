package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.SalesCancellationHistory;

public interface SalesCancellationHistoryDao extends Dao<SalesCancellationHistory> {


	public List<SalesCancellationHistory> findAll();
	public List<SalesCancellationHistory> findByProjectId(Long projectId);
	public List<SalesCancellationHistory> findByInventoryId(Long inventoryId);
	public SalesCancellationHistory findById(Long cancellationId);
}
