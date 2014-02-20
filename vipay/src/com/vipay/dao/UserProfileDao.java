package com.vipay.dao;

import java.util.List;

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
	
	public List<UserProfile> findAll();
}
