package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.CaseLink;

public interface CaseLinkDao extends Dao<CaseLink>{
	public List<CaseLink> getCaseLinkList(String caseType);
}
