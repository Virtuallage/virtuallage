package com.vipro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.DocumentReference;
import com.vipro.data.ProjectInventory;

@Repository("com.vipro.dao.DocumentReferenceDao")
public class DocumentReferenceDaoImpl extends DaoImpl<DocumentReference> implements DocumentReferenceDao {

	@Override
	public DocumentReference findById(Long id) {

		return (DocumentReference) getHibernateTemplate().get(DocumentReference.class, id);
	}
	
	@Override
	public List<DocumentReference> findByAccountIdAndDocType(Long accountId, String docType) {
		String query = "select o from com.vipro.data.DocumentReference o where o.account.accountId=? and o.docType='" + docType + "'";
		return getHibernateTemplate().find(query, accountId);
	}

}
