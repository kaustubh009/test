package Framework.Kaustubh;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportNG;
import resources.base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

public class Listeners extends base implements  ITestListener {
	
	ExtentReports extent = ExtentReportNG.ReportConfig();
	ExtentTest test;
	ThreadLocal<ExtentTest> localExtent = new  ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result)  {
		// TODO Auto-generated method stub
		
		test = extent.createTest(result.getMethod().getMethodName());
		localExtent.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		localExtent.get().log(Status.PASS, "Test Passed successfully");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		localExtent.get().fail(result.getThrowable());
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		try {
			localExtent.get().addScreenCaptureFromPath(getScreenshotPath(testMethodName,driver), testMethodName);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}
	
	
	
}
