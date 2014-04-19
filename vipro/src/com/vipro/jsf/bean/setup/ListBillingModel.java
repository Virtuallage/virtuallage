package com.vipro.jsf.bean.setup;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.event.RowEditEvent;

import com.vipro.auth.AuthUser;
import com.vipro.data.BillingModel;
import com.vipro.data.BillingModelHeader;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.service.BillingModelHeaderService;
import com.vipro.service.BillingModelService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.SpringBeanUtil;

@ManagedBean(name = "listBillingModel")
@SessionScoped
public class ListBillingModel extends CommonBean implements Serializable {

	private static final Object arg0 = null;

	private List<SelectItem> listBillingHeader = null;
	private List<SelectItem> listStatus = null;

	private List<BillingModelHeader> modelsHeader;
	private List<BillingModelHeader> modelsHeaderList;
	private BillingModelHeader modelHeader;
	private List<BillingModel> models;
	private BillingModel model;
	
	private Long headerId = (long) 0;
	private String billingModelCode;
	private String description;
	private String status;
	private String header;
	
	private String currentModel;
	private BigDecimal sum;
	private String color;
	private String msg;
	
	private Long modelId;
	private BigDecimal billingPercentage;

	@PostConstruct
	public void init() {
		listBillingHeader = getBillingModelAsItems();
		listStatus = CodeUtil.getCodes("SS");
	}

	public List<SelectItem> getBillingModelAsItems() {
		BillingModelHeaderService billingHeaderService = (BillingModelHeaderService) SpringBeanUtil.lookup(BillingModelHeaderService.class.getName());
		modelsHeaderList = billingHeaderService.findAllModel();
		List<SelectItem> modelItems = new ArrayList<SelectItem>();
		modelItems.add( new SelectItem(0, "Select All"));
		for (BillingModelHeader p : modelsHeaderList) {
			modelItems.add( new SelectItem(p.getHeaderId(), p.getDescription()));
		}

		return modelItems;
	}

	public String searchModel(){
		BillingModelHeaderService billingHeaderService = (BillingModelHeaderService) SpringBeanUtil.lookup(BillingModelHeaderService.class.getName());
		
		if(headerId == null || headerId == 0)
			modelsHeader = billingHeaderService.findAllModel();
		else
			modelsHeader = billingHeaderService.findById(headerId);

		return "listBillingModel";
	}

	public String editBillingModel(String modelCode, String modelDesc){
		header = "Progressive Billing Model: " + modelCode + " - " + modelDesc;
		
		sum = BigDecimal.ZERO;
		BillingModelService billingModelService = (BillingModelService) SpringBeanUtil.lookup(BillingModelService.class.getName());
		models = billingModelService.findByBillingModelCode(modelCode);

		for (BillingModel p : models) {
			sum = sum.add(p.getBillingPercentage());
		}

		setColor();

		currentModel = modelCode;

		return "/secured/setup/billingModel/editProgressiveBillingModel.xhtml";
	}
	
	public void setColor(){
		if(sum.compareTo(new BigDecimal("100")) == 0 ){ 
			color = "black";
			msg = "";
		}else{
			color = "red";
			msg = "Total percentage must equal to 100%";
		}
	}

	public String newBillingModelHeader(){
		AuthUser user = getCurrentUser();
		setModelHeader(new BillingModelHeader());
		getModelHeader().setDateChanged(new Date());
		getModelHeader().setChangedBy(user.getUserProfile().getUserId());
		getModelHeader().setStatus("SSACT");
		return "/secured/setup/billingModel/addNewModelHeader.xhtml";
	}
	
	public String newBillingModel(){
		AuthUser user = getCurrentUser();
		setModel(new BillingModel());
		getModel().setDateChanged(new Date());
		getModel().setChangedBy(user.getUserProfile().getUserId());
		getModel().setStatus("SSACT");
		getModel().setBillingModelCode(currentModel);
		return "/secured/setup/billingModel/addNewModel.xhtml";
	}

	public String backToListing(){
		return "/secured/setup/billingModel/listProgressiveBillingModel.xhtml";
	}
	
	public String backToEdit(){
		return "/secured/setup/billingModel/editProgressiveBillingModel.xhtml";
	}

	public String insertNewModelHeader(){
		BillingModelHeaderService billingHeaderService = (BillingModelHeaderService) SpringBeanUtil.lookup(BillingModelHeaderService.class.getName());
		List<BillingModelHeader> bmh = billingHeaderService.findByModel(modelHeader.getBillingModelCode());
		if(bmh.isEmpty())
			billingHeaderService.insert(modelHeader);
		else{
			addErrorMessage("Add New Billing Model Header",
					"Billing Model Code : " + modelHeader.getBillingModelCode() + " already existed." );
			return null;
		}
		return "/secured/setup/billingModel/listProgressiveBillingModel.xhtml";
	}
	
