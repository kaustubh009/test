package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver= driver;
	}

	By signIn = By.cssSelector("a[href*='sign_in']");
	By featured = By.cssSelector("div.text-center>h2");
	By rightNav = By.cssSelector("ul[class*='navbar-right']>li>a");
	
	public WebElement getSignIn() {

		return driver.findElement(signIn);

	}
	
	public WebElement featuredText() {

		return driver.findElement(featured);

	}
	
	public WebElement getNavBar() {

		return driver.findElement(rightNav);

	}

}
