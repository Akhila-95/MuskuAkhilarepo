package com.providio.Validations;

 

 

import java.util.List;

 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

 

import com.github.javafaker.Faker;
import com.providio.pageObjects.CreateAccount;
import com.providio.pageObjects.guestUserLoginPage;
import com.providio.pageObjects.loginPage;
import com.providio.pageObjects.miniCartPage;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productListingPage;
import com.providio.testcases.baseClass;
import com.providio.testcases.size;
import com.providio.testcases.tc__LogOut;
import com.providio.testcases.tc__createAccount;

 

public class CheckoutPage1_Validation extends baseClass {

 

    Faker faker = new Faker();
    @Test
    public void checkoutPage1Validation() throws InterruptedException {

            commonScript();
            forgotPassword();
            guestcheckoutValidation();
            signUpInCheckoutValidation(driver);
            signInFromCheckOut();


 

    }

    public void forgotPasswordValidation() throws InterruptedException {
          commonScript();
          forgotPassword();
    }
    public void guestcheckoutValidationValidation() throws InterruptedException {
          commonScript();
          guestcheckoutValidation();
    }

    public void  signInFromCheckOutValidation(WebDriver driver) throws InterruptedException{
          commonScript();
          signUpInCheckoutValidation(driver);         
    }
    public void    signInFromCheckOutValidation() throws InterruptedException {
          commonScript();
           signInFromCheckOut();
    }

    public void commonScript() throws InterruptedException {

        driver.get(this.baseURL);
        logger.info("enterd into url");

    //naviagated into random menu
         navigationPage navPage= new navigationPage(driver);
         navPage.selectRandomMenu(driver);
         logger.info("Entered into menu");

         //plp page    
         productListingPage plp = new productListingPage(driver);
         plp.selectProductRandom(driver);
         logger.info("Entered into plp page");

 

        size s = new size();
        s.selectSize(driver);

        miniCartPage mc = new miniCartPage(driver);

        Thread.sleep(4000);

        //click on the cart button
        mc.clickcartbutton(driver);
        Thread.sleep(2000);
        mc.clickCheckout();
        logger.info("Clicked on checkout button");
    }
    public void guestcheckoutValidation() throws InterruptedException {

 

         guestUserLoginPage guestLoginPage = new guestUserLoginPage(driver);
         guestLoginPage.clickOnGuestCheckOut();
         logger.info("Clicked on Guest checkout");

         emptyEmailAddress();

         invalidEmailAddress();

         guestCheckOutValidEmailAddress();

    }
    public void emptyEmailAddress() throws InterruptedException {

         guestUserLoginPage guestLoginPage = new guestUserLoginPage(driver);
         test.info("Verifying the error message by continuing without entering email address");
         guestLoginPage.clickOnContinueAsGuest();
         logger.info("Clicked on Guest continue as guest without entering email ");
         Thread.sleep(1000);
         WebElement errorMsgElement = driver.findElement(By.xpath("//div[contains(text(),'This field is required.')]"));
         String  expectedErrorMsg = errorMsgElement.getText();
         String actualErrorMsg="This field is required.";
             if(expectedErrorMsg.equals(actualErrorMsg)) {
                test.pass("Successfully the error message is dispalyed when continued without entering email address");
             }else {
                 test.fail("No error message is dispalyed when continued without entering email address");
             }
    }

 

