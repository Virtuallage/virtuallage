package com.vipro.jsf.bean.mis;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.vipro.constant.CommonConst;
import com.vipro.data.Project;
import com.vipro.dto.ProjectRevenueItemDTO;
import com.vipro.dto.ReportDTO;
import com.vipro.dto.SalesByAgentItemDTO;
import com.vipro.dto.TotalLoanOfferedItemDTO;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.service.ProjectService;
import com.vipro.service.ReportService;
import com.vipro.utils.spring.SpringBeanUtil;


@ManagedBean(name = "salesSummaryBean")
@RequestScoped
public class SalesSummaryBean extends CommonBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3935359725818731090L;

	private ProjectService projectService;
	private ReportService reportService;
	private Long selectedProjectId;
	private List<SelectItem> projects;
	private List<String> columns = new ArrayList<String>();
	private String blocksTitle = "";
	private List<String> blockCodeList = null;
	private List<ProjectRevenueItemDTO> projRevSummaryRows = new ArrayList<ProjectRevenueItemDTO>();
	private List<TotalLoanOfferedItemDTO> totalLoanOfferedRows = new ArrayList<TotalLoanOfferedItemDTO>();
	private List<SalesByAgentItemDTO> salesByAgentRows = new ArrayList<SalesByAgentItemDTO>();
	private ReportDTO reportDTO = new ReportDTO();
	private Project project = null;
	
	
	public SalesSummaryBean() {
		
		this.projectService = (ProjectService)SpringBeanUtil.lookup(ProjectService.class.getName());
		this.reportService = (ReportService)SpringBeanUtil.lookup(ReportService.class.getName());
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
			String selectedProjectIdStr = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("salesSummaryForm:projectList_input");
			if(selectedProjectIdStr != null){
				selectedProjectId = Long.parseLong(selectedProjectIdStr);
				project = this.projectService.findById(selectedProjectId);
				columns = getTotalBlocks();
				projRevSummaryRows.clear();
				totalLoanOfferedRows.clear();
				salesByAgentRows.clear();
				populateSalesSummaryItemDTO();
				setTotalLoanOfferedRows(this.projectService.getTotalLoanOfferedByProjectId(selectedProjectId));
				setSalesByAgentRows(this.projectService.getSalesByAgentByProjectId(selectedProjectId));				
			}else{
				
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	private List<String> getTotalBlocks(){
		List<String> result = null;
		try{
			result = projectService.getTotalInventoryBlocks();
			if(result != null && result.size() > 0){
				blockCodeList = new ArrayList<String>();
				for(int index = 0; index < result.size(); index++){
					String col = result.get(index);
					String[] blockNoArr = col.split(" ");
					blockCodeList.add(blockNoArr[1]);
					
					blocksTitle += col+" & ";					
				}
				blocksTitle = blocksTitle.substring(0,blocksTitle.length()-2);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
	}
	
	
	
	private void populateSalesSummaryItemDTO(){
		projRevSummaryRows.add(addTotalProjRev());
		projRevSummaryRows.add(addDescriptionOnlyRow("AP Validity Period"));
		projRevSummaryRows.add(getValidityPeriodSum("Gross"));
		projRevSummaryRows.add(getValidityPeriodSum("Net"));
		projRevSummaryRows.add(getValidityPeriodSum("Secured"));
		projRevSummaryRows.add(addEmptyRow());
		
		if(project != null && project.getLandProprietorId() != null && project.getLandProprietorId() != 0L){
			String a5Name = project.getLandProprietorName();
			projRevSummaryRows.add(addA5NameMainRow(a5Name));
			projRevSummaryRows.add(addA5NameSum("Gross"));
			projRevSummaryRows.add(addA5NameSum("Net"));
			projRevSummaryRows.add(addEmptyRow());
		}
		
		projRevSummaryRows.add(addBookingMainRow());
		projRevSummaryRows.add(addBookingSum("Gross"));
		projRevSummaryRows.add(addBookingSum("Net"));
		projRevSummaryRows.add(addBookingSum("Bumi"));
		projRevSummaryRows.add(addBookingSum("NonBumi"));
		projRevSummaryRows.add(addBookingBalanceUnsoldRow());
		projRevSummaryRows.add(addEmptyRow());
		projRevSummaryRows.add(addSPAMainRow());
		projRevSummaryRows.add(addSPASum("Gross"));
		projRevSummaryRows.add(addSPASum("Net"));
		projRevSummaryRows.add(addSPAPendingSigningRow());
		projRevSummaryRows.add(addEmptyRow());
		projRevSummaryRows.add(addCashMainRow());
		projRevSummaryRows.add(addCashSum("Gross"));
		projRevSummaryRows.add(addCashSum("Net"));
		projRevSummaryRows.add(addEmptyRow());
		projRevSummaryRows.add(addLOMainRow());
		projRevSummaryRows.add(addLOSum("Gross"));
		projRevSummaryRows.add(addLOSum("Net"));
		projRevSummaryRows.add(addLOPendingSigningRow());
		projRevSummaryRows.add(addEmptyRow());
		projRevSummaryRows.add(addLAMainRow());
		projRevSummaryRows.add(addLASum("Gross"));
		projRevSummaryRows.add(addLASum("Net"));
		projRevSummaryRows.add(addLAPendingSigningRow());
		projRevSummaryRows.add(addEmptyRow());
		projRevSummaryRows.add(addAdviseMainRow());
		projRevSummaryRows.add(addAdviseSum("Gross"));
		projRevSummaryRows.add(addAdviseSum("Net"));
		projRevSummaryRows.add(addAdvisePendingRow());

	}
	
	private ProjectRevenueItemDTO addEmptyRow(){
		ProjectRevenueItemDTO itemDTO = new ProjectRevenueItemDTO();
		itemDTO.setDescription("");
		itemDTO.setEmptyRow(true);
		if(columns.size() -1 >0 ){
			List<BigDecimal> blocksList = new ArrayList<BigDecimal>();
			BigDecimal totalValue = null;
			for(int i = 0; i< blockCodeList.size(); i++){
				blocksList.add(null);
			}
			itemDTO.setBlocks(blocksList);
			itemDTO.setTotal(totalValue);
		}
		return itemDTO;
	}
	
	private ProjectRevenueItemDTO addTotalProjRev(){
		ProjectRevenueItemDTO itemDTO = new ProjectRevenueItemDTO();
		itemDTO.setCurrency(false);
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MMM yyyy");
		itemDTO.setDescription("Total Proj Rev. "+"("+"Updated as at "+dateTimeFormat.format(new Date())+")");
		if(columns.size() -1 >0 ){
			List<BigDecimal> blocksList = new ArrayList<BigDecimal>();
			BigDecimal totalValue = new BigDecimal(0);
			for(String blockNo:blockCodeList){
				BigDecimal result = new BigDecimal(this.projectService.getBlockCountByNo(blockNo, selectedProjectId));
				blocksList.add(result);
				totalValue = totalValue.add(result);
			}
			itemDTO.setBlocks(blocksList);
			itemDTO.setTotal(totalValue);
		}
		return itemDTO;
	}	
	private ProjectRevenueItemDTO getValidityPeriodSum(String type){
		ProjectRevenueItemDTO itemDTO = new ProjectRevenueItemDTO();
		if(type != null && !type.isEmpty()){
			if(type.equals("Gross")){
				itemDTO.setDescription("a) Gross Sales	 ");
			}else if(type.equals("Net") ){
				itemDTO.setDescription("b) Net Sales	 ");
			}else if(type.equals("Secured")){
				itemDTO.setDescription("c) Secured Sales	 ");
			} 
		}
		if(columns.size() -1 > 0){
			List<BigDecimal> blocksList = new ArrayList<BigDecimal>();
			for(String blockNo:blockCodeList){
				BigDecimal result = this.projectService.getValidityPeriodSum(blockNo, selectedProjectId,type);
				blocksList.add(result);
				itemDTO.setTotal(itemDTO.getTotal().add(result));
			}
			
			itemDTO.setBlocks(blocksList);
		}
		return itemDTO;
	}
	
	private ProjectRevenueItemDTO addA5NameMainRow(String a5Name){
		ProjectRevenueItemDTO itemDTO = new ProjectRevenueItemDTO();
		itemDTO.setCurrency(false);
		itemDTO.setDescription(a5Name);
		itemDTO.setHeading(true);
		if(columns.size() -1 >0 ){
			List<BigDecimal> blocksList = new ArrayList<BigDecimal>();
			for(String blockNo:blockCodeList){
				BigDecimal result = new BigDecimal(this.projectService.getA5NameBlockCountByNo(blockNo, selectedProjectId,project.getBussinessPartnerId()));
				blocksList.add(result);
				itemDTO.setTotal(itemDTO.getTotal().add(result));
			}
			itemDTO.setBlocks(blocksList);
			
		}
		return itemDTO;
	}
	private ProjectRevenueItemDTO addA5NameSum(String type){
		ProjectRevenueItemDTO itemDTO = new ProjectRevenueItemDTO();
		if(type.equals("Gross")){
			itemDTO.setDescription("a) Gross Sales	 ");
		}else if(type.equals("Net") ){
			itemDTO.setDescription("b) Net Sales	 ");
		}
		if(columns.size()-1 >0 ){
			List<BigDecimal> blocksList = new ArrayList<BigDecimal>();
			for(String blockNo:blockCodeList){
				BigDecimal result = this.projectService.addA5NameSum(blockNo, selectedProjectId,type,project.getBussinessPartnerId());
				blocksList.add(result);
				itemDTO.setTotal(itemDTO.getTotal().add(result));
			}
			itemDTO.setBlocks(blocksList);
			
		}
		return itemDTO;
	}
	private ProjectRevenueItemDTO addBookingMainRow(){
		ProjectRevenueItemDTO itemDTO = new ProjectRevenueItemDTO();
		itemDTO.setCurrency(false);
		itemDTO.setDescription("Booking");
		itemDTO.setHeading(true);
		if(columns.size() -1 >0 ){
			List<BigDecimal> blocksList = new ArrayList<BigDecimal>();
			for(String blockNo:blockCodeList){
				BigDecimal result = new BigDecimal(this.projectService.getBookingCountByNo(blockNo, selectedProjectId));
				blocksList.add(result);
				if(result != null){
					itemDTO.setTotal(itemDTO.getTotal().add(result));
				}
			}
			itemDTO.setBlocks(blocksList);
			
		}
		return itemDTO;
	}
	private ProjectRevenueItemDTO addBookingSum(String type){
		ProjectRevenueItemDTO itemDTO = new ProjectRevenueItemDTO();
		if(type.equals("Gross")){
			itemDTO.setDescription("a) Gross Sales");
		}else if(type.equals("Net") ){
			itemDTO.setDescription("b) Net Sales");
		}else if(type.equals("Bumi") ){
			itemDTO.setCurrency(false);
			itemDTO.setDescription("c) Bumi");
		}else if(type.equals("NonBumi") ){
			itemDTO.setCurrency(false);
			itemDTO.setDescription("d) Non Bumi ");
		}
		if(columns.size() -1 >0 ){
			List<BigDecimal> blocksList = new ArrayList<BigDecimal>();
			for(String blockNo:blockCodeList){
				BigDecimal result = this.projectService.addBookingSum(blockNo, selectedProjectId,type);
				blocksList.add(result);
				if(result != null){
					itemDTO.setTotal(itemDTO.getTotal().add(result));
				}
			}
			itemDTO.setBlocks(blocksList);
			
		}
		return itemDTO;
	}
	
	private ProjectRevenueItemDTO addBookingBalanceUnsoldRow(){
		ProjectRevenueItemDTO itemDTO = new ProjectRevenueItemDTO();
		itemDTO.setDescription("Balance Unsold");
		itemDTO.setCurrency(false);
		//itemDTO.setHeading(true);
		
		ProjectRevenueItemDTO projRevDTO = projRevSummaryRows.get(0);
		ProjectRevenueItemDTO a5NameDTO = new ProjectRevenueItemDTO();
		int bookingDTOIndex = 6;
		if(project.getLandProprietorId() != null){
				a5NameDTO = projRevSummaryRows.get(6);
				bookingDTOIndex = bookingDTOIndex+4;
		}
		ProjectRevenueItemDTO bookingDTO = projRevSummaryRows.get(bookingDTOIndex);
		
		
		if(projRevDTO.getBlocks() != null && projRevDTO.getBlocks().size() >0){
			List<BigDecimal> blocks = new ArrayList<BigDecimal>();
			for(int index = 0; index < projRevDTO.getBlocks().size(); index++){
				
				BigDecimal a5NameVal = new BigDecimal(0l);
				if( a5NameDTO.getBlocks() != null &&  !a5NameDTO.getBlocks().isEmpty()){
					 a5NameVal = a5NameDTO.getBlocks().get(index);
				}
				blocks.add(projRevDTO.getBlocks().get(index).subtract(a5NameVal).subtract(bookingDTO.getBlocks().get(index)));
				itemDTO.setTotal(itemDTO.getTotal().add(blocks.get(index)));
			}
			itemDTO.setBlocks(blocks);
		}
		
		return itemDTO;
	}
	
	private ProjectRevenueItemDTO addSPAMainRow(){
		ProjectRevenueItemDTO itemDTO = new ProjectRevenueItemDTO();
		itemDTO.setDescription("SPA ");
		itemDTO.setHeading(true);
		itemDTO.setCurrency(false);
		if(columns.size() -1 >0 ){
			List<BigDecimal> blocksList = new ArrayList<BigDecimal>();
			for(String blockNo:blockCodeList){
				BigDecimal result = new BigDecimal(this.projectService.getSPACountByNo(blockNo, selectedProjectId));
				blocksList.add(result);
				if(result != null){
					itemDTO.setTotal(itemDTO.getTotal().add(result));
				}
			}
			itemDTO.setBlocks(blocksList);
			
		}
		return itemDTO;
	}
	private ProjectRevenueItemDTO addSPASum(String type){
		ProjectRevenueItemDTO itemDTO = new ProjectRevenueItemDTO();
		if(type.equals("Gross")){
			itemDTO.setDescription("a) Gross Sales");
		}else if(type.equals("Net") ){
			itemDTO.setDescription("b) Net Sales");
		}
		if(columns.size() -1 >0 ){
			List<BigDecimal> blocksList = new ArrayList<BigDecimal>();
			for(String blockNo:blockCodeList){
				BigDecimal result = this.projectService.addSPASum(blockNo, selectedProjectId,type);
				blocksList.add(result);
				if(result != null){
					itemDTO.setTotal(itemDTO.getTotal().add(result));
				}
			}
			itemDTO.setBlocks(blocksList);
			
		}
		return itemDTO;
	}
	
	private ProjectRevenueItemDTO addSPAPendingSigningRow(){
		ProjectRevenueItemDTO itemDTO = new ProjectRevenueItemDTO();
		itemDTO.setDescription("Pending SPA Signing");
		itemDTO.setCurrency(false);
		int bookingDTOIndex = 10;
		int spaDTOIndex = 17;
		if(project.getLandProprietorId() == null || project.getLandProprietorId() == 0L){
			bookingDTOIndex = bookingDTOIndex-4;
			spaDTOIndex = spaDTOIndex-4;
		}
		ProjectRevenueItemDTO bookingDTO = projRevSummaryRows.get(bookingDTOIndex);
		ProjectRevenueItemDTO spaDTO = projRevSummaryRows.get(spaDTOIndex);
		
		if(bookingDTO.getBlocks() != null && bookingDTO.getBlocks().size() >0){
			List<BigDecimal> blocks = new ArrayList<BigDecimal>();
			for(int index = 0; index < bookingDTO.getBlocks().size(); index++){
				blocks.add(bookingDTO.getBlocks().get(index).subtract(spaDTO.getBlocks().get(index)));
				itemDTO.setTotal(itemDTO.getTotal().add(blocks.get(index)));
			}
			itemDTO.setBlocks(blocks);
		}
		
		return itemDTO;
	}
	
	private ProjectRevenueItemDTO addCashMainRow(){
		ProjectRevenueItemDTO itemDTO = new ProjectRevenueItemDTO();
		itemDTO.setDescription("Cash");
		itemDTO.setHeading(true);
		itemDTO.setCurrency(false);
		if(columns.size() -1 >0 ){
			List<BigDecimal> blocksList = new ArrayList<BigDecimal>();
			for(String blockNo:blockCodeList){
				BigDecimal result = new BigDecimal(this.projectService.getCashCountByNo(blockNo, selectedProjectId));
				blocksList.add(result);
				if(result != null){
					itemDTO.setTotal(itemDTO.getTotal().add(result));
				}
			}
			itemDTO.setBlocks(blocksList);
			
		}
		return itemDTO;
	}
	private ProjectRevenueItemDTO addCashSum(String type){
		ProjectRevenueItemDTO itemDTO = new ProjectRevenueItemDTO();
		if(type.equals("Gross")){
			itemDTO.setDescription("a) Gross Sales");
		}else if(type.equals("Net") ){
			itemDTO.setDescription("b) Net Sales");
		}
		if(columns.size() -1 >0 ){
			List<BigDecimal> blocksList = new ArrayList<BigDecimal>();
			for(String blockNo:blockCodeList){
				BigDecimal result = this.projectService.addCashSum(blockNo, selectedProjectId,type);
				blocksList.add(result);
				if(result != null){
					itemDTO.setTotal(itemDTO.getTotal().add(result));
				}
			}
			itemDTO.setBlocks(blocksList);
			
		}
		return itemDTO;
	}
	
	private ProjectRevenueItemDTO addLOMainRow(){
		ProjectRevenueItemDTO itemDTO = new ProjectRevenueItemDTO();
		itemDTO.setDescription("LO");
		itemDTO.setHeading(true);
		itemDTO.setCurrency(false);
		if(columns.size() -1 >0 ){
			List<BigDecimal> blocksList = new ArrayList<BigDecimal>();
			for(String blockNo:blockCodeList){
				BigDecimal result = new BigDecimal(this.projectService.getLOCountByNo(blockNo, selectedProjectId));
				blocksList.add(result);
				if(result != null){
					itemDTO.setTotal(itemDTO.getTotal().add(result));
				}
			}
			itemDTO.setBlocks(blocksList);
			
		}
		return itemDTO;
	}
	private ProjectRevenueItemDTO addLOSum(String type){
		ProjectRevenueItemDTO itemDTO = new ProjectRevenueItemDTO();
		if(type.equals("Gross")){
			itemDTO.setDescription("a) Gross Sales");
		}else if(type.equals("Net") ){
			itemDTO.setDescription("b) Net Sales");
		}
		if(columns.size() -1 >0 ){
			List<BigDecimal> blocksList = new ArrayList<BigDecimal>();
			for(String blockNo:blockCodeList){
				BigDecimal result = this.projectService.addLOSum(blockNo, selectedProjectId,type);
				blocksList.add(result);
				if(result != null){
					itemDTO.setTotal(itemDTO.getTotal().add(result));
				}
			}
			itemDTO.setBlocks(blocksList);
			
		}
		return itemDTO;
	}
	private ProjectRevenueItemDTO addLOPendingSigningRow(){
		ProjectRevenueItemDTO itemDTO = new ProjectRevenueItemDTO();
		itemDTO.setDescription("Pending LO Signing");
		itemDTO.setCurrency(false);
		int bookingDTOIndex = 10;
		int cashDTOIndex = 22;
		int loDTOIndex = 26;
		if(project.getLandProprietorId() == null || project.getLandProprietorId() == 0L){
			bookingDTOIndex = bookingDTOIndex-4;
			cashDTOIndex = cashDTOIndex-4;
			loDTOIndex = loDTOIndex -4;
		}
		ProjectRevenueItemDTO bookingDTO = projRevSummaryRows.get(bookingDTOIndex);
		ProjectRevenueItemDTO cashDTO = projRevSummaryRows.get(cashDTOIndex);
		ProjectRevenueItemDTO loDTO = projRevSummaryRows.get(loDTOIndex);
		
		if(bookingDTO.getBlocks() != null && bookingDTO.getBlocks().size() >0){
			List<BigDecimal> blocks = new ArrayList<BigDecimal>();
			for(int index = 0; index < bookingDTO.getBlocks().size(); index++){
				blocks.add( bookingDTO.getBlocks().get(index).subtract(cashDTO.getBlocks().get(index)).subtract(loDTO.getBlocks().get(index)));				
				itemDTO.setTotal(itemDTO.getTotal().add(blocks.get(index)));
			}
			itemDTO.setBlocks(blocks);
		}
		
		return itemDTO;
	}
	private ProjectRevenueItemDTO addLAMainRow(){
		ProjectRevenueItemDTO itemDTO = new ProjectRevenueItemDTO();
		itemDTO.setDescription("LA");
		itemDTO.setHeading(true);
		itemDTO.setCurrency(false);
		if(columns.size() -1 >0 ){
			List<BigDecimal> blocksList = new ArrayList<BigDecimal>();
			for(String blockNo:blockCodeList){
				BigDecimal result = new BigDecimal(this.projectService.getLACountByNo(blockNo, selectedProjectId));
				blocksList.add(result);
				if(result != null){
					itemDTO.setTotal(itemDTO.getTotal().add(result));
				}
			}
			itemDTO.setBlocks(blocksList);
			
		}
		return itemDTO;
	}
	private ProjectRevenueItemDTO addLASum(String type){
		ProjectRevenueItemDTO itemDTO = new ProjectRevenueItemDTO();
		if(type.equals("Gross")){
			itemDTO.setDescription("a) Gross Sales");
		}else if(type.equals("Net") ){
			itemDTO.setDescription("b) Net Sales");
		}
		if(columns.size() -1 >0 ){
			List<BigDecimal> blocksList = new ArrayList<BigDecimal>();
			for(String blockNo:blockCodeList){
				BigDecimal result = this.projectService.addLASum(blockNo, selectedProjectId,type);
				blocksList.add(result);
				if(result != null){
					itemDTO.setTotal(itemDTO.getTotal().add(result));
				}
			}
			itemDTO.setBlocks(blocksList);
			
		}
		return itemDTO;
	}
	private ProjectRevenueItemDTO addLAPendingSigningRow(){
		ProjectRevenueItemDTO itemDTO = new ProjectRevenueItemDTO();
		itemDTO.setDescription("Pending LA Signing");
		itemDTO.setCurrency(false);
		int loDTOIndex = 26;
		int laDTOIndex = 31;
		if(project.getLandProprietorId() == null || project.getLandProprietorId() == 0L){
			loDTOIndex = loDTOIndex-4;
			laDTOIndex = laDTOIndex-4;
		}
		ProjectRevenueItemDTO loDTO = projRevSummaryRows.get(loDTOIndex);
		ProjectRevenueItemDTO laDTO = projRevSummaryRows.get(laDTOIndex);
		
		if(loDTO.getBlocks() != null && loDTO.getBlocks().size() >0){
			List<BigDecimal> blocks = new ArrayList<BigDecimal>();
			for(int index = 0; index < loDTO.getBlocks().size(); index++){
				blocks.add( loDTO.getBlocks().get(index).subtract(laDTO.getBlocks().get(index)));				
				itemDTO.setTotal(itemDTO.getTotal().add(blocks.get(index)));
			}
			itemDTO.setBlocks(blocks);
		}
		
		return itemDTO;
	}
	private ProjectRevenueItemDTO addAdviseMainRow(){
		ProjectRevenueItemDTO itemDTO = new ProjectRevenueItemDTO();
		itemDTO.setDescription("Advise");
		itemDTO.setHeading(true);
		itemDTO.setCurrency(false);
		if(columns.size() -1 >0 ){
			List<BigDecimal> blocksList = new ArrayList<BigDecimal>();
			for(String blockNo:blockCodeList){
				BigDecimal result = new BigDecimal(this.projectService.getAdviseCountByNo(blockNo, selectedProjectId));
				blocksList.add(result);
				if(result != null){
					itemDTO.setTotal(itemDTO.getTotal().add(result));
				}
			}
			itemDTO.setBlocks(blocksList);
			
		}
		return itemDTO;
	}
	private ProjectRevenueItemDTO addAdviseSum(String type){
		ProjectRevenueItemDTO itemDTO = new ProjectRevenueItemDTO();
		if(type.equals("Gross")){
			itemDTO.setDescription("a) Gross Sales");
		}else if(type.equals("Net") ){
			itemDTO.setDescription("b) Net Sales");
		}
		if(columns.size() -1 >0 ){
			List<BigDecimal> blocksList = new ArrayList<BigDecimal>();
			for(String blockNo:blockCodeList){
				BigDecimal result = this.projectService.addAdviseSum(blockNo, selectedProjectId,type);
				blocksList.add(result);
				if(result != null){
					itemDTO.setTotal(itemDTO.getTotal().add(result));
				}
			}
			itemDTO.setBlocks(blocksList);
			
		}
		return itemDTO;
	}
	private ProjectRevenueItemDTO addAdvisePendingRow(){
		ProjectRevenueItemDTO itemDTO = new ProjectRevenueItemDTO();
		itemDTO.setCurrency(false);
		itemDTO.setDescription("Pending Advise");
		
		int laDTOIndex = 31;
		int adviseDTOIndex = 36;
		if(project.getLandProprietorId() == null || project.getLandProprietorId() == 0L){
			laDTOIndex = laDTOIndex-4;
			adviseDTOIndex = adviseDTOIndex-4;
		}
		ProjectRevenueItemDTO laDTO = projRevSummaryRows.get(laDTOIndex);
		ProjectRevenueItemDTO adviseDTO = projRevSummaryRows.get(adviseDTOIndex);
		
		if(laDTO.getBlocks() != null && laDTO.getBlocks().size() >0){
			List<BigDecimal> blocks = new ArrayList<BigDecimal>();
			for(int index = 0; index < laDTO.getBlocks().size(); index++){
				blocks.add( laDTO.getBlocks().get(index).subtract(adviseDTO.getBlocks().get(index)));				
				itemDTO.setTotal(itemDTO.getTotal().add(blocks.get(index)));
			}
			itemDTO.setBlocks(blocks);
		}
		
		return itemDTO;
	}
	public void exportReportAction(Long formatID) {
		try {
			String selectedProjectIdStr = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedProjectId");
			if(selectedProjectIdStr != null){
				selectedProjectId = Long.parseLong(selectedProjectIdStr);
				reportDTO.setProjectId(selectedProjectId);
				reportDTO.setReportFormatId(formatID);
				
				if(project != null){
					columns = getTotalBlocks();
					populateSalesSummaryItemDTO();
					reportDTO.setProjectName(project.getProjectName());
					reportDTO.setInstitutionName(project.getInstitution().getInstitutionName());
					reportService.generateSalesSummaryReport(reportDTO,projRevSummaryRows,columns);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void exportTotalLoanOfferedReport(Long formatID) {
		try {
			String selectedProjectIdStr = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedProjectId");
			if(selectedProjectIdStr != null){
				selectedProjectId = Long.parseLong(selectedProjectIdStr);
				reportDTO.setProjectId(selectedProjectId);
				reportDTO.setReportFormatId(formatID);
				reportDTO.setBlocksTitle(blocksTitle);
				reportService.generateTotalLoanOfferedReport(reportDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void exportSalesByStaffAgentReport(Long formatID) {
		try {
			String selectedProjectIdStr = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedProjectId");
			if(selectedProjectIdStr != null){
				selectedProjectId = Long.parseLong(selectedProjectIdStr);
				reportDTO.setProjectId(selectedProjectId);
				reportDTO.setReportFormatId(formatID);
				reportDTO.setBlocksTitle(blocksTitle);
				reportService.generateSalesByStaffAgentReport(reportDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private ProjectRevenueItemDTO addDescriptionOnlyRow(String description){
		ProjectRevenueItemDTO itemDTO = new ProjectRevenueItemDTO();
		itemDTO.setDescription(description);
		if(project != null){
			if(project.getStartDate() != null && project.getEndDate() != null){
				SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy");
				String startDate = dateTimeFormat.format(project.getStartDate());
				String endDate = dateTimeFormat.format(project.getEndDate());
				itemDTO.setAdditionalInformation(startDate + " till "+endDate);
			}else{
				itemDTO.setAdditionalInformation(null);
			}
		}

		itemDTO.setHeading(true);
		itemDTO.setEmptyRow(true);
		itemDTO.setTotal(null);
		return itemDTO;
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


	public List<String> getColumns() {
		return columns;
	}


	public void setColumns(List<String> columns) {
		this.columns = columns;
	}
	
	
	public ReportDTO getReportDTO() {
		return reportDTO;
	}


	public void setReportDTO(ReportDTO reportDTO) {
		this.reportDTO = reportDTO;
	}


	public ReportService getReportService() {
		return reportService;
	}


	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}


	public List<ProjectRevenueItemDTO> getProjRevSummaryRows() {
		return projRevSummaryRows;
	}


	public void setProjRevSummaryRows(List<ProjectRevenueItemDTO> projRevSummaryRows) {
		this.projRevSummaryRows = projRevSummaryRows;
	}


	public List<TotalLoanOfferedItemDTO> getTotalLoanOfferedRows() {
		return totalLoanOfferedRows;
	}


	public void setTotalLoanOfferedRows(
			List<TotalLoanOfferedItemDTO> totalLoanOfferedRows) {
		this.totalLoanOfferedRows = totalLoanOfferedRows;
	}


	public String getTotalLoanOfferedBlocks() {
		return blocksTitle;
	}


	public void setTotalLoanOfferedBlocks(String totalLoanOfferedBlocks) {
		this.blocksTitle = totalLoanOfferedBlocks;
	}


	public List<SalesByAgentItemDTO> getSalesByAgentRows() {
		return salesByAgentRows;
	}


	public void setSalesByAgentRows(List<SalesByAgentItemDTO> salesByAgentRows) {
		this.salesByAgentRows = salesByAgentRows;
	}


	public String getBlocksTitle() {
		return blocksTitle;
	}


	public void setBlocksTitle(String blocksTitle) {
		this.blocksTitle = blocksTitle;
	}
	
}
