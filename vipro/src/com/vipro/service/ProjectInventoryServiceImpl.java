package com.vipro.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vipro.dao.AddressDao;
import com.vipro.dao.ProjectInventoryDao;
import com.vipro.data.ProjectInventory;
import com.vipro.dto.*;
import com.vipro.jsf.bean.CommonBean;

@Service("com.vipro.service.ProjectInventoryService")
public class ProjectInventoryServiceImpl implements ProjectInventoryService {

	@Autowired
	private ProjectInventoryDao projectInventoryDao;
	@Autowired
	private AddressDao addressDao;

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
	public List<ProjectInventory> getUnAvailableInventories(Long projectId) {
		return projectInventoryDao.findByUnAvailableProjectId(projectId);
	}

	@Override
	public List<ProjectInventory> getCancellingInventories(Long projectId) {
		return projectInventoryDao.findCancellingById(projectId);
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
	@Transactional
	public void updatePropertyUnit(PropertyUnitDetailsDTO  dto){
		if(dto.getAddress().getAddressId() == null){
			dto.getAddress().setCreatedBy(CommonBean.getCurrentUser().getUsername());
			dto.getAddress().setCreatedOn(new Date());
		} else {
			dto.getAddress().setAddressLine1((dto.getAddress().getAddressLine1()).toUpperCase());
			dto.getAddress().setAddressLine2((dto.getAddress().getAddressLine2()).toUpperCase());
			dto.getAddress().setAddressLine3((dto.getAddress().getAddressLine3()).toUpperCase());
			dto.getAddress().setAddressLine4((dto.getAddress().getAddressLine4()).toUpperCase());
			dto.getAddress().setCity((dto.getAddress().getCity()).toUpperCase());
		}
		addressDao.update(dto.getAddress());
		dto.getProjectInvetory().setPropertyAddress(dto.getAddress());
		projectInventoryDao.update(dto.getProjectInvetory());
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

	@Override
	public List<ProjectInventory> getInventories(Long projectId, String unitNo) {
		// TODO Auto-generated method stub
		return projectInventoryDao.findByProjectIdUnitNo(projectId, unitNo);
	}
	
	@Override
	public List<ProjectInventory> getAvailableInventories(Long projectId, String unitNo) {
		return projectInventoryDao.findByAvailableProjectIdUnitNo(projectId, unitNo);
	}

	@Override
	public List<ProjectInventory> getUnAvailableInventories(Long projectId, String unitNo) {
		return projectInventoryDao.findByUnAvailableProjectIdUnitNo(projectId, unitNo);
	}

	@Override
	public List<ProjectInventory> getLockedUnit(Long projectId, Long userId) {
		return projectInventoryDao.findLockedUnit(projectId, userId);
	}

	public AddressDao getAddressDao() {
		return addressDao;
	}

	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}
}
