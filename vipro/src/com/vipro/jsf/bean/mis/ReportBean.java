package com.vipro.jsf.bean.mis;

import java.io.File;
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
import com.vipro.utils.spring.JasperCsvUtil;
import com.vipro.utils.spring.JasperUtil;
import com.vipro.utils.spring.SpringBeanUtil;

@ManagedBean(name = "reportBean")
@RequestScoped
public class ReportBean {
	
	private Long projectId;
	
	private List<SelectItem> listProject = null;
	
	private StreamedContent MISReport;
	private StreamedContent ProgressiveBillingReport;

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
	
	public StreamedContent getMISReport() {  
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("project_id", Long.toString(projectId));
		
		String report = JasperConst.MIS_PROJECT_PRICING;
		JasperUtil.generateReport(hm, report);
		
		String path ="/MISReport/MISReport.pdf";
		InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream(path);  
        MISReport = new DefaultStreamedContent(stream, "MISReport.pdf", "MISReport.pdf"); 
        
        return MISReport;  
    } 
	
	public StreamedContent getProgressiveBillingReport() {  
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("projectId", Long.toString(projectId));
		
		Project project_name = new Project();
		project_name.getProjectName();
		ProjectService projectService = (ProjectService) SpringBeanUtil
				.lookup(ProjectService.class.getName());
		project_name = projectService.findById(projectId);
		String outputfilename = "ProgressiveBillingListingByInvoiceNo" + project_name.getProjectCode() + ".pdf";
		
		MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
		String mimeType = mimeTypesMap.getContentType(outputfilename);
				
		String pathx = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
	    pathx = pathx.concat("MISReport/");
	    File reportDirectory = new File(pathx);
	    if (!reportDirectory.exists())
	    {
	    	reportDirectory.mkdir();
	    }

			String report = JasperConst.PROGRESSIVE_BILLING_REPORT_BY_INVOICE_NO;
			String pdf = pathx + "ProgressiveBillingListingByInvoiceNo.pdf";
			JasperUtil.generateReport(hm, report, pdf);
			String path ="/MISReport/ProgressiveBillingListingByInvoiceNo.pdf";
			InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream(path);
			ProgressiveBillingReport = new DefaultStreamedContent(stream, mimeType, outputfilename);
		

        return ProgressiveBillingReport;  
    } 
}
