package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.constant.PropertyUnitStatusConst;
import com.vipro.data.ProgressiveBilling;

@Repository("com.vipro.dao.ProgressiveBillingDao")
public class ProgressiveBillingDaoImpl extends DaoImpl<ProgressiveBilling>
		implements ProgressiveBillingDao {

	@Override
	public List<ProgressiveBilling> findByAccountId(Long accountId) {
		String query = "select o from ProgressiveBilling o where o.account.accountId=?";
		return getHibernateTemplate().find(query, accountId);
	}
	
	@Override
	public ProgressiveBilling findById(Long id) {
		return getHibernateTemplate().get(ProgressiveBilling.class, id);
	}

}
