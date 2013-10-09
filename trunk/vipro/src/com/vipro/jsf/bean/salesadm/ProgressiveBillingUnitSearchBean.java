package com.vipro.jsf.bean.salesadm;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.vipro.data.Project;
import com.vipro.dto.ProgressiveBillingUnitSeachDTO;
import com.vipro.dto.PropertyUnitDetailsDTO;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.service.ProjectService;
import com.vipro.utils.spring.SpringBeanUtil;

@ManagedBean(name = "progressiveBillingUnitSearchBean")
@ViewScoped
public class ProgressiveBillingUnitSearchBean extends CommonBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2763159874232670517L;

	private ProjectService projectService;
	private Long selectedProjectId;
	private Project project = null;
	private String unit;
	
	private List<ProgressiveBillingUnitSeachDTO> dtoList;
	

	public ProgressiveBillingUnitSearchBean() {
		this.projectService = (ProjectService)SpringBeanUtil.lookup(ProjectService.class.getName());
		String selectedProjectIdStr = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedProjectId");
		if(selectedProjectIdStr != null && !selectedProjectIdStr.isEmpty()){
			selectedProjectId = Long.parseLong(selectedProjectIdStr);
			project = this.projectService.findById(selectedProjectId);
		}
	}
	
	public String searchProject(){
		try{
			String selectedProjectIdStr = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("pbUSearchForm:projectList_input");
			if(selectedProjectIdStr != null){
				selectedProjectId = Long.parseLong(selectedProjectIdStr);
				//System.out.println("----------------------unit is :"+this.unit);
				dtoList = this.projectService.getProgressiveBillingUnitSearchDTOListByProjectIdAndUnit(selectedProjectId,this.unit);
								
				System.out.println("Size is  :"+dtoList.size());
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	private List<SelectItem> projects;
	
	
	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public Long getSelectedProjectId() {
		return selectedProjectId;
	}

	public void setSelectedProjectId(Long selectedProjectId) {
		this.selectedProjectId = selectedProjectId;
	}

	public List<SelectItem> getProjects() {
		return projects;
	}

	public void setProjects(List<SelectItem> projects) {
		this.projects = projects;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public List<ProgressiveBillingUnitSeachDTO> getDtoList() {
		return dtoList;
	}

	public void setDtoList(List<ProgressiveBillingUnitSeachDTO> dtoList) {
		this.dtoList = dtoList;
	}
}
