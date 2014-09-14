package com.vipro.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.constant.ProgressiveBillingConst;
import com.vipro.constant.PropertyUnitStatusConst;
import com.vipro.constant.TransactionCodeConst;
import com.vipro.constant.TransactionStatusConst;
import com.vipro.constant.CommonConst;
import com.vipro.data.Account;
import com.vipro.data.Address;
import com.vipro.data.Customer;
import com.vipro.data.Project;
import com.vipro.data.ProjectInventory;
import com.vipro.data.TransactionHistory;
import com.vipro.data.UserProfile;
import com.vipro.dto.AdviseUpdateDetailsDTO;
import com.vipro.dto.PaymentEntryDTO;
import com.vipro.dto.TransactionEntryDTO;
import com.vipro.dto.ProgressiveBillingUnitSeachDTO;
import com.vipro.dto.PropertyUnitDetailsDTO;
import com.vipro.dto.ManualEntryApprovalDTO;

@SuppressWarnings("unchecked")
@Repository("com.vipro.dao.ProjectDao")
public class ProjectDaoImpl extends DaoImpl<Project> implements ProjectDao {

	@Override
	public List<Project> findAll() {
		String query = "select o from Project o ";
		return getHibernateTemplate().find(query);
	}

	@Override
	public Project findById(Long id) {
		return getHibernateTemplate().get(Project.class, id);
	}

