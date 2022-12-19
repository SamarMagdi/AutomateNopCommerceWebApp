package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Login;
import org.example.pages.Home;
import org.example.pages.PageBase;
import org.testng.Assert;

import static Steps.Registration.email;
import static Steps.Registration.password;

public class HoverAndSelect extends Hooks {
    Login loginPage;
    Home homePage;
    @Given("user login to Application")
    public void userInLoginPage() {
        initialization("Chrome");
        startApplication();
    }

    @When("Hover over any category and select subcategory")
    public void hoverOverAnyCategoryAndSelectSubcategory() {
        loginPage=new Login(driver);
        homePage=new Home(driver);
        loginPage.login(email,password);
        PageBase.hoverWebElement(driver,homePage.ComputerProductsTap());
        homePage.selectComputerProduct();
    }

    @Then("the sub category page should appear correctly")
    public void theSubCategoryPageShouldAppearCorrectly() {
        Assert.assertEquals(homePage.getProductPageHeader(),"Notebooks");
        tearDown();
    }
}
