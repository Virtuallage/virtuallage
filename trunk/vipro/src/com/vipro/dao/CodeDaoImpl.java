package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.BillingModel;
import com.vipro.data.CodeDetId;
import com.vipro.data.CodeHeader;
import com.vipro.data.CodeDet;

@Repository("com.vipro.dao.CodeDao")
public class CodeDaoImpl extends DaoImpl<CodeHeader> implements CodeDao {

	@Override
	public CodeHeader findById(String codeId) {
		CodeHeader header = getHibernateTemplate().get(CodeHeader.class, codeId);
		return header;
	}
	
	@Override
	public CodeDet findByKey(CodeDetId Key) {
		CodeDet detail = getHibernateTemplate().get(CodeDet.class, Key);
		return detail;
	}

	@Override
	public List<CodeHeader> findAllCodeHeaders() {
		String query = " select o from CodeHeader order by o.codeHeaderId ";
		List<CodeHeader> list = getHibernateTemplate().find(query);
		return list;
//		return getHibernateTemplate().loadAll(CodeHeader.class);
	}
	
	@Override
	public List<CodeHeader> findAllHdrs() {
		String query = "select o from CodeHeader o ";
		return getHibernateTemplate().find(query);
	}
	
	@Override
	public List<CodeDet> findByHeaderId(String codeHeaderId) {
		String query = "select o from CodeDet o where o.codeHeader.codeHeaderId=?";
		return getHibernateTemplate().find(query, codeHeaderId);
	}

	@Override
	public List<CodeDet> findByHeaderId() {
		// TODO Auto-generated method stub
		return null;
	}


}
