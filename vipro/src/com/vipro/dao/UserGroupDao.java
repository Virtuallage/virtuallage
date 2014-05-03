package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.UserGroup;

/**
 * 
 * @author Sean
 *
 */
public interface UserGroupDao extends Dao<UserGroup>{

	public UserGroup findByGroupId(String groupId);
	
	public List<UserGroup> findAll();
}
