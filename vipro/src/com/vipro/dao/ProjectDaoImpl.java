package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.Project;

@Repository("com.vipro.dao.ProjectDao")
public class ProjectDaoImpl extends DaoImpl<Project> implements ProjectDao {

	@Override
	public List<Project> findAll() {
		String query = "select o from Project o ";
		return getHibernateTemplate().find(query);
	}

	@Override
	public Project findById(Long id) {
		return getHibernateTemplate().get(Project.class, id);
	}

}
