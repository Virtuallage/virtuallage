package com.vipro.service;

import java.util.List;

import com.vipro.data.Case;
import com.vipro.data.CaseActivity;

public interface CaseService {

	public List<Case> findByAssigneeId(Long assigneeId);
	
	public Case findById(Long caseId);
	
	public void insert(Case c);
	
	public void update(Case c);
	
	public void delete(Long c);
	
	public void insertActivity(CaseActivity a);
	
}
