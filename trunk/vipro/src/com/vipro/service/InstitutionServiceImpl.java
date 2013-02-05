package com.vipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipro.dao.InstitutionDao;
import com.vipro.data.Institution;

@Service("com.vipro.service.InstitutionService")
public class InstitutionServiceImpl implements InstitutionService {

	@Autowired
	private InstitutionDao institutionDao;

	public InstitutionDao getInstitutionDao() {
		return institutionDao;
	}

	public void setInstitutionDao(InstitutionDao institutionDao) {
		this.institutionDao = institutionDao;
	}

	@Override
	public List<Institution> findAll() {
		return institutionDao.findAll();
	}

	@Override
	public List<Institution> findAllActive() {
		return institutionDao.findAllActive();
	}

	@Override
	public Institution findById(Long id) {
		return institutionDao.findById(id);
	}

	@Override
	public void insert(Institution ins) {
		institutionDao.insert(ins);
	}

	@Override
	public void update(Institution ins) {
		institutionDao.update(ins);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
