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

public class HomePageTest extends base {
	public WebDriver driver;
	public static Logger log = (Logger) LogManager.getLogger(HomePageTest.class.getName());

	@BeforeTest

	public void initialize() throws IOException {

		driver = initializeDriver();
		log.info("Driver Initialized");
		log.debug("debug message");
		log.info("Info message");
		log.error("error message");
		log.fatal("fatal message");
		

	}

	@Test(dataProvider = "getData")

	public void baseNavigation(String Username, String Password) throws IOException {

		driver.get(prop.getProperty("URL"));
		log.info("Web Site launched");
		LandingPage lp = new LandingPage(driver);
		lp.getSignIn().click();
		log.info("Click on Sign in");
		LoginPage logPage = new LoginPage(driver);
//		logPage.LoginButton().click();
		logPage.Email().sendKeys(Username);
		log.info("User Name entered");
		logPage.Password().sendKeys(Password);
		log.info("Password entered");
//		logPage.LoginButton().click();

//		driver.quit();
		Assert.assertTrue(false);
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "Kaustubhsingh@gmail.com";
		data[0][1] = "123";
		data[1][0] = "ShahidAfridi@gmail.com";
		data[1][1] = "Shahid";

		return data;

	}
}