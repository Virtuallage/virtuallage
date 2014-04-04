package com.vipro.jsf.bean.setup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.vipro.constant.CommonConst;
import com.vipro.data.CodeDetId;
import com.vipro.data.CodeDet;
import com.vipro.data.CodeHeader;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.service.CodeService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.SpringBeanUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

@ManagedBean(name="commonCode")
@SessionScoped
public class CommonCodeSetup extends CommonBean implements Serializable{

	private String codeType;
	
	private CodeHeader codeHeaderFld;
	private CodeDet codeDetFld;
	private CodeDet codeDetFld1;
	private CodeDetId codeDetIdFld;
	private List<SelectItem> listCodeType;
	private List<SelectItem> listCodeTypeOnly;
	private List<SelectItem> listStatus;
	private Set<CodeDet> setcodeDet = new HashSet<CodeDet>();

	private List<CodeHeader> listCodeHeaders;
	private List<CodeDet> listCodeDets;
	
	
	@PostConstruct
	public void init() {
		setListStatus(CodeUtil.getCodes("SS"));
//		listCodeType = CodeUtil.getCodeHeaders();
//		listCodeType.set(0, new SelectItem(null, "Select All"));
//		listCodeTypeOnly = getCodeTypeOnly();
		RefreshCodeType();
	}

	public List<SelectItem> getCodeTypeOnly() {
		List<SelectItem> listItems = new ArrayList<SelectItem>();
		for (SelectItem Item : listCodeType) {
			if (Item.getValue() == null) {
				listItems.add( new SelectItem(Item.getValue(), Item.getLabel(), "") );
			} else {
				listItems.add( new SelectItem(Item.getValue(), Item.getValue().toString(), Item.getLabel()) );
			}
		}
		return listItems;
	}

	public String LookupDesc(String value) {   
	    for (SelectItem item : listCodeType) {   
	        if ( value.equals(item.getValue()) ) {   
	             return item.getLabel();   
	        }  
	     }
	    throw new RuntimeException("Please input Description for '" + value + "'"); 
	}  

	public void getDesc() {   
	    codeHeaderFld.setName(LookupDesc(codeDetFld.getCodeHeaderId()));   
	}  
	
	public void RefreshCodeType() {
		listCodeType = CodeUtil.getCodeHeaders();
		listCodeTypeOnly = getCodeTypeOnly();
		listCodeType.set(0, new SelectItem(null, "Select All"));
	}
	
	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public CodeHeader getCodeHeaderFld() {
		return codeHeaderFld;
	}

	public void setCodeHeaderFld(CodeHeader codeHeaderFld) {
		this.codeHeaderFld = codeHeaderFld;
	}


//	public HashSet<CodeDet> getCodeDet() {
//		return codeDet;
//	}

//	public void setCodeDet(HashSet<CodeDet> codeDet) {
//		this.codeDet = codeDet;
//	}

	public List<SelectItem> getListCodeType() {
		return listCodeType;
	}

	public void setListCodeType(List<SelectItem> listCodeType) {
		this.listCodeType = listCodeType;
	}

	public List<SelectItem> getListStatus() {
		return listStatus;
	}

	public void setListStatus(List<SelectItem> listStatus) {
		this.listStatus = listStatus;
	}

	public CodeDet getCodeDetFld() {
		return codeDetFld;
	}

	public void setCodeDetFld(CodeDet codeDetFld) {
		this.codeDetFld = codeDetFld;
	}

	public Set<CodeDet> getSetcodeDet() {
		return setcodeDet;
	}

	public void setSetcodeDet(Set<CodeDet> setcodeDet) {
		this.setcodeDet = setcodeDet;
	}

	public List<CodeHeader> getListCodeHeaders() {
		return listCodeHeaders;
	}

	public void setListCodeHeaders(List<CodeHeader> listCodeHeaders) {
		this.listCodeHeaders = listCodeHeaders;
	}

	public List<CodeDet> getListCodeDets() {
		return listCodeDets;
	}

	public void setListCodeDets(List<CodeDet> listCodeDets) {
		this.listCodeDets = listCodeDets;
	}

	public List<SelectItem> getListCodeTypeOnly() {
		return listCodeTypeOnly;
	}

	public void setListCodeTypeOnly(List<SelectItem> listCodeTypeOnly) {
		this.listCodeTypeOnly = listCodeTypeOnly;
	}

	public String searchCommonCode() {

		codeHeaderFld = new CodeHeader();
		codeDetFld = new CodeDet();
		List<CodeDet> listCodeDets = new ArrayList<CodeDet>();

		CodeService commoncode = (CodeService) SpringBeanUtil
				.lookup(CodeService.class.getName());

		if (StringUtils.hasText(codeType)) {
			setListCodeDets(commoncode.getCodeDetailList(codeType));
		} else {
			setListCodeHeaders(commoncode.findAllCodeHdrs());

//			System.out.println(listCodeHeaders.size());
			Iterator itr = listCodeHeaders.iterator();

			for(int i=0; i<listCodeHeaders.size(); i++) {
				codeHeaderFld = listCodeHeaders.get(i);
				setcodeDet = codeHeaderFld.getCodeDets();

				Iterator it = setcodeDet.iterator();

				while(it.hasNext()) {
					codeDetFld = (CodeDet)it.next();
					listCodeDets.add(codeDetFld);
				}
			}
			setListCodeDets(listCodeDets);
		}
		return "listCommonCode";
	}

