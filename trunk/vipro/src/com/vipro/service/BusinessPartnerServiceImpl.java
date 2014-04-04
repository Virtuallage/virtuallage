package com.vipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipro.dao.BusinessPartnerDao;
import com.vipro.data.BusinessPartner;

@Service("com.vipro.service.BusinessPartnerService")
public class BusinessPartnerServiceImpl implements BusinessPartnerService {
	
	@Autowired
	private BusinessPartnerDao businessPartnerDao;
	
	
	public BusinessPartnerDao getBusinessPartnerDao() {
		return businessPartnerDao;
	}

	public void setBusinessPartnerDao(BusinessPartnerDao businessPartnerDao) {
		this.businessPartnerDao = businessPartnerDao;
	}

	@Override
	public BusinessPartner findById(Long partnerId) {
		return businessPartnerDao.findById(partnerId);
	}
	
	@Override
	public BusinessPartner findByCompanyCode(String companyCode) {
		return businessPartnerDao.findByCompanyCode(companyCode);
	}
	
	@Override
	public List<BusinessPartner> findByPartnerType(String partnerType) {
		return businessPartnerDao.findByPartnerType(partnerType);
	}

	@Override
	public void insert(BusinessPartner a) {
		businessPartnerDao.insert(a);
	}

	@Override
	public void update(BusinessPartner a) {
		businessPartnerDao.update(a);
	}

	@Override
	public void delete(Long partnerId) {
		BusinessPartner a =businessPartnerDao.findById(partnerId);
		businessPartnerDao.delete(a);
	}
	
}
