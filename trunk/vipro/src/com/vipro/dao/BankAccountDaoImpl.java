package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.constant.AccountStatusConst;
import com.vipro.data.BankAccount;
import com.vipro.data.BillingModel;

@Repository("com.vipro.dao.BankAccountDao")
public class BankAccountDaoImpl extends DaoImpl<BankAccount> implements BankAccountDao {

	@Override
	public List<BankAccount> findAll() {
		String query="select o from com.vipro.data.BankAccount o where o.status='" 
				+ AccountStatusConst.STATUS_ACTIVE + "'";
		return getHibernateTemplate().find(query);
	}
	
	@Override
	public List<BankAccount> findByProjectId(Long projectId) {
		String query="select o from BankAccount o where o.project.projectId=? "
				+ "and o.status='"+AccountStatusConst.STATUS_ACTIVE + "'";
		return getHibernateTemplate().find(query, projectId);
	}
	
	@Override
	public BankAccount findById(Long bankAccountId) {
		return getHibernateTemplate().get(BankAccount.class, bankAccountId);
	}
	
}
