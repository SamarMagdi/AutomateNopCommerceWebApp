package Steps;

import com.relevantcodes.extentreports.LogStatus;
import org.example.pages.PageBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

import static Steps.Registration.email;
import static Steps.Registration.password;

public class Login extends Hooks {

	org.example.pages.Login loginPage;

	//user is in login page
	@Given("user is in login page")
	public void user_is_in_login_page() {
		initialization("Chrome");
		startApplication();
	}

	//user add valid username and password and click login button
	@When("user add valid username and password and click login button")
	public void user_add_valid_username_and_password() {

		loginPage = new org.example.pages.Login(driver);
		PageBase.scrollWithSpecificSize(driver,0,300);
		loginPage.login(email,password);
	}

	//user navigate to home page
	@Then("user navigate to home page")
	public void user_navigate_to_home_page() {
		Assert.assertTrue(driver.getPageSource().contains("Welcome to our store"));
		System.out.println(email);
		// extend report status
		test.log(LogStatus.PASS, "Login Successfully to Application");
		tearDown();
	}

}
