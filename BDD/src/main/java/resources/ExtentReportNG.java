package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentTest;

public class ExtentReportNG {
	static ExtentReports extent;
	
	public static ExtentReports ReportConfig() {
		String path = System.getProperty("user.dir")+"\\reports\\index.html";	
		ExtentSparkReporter spark  = new ExtentSparkReporter(path);
		spark.config().setReportName("Kaustubh Framework Report");
		spark.config().setDocumentTitle("The Framework ");
		
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Tester", "Kaustubh Ji Singh");	
		return extent;
	}

	
	
}
