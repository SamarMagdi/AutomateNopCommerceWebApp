package Steps;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.PageBase;
import org.testng.Assert;

public class Registration extends Hooks {

    org.example.pages.Registration registrationPage;
    public static String email;
    public static String password;

    //user is in main page
    @Given("user is in main page")
    public void userInMainPage() {
        initialization("Chrome");
        startApplication();
    }

    //user choose register tap
    @When("user choose register tap")
    public void userChooseRegisterTap() {
        registrationPage=new org.example.pages.Registration(driver);
        driver.findElement(registrationPage.registerTap).click();
    }

    @And("fill all data and click register button")
    public void fillAllDataAndClickRegisterButton() {
        email=PageBase.generateString(5)+"@yahoo.com";
        password=PageBase.generateString(5)+PageBase.generateInteger(100);
        registrationPage.registerNewUser(
                PageBase.generateString(5),
                PageBase.generateString(5),
                email,
                PageBase.generateString(5),
                password);
    }

    //user navigate to user page
    @Then("user navigate to user page")
    public void userNavigateToHomePage() {
        Assert.assertTrue(driver.getPageSource().contains("Your registration completed"));
        driver.findElement(registrationPage.continueButton).click();
        Assert.assertTrue(driver.getPageSource().contains("Welcome to our store"));
        // extend report status
        test.log(LogStatus.PASS, "Register Successfully to Application");
        tearDown();
    }
}
