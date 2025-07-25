package com.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LoginExtentReportManager {
	private static ExtentReports extent;
	public static ExtentReports getReportInstance() {
		if(extent==null) {
			String reportPath = System.getProperty("user.dir") + "//LoginTestReport.html";
			ExtentSparkReporter spark=new ExtentSparkReporter(reportPath);
			spark.config().setDocumentTitle("Login Testing");
			spark.config().setReportName("Selenium Result tests");
			extent=new ExtentReports();
			extent.attachReporter(spark);
			extent.setSystemInfo("Tester", "Sowmya");

		}
		return extent;
	}


}
