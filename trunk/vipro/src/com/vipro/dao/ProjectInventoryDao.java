package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.ProjectInventory;

public interface ProjectInventoryDao extends Dao<ProjectInventory>{

	
	public List<ProjectInventory> findByProjectId(Long projectId);
	
	public List<ProjectInventory> findByProjectIdUnitNo(Long projectId, String unitNo);
	
	public List<ProjectInventory> findLockedUnit(Long projectId, Long userId);
	
	public List<ProjectInventory> findByAvailableProjectId(Long projectId);
	
	public ProjectInventory findById(Long id);
	
	public ProjectInventory findByCompositeKey(Long projectId, String blockNo, String unit, String level);

	public int countTotalUnits(Long projectId);
}
