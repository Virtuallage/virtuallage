package com.vipro.service;

import java.util.List;

import com.vipro.data.Discount;

public interface DiscountService {

	public List<Discount> findByProjectId(Long projectId);
	public void insert(Discount d);
	public void update(Discount d);
	public void delete(Long discountId);
}
