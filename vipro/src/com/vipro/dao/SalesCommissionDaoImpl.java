package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.SalesCommission;

@Repository("com.vipro.dao.SalesCommissionDao")
public class SalesCommissionDaoImpl extends DaoImpl<SalesCommission> implements SalesCommissionDao {

	@Override
	public List<SalesCommission> findByProjectId(Long projectId) {
		String query = "select o from SalesCommission o where o.project.projectId=?";
		return getHibernateTemplate().find(query, projectId);

	}

	@Override
	public SalesCommission findById(Long id) {
		return getHibernateTemplate().get(SalesCommission.class, id);
	}

}
