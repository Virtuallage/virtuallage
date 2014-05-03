package com.vipro.jsf.bean.sales;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.springframework.dao.DataIntegrityViolationException;

import com.vipro.data.AdjHeader;
import com.vipro.data.Project;
import com.vipro.data.ProjectInventory;
import com.vipro.data.UserProfile;

import com.vipro.service.AdjHeaderService;
import com.vipro.service.UserProfileService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.SpringBeanUtil;
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
	private AdjHeader adjHeader;
	
	
	public PriceAdjustment() {

	}

	@PostConstruct
	public void init() {
		listProject = CodeUtil.getProjectAsItems();
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

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public AdjHeader getAdjHeader() {
		return adjHeader;
	}

	public void setAdjHeader(AdjHeader adjHeader) {
		this.adjHeader = adjHeader;
	}
	
	public void save() {
		try {

			AdjHeaderService service = (AdjHeaderService) SpringBeanUtil.lookup(AdjHeaderService.class.getName());
			service.update(adjHeader);
			addInfoMessage("Price Adjustment", "Price Adjusment is updated");
		} catch (Throwable th) {
			addErrorMessage("Price Adjustment", "Error saving details. " + th.getMessage());
//			return null;
		}
		
	}
	
	}
