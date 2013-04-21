package com.vipro.utils.spring;

import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import com.vipro.constant.DataSourceConst;
import com.vipro.constant.JasperConst;

public class JasperUtil {

	private static Random randomGenerator = null;

	static {
		randomGenerator = new Random(new Date().getTime());
	}

	public static boolean generateReport(HashMap<String, Object> hm,
			String report) {
		System.out.println(JasperConst.TOMCAT_HOME + "[aaa]");
		String pdf = JasperConst.TMP_PATH + JasperConst.TMP_FILENAME
				+ randomGenerator.nextLong() + ".pdf";
		return generateReport(hm, report, pdf);
	}

	public static boolean generateReport(HashMap<String, Object> hm,
			String report, String pdf) {
		System.out.println("Usage: ReportGenerator ....");
		boolean result = false;

		try {
			System.out.println("Start ....");
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
			JasperExportManager.exportReportToPdfFile(jasperPrint, pdf);
			System.out.println("Done exporting reports to pdf");

			File myFile = new File(pdf);
			Desktop.getDesktop().open(myFile);
			System.out.println("Done opening pdf");

			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("Exception" + e);
		}
		return result;
	}

}