package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.constant.TransactionStatusConst;
import com.vipro.data.ProgressiveBilling;
import com.vipro.data.TransactionHistory;

@SuppressWarnings("unchecked")
@Repository("com.vipro.dao.TransactionHistoryDao")
public class TransactionHistoryDaoImpl extends DaoImpl<TransactionHistory> implements TransactionHistoryDao {

	@Override
	public List<TransactionHistory> findByAccountId(Long accountId) {
		String query = "select o from TransactionHistory o where o.account.accountId=? order by o.transactionDate, o.invoiceNo";
		return getHibernateTemplate().find(query, accountId);
	}
	
	@Override
	public List<TransactionHistory> findTransactionHistoryByAccountIdAndTcode(
			Long accountId, String transactionCode,String transactionCode2,String transactionCode3) {
		String query = "select o from TransactionHistory o where o.account.accountId=? and (o.transactionCode.transactionCode =? or o.transactionCode.transactionCode =? or o.transactionCode.transactionCode =?) and o.status in (?,?)";
		return getHibernateTemplate().find(query, accountId, transactionCode, transactionCode2, transactionCode3,
				TransactionStatusConst.PENDING, TransactionStatusConst.POSTED);
	}
	
	@Override
	public TransactionHistory findByAccountIdInvoiceNo(Long accountId, String invoiceNo){
		TransactionHistory txnHis = new TransactionHistory();
		
		String query = "select o from TransactionHistory o where o.account.accountId=? and o.invoiceNo =? and o.txnReversalId is NULL";
		@SuppressWarnings("rawtypes")
		List list = getHibernateTemplate().find(query, accountId,invoiceNo);
		if(list != null && !list.isEmpty()){
			txnHis = (TransactionHistory)list.get(0);
		}
		return txnHis;
	}

	@Override
	public TransactionHistory findById(Long id) {
		return getHibernateTemplate().get(TransactionHistory.class, id);
	}

}
