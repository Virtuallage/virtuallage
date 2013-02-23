package com.vipro.dao;

import com.vipro.common.Dao;
import com.vipro.data.Address;

public interface AddressDao extends Dao<Address>{

	public Address findById(Long addressId);
}
