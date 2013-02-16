package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.Project;

public interface ProjectDao extends Dao<Project> {

	
	public List<Project> findAll();
	public Project findById(Long id);
}
