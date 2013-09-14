package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.Account;
import com.vipro.data.SalesCommissionHistory;

@Repository("com.vipro.dao.SalesCommissionHistoryDao")
public class SalesCommissionHistoryDaoImpl extends DaoImpl<SalesCommissionHistory> implements SalesCommissionHistoryDao {

	@Override
	public List<SalesCommissionHistory> findByBatchNo(Long batchNo) {
		String query="select o from com.vipro.data.SalesCommissionHistory o where o.batchNo=?";
		List<SalesCommissionHistory> historys = getHibernateTemplate().find(query, batchNo);
		return historys;
	}
	
	@Override
	public List<SalesCommissionHistory> findByAccountId(Long accountId) {
		String query="select o from com.vipro.data.SalesCommissionHistory o where o.account.accountId=?";
		List<SalesCommissionHistory> historys = getHibernateTemplate().find(query, accountId);
		return historys;
	}
	
	@Override
	public List<SalesCommissionHistory> findAll() {
		String query="select o from com.vipro.data.SalesCommissionHistory o order by o.batchNo";
		return getHibernateTemplate().find(query);
	}

	@Override
	public SalesCommissionHistory findById(Long commissionId) {
		return getHibernateTemplate().get(SalesCommissionHistory.class, commissionId);
	}

}
