package pac1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class flipkartproject {
	WebDriver driver;
  @Test
  public void f() throws Exception {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  driver.get("https://www.flipkart.com/");
	  driver.manage().window().maximize();
	  
	  //login testing
	  
	  WebElement login =driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/header/div[2]/div[2]/div/div/div/div/a/span"));
	  if(login.isDisplayed()) {
		  Assert.assertTrue(true);
		  login.click();
	  }
	  else {
		  Assert.assertTrue(false);
	  }
	  
	  driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[1]/input")).sendKeys("6302827224");
	  driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[3]/button")).click();
	  
	  Thread.sleep(25000);
	  
	  
	  
	  


	  WebElement search=driver.findElement(By.xpath("//input[@name='q']"));
	  search.sendKeys("mobile",Keys.ENTER);
  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  
	  WebElement minDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
			    By.xpath("//select[option[text()='Min']]")));
			Select min = new Select(minDropdown);
			min.selectByContainsVisibleText("₹10000");
			Thread.sleep(1000);
	  
	  WebElement maxDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
			    By.xpath("//select[option[text()='₹30000+']]"))); 
			Select max = new Select(maxDropdown);
			max.selectByContainsVisibleText("₹15000");
	  
	  Thread.sleep(2000);

	  
	  WebElement oppo=driver.findElement(By.xpath("//div[text()='OPPO']"));
	  oppo.click();
	  
  Thread.sleep(2000);
	  
	
	  WebElement icon = driver.findElement(By.cssSelector("#container > div > div.nt6sNV.JxFEK3._48O0EI > div > div:nth-child(2) > div:nth-child(2) > div > div > div > a > div.Otbq5D > div.oUss6M.ssUU08 > div > svg > path"));
	  icon.click(); 
	  
	  Thread.sleep(2000);
	  
	  Actions account=new Actions(driver);
	  account.moveToElement(driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div"))).perform();
	  
	  WebElement wishlist=driver.findElement(By.xpath("//a[.//div[text()='Wishlist']]"));
	  wishlist.click();
	  

	  Thread.sleep(2000);


	  WebElement plus=driver.findElement(By.xpath("//img[@title='Flipkart']"));
	  plus.click();
  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  WebElement fashion = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div/div/div/div/div/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/div[1]/div/div/span/span[1]"));
	  Actions act = new Actions(driver);
	  act.moveToElement(fashion).perform();
	  Thread.sleep(1000);
	  
	  WebElement kids=driver.findElement(By.linkText("Kids"));
	  act.moveToElement(kids).perform();
	  
	  WebElement kids_shirts=driver.findElement(By.linkText("Boys & Girls Tshirts"));
	  kids_shirts.click();
	  
	  WebElement minDropdown1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
			    By.xpath("//select[option[text()='Min']]")));
			Select min1 = new Select(minDropdown1);
			min1.selectByContainsVisibleText("300");
			
			  WebElement maxDropdown1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
					    By.xpath("//select[option[text()='250+']]"))); 
					Select max1 = new Select(maxDropdown1);
					max1.selectByContainsVisibleText("500");
					
					Thread.sleep(1000);
					
					driver.findElement(By.xpath("//div[text()='Brand']")).click();
					
					driver.findElement(By.xpath("//div[text()='Allen Solly']")).click();
					Thread.sleep(2000);

	  driver.findElement(By.cssSelector("#container > div > div.nt6sNV.JxFEK3._48O0EI > div > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(1) > div > a > div:nth-child(1) > div > div.wvIX4U > div > img")).click();
	  
	  String originalWindow = driver.getWindowHandle();
	  WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait1.until(driver -> driver.getWindowHandles().size() > 1);
	  
	  for (String windowHandle : driver.getWindowHandles()) {
		    if (!windowHandle.equals(originalWindow)) {
		        driver.switchTo().window(windowHandle);
		        break;
		    }
		}
	  
	  JavascriptExecutor js1 = (JavascriptExecutor) driver;
	    js1.executeScript("window.scrollTo(0, document.body.scrollHeight/2);");
	  
	 
    
    driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
    
    Thread.sleep(1000);
    
    
    
    driver.findElement(By.xpath("//button[text()='+']")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[text()='–']")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[.//span[text()='Place Order']]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[text()='Deliver Here']")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//button[text()='CONTINUE']")).click();
    
    
    
    

	  
  }
}
