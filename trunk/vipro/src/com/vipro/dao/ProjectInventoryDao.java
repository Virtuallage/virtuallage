package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.ProjectInventory;

public interface ProjectInventoryDao extends Dao<ProjectInventory>{

	
	public List<ProjectInventory> findByProjectId(Long projectId);
	
	public ProjectInventory findById(Long id);
}
