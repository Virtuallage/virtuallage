package com.vipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vipro.dao.ProgressiveBillingDao;
import com.vipro.data.ProgressiveBilling;
import com.vipro.utils.spring.SpringBeanUtil;
import com.vipro.dto.*;
import com.vipro.data.*;

@Service("com.vipro.service.ProgressiveBillingService")
public class ProgressiveBillingServiceImpl implements ProgressiveBillingService {

	@Autowired
	private ProgressiveBillingDao progressiveBillingDao;

	public ProgressiveBillingDao getProgressiveBillingDao() {
		return progressiveBillingDao;
	}

	public void setProgressiveBillingDao(ProgressiveBillingDao progressiveBillingDao) {
		this.progressiveBillingDao = progressiveBillingDao;
	}

	@Override
	public List<ProgressiveBilling> getProgressiveBilling(Long accountId) {
		return progressiveBillingDao.findByAccountId(accountId);
	}

	@Override
	public void insert(ProgressiveBilling p) {
		progressiveBillingDao.insert(p);

	}

	@Override
	public void update(ProgressiveBilling p) {
		progressiveBillingDao.update(p);

	}

	@Override
	public void delete(Long id) {
		ProgressiveBilling o = progressiveBillingDao.findById(id);
		progressiveBillingDao.delete(o);

	}

	@Override
	@Transactional
	public void changeAddress(ChangeAddressDTO corDTO, Account account) {
		 AddressService adrService = (AddressService)SpringBeanUtil.lookup(AddressService.class.getName());
		 CustomerService cusService = (CustomerService)SpringBeanUtil.lookup(CustomerService.class.getName());
		 AccountService acctService = (AccountService)SpringBeanUtil.lookup(AccountService.class.getName());
		 
		 
		 if(corDTO.isCorrAddress()){
			 cusService.update(corDTO.getCustomer()); // update email address
			 adrService.update(corDTO.getAddress());
		
			 if(!corDTO.getCustomer().getCustomerId().equals(account.getCorrAddrCustId())){
				 account.setCorrAddrCustId(corDTO.getCustomer().getCustomerId());
				 acctService.update(account);
			 }
		 }
	}


}
