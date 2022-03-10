package com.blockchain.pages;

import com.blockchain.util.PropKey;
import com.blockchain.util.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToBlockchainWalletLoginPage() {
        String url = PropertyReader.getInstance().getProperty(PropKey.LOGIN_URL.getPropVal());
        driver.get(url);
        driver.getCurrentUrl().contains("login");
    }

    public void navigateToBlockchainWalletSignUpPage() {
        String url = PropertyReader.getInstance().getProperty(PropKey.SIGNUP_URL.getPropVal());
        driver.get(url);
        driver.getCurrentUrl().contains("signup");
    }

    public void waitForVisibility(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15, 1));
        wait.until(ExpectedConditions.visibilityOf(e));
    }
}
