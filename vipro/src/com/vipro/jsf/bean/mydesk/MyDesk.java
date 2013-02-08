package com.vipro.jsf.bean.mydesk;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.vipro.data.Case;
import com.vipro.service.CaseService;
import com.vipro.utils.spring.FacesUtil;
import com.vipro.utils.spring.SpringBeanUtil;

import static com.vipro.jsf.bean.PageConst.MAIN;

@ManagedBean(name="myDesk")
@RequestScoped
public class MyDesk {
	private CaseService caseService;
	private List<Case> myCases;
	private Case selectedCase;
	
	
	public MyDesk() {
		caseService = (CaseService) SpringBeanUtil.lookup(CaseService.class.getName());
	}


	public List<Case> getMyCases() {
		return myCases;
	}


	public void setMyCases(List<Case> myCases) {
		this.myCases = myCases;
	}


	public Case getSelectedCase() {
		return selectedCase;
	}


	public void setSelectedCase(Case selectedCase) {
		this.selectedCase = selectedCase;
	}
	
	@PostConstruct
	public void init() {
		
	}
	
	public String newCase() {
		return "newCase";
	}
	
	public String insertCase() {
		FacesUtil.addMessage("My Work Queue", "Case is created.");
		return "listCase";
	}
	
	public String updateCase() {
		FacesUtil.addMessage("My Work Queue", "Case is updated.");
		return "listCase";
	}
	
	public String openCase() {
		return "openCase";
	}
	
	public String cancel() {
		return "listCase";
	}
	
	
	

}
