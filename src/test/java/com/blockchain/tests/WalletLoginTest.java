package com.blockchain.tests;

import com.blockchain.steps.SignInSteps;
import com.blockchain.util.Helper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Wallet Login Tests")
public class WalletLoginTest extends SignInSteps {


    @Test
    @DisplayName("A user must be able to login with valid credentials.")
    void walletSignInWithValidUsernameAndPassword() {
        String email = Helper.generateRandomEmail();
        String password = Helper.passwordGenerator();
        create_wallet_account(email, password);
        logout_from_my_account();
        navigate_to_wallet_login();
        enter_username_to_signIn(email);
        enter_password_to_signIn(password);
        user_is_on_the_wallet_home_page();
    }

    @ParameterizedTest
    @CsvSource({
            "dfddfdfs&%%$&,                                       Invalid Wallet ID or Email",
            "131313.com,                                          Invalid Wallet ID or Email",
            "'    ',                                              Required",
            "dfhdajhffjhdlkfhdklfhkdlhfldhflkdhfklhdf@fgdsgds,    Invalid Wallet ID or Email",
            "deepthi.copper@gmail.com,                            Error sending verification email. Please try again."
    })
    @DisplayName("A user should not be able to login with invalid username and see an error message")
    void walletSignInWithInvalidUsername(String userName, String errorMessage) {
        navigate_to_wallet_login();
        enter_username_to_signIn(userName);
        user_can_see_an_error_in_the_email_textField(errorMessage);
    }

    @ParameterizedTest
    @CsvSource({
            "dfddfdfs&%%$&,                                       Wrong password. Do you want to recover your wallet using Secret Private Key Recovery Phrase?",
            "13        ,                                          Wrong password. Do you want to recover your wallet using Secret Private Key Recovery Phrase?",
             "'    ',                                             Required",
            "dfhdajhWWWWfjhdlkfhdklfh5362$£$!@$fldhfl@fgdsgds,    Wrong password. Do you want to recover your wallet using Secret Private Key Recovery Phrase?",
            "gdjs,                                                Wrong password. Do you want to recover your wallet using Secret Private Key Recovery Phrase?"
    })
    @DisplayName("A user should not be able to login with invalid password and see an error message")
    void walletSignInWithValidUsernameAndInvalidPassword(String password, String errorMessage) {
        navigate_to_wallet_login();
        enter_username_to_signIn("deep.crpto.test@gmail.com");
        enter_password_to_signIn(password);
        user_can_see_an_error_in_the_password_textField(errorMessage);
    }

    @Test
    @DisplayName("A user should be able to navigates to the help page from login page")
    void userNavigatesToHelpPageFromLoginPage() {
        navigate_to_wallet_login();
        navigates_to_help_page_from_loginPage();
        user_is_on_the_wallet_help_page();
    }

    @Test
    @DisplayName("A user should be able to navigates to signup page from login page")
    void userNavigatesToSignUpPageFromLoginPage() {
        navigate_to_wallet_login();
        navigates_to_signup_page_from_loginPage();
        user_is_on_the_signup_page();
    }

    @Test
    @DisplayName("A user should be able to navigates back to Email screen from Password screen")
    void userNavigatesBackToEmailScreenFromPasswordScreen() {
        navigate_to_wallet_login();
        enter_username_to_signIn("deepthicrypto22@gmail.com");
        navigates_back_to_emailScreen_from_passwordScreen();
        user_is_on_the_wallet_home_page();
    }

}
