package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Login;
import org.example.pages.Home;
import org.example.pages.PageObjectBase;
import org.testng.Assert;

import static Steps.RegistrationTestStep.email;
import static Steps.RegistrationTestStep.password;

public class HoverAndSelectTestStep extends Hooks {
    Login loginPage;
    Home homePage;

    //user login to Application
    @Given("login to Application")
    public void userInLoginPage() {
        initialization("Chrome");
        startApplication();
    }

    //Hover over any category and select subcategory
    @When("Hover over any category and select subcategory")
    public void hoverOverAnyCategoryAndSelectSubcategory() {
        loginPage=new Login(driver);
        homePage=new Home(driver);
        loginPage.login(email,password);
        PageObjectBase.hoverWebElement(driver,homePage.ComputerProductsTap());
        homePage.selectComputerProduct();
    }

    //the sub category page should appear correctly
    @Then("sub category page should appear correctly")
    public void theSubCategoryPageShouldAppearCorrectly() {
        Assert.assertEquals(homePage.getProductPageHeader(),"Notebooks");
        tearDown();
    }
}
