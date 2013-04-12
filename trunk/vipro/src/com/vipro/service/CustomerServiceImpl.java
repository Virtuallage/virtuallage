package com.vipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipro.dao.CustomerDao;
import com.vipro.data.Customer;

@Service("com.vipro.service.CustomerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> findByIdNo(String idNo) {
		return customerDao.findByIdNo(idNo);
	}

	@Override
	public List<Customer> findByIdNoName(String idNo, String name) {
		return customerDao.findByIdNoName(idNo, name);
	}

	@Override
	public void insert(Customer c) {
		customerDao.insert(c);
		
	}

	@Override
	public void delete(Long custId) {
		Customer c = customerDao.findById(custId);
		customerDao.delete(c);
		
	}

	@Override
	public void update(Customer c) {
		customerDao.update(c);
	}
	
	@Override
	public Customer findByCustId(Long custId) {
		return customerDao.findById(custId);
	}
	
}
