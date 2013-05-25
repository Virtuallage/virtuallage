package com.vipro.service;

import java.util.List;

import com.vipro.data.DocumentReference;

public interface DocumentReferenceService {

	
	public DocumentReference findById(Long id);
	public List<DocumentReference> findByAccountIdAndDocType(Long accountId, String docType);
	public void insert(DocumentReference doc);
	public void update(DocumentReference doc);
	public void delete(Long id);
}
