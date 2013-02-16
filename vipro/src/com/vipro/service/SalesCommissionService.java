package com.vipro.service;

import java.util.List;

import com.vipro.data.SalesCommission;

public interface SalesCommissionService {

	public List<SalesCommission> findByProjectId(Long projectId);
	public void insert(SalesCommission s);
	public void update(SalesCommission s);
	public void delete(Long id);
}
