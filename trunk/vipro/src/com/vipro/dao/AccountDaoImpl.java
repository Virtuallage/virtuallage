package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.Account;

@Repository("com.vipro.dao.AccountDao")
public class AccountDaoImpl extends DaoImpl<Account> implements AccountDao {



	@Override
	public List<Account> findByProjectInventoryId(Long inventoryId) {
		String query="select o from com.vipro.data.Account o where o.projectInventory.inventoryId=?";
		List<Account> acc = getHibernateTemplate().find(query, inventoryId);
		return acc;
	}

	@Override
	public Account findById(Long accountId) {
		return getHibernateTemplate().get(Account.class, accountId);
	}

}
