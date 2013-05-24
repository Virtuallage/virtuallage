package com.vipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipro.dao.ProjectInventoryDao;
import com.vipro.data.ProjectInventory;

@Service("com.vipro.service.ProjectInventoryService")
public class ProjectInventoryServiceImpl implements ProjectInventoryService {

	@Autowired
	private ProjectInventoryDao projectInventoryDao;

	public ProjectInventoryDao getProjectInventoryDao() {
		return projectInventoryDao;
	}

	public void setProjectInventoryDao(ProjectInventoryDao projectInventoryDao) {
		this.projectInventoryDao = projectInventoryDao;
	}

	@Override
	public List<ProjectInventory> getInventories(Long projectId) {
		return projectInventoryDao.findByProjectId(projectId);
	}
	
	@Override
	public List<ProjectInventory> getAvailableInventories(Long projectId) {
		return projectInventoryDao.findByAvailableProjectId(projectId);
	}

	@Override
	public ProjectInventory getInventoryById(Long inventoryId) {
		return projectInventoryDao.findById(inventoryId);
	}

	@Override
	public void insert(ProjectInventory p) {
		projectInventoryDao.insert(p);

	}

	@Override
	public void update(ProjectInventory p) {
		projectInventoryDao.update(p);

	}

	@Override
	public void delete(Long inventoryId) {
		ProjectInventory o = projectInventoryDao.findById(inventoryId);
		projectInventoryDao.delete(o);

	}

	@Override
	public ProjectInventory findByCompositeKey(Long projectId, String blockNo,
			String unit, String level) {
		return projectInventoryDao.findByCompositeKey(projectId, blockNo, unit,
				level);
	}
	
	@Override
	public int countTotalUnits(Long projectId) {
		return projectInventoryDao.countTotalUnits(projectId);
	}
}
