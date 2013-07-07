package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.Account;

public interface AccountDao extends Dao<Account> {


	public List<Account> findAll();
	public List<Account> findAllAvailable();
	public List<Account> findByProjectInventoryId(Long inventoryId);
	public List<Account> findByAvailableProjectInventoryId(Long inventoryId);
	public List<Account> findByUserId(Long userId);
	public List<Account> findByAvailableUserId(Long userId);
	public Account findById(Long accountId);
}
