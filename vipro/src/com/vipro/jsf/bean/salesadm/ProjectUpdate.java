package com.vipro.jsf.bean.salesadm;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;

import com.vipro.constant.BusinessPartnerTypeConst;
import com.vipro.constant.ProjectStatusConst;
import com.vipro.data.Discount;
import com.vipro.data.Project;
import com.vipro.data.ProjectInventory;
import com.vipro.data.SalesCommission;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.service.DiscountService;
import com.vipro.service.ProjectInventoryService;
import com.vipro.service.ProjectService;
import com.vipro.service.SalesCommissionService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.SpringBeanUtil;

@ManagedBean(name = "projectUpdate")
@SessionScoped
public class ProjectUpdate extends CommonBean implements Serializable {
	private List<Project> projects;
	private Long projectId;
	private Project project;
	private List<SelectItem> countries;
	private List<SelectItem> states;
	private List<SelectItem> cities;
	private List<SelectItem> propertyTypes;
	private List<SelectItem> institutions;
	private List<SelectItem> developers;
	private List<SelectItem> landProprietors;
	private List<SelectItem> reportGroups;
	private List<SelectItem> statusList;
	private String locationSearch;
	private int totalUnits;
	private double currentDiscount;
	private double salesCommission;
	private String commisionType;
	private Discount discount;
	private SalesCommission commission;
	/**
	 * inventory related properties
	 */
	private List<ProjectInventory> inventories;
	private ProjectInventory inventory;
	private List<SelectItem> propertyStatusList;
	private List<SelectItem> titleTypeList;
	private List<SelectItem> orientationList;

	public ProjectUpdate() {

	}

	@PostConstruct
	public void init() {
		countries = CodeUtil.getCodes("CT");
		cities = CodeUtil.getCodes("CI");
		states = CodeUtil.getCodes("ST");
		propertyTypes = CodeUtil.getCodes("PT");
		setReportGroups(CodeUtil.getCodes("RG"));
		propertyStatusList = CodeUtil.getPropertyStatusAsItems();
		titleTypeList = CodeUtil.getCodes("PL");
		orientationList = CodeUtil.getCodes("OR");
		statusList = CodeUtil.getCodes("SS");
		institutions = CodeUtil.getInstitutionAsItems();
		developers = CodeUtil.getBusinessPartnerAsItems(BusinessPartnerTypeConst.DEVELOPER);
		landProprietors = CodeUtil.getBusinessPartnerAsItems(BusinessPartnerTypeConst.LAND_PROPRIETOR);
		
		listProject();

	}
	
	public List<SelectItem> getPropertyStatusList() {
		return propertyStatusList;
	}

	public void setPropertyStatusList(List<SelectItem> propertyStatusList) {
		this.propertyStatusList = propertyStatusList;
	}

	public List<SelectItem> getTitleTypeList() {
		return titleTypeList;
	}

	public void setTitleTypeList(List<SelectItem> titleTypeList) {
		this.titleTypeList = titleTypeList;
	}

	public ProjectInventory getInventory() {
		return inventory;
	}

	public void setInventory(ProjectInventory inventory) {
		this.inventory = inventory;
	}

	public List<ProjectInventory> getInventories() {
		return inventories;
	}

