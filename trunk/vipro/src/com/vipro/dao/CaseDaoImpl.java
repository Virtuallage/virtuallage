package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.Case;
import com.vipro.data.CaseRoute;

/**
 * 
 * @author cvl
 *
 */
@Repository("com.vipro.dao.CaseDao")
public class CaseDaoImpl extends DaoImpl<Case> implements CaseDao {

	@Override
	public List<Case> findByAssigneeId(Long assigneeId, String assigneeGrp) {
		
		String query = "select o from Case o where o.assignee.userId=? or o.groupId=?";
		List<Case> cases = getHibernateTemplate().find(query, assigneeId, assigneeGrp);
		return cases;
	}

	@Override
	public Case findById(Long caseId) {
		return (Case) getHibernateTemplate().get(Case.class, caseId);
	}

	@Override
	public Case findByProject(String caseType, Long projectId, String unitNo) {
		String query = "select o from Case o where o.caseType=? and o.projectId=? and o.unitNo=?";
		List<Case> cases = getHibernateTemplate().find(query, caseType, projectId, unitNo);
		for (Case d : cases) {
			return d;
		}
		return null;
	}

}
