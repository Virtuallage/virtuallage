package com.vipro.jsf.bean.setup;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.vipro.auth.AuthUser;
import com.vipro.constant.CodeConst;
import com.vipro.constant.CommonConst;
import com.vipro.data.Institution;
import com.vipro.data.UserGroup;
import com.vipro.data.UserProfile;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.service.InstitutionService;
import com.vipro.service.UserGroupService;
import com.vipro.service.UserProfileService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.SpringBeanUtil;

@ManagedBean(name="userGroup")
@SessionScoped
public class UserGroupSetup extends CommonBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6546722971564886725L;

	private UserGroup userGroupFld;
	private UserGroup userGroupFld1;
	private UserProfile userProfileFld;
	
	private List<SelectItem> listStatus;
	private List<UserGroup> listUserGroups;
	private List<UserProfile> listUserProfiles;
	private List<SelectItem> listDepartments;
	private List<SelectItem> listSpecial;
	private List<Institution> listInstitutions;

	public String password;
	
	@PostConstruct
	public void init() {
		userGroupFld = new UserGroup();
		setListStatus(CodeUtil.getCodes("SS"));
		listSpecial = CodeUtil.getCodes("SH");
		setListDepartments(CodeUtil.getCodes(CodeConst.DEPARTMENT));
		setListInstitutions(getInstitutionList());
		RefreshUserGroup();
	}

	public UserGroup getUserGroupFld() {
		return userGroupFld;
	}

	public void setUserGroupFld(UserGroup userGroupFld) {
		this.userGroupFld = userGroupFld;
	}

	public UserGroup getUserGroupFld1() {
		return userGroupFld1;
	}

	public void setUserGroupFld1(UserGroup userGroupFld1) {
		this.userGroupFld1 = userGroupFld1;
	}

	public List<UserGroup> getListUserGroups() {
		return listUserGroups;
	}

	public void setListUserGroups(List<UserGroup> listUserGroups) {
		this.listUserGroups = listUserGroups;
	}

	public UserProfile getUserProfileFld() {
		return userProfileFld;
	}

	public void setUserProfileFld(UserProfile userProfileFld) {
		this.userProfileFld = userProfileFld;
	}

	public List<UserProfile> getListUserProfiles() {
		return listUserProfiles;
	}

	public void setListUserProfiles(List<UserProfile> listUserProfiles) {
		this.listUserProfiles = listUserProfiles;
	}

	public List<SelectItem> getListStatus() {
		return listStatus;
	}

	public void setListStatus(List<SelectItem> listStatus) {
		this.listStatus = listStatus;
	}

	public List<SelectItem> getListDepartments() {
		return listDepartments;
	}

	public void setListDepartments(List<SelectItem> listDepartments) {
		this.listDepartments = listDepartments;
	}

	public List<SelectItem> getListSpecial() {
		return listSpecial;
	}

	public void setListSpecial(List<SelectItem> listSpecial) {
		this.listSpecial = listSpecial;
	}

	public List<Institution> getListInstitutions() {
		return listInstitutions;
	}

	public void setListInstitutions(List<Institution> listInstitutions) {
		this.listInstitutions = listInstitutions;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void RefreshUserGroup() {
		
		UserGroupService usergroup = (UserGroupService) SpringBeanUtil
				.lookup(UserGroupService.class.getName());

		setListUserGroups(usergroup.findAll());
	}

	public void RefreshUserProfile(UserGroup usergroup) {
		
		UserProfileService userprofile = (UserProfileService) SpringBeanUtil
				.lookup(UserProfileService.class.getName());
		setListUserProfiles(userprofile.findByGroup(usergroup));
	}

	private List<Institution> getInstitutionList() {
		InstitutionService institutionService = (InstitutionService) SpringBeanUtil.lookup(InstitutionService.class.getName());
		List<Institution> ins = institutionService.findAllActive();
		return ins;
	}
	
	private UserProfile getUserProfile(String username) {
		UserProfileService userprofile = (UserProfileService) SpringBeanUtil
				.lookup(UserProfileService.class.getName());
		UserProfile up = userprofile.findByUsername(username);
		return up;
	}

	public String LoadUserGroup() {
		return "editUserGroup";
	}

	public String LoadUserProfile() {
		String username = userProfileFld.getUsername();
		userProfileFld = getUserProfile(username);
		setPassword(userProfileFld.getPassword());
		userProfileFld.setPassword(null);
		return "editUserProfile";
	}

	public String NewUserGroup() {
		userGroupFld = new UserGroup();
		userGroupFld.setStatus(CommonConst.STATUS_ACTIVE);
		return "addUserGroup";
	}

	public String NewUserProfile() {
		userProfileFld = new UserProfile();
		userProfileFld.setStatus(CommonConst.STATUS_ACTIVE);
		return "addUserProfile";
	}

	public String backTolistUserGroup() {
		return "listUserGroup";
	}

	public String backTolistUserProfile() {  
		return "listUserProfile";
	}

	public String ListUserProfile() {
		try {
			RefreshUserProfile(userGroupFld);
		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("List User Profile", t.getMessage());
			return null;
		}
		
		return "listUserProfile";
	}
	
	public String UpdateUserGroup() {
		try {
			UserGroupService usergroup = (UserGroupService) SpringBeanUtil
					.lookup(UserGroupService.class.getName());
			
			usergroup.update(userGroupFld);
			
		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("Edit User Group", t.getMessage());
			return null;
		}

		RefreshUserGroup();
		addInfoMessage("Record Saved", "User Group information saved successfully.");
		
		return "listUserGroup";
	}

	public String UpdateUserProfile() {
		String encodedpwd;
		try {
			UserProfileService userprofile = (UserProfileService) SpringBeanUtil
					.lookup(UserProfileService.class.getName());
			
			System.out.println("saved :" + password);
			System.out.println("input :" + userProfileFld.getPassword());
			if (userProfileFld.getPassword() != null) {
				System.out.println("encode now!");
				encodedpwd = EncodePassword(userProfileFld.getPassword());
			} else {
				encodedpwd = password;
				System.out.println("assign now!");
			}
			System.out.println("encoded :" + encodedpwd);
			
			userProfileFld.setPassword(encodedpwd);
			userprofile.update(userProfileFld);
			
		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("Change User Profile", t.getMessage());
			return null;
		}

		RefreshUserGroup();
		addInfoMessage("Record Saved", "User Profile information saved successfully.");
		
		return "listUserProfile";
	}

	public String InsertUserGroup() {
		try {		
			UserGroupService usergroup = (UserGroupService) SpringBeanUtil
					.lookup(UserGroupService.class.getName());
			
			String groupid = userGroupFld.getGroupId();
			userGroupFld.setGroupId(groupid.toUpperCase());
			
			// Check if Code Type exists
			UserGroup userGroupFld1 = new UserGroup();	
			userGroupFld1 = usergroup.findById(groupid);

   			if (userGroupFld1 != null) {
   				addErrorMessage("Add New User Group",
						"Group Id : " + groupid + " already existed." );
				return null;
	        }

			usergroup.insert(userGroupFld);

		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("Add User Group Information", t.getMessage());
			return null;
		}

		RefreshUserGroup();
		addInfoMessage("Record Saved", "User Group information saved successfully.");
		
		return "listUserGroup";
	}
	
	public String InsertUserProfile() {
		try {		
			UserProfileService userprofile = (UserProfileService) SpringBeanUtil
					.lookup(UserProfileService.class.getName());
		
			String username = userProfileFld.getUsername();
		
			// Check if Code Type exists
			UserProfile userProfileFld1 = new UserProfile();	
			userProfileFld1 = userprofile.findByUsername(username);

			if (userProfileFld1 != null) {
				addErrorMessage("Create User Profile",
						"User Id : " + username + " already existed." );
				return null;
			}

			String encodedpwd = EncodePassword(userProfileFld.getPassword());
			userProfileFld.setPassword(encodedpwd);
			userProfileFld.setInvalidPasswordCount(0);
			userProfileFld.setUserGroup(userGroupFld);
			userProfileFld.setInstitution(listInstitutions.get(0));
			userprofile.insert(userProfileFld);

		} catch (Throwable t) {
			t.printStackTrace();
			addErrorMessage("Create User Profile", t.getMessage());
			return null;
		}

	RefreshUserProfile(userGroupFld);
	addInfoMessage("Record Saved", "User Profile created successfully.");
	
	return "listUserProfile";
	}

	public String EncodePassword(String password) {
		Md5PasswordEncoder encoder = (Md5PasswordEncoder) SpringBeanUtil.lookup("passwordEncoder");
		String EncodedPwd = encoder.encodePassword(password,  null);
		
		return EncodedPwd;
	}

}
