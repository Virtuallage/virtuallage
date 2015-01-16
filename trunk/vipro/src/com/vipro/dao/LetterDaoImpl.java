package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.Letter;

/**
 * 
 * @author Sean
 *
 */
@SuppressWarnings("unchecked")
@Repository("com.vipro.dao.Letter")
public class LetterDaoImpl extends DaoImpl<Letter> implements LetterDao {

	@Override
	public Letter findById(Long id) {
		return getHibernateTemplate().get(Letter.class, id);
	}
	
	@Override
	public List<Letter> findByProjectId(Long projectId) {
		String query = "select o from Letter o where o.project.projectId=?";
		return getHibernateTemplate().find(query, projectId);
	}

	@Override
	public List<Letter> findByProjectIdStatus(Long projectId, String status) {
		String query = "select o from Letter o where o.project.projectId=? and o.status=?";
		return getHibernateTemplate().find(query, projectId, status);
	}
	
	@Override
	public List<Letter> findAll() {
		String query = "select o from Letter o";
		return getHibernateTemplate().find(query);
	}

}
