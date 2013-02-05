package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.Dao;
import com.vipro.common.DaoImpl;
import com.vipro.constant.InstitutionStatusConst;
import com.vipro.data.Institution;

/**
 * 
 * @author cvl
 *
 */
@SuppressWarnings("unchecked")
@Repository("com.vipro.dao.InstitutionDao")
public class InstitutionDaoImpl extends DaoImpl<Institution> implements InstitutionDao {

	@Override
	public Institution findById(Long id) {
		Institution ins = getHibernateTemplate().get(Institution.class, id);
		return ins;
	}

	
	@Override
	public List<Institution> findAllActive() {
		String query = "select o from Institution o where o.status=?";
		List<Institution> list = getHibernateTemplate().find(query, InstitutionStatusConst.STATUS_ACTIVE);
		return list;
	}

	@Override
	public List<Institution> findAll() {
		String query = "select o from Institution o";
		List<Institution> list = getHibernateTemplate().find(query);
		return list;
	}

}
