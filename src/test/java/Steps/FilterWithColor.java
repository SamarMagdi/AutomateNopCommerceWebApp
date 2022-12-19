package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Login;
import org.example.pages.Home;
import org.example.pages.Shoes;
import org.example.pages.PageBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static Steps.Registration.email;
import static Steps.Registration.password;

public class FilterWithColor extends Hooks {

    Login loginPage;
    Home homePage;
    Shoes shoesPage;
    @Given("user login to the application")
    public void userInLoginPage() {
        initialization("Chrome");
        startApplication();
    }


    @When("user select subcategory and filter with specific color")
    public void userSelectSubcategoryAndFilterWithSpecificColor() {
        loginPage=new Login(driver);
        homePage=new Home(driver);
        shoesPage=new Shoes(driver);
        loginPage.login(email,password);
        PageBase.hoverWebElement(driver,homePage.apparelProductsTap());
        homePage.selectApparelProduct();
        shoesPage.filterShoes();
    }

    @Then("filtered results should appear correctly")
    public void filteredResultsShouldAppearCorrectly() {
        List<WebElement> elements=driver.findElements(shoesPage.getAddToCardButton());
        Assert.assertNotEquals(elements.size(),0);
        tearDown();
    }
}
