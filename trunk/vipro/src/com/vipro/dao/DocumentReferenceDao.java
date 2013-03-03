package com.vipro.dao;

import com.vipro.common.Dao;
import com.vipro.data.DocumentReference;

public interface DocumentReferenceDao extends Dao<DocumentReference>{

	public DocumentReference findById(Long id);
}
