package pac1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageFactory_Repo {
	
	WebDriver driver;
	
	@FindBy(name="username")
	WebElement uname;
	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit;
	
	public void enterUsername() {
		uname.sendKeys("Admin");
	}
	
	public void enterpassword() {
		pwd.sendKeys("admin123");
	}
	
	public void clicksubmit() {
		submit.click();
	}
	
	
	

}