    public void invalidEmailAddress() throws InterruptedException {

         test.info("Verifying the error message for invalid email address");
         guestUserLoginPage guestLoginPage = new guestUserLoginPage(driver);
         String invalidEmail= faker.internet().domainWord() + faker.number().digits(2);
         System.out.println(invalidEmail);
         guestLoginPage.clickOnEmail(invalidEmail);

         guestLoginPage.clickOnContinueAsGuest();
         Thread.sleep(1000);
         logger.info("Clicked on Guest continue as guest with invalid email ");
         WebElement invalidErrorMsgElement =driver.findElement(By.xpath("//div[contains(text(),'Please enter a valid email address.')]"));
         String expectedInvalidErrorMsg= invalidErrorMsgElement.getText();
         String actualInvalidError= "Please enter a valid email address.";

         if(expectedInvalidErrorMsg.equals(actualInvalidError)) {
             test.pass("Successfully the error message is dispalyed when invalid email address entered");
         } else {
            test.fail("No error message is displayed when invalid email address entered");
         }
    }
    public void guestCheckOutValidEmailAddress() throws InterruptedException {

         test.info("Verifying the by valid email address");
         String validMail = faker.internet().emailAddress();         
         guestUserLoginPage guestLoginPage = new guestUserLoginPage(driver);
         guestLoginPage.clickOnEmailClear();
         guestLoginPage.clickOnEmail(validMail);
         logger.info("Entered valid mail address");

         guestLoginPage.clickOnContinueAsGuest();
         logger.info("Clicked on Guest continue as guest with valid email ");
         Thread.sleep(2000);
         WebElement paginationOfGuestUser = driver.findElement(By.xpath("//span[contains(@class,'customer-labe')]"));
             if(paginationOfGuestUser.isDisplayed()) {
                 test.pass("Successfully the page is redirected to checkout page 1");
             }else {
                 test.fail(" The page is not redirected to checkout page 1");
             }

             Thread.sleep(1000);
             guestLoginPage.clickOnBackToCart();
             logger.info("Clicked on back to cart");

             System.out.println("");


    }

//account creation from checkout page
    public void signUpInCheckoutValidation(WebDriver driver) throws InterruptedException {

         List<WebElement> checkout = driver.findElements(By.xpath("//a[contains(@class,'btn btn-primary btn')]"));
         if(checkout.size()>0) {        
            miniCartPage mc = new miniCartPage(driver);
            mc.clickCheckout();
            logger.info("Clicked on checkout button");
         }
        tc__createAccount ca =new  tc__createAccount();
        ca.createAccountFromCheckOut();

        Thread.sleep(2000);
        WebElement paginationOfGuestUser = driver.findElement(By.xpath("//span[contains(@class,'customer-labe')]"));
             if(paginationOfGuestUser.isDisplayed()) {
                 test.pass("Created account and Successfully the page is redirected to checkout page 1");
             }else {
                 test.fail(" The page is not redirected to checkout page 1");
             }

             Thread.sleep(3000);
             guestUserLoginPage guestLoginPage = new guestUserLoginPage(driver);
             guestLoginPage.clickOnBackToCart();
             logger.info("Clicked on back to cart");

             logger.info("Logined by creating account");

             Thread.sleep(5000);

             tc__LogOut logout= new tc__LogOut();
             logout.Logout();

             commonScript();
             System.out.println("");
    }

 

    
    public void forgotPassword() throws InterruptedException {

        guestUserLoginPage guestLoginPage = new guestUserLoginPage(driver);
        test.info("Forgot password");
//        Thread.sleep(1000);
//        guestLoginPage.clickOnEmail(reEnterMail);
//        logger.info("Entered email");

        Thread.sleep(1000);

        guestLoginPage.clickOnForgotPwd();
        logger.info("Clicked on forget password");

        Thread.sleep(1000);
        guestLoginPage.enterForgotPwdEmail();
        logger.info("Entered the email id");

        Thread.sleep(2000);
        guestLoginPage.clickOnSend(driver);
        logger.info("Clicked on send button");

        Thread.sleep(3000);
        guestLoginPage.clickOnLoginPwd();

        Thread.sleep(3000);
          System.out.println("");
    }        


