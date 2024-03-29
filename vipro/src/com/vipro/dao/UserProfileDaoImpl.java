package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.UserGroup;
import com.vipro.data.UserProfile;

/**
 * 
 * @author cvl
 *
 */
@SuppressWarnings("unchecked")
@Repository("com.vipro.dao.UserProfileDao")
public class UserProfileDaoImpl extends DaoImpl<UserProfile> implements UserProfileDao {

	
	@Override
	public UserProfile findByUsername(String username) {
		String query = "select o from UserProfile o where o.username=?";
		List<UserProfile> list = getHibernateTemplate().find(query, username);
		if (list!=null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public UserProfile findByUserId(Long userId) {
		UserProfile up = getHibernateTemplate().get(UserProfile.class, userId);
		return up;
	}

	@Override
	public List<UserProfile> findAll() {
		String query = "select o from UserProfile o";
		return getHibernateTemplate().find(query);
	}

	@Override
	public List<UserProfile> findActiveUsers() {
		String query = "select o from UserProfile o where o.status='SSACT' order by o.name";
		return getHibernateTemplate().find(query);
	}

	public List<UserProfile> findByGroup(UserGroup usergroup) {
		String query = "select o from UserProfile o where o.userGroup=? order by o.username";
		return getHibernateTemplate().find(query, usergroup);
	}
}
