package com.vipro.service;

import java.util.List;

import com.vipro.data.Customer;

public interface CustomerService {

	public List<Customer> findByIdNo(String idNo);
	
	public List<Customer> findByIdNoName(String idNo, String name);

	public List<Customer> findByIdNoNameCategory(String idNo, String name, String category);
	
	public void insert(Customer c);
	
	public void delete(Long custId);
	
	public void update(Customer c);
	
	public Customer findByCustId(Long custId);
}
