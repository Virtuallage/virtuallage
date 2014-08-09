package com.vipro.jsf.bean.mis;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Date;

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
import com.vipro.data.CodeDet;
import com.vipro.data.Customer;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.JasperUtil;

@ManagedBean(name = "potentialPurchaserBean")
@RequestScoped
public class PotentialPurchaserBean {
	
	private Long projectId;
	private CodeDet codeDet; 
	private Customer customer;
	private String marketingCode;
	private List<SelectItem> listProject = null;
	private List<SelectItem> listMarketingCodes = null;
	private Date startDate = null;
	private Date endDate = null;
	private StreamedContent PPStatistics;
	
	
	@PostConstruct	
	public void init() {
		listProject = CodeUtil.getProjectAsItems();
		listMarketingCodes = CodeUtil.getCodes("MC");
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
	
	public List<SelectItem> getListMarketingCodes() {
		return listMarketingCodes;
	}

	public void setListMarketingCodes(List<SelectItem> listMarketingCodes) {
		this.listMarketingCodes = listMarketingCodes;
	}

	public CodeDet getCodeDet() {
		return codeDet;
	}

	public void setCodeDet(CodeDet codeDet) {
		this.codeDet = codeDet;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getMarketingCode() {
		return marketingCode;
	}

	public void setMarketingCode(String marketingCode) {
		this.marketingCode = marketingCode;
	}

	public StreamedContent getPPStatistics() {
		
		DateFormat s1=new SimpleDateFormat("yyyy-MM-dd");
		String strdate=s1.format(startDate);
		
		DateFormat s2=new SimpleDateFormat("yyyy-MM-dd");
		String e1date=s2.format(endDate);
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("MarketingCode", marketingCode);
		hm.put("StartDate", strdate);
		hm.put("EndDate", e1date);	
		
//		String outputfilename = "PotentialPurchaserStatistics.pdf";
		String report = JasperConst.PotentialPurchaserStatistics;
		JasperUtil.generateReport(hm, report);

		String path ="/MISReport/MISReport.pdf";
//		MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
//		String mimeType = mimeTypesMap.getContentType(outputfilename);
		InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream(path);
//		PPStatistics = new DefaultStreamedContent(stream, mimeType, outputfilename);	
		PPStatistics = new DefaultStreamedContent(stream, "MISReport.pdf", "MISReport.pdf");		
		
		return PPStatistics;
	
	}

	public void setPPStatistics(StreamedContent pPStatistics) {
		PPStatistics = pPStatistics;
	}

}
