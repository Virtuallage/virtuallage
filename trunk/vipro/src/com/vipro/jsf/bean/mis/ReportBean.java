package com.vipro.jsf.bean.mis;

import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import com.vipro.constant.JasperConst;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.JasperUtil;

@ManagedBean(name = "reportBean")
@RequestScoped
public class ReportBean {
	
	private Long projectId;
	
	private List<SelectItem> listProject = null;

	@PostConstruct
	public void init() {
		listProject = CodeUtil.getProjectAsItems();
	}
	
	
	public String genProjectPricingRpt() {
		// generate project pricing report
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("project_id", Long.toString(projectId));
		
		String report = JasperConst.MIS_PROJECT_PRICING;
		JasperUtil.generateReport(hm, report);
		
		return "projectPricingRpt";
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public List<SelectItem> getListProject() {
		return listProject;
	}

	public void setListProject(List<SelectItem> listProject) {
		this.listProject = listProject;
	}
	
}
