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

import com.vipro.auth.AuthUser;
import com.vipro.constant.BusinessPartnerTypeConst;
import com.vipro.constant.ProjectStatusConst;
import com.vipro.constant.PropertyUnitStatusConst;
import com.vipro.constant.CommonConst;
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
	private List<SelectItem> developers;
	private List<SelectItem> landProprietors;
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
	private List<SelectItem> layoutTypeList;
	private List<SelectItem> facingList;

	public ProjectSetup() {

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
		layoutTypeList = CodeUtil.getCodes("LT");
		facingList = CodeUtil.getCodes("FC");
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
			String pname= project.getProjectName();
			project.setProjectName(pname.toUpperCase());
			String addr1= project.getAddress1();
			project.setAddress1(addr1.toUpperCase());
			String addr2= project.getAddress2();
			project.setAddress2(addr2.toUpperCase());
			String addr3= project.getAddress3();
			project.setAddress3(addr3.toUpperCase());
			String addr4= project.getAddress4();
			project.setAddress4(addr4.toUpperCase());
			String pcity= project.getCity();
			project.setCity(pcity.toUpperCase());
			
			ProjectService projectService = (ProjectService) SpringBeanUtil
					.lookup(ProjectService.class.getName());
			if(project.getStatus() == null) {
				project.setStatus(ProjectStatusConst.STATUS_ACTIVE);
			}

			project.setDateChanged(new Date());
			AuthUser user = getCurrentUser();
			project.setChangedBy(user.getUserProfile().getUserId());
			
			projectService.insert(project);

			listProject();

			discount = new Discount();
			commission = new SalesCommission();

			refreshCommissionDiscount();
			addInfoMessage("Saved", "Project Record Saved Successfully.");
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
		if (inventory.getDiscountRate() == null) {
			inventory.setDiscountRate(project.getDiscountRate());
		}
		return "editInventory";
	}

	public String deleteInventory() {
		try {
			ProjectInventoryService inventoryService = (ProjectInventoryService) SpringBeanUtil
					.lookup(ProjectInventoryService.class.getName());

			if (inventory != null) {
				inventoryService.delete(inventory.getInventoryId());
				addInfoMessage("Deleted", "Property Unit Deleted Successfully.");
			}
		} catch (Throwable t) {
			if (t instanceof DataIntegrityViolationException) {
				addErrorMessage("Warning",
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
			
			inventory.setStatusChangeDate(new Date());
			AuthUser user = getCurrentUser();
			inventory.setChangeUserId(user.getUserProfile().getUserId());
			
			inventoryService.update(inventory);
			addInfoMessage("Saved", "Property Unit Saved Successfully.");
		} catch (Throwable t) {
			addErrorMessage(t.getClass().getName(), t.getMessage());
			return null;
		}
		return toInventoryList();
	}

	public String saveInventoryAsNew() {
		Long inventoryId = inventory.getInventoryId();
		try {
			String fblock = inventory.getBlockNo();
			inventory.setBlockNo(fblock.toUpperCase());
			String funitno = inventory.getUnitNo();
			inventory.setUnitNo(funitno.toUpperCase());
			String flayout = inventory.getLayoutType();
			inventory.setLayoutType(flayout.toUpperCase());
			
			ProjectInventoryService inventoryService = (ProjectInventoryService) SpringBeanUtil
					.lookup(ProjectInventoryService.class.getName());
			inventory.setInventoryId(null);
			inventory.setProject(project);
			validateInventoryKey(inventoryService);
			
			inventory.setPropertyStatus(PropertyUnitStatusConst.STATUS_AVAILABLE);
			inventory.setStatusChangeDate(new Date());
			AuthUser user = getCurrentUser();
			inventory.setChangeUserId(user.getUserProfile().getUserId());
			
			inventoryService.insert(inventory);
			addInfoMessage("Added", "Property Unit Added Successfully.");
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

	public List<SelectItem> getLayoutTypeList() {
		return layoutTypeList;
	}

	public void setLayoutTypeList(List<SelectItem> layoutTypeList) {
		this.layoutTypeList = layoutTypeList;
	}

	public List<SelectItem> getFacingList() {
		return facingList;
	}

	public void setFacingList(List<SelectItem> facingList) {
		this.facingList = facingList;
	}

}
