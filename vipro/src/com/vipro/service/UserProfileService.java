package com.vipro.service;

import com.vipro.data.UserProfile;

public interface UserProfileService {

	
	public UserProfile findById(Long userId);
	
	public void insert(UserProfile up);
	
	public void update(UserProfile up);
	
	public void delete(Long userId);
}
