package com.vipro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.vipro.dao.AddressDao;
import com.vipro.data.Address;

@Service("com.vipro.service.AddressService")
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressDao addressDao;
	
	
	public AddressDao getAddressDao() {
		return addressDao;
	}

	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	@Override
	public Address findById(Long addressId) {
		return addressDao.findById(addressId);
	}
	
	@Override
	public Address findByCustomerId(Long customerId) {
		return addressDao.findById(customerId);
	}
	
	@Override
	public List<Address> findAll() {
		return addressDao.findAll();
	}

	@Override
	public void insert(Address a) {
		addressDao.insert(a);
	}

	@Override
	public void update(Address a) {
		addressDao.update(a);
	}

	@Override
	public void delete(Long addrId) {
		Address a =addressDao.findById(addrId);
		addressDao.delete(a);
	}
	
}
