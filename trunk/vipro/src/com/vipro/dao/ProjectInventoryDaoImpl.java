package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.constant.PropertyUnitStatusConst;
import com.vipro.data.ProjectInventory;

@Repository("com.vipro.dao.ProjectInventoryDao")
public class ProjectInventoryDaoImpl extends DaoImpl<ProjectInventory>
		implements ProjectInventoryDao {

	@Override
	public List<ProjectInventory> findByProjectId(Long projectId) {
		String query = "select o from ProjectInventory o where o.project.projectId=?";
		return getHibernateTemplate().find(query, projectId);
	}
	
	@Override
	public List<ProjectInventory> findByAvailableProjectId(Long projectId) {
		String query = "select o from ProjectInventory o where o.project.projectId=? and o.propertyStatus='" 
				+ PropertyUnitStatusConst.STATUS_SOLD + "'";
		return getHibernateTemplate().find(query, projectId);
	}

	@Override
	public ProjectInventory findById(Long id) {
		return getHibernateTemplate().get(ProjectInventory.class, id);
	}

	@Override
	public ProjectInventory findByCompositeKey(Long projectId, String blockNo,
			String unit, String level) {
		String query = "select o from ProjectInventory o where o.project.projectId=? "
				+ "and blockNo=? and o.unitNo=? and o.level=?";
		List<ProjectInventory> list = getHibernateTemplate().find(query,
				projectId, blockNo, unit, level);
		if (list != null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}

}
