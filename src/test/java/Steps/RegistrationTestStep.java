package Steps;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.PageObjectBase;
import org.testng.Assert;

public class RegistrationTestStep extends Hooks {

    org.example.pages.Registration registrationPage;
    public static String email;
    public static String password;

    //user is in main page
    @Given("user is in main page")
    public void userInMainPage() {
        initialization("Chrome");
        startApplication();
    }

    //choose register tap
    @When("choose register tap")
    public void userChooseRegisterTap() {
        registrationPage=new org.example.pages.Registration(driver);
        driver.findElement(registrationPage.registerTap).click();
    }

    @And("fill all data")
    public void fillAllDataAndClickRegisterButton() {
        email= PageObjectBase.generateString(5)+"@yahoo.com";
        password= PageObjectBase.generateString(5)+ PageObjectBase.generateInteger(100);
        registrationPage.registerNewUser(
                PageObjectBase.generateString(5),
                PageObjectBase.generateString(5),
                email,
                PageObjectBase.generateString(5),
                password);
    }

    //user navigate to user page
    @Then("navigate to user page")
    public void userNavigateToHomePage() {
        Assert.assertTrue(driver.getPageSource().contains("Your registration completed"));
        driver.findElement(registrationPage.continueButton).click();
        Assert.assertTrue(driver.getPageSource().contains("Welcome to our store"));
        // extend report status
        test.log(LogStatus.PASS, "Register Successfully to Application");
        tearDown();
    }
}
