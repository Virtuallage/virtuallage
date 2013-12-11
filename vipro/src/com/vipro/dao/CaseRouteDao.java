package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.CaseRoute;

public interface CaseRouteDao extends Dao<CaseRoute>{
	
	public CaseRoute getCaseRoute(String caseType, String status, 
			Long projectId, String groupId, Long userId);
}
