package com.vipro.service;

import java.util.List;

import com.vipro.data.SalesCancellationHistory;;

public interface SalesCancellationService {

	public List<SalesCancellationHistory> findAll();
	public List<SalesCancellationHistory> findByInventoryId(Long inventoryId);
	public SalesCancellationHistory findById(Long cancellationId);
	public void insert(SalesCancellationHistory a);
	public void update(SalesCancellationHistory a);
	public void delete(Long cancellationId);
}
