package com.vipro.service;

import java.util.List;

import com.vipro.data.CaseLink;

public interface CaseLinkService {
	public List<CaseLink> getCaseLinkList(String caseType, String caseStatus);
}
