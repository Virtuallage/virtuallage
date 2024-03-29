package com.vipro.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vipro.dao.ProjectDao;
import com.vipro.dao.ProjectInventoryDao;
import com.vipro.data.Project;
import com.vipro.data.ProjectInventory;
import com.vipro.dto.AdviseUpdateDetailsDTO;
import com.vipro.dto.PaymentEntryDTO;
import com.vipro.dto.TransactionEntryDTO;
import com.vipro.dto.ProgressiveBillingUnitSeachDTO;
import com.vipro.dto.PropertyUnitDetailsDTO;
import com.vipro.dto.SalesByAgentItemDTO;
import com.vipro.dto.TotalLoanOfferedItemDTO;
import com.vipro.dto.ManualEntryApprovalDTO;
import com.vipro.dto.LoanCancellationDTO;

@Service("com.vipro.service.ProjectService")
public class ProjectServiceImpl implements ProjectService,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5797233200083567618L;
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private ProjectInventoryDao projectInventoryDao;
	

	public ProjectDao getProjectDao() {
		return projectDao;
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	public ProjectInventoryDao getProjectInventoryDao() {
		return projectInventoryDao;
	}

	public void setProjectInventoryDao(ProjectInventoryDao projectInventoryDao) {
		this.projectInventoryDao = projectInventoryDao;
	}

	@Override
	public List<Project> findAllProjects() {
		return projectDao.findAll();
	}

	@Override
	public List<ProjectInventory> findInventories(Long projectId) {
		return projectInventoryDao.findByProjectId(projectId);
	}

	@Override
	public void insert(Project p) {
		projectDao.insert(p);

	}

	@Override
	public void update(Project p) {
		projectDao.update(p);

	}

	@Override
	public void deleteProject(Long projectId) {
		Project p = projectDao.findById(projectId);
		projectDao.delete(p);

	}

	@Override
	public void insert(ProjectInventory i) {
		projectInventoryDao.insert(i);

	}

	@Override
	public void update(ProjectInventory i) {
		projectInventoryDao.update(i);

	}

	@Override
	public void deleteInventory(Long inventoryId) {
		ProjectInventory i = projectInventoryDao.findById(inventoryId);
		projectInventoryDao.delete(i);

	}

	@Override
	public Project findById(Long projectId) {
		return projectDao.findById(projectId);
	}

	@Override
	public Project findByIdAndUnit(Long projectId,String unit) {
		Project p = null;
		if(StringUtils.isEmpty(unit))
			p = projectDao.findById(projectId);
		else
			p = projectDao.findByIdAndUnit(projectId, unit);		
		return p;
	}
	
	public List<PropertyUnitDetailsDTO> getPropertyUnitDetailsDTOListByProjectIdAndUnit(Long projectId, String UnitNo){
		return projectDao.getPropertyUnitDetailsDTOListByProjectIdAndUnit(projectId, UnitNo);
	}
	
	public List<AdviseUpdateDetailsDTO> getAdviseUpdateDetailsDTOListByProjectIdAndUnit(Long projectId, String UnitNo){
		return projectDao.getAdviseUpdateDetailsDTOListByProjectIdAndUnit(projectId, UnitNo);
	}
	@Override
	public List<String> getTotalInventoryBlocks() {
		List<String> result = null;
			try{
				result = projectInventoryDao.getTotalInventoryBlocks();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		return result;
	}

	@Override
	public Long getBlockCountByNo(String blockNo,Long projectId) {
		Long count = 0l;
			try{
				count = projectInventoryDao.getBlockCountByNo(blockNo,projectId);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		return count;
	}

	
	@Override
	public BigDecimal getValidityPeriodSum(String blockNo, Long projectId,String type) {
		BigDecimal result = new BigDecimal(0);
		try{
			result = projectInventoryDao.getValidityPeriodSum(blockNo,projectId,type);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
	}

	
	@Override
	public Long getA5NameBlockCountByNo(String blockNo, Long projectId,Long businessPartnerId) {
		Long count = 0l;
		try{
			count = projectInventoryDao.getA5NameBlockCountByNo(blockNo,projectId,businessPartnerId);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	return count;
	}
	@Override
	public BigDecimal addA5NameSum(String blockNo, Long projectId,String type,Long landProprietorID) {
		BigDecimal result = new BigDecimal(0);
		try{
			result = projectInventoryDao.addA5NameSum(blockNo,projectId,type,landProprietorID);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public Long getBookingCountByNo(String blockNo, Long projectId) {
		Long count = 0l;
		try{
			count = projectInventoryDao.getBookingCountByNo(blockNo,projectId);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	return count;
	}
	@Override
	public BigDecimal addBookingSum(String blockNo, Long projectId,String type) {
		BigDecimal result = new BigDecimal(0);
		try{
			result = projectInventoryDao.addBookingSum(blockNo,projectId,type);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public BigDecimal addSPASum(String blockNo, Long projectId, String type) {
		BigDecimal result = new BigDecimal(0);
		try{
			result = projectInventoryDao.addSPASum(blockNo,projectId,type);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public Long getSPACountByNo(String blockNo, Long projectId) {
		Long count = 0l;
		try{
			count = projectInventoryDao.getSPACountByNo(blockNo,projectId);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	return count;
	}

	@Override
	public Long getCashCountByNo(String blockNo, Long projectId) {
		Long count = 0l;
		try{
			count = projectInventoryDao.getCashCountByNo(blockNo,projectId);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return count;
	}

	@Override
	public BigDecimal addCashSum(String blockNo, Long projectId, String type) {
		BigDecimal result = new BigDecimal(0);
		try{
			result = projectInventoryDao.addCashSum(blockNo,projectId,type);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public Long getLOCountByNo(String blockNo, Long projectId) {
		Long count = 0l;
		try{
			count = projectInventoryDao.getLOCountByNo(blockNo,projectId);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return count;
	}

	@Override
	public BigDecimal addLOSum(String blockNo, Long projectId, String type) {
		BigDecimal result = new BigDecimal(0);
		try{
			result = projectInventoryDao.addLOSum(blockNo,projectId,type);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public Long getLACountByNo(String blockNo, Long projectId) {
		Long count = 0l;
		try{
			count = projectInventoryDao.getLACountByNo(blockNo,projectId);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return count;
	}

	@Override
	public BigDecimal addLASum(String blockNo, Long projectId, String type) {
		BigDecimal result = new BigDecimal(0);
		try{
			result = projectInventoryDao.addLASum(blockNo,projectId,type);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
	}
	@Override
	public Long getAdviseCountByNo(String blockNo, Long projectId) {
		Long count = 0l;
		try{
			count = projectInventoryDao.getAdviseCountByNo(blockNo,projectId);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return count;
	}

	@Override
	public BigDecimal addAdviseSum(String blockNo, Long projectId, String type) {
		BigDecimal result = new BigDecimal(0);
		try{
			result = projectInventoryDao.addAdviseSum(blockNo,projectId,type);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public List<TotalLoanOfferedItemDTO> getTotalLoanOfferedByProjectId(
			Long projectId) {
		List<TotalLoanOfferedItemDTO> resultList = null;
		try{
			List<Object> resultObj = projectInventoryDao.getTotalLoanOfferedByProjectId(projectId);
			if(resultObj != null && resultObj.size() > 0){
				resultList = new ArrayList<TotalLoanOfferedItemDTO>();
				TotalLoanOfferedItemDTO finalTotalRow = new TotalLoanOfferedItemDTO();
				finalTotalRow.setBankName("Total");
				for(Object obj : resultObj){
					Object[] objArr = (Object[])obj;
					TotalLoanOfferedItemDTO dto = new TotalLoanOfferedItemDTO();
					dto.setBankName(objArr[0].toString());
					dto.setLoanCount(Long.parseLong(objArr[1].toString()));
					dto.setTotalAmount(new BigDecimal(objArr[2].toString()));
					
					finalTotalRow.setLoanCount(finalTotalRow.getLoanCount()+dto.getLoanCount());
					finalTotalRow.setTotalAmount(finalTotalRow.getTotalAmount().add(dto.getTotalAmount()));
					resultList.add(dto);
				}
				resultList.add(new TotalLoanOfferedItemDTO());
				finalTotalRow.setIsTotalRow(true);
				resultList.add(finalTotalRow);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return resultList;
	}

	@Override
	public List<SalesByAgentItemDTO> getSalesByAgentByProjectId(Long projectId) {
		List<SalesByAgentItemDTO> resultList = null;
		try{
			List<Object> resultObj = projectInventoryDao.getSalesByAgentByProjectId(projectId);
			if(resultObj != null && resultObj.size() > 0){
				resultList = new ArrayList<SalesByAgentItemDTO>();
				SalesByAgentItemDTO finalTotalRow = new SalesByAgentItemDTO();
				finalTotalRow.setSoldBy("Total");
				for(Object obj : resultObj){
					Object[] objArr = (Object[])obj;
					SalesByAgentItemDTO dto = new SalesByAgentItemDTO();
					
					if(objArr[0] != null){
						dto.setSoldBy(objArr[0].toString());
					}
					if(objArr[1] != null){
						dto.setUnits(Long.parseLong(objArr[1].toString()));
					}
					if(objArr[2] != null){
						dto.setNetSales(new BigDecimal(objArr[2].toString()));
					}
					if(objArr[3] != null){
						dto.setStaffPurchase(Long.parseLong(objArr[3].toString()));
					}
					if(objArr[4] != null){
						dto.setSalesCampaign(Long.parseLong(objArr[4].toString()));
					}
					
					finalTotalRow.setUnits(finalTotalRow.getUnits()+dto.getUnits());
					finalTotalRow.setNetSales(finalTotalRow.getNetSales().add(dto.getNetSales()));
					finalTotalRow.setStaffPurchase(finalTotalRow.getStaffPurchase()+dto.getStaffPurchase());
					finalTotalRow.setSalesCampaign(finalTotalRow.getSalesCampaign()+dto.getSalesCampaign());
					resultList.add(dto);
				}
				finalTotalRow.setIsTotalRow(true);
				resultList.add(new SalesByAgentItemDTO());
				resultList.add(finalTotalRow);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return resultList;
	}

	@Override
	public List<ProgressiveBillingUnitSeachDTO> getProgressiveBillingUnitSearchDTOListByProjectIdAndUnit(
			Long projectId, String UnitNo) {
		return projectDao.getProgressiveBillingUnitSearchDTOListByProjectIdAndUnit(projectId, UnitNo);
		}
	
	@Override
	public List<PaymentEntryDTO> getPaymentEntryDTOListByProjectIdAndUnit(Long projectId, String UnitNo){
		return projectDao.getPaymentEntryDTOListByProjectIdAndUnit(projectId, UnitNo);
	}
	
	@Override
	public List<TransactionEntryDTO> getTransactionEntryDTOListByProjectIdAndUnit(Long projectId, String UnitNo){
		return projectDao.getTransactionEntryDTOListByProjectIdAndUnit(projectId, UnitNo);
	}
	
	@Override
	public List<ManualEntryApprovalDTO> getManualEntryApprovalDTOList(Long projectId, String UnitNo){
		return projectDao.getManualEntryApprovalDTOList(projectId, UnitNo);
	}
	
	public List<LoanCancellationDTO> getLoanCancellationByProjectIdAndUnit(Long projectId, String UnitNo){
		return projectDao.getLoanCancellationByProjectIdAndUnit(projectId, UnitNo);
	}

}
