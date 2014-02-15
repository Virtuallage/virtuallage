package com.vipro.dao;

import com.vipro.common.Dao;
import com.vipro.data.SeqNo;

/**
 * 
 * @author cvl
 *
 */
public interface SeqNoDao extends Dao<SeqNo> {
	public SeqNo findById(String seqType,String projectCode);
	public void updateSeqNo(String seqType, Long seqNo,String projectCode);
	
}
