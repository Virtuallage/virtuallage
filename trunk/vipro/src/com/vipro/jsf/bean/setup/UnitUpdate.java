package com.vipro.jsf.bean.setup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Date;
import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.primefaces.model.StreamedContent;
import org.primefaces.component.inputtext.InputText;

import com.vipro.auth.AuthUser;
import com.vipro.constant.CommonConst;
import com.vipro.constant.PropertyUnitStatusConst;
import com.vipro.data.Account;
import com.vipro.data.Customer;
import com.vipro.data.DocumentReference;
import com.vipro.data.Project;
import com.vipro.data.ProjectInventory;
import com.vipro.data.UserProfile;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.service.AccountService;
import com.vipro.service.CustomerService;
import com.vipro.service.DocumentReferenceService;
import com.vipro.service.ProjectInventoryService;
import com.vipro.service.ProjectService;
import com.vipro.service.UserProfileService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.SpringBeanUtil;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.springframework.util.StringUtils;

@ManagedBean(name="unitUpdate")
@SessionScoped
public class UnitUpdate extends CommonBean implements Serializable{

	private List<Project> projects;
	private List<ProjectInventory> inventories;
	private List<SelectItem> listProject;
	private List<SelectItem> propertyStatusList;
	private List<SelectItem> layoutTypeList;
	private List<SelectItem> orientationList;
	private List<SelectItem> facingList;
	private List<SelectItem> viewList;
	
	private ProjectInventory inventory;
	private Account account;
	private Long projectId;
	private String unitNo;
	private Project project;
	private UserProfile attendedBy;
	private String CurrentStatus;
	private BigDecimal PurchasePrice;
	private BigDecimal DiscountAmount;
	private BigDecimal DiscountRate;
	private BigDecimal NetPrice;
		
	@PostConstruct
	public void init() {
		propertyStatusList = CodeUtil.getCodes("PS");
		layoutTypeList = CodeUtil.getCodes("LT");
		orientationList = CodeUtil.getCodes("OR");
		facingList = CodeUtil.getCodes("FC");
		viewList = CodeUtil.getCodes("VW");
	}
	
	public List<SelectItem> getPropertyStatusList() {
		return propertyStatusList;
	}

	public void setPropertyStatusList(List<SelectItem> propertyStatusList) {
		this.propertyStatusList = propertyStatusList;
	}
	
	public List<SelectItem> getLayoutTypeList() {
		return layoutTypeList;
	}

	public void setLayoutTypeList(List<SelectItem> layoutTypeList) {
		this.layoutTypeList = layoutTypeList;
	}

	public List<SelectItem> getOrientationList() {
		return orientationList;
	}

	public void setOrientationList(List<SelectItem> orientationList) {
		this.orientationList = orientationList;
	}
	
	public List<SelectItem> getFacingList() {
		return facingList;
	}

	public void setFacingList(List<SelectItem> facingList) {
		this.facingList = facingList;
	}

	public List<SelectItem> getViewList() {
		return viewList;
	}

	public void setViewList(List<SelectItem> viewList) {
		this.viewList = viewList;
	}
	
	public List<SelectItem> getListProject() {
		listProject = CodeUtil.getProjectAsItems();
		return listProject;
	}

	public void setListProject(List<SelectItem> listProject) {
		this.listProject = listProject;
	}
	
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<ProjectInventory> getInventories() {
		return inventories;
	}

	public void setInventories(List<ProjectInventory> inventories) {
		this.inventories = inventories;
	}

	public ProjectInventory getInventory() {
		return inventory;
	}

