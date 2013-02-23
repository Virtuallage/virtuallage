package com.vipro.jsf.bean.sales;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.vipro.constant.ProjectStatusConst;
import com.vipro.data.Discount;
import com.vipro.data.Project;
import com.vipro.data.ProjectInventory;
import com.vipro.data.SalesCommission;
import com.vipro.service.DiscountService;
import com.vipro.service.ProjectInventoryService;
import com.vipro.service.ProjectService;
import com.vipro.service.SalesCommissionService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.FacesUtil;
import com.vipro.utils.spring.SpringBeanUtil;

@ManagedBean(name = "projectSetup")
@SessionScoped
public class ProjectSetup implements Serializable {
	/**
	 * project related propertiess
	 */
	private List<Project> projects;
	private List<Discount> discounts;
	private List<SalesCommission> commissions;
	private Long projectId;
	private Project project;
	private List<SelectItem> countries;
	private List<SelectItem> states;
	private List<SelectItem> cities;
	private List<SelectItem> propertyTypes;
	private List<SelectItem> institutions;
	private String locationSearch;

	private int totalUnits;
	private double priceRangeFrom;
	private double priceRangeTo;
	private double currentDiscount;
	private Date discountExpiry;
	private double salesCommission;
	private Date commisionEffective;
	private Discount discount;
	private SalesCommission commission;

	/**
	 * inventory related properties
	 */
	private List<ProjectInventory> inventories;
	private ProjectInventory inventory;
	private List<SelectItem> propertyStatusList;
	private List<SelectItem> titleTypeList;

	public ProjectSetup() {

	}

	@PostConstruct
	public void init() {
		countries = CodeUtil.getCodes("COUNTRY");
		cities = CodeUtil.getCodes("CITY");
		states = CodeUtil.getCodes("STATE");
		propertyTypes = CodeUtil.getCodes("PROP_TYPE");
		propertyStatusList = CodeUtil.getPropertyStatusAsItems();
		titleTypeList = CodeUtil.getCodes("TITLE_TYPE");
		institutions = CodeUtil.getInstitutionAsItems();
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

	public List<Discount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<Discount> discounts) {
		this.discounts = discounts;
	}

	public List<SalesCommission> getCommissions() {
		return commissions;
	}

	public void setCommissions(List<SalesCommission> commissions) {
		this.commissions = commissions;
	}

	public int getTotalUnits() {
		return totalUnits;
	}

	public void setTotalUnits(int totalUnits) {
		this.totalUnits = totalUnits;
	}

	public double getPriceRangeFrom() {
		return priceRangeFrom;
	}

	public void setPriceRangeFrom(double priceRangeFrom) {
		this.priceRangeFrom = priceRangeFrom;
	}

	public double getPriceRangeTo() {
		return priceRangeTo;
	}

	public void setPriceRangeTo(double priceRangeTo) {
		this.priceRangeTo = priceRangeTo;
	}

	public double getCurrentDiscount() {
		return currentDiscount;
	}

	public void setCurrentDiscount(double currentDiscount) {
		this.currentDiscount = currentDiscount;
	}

	public Date getDiscountExpiry() {
		return discountExpiry;
	}

	public void setDiscountExpiry(Date discountExpiry) {
		this.discountExpiry = discountExpiry;
	}

	public double getSalesCommission() {
		return salesCommission;
	}

	public void setSalesCommission(double salesCommission) {
		this.salesCommission = salesCommission;
	}

	public Date getCommisionEffective() {
		return commisionEffective;
	}

