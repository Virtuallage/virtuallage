package com.vipro.service;

import java.util.List;

import com.vipro.data.AdjHeader;

public interface AdjHeaderService {

	public List<AdjHeader> findAll();
	public List<AdjHeader> findByProjectId(Long projectId);
	public AdjHeader findById(Long adjHeaderId);
	public void insert(AdjHeader adjHeader);
	public void update(AdjHeader adjHeader);
	public void delete(Long adjHeaderId);
}
