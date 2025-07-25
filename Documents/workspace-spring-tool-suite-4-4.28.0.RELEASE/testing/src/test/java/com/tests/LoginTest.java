package com.tests;


import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.BaseLoginTest;
import com.pages.Login_PageObjects;

public class LoginTest extends BaseLoginTest{
	Login_PageObjects login_obj;
	
	
	  @Test(priority = 1)
	  public void websiteCheck() {
		  test=extent.createTest("Checking Whether Flipkart Website is opened or not");
		  login_obj=new Login_PageObjects(driver);
		  if(login_obj.findWebPage().isDisplayed()) {
			  Assert.assertTrue(true);
			  test.log(Status.PASS, "Flipkart Website Opened");
		  }
		  else {
			  Assert.fail();
			  test.log(Status.FAIL, "Flipkart Website Not Opened");
		  }
		  
		  
	  }
	
	
	  @Test(priority = 2)
  public void loginButtonCheck() {
	  test=extent.createTest("Checking Whether Login Button is displayed or not");
	  login_obj=new Login_PageObjects(driver);
	  if(login_obj.findLogin().isDisplayed()) {
		  Assert.assertTrue(true);
		  test.log(Status.PASS, "Login Button is Displaying");
	  }
	  else {
		  Assert.fail();
		  test.log(Status.FAIL, "Login Button is not Displaying");
	  }
	  
	  
  }
  
	  @Test(priority = 3)
  public void loginButtonClick() {
	  test=extent.createTest("Checking Whether Login Button is Clicked or not");
	  login_obj=new Login_PageObjects(driver);
	  login_obj.clickLogin();
	  if(login_obj.findPhone().isDisplayed()) {
		  Assert.assertTrue(true);
		  test.log(Status.PASS, "Login Button is Clicked");
	  }
	  else {
		  Assert.fail();
		  test.log(Status.FAIL, "Login Button is not Clicked");
	  }
	  
  }
  
  @Test(priority = 4)
  public void checkPhoneNumber() {
	  test=extent.createTest("Checking Whether Phone Number is Entered or not");
	  login_obj=new Login_PageObjects(driver);
	  try {
		  login_obj.clickLogin();
		  login_obj.findPhone().sendKeys(phonenumber);
		  login_obj.clickOtp();
		  Assert.assertTrue(true);
		  test.log(Status.PASS, "Phone Number Entered Successfully");
		  
	  }
	  catch(Exception e) {
		  e.printStackTrace();
		  Assert.fail();
		  test.log(Status.FAIL, "Phone Number Not Entered");
	  }
	   
  }
  
  @Test(priority = 5)
  public void checkLogin() throws Exception {
	  test=extent.createTest("Checking Whether Login is Successful or not");
	  login_obj=new Login_PageObjects(driver);
	  login_obj.clickLogin();
	  login_obj.findPhone().sendKeys(phonenumber);
	  login_obj.clickOtp();
	  Thread.sleep(25000);
	  if(login_obj.account().isDisplayed()) {
		  Assert.assertTrue(true);
		  test.log(Status.PASS, "Login successful");
	  }
	  else {
		  Assert.fail();
		  test.log(Status.FAIL, "Login Unsuccessful");
		  
	  }
	  
  }
  
  
}
