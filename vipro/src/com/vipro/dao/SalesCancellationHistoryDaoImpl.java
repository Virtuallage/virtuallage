package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.SalesCancellationHistory;

@Repository("com.vipro.dao.SalesCancellationHistoryDao")
public class SalesCancellationHistoryDaoImpl extends DaoImpl<SalesCancellationHistory> implements SalesCancellationHistoryDao {


	@Override
	public List<SalesCancellationHistory> findAll() {
		String query="select o from com.vipro.data.SalesCancellationHistory o";
		return getHibernateTemplate().find(query);
	}

	@Override
	public SalesCancellationHistory findById(Long cancellationId) {
		return getHibernateTemplate().get(SalesCancellationHistory.class, cancellationId);
	}

}
