package com.vipro.service;

import java.util.ArrayList;
import java.util.List;
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

		items.add( new SelectItem(null, "Select One"));
		if (header != null) {
			//items.add( new SelectItem(null, "Select One"));

			Set<CodeDet> cds = header.getCodeDets();
			for (CodeDet cd : cds) {
				items.add( new SelectItem(cd.getId().getCode(), cd.getDescription()) );
			}
		}
		return items;
	}
	
	@Override
	public List<SelectItem> getCodeHeaders() {
		List<CodeHeader> codeHeaderList = codeDao.findAllCodeHeaders();
		List<SelectItem> items = new ArrayList<SelectItem>();
		
		if (codeHeaderList != null && codeHeaderList.size() > 0) {
			items.add( new SelectItem(null, "Select One"));
			for (CodeHeader codeHeader : codeHeaderList) {
				items.add( new SelectItem(codeHeader.getCodeHeaderId(), codeHeader.getName()) );
			}
		}
		return items;
	}
	
	@Override
	public List<CodeDet> getCodeDetailList(String codeId) {
		if (codeId != null && !codeId.equals("")) {
			CodeHeader header = findById(codeId);
			if (header != null)  {
				Set<CodeDet> map = header.getCodeDets();
				if (map != null) {
					return new ArrayList<CodeDet>(map);
				}
			}
		} else {
			// find codeDet for all codeHeader if codeId is null
			List<CodeHeader> codeHeaderList = codeDao.findAllCodeHeaders();
			List<CodeDet> codeDetList = new ArrayList<CodeDet>();
			for (CodeHeader codeHeader : codeHeaderList) {
				Set<CodeDet> map = codeHeader.getCodeDets();
				if (map != null) {
					List<CodeDet> tempList = new ArrayList<CodeDet>(map);
					codeDetList.addAll(tempList);
				}
			}
			return codeDetList;
		}
		return null;
	}

}
