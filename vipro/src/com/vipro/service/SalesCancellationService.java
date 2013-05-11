package com.vipro.service;

import java.util.List;

import com.vipro.data.SalesCancellationHistory;;

public interface SalesCancellationService {

	public List<SalesCancellationHistory> findAll();
	public SalesCancellationHistory findById(Long accountId);
	public void insert(SalesCancellationHistory a);
	public void update(SalesCancellationHistory a);
	public void delete(Long cancellationId);
}
