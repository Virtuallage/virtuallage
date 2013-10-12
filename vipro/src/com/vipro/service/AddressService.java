package com.vipro.service;

import com.vipro.data.Address;
import java.util.List;

public interface AddressService {

	public Address findById(Long addressId);
	public Address findByCustomerId(Long customerId);
	public List<Address> findAll();
	public void insert(Address a);
	public void update(Address a);
	public void delete(Long addrId);
}
