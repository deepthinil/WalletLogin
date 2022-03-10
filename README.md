# WalletLogin

**About this solution:**

Wallet sign in functionality is automated (UI level) using the following framework and tools:
   Selenium Webdriver with JUnit5 + Java (Maven project)
   IDE - Intellij Idea
   
   All the test cases are included in the WalletLoginTest class and the relevant steps and methods have implemented using the page object model. 


 **Note:**

  I have created few wallet accounts in order to test different scenarios for the Wallet login. As you mentioned I did not verify the email. But unfortunately after few attempts it shows me Verify your device screen after I enter the email. Also it shows me the error message "Error sending verification email. Please try again" Because of these reasons some tests can't run the full flow as expected.
I have tried automating a new wallet registration each time  before sign in , still it was showing the same error "Error sending verification email" even though test has skipped the verify email step. The following tests will be failing due to that:


    void walletSignInWithValidUsernameAndPassword() 
    walletSignInWithValidUsernameAndInvalidPassword()
    userNavigatesBackToEmailScreenFromPasswordScreen

   
**How to run the project:**

Pre requisite:

-JAVA and APACHE Maven is installed and set as environment variables
-Change the Chromedriver location from "src/test/resources/drivers/macM1/chromedriver to "src/test/resources/drivers/chromedriver" in the DriverManager class (line 66).

1. Open the project in Intellij and rebuild the project
2. Navigated to project root folder via terminal 
3. Run the following maven command to run the test with any of these browsers: Chrome, Firefox or Safari 

    mvn clean test -Dbrowser=chrome

Note: If you are running against Safari browser , make sure to run the following command first.

      safaridriver --enable



  
