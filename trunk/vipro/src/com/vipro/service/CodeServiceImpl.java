package com.vipro.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipro.dao.CodeDao;
import com.vipro.data.CodeDet;
import com.vipro.data.CodeHeader;

@Service("com.vipro.service.CodeService")
public class CodeServiceImpl implements CodeService {

	@Autowired
	private CodeDao codeDao;

	public CodeDao getCodeDao() {
		return codeDao;
	}

	public void setCodeDao(CodeDao codeDao) {
		this.codeDao = codeDao;
	}

	@Override
	public CodeHeader findById(String codeId) {
		return codeDao.findById(codeId);
	}

	@Override
	public List<SelectItem> getCodes(String codeId) {
		CodeHeader header = findById(codeId);
		List<SelectItem> items = new ArrayList<SelectItem>();

		if (header != null) {
			items.add( new SelectItem(null, "Select One"));

			Set<CodeDet> cds = header.getCodeDets();
			for (CodeDet cd : cds) {
				items.add( new SelectItem(cd.getId().getCode(), cd.getDescription()) );
			}
		}
		return items;
	}

}
