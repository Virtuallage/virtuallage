package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.ProgressiveBilling;

@Repository("com.vipro.dao.ProgressiveBillingDao")
public class ProgressiveBillingDaoImpl extends DaoImpl<ProgressiveBilling>
		implements ProgressiveBillingDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ProgressiveBilling> findByAccountId(Long accountId) {
		String query = "select o from ProgressiveBilling o where o.account.accountId=?";
		return getHibernateTemplate().find(query, accountId);
	}
	
	@Override
	public ProgressiveBilling findByStageAndAccountId(Long accountId, String stageNo) {
		ProgressiveBilling pb = new ProgressiveBilling();
				
		String query = "select o from ProgressiveBilling o where o.account.accountId=? and o.stageNo=?";
		List list = getHibernateTemplate().find(query, accountId,stageNo);
		if(list != null && !list.isEmpty()){
			pb = (ProgressiveBilling)list.get(0);
		}
		return pb;
	}
	
	@Override
	public ProgressiveBilling findById(Long id) {
		return getHibernateTemplate().get(ProgressiveBilling.class, id);
	}

}
