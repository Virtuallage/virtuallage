package com.vipro.jsf.bean.sales;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.vipro.constant.ProjectStatusConst;
import com.vipro.data.Discount;
import com.vipro.data.Project;
import com.vipro.data.SalesCommission;
import com.vipro.service.DiscountService;
import com.vipro.service.ProjectService;
import com.vipro.service.SalesCommissionService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.FacesUtil;
import com.vipro.utils.spring.SpringBeanUtil;

@ManagedBean(name = "projectSetup")
@SessionScoped
public class ProjectSetup implements Serializable {
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
	private Date commisionExpiry;

	public ProjectSetup() {

	}

	@PostConstruct
	public void init() {
		countries = CodeUtil.getCodes("COUNTRY");
		cities = CodeUtil.getCodes("CITY");
		states = CodeUtil.getCodes("STATE");
		propertyTypes = CodeUtil.getCodes("PROP_TYPE");
		institutions = CodeUtil.getInstitutionAsItems();
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

	public Date getCommisionExpiry() {
		return commisionExpiry;
	}

	public void setCommisionExpiry(Date commisionExpiry) {
		this.commisionExpiry = commisionExpiry;
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
		ProjectService projectService = (ProjectService) SpringBeanUtil
				.lookup(ProjectService.class.getName());
		projectId = project.getProjectId();
		
		DiscountService discountService = (DiscountService) SpringBeanUtil
				.lookup(DiscountService.class.getName());
		discounts = discountService.findByProjectId(projectId);
		
		SalesCommissionService salesCommissionService = (SalesCommissionService) SpringBeanUtil
				.lookup(SalesCommissionService.class.getName());
		
		commissions = salesCommissionService.findByProjectId(projectId);

		return "newProject";
	}

	public String saveProject() {
		ProjectService projectService = (ProjectService) SpringBeanUtil
				.lookup(ProjectService.class.getName());
		project.setStatus(ProjectStatusConst.STATUS_ACTIVE);
		projectService.insert(project);

		listProject();
		return "project";
	}

}
