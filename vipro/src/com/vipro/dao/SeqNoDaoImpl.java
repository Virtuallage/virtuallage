package com.vipro.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
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

	@SuppressWarnings("unchecked")
	@Override
	public SeqNo findById(String seqType, String projectCode) {		
		StringBuilder  query = new StringBuilder(" from SeqNo where seqType=? ");
		if (!StringUtils.isEmpty(projectCode)){
			query.append(" and upper(projectCode)='"+ projectCode.trim().toUpperCase()+"'");
		}
				
		List<SeqNo> list =  getHibernateTemplate().find(query.toString(), seqType);
		if (list != null && list.size()>0) {
			return list.get(0);
		}
		return null;
		
	}

	
	@Override
	public void updateSeqNo(String seqType, Long seqNo,String projectCode) {
		SeqNo ins = findById(seqType, projectCode);
		ins.setNextSeq(seqNo);
		getHibernateTemplate().update(ins);
	}
}
