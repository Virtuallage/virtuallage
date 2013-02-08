package com.vipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipro.dao.CaseDao;
import com.vipro.data.Case;

@Service("com.vipro.service.CaseService")
public class CaseServiceImpl implements CaseService {
	
	@Autowired
	private CaseDao caseDao;
	

	public List<Case> findByAssigneeId(Long assigneeId) {
		return caseDao.findByAssigneeId(assigneeId);
	}


	@Override
	public void insert(Case c) {
		caseDao.insert(c);
		
	}


	@Override
	public void update(Case c) {
		caseDao.update(c);
		
	}


	@Override
	public void delete(Long c) {
		Case cs = caseDao.findById(c);
		caseDao.delete(cs);
		
		
	}


	@Override
	public Case findById(Long caseId) {
		return caseDao.findById(caseId);
	}
	
}
