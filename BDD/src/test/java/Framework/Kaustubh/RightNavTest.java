package Framework.Kaustubh;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class RightNavTest extends base {
	public WebDriver driver;
	public static Logger log = (Logger) LogManager.getLogger(HomePageTest.class.getName());

	@BeforeTest

	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("URL"));

	}

	@Test

	public void validateFeaturedText() throws IOException {

		LandingPage lp = new LandingPage(driver);
		Assert.assertEquals(lp.getNavBar().isDisplayed(), true);

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

//		@DataProvider		
//		public Object[][] getData() {
//		Object[][] data = new Object[1][1];
//		data[0][0] = "FEATURED COURSES";
//		
//		
//		return data;
//		
//	
//
//}
}