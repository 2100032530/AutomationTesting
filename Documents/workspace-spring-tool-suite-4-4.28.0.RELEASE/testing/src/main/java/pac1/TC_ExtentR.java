package pac1;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class TC_ExtentR extends BaseTest{
	
	@Test
    public void testGoogleSearch() {
        test = extent.createTest("Google Search Test");
        driver.get("https://www.google.com");
        test.log(Status.PASS, "Opened Google homepage");
        
    }

    @Test
    public void testBingSearch() {
        test = extent.createTest("Bing Search Test");
        driver.get("https://www.bing.com");
        test.log(Status.PASS, "Opened Bing homepage");
    }
    
    

}
