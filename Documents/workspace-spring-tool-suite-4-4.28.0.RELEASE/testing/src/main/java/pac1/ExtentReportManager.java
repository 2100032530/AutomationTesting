package pac1;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	private static ExtentReports extent;
	
	public static ExtentReports getReportInstance() {
		if(extent==null) {
			String reportPath = System.getProperty("user.dir") + "//TestReport.html";
			ExtentSparkReporter spark=new ExtentSparkReporter(reportPath);
			spark.config().setDocumentTitle("Automation Report");
			spark.config().setReportName("Selenium Result tests");
			extent=new ExtentReports();
			extent.attachReporter(spark);
			extent.setSystemInfo("Tester", "Sowmya");

		}
		return extent;
	}

}
