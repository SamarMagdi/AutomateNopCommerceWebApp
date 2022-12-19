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

public class AddDifferentProductsToShoppingCard extends Hooks {
    Login loginPage;
    Home homePage;
    Shoes shoesPage;
    Notebook notebookPage;
    @Given("user login correctly")
    public void userInLoginPage() {
        initialization("Chrome");
        startApplication();
    }

    @When("user add one product from Notebooks in computer category to shopping card")
    public void userAddOneProductFromNotebooksInComputerCategoryToShoppingCard() throws InterruptedException {
        loginPage=new Login(driver);
        homePage=new Home(driver);
        notebookPage=new Notebook(driver);
        loginPage.login(email,password);
        PageBase.hoverWebElement(driver,homePage.ComputerProductsTap());
        homePage.selectComputerProduct();
        driver.findElements(notebookPage.getAddToCardButton()).get(0).click();
        Thread.sleep(4000);
        PageBase.scrollWithSpecificSize(driver,0,700);
        driver.findElements(notebookPage.getAddToCardButton()).get(0).click();
        Thread.sleep(3000);
        Assert.assertEquals(notebookPage.getConfirmationMessage(),"The product has been added to your shopping cart");
    }

    @And("user add one product from Shoes in Apparel category to shopping card")
    public void userAddOneProductFromShoesInApparelCategoryToShoppingCard() throws InterruptedException {
        shoesPage=new Shoes(driver);
        PageBase.hoverWebElement(driver,homePage.apparelProductsTap());
        homePage.selectApparelProduct();
        driver.findElements(shoesPage.getAddToCardButton()).get(0).click();
        Thread.sleep(3000);
        PageBase.scrollWithSpecificSize(driver,0,400);
        shoesPage.selectShoesSize();
        PageBase.scrollWithSpecificSize(driver,0,400);
        driver.findElements(shoesPage.getAddToCardButton()).get(0).click();
        Thread.sleep(3000);
        Assert.assertEquals(shoesPage.getConfirmationMessage(),"The product has been added to your shopping cart");
    }

    @Then("the selected two products should added and appear correctly in shopping card")
    public void theSelectedTwoProductsShouldAddedAndAppearCorrectlyInShoppingCard() {
        Assert.assertEquals(homePage.getShoppingCardAmount(),"(3)");
        tearDown();
    }
}
