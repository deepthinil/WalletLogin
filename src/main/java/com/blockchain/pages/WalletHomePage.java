package com.blockchain.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WalletHomePage extends BasePage {

    @FindBy(xpath = "//*[@data-e2e='page-home']")
    WebElement pageHome;

    @FindBy(xpath = "//*[@data-e2e='sendButton']")
    WebElement btnSend;

    @FindBy(xpath = "//*[@data-e2e='receiveButton']")
    WebElement btnReceive;

    @FindBy(xpath = "//*[@data-e2e='settingsLink']")
    WebElement myAccountLink;

    @FindBy(xpath = "//*[@data-e2e='logoutLink']")
    WebElement logoutLink;

    @FindBy(xpath = "//*[@data-e2e='completeProfileCloseModalIcon']")
    WebElement completeProfileCloseModalIcon;

    @FindBy(xpath = "//*[@data-e2e='completeProfileButtonVerifyId']")
    WebElement btnCompleteProfileComplete;

    @FindBy(xpath = "//*[@data-e2e='linkBankContinue']")
    WebElement newLegalEntity;

    public WalletHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WalletHomePage exists() {
        waitForVisibility(pageHome);
        Assert.assertTrue(pageHome.isDisplayed());
        Assert.assertTrue(btnSend.isDisplayed());
        Assert.assertTrue(btnReceive.isDisplayed());
        return this;
    }

    public void signOutFromTheAccount() {
        waitForVisibility(completeProfileCloseModalIcon);
        Assert.assertTrue(completeProfileCloseModalIcon.isDisplayed());
        if (completeProfileCloseModalIcon.isDisplayed() == true) {
            completeProfileCloseModalIcon.click();
        }
        myAccountLink.click();
        waitForVisibility(logoutLink);
        logoutLink.click();
    }

}
