package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.Account;
import com.vipro.data.AdjHeader;

@Repository("com.vipro.dao.AdjHeaderDao")
public class AdjHeaderDaoImpl extends DaoImpl<AdjHeader> implements AdjHeaderDao {


	@Override
	public List<AdjHeader> findAll() {
		String query="select o from com.vipro.data.AdjHeader o";
		return getHibernateTemplate().find(query);
	}
	
	@Override
	public List<AdjHeader> findByProjectId(Long projectId) {
		String query="select o from com.vipro.data.AdjHeader o where o.project.projectId=?";
		return getHibernateTemplate().find(query, projectId);
	}
	
	@Override
	public AdjHeader findById(Long adjHeaderId) {
		return getHibernateTemplate().get(AdjHeader.class, adjHeaderId);
	}

}
