package com.vipro.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.vipro.common.DaoImpl;
import com.vipro.data.Account;
import com.vipro.data.Address;
import com.vipro.data.Customer;
import com.vipro.data.ProgressiveBilling;
import com.vipro.data.Project;
import com.vipro.data.ProjectInventory;
import com.vipro.data.UserProfile;
import com.vipro.dto.AdviseUpdateDetailsDTO;
import com.vipro.dto.ProgressiveBillingUnitSeachDTO;
import com.vipro.dto.PropertyUnitDetailsDTO;

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
		query.append(" and a.projectInventory.inventoryId = o.inventoryId ");
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
		query.append(" and a.projectInventory.inventoryId = o.inventoryId ");
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
	
	private String findUserNameByUserId(Long id) {
		String name = "";
		if(id != null){
			UserProfile u = getHibernateTemplate().get(UserProfile.class, id);
			name = u.getName();
		}
		return name;
		}
	@Override
	public List<ProgressiveBillingUnitSeachDTO> getProgressiveBillingUnitSearchDTOListByProjectIdAndUnit(Long projectId, String UnitNo) {
		List<ProgressiveBillingUnitSeachDTO> resultList = new ArrayList<ProgressiveBillingUnitSeachDTO>();
		StringBuilder query = new StringBuilder(
				" select distinct pi, pi.project, a.customer,a, pb from ProgressiveBilling pb inner join pb.account a inner join a.projectInventory pi"
						+ " where pi.project.projectId=?  ");
		if (!StringUtils.isEmpty(UnitNo)) {
			query.append(" and upper(pi.unitNo) Like'" + UnitNo.toUpperCase()
					+ "%'");
		}

		
		List<Object[]> list = getHibernateTemplate().find(query.toString(), projectId);
		if (list != null && list.size() > 0) {


			for (Object[] ob : list) {
				ProgressiveBillingUnitSeachDTO dto = new ProgressiveBillingUnitSeachDTO(
						(ProjectInventory) ob[0], (Project) ob[1],
						(Customer) ob[3], (Account) ob[2], (ProgressiveBilling)ob[4]);
				resultList.add(dto);
			}	
			}
		return resultList;
	}
	
}
