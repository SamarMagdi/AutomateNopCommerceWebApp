package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Login;
import org.example.pages.Home;
import org.example.pages.Shoes;
import org.example.pages.PageBase;
import org.testng.Assert;

import static Steps.Registration.email;
import static Steps.Registration.password;

public class SelectDifferentCategories extends Hooks {

    Login loginPage;
    Home homePage;
    Shoes shoesPage;

    //user login to the app
    @Given("user login to the app")
    public void userInLoginPage() {
        initialization("Chrome");
        startApplication();
    }

    //user select hover Computers categories and select Notebooks sub category
    @When("user select hover Computers categories and select Notebooks sub category")
    public void userSelectHoverComputersCategoriesAndSelectNotebooksSubCategory() {
        loginPage=new Login(driver);
        homePage=new Home(driver);
        shoesPage=new Shoes(driver);
        loginPage.login(email,password);
        PageBase.hoverWebElement(driver,homePage.ComputerProductsTap());
        homePage.selectComputerProduct();
    }

    @Then("Notebooks page should start correctly")
    public void notebooksPageShouldStartCorrectly() {
        Assert.assertEquals(homePage.getProductPageHeader(),"Notebooks");
    }

    @And("user select hover Apparel categories and select Shoes sub category")
    public void userSelectHoverApparelCategoriesAndSelectShoesSubCategory() {
        PageBase.hoverWebElement(driver,homePage.apparelProductsTap());
        homePage.selectApparelProduct();
    }

    //Shoes page should appear correctly
    @Then("Shoes page should appear correctly")
    public void shoesPageShouldAppearCorrectly() {
        Assert.assertEquals(homePage.getProductPageHeader(),"Shoes");
        tearDown();
    }
}
