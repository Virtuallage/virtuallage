package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.BusinessPartner;

public interface BusinessPartnerDao extends Dao<BusinessPartner> {

	public BusinessPartner findById(Long codeId);
	public List<BusinessPartner> findByPartnerType(String partnerType);
	public List<BusinessPartner> findAllBusinessPartner(); 

}
