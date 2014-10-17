package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.BankAccount;

public interface BankAccountDao extends Dao<BankAccount> {

	public List<BankAccount> findAll();
	public List<BankAccount> findByProjectId(Long projectId);
	public BankAccount findById(Long bankAccountId);
}
