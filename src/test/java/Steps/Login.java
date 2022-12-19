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

	@Given("user is in login page")
	public void user_is_in_login_page() {
		initialization("Chrome");
		startApplication();
	}

	@When("user add valid username and password and click login button")
	public void user_add_valid_username_and_password() {

		loginPage = new org.example.pages.Login(driver);
		PageBase.scrollWithSpecificSize(driver,0,300);
		loginPage.login(email,password);
	}

	@Then("user navigate to home page")
	public void user_navigate_to_home_page() {
		Assert.assertTrue(driver.getPageSource().contains("Welcome to our store"));
		System.out.println(email);
		// extend report status
		test.log(LogStatus.PASS, "Login Successfully to Application");
		tearDown();
	}

//	@When("user add invalid username and password")
//	public void userEnterUsernameAndPassword(DataTable usercredentials) {
//		//Write the code to handle Data Table
//		List<String> data = usercredentials.row(0);
//		loginPage = new LoginPage(driver);

//		loginPage.userName.sendKeys(data.get(0));
//
//		loginPage.userPassword.sendKeys(data.get(1));
//	}

//	@Then("user will not navigate to home page")
//	public void userWillNotNavigateToHomePage() {
//		WebElement element = driver.findElement(By.xpath("//h3[@data-test='error']"));
//		Assert.assertEquals(element.getText().toString(), "Epic sadface: Username and password do not match any user in this service");
//	}
}
