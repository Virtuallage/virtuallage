package com.vipro.jsf.bean.sales;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.springframework.dao.DataIntegrityViolationException;

import com.vipro.data.Project;
import com.vipro.data.ProjectInventory;

import com.vipro.utils.spring.CodeUtil;
import com.vipro.jsf.bean.CommonBean;

@ManagedBean(name = "priceAdjustment")
@SessionScoped
public class PriceAdjustment extends CommonBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<SelectItem> listProject;
	private ProjectInventory inventory;
	private Project project;
	private Long projectId;
	private Date effectiveDate;
	
	private String something;
	
	public PriceAdjustment() {

	}

	@PostConstruct
	public void init() {
		listProject = CodeUtil.getProjectAsItems();
		something = "test";

	}

	public List<SelectItem> getListProject() {
		return listProject;
	}

	public void setListProject(List<SelectItem> listProject) {
		this.listProject = listProject;
	}

	public ProjectInventory getInventory() {
		return inventory;
	}

	public void setInventory(ProjectInventory inventory) {
		this.inventory = inventory;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Long getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getSomething() {
		return something;
	}

	public void setSomething(String something) {
		this.something = something;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	
	}
