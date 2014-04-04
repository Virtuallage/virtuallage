package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.CodeDetId;
import com.vipro.data.CodeHeader;
import com.vipro.data.CodeDet;

public interface CodeDao extends Dao<CodeHeader> {

	public CodeHeader findById(String codeId);
	
	public CodeDet findByKey(CodeDetId Key);
	
	public List<CodeHeader> findAllCodeHeaders();
	
	public List<CodeHeader> findAllHdrs();
	
	public List<CodeDet> findByHeaderId();

	public List<CodeDet> findByHeaderId(String codeHeaderId);
}
