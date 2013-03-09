package com.vipro.service;

import java.util.List;

import com.vipro.data.ProjectInventory;

public interface ProjectInventoryService {

	
	public List<ProjectInventory> getInventories(Long projectId);
	
	public ProjectInventory getInventoryById(Long inventoryId);
	
	public void insert(ProjectInventory p);
	
	public void update(ProjectInventory p);
	
	public void delete(Long inventoryId);
	

}