    public void signInFromCheckOut() throws InterruptedException {

        List<WebElement> checkout = driver.findElements(By.xpath("//a[contains(@class,'btn btn-primary btn')]"));
         if(checkout.size()>0) {        
            miniCartPage mc = new miniCartPage(driver);
            mc.clickCheckout();
            logger.info("Clicked on checkout button");
         }
        test.info("Verifying the sign in from checkout ");
        guestUserLoginPage guestLoginPage = new guestUserLoginPage(driver);
        guestLoginPage.clickOnGuestCheckOut();

        logger.info("Clicked on guest checkout");
        guestLoginPage.clickOnSignIn();
        logger.info("Clicked on sign in ");

        verifyLoginFailureWithIncorrectCredentials();
        verifyLoginFailureWithEmptyEmailAndPassword();
        verifyLoginFailureWithInvalidEmailFormat();
        verifyLoginFailureWithIncorrectPassword();
        verifyLoginFailureWithEmptyEmail();
        verifyLoginFailureWithEmptyPassword();
        verifyLoginWithValidCredientials();

         Thread.sleep(3000);

//         guestLoginPage.clickOnBackToCart();
//         logger.info("Clicked on back to cart");
//         
//         logger.info("Logined by creating account");
//         
//         Thread.sleep(5000);
//         tc__LogOut logout= new tc__LogOut();
//         logout.Logout1();
//         
//         commonScript();
    }

    public void verifyLoginFailureWithIncorrectCredentials() throws InterruptedException {

        test.info("Verify login failure with incorrect credentials");
        // Test Case 2: Verify login failure with incorrect credentials


        guestUserLoginPage guestLoginPage = new guestUserLoginPage(driver);
        guestLoginPage.clickOnGuestMail("akhila.m@etg.digital");         
        Thread.sleep(2000L);      
        logger.info("entered email");
        Thread.sleep(2000L);
        guestLoginPage.clickOnGuestPassword("234sfd");
        logger.info("entered password");
        Thread.sleep(2000L);
        guestLoginPage.clickOnLogin();
        logger.info("click on the login button");
        Thread.sleep(5000L);

        WebElement errorMessageInvalidCred = driver.findElement(By.xpath("//div[contains(text(),'This field needs at least 8 characters, 1 number, 1 lowercase letter, 1 uppercase letter, & 1 special character.')]"));      
        boolean isDisplayedinvalidcred = errorMessageInvalidCred.isDisplayed();
        logger.info(isDisplayedinvalidcred);

        if(isDisplayedinvalidcred) {
            test.pass("User entered the wrong creditials and error displayed successfully");         
            logger.info("User entered the wrong creditials and error displayed successfully");
        }else {
            test.fail("User entered the wrong creditials and error not displayed");         
            logger.info("User entered the wrong creditials and error not displayed");
        }
        }
        //softAssert.assertTrue(isDisplayed, "Login failure error message not displayed");

 

