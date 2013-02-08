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
	
	public List<Case> findByAssigneeId(Long assigneeId);
	 
	public Case findById(Long caseId);
}
