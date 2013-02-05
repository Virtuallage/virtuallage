package com.vipro.service;

import java.util.List;

import com.vipro.data.Institution;

public interface InstitutionService {

	public List<Institution> findAll();
	
	public List<Institution> findAllActive();
	
	public Institution findById(Long id);
	
	public void insert(Institution ins);
	
	public void update(Institution ins);
	
	public void delete(Long id);
	
}
