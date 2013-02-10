package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.Case;

/**
 * 
 * @author cvl
 *
 */
@Repository("com.vipro.dao.CaseDao")
public class CaseDaoImpl extends DaoImpl<Case> implements CaseDao {

	@Override
	public List<Case> findByAssigneeId(Long assigneeId) {
		String query = "select o from Case o where o.assignee.userId=?";
		List<Case> cases = getHibernateTemplate().find(query, assigneeId);
		return cases;
	}

	@Override
	public Case findById(Long caseId) {
		return (Case) getHibernateTemplate().get(Case.class, caseId);
	}

}
