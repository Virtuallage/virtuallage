package com.vipro.service;

import com.vipro.data.Address;

public interface AddressService {

	public Address findById(Long addressId);
	public void insert(Address a);
	public void update(Address a);
	public void delete(Long addrId);
}
