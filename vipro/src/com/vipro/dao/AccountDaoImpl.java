package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.constant.AccountStatusConst;
import com.vipro.data.Account;
import com.vipro.data.BusinessPartner;
import com.vipro.data.Project;

@Repository("com.vipro.dao.AccountDao")
public class AccountDaoImpl extends DaoImpl<Account> implements AccountDao {


	@Override
	public List<Account> findAll() {
		String query="select o from com.vipro.data.Account o";
		return getHibernateTemplate().find(query);
	}

	@Override
	public List<Account> findByProjectInventoryId(Long inventoryId) {
		String query="select o from com.vipro.data.Account o where o.projectInventory.inventoryId=?";
		List<Account> acc = getHibernateTemplate().find(query, inventoryId);
		return acc;
	}
	
	@Override
	public List<Account> findByAvailableProjectInventoryId(Long inventoryId) {
		String query="select o from com.vipro.data.Account o where o.projectInventory.inventoryId=? and o.accountStatus='"
				+ AccountStatusConst.STATUS_ACTIVE + "'";
		List<Account> acc = getHibernateTemplate().find(query, inventoryId);
		return acc;
	}

	@Override
	public Account findById(Long accountId) {
		return getHibernateTemplate().get(Account.class, accountId);
	}

}
