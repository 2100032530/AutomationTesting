package com.tests;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.base.BaseLoginTest;
import com.pages.Login_PageObjects;

public class LoginTest extends BaseLoginTest{
	Login_PageObjects login_obj;
	
	
	  @Test(priority = 1)
	  public void websiteCheck() throws Exception {
		  test=extent.createTest("Login Testing");
		  login_obj=new Login_PageObjects(driver);
		  
		  if(login_obj.findWebPage().isDisplayed()) {
			  Assert.assertTrue(true);
			  test.log(Status.PASS, "Flipkart Website Opened");
		  }
		  else {
			  Assert.fail();
			  test.log(Status.FAIL, "Flipkart Website Not Opened");
		  }
		  
		  if(login_obj.findLogin().isDisplayed()) {
			  Assert.assertTrue(true);
			  test.log(Status.PASS, "Login Button is Displaying");
		  }
		  else {
			  Assert.fail();
			  test.log(Status.FAIL, "Login Button is not Displaying");
		  }
		  login_obj.clickLogin();
		  if(login_obj.findPhone().isDisplayed()) {
			  Assert.assertTrue(true);
			  test.log(Status.PASS, "Login Button is Clicked");
		  }
		  else {
			  Assert.fail();
			  test.log(Status.FAIL, "Login Button is not Clicked");
		  }
		  
		    login_obj.findPhone().sendKeys(phonenumber);
		  
			  login_obj.clickOtp();
			  
			  if(login_obj.verify().isDisplayed()) {
				  Assert.assertTrue(true);
				  test.log(Status.PASS, "Phone Number Entered Successfully");
				  test.log(Status.PASS, "OTP is generated");
			  }
			  else {
				  Assert.fail();
				  test.log(Status.FAIL, "Phone Number Not Entered");
			  }
			  
			  Thread.sleep(20000);
			  if(login_obj.account().isDisplayed()) {
				  Assert.assertTrue(true);
				  test.log(Status.PASS, "Login successful");
			  }
			  else {
				  Assert.fail();
				  test.log(Status.FAIL, "Login Unsuccessful");
				  
			  }
		  }
	  
