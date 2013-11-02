package com.vipro.dao;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.SeqNo;

/**
 * 
 * @author cvl
 *
 */
@Repository("com.vipro.dao.SeqNoDao")
public class SeqNoDaoImpl extends DaoImpl<SeqNo> implements SeqNoDao {

	@Override
	public SeqNo findById(String id) {
		SeqNo ins = getHibernateTemplate().get(SeqNo.class, id);
		return ins;
	}

	
	@Override
	public void updateSeqNo(String id, Long seqNo) {
		SeqNo ins = getHibernateTemplate().get(SeqNo.class, id);
		ins.setNextSeq(seqNo);
		getHibernateTemplate().update(ins);
	}
}
