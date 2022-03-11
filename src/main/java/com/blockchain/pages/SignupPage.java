package com.blockchain.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignupPage extends BasePage {

    @FindBy(xpath = "//*[@data-e2e='signupButton']")
    WebElement btnCreateWallet;

    @FindBy(xpath = "//*[@data-e2e='createExchangeAccount']")
    WebElement btnCreateExchange;

    @FindBy(xpath = "//*[@data-e2e='signupEmail']")
    WebElement txtEmail;

    @FindBy(xpath = "//*[@data-e2e='signupPassword']")
    WebElement txtPassword;

    @FindBy(xpath = "//*[@data-e2e='signupConfirmPassword']")
    WebElement txtConfirmPassword;

    @FindBy(id = "react-select-2-input")
    WebElement unitedKingdomAsCountry2;

    @FindBy(id = "react-select-2-option-208")
    WebElement unitedKingdomAsCountry;

    @FindBy(xpath = "//*[@data-e2e='false']")
    WebElement checkboxTAndC;

    @FindBy(xpath = "//*[@data-e2e='signupButton']")
    WebElement btnSignup;

    @FindBy(xpath = "//*[@data-e2e='verifyEmailLater']")
    WebElement verifyEmailLater;


    public SignupPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void exists() {
        waitForVisibility(btnCreateWallet);
        Assert.assertTrue(btnCreateWallet.isDisplayed());
        Assert.assertTrue(btnCreateExchange.isDisplayed());
    }

    public void chooseCreateWalletAccountOption() {
        waitForVisibility(btnCreateWallet);
        btnCreateWallet.click();
    }

    public void createNewWalletAccount(String email, String password) {
        waitForVisibility(txtEmail);
        txtEmail.clear();
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        txtConfirmPassword.sendKeys(password);

        unitedKingdomAsCountry2.click();
        waitForVisibility(unitedKingdomAsCountry);
        unitedKingdomAsCountry.click();
        checkboxTAndC.click();
        btnSignup.click();
    }

    public void chooseVerifyEmailLaterOption() {
        waitForVisibility(verifyEmailLater);
        verifyEmailLater.click();
    }

}
