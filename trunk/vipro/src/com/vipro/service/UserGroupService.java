package com.vipro.service;

import java.util.List;

import com.vipro.data.UserGroup;

/**
 * 
 * @author Sean
 *
 */
public interface UserGroupService {
	
	public UserGroup findById(String groupId);
	
	public List<UserGroup> findAll();

	public void insert(UserGroup ug);
	
	public void update(UserGroup ug);
	
	public void delete(String groupId);
}
