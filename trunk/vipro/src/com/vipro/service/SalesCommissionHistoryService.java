package com.vipro.service;

import java.util.List;

import com.vipro.data.SalesCommissionHistory;

public interface SalesCommissionHistoryService {

	public List<SalesCommissionHistory> findByBatchNo(Long batchNo);
	public List<SalesCommissionHistory> findByAccountId(Long accounId);
	public List<SalesCommissionHistory> findAll();
	public SalesCommissionHistory findById(Long commissionId);
	public void insert(SalesCommissionHistory a);
	public void update(SalesCommissionHistory a);
	public void delete(Long commissionId);
}
