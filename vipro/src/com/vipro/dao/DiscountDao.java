package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.Discount;

public interface DiscountDao extends Dao<Discount>{

	public List<Discount> findByProjectId(Long projectId);
	public Discount findById(Long id);
	public Discount findCurrentEffectiveDiscount(Long projectId);
}
