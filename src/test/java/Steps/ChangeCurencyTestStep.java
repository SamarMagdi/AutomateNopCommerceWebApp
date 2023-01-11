package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Login;
import org.example.pages.Home;
import org.testng.Assert;

import static Steps.RegistrationTestStep.email;
import static Steps.RegistrationTestStep.password;

public class ChangeCurencyTestStep extends Hooks {

    Login loginPage;
    Home homePage;
    String firstOption;

    //user login to nop commerce
    @Given("login to an application")
    public void userInLoginPage() {
        initialization("Chrome");
        startApplication();
    }

    //change current currency to another
    @When("change current currency to another")
    public void changeCurrentCurrencyToAnother() {
        loginPage=new Login(driver);
        homePage=new Home(driver);
        loginPage.login(email,password);
        firstOption=homePage.getFirstCurrency();
        homePage.changeCurrency();
    }

    //currency should changed correctly
    @Then("currency should change correctly")
    public void currencyShouldChangedCorrectly() {
        Assert.assertNotEquals(firstOption,homePage.getFirstCurrency());
        tearDown();
    }
}
