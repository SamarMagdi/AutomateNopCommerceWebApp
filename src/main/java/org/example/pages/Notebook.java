package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;


public class Notebook {
    WebDriver driver;

    public Notebook(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*The purpose of a product description is to supply customers with important information about the features and key benefits of the product so they're compelled to buy.*/

    final private By addToCard = RelativeLocator.with(By.xpath("//button[text()='Add to cart']"));
    final private By addToWhitList = RelativeLocator.with(By.xpath("//button[text()='Add to wishlist']"));
    final private By addToCompareList = RelativeLocator.with(By.xpath("//button[text()='Add to compare list']"));
    final private By confirmationMessage = RelativeLocator.with(By.xpath("//p[@class='content']"));
    final private By addWhiteListButton = RelativeLocator.with(By.xpath("(//button[text()='Add to wishlist'])[1]"));

    public void clickAddToWhiteListButton() {
        driver.findElement(addWhiteListButton).click();
    }

    public String getConfirmationMessage() {
        return driver.findElement(confirmationMessage).getText();
    }

    public By getAddToCardButton() {
        return addToCard;
    }

    public By getAddToWhitList() {
        return addToWhitList;
    }

    public By getAddToCompareList() {
        return addToCompareList;
    }
}
