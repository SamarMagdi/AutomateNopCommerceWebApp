package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.*;
import org.example.pages.Login;

import java.io.IOException;

import static Steps.RegistrationTestStep.email;
import static Steps.RegistrationTestStep.password;

public class CreateSuccessfulOrderTestStep extends Hooks {

    Login loginPage;
    Home homePage;
    CheckOut checkOutPage;

    //user login Successfully to Nop Commerce App
    @Given("login Successfully to Application")
    public void userInLoginPage() {
        initialization("Chrome");
        startApplication();
    }

    //user click go to card button and complete checkout
    @When("click go to card button and complete checkout")
    public void userClickGoToCardButtonAndCompleteCheckout() throws InterruptedException {
        loginPage=new Login(driver);
        homePage=new Home(driver);
        checkOutPage=new CheckOut(driver);
        loginPage.login(email,password);
        PageObjectBase.hoverWebElement(driver,homePage.getShoppingCard());
        homePage.clickGoToCardButton();
        checkOutPage.checkTermsOfService();
        checkOutPage.ClickCheckoutButton();
        // fill billing address form
        checkOutPage.fillBillingAddress();
        Thread.sleep(2000);
        // choose shipping method
        checkOutPage.chooseShippingMethod();
        Thread.sleep(2000);
        // choose payment method
        checkOutPage.choosePaymentMethod();
        Thread.sleep(2000);
        // fill payment information
        checkOutPage.fillPaymentInformation();
        Thread.sleep(2000);
        // complete payment
        checkOutPage.confirmPayment();
    }

    //order should created successfully
    @Then("order should be created successfully")
    public void orderShouldCreatedSuccessfully() throws IOException {
        homePage.logout();
        tearDown();
        PageObjectBase.startHtmlReport(System.getProperty("user.dir")+"/target/HtmlReports","report.html");
    }
}
