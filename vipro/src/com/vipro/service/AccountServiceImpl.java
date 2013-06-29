package com.vipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipro.dao.AccountDao;
import com.vipro.data.Account;

@Service("com.vipro.service.AccountService")
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDao accountDao;
	
	
	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	@Override
	public List<Account> findAll() {
		return accountDao.findAll();
	}

	@Override
	public List<Account> findByProjectInventoryId(Long inventoryId) {
		return accountDao.findByProjectInventoryId(inventoryId);
	}
	
	@Override
	public List<Account> findByUserId(Long userId) {
		return accountDao.findByUserId(userId);
	}
	
	@Override
	public List<Account> findByAvailableProjectInventoryId(Long inventoryId) {
		return accountDao.findByAvailableProjectInventoryId(inventoryId);
	}

	@Override
	public void insert(Account a) {
		accountDao.insert(a);
		
	}

	@Override
	public void update(Account a) {
		accountDao.update(a);
		
	}

	@Override
	public void delete(Long accountId) {
		Account a = accountDao.findById(accountId);
		accountDao.delete(a);
		
	}

	@Override
	public Account findById(Long accountId) {
		return accountDao.findById(accountId);
	}

}
