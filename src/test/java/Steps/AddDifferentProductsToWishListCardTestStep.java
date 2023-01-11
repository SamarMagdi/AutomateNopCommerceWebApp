package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.*;
import org.example.pages.Login;
import org.testng.Assert;

import static Steps.RegistrationTestStep.email;
import static Steps.RegistrationTestStep.password;

public class AddDifferentProductsToWishListCardTestStep extends Hooks {
    Login loginPage;
    Home homePage;
    Shoes shoesPage;
    Notebook notebookPage;

    //user login correctly to the app
    @Given("login correctly to app")
    public void userInLoginPage() {
        initialization("Chrome");
        startApplication();
    }

    //user add one product from Notebooks in computer category to White List
    @When("add one product from Notebooks in computer category to Wish List")
    public void userAddOneProductFromNotebooksInComputerCategoryToShoppingCard() throws InterruptedException {
        loginPage=new Login(driver);
        homePage=new Home(driver);
        notebookPage=new Notebook(driver);
        loginPage.login(email,password);
        PageObjectBase.hoverWebElement(driver,homePage.ComputerProductsTap());
        homePage.selectComputerProduct();
        driver.findElements(notebookPage.getAddToCardButton()).get(0).click();
        Thread.sleep(4000);
        PageObjectBase.scrollWithSpecificSize(driver,0,400);
        notebookPage.clickAddToWhiteListButton();
        Thread.sleep(3000);
        Assert.assertEquals(notebookPage.getConfirmationMessage(),"The product has been added to your wishlist");
    }

    @And("add one product from Shoes in Apparel category to Wish List")
    public void userAddOneProductFromShoesInApparelCategoryToShoppingCard() throws InterruptedException {
        shoesPage=new Shoes(driver);
        PageObjectBase.hoverWebElement(driver,homePage.apparelProductsTap());
        homePage.selectApparelProduct();
        driver.findElements(shoesPage.getAddToCardButton()).get(0).click();
        Thread.sleep(3000);
        PageObjectBase.scrollWithSpecificSize(driver,0,400);
        shoesPage.selectShoesSize();
        PageObjectBase.scrollWithSpecificSize(driver,0,400);
        shoesPage.clickAddToWhiteListButton();
        Thread.sleep(3000);
        Assert.assertEquals(shoesPage.getConfirmationMessage(),"The product has been added to your wishlist");
    }

    //the selected two products should added correctly
    @Then("the selected two products should added correctly")
    public void theSelectedTwoProductsShouldAddedAndAppearCorrectlyInShoppingCard() {
        Assert.assertEquals(homePage.getWhiteListAmount(),"(3)");
        tearDown();
    }
}
