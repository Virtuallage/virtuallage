package com.vipro.constant;


public class JasperConst {

	
	public static final String TOMCAT_HOME = System.getProperty("catalina.base") + "/wtpwebapps";
	
	public static final String SALES_REG_RECEIPT = TOMCAT_HOME + "/vipro/report/sales_reg_receipt.jrxml";

	public static final String SALES_REG_FORM = TOMCAT_HOME + "/vipro/report/sales_reg_form.jrxml";
	
	public static final String MIS_PROJECT_PRICING = TOMCAT_HOME + "/vipro/report/mis_proj_pricing.jrxml";

	public static final String TMP_PATH = System.getProperty("java.io.tmpdir") + "/";
	
	public static final String TMP_FILENAME = "jasper_tmp";

}
