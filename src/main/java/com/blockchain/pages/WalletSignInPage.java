package com.blockchain.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.HashMap;
import java.util.Map;

public class WalletSignInPage extends BasePage {


    @FindBy(xpath = "//*[@data-e2e='loginGuidOrEmail']")
    WebElement txtEmail;

    @FindBy(xpath = "//*[@data-e2e='loginButton']")
    WebElement btnLogin;

    @FindBy(xpath = "//*[@data-e2e='loginPassword']")
    WebElement txtPassword;

    @FindBy(xpath = "//*[@data-e2e='passwordButton']")
    WebElement btnPassword;

    @FindBy(xpath = "//*[@data-e2e='loginGetHelp']")
    WebElement loginHelpLink;

    @FindBy(xpath = "//*[@data-e2e='signupBack']")
    WebElement btnBack;

    @FindBy(xpath = "//*[@data-e2e='textBoxError']")
    WebElement txtInvalidEmailError;

    @FindBy(xpath = "//*[@data-e2e='requiredMessage']")
    WebElement txtEmailOrPasswordRequiredError;

    @FindBy(xpath = "//*[@data-e2e='toastMessage']")
    WebElement emailDoesNotExistErrorMessage;

    @FindBy(xpath = "//*[@data-e2e='passwordError']")
    WebElement txtInvalidPasswordError;

    @FindBy(xpath = "//*[@data-e2e='signupLink']")
    WebElement signUpLink;

    Map<String, WebElement> errorMap = new HashMap<String, WebElement>() {{
        put("Required", txtEmailOrPasswordRequiredError);
        put("Invalid Wallet ID or Email", txtInvalidEmailError);
        put("Error sending verification email. Please try again.", emailDoesNotExistErrorMessage);
        put("Wrong password. Do you want to recover your wallet using Secret Private Key Recovery Phrase?", txtInvalidPasswordError);
    }};


    public WalletSignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void exists() {
        waitForVisibility(txtEmail);
        Assert.assertTrue(txtEmail.isDisplayed());
        Assert.assertTrue(btnLogin.isDisplayed());
        Assert.assertTrue(loginHelpLink.isDisplayed());
    }

    public void enter_username_and_continue(String userName) {
        txtEmail.clear();
        txtEmail.sendKeys(userName);
        btnLogin.click();
    }

    public void choose_back_button_from_password_Screen() {
        waitForVisibility(btnBack);
        btnBack.click();
    }

    public void enter_password_and_continue(String password) {
        waitForVisibility(txtPassword);
        txtPassword.clear();
        txtPassword.sendKeys(password);
        btnPassword.click();
    }

    public void error_message_displayed_on_email_textField(String errorMessage) {
        Assert.assertFalse(btnLogin.isEnabled());
        waitForVisibility(errorMap.get(errorMessage));
        Assert.assertTrue(errorMap.get(errorMessage).isDisplayed());
    }

    public void error_message_displayed_on_password_textField(String errorMessage) {
        Assert.assertFalse(btnPassword.isEnabled());
        waitForVisibility(errorMap.get(errorMessage));
        Assert.assertTrue(errorMap.get(errorMessage).isDisplayed());
    }

    public void choose_need_some_help_link_from_loginPage() {
        loginHelpLink.click();
    }

    public void choose_signUp_link_from_loginPage() {
        signUpLink.click();
    }
}
