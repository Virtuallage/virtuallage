package com.vipro.jsf.bean.account;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.vipro.constant.CommonConst;
import com.vipro.constant.TransactionCodeConst;
import com.vipro.constant.TransactionStatusConst;
import com.vipro.data.Account;
import com.vipro.data.Project;
import com.vipro.data.TransactionCode;
import com.vipro.data.TransactionHistory;
import com.vipro.dao.TransactionHistoryDao;
import com.vipro.dto.TransactionEntryDTO;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.service.TransactionCodeService;
import com.vipro.service.ProjectService;
import com.vipro.service.TransactionHistoryService;
import com.vipro.utils.spring.SpringBeanUtil;
import com.vipro.utils.spring.CodeUtil;

@ManagedBean(name = "manualEntryBean")
@ViewScoped
public class ManualEntryBean extends CommonBean implements Serializable{

	private static final long serialVersionUID = -393535972424223490L;

	private ProjectService projectService;
	private Long selectedProjectId;
	private List<SelectItem> projects;
	
	private String unit;
	private Date txnDate = new Date();
	private BigDecimal txnAmount = BigDecimal.ZERO;
	private String txnDesc = "";
	private String txnCode = "";
	private String txnDrCr = "";
	private String txnRefNo = "";
	private String txnInvNo ="";

	private TransactionEntryDTO selectedDto = new TransactionEntryDTO();
	private List<TransactionEntryDTO> dtoList;
	private List<SelectItem> propertyStatusList;
	private List<SelectItem> transactionCodeList;

	private Project project = null;
	private TransactionHistoryDao transactionHistoryDao;
	
	public ManualEntryBean() {
		
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
			
			propertyStatusList = CodeUtil.getCodes("PS");
			transactionCodeList = CodeUtil.getTransactionCodes();
				
		}catch(Exception ex){
			ex.printStackTrace();
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
				dtoList = this.projectService.getTransactionEntryDTOListByProjectIdAndUnit(selectedProjectId,this.unit);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public void closePUDetails(ActionEvent actionEvent) {  
        RequestContext context = RequestContext.getCurrentInstance();  
        boolean success = true; 
        setSelectedDto(new TransactionEntryDTO());
        refreshProjectSearch();
        CommonBean.addInfoMessage("INFORMATION"," Details windows closed normally.");
        context.addCallbackParam("success", success);  
	}
	
	public void refreshProjectSearch(){
		if(selectedProjectId != null){
			dtoList = this.projectService.getTransactionEntryDTOListByProjectIdAndUnit(selectedProjectId,this.unit);
		}
	}
	
	public void savePUDetails(ActionEvent actionEvent) {  
	        RequestContext context = RequestContext.getCurrentInstance();  
	        	        
	        boolean success = false; 
			Account aa = new Account();
			aa.setAccountId(selectedDto.getAccount().getAccountId()); 
			
			TransactionHistoryService txnHisService = (TransactionHistoryService) SpringBeanUtil.lookup(TransactionHistoryService.class.getName());
			TransactionHistory txnHis = new TransactionHistory();

			TransactionCode codeManual = new TransactionCode();
			codeManual.setTransactionCode(txnCode);
			
			txnHis = new TransactionHistory();
			txnHis.setAccount(aa);
			txnHis.setTransactionCode(codeManual);
			txnHis.setTransactionDate(txnDate);
			txnHis.setTransactionDescription(txnDesc);
			txnHis.setAmount(txnAmount);
			txnHis.setCodeType(txnDrCr);
			txnHis.setRefNo(txnRefNo);
			txnHis.setInvoiceNo(txnInvNo);
			txnHis.setUserId(CommonBean.getCurrentUser().getUserProfile().getUserId());
			txnHis.setStatus(TransactionStatusConst.SAVED);
			txnHisService.insert(txnHis);		

	        CommonBean.addInfoMessage("INFORMATION"," The Transaction has been saved successfully.");
	        success = true;
	        context.addCallbackParam("success", success);  
	    }  
	
	public String onDtoSelection(){

		this.txnAmount=BigDecimal.ZERO;
        this.txnDate=new Date();
        this.txnCode="";
        this.txnDrCr="";
        this.txnRefNo="";
        this.txnInvNo="";

		return null;
	}
	
	public void findTransactionCode() {
		
		TransactionCodeService transactionCodeService = (TransactionCodeService) SpringBeanUtil.lookup(TransactionCodeService.class.getName());
		
		if (txnCode != "") {
			TransactionCode transactionCode = transactionCodeService.findByTC(txnCode);
			if(transactionCode != null) {
				txnDesc = transactionCode.getName();
				txnDrCr = transactionCode.getCodeType();
			}
		}
	}

// Getter & Setter Area
	
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

	public List<TransactionEntryDTO> getDtoList() {
		return dtoList;
	}

	public void setDtoList(List<TransactionEntryDTO> dtoList) {
		this.dtoList = dtoList;
	}

	public TransactionEntryDTO getSelectedDto() {
		return selectedDto;
	}

	public void setSelectedDto(TransactionEntryDTO selectedDto) {
		this.selectedDto = selectedDto;
	}

	public List<SelectItem> getPropertyStatusList() {
		return propertyStatusList;
	}

	public void setPropertyStatusList(List<SelectItem> propertyStatusList) {
		this.propertyStatusList = propertyStatusList;
	}

	public List<SelectItem> getTransactionCodeList() {
		return transactionCodeList;
	}

	public void setTransactionCodeList(List<SelectItem> transactionCodeList) {
		this.transactionCodeList = transactionCodeList;
	}

	public BigDecimal getTxnAmount() {
		return txnAmount;
	}

	public void setTxnAmount(BigDecimal txnAmount) {
		this.txnAmount = txnAmount;
	}

	public String getTxnDesc() {
		return txnDesc;
	}

	public void setTxnDesc(String txnDesc) {
		this.txnDesc = txnDesc;
	}

	public Date getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(Date txnDate) {
		this.txnDate = txnDate;
	}

	public String getTxnCode() {
		return txnCode;
	}

	public void setTxnCode(String txnCode) {
		this.txnCode = txnCode;
	}

	public String getTxnDrCr() {
		return txnDrCr;
	}

	public void setTxnDrCr(String txnDrCr) {
		this.txnDrCr = txnDrCr;
	}

	public String getTxnRefNo() {
		return txnRefNo;
	}

	public void setTxnRefNo(String txnRefNo) {
		this.txnRefNo = txnRefNo;
	}

	public String getTxnInvNo() {
		return txnInvNo;
	}

	public void setTxnInvNo(String txnInvNo) {
		this.txnInvNo = txnInvNo;
	}

	public TransactionHistoryDao getTransactionHistoryDao() {
		return transactionHistoryDao;
	}

	public void setTransactionHistoryDao(TransactionHistoryDao transactionHistoryDao) {
		this.transactionHistoryDao = transactionHistoryDao;
	}
}
