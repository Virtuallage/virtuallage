package com.vipro.service;

import java.util.List;

import com.vipro.data.Case;
import com.vipro.data.CaseActivity;
import com.vipro.data.CaseRoute;

public interface CaseService {

	public List<Case> findByAssigneeId(Long assigneeId, String assigneeGrp);
	
	public Case findById(Long caseId);
	
	public void insert(Case c);
	
	public void update(Case c);
	
	public void delete(Long c);
	
	public void insertActivity(CaseActivity a);
	
	public CaseRoute getCaseRoute(String caseType, String status, 
			Long projectId, String groupId, Long userId);
	
	public Case findByProject(String caseType, Long projectId, String unitNo);
}
