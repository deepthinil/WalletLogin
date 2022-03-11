package com.blockchain.steps;

import com.blockchain.driver.DriverManager;
import com.blockchain.pages.*;

public class SignInSteps extends DriverManager {

    private BasePage basePage = new BasePage(getDriver());
    private WalletSignInPage walletSignInPage = new WalletSignInPage(getDriver());
    private WalletHomePage walletHomePage = new WalletHomePage(getDriver());
    private HelpPage helpPage = new HelpPage(getDriver());
    private SignupPage signupPage = new SignupPage(getDriver());

    public void navigate_to_wallet_login() {
        basePage.navigateToBlockchainWalletLoginPage();
        walletSignInPage.exists();
    }

    public void create_wallet_account(String userName, String password) {
        basePage.navigateToBlockchainWalletSignUpPage();
        signupPage.exists();
        signupPage.chooseCreateWalletAccountOption();
        signupPage.createNewWalletAccount(userName, password);
        signupPage.chooseVerifyEmailLaterOption();
        walletHomePage.exists();
    }

    public void logout_from_my_account() {
        walletHomePage.signOutFromTheAccount();
        walletSignInPage.choose_back_button_from_password_Screen();
    }

    public void enter_username_to_signIn(String userName) {
        try {
            walletSignInPage.enter_username_and_continue(userName);
        }
        catch (Exception ex) {}
    }

    public void navigates_back_to_emailScreen_from_passwordScreen() {
        walletSignInPage.choose_back_button_from_password_Screen();
    }

    public void user_can_see_an_error_in_the_email_textField(String errorMessage) {
        walletSignInPage.error_message_displayed_on_email_textField(errorMessage);
    }

    public void enter_password_to_signIn(String password) {
        walletSignInPage.enter_password_and_continue(password);
    }

    public void user_can_see_an_error_in_the_password_textField(String errorMessage) {
        walletSignInPage.error_message_displayed_on_password_textField(errorMessage);
    }

    public void user_is_on_the_wallet_home_page() {
        walletHomePage.exists();
    }

    public void navigates_to_help_page_from_loginPage() {
        walletSignInPage.choose_need_some_help_link_from_loginPage();
    }

    public void navigates_to_signup_page_from_loginPage() {
        walletSignInPage.choose_signUp_link_from_loginPage();
    }

    public void user_is_on_the_wallet_help_page() {
        helpPage.exists();
    }

    public void user_is_on_the_signup_page() {
        signupPage.exists();
    }
}
