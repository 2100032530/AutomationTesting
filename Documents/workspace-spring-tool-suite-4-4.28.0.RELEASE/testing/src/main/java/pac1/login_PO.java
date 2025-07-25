package pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login_PO {
	WebDriver driver;
	By uname=By.name("username");
	By pwd=By.name("password");
	By submit = By.xpath("//button[@type='submit']");
    
	public login_PO(WebDriver driver) {
		this.driver=driver;
		
	}

	public void enterUsername(String username) {
		driver.findElement(uname).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(pwd).sendKeys(password);
	}
	
	public void submit() {
		driver.findElement(submit).click();
	}

}
