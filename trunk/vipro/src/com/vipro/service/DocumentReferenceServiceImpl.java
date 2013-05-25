package com.vipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipro.dao.DocumentReferenceDao;
import com.vipro.data.DocumentReference;

@Service("com.vipro.service.DocumentReferenceService")
public class DocumentReferenceServiceImpl implements DocumentReferenceService {

	@Autowired
	private DocumentReferenceDao documentReferenceDao;

	public DocumentReferenceDao getDocumentReferenceDao() {
		return documentReferenceDao;
	}

	public void setDocumentReferenceDao(
			DocumentReferenceDao documentReferenceDao) {
		this.documentReferenceDao = documentReferenceDao;
	}

	@Override
	public DocumentReference findById(Long id) {
		return documentReferenceDao.findById(id);
	}
	
	@Override
	public List<DocumentReference> findByAccountIdAndDocType(Long accountId, String docType) {
		return documentReferenceDao.findByAccountIdAndDocType(accountId, docType);
	}

	@Override
	public void insert(DocumentReference doc) {
		documentReferenceDao.insert(doc);

	}

	@Override
	public void update(DocumentReference doc) {
		documentReferenceDao.update(doc);

	}

	@Override
	public void delete(Long id) {
		DocumentReference r = documentReferenceDao.findById(id);
		documentReferenceDao.delete(r);

	}

}
