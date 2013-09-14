package com.vipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipro.dao.AdjHeaderDao;
import com.vipro.data.AdjHeader;

@Service("com.vipro.service.AdjHeaderService")
public class AdjHeaderServiceImpl implements AdjHeaderService {
	@Autowired
	private AdjHeaderDao adjHeaderDao;
	
	public AdjHeaderDao getAdjHeaderDao() {
		return adjHeaderDao;
	}

	public void setAdjHeaderDao(AdjHeaderDao adjHeaderDao) {
		this.adjHeaderDao = adjHeaderDao;
	}
	
	@Override
	public List<AdjHeader> findAll() {
		return adjHeaderDao.findAll();
	}
	
	@Override
	public List<AdjHeader> findByProjectId(Long projectId) {
		return adjHeaderDao.findByProjectId(projectId);
	}

	@Override
	public void insert(AdjHeader adjHeader) {
		adjHeaderDao.insert(adjHeader);
	}

	@Override
	public void update(AdjHeader adjHeader) {
		adjHeaderDao.update(adjHeader);
	}

	@Override
	public void delete(Long adjHeaderId) {
		AdjHeader adjHeader = adjHeaderDao.findById(adjHeaderId);
		adjHeaderDao.delete(adjHeader);
	}

	@Override
	public AdjHeader findById(Long adjHeaderId) {
		return adjHeaderDao.findById(adjHeaderId);
	}

}
