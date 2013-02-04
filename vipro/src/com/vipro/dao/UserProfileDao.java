package com.vipro.dao;

import com.vipro.common.Dao;
import com.vipro.data.UserProfile;

/**
 * 
 * @author cvl
 *
 */
public interface UserProfileDao extends Dao<UserProfile>{

	public UserProfile findByUsername(String username);
	
	public UserProfile findByUserId(Long userId);
}
