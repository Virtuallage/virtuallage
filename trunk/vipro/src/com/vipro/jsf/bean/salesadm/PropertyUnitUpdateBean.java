package com.vipro.jsf.bean.salesadm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;

import com.vipro.constant.CodeConst;
import com.vipro.constant.CommonConst;
import com.vipro.data.Project;
import com.vipro.dto.PropertyUnitDetailsDTO;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.service.CodeService;
import com.vipro.service.ProjectInventoryService;
import com.vipro.service.ProjectService;
import com.vipro.utils.spring.SpringBeanUtil;


@ManagedBean(name = "propertyUnitUpdateBean")
@ViewScoped
public class PropertyUnitUpdateBean extends CommonBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -393535972424223490L;

	private ProjectService projectService;
	private Long selectedProjectId;
	private String unit;
	private List<SelectItem> projects;
	private PropertyUnitDetailsDTO selectedDto = new PropertyUnitDetailsDTO();
	private List<PropertyUnitDetailsDTO> dtoList;
	
	private List<SelectItem> statesSIList;
	private List<SelectItem> titlTypesSIList;
	
	private Project project = null;
	
	
	public PropertyUnitUpdateBean() {
		
		this.projectService = (ProjectService)SpringBeanUtil.lookup(ProjectService.class.getName());
		String selectedProjectIdStr = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedProjectId");
		if(selectedProjectIdStr != null && !selectedProjectIdStr.isEmpty()){
			selectedProjectId = Long.parseLong(selectedProjectIdStr);
			project = this.projectService.findById(selectedProjectId);
		}
	}

	@PostConstruct
	public void initialize(){
		
		try{
			projects = new ArrayList<SelectItem>();
			projects.add(new SelectItem(null,CommonConst.SELECT));
			List<Project> allProjects = projectService.findAllProjects();
			if(allProjects != null && allProjects.size()>0){
				for(Project proj : allProjects){
					projects.add(new SelectItem(proj.getProjectId(),proj.getProjectName()));
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private List<SelectItem> getCodeSIList(String code) {
		CodeService codeService = (CodeService) SpringBeanUtil.lookup(CodeService.class.getName());
		return codeService.getCodes(code);
	}
	
	public void savePUDetails(ActionEvent actionEvent) {  
	        RequestContext context = RequestContext.getCurrentInstance();  
	        boolean success = false; 
	        
	        ProjectInventoryService service = (ProjectInventoryService)SpringBeanUtil.lookup(ProjectInventoryService.class.getName());
	        
	        service.updatePropertyUnit(getSelectedDto());
	        
	        setSelectedDto(new PropertyUnitDetailsDTO());

	        CommonBean.addInfoMessage("Update Successful."," The Property unit information has been updated successfully.");
	        success = true;
	        context.addCallbackParam("success", success);  
	    }  
	
	public void closePUDetails(ActionEvent actionEvent) {  
        RequestContext context = RequestContext.getCurrentInstance();  
        boolean success = true; 
        setSelectedDto(new PropertyUnitDetailsDTO());
        refreshProjectSearch();
        CommonBean.addInfoMessage("Details Closed."," Details windows closed.");
        context.addCallbackParam("success", success);  
	}
	
	public void refreshProjectSearch(){
		if(selectedProjectId != null){
			dtoList = this.projectService.getPropertyUnitDetailsDTOListByProjectIdAndUnit(selectedProjectId,this.unit);
		}
	}
	public String searchProject(){
		try{
			String selectedProjectIdStr = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("puListForm:projectList_input");
			if(selectedProjectIdStr != null){
				final DataTable d = (DataTable) FacesContext.getCurrentInstance().getViewRoot()
				        .findComponent(":puListForm:dt");
				    d.setFirst(0);
				selectedProjectId = Long.parseLong(selectedProjectIdStr);
				dtoList = this.projectService.getPropertyUnitDetailsDTOListByProjectIdAndUnit(selectedProjectId,this.unit);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
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

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public List<PropertyUnitDetailsDTO> getDtoList() {
		return dtoList;
	}

	public void setDtoList(List<PropertyUnitDetailsDTO> dtoList) {
		this.dtoList = dtoList;
	}

	public PropertyUnitDetailsDTO getSelectedDto() {
		return selectedDto;
	}

	public void setSelectedDto(PropertyUnitDetailsDTO selectedDto) {
		this.selectedDto = selectedDto;
	}

	public List<SelectItem> getStatesSIList() {
		statesSIList = getCodeSIList(CodeConst.STATE);
		
		return statesSIList;
	}

	public void setStatesSIList(List<SelectItem> statesSIList) {
		this.statesSIList = statesSIList;
	}

	public List<SelectItem> getTitlTypesSIList() {
		titlTypesSIList = getCodeSIList(CodeConst.PROPERTY_TITLE);
		return titlTypesSIList;
	}

	public void setTitlTypesSIList(List<SelectItem> titlTypesSIList) {
		this.titlTypesSIList = titlTypesSIList;
	}
}
