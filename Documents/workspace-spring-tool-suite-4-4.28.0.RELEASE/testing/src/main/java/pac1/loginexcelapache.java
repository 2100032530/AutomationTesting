package pac1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

public class loginexcelapache {
	WebDriver driver;
  @Test(dataProvider = "signin")
  public void f(String email) throws IOException {
	  WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
	  
	  driver.findElement(By.id("email_create")).sendKeys(email);

	  driver.findElement(By.name("SubmitCreate")).click();

	  
  }
  @Test(dataProvider = "register")
  public void f1(String title,String fname,String lname,String pwd,String days) throws IOException {

	  
	  if(title.equalsIgnoreCase("Mr.")) {
		  driver.findElement(By.id("uniform-id_gender1")).click();
	  }
	  
	  if(title.equalsIgnoreCase("Mrs.")) {
		  driver.findElement(By.id("uniform-id_gender2")).click();
	  }
	  driver.findElement(By.id("customer_firstname")).sendKeys(fname);
	  driver.findElement(By.id("customer_lastname")).sendKeys(lname);
	  driver.findElement(By.id("passwd")).sendKeys(pwd);
	  Select s= new Select(driver.findElement(By.id("days")));
	  s.selectByIndex(Integer.parseInt(days));

	  
  }

  @DataProvider
  public String[][] signin() throws IOException {
	  String data[][]=new String[1][1];
	  String projectpath=System.getProperty("user.dir");
	  File f1=new File(projectpath + "\\signindata.xlsx");
	  FileInputStream is=new FileInputStream(f1);
	  XSSFWorkbook wbook=new XSSFWorkbook(is);
	  XSSFSheet sheet=wbook.getSheetAt(0);
	  int row_count=sheet.getPhysicalNumberOfRows();
	  System.out.println(row_count);
	  for(int i=0;i<row_count;i++) {
		  data[i][0]=sheet.getRow(i).getCell(0).getStringCellValue();
	  }
	  
	return data;

  
}
  
  @DataProvider
  public String[][] register() throws IOException {
	  String data[][]=new String[1][5];
	  String projectpath=System.getProperty("user.dir");
	  File f1=new File(projectpath + "\\signindata.xlsx");
	  FileInputStream is=new FileInputStream(f1);
	  XSSFWorkbook wbook=new XSSFWorkbook(is);
	  XSSFSheet sheet=wbook.getSheetAt(1);
	  int row_count=sheet.getPhysicalNumberOfRows();
	  System.out.println(row_count);
	  for(int i=0;i<row_count;i++) {
		  data[i][0]=sheet.getRow(i).getCell(0).getStringCellValue();
		  data[i][1]=sheet.getRow(i).getCell(1).getStringCellValue();
		  data[i][2]=sheet.getRow(i).getCell(2).getStringCellValue();
		  data[i][3]=sheet.getRow(i).getCell(3).getStringCellValue();
		  data[i][4]=sheet.getRow(i).getCell(4).getStringCellValue();
	  }
	  
	return data;

  
}
  
}
