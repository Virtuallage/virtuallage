package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.Letter;

/**
 * 
 * @author Sean
 *
 */
public interface LetterDao extends Dao<Letter>{

	public Letter findById(Long id);
	
	public List<Letter> findByProjectId(Long projectId);
	
	public List<Letter> findByProjectIdStatus(Long projectId, String status);
	
	public List<Letter> findAll();
}
