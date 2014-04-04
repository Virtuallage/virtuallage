package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.BusinessPartner;

public interface BusinessPartnerDao extends Dao<BusinessPartner> {

	public BusinessPartner findById(Long partnerId);
	public BusinessPartner findByCompanyCode(String companyCode);
	public List<BusinessPartner> findByPartnerType(String partnerType);
	public List<BusinessPartner> findAllBusinessPartner(); 

}
