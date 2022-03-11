# WalletLogin

**About this solution:**

Wallet sign in functionality is automated (UI level) using the following framework and tools:
   Selenium Webdriver with JUnit5 + Java (Maven project)
   IDE - Intellij Idea
   
   All the test cases are included in the WalletLoginTest class and the relevant steps and methods have implemented using the page object model. 
   
    walletSignInWithValidUsernameAndPassword() 
    walletSignInWithInvalidUsername()
    walletSignInWithValidUsernameAndInvalidPassword()
    userNavigatesToHelpPageFromLoginPage()
    userNavigatesToSignUpPageFromLoginPage()
    userNavigatesBackToEmailScreenFromPasswordScreen()


 **Note:**

  I have created few wallet accounts in order to test different scenarios for the Wallet login. As you advised, I did not verify the email, however unfortunately after few attempts I was prompted with "Verify your device" screen post entering the email. It also sometimes shows the error message "Error sending verification email. Please try again" Because of these reasons some tests can't run the full flow as I would have expected.
I have tried automating a new wallet registration each time  before sign in which might help as trusted browser session in order elimanate the prompt for the email verification however that didnt seem to work, even though automation test had skipped the verify email step. 

The following tests might fail due to the reasons elboarted above:


    void walletSignInWithValidUsernameAndPassword() 
    walletSignInWithValidUsernameAndInvalidPassword()
    userNavigatesBackToEmailScreenFromPasswordScreen()

   
**How to run the project:**

Pre-requisite:

- JAVA and APACHE Maven is installed and set appropriate environment variables
- If this is run on non M1 chip: Change the Chromedriver location from "src/test/resources/drivers/macM1/chromedriver to "src/test/resources/drivers/chromedriver" in the DriverManager class (line 66).
- Chrome / Firefox / Safari browser is installed (recent versions).

1. Open the project in Intellij and rebuild the project
2. Navigated to project root folder via terminal 
3. Run the following maven command to run the test with any of these browsers: Chrome, Firefox or Safari 

     mvn clean test -Dbrowser=chrome

 Note: If you are running against Safari browser , make sure to run the following command first.

      safaridriver --enable
      
 If you are running the tests via IntelliJ, tests will run on Chrome browser as browser is set to Chrome by default in application.properties. But if you want to run the tests on a different browser, change the value (browser name) in application.properties.

