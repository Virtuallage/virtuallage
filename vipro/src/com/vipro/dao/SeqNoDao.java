package com.vipro.dao;

import com.vipro.common.Dao;
import com.vipro.data.SeqNo;

/**
 * 
 * @author cvl
 *
 */
public interface SeqNoDao extends Dao<SeqNo> {
	public SeqNo findById(String id);
	public void updateSeqNo(String id, Long seqNo);
	
}
