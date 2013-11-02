package com.vipro.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.constant.CommonConst;
import com.vipro.data.BillingModel;
import com.vipro.data.SeqNo;

/**
 * 
 * @author cvl
 *
 */
@SuppressWarnings("unchecked")
@Repository("com.vipro.dao.BillingModelDao")
public class BillingModelDaoImpl extends DaoImpl<BillingModel> implements BillingModelDao {

	@Override
	public BillingModel findById(Long id) {
		BillingModel ins = getHibernateTemplate().get(BillingModel.class, id);
		return ins;
	}

	
	@Override
	public List<BillingModel> findAllActive() {
		String query = "select o from BillingModel o where o.status=?";
		List<BillingModel> list = getHibernateTemplate().find(query, CommonConst.STATUS_ACTIVE);
		return list;
	}

	@Override
	public List<BillingModel> findAll() {
		String query = "select o from BillingModel o ";
		List<BillingModel> list = getHibernateTemplate().find(query);
		return list;
	}

	@Override
	public List<BillingModel> findByBillingModelCode(String modelCode) {
		String query = " select o from BillingModel o where o.billingModelCode=? order by o.billingSeq ";
		List<BillingModel> list = getHibernateTemplate().find(query, modelCode);
		return list;
	}
}
