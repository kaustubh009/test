package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver= driver;
	}

	By email = By.cssSelector("input[id='user_email'");
	By password = By.cssSelector("input[id='user_password']");
	By login = By.cssSelector("input[name='commit']");

	public WebElement Email() {

		return driver.findElement(email);

	}
	
	public WebElement Password() {

		return driver.findElement(password);

	}
	
	public WebElement LoginButton() {

		return driver.findElement(login);

	}

}
