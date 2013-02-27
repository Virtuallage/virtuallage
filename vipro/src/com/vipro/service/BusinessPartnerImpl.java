package com.vipro.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipro.dao.CodeDao;
import com.vipro.data.CodeDet;
import com.vipro.data.CodeHeader;

@Service("com.vipro.service.BusinessPartnerService")
public class BusinessPartnerServiceImpl implements BusinessPartnerService {

	@Autowired
	private BusinessPartnerDao BusinessPartnerDao;

	public BusinessPartnerDao getBusinessPartnerDao() {
		return BusinessPartnerDao;
	}

	public void setBusinessPartnerDao(BusinessPartnerDao BusinessPartnerDao) {
		this.BusinessPartnerDao = BusinessPartnerDao;
	}

	@Override
	public BusinessPartnerHeader findById(String codeId) {
		return BusinessPartnerDao.findById(BusinessPartnerId);
	}

	@Override
	public List<BusinessPartner> findByProjectBusinessPartnerId(Long BusinessPartnerId) {
		String query="select o from com.vipro.data.BusinessPartner o where o.PartnerType.BusinessPartnerId=?";
		List<Account> acc = getHibernateTemplate().find(query, BusinessPartnerId);
		return BusinessPartner;
	}

	@Override
	public BusinessPartner findById(Long BusinessPartnerId) {
		return getHibernateTemplate().get(BusinessPartner.class, BusinessPartnerId);
	}
	
	@Override
	public BusinessPartner findAll() {
		return getHibernateTemplate().find(¡°select o from BusinessPartner o¡±);
	}
	
	}
	
}
