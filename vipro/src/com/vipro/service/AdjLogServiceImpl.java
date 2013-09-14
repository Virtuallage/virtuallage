package com.vipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipro.dao.AdjLogDao;
import com.vipro.data.AdjLog;

@Service("com.vipro.service.AdjLogService")
public class AdjLogServiceImpl implements AdjLogService {
	@Autowired
	private AdjLogDao adjLogDao;
	
	public AdjLogDao getAdjLogDao() {
		return adjLogDao;
	}

	public void setAdjLogDao(AdjLogDao adjLogDao) {
		this.adjLogDao = adjLogDao;
	}
	
	@Override
	public List<AdjLog> findAll() {
		return adjLogDao.findAll();
	}
	
	@Override
	public List<AdjLog> findByAdjHeaderId(Long adjHeaderId) {
		return adjLogDao.findByAdjHeaderId(adjHeaderId);
	}

	@Override
	public void insert(AdjLog adjLog) {
		adjLogDao.insert(adjLog);
	}

	@Override
	public void update(AdjLog adjLog) {
		adjLogDao.update(adjLog);
	}

	@Override
	public void delete(Long adjLogId) {
		AdjLog adjLog = adjLogDao.findById(adjLogId);
		adjLogDao.delete(adjLog);
	}

	@Override
	public AdjLog findById(Long adjLogId) {
		return adjLogDao.findById(adjLogId);
	}

}
