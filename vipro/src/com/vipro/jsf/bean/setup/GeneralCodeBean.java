package com.vipro.jsf.bean.setup;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.primefaces.event.RowEditEvent;

import com.vipro.constant.CodeConst;
import com.vipro.data.CodeDet;
import com.vipro.data.CodeDetId;
import com.vipro.data.CodeHeader;
import com.vipro.jsf.bean.PageConst;
import com.vipro.utils.spring.CodeUtil;


@ManagedBean(name = "generalCodeBean")
@SessionScoped
public class GeneralCodeBean implements PageConst {

	private String codeType;
	private CodeDet selectedCodeDet;
	private CodeDet newCodeDet;
	
	private List<SelectItem> codeHeaderList;
	private List<SelectItem> statusList;
	
	private List<CodeDet> codeDetList;
	
	public List<SelectItem> getCodeHeaderList() {
		return codeHeaderList;
	}

	public void setCodeHeaderList(List<SelectItem> codeHeaderList) {
		this.codeHeaderList = codeHeaderList;
	}

	public List<CodeDet> getCodeDetList() {
		return codeDetList;
	}

	public void setCodeDetList(List<CodeDet> codeDetList) {
		this.codeDetList = codeDetList;
	}
	
	public List<SelectItem> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<SelectItem> statusList) {
		this.statusList = statusList;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public CodeDet getSelectedCodeDet() {
		return selectedCodeDet;
	}

	public void setSelectedCodeDet(CodeDet selectedCodeDet) {
		this.selectedCodeDet = selectedCodeDet;
	}

	public CodeDet getNewCodeDet() {
		if (newCodeDet == null) {
			newCodeDet = new CodeDet(new CodeDetId(), new CodeHeader());
		}
		return newCodeDet;
	}

	public void setNewCodeDet(CodeDet newCodeDet) {
		this.newCodeDet = newCodeDet;
	}

	@PostConstruct
	public void init() {
		codeHeaderList = CodeUtil.getCodeHeaders();
		statusList = CodeUtil.getCodes(CodeConst.STATUS);
	}
	
    public void onSearch() {
    	codeDetList = CodeUtil.getCodeDetailList(codeType);
    	CodeHeader codeHeader = CodeUtil.getCodeHeader(codeType);
    	if (codeHeader != null) {
	    	CodeDetId codeDetId = new CodeDetId(codeHeader.getCodeHeaderId(), "");
	    	newCodeDet = new CodeDet(codeDetId, codeHeader);
    	}
    }
	
    public void onEdit(RowEditEvent event) {  
    	System.out.println("ONEDIT");
    	
//        FacesMessage msg = new FacesMessage("Car Edited", ((Car) event.getObject()).getModel());  
//  
//        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
      
    public void onCancel(RowEditEvent event) {
    	System.out.println("ONCANCEL");
//        FacesMessage msg = new FacesMessage("Car Cancelled", ((Car) event.getObject()).getModel());  
//  
//        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
	
    public void onDelete() {
    	System.out.println("ONDELETE");
//        FacesMessage msg = new FacesMessage("Car Cancelled", ((Car) event.getObject()).getModel());  
//  
//        FacesContext.getCurrentInstance().addMessage(null, msg);  
    } 
    
    public void onAdd() {
    	System.out.println("ONADD");
    	CodeHeader codeHeader = CodeUtil.getCodeHeader(codeType);
    	if (codeHeader != null) {
	    	CodeDetId codeDetId = new CodeDetId(codeHeader.getCodeHeaderId(), "");
	    	newCodeDet = new CodeDet(codeDetId, codeHeader);
    	}
//        FacesMessage msg = new FacesMessage("Car Cancelled", ((Car) event.getObject()).getModel());  
//  
//        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
}