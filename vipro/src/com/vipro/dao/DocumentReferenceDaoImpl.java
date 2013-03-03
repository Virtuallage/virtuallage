package com.vipro.dao;

import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.DocumentReference;

@Repository("com.vipro.dao.DocumentReferenceDao")
public class DocumentReferenceDaoImpl extends DaoImpl<DocumentReference> implements DocumentReferenceDao {

	@Override
	public DocumentReference findById(Long id) {

		return (DocumentReference) getHibernateTemplate().get(DocumentReference.class, id);
	}

}
