package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.Institution;

/**
 * 
 * @author cvl
 *
 */
public interface InstitutionDao extends Dao<Institution>{

	public Institution findById(Long id);
	
	public List<Institution> findAllActive();
	
	public List<Institution> findAll();
	
}
