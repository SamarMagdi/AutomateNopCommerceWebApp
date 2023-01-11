package Steps;

import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Login;
import org.example.pages.Home;

import static Steps.RegistrationTestStep.email;
import static Steps.RegistrationTestStep.password;

public class CheckSearchTestStep extends Hooks {

    Login loginPage;
    Home homePage;

    //user login to nop commerce web application
    @Given("login to web application")
    public void userInLoginPage() {
        initialization("Chrome");
        startApplication();
    }

    //search for product
    @When("search for product")
    public void searchForProduct() {
        loginPage=new Login(driver);
        homePage=new Home(driver);
        loginPage.login(email,password);
        homePage.searchProducts();

    }

    //results should appear correctly
    @Then("results should appear correctly")
    public void resultsShouldAppearCorrectly(){
        homePage.checkSearchResult();
        // extend report status
        test.log(LogStatus.PASS, "Searching Work Correctly");
        tearDown();
//        PageBase.startHtmlReport(System.getProperty("user.dir")+"/target/HtmlReports","report.html");
    }
}
