package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.Account;
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
	
	@Override
	public List<Address> findAll() {
		String query="select o from com.vipro.data.Address o";
		return getHibernateTemplate().find(query);
	}

}
