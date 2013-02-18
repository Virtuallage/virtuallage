package com.vipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipro.dao.SalesCommissionDao;
import com.vipro.data.SalesCommission;

@Service("com.vipro.service.SalesCommissionService")
public class SalesCommissionServiceImpl implements SalesCommissionService {
	@Autowired
	private SalesCommissionDao salesCommissionDao;
	
	

	public SalesCommissionDao getSalesCommissionDao() {
		return salesCommissionDao;
	}

	public void setSalesCommissionDao(SalesCommissionDao salesCommissionDao) {
		this.salesCommissionDao = salesCommissionDao;
	}

	@Override
	public List<SalesCommission> findByProjectId(Long projectId) {
		return salesCommissionDao.findByProjectId(projectId);
	}

	@Override
	public void insert(SalesCommission s) {
		salesCommissionDao.insert(s);
		
	}

	@Override
	public void update(SalesCommission s) {
		salesCommissionDao.update(s);
		
	}

	@Override
	public void delete(Long id) {
		SalesCommission s = salesCommissionDao.findById(id);
		salesCommissionDao.delete(s);
		
	}

	@Override
	public SalesCommission findCurrentEffectiveSalesCommission(Long projectId) {
		return salesCommissionDao.findCurrentEffectiveSalesCommission(projectId);
	}

}
