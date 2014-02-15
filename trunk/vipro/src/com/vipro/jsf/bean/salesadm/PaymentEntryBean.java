package com.vipro.jsf.bean.salesadm;

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

import com.vipro.constant.CodeConst;
import com.vipro.constant.CommonConst;
import com.vipro.constant.ProgressiveBillingConst;
import com.vipro.data.Project;
import com.vipro.dto.PaymentEntryDTO;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.service.ProgressiveBillingService;
import com.vipro.service.ProjectService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.SpringBeanUtil;

@ManagedBean(name = "paymentEntryBean")
@ViewScoped
public class PaymentEntryBean extends CommonBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2763159874232670517L;

	private ProjectService projectService;
	private Long selectedProjectId;
	private Project project = null;
	private String unit;
	private List<SelectItem> projects;
	private PaymentEntryDTO selectedDto = new PaymentEntryDTO();
	private List<PaymentEntryDTO> dtoList;
	
	private BigDecimal paymentAmount = BigDecimal.ZERO;
	private String chequeNo = "";
	private String selectedPaymentMethod = "";
	private String selectedBank = "";
	private String selectedTransactionType = "Progressive Billing Payment";
	private Date selectedChkDate = new Date();
	private Date toDay = new Date();
	
	private List<SelectItem> transactionTypeList;
	private List<SelectItem> paymentMethodList;
	private List<SelectItem> bankList;
	
	public PaymentEntryBean() {
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
			
			bankList =  CodeUtil.getCodes(CodeConst.BANK_NAME);
			paymentMethodList =  CodeUtil.getCodes(CodeConst.PAYMENT_METHOD);
			transactionTypeList =  CodeUtil.getCodes("CI");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public String searchProject(){
		try{
			String selectedProjectIdStr = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("pbUSearchForm:projectList_input");
			if(selectedProjectIdStr != null){
				selectedProjectId = Long.parseLong(selectedProjectIdStr);
				dtoList = this.projectService.getPaymentEntryDTOListByProjectIdAndUnit(selectedProjectId,this.unit);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
		public void onClose(ActionEvent actionEvent) {
			 RequestContext context = RequestContext.getCurrentInstance();
			 boolean success = true;
			 CommonBean.addInfoMessage("Details Closed."," Details window closed.");
			 context.addCallbackParam("success", success);
		}
		
		public void onWarningClose(ActionEvent actionEvent) {
			 RequestContext context = RequestContext.getCurrentInstance();
			 boolean success = true;
			 CommonBean.addInfoMessage("Warning Closed."," Warning Window Closed.");
			 context.addCallbackParam("success3", success);
		}
		
		public void onSubmitAction(ActionEvent actionEvent) {	 
			
			ProgressiveBillingService pbService = (ProgressiveBillingService)SpringBeanUtil.lookup(ProgressiveBillingService.class.getName());
			String[] statuses = new String[]{ProgressiveBillingConst.PB_STATUS_BILL, ProgressiveBillingConst.PB_STATUS_PARTIAL_PAYMENT};
			
			int res = paymentAmount.compareTo(getSelectedDto().getTransaction().getAmount());
			
			if (res == 1) {
				RequestContext.getCurrentInstance().execute("dlg4.show()");
			} else { // if equal or less check for remain amount.
				BigDecimal dd = pbService
						.getRemaingPaymentAmountByAccountIdStatusAndInvoiceNo(
								getSelectedDto().getAccount().getAccountId(),
								statuses, getSelectedDto().getTransaction()
										.getInvoiceNo());
				System.out
						.println("---------------------------------------------------------");
				System.out.println("Remaing amount is ::" + dd);
	
				int diff = paymentAmount.compareTo(dd);
	
				if (diff == -1) { // if less
					RequestContext.getCurrentInstance().execute("dlg3.show()");
				} else if (diff == 1) { // if greater
					RequestContext.getCurrentInstance().execute("dlg4.show()");
				} else { // if equal
					generatePaymentForInvoice();
				}
			}
		}
			
		private void generatePaymentForInvoice(){
			 RequestContext context = RequestContext.getCurrentInstance();
			 boolean success = false;
			ProgressiveBillingService pbService = (ProgressiveBillingService)SpringBeanUtil.lookup(ProgressiveBillingService.class.getName());
			 success = pbService.generatePaymentForInvoice(getSelectedDto(), paymentAmount, selectedPaymentMethod, selectedBank, chequeNo,selectedChkDate);
			 
			if(success){
				Long txRevsalId= selectedDto.getTransaction().getTxnReversalId();
				if( txRevsalId != null ){
				  dtoList = this.projectService.getPaymentEntryDTOListByProjectIdAndUnit(selectedProjectId,this.unit);
				//	dtoList.remove(selectedDto);
				}
				 setSelectedDto(new PaymentEntryDTO());
				 CommonBean.addInfoMessage("Payment Submitted Successfully","The payment transaction has been submitted for processing.");
				 context.addCallbackParam("success2", success);
				 context.execute("dlg.hide()");
			 }else{
				 CommonBean.addErrorMessage("Payment Submition Erorr","Please contact application administrator.");
			 }
		}
		
		public void onYes(ActionEvent actionEvent) {
			 generatePaymentForInvoice();
		}
		
		public void onNo(ActionEvent actionEvent) {
			 RequestContext context = RequestContext.getCurrentInstance();
			 boolean success = true;
			 
			 CommonBean.addInfoMessage("Warning Closed."," Warning window closed.");
			 context.addCallbackParam("success2", success);
		}
	public String onDtoSelection(){
		this.selectedBank = "";
		this.selectedChkDate = new Date();
		this.selectedPaymentMethod = "";
		this.chequeNo="";
		this.paymentAmount = getSelectedDto().getTransaction().getAmount();
		
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

	public List<PaymentEntryDTO> getDtoList() {
		return dtoList;
	}

	public void setDtoList(List<PaymentEntryDTO> dtoList) {
		this.dtoList = dtoList;
	}

	public PaymentEntryDTO getSelectedDto() {
		return selectedDto;
	}

	public void setSelectedDto(PaymentEntryDTO selectedDto) {
		this.selectedDto = selectedDto;
	}

	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public List<SelectItem> getTransactionTypeList() {
		return transactionTypeList;
	}

	public void setTransactionTypeList(List<SelectItem> transactionTypeList) {
		this.transactionTypeList = transactionTypeList;
	}

	public List<SelectItem> getPaymentMethodList() {
		return paymentMethodList;
	}

	public void setPaymentMethodList(List<SelectItem> paymentMethodList) {
		this.paymentMethodList = paymentMethodList;
	}

	public List<SelectItem> getBankList() {
		return bankList;
	}

	public void setBankList(List<SelectItem> bankList) {
		this.bankList = bankList;
	}

	public String getSelectedPaymentMethod() {
		return selectedPaymentMethod;
	}

	public void setSelectedPaymentMethod(String selectedPaymentMethod) {
		this.selectedPaymentMethod = selectedPaymentMethod;
	}

	public String getSelectedBank() {
		return selectedBank;
	}

	public void setSelectedBank(String selectedBank) {
		this.selectedBank = selectedBank;
	}

	public String getSelectedTransactionType() {
		return selectedTransactionType;
	}

	public void setSelectedTransactionType(String selectedTransactionType) {
		this.selectedTransactionType = selectedTransactionType;
	}

	public Date getSelectedChkDate() {
		return selectedChkDate;
	}

	public void setSelectedChkDate(Date selectedChkDate) {
		this.selectedChkDate = selectedChkDate;
	}

	public Date getToDay() {
		return toDay;
	}

	public void setToDay(Date toDay) {
		this.toDay = toDay;
	}
	
}
