package com.vipro.dao;

import com.vipro.common.Dao;
import com.vipro.data.CodeHeader;

public interface CodeDao extends Dao<CodeHeader> {

	public CodeHeader findById(String codeId);
}
