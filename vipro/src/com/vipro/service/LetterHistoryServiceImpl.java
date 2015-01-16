package com.vipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipro.dao.LetterHistoryDao;
import com.vipro.data.LetterHistory;

/**
 * 
 * @author Sean
 *
 */
@Service("com.vipro.service.LetterHistoryService")
public class LetterHistoryServiceImpl implements LetterHistoryService {

	@Autowired
	private LetterHistoryDao letterHistoryDao;

	public LetterHistoryDao getLetterHistoryDao() {
		return letterHistoryDao;
	}

	public void setLetterHistoryDao(LetterHistoryDao letterHistoryDao) {
		this.letterHistoryDao = letterHistoryDao;
	}

	@Override
	public List<LetterHistory> findByLetterIdAccount(Long letterId, Long accountId) {
		return letterHistoryDao.findByLetterIdAccount(letterId, accountId);
	}
	
	@Override
	public List<LetterHistory> findByAccount(Long accountId) {
		return letterHistoryDao.findByAccount(accountId);
	}

	@Override
	public List<LetterHistory> findAll() {
		return letterHistoryDao.findAll();
	}
	
	@Override
	public void insert(LetterHistory lh) {
		letterHistoryDao.insert(lh);
	}

	@Override
	public void update(LetterHistory lh) {
		letterHistoryDao.update(lh);
	}

	@Override
	public void delete(Long lhId) {
		LetterHistory lh = letterHistoryDao.findById(lhId);
		letterHistoryDao.delete(lh);
	}

}
