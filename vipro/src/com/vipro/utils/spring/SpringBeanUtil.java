package com.vipro.utils.spring;

import java.io.IOException;


import org.apache.log4j.Logger;
import org.springframework.core.io.Resource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;


import com.vipro.auth.AuthUser;
import com.vipro.dao.UserProfileDao;

/**
 * 
 * @author cvl
 *
 */
public final class SpringBeanUtil {
	private final static Logger log = Logger.getLogger(SpringBeanUtil.class);
	
	public static Object lookup(String id) {
		Object obj=ApplicationContextFactory.getApplicationContext().getBean(id);
		return obj;
	}
	
	/**
	 * 
	 * @param path ex: "classpath:seatmap/file/*.txt"
	 * @return
	 */
	public static Resource[] findFiles(String path) {
		Resource[] res;
		try {
			res = ApplicationContextFactory.getApplicationContext().getResources(path);
			return res;
		} catch (IOException e) {
			log.error(e);
		}
		return null;
	}
	
	

	

}
