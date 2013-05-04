package com.vipro.dao;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.Address;

@Repository("com.vipro.dao.AddressDao")
public class AddressDaoImpl extends DaoImpl<Address> implements AddressDao {

	@Override
	public Address findById(Long addressId) {
		return getHibernateTemplate().get(Address.class, addressId);
	}

	@Override
	public Address findByCustomerId(Long customerId) {
		return getHibernateTemplate().get(Address.class, customerId);
	}
}
