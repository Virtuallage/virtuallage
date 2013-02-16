package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.ProjectInventory;

@Repository("com.vipro.dao.ProjectInventoryDao")
public class ProjectInventoryDaoImpl extends DaoImpl<ProjectInventory> implements ProjectInventoryDao {

	@Override
	public List<ProjectInventory> findByProjectId(Long projectId) {
		String query = "select o from ProjectInventory o where o.project.projectId=?";
		return getHibernateTemplate().find(query, projectId);
	}

	@Override
	public ProjectInventory findById(Long id) {
		return getHibernateTemplate().get(ProjectInventory.class, id);
	}

}
