package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.Project;
import com.vipro.dto.AdviseUpdateDetailsDTO;
import com.vipro.dto.ProgressiveBillingUnitSeachDTO;
import com.vipro.dto.PropertyUnitDetailsDTO;

public interface ProjectDao extends Dao<Project> {

	
	public List<Project> findAll();
	public Project findById(Long id);
	public Project findByIdAndUnit(Long id, String unit) ;
	public List<PropertyUnitDetailsDTO> getPropertyUnitDetailsDTOListByProjectIdAndUnit(Long projectId, String UnitNo);
	public List<AdviseUpdateDetailsDTO> getAdviseUpdateDetailsDTOListByProjectIdAndUnit(Long projectId, String UnitNo);
	public List<ProgressiveBillingUnitSeachDTO> getProgressiveBillingUnitSearchDTOListByProjectIdAndUnit(Long projectId, String UnitNo);
}
