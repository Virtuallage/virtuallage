package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.AdjLog;

public interface AdjLogDao extends Dao<AdjLog> {

	public List<AdjLog> findAll();
	public List<AdjLog> findByAdjHeaderId(Long adjHeaderId);
	public AdjLog findById(Long adjLogId);
}
