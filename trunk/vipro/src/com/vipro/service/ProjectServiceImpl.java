package com.vipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipro.dao.ProjectDao;
import com.vipro.dao.ProjectInventoryDao;
import com.vipro.data.Project;
import com.vipro.data.ProjectInventory;

@Service("com.vipro.service.ProjectService")
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private ProjectInventoryDao projectInventoryDao;

	public ProjectDao getProjectDao() {
		return projectDao;
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	public ProjectInventoryDao getProjectInventoryDao() {
		return projectInventoryDao;
	}

	public void setProjectInventoryDao(ProjectInventoryDao projectInventoryDao) {
		this.projectInventoryDao = projectInventoryDao;
	}

	@Override
	public List<Project> findAllProjects() {
		return projectDao.findAll();
	}

	@Override
	public List<ProjectInventory> findInventories(Long projectId) {
		return projectInventoryDao.findByProjectId(projectId);
	}

	@Override
	public void insert(Project p) {
		projectDao.insert(p);

	}

	@Override
	public void update(Project p) {
		projectDao.update(p);

	}

	@Override
	public void deleteProject(Long projectId) {
		Project p = projectDao.findById(projectId);
		projectDao.delete(p);

	}

	@Override
	public void insert(ProjectInventory i) {
		projectInventoryDao.insert(i);

	}

	@Override
	public void update(ProjectInventory i) {
		projectInventoryDao.update(i);

	}

	@Override
	public void deleteInventory(Long inventoryId) {
		ProjectInventory i = projectInventoryDao.findById(inventoryId);
		projectInventoryDao.delete(i);

	}

	@Override
	public Project findById(Long projectId) {
		return projectDao.findById(projectId);
	}

}
