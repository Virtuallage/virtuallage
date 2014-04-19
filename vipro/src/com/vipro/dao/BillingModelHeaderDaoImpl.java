package com.vipro.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.constant.CommonConst;
import com.vipro.data.BillingModel;
import com.vipro.data.BillingModelHeader;
import com.vipro.data.BusinessPartner;
import com.vipro.data.SeqNo;

/**
 * 
 * @author cvl
 *
 */
@Repository("com.vipro.dao.BillingModelHeaderDao")
public class BillingModelHeaderDaoImpl extends DaoImpl<BillingModelHeader> implements BillingModelHeaderDao {

	@Override
	public List<BillingModelHeader> findAllModel() {
		String query = "select o from BillingModelHeader o order by o.billingModelCode";
		List<BillingModelHeader> list = getHibernateTemplate().find(query);

		return list;
	}

	@Override
	public List<BillingModelHeader> findById(Long headerId) {
		String query = "select o from BillingModelHeader o where o.headerId=?";
		List<BillingModelHeader> list = getHibernateTemplate().find(query, headerId);

		return list;
	}

	@Override
	public BillingModelHeader findModel(Long headerId) {
		BillingModelHeader header = getHibernateTemplate().get(BillingModelHeader.class, headerId);
		return header;
	}

	@Override
	public List<BillingModelHeader> findByModel(String modelCode) {
		String query = "select o from BillingModelHeader o where o.billingModelCode=?";
		List<BillingModelHeader> list = getHibernateTemplate().find(query, modelCode);

		return list;
	}
}