	public void setInventories(List<ProjectInventory> inventories) {
		this.inventories = inventories;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public SalesCommission getCommission() {
		return commission;
	}

	public void setCommission(SalesCommission commission) {
		this.commission = commission;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public int getTotalUnits() {
		try {
			ProjectInventoryService projectInventoryService = 
					(ProjectInventoryService) SpringBeanUtil
					.lookup(ProjectInventoryService.class.getName());
			setTotalUnits(projectInventoryService.countTotalUnits(projectId));
		} catch (Throwable t) {
			addErrorMessage(t.getClass().getName(), t.getMessage());
		}
		return totalUnits;
	}

	public void setTotalUnits(int totalUnits) {
		this.totalUnits = totalUnits;
	}

	public double getCurrentDiscount() {
		return currentDiscount;
	}

	public void setCurrentDiscount(double currentDiscount) {
		this.currentDiscount = currentDiscount;
	}

	public double getSalesCommission() {
		return salesCommission;
	}

	public void setSalesCommission(double salesCommission) {
		this.salesCommission = salesCommission;
	}

	public String getLocationSearch() {
		return locationSearch;
	}

	public void setLocationSearch(String locationSearch) {
		this.locationSearch = locationSearch;
	}

	public List<SelectItem> getInstitutions() {
		return institutions;
	}

	public void setInstitutions(List<SelectItem> institutions) {
		this.institutions = institutions;
	}

	public List<SelectItem> getPropertyTypes() {
		return propertyTypes;
	}

	public void setPropertyTypes(List<SelectItem> propertyTypes) {
		this.propertyTypes = propertyTypes;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<SelectItem> getCountries() {
		return countries;
	}

	public void setCountries(List<SelectItem> countries) {
		this.countries = countries;
	}

	public List<SelectItem> getStates() {
		return states;
	}

	public void setStates(List<SelectItem> states) {
		this.states = states;
	}

	public List<SelectItem> getCities() {
		return cities;
	}

	public void setCities(List<SelectItem> cities) {
		this.cities = cities;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<SelectItem> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<SelectItem> statusList) {
		this.statusList = statusList;
	}

	public String getCommisionType() {
		return commisionType;
	}

	public void setCommisionType(String commisionType) {
		this.commisionType = commisionType;
	}

	public String listProject() {
		try {
			ProjectService projectService = (ProjectService) SpringBeanUtil
					.lookup(ProjectService.class.getName());
			projects = projectService.findAllProjects();
		} catch (Throwable t) {
			addErrorMessage(t.getClass().getName(), t.getMessage());
		}
		return "saListProject";
	}

	public String EditProject() {
		projectId = project.getProjectId();
		return "saEditProject";
	}
	
	public String saveProject() {
		try {
			ProjectService projectService = (ProjectService) SpringBeanUtil
					.lookup(ProjectService.class.getName());
			if(project.getStatus() == null) {
				project.setStatus(ProjectStatusConst.STATUS_ACTIVE);
			}
			projectService.insert(project);

			listProject();

			addInfoMessage("Project", "Project Saved");
		} catch (Throwable t) {
			addErrorMessage(t.getClass().getName(), t.getMessage());
		}

		return "saListProject";
	}

	public String toInventoryList() {
		try {
			if (project != null) {
				projectId = project.getProjectId();
			}

			ProjectInventoryService inventoryService = (ProjectInventoryService) SpringBeanUtil
					.lookup(ProjectInventoryService.class.getName());
			inventories = inventoryService.getInventories(projectId);
		} catch (Throwable t) {
			addErrorMessage(t.getClass().getName(), t.getMessage());
		}
		return "saListInventory";
	}

	public String editInventory() {
		inventory.setDiscountRate(project.getDiscountRate());
		return "saEditInventory";
	}

	public String saveInventory() {
		try {
			ProjectInventoryService inventoryService = (ProjectInventoryService) SpringBeanUtil
					.lookup(ProjectInventoryService.class.getName());
			inventory.setProject(project);
			validateInventoryKey(inventoryService);
			inventoryService.update(inventory);
			addInfoMessage("Property Unit", "Property Unit Saved");
		} catch (Throwable t) {
			addErrorMessage(t.getClass().getName(), t.getMessage());
			return null;
		}
		return toInventoryList();
	}

	public void validateInventoryKey(ProjectInventoryService inventoryService) throws Throwable {
		ProjectInventory inventoryDb = inventoryService.findByCompositeKey(inventory.getProject().getProjectId(),
				inventory.getBlockNo(), inventory.getUnitNo(),
				inventory.getLevel());
		if (inventoryDb != null) {
			if ((!inventoryDb.getInventoryId().equals(inventory.getInventoryId())) ||
				inventory.getInventoryId() == null) {
				throw new Throwable(
						"Inventory of given Block No, Unit No and Level has already been created for Project");
			} else {
				BeanUtils.copyProperties(inventory, inventoryDb);
				inventory = inventoryDb;
			}
		}
	}

	public List<SelectItem> getReportGroups() {
		return reportGroups;
	}

	public void setReportGroups(List<SelectItem> reportGroups) {
		this.reportGroups = reportGroups;
	}

	public List<SelectItem> getOrientationList() {
		return orientationList;
	}

	public void setOrientationList(List<SelectItem> orientationList) {
		this.orientationList = orientationList;
	}
	
	public List<SelectItem> getLandProprietors() {
		return landProprietors;
	}

	public void setLandProprietors(List<SelectItem> landProprietors) {
		this.landProprietors = landProprietors;
	}

	public List<SelectItem> getDevelopers() {
		return developers;
	}

	public void setDevelopers(List<SelectItem> developers) {
		this.developers = developers;
	}

}
