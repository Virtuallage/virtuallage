package com.vipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipro.dao.LetterDao;
import com.vipro.data.Letter;

/**
 * 
 * @author Sean
 *
 */
@Service("com.vipro.service.LetterService")
public class LetterServiceImpl implements LetterService {

	@Autowired
	private LetterDao letterDao;

	public LetterDao getLetterDao() {
		return letterDao;
	}

	public void setLetterDao(LetterDao letterDao) {
		this.letterDao = letterDao;
	}

	@Override
	public List<Letter> findByProjectId(Long projectId) {
		return letterDao.findByProjectId(projectId);
	}
	
	@Override
	public List<Letter> findByProjectIdStatus(Long projectId, String status) {
		return letterDao.findByProjectIdStatus(projectId, status);
	}
	
	@Override
	public List<Letter> findAll() {
		return letterDao.findAll();
	}
	
	@Override
	public void insert(Letter letter) {
		letterDao.insert(letter);
	}

	@Override
	public void update(Letter letter) {
		letterDao.update(letter);
	}

	@Override
	public void delete(Long letterId) {
		Letter letter = letterDao.findById(letterId);
		letterDao.delete(letter);
	}

}
