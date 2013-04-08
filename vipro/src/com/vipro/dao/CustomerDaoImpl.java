package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.Customer;

@Repository("com.vipro.dao.CustomerDao")
@SuppressWarnings("unchecked")
public class CustomerDaoImpl extends DaoImpl<Customer> implements CustomerDao {

	
	@Override
	public List<Customer> findByIdNoName(String idNo, String name) {
		String query = "select o from Customer o where o.identityNo like ? and o.fullName like ?";
		List<Customer> list = getHibernateTemplate().find(query, "%" + idNo + "%", "%" + name + "%");
		return list;
	}

	@Override
	public List<Customer> findByIdNo(String idNo) {
		String query = "select o from Customer o where o.identityNo like ?";
		List<Customer> list = getHibernateTemplate().find(query, "%" + idNo + "%");
		return list;
	}

	@Override
	public Customer findById(Long custId) {
		return getHibernateTemplate().get(Customer.class, custId);
	}

}
