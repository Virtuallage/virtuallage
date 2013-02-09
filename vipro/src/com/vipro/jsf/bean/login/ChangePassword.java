package com.vipro.jsf.bean.login;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.vipro.auth.AuthUser;
import com.vipro.data.UserProfile;
import com.vipro.jsf.bean.PageConst;
import com.vipro.service.UserProfileService;
import com.vipro.utils.spring.FacesUtil;
import com.vipro.utils.spring.SpringBeanUtil;

/**
 * 
 * @author cvl
 *
 */
@ManagedBean(name = "changePassword")
@RequestScoped
public class ChangePassword implements PageConst {

	private String username;
	private String oldPassword;
	private String password1;
	private String password2;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
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

	@PostConstruct
	public void init() {
		AuthUser user = FacesUtil.getCurrentUser();
		if (user != null) {
			setUsername(user.getName());
		}
	}

	public String changePassword() {
		Md5PasswordEncoder encoder = (Md5PasswordEncoder) SpringBeanUtil.lookup("passwordEncoder");
		String oldPwd = encoder.encodePassword(oldPassword,  null);
		
		if (!password1.equals(password2)) {
			FacesUtil.addInfoMessage("New Password is not identical", "New Password is not identical");
			return null;
		}
		
		String pwd = encoder.encodePassword(password2, null);
		
		AuthUser authUser = FacesUtil.getCurrentUser();
		if (authUser!=null) {
			UserProfile up = authUser.getUserProfile();
			if (!oldPwd.equals(up.getPassword())) {
				FacesUtil.addInfoMessage("Old Password not correct", "Old Password not correct.");
				return null;
			}
			if (up!=null) {
				UserProfileService serv = (UserProfileService) SpringBeanUtil.lookup(UserProfileService.class.getName());
				up = serv.findById(up.getUserId());
				up.setPassword(pwd);
				serv.update(up);
			}
		}
		
		FacesUtil.addInfoMessage("Password Changed", "Password Changed");
		return MAIN;
	}

}
