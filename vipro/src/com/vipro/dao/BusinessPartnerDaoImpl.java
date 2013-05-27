package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.BusinessPartner;

@Repository("com.vipro.dao.BusinessPartnerDao")
public class BusinessPartnerDaoImpl extends DaoImpl<BusinessPartner> implements BusinessPartnerDao {

	@Override
	public BusinessPartner findById(Long codeId) {
		BusinessPartner header = getHibernateTemplate().get(BusinessPartner.class, codeId);
		return header;
	}
	
	@Override
	public List<BusinessPartner> findByPartnerType(String partnerType) {
		String query = "select o from BusinessPartner o where o.partnerType=?";
		return getHibernateTemplate().find(query, partnerType);
	}
	
	@Override
	public List<BusinessPartner> findAllBusinessPartner() {
		return getHibernateTemplate().loadAll(BusinessPartner.class);
	}

}