	@Override
	public Project findByIdAndUnit(Long id, String unit) {		
		
		StringBuilder  query = new StringBuilder(" select o.project from ProjectInventory o where o.project.projectId=? ");
		if (!StringUtils.isEmpty(unit)){
			query.append(" and upper(o.unitNo)='"+ unit.trim().toUpperCase()+"'");
		}
				
		List<Project> list =  getHibernateTemplate().find(query.toString(), id);
		if (list != null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	@Override
	public List<PropertyUnitDetailsDTO> getPropertyUnitDetailsDTOListByProjectIdAndUnit(Long id, String UnitNo){
	
		List<PropertyUnitDetailsDTO> resultList = new ArrayList<PropertyUnitDetailsDTO>();
		StringBuilder  query = new StringBuilder(" select distinct o, o.project, a , a.customer , propertyAddress from ProjectInventory o left outer join o.propertyAddress as propertyAddress, Account a " +
				" where o.project.projectId=?  ");
		query.append(" and a.projectInventory.inventoryId = o.inventoryId and a.accountStatus <> '" 
				+ CommonConst.STATUS_CANCELLED + "'");
		if (!StringUtils.isEmpty(UnitNo)){
			query.append(" and upper(o.unitNo) Like'"+ UnitNo.trim().toUpperCase()+"%' ");
		}
		
		query.append(" order by o.unitNo ");		
		
		List<Object[]> list =  getHibernateTemplate().find(query.toString() , id);
		if (list != null && list.size()>0) {
			for (Object[] ob : list) {
					PropertyUnitDetailsDTO dto = new PropertyUnitDetailsDTO((ProjectInventory)ob[0],(Project)ob[1],(Customer)ob[3],(Account)ob[2],(Address)ob[4]);
				resultList.add(dto);
			}	
		}
		return resultList;
	}
	
	@Override
	public List<AdviseUpdateDetailsDTO> getAdviseUpdateDetailsDTOListByProjectIdAndUnit(Long projectId, String UnitNo){
		List<AdviseUpdateDetailsDTO> resultList = new ArrayList<AdviseUpdateDetailsDTO>();
		StringBuilder  query = new StringBuilder(" select distinct o, o.project, a , a.customer , a.adviseVerifiedBy from ProjectInventory o,  Account a " +
				" where o.project.projectId=?  ");
		query.append(" and a.projectInventory.inventoryId = o.inventoryId and a.accountStatus <> '" 
				+ CommonConst.STATUS_CANCELLED + "'");
		if (!StringUtils.isEmpty(UnitNo)){
			query.append(" and upper(o.unitNo) Like'"+ UnitNo.trim().toUpperCase()+"%'");
		}
		
		query.append(" order by o.unitNo ");
		List<Object[]> list =  getHibernateTemplate().find(query.toString() , projectId);
		if (list != null && list.size()>0) {
			for (Object[] ob : list) {
				AdviseUpdateDetailsDTO dto = new AdviseUpdateDetailsDTO((ProjectInventory)ob[0],(Project)ob[1],(Customer)ob[3],(Account)ob[2],findUserNameByUserId((Long)ob[4]));
				resultList.add(dto);
			}	
		}
		return resultList;
	}
	
	
	@Override
	public List<PaymentEntryDTO> getPaymentEntryDTOListByProjectIdAndUnit(Long projectId, String UnitNo){
		List<PaymentEntryDTO> resultList = new ArrayList<PaymentEntryDTO>();
		StringBuilder  query = new StringBuilder(" select distinct o, o.project, a , a.customer , a.adviseVerifiedBy, th from ProjectInventory o,  Account a, TransactionHistory th, ProgressiveBilling pb" +
				" where o.project.projectId=? and a.accountStatus <> '" 
				+ CommonConst.STATUS_CANCELLED + "'");
		query.append(" and th.invoiceNo = pb.invoiceNo and pb.txnReversalId is Null ");
		query.append(" and a.projectInventory.inventoryId = o.inventoryId ");
		query.append(" and a.accountId = th.account.accountId " )
		.append(" and th.transactionCode.transactionCode IN ("+TransactionCodeConst.ADD_PROGRESSIVE_BILLING +","+TransactionCodeConst.RENOTICE_BILLING+" ) ")
		.append(" and th.status in ( '"+TransactionStatusConst.PENDING+"', '"+TransactionStatusConst.POSTED+"' ) ")
		.append(" and th.txnReversalId is NULL " );
		
		if (!StringUtils.isEmpty(UnitNo)){
			query.append(" and upper(o.unitNo) Like'"+ UnitNo.trim().toUpperCase()+"%'");
		}
		query.append(" order by  th.invoiceNo ");
		
		List<Object[]> list =  getHibernateTemplate().find(query.toString() , projectId);
		if (list != null && list.size()>0) {
			for (Object[] ob : list) {
				PaymentEntryDTO dto = new PaymentEntryDTO((ProjectInventory)ob[0],(Project)ob[1],(Customer)ob[3],(Account)ob[2],findUserNameByUserId((Long)ob[4]),(TransactionHistory)ob[5]);
				resultList.add(dto);
			}	
		}
		return resultList;
	}
	
	private String findUserNameByUserId(Long id) {
		String name = "";
		if(id != null){
			UserProfile u = getHibernateTemplate().get(UserProfile.class, id);
			if(u != null ){
				name = u.getName();
			}
			
		}
		return name;
		}
	@Override
	public List<ProgressiveBillingUnitSeachDTO> getProgressiveBillingUnitSearchDTOListByProjectIdAndUnit(Long projectId, String UnitNo) {
		List<ProgressiveBillingUnitSeachDTO> resultList = new ArrayList<ProgressiveBillingUnitSeachDTO>();
		StringBuilder query = new StringBuilder(
				" select distinct pi, pi.project, a.customer, a , cd.description from ProjectInventory pi ,CodeDet cd,  Account a " )
		.append(" where pi.project.projectId=? and pi.propertyStatus = cd.id.code ")
		.append(" and pi.inventoryId = a.projectInventory.inventoryId ")
		.append(" and pi.propertyStatus = ? ")
		.append(" and a.accountStatus <> '" + CommonConst.STATUS_CANCELLED + "'");
				
		if (!StringUtils.isEmpty(UnitNo)) {
			query.append(" and upper(pi.unitNo) Like'"+ UnitNo.trim().toUpperCase()+"%' ");
		}
	
		query.append(" order by pi.unitNo ");		

		List<Object[]> list = getHibernateTemplate().find(query.toString(), projectId, PropertyUnitStatusConst.STATUS_SOLD);
		if (list != null && list.size() > 0) {


			for (Object[] ob : list) {
				
				ProgressiveBillingUnitSeachDTO dto = new ProgressiveBillingUnitSeachDTO(
						(ProjectInventory) ob[0], (Project) ob[1],
						(Customer) ob[2], (Account) ob[3]);
				dto.setStatusDesc((String)ob[4]);
				dto.setStageNo(getProgressiveBillingStage(dto.getAccount().getAccountId()));
				resultList.add(dto);
			}	
			}
		return resultList;
	}
	
	private String getProgressiveBillingStage(Long account_id) {
		String stage = "0";
		if(account_id != null){
			
			StringBuilder query = new StringBuilder(
					" select max(pb.stageNo)  from  ProgressiveBilling pb " )
			.append(" where pb.account.accountId = ? ")
			.append(" and pb.status in ('"+ProgressiveBillingConst.PB_STATUS_BILL+"', '"+ProgressiveBillingConst.PB_STATUS_FULL_PAYMENT+"')");		
			
			List<String> list = getHibernateTemplate().find(query.toString(),account_id);
			if (list != null && !list.isEmpty()) {
				stage = list.get(0) == null ? "0":list.get(0);
			}			
		}
		return stage;
		}
	
	@Override
	public List<TransactionEntryDTO> getTransactionEntryDTOListByProjectIdAndUnit(Long projectId, String UnitNo){
		List<TransactionEntryDTO> resultList = new ArrayList<TransactionEntryDTO>();

		StringBuilder  query = new StringBuilder(" select distinct o, o.project, a , a.customer from ProjectInventory o, Account a " +
				" where o.project.projectId=?  ");
		query.append(" and a.projectInventory.inventoryId = o.inventoryId and a.accountStatus <> '" 
				+ CommonConst.STATUS_CANCELLED + "'");
		
		if (!StringUtils.isEmpty(UnitNo)){
			query.append(" and upper(o.unitNo) Like'"+ UnitNo.trim().toUpperCase()+"%' ");
		}
		
		query.append(" order by o.unitNo ");			

		List<Object[]> list =  getHibernateTemplate().find(query.toString() , projectId);
		if (list != null && list.size()>0) {
			for (Object[] ob : list) {
				TransactionEntryDTO dto = new TransactionEntryDTO((ProjectInventory)ob[0],(Project)ob[1],(Customer)ob[3],(Account)ob[2]);
				resultList.add(dto);
			}	
		}
		return resultList;
	}
	
	@Override
	public List<ManualEntryApprovalDTO> getManualEntryApprovalDTOList(Long projectId, String UnitNo){
		List<ManualEntryApprovalDTO> resultList = new ArrayList<ManualEntryApprovalDTO>();
		StringBuilder  query = new StringBuilder(" select distinct o, o.project, a , a.customer , a.adviseVerifiedBy, th from ProjectInventory o,  Account a, TransactionHistory th" +
				" where o.project.projectId=? and a.accountStatus <> '" 
				+ CommonConst.STATUS_CANCELLED + "'");
		query.append(" and a.projectInventory.inventoryId = o.inventoryId ");
		query.append(" and a.accountId = th.account.accountId " )
		.append(" and th.status in ( '"+TransactionStatusConst.SAVED+"') ");
		
		if (!StringUtils.isEmpty(UnitNo)){
			query.append(" and upper(o.unitNo) Like'"+ UnitNo.trim().toUpperCase()+"%'");
		}
		query.append(" order by o.unitNo ");
		
		List<Object[]> list =  getHibernateTemplate().find(query.toString() , projectId);
		if (list != null && list.size()>0) {
			for (Object[] ob : list) {
				ManualEntryApprovalDTO dto = new ManualEntryApprovalDTO((ProjectInventory)ob[0],(Project)ob[1],(Customer)ob[3],(Account)ob[2],findUserNameByUserId((Long)ob[4]),(TransactionHistory)ob[5]);
				resultList.add(dto);
			}	
		}
		return resultList;
	}
}
