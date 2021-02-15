package Framework.Kaustubh;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class featureTextTest extends base {
	public WebDriver driver;
	public static Logger log = (Logger) LogManager.getLogger(featureTextTest.class.getName());
	
	@BeforeTest
		
	public void initialize() throws IOException {
		
		driver = initializeDriver();
		log.info("Driver Initialized");
		driver.get(prop.getProperty("URL"));
		log.info("Web Site Launched");
		log.error("error message");
		log.fatal("fatal message");
		log.info("info info info");
		log.error("Kaustubh");
		
	}
	
	@Test(dataProvider = "getData")
	public void validateFeaturedText(String text) throws IOException {

		
		LandingPage lp = new LandingPage(driver);
//		lp.getSignIn().click();
		String ft = lp.featuredText().getText();
		log.info("Text Retrieved");
		System.out.println(text);
		System.out.println(ft);
		log.info("Printed Text");
		Assert.assertEquals(text, ft);
		log.info("Successfully validated the featured text");
		

	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	
	
		@DataProvider		
		public Object[][] getData() {
		Object[][] data = new Object[1][1];
		data[0][0] = "FEATURED COURSES1";
		
		
		return data;
		
	

}
}