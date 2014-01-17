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
		
		String query = "select o from Case o where (o.assignee.userId=? or o.groupId=?) and o.status <> 'CSCLS' and  o.status <> 'CSREJ' and  o.status <> 'CSCAN'";
		List<Case> cases = getHibernateTemplate().find(query, assigneeId, assigneeGrp);
		return cases;
	}

	@Override
	public Case findById(Long caseId) {
		return (Case) getHibernateTemplate().get(Case.class, caseId);
	}

	@Override
	public Case findByProject(String caseType, Long projectId, Long accountId) {
		String query = "select o from Case o where o.caseType=? and o.projectId=? and o.accountId=?";
		List<Case> cases = getHibernateTemplate().find(query, caseType, projectId, accountId);
		for (Case d : cases) {
			return d;
		}
		return null;
	}

}
