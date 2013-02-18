package com.vipro.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.Discount;

@Repository("com.vipro.dao.DiscountDao")
public class DiscountDaoImpl extends DaoImpl<Discount> implements DiscountDao {

	@Override
	public List<Discount> findByProjectId(Long projectId) {
		String query = "select o from Discount o where o.project.projectId=?";
		return getHibernateTemplate().find(query, projectId);
	}

	@Override
	public Discount findById(Long id) {
		return getHibernateTemplate().get(Discount.class, id);
	}

	@Override
	public Discount findCurrentEffectiveDiscount(Long projectId) {
		String query = "select o from Discount o where  o.effectiveDate <=? and o.expiryDate >=? order by o.effectiveDate";
		Date d = new Date();
		List<Discount> list = getHibernateTemplate().find(query, d,d);
		if (list!=null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}

}
