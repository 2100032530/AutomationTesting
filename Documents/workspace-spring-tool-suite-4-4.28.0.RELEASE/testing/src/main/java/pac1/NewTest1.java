package pac1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest1 {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(String username,String password) {
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  driver.manage().window().fullscreen();
	  driver.findElement(By.name("username")).sendKeys(username);
	  driver.findElement(By.name("password")).sendKeys(password);
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  
	  //after login verifying whether dashboard is visible or not
	  if(driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed()) {
		  Assert.assertTrue(true); 
	  }
	  else {
		  Assert.assertTrue(false);
	  }
	  
  }
  
  @Test(dataProvider = "dp1")
  public void leave(Integer days,String username,String password) {
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  driver.manage().window().fullscreen();
	  driver.findElement(By.name("username")).sendKeys(username);
	  driver.findElement(By.name("password")).sendKeys(password);
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  driver.findElement(By.xpath("//span[text()='Leave']")).click();
	  if(driver.findElement(By.xpath("//h5[text()='Leave List']")).isDisplayed()) {
		  Assert.assertTrue(true);
	  }
	  else {
		  Assert.assertTrue(false);
		  
	  }
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "Admin", "admin123" },
      //new Object[] { 2, "b" },
    };
  }
  
  @DataProvider
  public Object[][] dp1() {
    return new Object[][] {
      new Object[] { 20 ,  "Admin", "admin123" },
      //new Object[] { 2, "b" },
    };
  }
  
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
