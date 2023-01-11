package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Login;
import org.example.pages.Home;
import org.example.pages.Shoes;
import org.example.pages.PageObjectBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static Steps.RegistrationTestStep.email;
import static Steps.RegistrationTestStep.password;

public class FilterWithColorTestStep extends Hooks {

    Login loginPage;
    Home homePage;
    Shoes shoesPage;

    //user login to the application
    @Given("login to nop application")
    public void userInLoginPage() {
        initialization("Chrome");
        startApplication();
    }

    //user select subcategory and filter with specific color
    @When("select subcategory and filter with specific color")
    public void userSelectSubcategoryAndFilterWithSpecificColor() {
        loginPage=new Login(driver);
        homePage=new Home(driver);
        shoesPage=new Shoes(driver);
        loginPage.login(email,password);
        PageObjectBase.hoverWebElement(driver,homePage.apparelProductsTap());
        homePage.selectApparelProduct();
        shoesPage.filterShoes();
    }

    //filtered results should appear correctly
    @Then("filtered results should appear correctly")
    public void filteredResultsShouldAppearCorrectly() {
        List<WebElement> elements=driver.findElements(shoesPage.getAddToCardButton());
        Assert.assertNotEquals(elements.size(),0);
        tearDown();
    }
}
