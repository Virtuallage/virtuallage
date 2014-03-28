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
import java.util.Collections;
import java.util.List;

import javax.activation.MimetypesFileTypeMap;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.primefaces.component.selectbooleancheckbox.SelectBooleanCheckbox;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.vipro.constant.CodeConst;
import com.vipro.constant.CommonConst;
import com.vipro.constant.JasperConst;
import com.vipro.constant.ProgressiveBillingConst;
import com.vipro.data.Address;
import com.vipro.data.Customer;
import com.vipro.data.Project;
import com.vipro.dto.BillingModelStageDTO;
import com.vipro.dto.ChangeAddressDTO;
import com.vipro.dto.ProgressiveBillingUnitSeachDTO;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.service.CustomerService;
import com.vipro.service.ProgressiveBillingService;
import com.vipro.service.ProjectService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.NumberConverter;
import com.vipro.utils.spring.SpringBeanUtil;

@ManagedBean(name = "renoticeUnitSearchBean")
@ViewScoped
public class RenoticeUnitSearchBean extends CommonBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2763159874232670517L;

	private ProjectService projectService;
	private Long selectedProjectId;
	private Project project = null;
	private String unit;
	private String ttlAmount;
	private List<SelectItem> projects;
	private List<SelectItem> statesSIList;
	private ProgressiveBillingUnitSeachDTO selectedDto = new ProgressiveBillingUnitSeachDTO();
	private List<ProgressiveBillingUnitSeachDTO> dtoList;
	private Address corrAddress = new Address();
	private List<ChangeAddressDTO> addressDTOList = new ArrayList<ChangeAddressDTO>();
	private ChangeAddressDTO corrDTO = new ChangeAddressDTO( true);
	private BigDecimal percent = new BigDecimal(100);
	private List<BillingModelStageDTO> selectedStageDtoList = new ArrayList<BillingModelStageDTO>();
	private Long invoiceNo = new Long(1l);
	private StreamedContent fileToDownload;
	private BigDecimal financierPortion = new BigDecimal(0.00);
	private BigDecimal financierStageAmount = new BigDecimal(0.00);	
	private BigDecimal purchaserPortion = new BigDecimal(0.00);
	private BigDecimal purchaserStageAmount = new BigDecimal(0.00);
	
	public RenoticeUnitSearchBean() {
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
	
	public String searchProject(){
		try{
			String selectedProjectIdStr = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("pbUSearchForm:projectList_input");
			if(selectedProjectIdStr != null){
				selectedProjectId = Long.parseLong(selectedProjectIdStr);
				dtoList = this.projectService.getProgressiveBillingUnitSearchDTOListByProjectIdAndUnit(selectedProjectId,this.unit);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
		public void onView(ActionEvent actionEvent) {
			
		}
	
		private File getBaseFolder(Long accountId){
			File baseFolder = new File(CommonConst.PROGRESSIVE_BILL_FOLDER_NAME);
			if(accountId != null){
				 baseFolder = new File(JasperConst.ACCOUNTS_FOLDER+"/"+accountId.toString()+"/"+CommonConst.PROGRESSIVE_BILL_FOLDER_NAME);
				 if(!baseFolder.exists()){
					 baseFolder.mkdirs();
					}
			}
				 return baseFolder;
		}
		
		public void handleFileUpload(FileUploadEvent event) {
			try{
					 
				 if(getSelectedDto().getAccount().getAccountId() != null){
					 
					File targetFolder = getBaseFolder(getSelectedDto().getAccount().getAccountId());
					InputStream inputStream = event.getFile().getInputstream();
					OutputStream out = new FileOutputStream(new File(targetFolder,event.getFile().getFileName()));
					int read = 0;
					byte[] bytes = new byte[1024];
					while((read = inputStream.read(bytes)) != -1){
						out.write(bytes,0,read);
					}
					inputStream.close();
					out.flush();
					out.close();
					CommonBean.addInfoMessage("Upload Successful."," The document is stored at "+targetFolder.getAbsolutePath());
				 }
			}catch(IOException io){
				io.printStackTrace();
			}
		}
		
		
		 public List<StreamedContent> getAllUploadedFiles() {
			 List<StreamedContent> fileList = new ArrayList<StreamedContent>();
			 
			 if(getSelectedDto().getAccount().getAccountId() != null){
				 File baseFolder =  getBaseFolder(getSelectedDto().getAccount().getAccountId());
			 
			 File[] filesArray = baseFolder.listFiles();

			 if (filesArray != null) {
			     for (File ufile : filesArray) {
			     InputStream stream = null;
			     try {
			    	 String filePath = ufile.getAbsolutePath();
			         stream = new FileInputStream(filePath);
			         MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
					 String mimeType = mimeTypesMap.getContentType(filePath);
			         StreamedContent file = new DefaultStreamedContent(stream,mimeType,ufile.getName());
			         fileList.add(file);
			     } catch (FileNotFoundException e) {
			         e.printStackTrace();
			     }
			     try {
			         stream.close();
			     } catch (IOException e) {
			         // TODO Auto-generated catch block
			         e.printStackTrace();
			     }
			     }
			     Collections.reverse(fileList);
			 }

			 }
			 return fileList;
			 }
		 public void prepareFileToDownload(final StreamedContent arq) {
				try{
					 if(getSelectedDto().getAccount().getAccountId() != null){
						 File baseFolder = getBaseFolder(getSelectedDto().getAccount().getAccountId());					 
						 String fileName =baseFolder.getPath()+"/"+arq.getName();
						MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
						String mimeType = mimeTypesMap.getContentType(fileName);
						InputStream stream = new FileInputStream(fileName);
						this.fileToDownload = new DefaultStreamedContent(stream,mimeType,arq.getName());
					 }
				}catch(IOException e){
					e.printStackTrace();
				}
				}
		 
		public void onClose(ActionEvent actionEvent) {
			 RequestContext context = RequestContext.getCurrentInstance();
			 boolean success = true;
//			 setSelectedDto(new AdviseUpdateDetailsDTO());
//			 refreshProjectSearch();
			 CommonBean.addInfoMessage("Details Closed."," Details window closed.");
			 context.addCallbackParam("success", success);
		}
		

		public void onCloseChangeAddress(ActionEvent actionEvent) {
			 RequestContext context = RequestContext.getCurrentInstance();
			 boolean success = true;
			 clearAddressChange();
			 CommonBean.addInfoMessage("Change Address Closed."," Change Address window closed.");
			 context.addCallbackParam("success", success);
		}
		
		public void onSaveChangeAddress(ActionEvent actionEvent) {
			 RequestContext context = RequestContext.getCurrentInstance();
			 boolean success = true;
			 
			 ProgressiveBillingService service = (ProgressiveBillingService)SpringBeanUtil.lookup(ProgressiveBillingService.class.getName());
			 			 
			 if(getCorrDTO().isCorrAddress()){
				 service.changeAddress(getCorrDTO(), getSelectedDto().getAccount());
				 setCorrAddress(getCorrDTO().getAddress());				 
			 }
			 
//			 if(getAdrs2DTO().isCorrAddress()){
//				 service.changeAddress(getAdrs2DTO(), getSelectedDto().getAccount());
//				 setCorrAddress(getAdrs2DTO().getAddress());
//			 }

			 this.addressDTOList.clear();
			 //clearAddressChange();
			 CommonBean.addInfoMessage("Address Updated"," Address details updated successfully");
			 context.addCallbackParam("success", success);
		}
		
		public void onChangeAddress(){
			CustomerService cusService = (CustomerService)SpringBeanUtil.lookup(CustomerService.class.getName());
			clearAddressChange();
			Long corrCustId = getSelectedDto().getAccount().getCorrAddrCustId();
			if(corrCustId != null){
				getCorrDTO().setCustomer(cusService.findCustomerWithAddressByCustId(corrCustId));
				getCorrDTO().setAddress((Address)getCorrDTO().getCustomer().getAddresses().iterator().next());
				getCorrDTO().setCorrAddress(true);
			}
			
			getAddressDTOList().add(getCorrDTO());
			fillChangeAddressDTO(getSelectedDto().getAccount().getCustomer(), corrCustId, cusService) ;
			fillChangeAddressDTO(getSelectedDto().getAccount().getCustomer2(), corrCustId, cusService);
			fillChangeAddressDTO(getSelectedDto().getAccount().getCustomer3(), corrCustId, cusService);
			fillChangeAddressDTO(getSelectedDto().getAccount().getCustomer4(), corrCustId, cusService);
			fillChangeAddressDTO(getSelectedDto().getAccount().getCustomer5(), corrCustId, cusService);	
		}
	
	private ChangeAddressDTO fillChangeAddressDTO(Customer c, Long corrCustId, CustomerService cusService){
		ChangeAddressDTO dto =null;
		if(c != null && !corrCustId.equals(c.getCustomerId())){							
			dto = new ChangeAddressDTO();
			dto.setCustomer(cusService.findCustomerWithAddressByCustId(c.getCustomerId()));
			if( dto.getCustomer().getAddresses()!= null && !dto.getCustomer().getAddresses().isEmpty())
			{
				dto.setAddress((Address)dto.getCustomer().getAddresses().iterator().next());
			}else {
				dto.setAddress(new Address());
			}
			dto.setCorrAddress(false);
		}
		if(dto != null){
			getAddressDTOList().add(dto);
		}
		return dto;
	}
		
	public String onDtoSelection(){
		CustomerService cusService = (CustomerService)SpringBeanUtil.lookup(CustomerService.class.getName());
		ProgressiveBillingService pbService = (ProgressiveBillingService)SpringBeanUtil.lookup(ProgressiveBillingService.class.getName());
		
		getSelectedDto().setStageDtoList(pbService.getBillingModelListByProjectBillingModelCode(
				selectedProjectId, getSelectedDto().getProject().getBillingModelCode(), getSelectedDto().getAccount().getAccountId()));

		setCorrAddress(new Address());
		//this.corrAddress = adrService.findByCustomerId((getSelectedDto().getAccount().getCorrAddrCustId()));
		clearAddressChange();
		
		getCorrDTO().setCustomer(cusService.findCustomerWithAddressByCustId(getSelectedDto().getAccount().getCorrAddrCustId()));
		getCorrDTO().setAddress((Address)getCorrDTO().getCustomer().getAddresses().iterator().next());
		getCorrDTO().setCorrAddress(true);
		return null;
	}
	
	public void clearAddressChange(){
		
		this.setCorrDTO(new ChangeAddressDTO());
		this.addressDTOList.clear();
	}
	public void corrAddressChecked(ValueChangeEvent event) {  
		boolean newValue = (Boolean) event.getNewValue();
		
		int index = (Integer) event.getComponent().getAttributes().get("index"); 
		
		if(!newValue && index == 0 ){
			index = 1;
			getAddressDTOList().get(1).setCorrAddress(true);
			setCorrDTO(getAddressDTOList().get(1));
		}else if (!newValue && index != 0){
			getAddressDTOList().get(0).setCorrAddress(true);
			setCorrDTO(getAddressDTOList().get(0));
		}
		
		if(newValue){ //if true reset all to false;
			for (int i = 0; i < addressDTOList.size(); i++) {
				if(i != index){
					getAddressDTOList().get(i).setCorrAddress(false);
				}else{
					setCorrDTO(getAddressDTOList().get(i));
				}
			}
		}
		CommonBean.addInfoMessage("Check box clicked."," Corr Address is Changed");
    }  
	
	public void onStageSelection(ValueChangeEvent event) {  
		boolean newValue = (Boolean) event.getNewValue();	
		int index = (Integer) event.getComponent().getAttributes().get("index");
		
		BillingModelStageDTO selectedDto = getSelectedDto().getStageDtoList().get(index);
		selectedDto.setBillMe(newValue);
		if(newValue){
			if(index > 0){
				boolean isFirstSelection = false, isSkip = false, wrongSelection = false;
				for (int i = 0; i < getSelectedDto().getStageDtoList().size(); i++) {
					BillingModelStageDTO dto =  getSelectedDto().getStageDtoList().get(i);
					if(!ProgressiveBillingConst.STAGE_RENOTICED.equals(dto.getStatus())){
						if(dto.isBillMe()){
							if (isFirstSelection && isSkip) {
								wrongSelection = true;
								break;
							} else {
								isFirstSelection = true;
							}														
						}else{
							if(isFirstSelection){
								 isSkip = true;
							}
							}
						}
					}//end for					
				if(wrongSelection){
					CommonBean.addErrorMessage("Cannot Skip Stages", "Cannot Skip stages in between!");
					 SelectBooleanCheckbox chckbox = (SelectBooleanCheckbox) event.getSource();
					 chckbox.setValue(false);;
				}
				
			}
		}else{
			if (index < getSelectedDto().getStageDtoList().size()) {
				for (int i = index+1; i < getSelectedDto().getStageDtoList()
						.size(); i++) {
					BillingModelStageDTO nextDto = getSelectedDto()
							.getStageDtoList().get(i);
					if (nextDto.isBillMe()) {
						nextDto.setBillMe(false);
					} else {
						break;
					}
				}
			}
		}
	}
	
	/************** Renotice Actions *********************/
	public void onRenoticeAction() {
		 boolean isRightSelection = false;	
		 boolean isCleared = true;
		 boolean firstTime = true;
		 int firstSeq = 0;
		 BigDecimal firstAmount = new BigDecimal(0);
		 setSelectedStageDtoList(new ArrayList<BillingModelStageDTO>());
		 this.ttlAmount = "";
		 BillingModelStageDTO sumDTO = new BillingModelStageDTO();
		 BigDecimal amountTtl = new BigDecimal(0);
		 BigDecimal percentTtl = new BigDecimal(0);
		 BigDecimal stageTtl = new BigDecimal(0);	
		 
		 if (getSelectedDto().getAccount().getLoanAmount().compareTo(BigDecimal.ZERO) == 0) {
			 CommonBean.addInfoMessage("WARNING","Loan Amount is Empty! Please key in the Loan Amount before proceeding.");
			 isCleared = false;
		 }
		 if (getSelectedDto().getAccount().getLoanAmount().compareTo(BigDecimal.ZERO) == 0) {
			 CommonBean.addInfoMessage("WARNING","Loan Amount is Missing! Please key in the Loan Amount before proceeding.");
			 isCleared = false;
		 }
		 if (getSelectedDto().getAccount().getFinancierId() == null) {
			 CommonBean.addInfoMessage("WARNING","Financier is Missing! Please select the Financier before proceeding.");
			 isCleared = false;
		 }
		 if (getSelectedDto().getAccount().getFinancierRef() == null) {
			 CommonBean.addInfoMessage("WARNING","LO Reference is Missing! Please key in the Financier Reference before proceeding.");
			 isCleared = false;
		 }
		 if (getSelectedDto().getAccount().getLaSolicitorId() == null) {
			 CommonBean.addInfoMessage("WARNING","LA Solicitor is Missing! Please select the LA Solicitor before proceeding.");
			 isCleared = false;
		 }
		 if (getSelectedDto().getAccount().getBorrowerId1() == null) {
			 CommonBean.addInfoMessage("WARNING","Borrower Name is Missing! Please Add at least 1 borrower before proceeding.");
			 isCleared = false;
		 }
		 		 
		 purchaserPortion = getSelectedDto().getAccount().getPurchasePrice().subtract(getSelectedDto().getAccount().getLoanAmount());
		 
		 if (isCleared) {
			 for (BillingModelStageDTO dto : getSelectedDto().getStageDtoList()) {
//			if(!dto.isBillMe() && (ProgressiveBillingConst.STAGE_BILLED.equals(dto.getStatus()) || ProgressiveBillingConst.STAGE_PAID.equals(dto.getStatus()))){
//				isRightSelection = false;
//				break;
//			}
				 if (firstTime) {
					 stageTtl = stageTtl.add(getSelectedDto().getAccount().getPurchasePrice().multiply(dto.getBillingModel().getBillingPercentage()).divide(this.percent));
				 }
				 if(dto.isBillMe()){
					 if (firstTime) {
						 firstSeq = dto.getBillingModel().getBillingSeq();
						 firstAmount = getSelectedDto().getAccount().getPurchasePrice().multiply(dto.getBillingModel().getBillingPercentage()).divide(this.percent);
						 firstTime = false;
					 }
					 if (dto.getBillingModel().getBillingSeq() == 1) {
						 CommonBean.addInfoMessage("WARNING","You cannot perform Renotice on 1st Stage! Please choose other stages.");
						 break;
					 }
					 isRightSelection = true;
					 amountTtl = amountTtl.add(getSelectedDto().getAccount().getPurchasePrice().multiply(dto.getBillingModel().getBillingPercentage()).divide(this.percent));
					 percentTtl = percentTtl.add(dto.getBillingModel().getBillingPercentage());
					 selectedStageDtoList.add(dto);
				 }		 
			 }
			 if (purchaserPortion.compareTo(stageTtl) >= 0) {
				 CommonBean.addInfoMessage("WARNING","Loan Amount is insufficient to cover for this stage! Please choose later stage or increase the Loan Amount.");
				 isRightSelection = false;
			 } else {
				 financierStageAmount = stageTtl.subtract(purchaserPortion);
				 if (financierStageAmount.compareTo(firstAmount) > 0) {
					 CommonBean.addInfoMessage("WARNING","Loan Amount is more than this stage amount! Please choose earlier stage or reduce the Loan Amount.");
					 isRightSelection = false;					 
				 }
				 purchaserStageAmount = firstAmount.subtract(financierStageAmount);
				 financierPortion = amountTtl.subtract(purchaserStageAmount);
			 }
			 
			 if(!selectedStageDtoList.isEmpty() && isRightSelection){
				 sumDTO.getBillingModel().setBillingPercentage(percentTtl);
				 sumDTO.getProgressiveBilling().setAmountBilled(amountTtl);
				 sumDTO.getBillingModel().setDescription("Total");
				 selectedStageDtoList.add(sumDTO);
				 this.ttlAmount = NumberConverter.convertDigitTextOnly(amountTtl);
			
				 ProgressiveBillingService pbService = (ProgressiveBillingService)SpringBeanUtil.lookup(ProgressiveBillingService.class.getName());
				 this.setInvoiceNo(pbService.getAndUpdteSeqNO(getSelectedDto().getProject().getProjectCode(), ProgressiveBillingConst.RB_INVOICE_SEQ_TYPE, true));			
			 }

			 if(isRightSelection){
				 RequestContext.getCurrentInstance().execute("dlg3.show()");
			 }
		 }	
	}
	
	public void onCancelBillConfirmation(){
		 RequestContext context = RequestContext.getCurrentInstance();
		 boolean success = true;
		 getSelectedStageDtoList().clear();
		 ProgressiveBillingService pbService = (ProgressiveBillingService)SpringBeanUtil.lookup(ProgressiveBillingService.class.getName());
		 pbService.getAndUpdteSeqNO(getSelectedDto().getProject().getProjectCode(), ProgressiveBillingConst.RB_INVOICE_SEQ_TYPE, false);
		 setInvoiceNo(new Long(1l));
		 CommonBean.addInfoMessage("Renotice Stages Window Closed.","");
		 context.addCallbackParam("success2", success);
	}
	
	public void onConfirmBill(){

		RequestContext context = RequestContext.getCurrentInstance();
		boolean success = true;
		ProgressiveBillingService pbService = (ProgressiveBillingService)SpringBeanUtil.lookup(ProgressiveBillingService.class.getName());
		
		boolean isSucessfull = pbService.generateRenoticesForSelectedStages(selectedStageDtoList, getInvoiceNo() ,getInvoiceNoFormated(), getSelectedDto(), purchaserStageAmount);
		
		if(isSucessfull){
			//BigDecimal amountTotal = selectedStageDtoList.get(selectedStageDtoList.size()).getProgressiveBilling().getAmountBilled();
			pbService.printRenoticeLetter(this.ttlAmount ,getSelectedDto().getProject().getProjectId(), getInvoiceNoFormated(), getSelectedDto().getAccount().getAccountId().toString(), financierPortion, purchaserPortion);
		}
		//Update StageDTOList from DB.
		getSelectedDto().setStageDtoList(pbService.getBillingModelListByProjectBillingModelCode(
				selectedProjectId, getSelectedDto().getProject().getBillingModelCode(), getSelectedDto().getAccount().getAccountId()));

		CommonBean.addInfoMessage("Renotice Processed Successfully.","The Renotice letter is ready for printing.");
		
		getSelectedStageDtoList().clear();
		setInvoiceNo(new Long(01));
		context.addCallbackParam("success2", success);
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

	public List<ProgressiveBillingUnitSeachDTO> getDtoList() {
		return dtoList;
	}

	public void setDtoList(List<ProgressiveBillingUnitSeachDTO> dtoList) {
		this.dtoList = dtoList;
	}

	public ProgressiveBillingUnitSeachDTO getSelectedDto() {
		return selectedDto;
	}

	public void setSelectedDto(ProgressiveBillingUnitSeachDTO selectedDto) {
		this.selectedDto = selectedDto;
	}

	public Address getCorrAddress() {
		return corrAddress;
	}

	public void setCorrAddress(Address corrAddress) {
		this.corrAddress = corrAddress;
	}

	public ChangeAddressDTO getCorrDTO() {
		return corrDTO;
	}

	public void setCorrDTO(ChangeAddressDTO corrDTO) {
		this.corrDTO = corrDTO;
	}

	public List<ChangeAddressDTO> getAddressDTOList() {
		return addressDTOList;
	}

	public void setAddressDTOList(List<ChangeAddressDTO> addressDTOList) {
		this.addressDTOList = addressDTOList;
	}

	public List<SelectItem> getStatesSIList() {
		if(statesSIList == null){
			statesSIList = CodeUtil.getCodes(CodeConst.STATE);
		}
		
		return statesSIList;
	}

	public void setStatesSIList(List<SelectItem> statesSIList) {
		this.statesSIList = statesSIList;
	}

	public BigDecimal getPercent() {
		return percent;
	}

	public void setPercent(BigDecimal percent) {
		this.percent = percent;
	}

	public List<BillingModelStageDTO> getSelectedStageDtoList() {
		return selectedStageDtoList;
	}

	public void setSelectedStageDtoList(
			List<BillingModelStageDTO> selectedStageDtoList) {
		this.selectedStageDtoList = selectedStageDtoList;
	}

	public Long getInvoiceNo() {
		return invoiceNo;
	}

	public String getInvoiceNoFormated() {
		return String.format("RI%04d%n", this.invoiceNo);
	}
	
	public void setInvoiceNo(Long invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public StreamedContent getFileToDownload() {
		return fileToDownload;
	}

	public void setFileToDownload(StreamedContent fileToDownload) {
		this.fileToDownload = fileToDownload;
	}
	
}
