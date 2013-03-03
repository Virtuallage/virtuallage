package com.vipro.service;

import com.vipro.data.DocumentReference;

public interface DocumentReferenceService {

	
	public DocumentReference findById(Long id);
	public void insert(DocumentReference doc);
	public void update(DocumentReference doc);
	public void delete(Long id);
}
