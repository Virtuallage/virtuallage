package com.vipro.service;

import com.vipro.dao.UserProfileDao;
import com.vipro.data.UserProfile;

public class UserProfileServiceImpl implements UserProfileService {

	private UserProfileDao userProfileDao;

	public UserProfileDao getUserProfileDao() {
		return userProfileDao;
	}

	public void setUserProfileDao(UserProfileDao userProfileDao) {
		this.userProfileDao = userProfileDao;
	}

	@Override
	public UserProfile findById(Long userId) {
		UserProfile up = userProfileDao.findByUserId(userId);
		return up;
	}

	@Override
	public void insert(UserProfile up) {
		userProfileDao.insert(up);
	}

	@Override
	public void update(UserProfile up) {
		userProfileDao.update(up);
		
	}

	@Override
	public void delete(Long userId) {
		UserProfile up = findById(userId);
		userProfileDao.delete(up);
		
	}

}
