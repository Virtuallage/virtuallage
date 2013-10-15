package com.vipro.jsf.bean.salesadm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.primefaces.context.RequestContext;

import com.vipro.constant.CodeConst;
import com.vipro.constant.CommonConst;
import com.vipro.data.*;
import com.vipro.utils.spring.*;
import com.vipro.dto.ChangeAddressDTO;
import com.vipro.dto.ProgressiveBillingUnitSeachDTO;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.service.*;
import com.vipro.utils.spring.SpringBeanUtil;

@ManagedBean(name = "progressiveBillingUnitSearchBean")
@ViewScoped
public class ProgressiveBillingUnitSearchBean extends CommonBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2763159874232670517L;

	private ProjectService projectService;
	private Long selectedProjectId;
	private Project project = null;
	private String unit;
	private List<SelectItem> projects;
	private List<SelectItem> statesSIList;
	private ProgressiveBillingUnitSeachDTO selectedDto = new ProgressiveBillingUnitSeachDTO();
	private List<ProgressiveBillingUnitSeachDTO> dtoList;
	private Address corrAddress = new Address();
	private List<ChangeAddressDTO> addressDTOList = new ArrayList<ChangeAddressDTO>();
	private ChangeAddressDTO corrDTO = new ChangeAddressDTO( true);
	
	public ProgressiveBillingUnitSearchBean() {
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
								
				System.out.println("Size is  :"+dtoList.size());
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
		public void onSave(ActionEvent actionEvent) {
			// RequestContext context = RequestContext.getCurrentInstance();
			// boolean success = false;
			// AccountService service =
			// (AccountService)SpringBeanUtil.lookup(AccountService.class.getName());
			//
			// service.update(getSelectedDto().getAccount());
			//
			// setSelectedDto(new AdviseUpdateDetailsDTO());
			//
			// searchProject();
			//
			// CommonBean.addInfoMessage("Update Successful."," The Advise information has been updated successfully.");
			// success = true;
			// context.addCallbackParam("success", success);
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
	
}
