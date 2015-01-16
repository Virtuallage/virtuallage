package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.LetterHistory;

/**
 * 
 * @author Sean
 *
 */
public interface LetterHistoryDao extends Dao<LetterHistory>{

	public LetterHistory findById(Long id);
	
	public List<LetterHistory> findByLetterIdAccount(Long projectId, Long accountId);

	public List<LetterHistory> findByAccount(Long accountId);

	public List<LetterHistory> findAll();
}