	public void setCommisionEffective(Date commisionEffective) {
		this.commisionEffective = commisionEffective;
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

	public String listProject() {
		ProjectService projectService = (ProjectService) SpringBeanUtil
				.lookup(ProjectService.class.getName());
		projects = projectService.findAllProjects();
		return "project";
	}

	public String addNewProject() {
		project = new Project();
		return "newProject";
	}

	public String editProject() {
		try {
			ProjectService projectService = (ProjectService) SpringBeanUtil
					.lookup(ProjectService.class.getName());
			projectId = project.getProjectId();
	
			DiscountService discountService = (DiscountService) SpringBeanUtil
					.lookup(DiscountService.class.getName());
			discounts = discountService.findByProjectId(projectId);
	
			SalesCommissionService salesCommissionService = (SalesCommissionService) SpringBeanUtil
					.lookup(SalesCommissionService.class.getName());
	
			commissions = salesCommissionService.findByProjectId(projectId);
	
			discount = new Discount();
			commission = new SalesCommission();
	
			refreshCommissionDiscount();
		} catch (Throwable t) {
			FacesUtil.addErrorMessage(t.getClass().getName(), t.getMessage());
		}

		return "newProject";
	}

	public String saveProject() {
		try {
			ProjectService projectService = (ProjectService) SpringBeanUtil
					.lookup(ProjectService.class.getName());
			project.setStatus(ProjectStatusConst.STATUS_ACTIVE);
			projectService.insert(project);
	
			listProject();
	
			discount = new Discount();
			commission = new SalesCommission();
	
			refreshCommissionDiscount();
			FacesUtil.addInfoMessage("Project", "Project Saved");
		} catch (Throwable t) {
			FacesUtil.addErrorMessage(t.getClass().getName(), t.getMessage());
		}

		return "project";
	}

	public void refreshCommissionDiscount() {
		DiscountService discountService = (DiscountService) SpringBeanUtil
				.lookup(DiscountService.class.getName());
		SalesCommissionService salesCommissionService = (SalesCommissionService) SpringBeanUtil
				.lookup(SalesCommissionService.class.getName());

		Discount d = discountService.findCurrentEffectiveDiscount(projectId);
		SalesCommission s = salesCommissionService
				.findCurrentEffectiveSalesCommission(projectId);

		if (d != null) {
			this.currentDiscount = d.getDiscountRate().doubleValue();
			this.discountExpiry = d.getExpiryDate();
		}
		if (s != null) {
			this.commisionEffective = s.getEffectiveDate();
			this.salesCommission = s.getAmountOrRate().doubleValue();
		}
	}

	public String addDiscount() {
		try {
			DiscountService discountService = (DiscountService) SpringBeanUtil
					.lookup(DiscountService.class.getName());
			discount.setProject(project);
			discount.setCreatedOn(new Date());
			discountService.insert(discount);
			discounts = discountService.findByProjectId(projectId);
			discount = new Discount();
			refreshCommissionDiscount();
			FacesUtil.addInfoMessage("Discount", "Discount Added");
		} catch (Throwable t) {
			FacesUtil.addErrorMessage(t.getClass().getName(), t.getMessage());
		}
		return null;
	}

	public String addSalesCommission() {
		try {
			SalesCommissionService salesCommissionService = (SalesCommissionService) SpringBeanUtil
					.lookup(SalesCommissionService.class.getName());
			commission.setProject(project);
			commission.setCreatedOn(new Date());
			salesCommissionService.insert(commission);
			commissions = salesCommissionService.findByProjectId(projectId);
			commission = new SalesCommission();
			refreshCommissionDiscount();
			FacesUtil.addInfoMessage("Sales Commission", "Sales Commission Added");
		} catch (Throwable t) {
			FacesUtil.addErrorMessage(t.getClass().getName(), t.getMessage());
		}
		return "newProject";
	}

	public String deleteDiscount() {
		if (discount != null && discount.getDiscountId() != null) {
			DiscountService discountService = (DiscountService) SpringBeanUtil
					.lookup(DiscountService.class.getName());
			discountService.delete(discount.getDiscountId());
			discounts = discountService.findByProjectId(projectId);
			discount = new Discount();
			refreshCommissionDiscount();
		}
		return null;
	}

	public String deleteSalesCommission() {
		if (commission != null && commission.getCommissionId() != null) {
			SalesCommissionService salesCommissionService = (SalesCommissionService) SpringBeanUtil
					.lookup(SalesCommissionService.class.getName());
			salesCommissionService.delete(commission.getCommissionId());
			commissions = salesCommissionService.findByProjectId(projectId);
			commission = new SalesCommission();
			refreshCommissionDiscount();
		}
		return null;
	}

	public String toInventoryList() {
		if (project!=null) {
			projectId = project.getProjectId();
		}

		ProjectInventoryService inventoryService = (ProjectInventoryService) SpringBeanUtil
				.lookup(ProjectInventoryService.class.getName());
		inventories = inventoryService.getInventories(projectId);

		return "inventoryList";
	}
	
	public String addInventory() {
		
		inventory = new ProjectInventory();
		
		return "editInventory";
	}

	
	public String editInventory() {
		
		return "editInventory";
	}
	
	public String saveInventory() {
		try {
			ProjectInventoryService inventoryService = (ProjectInventoryService) SpringBeanUtil
					.lookup(ProjectInventoryService.class.getName());
			inventory.setProject(project);
			inventoryService.update(inventory);
			FacesUtil.addInfoMessage("Property Unit", "Property Unit Saved");
		} catch (Throwable t) {
			FacesUtil.addErrorMessage(t.getClass().getName(), t.getMessage());
		}
		return toInventoryList();
	}
	
	public String saveInventoryAsNew() {
		try {
			ProjectInventoryService inventoryService = (ProjectInventoryService) SpringBeanUtil
					.lookup(ProjectInventoryService.class.getName());
			inventory.setProject(project);
			inventory.setInventoryId(null);
			inventoryService.insert(inventory);
			FacesUtil.addInfoMessage("Property Unit", "Property Unit Added");
		} catch (Throwable t) {
			FacesUtil.addErrorMessage(t.getClass().getName(), t.getMessage());
		}
		return editInventory();
	}
}
