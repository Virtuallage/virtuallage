package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.CodeHeader;

public interface CodeDao extends Dao<CodeHeader> {

	public CodeHeader findById(String codeId);
	
	public List<CodeHeader> findAllCodeHeaders();
}