	  @Test(priority = 2,dataProvider = "searchdata")
	  public void search(String product) throws IOException, Exception {
		  test=extent.createTest("Search Testing");
		  login_obj=new Login_PageObjects(driver);
		  if(login_obj.checkSearch().isDisplayed()) {
			  Assert.assertTrue(true);
			  test.log(Status.PASS, "Search Bar is displayed");
		  }
		  else {
			  Assert.fail();
			  test.log(Status.FAIL, "Search Bar is not displayed");
		  }
		  
		  login_obj.checkSearch().sendKeys(product,Keys.ENTER);
		  if(login_obj.checkElementSearch().isDisplayed()) {
			  Assert.assertTrue(true);
			  test.log(Status.PASS, "Product is Entered");
		  }
		  else {
			  Assert.fail();
			  test.log(Status.FAIL, "Product is not Entered");
		  }
		  test.log(Status.PASS, "Product is searched even when the user not logged in to the website");
		  
		  
		  
	  }
	  @DataProvider
	  public String[] searchdata() throws IOException{
		  String data[]=new String[1];
		  String projectPath = System.getProperty("user.dir");
		  File f1=new File(projectPath +"\\signindata.xlsx");
		  FileInputStream fis = new FileInputStream(f1);
		  XSSFWorkbook wbook= new XSSFWorkbook(fis);
		  XSSFSheet sheet=wbook.getSheetAt(2);
		  int row_count=sheet.getPhysicalNumberOfRows();
		  System.out.println(row_count);
		  
		  for(int i=0;i<row_count;i++) {
			  data[i]=sheet.getRow(i).getCell(0).getStringCellValue();
		  }
		  return data;  
	  }
	  
	  
	  @Test(priority = 3)
		public void addToWishList() throws Exception {
		  test=extent.createTest("addToWishList Testing");
		  login_obj=new Login_PageObjects(driver);
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  if(login_obj.setMinPrice().isDisplayed()) {
			  Assert.assertTrue(true);
			  test.log(Status.PASS, "Minimum price Filter is displayed");
		  }
		  else {
			  Assert.fail();
			  test.log(Status.FAIL, "Minimum price Filter is not displayed");
		  }
		  test.log(Status.PASS, "Minimum price Filter is Selected");
			
		  WebElement minDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
		  By.xpath("//select[option[text()='Min']]")));
				Select min = new Select(minDropdown);
				min.selectByContainsVisibleText("₹10000");
				Thread.sleep(1000);
		  
		  if(login_obj.setMaxPrice().isDisplayed()) {
			  Assert.assertTrue(true);
			  test.log(Status.PASS, "Maximum price Filter is displayed");
		  }
		  else {
			  Assert.fail();
			  test.log(Status.FAIL, "Maximum price Filter is not displayed");
		  }
			 WebElement maxDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath("//select[option[text()='₹30000+']]"))); 
		Select max = new Select(maxDropdown);
		max.selectByContainsVisibleText("₹15000");

       Thread.sleep(2000);
		  
		  test.log(Status.PASS, "Maximum price Filter is Selected");
		  
		  
		  if(login_obj.setBrand().isDisplayed()) {
			  Assert.assertTrue(true);
			  test.log(Status.PASS, "Brands Filter is displayed");
		  }
		  else {
			  Assert.fail();
			  test.log(Status.FAIL, "Brands Filter is not displayed");
		  }
		  login_obj.setBrand().click();
		  
		  test.log(Status.PASS, " OPPO Brand is selected");
		  if(login_obj.clickiocn().isDisplayed()) {
			  Assert.assertTrue(true);
			  test.log(Status.PASS, "WishList icon is displayed");
		  }
		  else {
			  Assert.fail();
			  test.log(Status.FAIL, "WishList icon is not displayed");
		  }
		  Thread.sleep(1000);
		  login_obj.clickiocn().click();
		  test.log(Status.PASS, "Product added to WishList");
		  login_obj.clickPlus();
		  
		}
	  
	  @Test(priority = 4)
	  public void addToCart() throws Exception {
		  test=extent.createTest("addToCart Testing");
		  login_obj=new Login_PageObjects(driver);
		  Actions act = new Actions(driver);
		  act.moveToElement(login_obj.fashion()).perform();
		  Thread.sleep(1000);
		  act.moveToElement(login_obj.kids()).perform();
		  Thread.sleep(1000);
		  login_obj.clothes();
		  
		  if(login_obj.setMinPrice().isDisplayed()) {
			  Assert.assertTrue(true);
			  test.log(Status.PASS, "Minimum price Filter is displayed");
			  
		  }
		  else {
			  Assert.fail();
			  test.log(Status.FAIL, "Minimum price Filter is not displayed");
			  
		  }
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  WebElement minDropdown1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[option[text()='Min']]")));
		  Select min1 = new Select(minDropdown1);
		  min1.selectByContainsVisibleText("300");
		  test.log(Status.PASS, "Minimum price Filter is Selected");
		  
		  if(login_obj.setMaxPrice1().isDisplayed()) {
			  Assert.assertTrue(true);
			  test.log(Status.PASS, "Maximum price Filter is displayed");
			  
		  }
		  else {
			  Assert.fail();
			  test.log(Status.FAIL, "Maximum price Filter is not displayed");
			  
		  }
		  
		  WebElement maxDropdown1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				    By.xpath("//select[option[text()='250+']]"))); 
				Select max1 = new Select(maxDropdown1);
				max1.selectByContainsVisibleText("500");
				
				test.log(Status.PASS, "Maximum price Filter is Selected");
				
				Thread.sleep(1000);
				if(login_obj.brand().isDisplayed()) {
					Assert.assertTrue(true);
					  test.log(Status.PASS, "Brand Filter is displayed");
				}
				else {
					Assert.fail();
					  test.log(Status.FAIL, "Brands Filter is not displayed");
				}
				
				login_obj.brand().click();
				Thread.sleep(1000);
			
					test.log(Status.PASS, "Brand Filter is Selected");
				
				
				login_obj.allen();
				
				test.log(Status.PASS, "Allen Solley Brand is Selected");
				
				Thread.sleep(2000);
				login_obj.shirt().click();
				
					test.log(Status.PASS, "T-Shirt  is Selected");
				
				 String originalWindow = driver.getWindowHandle();
				  WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
				  wait1.until(driver -> driver.getWindowHandles().size() > 1);
				  
				  for (String windowHandle : driver.getWindowHandles()) {
					    if (!windowHandle.equals(originalWindow)) {
					    	test.log(Status.PASS, "Page is redirected");
					        driver.switchTo().window(windowHandle);
					        break;
					    }
					    
					}
				  
				  JavascriptExecutor js1 = (JavascriptExecutor) driver;
				  js1.executeScript("window.scrollTo(0, document.body.scrollHeight/2);");
				    
				 if( login_obj.cart().isDisplayed()) {
					 Assert.assertTrue(true);
					 test.log(Status.PASS, "AddToCart Button is displayed");
				 }
				 else {
					 Assert.fail();
					  test.log(Status.FAIL, "AddToCart Button is not displayed");
				 }
				  login_obj.cart().click();
				
						 test.log(Status.PASS, "AddToCart Button is Selected");
					 
				  Thread.sleep(1000);
				  
				  if(login_obj.add().isDisplayed()) {
					  Assert.assertTrue(true);
						test.log(Status.PASS, "Add button is displayed for adding more than one product");
				  }
				  else {
					  Assert.fail();
					  test.log(Status.FAIL, "Add button is not displayed for adding more than one product");
				  }
				  login_obj.add().click();
				  
						test.log(Status.PASS, "Add button is Selected for adding more than one product");
				 
				  Thread.sleep(2000);
				  if(login_obj.minus().isDisplayed()) {
					  Assert.assertTrue(true);
						test.log(Status.PASS, "Minus button is displayed for subtracting the product");
				  }
				  else {
					  Assert.fail();
					  test.log(Status.FAIL, "Minus button is not displayed for subtracting the product");
				  }
				  login_obj.minus().click();
				  
						test.log(Status.PASS, "Minus button is selected for subtracting the product");
				  
				  Thread.sleep(2000);
		
	  }
	  
	  @Test(priority=5)

	  public void placeOrder() throws Exception {
		  test=extent.createTest("placeOrder Testing");
		  login_obj=new Login_PageObjects(driver);
		  if(login_obj.order().isDisplayed()) {
			  Assert.assertTrue(true);
			  login_obj.order().click();
			test.log(Status.PASS, "PlaceOrder button is displayed ");
			test.log(Status.PASS, "PlaceOrder button is selected");
		  }
		  else {
			  Assert.fail();
			  test.log(Status.FAIL, "PlaceOrder  button is not displayed");
		  }
		  
		  
		  Thread.sleep(2000);
		  
		  if(login_obj.deliver().isDisplayed()) {
			  Assert.assertTrue(true);
			  login_obj.deliver().click();
			test.log(Status.PASS, "DELIVER HERE button is diplayed");
			test.log(Status.PASS, "DELIVER HERE button is selected");
		  }
		  else {
			  Assert.fail();
			  test.log(Status.FAIL, "DELIVER HERE button is not diplayed");
		  }
		  
		  Thread.sleep(1000);
		  
		  if(login_obj.checkout().isDisplayed()){
			  Assert.assertTrue(true);
			  login_obj.checkout().click();
			test.log(Status.PASS, "Check Out button is diplayed");
			test.log(Status.PASS, "Check Out  button is selected");
		  }
		  else {
			  Assert.fail();
			  test.log(Status.FAIL, "Check Out  button is not diplayed");
		  }
		  
		  
		  
	  }
		  
		  
		  
	  
	  
  
  
}
