package Steps;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Login;
import org.testng.Assert;

import static Steps.RegistrationTestStep.email;

public class ResetPasswordTestStep extends Hooks {

    Login loginPage;

    //user is in login page and forget password
    @Given("user choose forget password")
    public void userInLoginPage() {
        initialization("Chrome");
        startApplication();
    }

    //user choose forget password link and add his email
    @When("fill email and click recovery button")
    public void userChooseForgetPasswordLinkAndAddHisEmail() {
        loginPage=new Login(driver);
        driver.findElement(loginPage.loginTap).click();
        loginPage.setPassword(email);
    }

    //Confirmation message should appear to user to check mail
    @Then("Confirmation message should appear")
    public void confirmationMessageShouldAppearToUserToCheckMail() {
        Assert.assertEquals(loginPage.getRecoverPasswordMessage(),"Email with instructions has been sent to you.");
        // extend report status
        test.log(LogStatus.PASS, "Password Reset Successfully");
        tearDown();
    }
}