	public String insertNewModel(){
		sum = BigDecimal.ZERO;
		BillingModelService billingService = (BillingModelService) SpringBeanUtil.lookup(BillingModelService.class.getName());
		billingService.insert(model);
		models = billingService.findByBillingModelCode(model.getBillingModelCode());
		
		for (BillingModel p : models) {
			sum = sum.add(p.getBillingPercentage());
		}
		setColor();
		
		return "/secured/setup/billingModel/editProgressiveBillingModel.xhtml";
	}

	public void onEdit(RowEditEvent event) {
		model = (BillingModel) event.getObject();
		update();
	}  
	
	public void update(){
		sum = BigDecimal.ZERO;
		AuthUser user = getCurrentUser();
		model.setDateChanged(new Date());
		model.setChangedBy(user.getUserProfile().getUserId());
		BillingModelService billingModelService = (BillingModelService) SpringBeanUtil.lookup(BillingModelService.class.getName());
		billingModelService.update(model);
		models = billingModelService.findByBillingModelCode(model.getBillingModelCode());
		
		for (BillingModel p : models) {
			sum = sum.add(p.getBillingPercentage());
		}
		setColor();
	}

	public void onEditH(RowEditEvent event) {
		modelHeader = (BillingModelHeader) event.getObject();

		AuthUser user = getCurrentUser();
		modelHeader.setDateChanged(new Date());
		modelHeader.setChangedBy(user.getUserProfile().getUserId());
		
		BillingModelHeaderService billingHeaderService = (BillingModelHeaderService) SpringBeanUtil.lookup(BillingModelHeaderService.class.getName());
		billingHeaderService.update(modelHeader);
		
	}
	
	public void onCancel(RowEditEvent event) {
		BillingModelService billingModelService = (BillingModelService) SpringBeanUtil.lookup(BillingModelService.class.getName());
		models = billingModelService.findByBillingModelCode(((BillingModel) event.getObject()).getBillingModelCode());
	}  
	
	public void onCancelH(RowEditEvent event) {

	}  
	
	public void onDelete(Long modelId){
		setModelId(modelId);
	}

	public void delete(String billingModelCode){
		sum = BigDecimal.ZERO;
		BillingModelService billingModelService = (BillingModelService) SpringBeanUtil.lookup(BillingModelService.class.getName());
		billingModelService.delete(getModelId());
		models = billingModelService.findByBillingModelCode(billingModelCode);
		for (BillingModel p : models) {
			sum = sum.add(p.getBillingPercentage());
		}
		setColor();
	}

	public List<SelectItem> getListBillingHeader() {
		listBillingHeader = getBillingModelAsItems();
		return listBillingHeader;
	}

	public void setListBillingHeader(List<SelectItem> listBillingHeader) {
		this.listBillingHeader = listBillingHeader;
	}

	public List<BillingModelHeader> getModelsHeader() {
		return modelsHeader;
	}

	public void setModelsHeader(List<BillingModelHeader> modelsHeader) {
		this.modelsHeader = modelsHeader;
	}

	public Long getHeaderId() {
		return headerId;
	}

	public void setHeaderId(Long headerId) {
		this.headerId = headerId;
	}

	public String getBillingModelCode() {
		return billingModelCode;
	}

	public void setBillingModelCode(String billingModelCode) {
		this.billingModelCode = billingModelCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BillingModelHeader getModelHeader() {
		return modelHeader;
	}

	public void setModelHeader(BillingModelHeader modelHeader) {
		this.modelHeader = modelHeader;
	}

	public List<SelectItem> getListStatus() {
		return listStatus;
	}

	public void setListStatus(List<SelectItem> listStatus) {
		this.listStatus = listStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<BillingModel> getModels() {
		return models;
	}

	public void setModels(List<BillingModel> models) {
		this.models = models;
	}

	public BillingModel getModel() {
		return model;
	}

	public void setModel(BillingModel model) {
		this.model = model;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public BigDecimal getSum() {
		return sum;
	}

	public void setSum(BigDecimal sum) {
		this.sum = sum;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Long getModelId() {
		return modelId;
	}

	public void setModelId(Long modelId) {
		this.modelId = modelId;
	}

	public BigDecimal getBillingPercentage() {
		return billingPercentage;
	}

	public void setBillingPercentage(BigDecimal billingPercentage) {
		this.billingPercentage = billingPercentage;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
