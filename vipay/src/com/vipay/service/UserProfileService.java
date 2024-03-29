package com.vipay.service;

import java.util.List;

import com.vipro.data.UserProfile;

/**
 * 
 * @author cvl
 *
 */
public interface UserProfileService {

	
	public UserProfile findById(Long userId);
	
	public List<UserProfile> findAll();
	
	public void insert(UserProfile up);
	
	public void update(UserProfile up);
	
	public void delete(Long userId);
}
