package com.vipro.service;

import java.util.List;

import com.vipro.data.BankAccount;

public interface BankAccountService {

	public List<BankAccount> findAll();
	public List<BankAccount> findByProjectId(Long projectId);
	public BankAccount findById(Long bankAccountId);
	public void insert(BankAccount a);
	public void update(BankAccount a);
	public void delete(Long bankAccountId);
}
