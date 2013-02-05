package com.vipro.auth;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.vipro.constant.UserStatusConst;
import com.vipro.data.UserProfile;


/**
 * 
 * @author cvl
 *
 */
@SuppressWarnings("deprecation")
public class AuthService extends HibernateDaoSupport implements UserDetailsService{
	private static final Log log = LogFactory.getLog(AuthService.class);
	
	@Override
	@SuppressWarnings({ "unchecked" })
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		List<UserProfile> list = getHibernateTemplate().find("select o from com.vipro.data.UserProfile o where upper(o.username)=?", username.toUpperCase());
		 
		UserProfile u = null;
		for (UserProfile l : list) {
			u = l;
		}
		
		if (u!=null) {
	
			boolean expired, locked, passwordExpired;
			boolean enabled = false;
			expired=locked=passwordExpired=false;
	

			List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
			try {
				
				if (u.getUserGroup()!=null) {
					GrantedAuthorityImpl ga = new GrantedAuthorityImpl("ROLE_" + u.getUserGroup().getGroupId());
					authList.add(ga);
					log.info(username);
					log.info(ga.getAuthority());
				}
						
				GrantedAuthorityImpl ga2 = new GrantedAuthorityImpl("ROLE_LOGGED_IN");
				authList.add(ga2);

			} finally {
			}
			
	
			
			if (UserStatusConst.STATUS_ACTIVE.equals(u.getStatus())) {
				enabled=true;
			} else {
				enabled=false;
			}
			
			AuthUser user = new AuthUser( u.getUsername(), u.getPassword(), enabled, !expired, !passwordExpired, !locked, authList);
			user.setName(u.getName());
			user.setUserProfile(u);
			
			
			return user;
		}
		
	
		throw new UsernameNotFoundException("Login failed!");
	}

}
