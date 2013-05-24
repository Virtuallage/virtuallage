package com.vipro.jsf.bean.sales;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;

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

@ManagedBean(name = "projectSetup")
@SessionScoped
public class ProjectSetup extends CommonBean implements Serializable {
	/**
	 * project related properties
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
	private List<SelectItem> reportGroups;
	private List<SelectItem> statusList;
	private String locationSearch;
	private int totalUnits;
	private double priceRangeFrom;
	private double priceRangeTo;
	private double currentDiscount;
	private Date discountExpiry;
	private double salesCommission;
	private String commisionType;
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
	private List<SelectItem> orientationList;

	public ProjectSetup() {

	}

	@PostConstruct
	public void init() {
		countries = CodeUtil.getCodes("COUNTRY");
		cities = CodeUtil.getCodes("CITY");
		states = CodeUtil.getCodes("STATE");
		propertyTypes = CodeUtil.getCodes("PROP_TYPE");
		setReportGroups(CodeUtil.getCodes("REPORT_GROUP"));
		propertyStatusList = CodeUtil.getPropertyStatusAsItems();
		titleTypeList = CodeUtil.getCodes("TITLE_TYPE");
		orientationList = CodeUtil.getCodes("ORIENTATION");
		statusList = CodeUtil.getCodes("STATUS");
		institutions = CodeUtil.getInstitutionAsItems();
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
		return "project";
	}

	public String addNewProject() {
		project = new Project();
		return "newProject";
	}

	public String editProject() {
		try {
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
			addErrorMessage(t.getClass().getName(), t.getMessage());
		}

		return "newProject";
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

			discount = new Discount();
			commission = new SalesCommission();

			refreshCommissionDiscount();
			addInfoMessage("Project", "Project Saved");
		} catch (Throwable t) {
			addErrorMessage(t.getClass().getName(), t.getMessage());
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
		} else {
			this.currentDiscount = 0;
			this.discountExpiry = null;
		}

		if (s != null) {
			this.commisionEffective = s.getEffectiveDate();
			this.salesCommission = s.getAmountOrRate().doubleValue();
			this.commisionType = s.getType();
		} else {
			this.commisionEffective = null;
			this.salesCommission = 0;
			this.commisionType = null;
		}
	}

	public String addDiscount() {
		try {
			validateDiscount();
			DiscountService discountService = (DiscountService) SpringBeanUtil
					.lookup(DiscountService.class.getName());
			discount.setProject(project);
			discount.setCreatedOn(new Date());
			discountService.insert(discount);
			discounts = discountService.findByProjectId(projectId);
			discount = new Discount();
			refreshCommissionDiscount();
			addInfoMessage("Discount", "Discount Added");
		} catch (Throwable t) {
			addErrorMessage(t.getClass().getName(), t.getMessage());
		}
		return null;
	}

	public void validateDiscount() throws Throwable {
		Date effDate = discount.getEffectiveDate();
		Date expDate = discount.getExpiryDate();

		if (effDate.after(expDate)) {
			throw new Throwable("Invalid Date Range selected");
		}

		for (Discount iter : discounts) {
			if (effDate != null) {
				if (effDate.after(iter.getEffectiveDate())
						&& effDate.before(iter.getExpiryDate())) {
					throw new Throwable(
							"Effective Date overlap with existing Discounts");
				}
			}

			if (expDate != null) {
				if (expDate.after(iter.getEffectiveDate())
						&& expDate.before(iter.getExpiryDate())) {
					throw new Throwable(
							"Expiry Date overlap with existing Discounts");
				}
			}
		}
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
			addInfoMessage("Sales Commission", "Sales Commission Added");
		} catch (Throwable t) {
			addErrorMessage(t.getClass().getName(), t.getMessage());
		}
		return "newProject";
	}

	public String deleteDiscount() {
		try {
			if (discount != null && discount.getDiscountId() != null) {
				DiscountService discountService = (DiscountService) SpringBeanUtil
						.lookup(DiscountService.class.getName());
				discountService.delete(discount.getDiscountId());
				discounts = discountService.findByProjectId(projectId);
				discount = new Discount();
				refreshCommissionDiscount();
				addInfoMessage("Discount", "Discount Deleted");
			}
		} catch (Throwable t) {
			addErrorMessage(t.getClass().getName(), t.getMessage());
		}
		return null;
	}

	public String deleteSalesCommission() {
		try {
			if (commission != null && commission.getCommissionId() != null) {
				SalesCommissionService salesCommissionService = (SalesCommissionService) SpringBeanUtil
						.lookup(SalesCommissionService.class.getName());
				salesCommissionService.delete(commission.getCommissionId());
				commissions = salesCommissionService.findByProjectId(projectId);
				commission = new SalesCommission();
				refreshCommissionDiscount();
			}
		} catch (Throwable t) {
			addErrorMessage(t.getClass().getName(), t.getMessage());
		}
		return null;
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
		return "inventoryList";
	}

	public String addInventory() {
		inventory = new ProjectInventory();
		inventory.setDiscountRate(project.getDiscountRate());
		return "editInventory";
	}

	public String editInventory() {
		inventory.setDiscountRate(project.getDiscountRate());
		return "editInventory";
	}

	public String deleteInventory() {
		try {
			ProjectInventoryService inventoryService = (ProjectInventoryService) SpringBeanUtil
					.lookup(ProjectInventoryService.class.getName());

			if (inventory != null) {
				inventoryService.delete(inventory.getInventoryId());
				addInfoMessage("Property Unit", "Property Unit Deleted");
			}
		} catch (Throwable t) {
			if (t instanceof DataIntegrityViolationException) {
				addErrorMessage("Property Unit",
						"This property is currently purchased. Deletion not allowed.");
			} else {
				addErrorMessage("Property Unit", t.getMessage());
			}
		}
		return toInventoryList();
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

	public String saveInventoryAsNew() {
		Long inventoryId = inventory.getInventoryId();
		try {
			ProjectInventoryService inventoryService = (ProjectInventoryService) SpringBeanUtil
					.lookup(ProjectInventoryService.class.getName());
			inventory.setInventoryId(null);
			inventory.setProject(project);
			validateInventoryKey(inventoryService);
			inventoryService.insert(inventory);
			addInfoMessage("Property Unit", "Property Unit Added");
		} catch (Throwable t) {
			addErrorMessage(t.getClass().getName(), t.getMessage());
			inventory.setInventoryId(inventoryId);
			return null;
		}
		return editInventory();
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

}
