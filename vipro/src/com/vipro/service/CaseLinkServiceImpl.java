package com.vipro.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipro.dao.CaseLinkDao;
import com.vipro.data.CaseLink;

@Service("com.vipro.service.CaseLinkService")
public class CaseLinkServiceImpl implements CaseLinkService {
	@Autowired
	private CaseLinkDao caseLinkDao;
	
	public CaseLinkDao getCaseLinkDao() {
		return caseLinkDao;
	}


	public void setCaseLinkDao(CaseLinkDao caseLinkDao) {
		this.caseLinkDao = caseLinkDao;
	}


	@Override
	public List<CaseLink> getCaseLinkList(String caseType, String caseStatus) {
		return caseLinkDao.getCaseLinkList(caseType, caseStatus);
	}
	
}
