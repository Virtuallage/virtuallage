package com.vipro.service;

import java.util.List;

import com.vipro.data.BusinessPartner;

public interface BusinessPartnerService {

	public BusinessPartner findById(Long partnerId);
	public BusinessPartner findByCompanyCode(String companyCode);	
	public List<BusinessPartner> findByPartnerType(String partnerType);
	public void insert(BusinessPartner a);
	public void update(BusinessPartner a);
	public void delete(Long partnerId);
}