	public void setInventory(ProjectInventory inventory) {
		this.inventory = inventory;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public UserProfile getAttendedBy() {
		return attendedBy;
	}

	public void setAttendedBy(UserProfile attendedBy) {
		this.attendedBy = attendedBy;
	}

	public String getUnitNo() {
		return unitNo;
	}

	public void setUnitNo(String unitNo) {
		this.unitNo = unitNo;
	}
	
	public String getCurrentStatus() {
		return CurrentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		CurrentStatus = currentStatus;
	}

	public BigDecimal getPurchasePrice() {
		return PurchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		PurchasePrice = purchasePrice;
	}

	public BigDecimal getDiscountAmount() {
		return DiscountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		DiscountAmount = discountAmount;
	}

	public BigDecimal getDiscountRate() {
		return DiscountRate;
	}

	public void setDiscountRate(BigDecimal discountRate) {
		DiscountRate = discountRate;
	}

	
	public String listProject() {
		ProjectService projectService = (ProjectService) SpringBeanUtil
				.lookup(ProjectService.class.getName());
		projects = projectService.findAllProjects();
		
		return "unitList";
	}

	public String listUnits(){
		listProject = CodeUtil.getProjectAsItems();

		ProjectService projectService = (ProjectService) SpringBeanUtil.lookup(ProjectService.class.getName());	
		ProjectInventoryService inventoryService = (ProjectInventoryService) SpringBeanUtil.lookup(ProjectInventoryService.class.getName());

		project = projectService.findById(projectId);
		
		if (StringUtils.hasText(unitNo)) {
			inventories = inventoryService.getInventories(projectId, unitNo);;
		} else {
			inventories = inventoryService.getInventories(projectId);
		}
		
		return "unitList";
	}
	
	public String selectUnit() {
		
		CurrentStatus = inventory.getPropertyStatus();
		PurchasePrice = inventory.getPurchasePrice();
		DiscountAmount = inventory.getDiscountAmount();
		DiscountRate = inventory.getDiscountRate();
		NetPrice = inventory.getNetPrice();
		
		return "editUnit";
		
	}
	
	public String saveUnit() {

		if (!inventory.getPropertyStatus().equals(CurrentStatus)) {
			if (CurrentStatus.equals(PropertyUnitStatusConst.STATUS_CANCELLED) ||
				CurrentStatus.equals(PropertyUnitStatusConst.STATUS_LOCKED)) {
				if (!inventory.getPropertyStatus().equalsIgnoreCase(PropertyUnitStatusConst.STATUS_AVAILABLE)) {
					addErrorMessage("WARNING!",	"You can only change the status to AVAILABLE.");
					inventory.setPropertyStatus(CurrentStatus);
					return selectUnit();	
				}
			} else {
				addErrorMessage("WARNING!",	"You Cannot change the Status if the Status is Not CANCELLED or LOCKED.");
				inventory.setPropertyStatus(CurrentStatus);
				return selectUnit();
			}
		}
		
		String updAccount = "N"; 
		if (!inventory.getPurchasePrice().equals(PurchasePrice) || 
			!inventory.getDiscountAmount().equals(DiscountAmount) || 
			!inventory.getDiscountRate().equals(DiscountRate)) {
			if (CurrentStatus.equals(PropertyUnitStatusConst.STATUS_CANCELLED) ||
				CurrentStatus.equals(PropertyUnitStatusConst.STATUS_LOCKED)) {
				addErrorMessage("WARNING!",	"You Cannot change the pricing if the Status is CANCELLED or LOCKED");
				inventory.setPurchasePrice(PurchasePrice);
				return selectUnit();
			} else {
				updAccount = "Y";
			}
		} else {
			updAccount = "Y";
		}

		BigDecimal zeroAmount = new BigDecimal(0);		
		if (inventory.getDiscountRate().compareTo(zeroAmount) > 0) {
			inventory.setDiscountAmount(inventory.getPurchasePrice().multiply(inventory.getDiscountRate()).divide(new BigDecimal(100)));
		} 
		inventory.setNetPrice(inventory.getPurchasePrice().subtract(inventory.getDiscountAmount()));

		ProjectInventoryService inventoryService = (ProjectInventoryService) SpringBeanUtil.lookup(ProjectInventoryService.class.getName());			
		AuthUser user = getCurrentUser();
		inventory.setChangeUserId(user.getUserProfile().getUserId());

		inventory.setStatusChangeDate(new Date());
		inventoryService.update(inventory);

// check and update account data, if any
		if (updAccount == "Y") {	
			AccountService accountService = (AccountService) SpringBeanUtil.lookup(AccountService.class.getName());
			List<Account> accounts = accountService.findByProjectInventoryId(inventory.getInventoryId());

			for (Account account : accounts) {
				if (account.getAccountId() == null) {
					addErrorMessage("WARNING!",	"There is no sales recorded for this unit, please contact your System Support (Account = Null). ");
					inventory.setPurchasePrice(PurchasePrice);
					inventory.setDiscountAmount(DiscountAmount);				
					inventory.setDiscountRate(DiscountRate);
					inventory.setNetPrice(NetPrice);
					inventoryService.update(inventory);
					return selectUnit();
				} else {
					if (!account.getAccountStatus().equalsIgnoreCase(CommonConst.STATUS_CANCELLED) &&
						!account.getAccountStatus().equalsIgnoreCase(CommonConst.STATUS_ACTIVE)	) {
						account.setPurchasePrice(inventory.getPurchasePrice());
						account.setDiscountedAmount(inventory.getDiscountAmount());
						account.setNetPrice(inventory.getNetPrice());
						account.setChangedBy(user.getUserProfile().getUserId());
						account.setDateChanged(new Date());		
						accountService.update(account);
					} else {
						addErrorMessage("WARNING!",	"This unit has been billed, you cannot change Price/Discount.");
						inventory.setPurchasePrice(PurchasePrice);
						inventory.setDiscountAmount(DiscountAmount);				
						inventory.setDiscountRate(DiscountRate);
						inventory.setNetPrice(NetPrice);
						inventoryService.update(inventory);
						return selectUnit();
					}
				}
			}	
		}

		addInfoMessage("INFORMATION", "Property Unit Update Completed Successfully.");
		return listUnits();
		
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public BigDecimal getNetPrice() {
		return NetPrice;
	}

	public void setNetPrice(BigDecimal netPrice) {
		NetPrice = netPrice;
	}

}
