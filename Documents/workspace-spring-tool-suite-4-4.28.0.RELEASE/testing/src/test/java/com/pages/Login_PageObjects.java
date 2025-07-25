package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_PageObjects {
	WebDriver driver;
	By login = By.xpath("//a[text()='Login']");
	By icon=By.xpath("//img[@title=\"Flipkart\"]");
	By phone=By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[1]/input");
	By otp=By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[3]/button");
	By account=By.xpath("//span[text()='Account']");
	
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

}
