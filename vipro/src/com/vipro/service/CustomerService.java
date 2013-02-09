package com.vipro.service;

import java.util.List;

import com.vipro.data.Customer;

public interface CustomerService {

	public List<Customer> findByIdNo(String idNo);
	
	public List<Customer> findByName(String name);
	
	public void insert(Customer c);
	
	public void delete(Long custId);
	
	public void update(Customer c);
}
