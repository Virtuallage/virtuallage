package com.vipro.dao;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.CodeHeader;

@Repository("com.vipro.dao.CodeDao")
public class CodeDaoImpl extends DaoImpl<CodeHeader> implements CodeDao {

	@Override
	public CodeHeader findById(String codeId) {
		CodeHeader header = getHibernateTemplate().get(CodeHeader.class, codeId);
		return header;
	}

}
