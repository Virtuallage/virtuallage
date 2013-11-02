package com.vipro.dao;

import java.util.Calendar;
import java.util.Date;
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
	
	public boolean isOffDay(int dayOfWeek, Long instId);
	
	public boolean isHoliday(Date date, Long instId);
	
}
