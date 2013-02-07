package com.vipro.service;

import java.util.List;

import com.vipro.data.Case;

public interface CaseService {

	public List<Case> findByAssigneeId(Long assigneeId);
	
}
