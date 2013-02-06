package com.vipro.common;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 
 * @author cvl
 *
 * @param <S>
 */
public class DaoImpl<S> extends HibernateDaoSupport implements Dao<S> {

	@Autowired
	public void init(SessionFactory factory) {
	    setSessionFactory(factory);
	}
	
	@Override
	public void insert(S o) {
		getHibernateTemplate().saveOrUpdate(o);
		
	}

	@Override
	public void update(S o) {
		getHibernateTemplate().saveOrUpdate(o);
		
	}

	@Override
	public void delete(S o) {
		getHibernateTemplate().delete(o);
		
	}

}
