package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.AdjLog;

@Repository("com.vipro.dao.AdjLogDao")
public class AdjLogDaoImpl extends DaoImpl<AdjLog> implements AdjLogDao {


	@Override
	public List<AdjLog> findAll() {
		String query="select o from com.vipro.data.AdjLog o";
		return getHibernateTemplate().find(query);
	}
	
	@Override
	public List<AdjLog> findByAdjHeaderId(Long adjHeaderId) {
		String query="select o from com.vipro.data.AdjLog o where o.adjHeaderId=?";
		return getHibernateTemplate().find(query, adjHeaderId);
	}

	@Override
	public AdjLog findById(Long adjLogId) {
		return getHibernateTemplate().get(AdjLog.class, adjLogId);
	}

}
