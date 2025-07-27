package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login_PageObjects {
	WebDriver driver;
	By login = By.xpath("//a[text()='Login']");
	By icon=By.xpath("//img[@title=\"Flipkart\"]");
	By phone=By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[1]/input");
	By otp=By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[3]/button");
	By verify=By.xpath("//button[text()='Verify']");
	By account=By.xpath("//span[text()='Account']");
	By search=By.xpath("//input[@name='q']");
	By mobile=By.xpath("//a[text()='Mobiles & Accessories']");
	
	By minPrice=By.xpath("//select[option[text()='Min']]");
	By maxPrice=By.xpath("//select[option[text()='₹30000+']]");
	By maxPrice1=By.xpath("//select[option[text()='250+']]");
	By oppo=By.xpath("//div[text()='OPPO']");
	By icon1=By.cssSelector("#container > div > div.nt6sNV.JxFEK3._48O0EI > div > div:nth-child(2) > div:nth-child(2) > div > div > div > a > div.Otbq5D > div.oUss6M.ssUU08 > div > svg > path");
	By plus=By.xpath("//img[@title='Flipkart']");
	By fashion=By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div/div/div/div/div/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/div[1]/div/div/span/span[1]");
	By kids=By.linkText("Kids");
	By clothes=By.linkText("Boys & Girls Tshirts");
	By brand=By.xpath("//div[text()='Brand']");
	By allen=By.xpath("//div[text()='Allen Solly']");
	By icon2=By.cssSelector("#container > div > div.nt6sNV.JxFEK3._48O0EI > div > div:nth-child(2) > div:nth-child(2) > div > div:nth-child(1) > div > a > div:nth-child(1) > div > div.wvIX4U > div > img");
	By cart=By.xpath("//button[text()='Add to cart']");
	By add=By.xpath("//button[text()='+']");
	By minus=By.xpath("//button[text()='–']");
	By order=By.xpath("//button[.//span[text()='Place Order']]");
	By deliver=By.xpath("//button[text()='Deliver Here']");
	By checkout=By.xpath("//button[text()='CONTINUE']");
	
	public Login_PageObjects(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement findLogin() {
		return driver.findElement(login);
	}
	
	public WebElement findWebPage() {
		return driver.findElement(icon);
	}
	
	public void clickLogin() {
		driver.findElement(login).click();
	}
	
	public WebElement findPhone() {
		return driver.findElement(phone);
	}
	
	public void clickOtp() {
		driver.findElement(otp).click();
	}
	
	public WebElement account() {
		return driver.findElement(account);
	}
	
	public WebElement verify() {
		return driver.findElement(verify);
	}
	public WebElement checkSearch() {
		return driver.findElement(search);
	}
	public WebElement checkElementSearch() {
		return driver.findElement(mobile);
	}
	
	public WebElement setMinPrice() {
		return driver.findElement(minPrice);
	}
	
	public WebElement setMaxPrice() {
		return driver.findElement(maxPrice);
	}
	
	public WebElement setMaxPrice1() {
		return driver.findElement(maxPrice1);
	}
	
	public WebElement setBrand() {
		return driver.findElement(oppo);
	}
	public WebElement clickiocn() {
		return driver.findElement(icon1);
	}
	public void clickPlus() {
		driver.findElement(plus).click();
	}
	public WebElement fashion() {
		return driver.findElement(fashion);
	}
	public WebElement kids() {
		return driver.findElement(kids);
	}
	public void clothes() {
		 driver.findElement(clothes).click();
	}
	public WebElement brand() {
		return driver.findElement(brand);
	}
	public void allen() {
		 driver.findElement(allen).click();
	}
	public WebElement shirt() {
		return driver.findElement(icon2);
	}
	public WebElement  cart() {
		return driver.findElement(cart);
	}
	public WebElement add() {
		return driver.findElement(add);
	}
	public WebElement minus() {
		return driver.findElement(minus);
	}
	public WebElement order() {
		return driver.findElement(order);
	}
	public WebElement deliver() {
		return driver.findElement(deliver);
	}
	public WebElement checkout() {
		return driver.findElement(checkout);
	}
}
