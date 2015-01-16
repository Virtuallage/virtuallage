package com.vipro.service;

import java.util.List;

import com.vipro.data.LetterHistory;

/**
 * 
 * @author Sean
 *
 */
public interface LetterHistoryService {
	
	public List<LetterHistory> findByLetterIdAccount(Long letterId, Long accountId);

	public List<LetterHistory> findByAccount(Long accountId);
	
	public List<LetterHistory> findAll();

	public void insert(LetterHistory lh);
	
	public void update(LetterHistory lh);
	
	public void delete(Long lhId);
}
