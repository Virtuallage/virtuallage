package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.Case;
import com.vipro.data.CaseLink;

@Repository("com.vipro.dao.CaseLinkDao")
public class CaseLinkDaoImpl extends DaoImpl<CaseLink> implements CaseLinkDao{

	@Override
	public void insert(CaseLink o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CaseLink o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CaseLink o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CaseLink> getCaseLinkList(String caseType, String caseStatus) {
		String query = "select o from CaseLink o where o.caseType=? and o.caseStatus=?";
		List<CaseLink> caseLink = getHibernateTemplate().find(query, caseType, caseStatus);
		return caseLink;
	}

}