        // Assert all the soft assertions
        //softAssert.assertAll();


 

    
    public void verifyLoginFailureWithEmptyEmailAndPassword() throws InterruptedException {
        test.info("Verify login failure with empty email and password");
        // Test Case 3: Verify login failure with empty email and password

        guestUserLoginPage guestLoginPage = new guestUserLoginPage(driver);
        guestLoginPage.clickOnGuestMail("");         
        Thread.sleep(2000L);      
        logger.info("entered email");
        Thread.sleep(2000L);
        guestLoginPage.clickOnGuestPassword("");
        logger.info("entered password");
        Thread.sleep(2000L);
        guestLoginPage.clickOnLogin();
        logger.info("click on the login button");
        Thread.sleep(5000L);;
        logger.info("click on the login button without entering email and password");
        //Thread.sleep(5000L);


          WebElement errorMessageemil = driver.findElement(By.xpath("(//div[contains(text(),'This field is required.')])[1]"));
            boolean isDisplayedemail = errorMessageemil.isDisplayed();
            logger.info(isDisplayedemail);
            Thread.sleep(5000L);
            WebElement errorMessagepwd = driver.findElement(By.xpath("(//div[contains(text(),'This field is required.')])[2]"));
            boolean isDisplayedpwd = errorMessagepwd.isDisplayed();
            logger.info(isDisplayedpwd);

 

            if(isDisplayedemail && isDisplayedpwd) {
                test.pass("User clicked the submit button with out entering the user name and pwd and  error displayed successfully");         
                logger.info("User clicked the submit button with out entering the user name and pwd and  error displayed successfully");
            }else {
                //test.fail("User clicked the submit button with out entering the user name and pwd and error not displayed");         
                logger.info("User clicked the submit button with out entering the user name and pwd and error not displayed");
                Thread.sleep(2000);
        }
        //softAssert.assertTrue(isDisplayed, "Login failure error message not displayed");

 

        // Assert all the soft assertions
        //softAssert.assertAll();
    }

 

    
    public void verifyLoginFailureWithInvalidEmailFormat() throws InterruptedException {
        test.info("Verify login failure with invalid email format");
        // Test Case 4: Verify login failure with invalid email format

 

        guestUserLoginPage guestLoginPage = new guestUserLoginPage(driver);
        guestLoginPage.clickOnGuestMail("akhila22mail.com");         
        Thread.sleep(2000L);      
        logger.info("entered email");
        Thread.sleep(2000L);
        guestLoginPage.clickOnGuestPassword("Akhireddy@97");
        logger.info("entered password");
        Thread.sleep(2000L);
        guestLoginPage.clickOnLogin();
        logger.info("click on the login button");
        Thread.sleep(5000L);;
        logger.info("click on the login button without entering email and password");

 

 

        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(),'Please enter a valid email address.')]"));
        boolean isInvalidEmailErrorDisplayed = errorMessage.isDisplayed();

        if(isInvalidEmailErrorDisplayed) {
            test.pass("User entered the wrong email format and error displayed successfully");         
            logger.info("User entered the wrong email format and error displayed successfully");
        }else {
            test.fail("User entered the wrong email format and error not displayed");         
            logger.info("User entered the wrong email format and error not displayed");
        }
        }
        //softAssert.assertTrue(isInvalidEmailErrorDisplayed, "Invalid email format error message not displayed");

 

        // Assert all the soft assertions
        //softAssert.assertAll();


 

 

    public void verifyLoginFailureWithIncorrectPassword() throws InterruptedException {
        test.info("Verify login failure with incorrect password");
        // Test Case 5: Verify login failure with incorrect password


 

        guestUserLoginPage guestLoginPage = new guestUserLoginPage(driver);
        guestLoginPage.clickOnGuestMail("akhila.m@etg.digital");         
        Thread.sleep(2000L);      
        logger.info("entered email");
        Thread.sleep(2000L);
        guestLoginPage.clickOnGuestPassword("Akhireddy@97");
        logger.info("entered password");
        Thread.sleep(2000L);
        guestLoginPage.clickOnLogin();
        logger.info("click on the login button");
        Thread.sleep(5000L);;
        logger.info("click on the login button without entering email and password");
        //Thread.sleep(5000);

 

 

        WebElement errorMessageInvalidCred = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible fade show']"));
        boolean isDisplayedinvalidcred = errorMessageInvalidCred.isDisplayed();
        logger.info(isDisplayedinvalidcred);

        if(isDisplayedinvalidcred) {
            test.pass("User entered the wrong creditials and error displayed successfully");         
            logger.info("User entered the wrong creditials and error displayed successfully");
        }else {
            //test.fail("User entered the wrong creditials and error not displayed");         
            logger.info("User entered the wrong creditials and error not displayed");

        }
        //softAssert.assertTrue(isDisplayed, "Incorrect password error message not displayed");

 

        // Assert all the soft assertions
        //softAssert.assertAll();
    }


    public void verifyLoginFailureWithEmptyEmail() throws InterruptedException {
        test.info("Verify login failure with empty email");
        // Test Case 3: Verify login failure with empty email and password

        guestUserLoginPage guestLoginPage = new guestUserLoginPage(driver);
        guestLoginPage.clickOnGuestMail("");         
        Thread.sleep(2000L);      
        logger.info("entered email");
        Thread.sleep(2000L);
        guestLoginPage.clickOnGuestPassword("Akhireddy@97");
        logger.info("entered password");
        Thread.sleep(2000L);
        guestLoginPage.clickOnLogin();
        logger.info("click on the login button");
        Thread.sleep(5000L);;
        logger.info("click on the login button without entering email and password");


          WebElement errorMessageemil = driver.findElement(By.xpath("(//div[contains(text(),'This field is required.')])[1]"));
            boolean isDisplayedemail = errorMessageemil.isDisplayed();
            logger.info(isDisplayedemail);
            Thread.sleep(5000L);

 

 

            if(isDisplayedemail) {
                test.pass("User clicked the submit button with out entering the userName and  error displayed successfully");         
                logger.info("User clicked the submit button with out entering userName and  error displayed successfully");
            }else {
                test.fail("User clicked the submit button with out entering userName and error not displayed");         
                logger.info("User clicked the submit button with out entering userName and error not displayed");
            }

 

        }
        //softAssert.assertTrue(isDisplayed, "Login failure error message not displayed");

 

        // Assert all the soft assertions
        //softAssert.assertAll();

 

    

    public void verifyLoginFailureWithEmptyPassword() throws InterruptedException {
        test.info("Verify login failure with empty password");
        // Test Case 3: Verify login failure with empty email and password

        guestUserLoginPage guestLoginPage = new guestUserLoginPage(driver);
        guestLoginPage.clickOnGuestMail("akhila@22mail.com");         
        Thread.sleep(2000L);      
        logger.info("entered email");
        Thread.sleep(2000L);
        guestLoginPage.clickOnGuestPassword("");
        logger.info("entered password");
        Thread.sleep(2000L);
        guestLoginPage.clickOnLogin();
        logger.info("click on the login button");
        Thread.sleep(5000L);;
        logger.info("click on the login button without entering email and password");

 

            WebElement errorMessagepwd = driver.findElement(By.xpath("(//div[contains(text(),'This field is required.')])[2]"));
            boolean isDisplayedpwd = errorMessagepwd.isDisplayed();
            logger.info(isDisplayedpwd);

 

            if(isDisplayedpwd) {
                test.pass("User clicked the submit button with out entering the PWD and  error displayed successfully");         
                logger.info("User clicked the submit button with out entering the PWD and  error displayed successfully");
            }else {
                test.fail("User clicked the submit button with out entering the PWD  and error not displayed");         
                logger.info("User clicked the submit button with out entering the PWD and error not displayed");
            }

 

        }
        //softAssert.assertTrue(isDisplayed, "Login failure error message not displayed");

 

        // Assert all the soft assertions
        //softAssert.assertAll();

