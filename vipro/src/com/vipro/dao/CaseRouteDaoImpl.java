package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.CaseActivity;
import com.vipro.data.CaseLink;
import com.vipro.data.CaseRoute;

@Repository("com.vipro.dao.CaseRouteDao")
public class CaseRouteDaoImpl extends DaoImpl<CaseRoute> implements CaseRouteDao{

	@Override
	public CaseRoute getCaseRoute(String caseType, String status,
			Long projectId, String groupId, Long userId) {

		String query = "select o from CaseRoute o where o.caseType=? and o.status=?";
		List<CaseRoute> crL = getHibernateTemplate().find(query, caseType, status);

		for (CaseRoute d : crL) {
			if(d.getUserId()!=null){
				if (d.getUserId().toString().equalsIgnoreCase(userId.toString()))
					return d;
			}
		}
		for (CaseRoute d : crL) {
			if(d.getGroupId()!=null){
				if (d.getGroupId().toString().equalsIgnoreCase(groupId))
					return d;
			}
		}
		for (CaseRoute d : crL) {
			if(d.getProjectId()!=null){
				if (d.getProjectId().toString().equalsIgnoreCase(projectId.toString()))
					return d;
			}
		}
		for (CaseRoute d : crL) {
			if (d.getUserId()== null && d.getGroupId()==null && d.getProjectId()==null)
				return d;
		}
		for (CaseRoute d : crL) {
			return d;
		}
		return null;
	}

}
