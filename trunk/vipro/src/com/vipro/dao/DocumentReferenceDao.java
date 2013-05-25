package com.vipro.dao;

import java.util.List;

import com.vipro.common.Dao;
import com.vipro.data.DocumentReference;
import com.vipro.data.ProjectInventory;

public interface DocumentReferenceDao extends Dao<DocumentReference>{

	public DocumentReference findById(Long id);
	
	public List<DocumentReference> findByAccountIdAndDocType(Long accountId, String docType);
}
