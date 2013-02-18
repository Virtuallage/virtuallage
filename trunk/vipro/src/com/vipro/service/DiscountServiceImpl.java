package com.vipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipro.dao.DiscountDao;
import com.vipro.data.Discount;

@Service("com.vipro.service.DiscountService")
public class DiscountServiceImpl implements DiscountService {
	@Autowired
	private DiscountDao discountDao;
	

	public DiscountDao getDiscountDao() {
		return discountDao;
	}

	public void setDiscountDao(DiscountDao discountDao) {
		this.discountDao = discountDao;
	}

	@Override
	public List<Discount> findByProjectId(Long projectId) {
		return discountDao.findByProjectId(projectId);
	}

	@Override
	public void insert(Discount d) {
		discountDao.insert(d);
		
	}

	@Override
	public void update(Discount d) {
		discountDao.update(d);
		
	}

	@Override
	public void delete(Long discountId) {
		Discount d = discountDao.findById(discountId);
		discountDao.delete(d);
		
	}

	@Override
	public Discount findById(Long discountId) {
		Discount d = discountDao.findById(discountId);
		return d;
	}

	@Override
	public Discount findCurrentEffectiveDiscount(Long projectId) {
		return discountDao.findCurrentEffectiveDiscount(projectId);
	}

}
