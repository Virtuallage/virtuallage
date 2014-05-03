package com.vipro.service;

import java.util.List;

import com.vipro.data.UserGroup;
import com.vipro.data.UserProfile;

/**
 * 
 * @author cvl
 *
 */
public interface UserProfileService {

	
	public UserProfile findById(Long userId);

	public UserProfile findByUsername(String username);
	
	public List<UserProfile> findAll();

	public List<UserProfile> findActiveUsers();	
		
	public List<UserProfile> findByGroup(UserGroup usergroup);

	public void insert(UserProfile up);
	
	public void update(UserProfile up);
	
	public void delete(Long userId);
}
