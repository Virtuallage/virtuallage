package com.vipro.service;

import java.util.List;

import com.vipro.data.Project;
import com.vipro.data.ProjectInventory;

public interface ProjectService {

	
	public List<Project> findAllProjects();
	public Project findById(Long projectId);
	public List<ProjectInventory> findInventories(Long projectId);
	
	public void insert(Project p);
	public void update(Project p);
	public void deleteProject(Long projectId);
	
	public void insert(ProjectInventory i);
	public void update(ProjectInventory i);
	public void deleteInventory(Long inventoryId);
}
