package com.vipro.service;

import java.util.List;

import com.vipro.data.Letter;

/**
 * 
 * @author Sean
 *
 */
public interface LetterService {
	
	public List<Letter> findByProjectId(Long projectId);
	
	public List<Letter> findByProjectIdStatus(Long projectId, String status);
	
	public List<Letter> findAll();

	public void insert(Letter letter);
	
	public void update(Letter letter);
	
	public void delete(Long letterId);
}
