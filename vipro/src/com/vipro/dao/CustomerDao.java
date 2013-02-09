package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.Customer;

public interface CustomerDao extends Dao<Customer> {

	public List<Customer> findByName(String name);
	
	public List<Customer> findByIdNo(String idNo);
	
	public Customer findById(Long custId);
}
