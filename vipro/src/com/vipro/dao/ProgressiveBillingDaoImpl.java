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
	
	@SuppressWarnings("unchecked")
	public List<ProgressiveBilling> findByAccountIdStatusAndInvoiceNo(Long accountId, String[] statuses, String invoiceNo){
		String fString ="";
		for (int i = 0; i < statuses.length; i++) {
			fString = fString+"'"+statuses[i]+"',";
		}
		fString = fString.substring(0, fString.length()-1);
		String query = "select o from ProgressiveBilling o where o.account.accountId=? and o.invoiceNo like '"+invoiceNo+"%' and  o.status in ("+fString+") ";
		return getHibernateTemplate().find(query, accountId);
		
	}
	
	@Override
	public ProgressiveBilling findByStageAndAccountId(Long accountId, String stageNo) {
		ProgressiveBilling pb = new ProgressiveBilling();
				
		String query = "select o from ProgressiveBilling o where o.account.accountId=? and o.stageNo=? order by o.scheduleId desc";
		List list = getHibernateTemplate().find(query, accountId,stageNo);
		if(list != null && !list.isEmpty()){
			pb = (ProgressiveBilling)list.get(0);
		}
		return pb;
	}
	
	
	@Override
	public boolean updateProgressiveBillingStatus(Long accountId, String to, String[] from, String[] stagesNos , Long txReversalId){
		
		String stageNoString ="";
		for (int i = 0; i < stagesNos.length; i++) {
			stageNoString = stageNoString+"'"+stagesNos[i]+"',";
		}
		stageNoString = stageNoString.substring(0, stageNoString.length()-1);
		
		String fString ="";
		for (int i = 0; i < from.length; i++) {
			fString = fString+"'"+from[i]+"',";
		}
		fString = fString.substring(0, fString.length()-1);
		
		 String hqlUpdate = "update ProgressiveBilling c set c.status = '"+to+"', c.txnReversalId = '"+txReversalId+"' where c.account.accountId ="+accountId+"  and c.stageNo in ("+stageNoString+") and c.status in ("+fString+") ";
		int i =  getHibernateTemplate().bulkUpdate(hqlUpdate);
		System.out.println(hqlUpdate+"\n--------------------------"+i);
		return true;
	}
	
	
	
	
	@Override
	public ProgressiveBilling findById(Long id) {
		return getHibernateTemplate().get(ProgressiveBilling.class, id);
	}

}
