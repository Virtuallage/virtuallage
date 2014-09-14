package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.BusinessPartner;
import com.vipro.data.TransactionCode;

/**
 * 
 * @author cvl
 *
 */
@SuppressWarnings("unchecked")
@Repository("com.vipro.dao.TransactionCodeDao")
public class TransactionCodeDaoImpl extends DaoImpl<TransactionCode> implements TransactionCodeDao {

	@Override
	public List<TransactionCode> findActiveTransactionCodes() {
		String query = "select o from TransactionCode o where o.status='SSACT' and o.manualEntry = 'Y' order by o.name";
		return getHibernateTemplate().find(query);
	}
	
	@Override
	public TransactionCode findByTC(String transactionCode) {
		List list = getHibernateTemplate().find(
                "from TransactionCode where transactionCode=? and status='SSACT'",transactionCode);
		if (list.size() == 0) {
			return null;
		}
		return (TransactionCode)list.get(0);
	}	

}
