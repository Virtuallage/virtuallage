package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.UserGroup;
import com.vipro.data.UserProfile;

/**
 * 
 * @author cvl
 *
 */
public interface UserProfileDao extends Dao<UserProfile>{

	public UserProfile findByUsername(String username);
	
	public UserProfile findByUserId(Long userId);
	
	public List<UserProfile> findAll();
	
	public List<UserProfile> findActiveUsers();
	
	public List<UserProfile> findByGroup(UserGroup usergroup); 
}
