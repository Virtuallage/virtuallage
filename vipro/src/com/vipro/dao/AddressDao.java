package com.vipro.dao;

import com.vipro.common.Dao;
import com.vipro.data.Address;
import java.util.List;

public interface AddressDao extends Dao<Address>{

	public Address findById(Long addressId);
	
	public Address findByCustomerId(Long customerId);
	
	public List<Address> findAll();
}
