package com.vipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipro.dao.UserGroupDao;
import com.vipro.data.UserGroup;

/**
 * 
 * @author Sean
 *
 */
@Service("com.vipro.service.UserGroupService")
public class UserGroupServiceImpl implements UserGroupService {

	@Autowired
	private UserGroupDao userGroupDao;


	public UserGroupDao getUserGroupDao() {
		return userGroupDao;
	}

	public void setUserGroupDao(UserGroupDao userGroupDao) {
		this.userGroupDao = userGroupDao;
	}

	@Override
	public UserGroup findById(String groupId) {
		UserGroup ug = userGroupDao.findByGroupId(groupId);
		return ug;
	}

	@Override
	public void insert(UserGroup ug) {
		userGroupDao.insert(ug);
	}

	@Override
	public void update(UserGroup ug) {
		userGroupDao.update(ug);
	}

	@Override
	public void delete(String groupId) {
		UserGroup ug = findById(groupId);
		userGroupDao.delete(ug);
	}

	@Override
	public List<UserGroup> findAll() {
		return userGroupDao.findAll();
	}
	
}
