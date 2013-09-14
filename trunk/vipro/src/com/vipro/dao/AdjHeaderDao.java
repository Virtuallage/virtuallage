package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.AdjHeader;;

public interface AdjHeaderDao extends Dao<AdjHeader> {


	public List<AdjHeader> findAll();
	public List<AdjHeader> findByProjectId(Long projectId);
	public AdjHeader findById(Long adjHeaderId);
}
