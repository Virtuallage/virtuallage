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
	public BusinessPartner findByCompanyCode(String companyCode) {
		List list = getHibernateTemplate().find(
                "from BusinessPartner where companyCode=?",companyCode);
		if (list.size() == 0) {
			return null;
		}
		return (BusinessPartner)list.get(0);
	}	
		
//	public Stock findByStockCode(String stockCode){
//		List list = getHibernateTemplate().find(
//                     "from Stock where stockCode=?",stockCode);
//		return (Stock)list.get(0);
//	}

	
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
