package com.vipro.service;

import java.util.List;

import com.vipro.data.AdjLog;

public interface AdjLogService {

	public List<AdjLog> findAll();
	public List<AdjLog> findByAdjHeaderId(Long adjHeaderId);
	public AdjLog findById(Long adjLogId);
	public void insert(AdjLog adjLog);
	public void update(AdjLog adjLog);
	public void delete(Long adjLogId);
}
