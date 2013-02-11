package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.CaseActivity;

public interface CaseActivityDao extends Dao<CaseActivity>{

	public List<CaseActivity> findByCaseId(Long caseId);
}
