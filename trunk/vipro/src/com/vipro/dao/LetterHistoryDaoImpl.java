package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.LetterHistory;

/**
 * 
 * @author Sean
 *
 */
@SuppressWarnings("unchecked")
@Repository("com.vipro.dao.LetterHistory")
public class LetterHistoryDaoImpl extends DaoImpl<LetterHistory> implements LetterHistoryDao {

	@Override
	public LetterHistory findById(Long id) {
		return getHibernateTemplate().get(LetterHistory.class, id);
	}
	
	@Override
	public List<LetterHistory> findByLetterIdAccount(Long letterId, Long accountId) {
		String query = "select o from LetterHistory o where o.letter.letterId=? and "
				+ "o.account.accountId=?";
		return getHibernateTemplate().find(query, letterId, accountId);
	}

	@Override
	public List<LetterHistory> findByAccount(Long accountId) {
		String query = "select o from LetterHistory o where o.account.accountId=?";
		return getHibernateTemplate().find(query, accountId);
	}

	@Override
	public List<LetterHistory> findAll() {
		String query = "select o from LetterHistory o";
		return getHibernateTemplate().find(query);
	}

}
