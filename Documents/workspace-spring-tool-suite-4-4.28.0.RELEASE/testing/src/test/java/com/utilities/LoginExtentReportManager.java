package com.utilities;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LoginExtentReportManager {
	private static ExtentReports extent;
	public static ExtentReports getReportInstance() {
		if(extent==null) {
			String reportPath = System.getProperty("user.dir") + "//reports" + "//LoginTestReport.html";
			ExtentSparkReporter spark=new ExtentSparkReporter(reportPath);
			spark.config().setDocumentTitle("Login Testing");
			spark.config().setReportName("Selenium Result tests");
			extent=new ExtentReports();
			extent.attachReporter(spark);
			extent.setSystemInfo("Tester", "Sowmya");

		}
		return extent;
	}
	
	public static String getScreenshotPath(WebDriver driver, String testName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String directory = System.getProperty("user.dir") + "//reports";

        File folder = new File(directory);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String screenshotPath = directory + "/" + testName + "_" + timestamp + ".png";

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(screenshotPath);
        try {
            FileHandler.copy(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }
	


}
