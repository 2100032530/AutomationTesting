package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.utilities.LoginExtentReportManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseLoginTest {
	protected WebDriver driver;
	protected static ExtentReports extent;
	protected ExtentTest test;
	protected String phonenumber;
	
	@BeforeSuite
    public void setupExtentReport() {
        extent = LoginExtentReportManager.getReportInstance();
    }
	
	@Parameters("browser")
	@BeforeMethod
    public void setup(Method method,String browser) throws IOException {
		if(browser.equalsIgnoreCase("chrome")) {
		if (method.getName().equals("websiteCheck")) {
		Properties prob=new Properties();
		String projectPath=System.getProperty("user.dir");
		  File f1=new File(projectPath + "//logindata.properties");
		  FileInputStream fis = new FileInputStream(f1);
		  prob.load(fis);
		  String url=prob.getProperty("url");
		  phonenumber=prob.getProperty("phonenumber");
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  driver.get(url);
		  driver.manage().window().maximize();
		}
		
		}
	
		if(browser.equalsIgnoreCase("firefox")) {
			if (method.getName().equals("websiteCheck")) {
			String projectPath=System.getProperty("user.dir");
			Properties prob=new Properties();
			  File f1=new File(projectPath+ "//logindata.properties");
			  FileInputStream fis = new FileInputStream(f1);
			  prob.load(fis);
			  String url=prob.getProperty("url");
			  phonenumber=prob.getProperty("phonenumber");
			  WebDriverManager.firefoxdriver().setup();
			  driver=new FirefoxDriver();
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			  driver.get(url);
			  driver.manage().window().maximize();
			}
			}
		
		
    }
	

	@AfterSuite
    public void flushExtent() {
    	extent.flush();
    }

}
