package com.vipro.jsf.bean.login;

import java.io.IOException;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.vipro.auth.AuthUser;
import com.vipro.utils.spring.FacesUtil;

@ManagedBean(name = "login")
public class Login {
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login() throws ServletException, IOException {
		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		HttpServletRequest request = ((HttpServletRequest) context.getRequest());

		ServletResponse resposnse = ((ServletResponse) context.getResponse());
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/j_spring_security_check");
		request.setAttribute("j_username", username);
		request.setAttribute("j_password", password);
		dispatcher.forward(request, resposnse);
		FacesContext.getCurrentInstance().responseComplete();

		
		
		AuthUser user = FacesUtil.getCurrentUser();
		
		if (user!=null ) {
			Map<String,Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			session.put("username", user.getUsername());
		}
		
		return null;
	}
}
