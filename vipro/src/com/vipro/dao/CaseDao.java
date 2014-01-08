package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.Case;

/**
 * 
 * @author cvl
 *
 */
public interface CaseDao extends Dao<Case> {
	
	public List<Case> findByAssigneeId(Long assigneeId, String assigneeGrp);
	 
	public Case findById(Long caseId);
	
	public Case findByProject(String caseType, Long projectId, Long accountId);
}
