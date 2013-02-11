package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.CaseActivity;

@Repository("com.vipro.dao.CaseActivityDao")
public class CaseActiivityDaoImpl extends DaoImpl<CaseActivity> implements CaseActivityDao{

	@Override
	public List<CaseActivity> findByCaseId(Long caseId) {
		String query = "select o from CaseActivity o where o.caseId=?";
		return getHibernateTemplate().find(query, caseId);
	}

}
