package com.vipro.service;

import java.util.List;

import javax.faces.model.SelectItem;

import com.vipro.data.CodeDet;
import com.vipro.data.CodeHeader;

public interface CodeService {
	
	public CodeHeader findById(String codeId);
	
	public List<SelectItem> getCodes(String codeId);
	
	public List<SelectItem> getCodeHeaders();
	
	public List<CodeDet> getCodeDetailList(String codeId);

}
