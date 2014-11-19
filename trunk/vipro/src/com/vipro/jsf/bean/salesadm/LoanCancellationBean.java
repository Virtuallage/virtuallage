package com.vipro.jsf.bean.salesadm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.activation.MimetypesFileTypeMap;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.vipro.constant.CodeConst;
import com.vipro.constant.CommonConst;
import com.vipro.constant.JasperConst;
import com.vipro.data.Project;
import com.vipro.dto.LoanCancellationDTO;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.service.AccountService;
import com.vipro.service.CodeService;
import com.vipro.service.ProjectService;
import com.vipro.utils.spring.SpringBeanUtil;


@ManagedBean(name = "loanCancellationBean")
@ViewScoped
public class LoanCancellationBean extends CommonBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -223101421389706685L;
	private ProjectService projectService;
	private Long selectedProjectId;
	private String unit;
	private List<SelectItem> projects;
	private LoanCancellationDTO selectedDto = new LoanCancellationDTO();
	private List<LoanCancellationDTO> dtoList;	
	private List<SelectItem> panelBankList;
	private List<SelectItem> purchaseTypeList;
	private Project project = null;
	
	public LoanCancellationBean() {
		
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
	
	private List<SelectItem> getCodeList(String code) {
		CodeService codeService = (CodeService) SpringBeanUtil.lookup(CodeService.class.getName());
		return codeService.getCodes(code);
	}
	
	public void saveAccount(ActionEvent actionEvent) {  
	        RequestContext context = RequestContext.getCurrentInstance();          

	        AccountService service = (AccountService)SpringBeanUtil.lookup(AccountService.class.getName());
	        boolean success = false; 
	        BigDecimal tempPurchaserPortion = (getSelectedDto().getAccount().getPurchasePrice().subtract(getSelectedDto().getAccount().getLoanAmount()));        
	        BigDecimal tempAmountBilled = getSelectedDto().getAccount().getBillingAmountTodate();
	        
	        if(tempPurchaserPortion.compareTo(tempAmountBilled) >= 0) {
	        	success = true;
	        }
	        
	        if(success) {
		        getSelectedDto().getAccount().setPurchaseType("PUCSH");
		        getSelectedDto().getAccount().setPanelBankId("");
		        getSelectedDto().getAccount().setLoanAmount(BigDecimal.ZERO);
		        getSelectedDto().getAccount().setLoSignedDate(null);
		        getSelectedDto().getAccount().setLoVerifiedBy(null);
		        getSelectedDto().getAccount().setLoVerifiedDate(null);
		        getSelectedDto().getAccount().setFinancierId(null);
		        getSelectedDto().getAccount().setFinancierRef(null);
		        getSelectedDto().getAccount().setLaRefNo(null);
		        getSelectedDto().getAccount().setLaSignedDate(null);
		        getSelectedDto().getAccount().setLaSolicitorId(null);
		        getSelectedDto().getAccount().setLaStampedDate(null);
		        getSelectedDto().getAccount().setLaVerifiedBy(null);
		        getSelectedDto().getAccount().setLaVerifiedDate(null);
		        getSelectedDto().getAccount().setBorrowerId1(null);
		        getSelectedDto().getAccount().setBorrowerId2(null);
		        getSelectedDto().getAccount().setRedemptionBankId(null);
		        getSelectedDto().getAccount().setDateChanged(new Date());
		        getSelectedDto().getAccount().setChangedBy(CommonBean.getCurrentUser().getUserProfile().getUserId());
		        service.update(getSelectedDto().getAccount());
		        
		        setSelectedDto(new LoanCancellationDTO());
		        refreshProjectSearch();
		        
		        CommonBean.addInfoMessage("Loan Cancellation Successful."," The Loan has been cancelled and purchser type is updated as Cash.");
		        context.addCallbackParam("success", success);  
	        } else {
		        CommonBean.addInfoMessage("Loan Cancellation Failed."," Financier invoice has been issued for this unit.");	        	
	        }
	        
	    }  
	
	public void closeAccount(ActionEvent actionEvent) {  
        RequestContext context = RequestContext.getCurrentInstance();  
        boolean success = true; 
        setSelectedDto(new LoanCancellationDTO());
        refreshProjectSearch();
        CommonBean.addInfoMessage("Details Closed."," Details windows closed.");
        context.addCallbackParam("success", success);  
    }  
	
	public void refreshProjectSearch(){
		if(selectedProjectId != null){
			dtoList = this.projectService.getLoanCancellationByProjectIdAndUnit(selectedProjectId,this.unit);
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
				dtoList = this.projectService.getLoanCancellationByProjectIdAndUnit(selectedProjectId,this.unit);
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

	public List<LoanCancellationDTO> getDtoList() {
		return dtoList;
	}

	public void setDtoList(List<LoanCancellationDTO> dtoList) {
		this.dtoList = dtoList;
	}

	public LoanCancellationDTO getSelectedDto() {
		return selectedDto;
	}

	public void setSelectedDto(LoanCancellationDTO selectedDto) {
		this.selectedDto = selectedDto;
	}

	public List<SelectItem> getPanelBankList() {
		panelBankList = getCodeList(CodeConst.BANK_NAME);
		return panelBankList;
	}

	public void setPanelBankList(List<SelectItem> panelBankList) {
		this.panelBankList = panelBankList;
	}

	public List<SelectItem> getPurchaseTypeList() {
		purchaseTypeList = getCodeList(CodeConst.PURCHASE_TYPE);
		return purchaseTypeList;
	}

	public void setPurchaseTypeList(List<SelectItem> purchaseTypeList) {
		this.purchaseTypeList = purchaseTypeList;
	}

}
