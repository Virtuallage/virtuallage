package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.UserGroup;

/**
 * 
 * @author Sean
 *
 */
@SuppressWarnings("unchecked")
@Repository("com.vipro.dao.UserGroupDao")
public class UserGroupDaoImpl extends DaoImpl<UserGroup> implements UserGroupDao {

	@Override
	public UserGroup findByGroupId(String groupId) {
		UserGroup ug = getHibernateTemplate().get(UserGroup.class, groupId);
		return ug;
	}

	@Override
	public List<UserGroup> findAll() {
		String query = "select o from UserGroup o";
		return getHibernateTemplate().find(query);
	}

}
