package com.vipro.jsf.bean.setup;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import com.vipro.auth.AuthUser;
import com.vipro.constant.BusinessPartnerTypeConst;
import com.vipro.constant.ProjectStatusConst;
import com.vipro.data.UserProfile;
import com.vipro.jsf.bean.CommonBean;
import com.vipro.service.UserProfileService;
import com.vipro.utils.spring.CodeUtil;
import com.vipro.utils.spring.SpringBeanUtil;
import javax.faces.bean.RequestScoped;
import com.vipro.jsf.bean.PageConst;



@ManagedBean(name = "resetPassword")
@SessionScoped
public class ResetPassword extends CommonBean implements Serializable {
	private List<UserProfile> userProfiles;
	private Long userId;
	private String password1;
	private String password2;

	public ResetPassword() {

	}

	@PostConstruct
	public void init() {
	
		listUserProfile();
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String listUserProfile() {
		try {
			UserProfileService userProfileService = (UserProfileService) SpringBeanUtil
					.lookup(UserProfileService.class.getName());
			userProfiles = userProfileService.findAll();
		} catch (Throwable t) {
			addErrorMessage(t.getClass().getName(), t.getMessage());
		}
		return "listUser";
	}

	public String changePassword() {
		Md5PasswordEncoder encoder = (Md5PasswordEncoder) SpringBeanUtil.lookup("passwordEncoder");
		return "listUser";
	}

	public List<UserProfile> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(List<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

}
