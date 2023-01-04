package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.*;
import org.example.pages.Login;
import org.testng.Assert;

import static Steps.Registration.email;
import static Steps.Registration.password;

public class AddDifferentProductsToCompareListCard extends Hooks {
    Login loginPage;
    Home homePage;
    Shoes shoesPage;
    Notebook notebookPage;

    // user login successfully
    @Given("user login Successfully")
    public void userInLoginPage() {
        initialization("Chrome");
        startApplication();
    }

    //user add one product from Notebooks in computer category to Compare List
    @When("user add one product from Notebooks in computer category to Compare List")
    public void userAddOneProductFromNotebooksInComputerCategoryToShoppingCard() throws InterruptedException {
        loginPage=new Login(driver);
        homePage=new Home(driver);
        notebookPage=new Notebook(driver);
        loginPage.login(email,password);
        PageBase.hoverWebElement(driver,homePage.ComputerProductsTap());
        homePage.selectComputerProduct();
        driver.findElements(notebookPage.getAddToCompareList()).get(0).click();
        Thread.sleep(3000);
        Assert.assertEquals(notebookPage.getConfirmationMessage(),"The product has been added to your product comparison");
    }

    @And("user add one product from Shoes in Apparel category to Compare List")
    public void userAddOneProductFromShoesInApparelCategoryToShoppingCard() throws InterruptedException {
        shoesPage=new Shoes(driver);
        PageBase.hoverWebElement(driver,homePage.apparelProductsTap());
        homePage.selectApparelProduct();
        driver.findElements(shoesPage.getAddToCompareList()).get(0).click();
        Thread.sleep(3000);
        Assert.assertEquals(shoesPage.getConfirmationMessage(),"The product has been added to your product comparison");
    }

    //the selected two products should added and appear correctly
    @Then("the selected two products should added and appear correctly")
    public void theSelectedTwoProductsShouldAddedAndAppearCorrectlyInShoppingCard() {
        Assert.assertEquals(homePage.getShoppingCardAmount(),"(3)");
        Assert.assertEquals(homePage.getWhiteListAmount(),"(3)");
        tearDown();
    }
}
