package com.vipro.jsf.bean.mis;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.vipro.constant.JasperConst;
import com.vipro.data.Project;
import com.vipro.service.ProjectService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.JasperCsvUtil;
import com.vipro.utils.spring.SpringBeanUtil;

@ManagedBean(name = "DataExtractionBean")
@RequestScoped
public class DataExtractionBean {
	
	private Long projectId;
	
	private List<SelectItem> listProject = null;
	
	private StreamedContent salesAdminDataExtraction;
	
	
	@PostConstruct	
	public void init() {
		listProject = CodeUtil.getProjectAsItems();
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
	
	
	public StreamedContent getsalesAdminDataExtraction() {
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("project_id", Long.toString(projectId));
		
		Project project_name = new Project();
		project_name.getProjectName();
		ProjectService projectService = (ProjectService) SpringBeanUtil
				.lookup(ProjectService.class.getName());
		project_name = projectService.findById(projectId);
		String outputfilename = "SalesAdminDataExtraction" + project_name.getProjectCode() + ".csv";
		
		//System.err.println("ProjectID="+ Long.toString(projectId));
		String report = JasperConst.SalesAdminDataExtraction;
		JasperCsvUtil.generateReport(hm, report);

		
		String path ="/MISReport/SalesAdminDataExtraction.csv";
		InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream(path);  
		salesAdminDataExtraction = new DefaultStreamedContent(stream, outputfilename, outputfilename); 
		
        return salesAdminDataExtraction;  
    } 
}
