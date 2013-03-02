package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.TransactionHistory;

@Repository("com.vipro.dao.TransactionHistoryDao")
public class TransactionHistoryDaoImpl extends DaoImpl<TransactionHistory> implements TransactionHistoryDao {

	@Override
	public List<TransactionHistory> findByAccountId(Long accountId) {
		String query = "select o from TransactionHistory o where o.account.accountId=?";
		return getHibernateTemplate().find(query, accountId);
	}

	@Override
	public TransactionHistory findById(Long id) {
		return getHibernateTemplate().get(TransactionHistory.class, id);
	}

}
