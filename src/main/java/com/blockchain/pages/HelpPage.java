package com.blockchain.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HelpPage extends BasePage {

    @FindBy(xpath = "//*[@data-e2e='needHelpBack']")
    WebElement btnHelpBack;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[3]/div/div[1]/div[3]/div[2]/div[1]")
    WebElement forgotPasswordLink;


    public HelpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void exists() {
        waitForVisibility(btnHelpBack);
        Assert.assertTrue(btnHelpBack.isDisplayed());
        Assert.assertTrue(forgotPasswordLink.isDisplayed());
    }

}
