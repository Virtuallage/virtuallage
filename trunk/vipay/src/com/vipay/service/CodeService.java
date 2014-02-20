package com.vipay.service;

import java.util.List;

import javax.faces.model.SelectItem;
import com.vipro.data.CodeDet;
import com.vipro.data.CodeHeader;

public interface CodeService {
	
	public CodeHeader findById(String codeId);
	
	public List<SelectItem> getCodes(String codeId);
	
	public List<SelectItem> getCodeHeaders();
	
	public List<CodeDet> getCodeDetailList(String codeId);
	
	public List<CodeHeader> findAllCodeHdrs();
	
	public void insert(CodeHeader h);
	public void update(CodeHeader h);
	public void deleteCodeHeader(String codeHeaderId);
	
	public List<CodeDet> getCodeDets(Long codeHeaderId);
	public void insert(CodeDet d);
	public void update(CodeDet d);
	public void deleteCodeDet(String codeHeaderId, String code);

	public List<CodeDet> getCodeDets(String codeHeaderId);
}
