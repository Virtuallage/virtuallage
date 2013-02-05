package com.vipro.service;

import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

import com.vipro.data.CodeHeader;

public interface CodeService {
	
	public CodeHeader findById(String codeId);
	
	public List<SelectItem> getCodes(String codeId);

}
