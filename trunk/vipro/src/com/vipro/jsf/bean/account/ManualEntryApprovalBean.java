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

import org.primefaces.context.RequestContext;

import com.vipro.constant.CommonConst;
import com.vipro.constant.TransactionCodeConst;
import com.vipro.constant.TransactionStatusConst;
import com.vipro.data.Account;
import com.vipro.data.Project;
import com.vipro.data.TransactionCode;
import com.vipro.data.TransactionHistory;
import com.vipro.dto.ManualEntryApprovalDTO;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.service.AccountService;
import com.vipro.service.ProjectService;
import com.vipro.service.TransactionHistoryService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.SpringBeanUtil;

@ManagedBean(name = "manualEntryApprovalBean")
@ViewScoped
public class ManualEntryApprovalBean extends CommonBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2763159874232670517L;

	private ProjectService projectService;
	private Long selectedProjectId;
	private Project project = null;
	private String unit;
	private List<SelectItem> projects;
	private ManualEntryApprovalDTO selectedDto = new ManualEntryApprovalDTO();
	private List<ManualEntryApprovalDTO> dtoList;
	
	private BigDecimal txnAmount = BigDecimal.ZERO;
	private String txnInvNo = "";
	private String txnRefNo = "";
	private String txnDesc = "";
	private String txnCode = "";
	private String txnDrCr = "";
	private Date txnDate = new Date();
	
	private List<SelectItem> transactionCodeList;
	
	public ManualEntryApprovalBean() {
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

			transactionCodeList = CodeUtil.getTransactionCodes();

		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public String searchProject(){
		try{
			String selectedProjectIdStr = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("pbUSearchForm:projectList_input");
			if(selectedProjectIdStr != null){
				selectedProjectId = Long.parseLong(selectedProjectIdStr);
				dtoList = this.projectService.getManualEntryApprovalDTOList(selectedProjectId,this.unit);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public void onClose(ActionEvent actionEvent) {
		 RequestContext context = RequestContext.getCurrentInstance();
		 boolean success = true;
	     refreshProjectSearch();
		 CommonBean.addInfoMessage("INFORMATION"," Details window is closed normally.");
		 context.addCallbackParam("success", success);
	}
		
	public void onWarningClose(ActionEvent actionEvent) {
		 RequestContext context = RequestContext.getCurrentInstance();
		 boolean success = true;
		 CommonBean.addInfoMessage("INFORMATION"," Warning Window is Closed normally.");
		 context.addCallbackParam("success3", success);
	}
	
	public void refreshProjectSearch(){
		if(selectedProjectId != null){
			dtoList = this.projectService.getManualEntryApprovalDTOList(selectedProjectId,this.unit);
		}
	}
	
	public void onApproveAction(ActionEvent actionEvent) {	 
		RequestContext context = RequestContext.getCurrentInstance();
		boolean success = false;
		
		TransactionHistory txn = selectedDto.getTransaction();
		Account acct = selectedDto.getAccount();

		TransactionHistoryService txnHisService = (TransactionHistoryService) SpringBeanUtil.lookup(TransactionHistoryService.class.getName());
		AccountService acctService = (AccountService) SpringBeanUtil.lookup(AccountService.class.getName());

		if (txnDrCr.compareTo(TransactionCodeConst.DEBIT) == 0) {
			acct.setAccountBalance(getSelectedDto().getAccount().getAccountBalanceNotNull().add(txnAmount)); 
		} else {
			acct.setAccountBalance(getSelectedDto().getAccount().getAccountBalanceNotNull().subtract(txnAmount)); 			
		}
//		acct.setDateChanged(new Date());
//		acct.setChangedBy(CommonBean.getCurrentUser().getUserProfile().getUserId());			
		acctService.update(acct);		
		
		// update transaction history record
		txn.setInvoiceNo(txnInvNo);
		txn.setTransactionCode(new TransactionCode(txnCode));
		txn.setTransactionDescription(txnDesc);
		txn.setAmount(txnAmount);
		txn.setCodeType(txnDrCr);
		txn.setInvoiceNo(txnInvNo);
		txn.setRefNo(txnRefNo);
		txn.setTransactionDate(txnDate);
		txn.setStatus(TransactionStatusConst.POSTED);
		txn.setPostedBy(CommonBean.getCurrentUser().getUserProfile().getUserId());
		txn.setPostingDate(new Date());		
		txnHisService.update(txn);
		
		// update account balance
		
		CommonBean.addInfoMessage("APPROVED","The manual transaction posted successfully.");
		context.addCallbackParam("success2", success);
		context.execute("dlg.hide()");
	    refreshProjectSearch();
	}	
	
	public void onReject(ActionEvent actionEvent) {
		 RequestContext context = RequestContext.getCurrentInstance();
		 boolean success = true;
			
		 TransactionHistory txn = selectedDto.getTransaction();
			
		 // update transaction status to Rejected record
		 TransactionHistoryService txnHisService = (TransactionHistoryService) SpringBeanUtil.lookup(TransactionHistoryService.class.getName());
		
		 txn.setStatus(TransactionStatusConst.REJECTED);
		 txnHisService.update(txn);	
		 
		 CommonBean.addInfoMessage("UPDATED"," This Saved Transaction is Rejected Successfully.");
		 context.addCallbackParam("success", success);
	     refreshProjectSearch();
	     
	}
	
	public String onDtoSelection(){
		
		this.txnAmount = getSelectedDto().getTransaction().getAmount();
		this.txnInvNo = getSelectedDto().getTransaction().getInvoiceNo();
		this.txnRefNo= getSelectedDto().getTransaction().getRefNo();
		this.txnDesc = getSelectedDto().getTransaction().getTransactionDescription();
		this.txnCode = getSelectedDto().getTransaction().getTransactionCode().getTransactionCode();
		this.txnDrCr = getSelectedDto().getTransaction().getCodeType();
		this.txnDate = getSelectedDto().getTransaction().getTransactionDate();
		
		return null;
	}
	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

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

	public List<ManualEntryApprovalDTO> getDtoList() {
		return dtoList;
	}

	public void setDtoList(List<ManualEntryApprovalDTO> dtoList) {
		this.dtoList = dtoList;
	}

	public ManualEntryApprovalDTO getSelectedDto() {
		return selectedDto;
	}

	public void setSelectedDto(ManualEntryApprovalDTO selectedDto) {
		this.selectedDto = selectedDto;
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

	public String getTxnInvNo() {
		return txnInvNo;
	}

	public void setTxnInvNo(String txnInvNo) {
		this.txnInvNo = txnInvNo;
	}

	public String getTxnRefNo() {
		return txnRefNo;
	}

	public void setTxnRefNo(String txnRefNo) {
		this.txnRefNo = txnRefNo;
	}

	public String getTxnDesc() {
		return txnDesc;
	}

	public void setTxnDesc(String txnDesc) {
		this.txnDesc = txnDesc;
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

	public Date getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(Date txnDate) {
		this.txnDate = txnDate;
	}

	
}
