package pac1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginExcelData {
	String projectPath = System.getProperty("user.dir");
	
  @Test(dataProvider = "logindata")
  public void f(String username,String password) throws IOException {
	  Properties prob=new Properties();
	  File f1=new File(projectPath+"//loginexceldata.properties");
	  FileInputStream fis = new FileInputStream(f1);
	  prob.load(fis);
	  String url=prob.getProperty("url");
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  driver.get(url);
	  
	  driver.findElement(By.name("username")).sendKeys(username);
	  driver.findElement(By.name("password")).sendKeys(password);
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  
	  driver.quit();
	  
  }
  
  @DataProvider
  public String[][] logindata() throws IOException{
	  String data[][]=new String[1][2];
	  File f1=new File(projectPath+"\\signindata.xlsx");
	  FileInputStream fis = new FileInputStream(f1);
	  XSSFWorkbook wbook= new XSSFWorkbook(fis);
	  XSSFSheet sheet=wbook.getSheetAt(0);
	  int row_count=sheet.getPhysicalNumberOfRows();
	  System.out.println(row_count);
	  
	  for(int i=0;i<row_count;i++) {
		  data[i][0]=sheet.getRow(i).getCell(0).getStringCellValue();
		  data[i][1]=sheet.getRow(i).getCell(1).getStringCellValue();  
	  }
	  return data;
	  
	  
  }
}
