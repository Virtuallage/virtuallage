package com.vipro.service;

import java.util.List;

import com.vipro.data.Account;

public interface AccountService {

	public List<Account> findAll();
	public List<Account> findByProjectInventoryId(Long inventoryId);
	public List<Account> findByAvailableProjectInventoryId(Long inventoryId);
	public Account findById(Long accountId);
	public void insert(Account a);
	public void update(Account a);
	public void delete(Long accountId);
}
