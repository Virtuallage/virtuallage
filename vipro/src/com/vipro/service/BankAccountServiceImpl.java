package com.vipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipro.dao.BankAccountDao;
import com.vipro.data.BankAccount;

@Service("com.vipro.service.BankAccountService")
public class BankAccountServiceImpl implements BankAccountService {
	@Autowired
	private BankAccountDao bankAccountDao;
	
	public BankAccountDao getBankAccountDao() {
		return bankAccountDao;
	}

	public void setBankAccountDao(BankAccountDao bankAccountDao) {
		this.bankAccountDao = bankAccountDao;
	}
	
	@Override
	public List<BankAccount> findAll() {
		return bankAccountDao.findAll();
	}
	
	@Override
	public List<BankAccount> findByProjectId(Long projectId) {
		return bankAccountDao.findByProjectId(projectId);
	}
	
	@Override
	public void insert(BankAccount a) {
		bankAccountDao.insert(a);
	}

	@Override
	public void update(BankAccount a) {
		bankAccountDao.update(a);
	}

	@Override
	public void delete(Long bankAccountId) {
		BankAccount a = bankAccountDao.findById(bankAccountId);
		bankAccountDao.delete(a);
	}

	@Override
	public BankAccount findById(Long bankAccountId) {
		return bankAccountDao.findById(bankAccountId);
	}

}
