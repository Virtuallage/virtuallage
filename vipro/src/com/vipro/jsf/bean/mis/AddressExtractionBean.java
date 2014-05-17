package com.vipro.jsf.bean.mis;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.activation.MimetypesFileTypeMap;
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
import com.vipro.utils.spring.JasperAddressUtil;
import com.vipro.utils.spring.JasperCsvUtil;
import com.vipro.utils.spring.SpringBeanUtil;

@ManagedBean(name = "AddressExtractionBean")
@RequestScoped
public class AddressExtractionBean {
	
	private Long projectId;
	
	private List<SelectItem> listProject = null;
	
	private StreamedContent salesAdminAddressExtraction;
	
	
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
	
	
	public StreamedContent getsalesAdminAddressExtraction() {
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("project_id", Long.toString(projectId));
		
		Project project_name = new Project();
		project_name.getProjectName();
		ProjectService projectService = (ProjectService) SpringBeanUtil
				.lookup(ProjectService.class.getName());
		project_name = projectService.findById(projectId);
		String outputfilename = "SalesAdminAddressExtraction" + project_name.getProjectCode() + ".docx";
		String report = JasperConst.SalesAdminAddressExtraction;
		JasperAddressUtil.generateReport(hm, report);

		String path ="/MISReport/SalesAdminAddressExtraction.docx";
		
		MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
		String mimeType = mimeTypesMap.getContentType(outputfilename);
		InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream(path);  
		salesAdminAddressExtraction = new DefaultStreamedContent(stream, mimeType, outputfilename); 
        
		return salesAdminAddressExtraction;  
    } 
}
