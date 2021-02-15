package stepDefinitions;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class StepDefinitions extends base {

	@Given("^User is on Home page$")
	public void User_is_on_Home_page() {
		System.out.println("User successfully on home page");
		
	}
	
	@When("^User logs in application with credentials username\"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_logs_in_application_with_credentials_usernamesomething_and_password_something(String strArg1, String strArg2) throws Throwable {
        System.out.println(strArg1);
        System.out.println(strArg2);
    }
	
	@Then("^User should land on welcome page$")
	public void User_is_on_Welcome_page() {
		System.out.println("User successfully landed on welcomw page");
		
	}
	
	 @And("^Card details are displayed \"([^\"]*)\"$")
	    public void card_details_are_displayed_something(String strArg1) throws Throwable {
	        System.out.println(strArg1);
	    }

	 @Given("^Initialize driver$")
	    public void initialize_driver() throws Throwable {
		 System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Drivers\\Chrome\\87\\chromedriver.exe");
			
			driver = new ChromeDriver();
	    }
	 

	 @Given("^Navigate to \"([^\"]*)\"  site$")
	    public void navigate_to_something_site(String strArg1) throws Throwable {
	        
	    	driver.get(strArg1);
	    }
	    
	 @Given("^Click on SignIn CTA and Land on Sign In page$")
	    public void click_on_signin_cta_and_land_on_sign_in_page() throws Throwable {
	    	LandingPage lp = new LandingPage(driver);
			lp.getSignIn().click();
	        
	    }

    
	    @When("^Enter Credentials (.+) and (.+)$")
	    public void enter_credentials_and(String username, String password) throws Throwable {
	    	LoginPage logPage = new LoginPage(driver);
	    	logPage.Email().sendKeys(username);
	    	logPage.Password().sendKeys(password);
	    	logPage.LoginButton().click();
	    }
	   
	  
	    @Then("^Verify text present$")
	    public void verify_text_present() throws Throwable {
	     	LoginPage logPage = new LoginPage(driver);
	     	System.out.println(logPage.Email().isDisplayed());

	        
	    }


	    @And("^close the browser$")
	    public void close_the_browser() throws Throwable {
	        driver.close();
	    }



	}
	



