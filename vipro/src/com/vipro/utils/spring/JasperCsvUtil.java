package com.vipro.utils.spring;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import javax.faces.context.FacesContext;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.JRExporterParameter;

import com.vipro.constant.DataSourceConst;
import com.vipro.constant.JasperConst;
import com.vipro.data.Account;
import com.vipro.data.Project;
import com.vipro.data.ProjectInventory;

public class JasperCsvUtil {

	private static Random randomGenerator = null;
	
	static {
		randomGenerator = new Random(new Date().getTime());
	}

	public static boolean generateReport(HashMap<String, Object> hm,
			String report) {
		String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
	    path = path.concat("MISReport/");
	    File reportDirectory = new File(path);
	    if (!reportDirectory.exists())
	    {
	    	reportDirectory.mkdir();
	    }
		String csv = path + "SalesAdminDataExtraction.csv";
		
		return generateReport(hm, report, csv);
	}
	
	public static boolean generateReport(HashMap<String, Object> hm,
			String report, Account account, String reportType) {
		String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
		
	    path = path.concat("reports/");
	    File reportDirectory = new File(path);
	    if (!reportDirectory.exists())
	    {
	    	reportDirectory.mkdir();
	    }
	    
	    path = path.concat(account.getAccountId() + "/");
	    File accountDirectory = new File(path);
	    if (!accountDirectory.exists())
	    {
	    	accountDirectory.mkdir();
	    }
	    
		String csv = path + reportType;
		return generateReport(hm, report, csv);
	}

	public static boolean generateReport(HashMap<String, Object> hm,
			String report, String csv) {
		boolean result = false;
		

		try {
			// String dbUrl = props.getProperty("jdbc.url");
			String dbUrl = DataSourceConst.DB_URL;
			// String dbDriver = props.getProperty("jdbc.driver");
			String dbDriver = DataSourceConst.DB_DRIVER;
			// String dbUname = props.getProperty("db.username");
			String dbUname = DataSourceConst.DB_USERNAME;
			// String dbPwd = props.getProperty("db.password");
			String dbPwd = DataSourceConst.DB_PASSWORD;

			// Load the JDBC driver
			Class.forName(dbDriver);
			// Get the connection
			Connection conn = DriverManager
					.getConnection(dbUrl, dbUname, dbPwd);

			JasperReport jasperReport = JasperCompileManager
					.compileReport(report);
			JasperPrint jasperPrint = JasperFillManager.fillReport(
					jasperReport, hm, conn);
			//JasperExportManager.exportReportToPdfFile(jasperPrint, csv);
			
			JRCsvExporter exporter = new  JRCsvExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT,  jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, csv);
			exporter.exportReport();

			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
