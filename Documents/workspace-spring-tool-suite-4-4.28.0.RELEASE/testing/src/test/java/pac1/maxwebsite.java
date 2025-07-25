package pac1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class maxwebsite {

	public static void main(String[] args) throws InterruptedException{
	
	
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.manage().window().maximize();
			driver.get("https://www.maxfashion.in/in/en/");

			driver.findElement(By.id("account-actions-signup")).click();
			driver.findElement(By.id("mobileNumber")).sendKeys("8125614748");
			driver.findElement(By.id("signup-form-submit")).click();
			Thread.sleep(15000);
			
			 //Men Product Buying Module
		     Actions actions = new Actions(driver);
		     WebElement menLink = driver.findElement(By.linkText("Men"));
		     actions.moveToElement(menLink).perform();

		     WebElement tShirts = driver.findElement(By.linkText("T-Shirts"));
		     tShirts.click();
		 
		     WebElement Size=driver.findElement(By.xpath("//*[@aria-label='collapse-icon']"));
		     Size.click();
		     
		     WebElement XL=driver.findElement(By.xpath("//*[@id=\"filter-div\"]/div[2]/div[2]/span/div/div/div/div[1]/span/span/input"));
		     XL.click();
		     
		     WebElement L=driver.findElement(By.xpath("//*[@id=\"filter-div\"]/div[2]/div[2]/span/div/div/div/div[2]/span/span/input"));
		     L.click();
		     
		     WebElement M=driver.findElement(By.xpath("//*[@id=\"filter-div\"]/div[2]/div[2]/span/div/div/div/div[3]/span/span/input"));
		     M.click();
		     
		     WebElement Min=driver.findElement(By.xpath("//*[@aria-label='minimum-input']"));
		     Min.clear();
		     Min.sendKeys("500");
		     
		     WebElement Max=driver.findElement(By.xpath("//*[@aria-label='maximum-input']"));
		     Max.clear();
		     Max.sendKeys("1000");
		     
		     WebElement SizeButt=driver.findElement(By.xpath("//*[@id=\"filter-div\"]/div[2]/div[1]/div[2]/div/div[3]/button/span/span"));
		     SizeButt.click();
		     
		     Thread.sleep(1000);
		     WebElement favs = driver.findElement(By.xpath("//button[contains(@class, 'favButtonOnProduct')]"));
		     favs.click();
		     
		     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", favs);
		     Thread.sleep(500);
		     ((JavascriptExecutor) driver).executeScript("arguments[0].click();", favs);
		     
		     WebElement favBtn = driver.findElement(By.xpath("//button[@aria-label='fav-icon']"));
		     favBtn.click();
		     
		     WebElement dropdown1 = driver.findElement(By.xpath("/html/body/div[1]/main/div[1]/div/div/div[2]/ul/li/div/section/div[2]/span[1]/span/span[1]/span"));
		     dropdown1.click();
		     
		     WebElement option1 =driver.findElement(By.xpath("//*[@id=\"account-section-container\"]/div[2]/ul/li/div/section/div[2]/span[1]/span/div/div/span/span/ul/li[4]/span"));
		     option1.click();
		     
		     WebElement ATB1=driver.findElement(By.linkText("Add to Basket"));
		     ATB1.click();
		     Thread.sleep(5000);
		     
		     WebElement Remove=driver.findElement(By.xpath("//*[@id=\"account-section-container\"]/div[2]/ul/li[1]/div/section/div[2]/a[1]"));
		     Remove.click();
		     
		//   Women Product Buying
		     WebElement go_women = driver.findElement(By.linkText("Women"));
		     go_women.click();
		     
		     Thread.sleep(2000);
		     
		     Actions a1 = new Actions(driver);
		     WebElement women = driver.findElement(By.linkText("Women"));
		     a1.moveToElement(women).perform();
		     
		     Thread.sleep(1000);
		     WebElement shirts = driver.findElement(By.linkText("Shirts"));
		     shirts.click();
		     
		     WebElement WSize=driver.findElement(By.xpath("//*[@id=\"filter-div\"]/div[2]/div[2]/div/div/button/span/span"));
		     WSize.click();
		     
		     WebElement WXL=driver.findElement(By.xpath("//*[@id=\"filter-div\"]/div[2]/div[2]/span/div/div/div/div[1]/span/span/input"));
		     WXL.click();
		     
		     WebElement WL=driver.findElement(By.xpath("//*[@id=\"filter-div\"]/div[2]/div[2]/span/div/div/div/div[1]/span/span/input"));
		     WL.click();
		   
		     WebElement WMin=driver.findElement(By.xpath("//*[@aria-label='minimum-input']"));
		     WMin.clear();
		     WMin.sendKeys("799");
		     
		     WebElement WMax=driver.findElement(By.xpath("//*[@aria-label='maximum-input']"));
		     WMax.clear();
		     WMax.sendKeys("1500");
		     
		     WebElement WSizeButt=driver.findElement(By.xpath("//*[@id=\"filter-div\"]/div[2]/div[2]/div/div/button/span/span"));
		     WSizeButt.click();

		     Thread.sleep(1000);
		     WebElement favs2 = driver.findElement(By.xpath("//button[contains(@class, 'favButtonOnProduct')]"));
		     favs2.click();
		     
		     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", favs2);
		     Thread.sleep(500);
		     ((JavascriptExecutor) driver).executeScript("arguments[0].click();", favs2);

		     WebElement favBtn2 = driver.findElement(By.xpath("//button[@aria-label='fav-icon']"));
		     favBtn2.click();
		     
		     WebElement dropdown2 = driver.findElement(By.xpath("//*[@id=\"account-section-container\"]/div[2]/ul/li[1]/div/section/div[2]/span[1]/span/span[1]/span"));
		     dropdown2.click();
		     
		     WebElement option2 =driver.findElement(By.xpath("//*[@id=\"account-section-container\"]/div[2]/ul/li[1]/div/section/div[2]/span[1]/span/div/div/span/span/ul/li[5]/span"));
		     option2.click();
		     
		     WebElement ATB2=driver.findElement(By.linkText("Add to Basket"));
		     ATB2.click();
		     Thread.sleep(5000);
		     
		     WebElement Remove1=driver.findElement(By.xpath("//*[@id=\"account-section-container\"]/div[2]/ul/li[1]/div/section/div[2]/a[1]"));
		     Remove1.click();
		     
		     
		     //Kids Product Buying
		     WebElement kids = driver.findElement(By.linkText("Kids"));
		     kids.click();
		     Thread.sleep(2000);
		     
		     Actions a2 = new Actions(driver);
		     WebElement kids1=driver.findElement(By.linkText("Kids"));
		     a2.moveToElement(kids1).perform();
		     
		     Thread.sleep(1000);
		     WebElement kshirts = driver.findElement(By.linkText("Shirts"));
		     kshirts.click();
		     
		     WebElement kSize=driver.findElement(By.xpath("//*[@id=\"filter-div\"]/div[2]/div[2]/div/div/button/span/span"));
		     kSize.click();
		     
		     WebElement ktwo=driver.findElement(By.xpath("//*[@id=\"filter-div\"]/div[2]/div[2]/span/div/div/div/div[1]/span/span/input"));
		     ktwo.click();
		     
		     WebElement kten=driver.findElement(By.xpath("//*[@id=\"filter-div\"]/div[2]/div[2]/span/div/div/div/div[2]/span/span/input"));
		     kten.click();
		   
		     
		     WebElement kMin=driver.findElement(By.xpath("//*[@aria-label='minimum-input']"));
		     kMin.clear();
		     kMin.sendKeys("799");
		     
		     WebElement kMax=driver.findElement(By.xpath("//*[@aria-label='maximum-input']"));
		     kMax.clear();
		     kMax.sendKeys("1500");
		     
		     WebElement kSizeButt=driver.findElement(By.xpath("//*[@id=\"filter-div\"]/div[2]/div[1]/div[2]/div/div[3]/button/span/span"));
		     kSizeButt.click();

		     Thread.sleep(1000);
		     WebElement kfavs2 = driver.findElement(By.xpath("//button[contains(@class, 'favButtonOnProduct')]"));
		     kfavs2.click();
		     
		     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", kfavs2);
		     Thread.sleep(500);
		     ((JavascriptExecutor) driver).executeScript("arguments[0].click();", kfavs2);

		     WebElement kfavBtn2 = driver.findElement(By.xpath("//button[@aria-label='fav-icon']"));
		     kfavBtn2.click();
		     
		     Thread.sleep(2000);
		     
		     WebElement dropdown3 = driver.findElement(By.xpath("/html/body/div[1]/main/div[1]/div/div/div[2]/ul/li/div/section/div[2]/span[1]/span/span[1]/span"));
		     dropdown3.click();
		     
		     WebElement option3 =driver.findElement(By.xpath("//*[@id=\"account-section-container\"]/div[2]/ul/li/div/section/div[2]/span[1]/span/div/div/span/span/ul/li[4]/span"));
		     option3.click();
		     
		     WebElement ATB3=driver.findElement(By.linkText("Add to Basket"));
		     ATB3.click();
		       
		     Thread.sleep(5000);
		     
		     WebElement Remove3=driver.findElement(By.xpath("//*[@id=\"account-section-container\"]/div[2]/ul/li[1]/div/section/div[2]/a[1]"));
		     Remove3.click();
		     
		     
		     // Checkout
		     
		     WebElement BasketIcon=driver.findElement(By.id("small-cart-opener-desktop"));
		     BasketIcon.click();
		     
		     WebElement checkout=driver.findElement(By.linkText(" Checkout Now "));
		     checkout.click();
		     
		     
		     
		     
		     
			}

		

		
		
	}
		

	


