package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class base {
	public static Logger log = (Logger) LogManager.getLogger(base.class.getName());

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		 prop = new Properties();
//		 System.getProperty("user.dir")
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Data.properties");
		prop.load(fis);
		// browser from MVN command - mvn test -Dbrowser=chrome
		String bs = System.getProperty("browser");
//		Browser from prop file 
//		String bs = prop.getProperty("browser");
		
		System.out.println(bs);

		if (bs.contains("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Drivers\\Chrome\\87\\chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			if (bs.contains("headless")) {
			options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			
//			normal chrome execution (Headed)
//			driver = new ChromeDriver();

		}

		else if (bs.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Drivers\\FF\\geckodriver.exe");
			driver = new FirefoxDriver();

		}

		else if (bs.equalsIgnoreCase("IE")) {

			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Drivers\\IE\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		return driver;

	}
	
	public String getScreenshotPath(String testcaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\ScreenShots\\"+testcaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		
		return destinationFile;
	}

}