public void verifyLoginWithValidCredientials() throws InterruptedException {

    test.info("Verify login correct credentials");
    // Test Case 3: Verify login failure with empty email and password

    guestUserLoginPage guestLoginPage = new guestUserLoginPage(driver);
    guestLoginPage.clickOnGuestMail("Upendra.y@gmail.com");         
    Thread.sleep(2000L);      
    logger.info("entered email");
    Thread.sleep(2000L);
    guestLoginPage.clickOnGuestPassword("Upendra@1218");
    logger.info("entered password");
    Thread.sleep(2000L);
    guestLoginPage.clickOnLogin();
    logger.info("click on the login button");
    Thread.sleep(5000L);;
    logger.info("clicked on the login button with entering valid email and password");

 

    Thread.sleep(2000);
    WebElement paginationOfGuestUser = driver.findElement(By.xpath("//span[contains(@class,'customer-labe')]"));
         if(paginationOfGuestUser.isDisplayed()) {
             test.pass("Logined Successfully ,the page is redirected to checkout page 1");

             Thread.sleep(5000);
             loginPage lp = new loginPage(driver);
             lp.clickOnLogo(driver);


            Thread.sleep(5000);
             tc__LogOut logout= new tc__LogOut();
             logout.Logout();

         }else {
             test.fail(" The page is not redirected to checkout page 1");
         }

 

    }
    //softAssert.assertTrue(isDisplayed, "Login failure error message not displayed");

 

    // Assert all the soft assertions
    //softAssert.assertAll();
}