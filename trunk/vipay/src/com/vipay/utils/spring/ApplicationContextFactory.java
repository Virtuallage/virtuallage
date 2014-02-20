package com.vipay.utils.spring;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * This class should be used by non-spring-wired classes if they need access to
 * the application context
 * @author cvl
 */
public class ApplicationContextFactory implements ServletContextAware {
	private static Logger log = Logger.getLogger(ApplicationContextFactory.class);

	private static Object initObj = null;
	private static int count = 0;
	private static ApplicationContext context;

	public static void init(Object o) {
		if (count > 0) {
			log.error("Can't initialize the application context twice: THIS SHOULD ONLY HAPPEN DURING TESTING");
		}
		initObj = o;
		count++;
		
	}

	public static ApplicationContext getApplicationContext() {
		
		if (initObj == null) {
			throw new IllegalStateException("Application context not initialized");
		} else if (initObj instanceof ServletContext) {
			ServletContext servletContext = (ServletContext) initObj;
			return WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

		} else if (initObj instanceof String) {
			if (context == null) {
				String contextResourceLocation = (String) initObj;
				context = new ClassPathXmlApplicationContext(contextResourceLocation);
			}
			return context;
		} else if(initObj instanceof ApplicationContext){
			context=(ApplicationContext)initObj;
			return context;
		}else{
			throw new IllegalStateException("You must initialize the context with a String");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.web.context.ServletContextAwar
	 *      e#setServletContext(javax.servlet.ServletContext)
	 */
	public void setServletContext(ServletContext servletContext) {
		init(servletContext);		
	}

}