	public String LoadCodeHeader() {
		
		codeDetFld.setCodeHeaderId(codeDetFld.getId().getCodeHeaderId());
		codeDetFld.setCode(codeDetFld.getId().getCode());
		codeHeaderFld.setName(LookupDesc(codeDetFld.getCodeHeaderId()));

		return "editCodeDet";
	}

	public String NewCodeHeader() {
		codeHeaderFld = new CodeHeader();
		return "addCodeHeader";
	}

	public String NewCodeDet() {
		
		codeHeaderFld = new CodeHeader();
		codeDetFld = new CodeDet();
		codeDetFld.setStatus(CommonConst.STATUS_ACTIVE);
		return "addCodeDet";
	}

	public String backTolistCommonCode() {
		return "listCommonCode";
	}

	public String UpdateCodeDet() {
		try {
			CodeService codeService = (CodeService) SpringBeanUtil
					.lookup(CodeService.class.getName());
			
			String codeheaderid = codeDetFld.getCodeHeaderId();
			codeHeaderFld.setCodeHeaderId(codeheaderid);
			String name = codeHeaderFld.getName();
			codeHeaderFld.setName(name);
			
			codeService.update(codeHeaderFld);

			codeDetIdFld = new CodeDetId();
			codeHeaderFld = new CodeHeader();
			codeDetIdFld.setCodeHeaderId(codeDetFld.getCodeHeaderId());
			codeDetIdFld.setCode(codeDetFld.getCode().toUpperCase());
			codeDetFld.setId(codeDetIdFld);
			
			codeService.update(codeDetFld);
			
		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("Edit Common Code Type", t.getMessage());
			return null;
		}

		RefreshCodeType();
		addInfoMessage("Record Saved", "Common Code Type information saved successfully.");
		
		return "listCommonCode";
	}

	public String InsertCodeHeader() {
		try {				
			CodeService commoncode = (CodeService) SpringBeanUtil
					.lookup(CodeService.class.getName());
			
			String codeheaderid = codeHeaderFld.getCodeHeaderId();
			System.out.println(codeheaderid);
			codeHeaderFld.setCodeHeaderId(codeheaderid.toUpperCase());
			String name = codeHeaderFld.getName();
			codeHeaderFld.setName(name.toUpperCase());
			
			// Check if Code Type exists
			CodeHeader codeHeaderFld1 = new CodeHeader();	
			codeHeaderFld1 = commoncode.findById(codeheaderid);

   			if (codeHeaderFld1 != null) {
				addErrorMessage("Add New Code Type",
						"Common Code Type : " + codeheaderid.toUpperCase() + " already existed." );
				return null;
	        }

			commoncode.insert(codeHeaderFld);

		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("Add Common Code Type", t.getMessage());
			return null;
		}

		RefreshCodeType();
		addInfoMessage("Record Saved", "Common Code Type information saved successfully.");
		
		return "listCommonCode";
	}
	
	public String InsertCodeDet() {
		try {
			CodeService codeService = (CodeService) SpringBeanUtil
					.lookup(CodeService.class.getName());
			
			// Check if Code Value exists
			codeDetIdFld = new CodeDetId();
			codeDetFld1 = new CodeDet();
			String xheaderid = codeDetFld.getCodeHeaderId();
			String xcode = codeDetFld.getCode().toUpperCase();
			codeDetIdFld.setCodeHeaderId(xheaderid);
			codeDetIdFld.setCode(xcode);
			codeDetFld1 = codeService.findByKey(codeDetIdFld);

   			if (codeDetFld1 != null) {
				addErrorMessage("Add New Common Code Information",
						"Common Code Value : " + codeDetFld1.getId().getCode() + " already existed." );
				return null;
	        }

   			// Update Code Header 
			String codeheaderid = codeDetFld.getCodeHeaderId();
			codeHeaderFld.setCodeHeaderId(codeheaderid);
			String name = codeHeaderFld.getName();
			codeHeaderFld.setName(name);
			
			codeService.update(codeHeaderFld);

   			// Insert Code Deatil 
			codeDetIdFld = new CodeDetId();
			codeHeaderFld = new CodeHeader();
			codeDetIdFld.setCodeHeaderId(codeDetFld.getCodeHeaderId());
			codeDetIdFld.setCode(codeDetFld.getCode().toUpperCase());
			codeDetFld.setId(codeDetIdFld);
	
			codeService.insert(codeDetFld);

		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("Add Common Code Type", t.getMessage());
			return null;
		}

		addInfoMessage("Record Saved", "Common Code Type information saved successfully.");
		
		return "listCommonCode";
	}
	
}
