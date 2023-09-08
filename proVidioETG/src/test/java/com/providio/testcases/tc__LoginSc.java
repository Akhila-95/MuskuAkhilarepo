package com.providio.testcases;

import com.providio.pageObjects.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tc__LoginSc extends baseClass {
	SoftAssert softAssert = new SoftAssert();
	
	 boolean openBrowserandClickSignInButtonset = false;
	
    @Test
    public void openBrowserandClickSignInButton() throws InterruptedException {
        test.info("Open browser");
        // Test Case 0: Open browser
        driver.get(baseURL);
        logger.info("Opened browser");
        Thread.sleep(2000L);
        loginPage lp = new loginPage(driver);
        lp.clickSign();
        logger.info("clicked on sign in");
        
        openBrowserandClickSignInButtonset = true;
    }

    @Test(dependsOnMethods = {"com.providio.testcases.testlogin.openBrowserandClickSignInButton"})
	public void verifySuccessfulLogin() throws InterruptedException {
		test.info("Verify successful login");
		// Test Case 1: Verify successful login
	if(openBrowserandClickSignInButtonset) {

        loginPage lp = new loginPage(driver);

        Thread.sleep(2000L);
        lp.setEmail(name);
        logger.info("entered email");
        Thread.sleep(2000L);
        lp.setPassword(password);
        logger.info("entered password");
        Thread.sleep(2000L);
        lp.clickSubmit();
        logger.info("click on the submit button");
        Thread.sleep(5000L);

		WebElement loginTitle = driver.findElement(By.xpath("//h1[@class='account-page-title']"));
		String expectedTitle = "Dashboard";
		String actualTitle = loginTitle.getText();
		
		//String actualTitle = "daha";

        
        if (actualTitle.equals(expectedTitle)) {
        	test.pass("User logged in successfully");         
            logger.info("User logged in successfully");
            isLoggedIn = true;
        } else {
        	
        	WebElement continueShoping = driver.findElement(By.xpath("//a[contains(text(), 'Continue Shopping')]"));
        	Thread.sleep(2000);
        	continueShoping.click();
        	Thread.sleep(4000);
        	isLoggedIn = true;
        	test.fail("The page Title does not match expected " + expectedTitle + " but found " + actualTitle);
            logger.info("Click failed");
            
        }

		//softAssert.assertEquals(actualTitle, expectedTitle, "User login failed");

		// Assert all the soft assertions
		//softAssert.assertAll();
        
	}
	}

	@Test
	public void verifyLoginFailureWithIncorrectCredentials() throws InterruptedException {
		test.info("Verify login failure with incorrect credentials");
		// Test Case 2: Verify login failure with incorrect credentials
		
		if(openBrowserandClickSignInButtonset) {

 		loginPage lp = new loginPage(driver);
        Thread.sleep(2000L);
        lp.setEmail("invalidemail@example.com");
        logger.info("entered email");
        Thread.sleep(2000L);
		lp.setPassword("incorrectpassword");
		logger.info("entered password");
		Thread.sleep(2000L);
		lp.clickSubmit();
        logger.info("click on the submit button");
        Thread.sleep(5000L);
        
        WebElement errorMessageInvalidCred = driver.findElement(By.xpath("//div[contains(@class, 'alert') and contains(@class, 'alert-danger')]"));
        String errorMessage = errorMessageInvalidCred.getText();
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
	}

	@Test
	public void verifyLoginFailureWithEmptyEmailAndPassword() throws InterruptedException {
		test.info("Verify login failure with empty email and password");
		// Test Case 3: Verify login failure with empty email and password
		if(openBrowserandClickSignInButtonset) {

         loginPage lp = new loginPage(driver);

        Thread.sleep(2000L);
        lp.setEmail("");
        logger.info("entered empty email");
        Thread.sleep(2000L);
        lp.setPassword("");
        logger.info("entered empty password");
        Thread.sleep(5000);
        lp.clickSubmitjs(driver);
        logger.info("click on the submit button without entering email and password");
        //Thread.sleep(5000L);
		
		
	      WebElement errorMessageemil = driver.findElement(By.xpath("(//div[@id= 'form-email-error'])[1]"));
	        boolean isDisplayedemail = errorMessageemil.isDisplayed();
	        logger.info(isDisplayedemail);
	        Thread.sleep(5000L);
	        WebElement errorMessagepwd = driver.findElement(By.xpath("(//div[@id= 'form-password-error'])[1]"));
	        boolean isDisplayedpwd = errorMessagepwd.isDisplayed();
	        logger.info(isDisplayedpwd);

	        if(isDisplayedemail && isDisplayedpwd) {
	        	test.pass("User clicked the submit button with out entering the user name and pwd and  error displayed successfully");         
	            logger.info("User clicked the submit button with out entering the user name and pwd and  error displayed successfully");
	        }else {
	        	//test.fail("User clicked the submit button with out entering the user name and pwd and error not displayed");         
	            logger.info("User clicked the submit button with out entering the user name and pwd and error not displayed");
	            Thread.sleep(2000);
	            reclikwhenthesubmitbutton();
	        }

		}
		//softAssert.assertTrue(isDisplayed, "Login failure error message not displayed");

		// Assert all the soft assertions
		//softAssert.assertAll();
	}

	@Test
	public void verifyLoginFailureWithInvalidEmailFormat() throws InterruptedException {
		test.info("Verify login failure with invalid email format");
		// Test Case 4: Verify login failure with invalid email format
		if(openBrowserandClickSignInButtonset) {

         loginPage lp = new loginPage(driver);

        Thread.sleep(2000L);
        lp.setEmail("invalidemail");
        logger.info("entered invalid email");
        Thread.sleep(2000L);
        lp.setPassword(password);
        logger.info("entered password");
        Thread.sleep(2000L);
        lp.clickSubmit();
        logger.info("click on the submit button");
        Thread.sleep(5000L);


		WebElement errorMessage = driver.findElement(By.xpath("(//div[@class='invalid-feedback' and @id='form-email-error'])[1]"));
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
	}

	@Test
	public void verifyLoginFailureWithIncorrectPassword() throws InterruptedException {
		test.info("Verify login failure with incorrect password");
		// Test Case 5: Verify login failure with incorrect password
		if(openBrowserandClickSignInButtonset) {

         loginPage lp = new loginPage(driver);

        Thread.sleep(2000L);
        lp.setEmail(name);
        logger.info("entered invalid email");
        Thread.sleep(2000L);
        lp.setPassword("incorrectpassword");
        logger.info("entered incorrectpassword");
        Thread.sleep(5000);
        lp.clickSubmitjs(driver);
        logger.info("click on the submit button");
        //Thread.sleep(5000);


		WebElement errorMessageInvalidCred = driver.findElement(By.xpath("//div[contains(@class, 'alert') and contains(@class, 'alert-danger')]"));
        boolean isDisplayedinvalidcred = errorMessageInvalidCred.isDisplayed();
        logger.info(isDisplayedinvalidcred);
        
        if(isDisplayedinvalidcred) {
        	test.pass("User entered the wrong creditials and error displayed successfully");         
            logger.info("User entered the wrong creditials and error displayed successfully");
        }else {
        	//test.fail("User entered the wrong creditials and error not displayed");         
            logger.info("User entered the wrong creditials and error not displayed");
            reclicksubmitbuttonincorrectpwd();
        }

		}
		//softAssert.assertTrue(isDisplayed, "Incorrect password error message not displayed");

		// Assert all the soft assertions
		//softAssert.assertAll();
	}
	
	@Test
	public void verifyLoginFailureWithEmptyEmail() throws InterruptedException {
		test.info("Verify login failure with empty email");
		// Test Case 3: Verify login failure with empty email and password
		if(openBrowserandClickSignInButtonset) {	

         loginPage lp = new loginPage(driver);

        Thread.sleep(2000L);
        lp.setEmail("");
        logger.info("entered empty email");
        Thread.sleep(2000L);
        lp.setPassword(password);
        logger.info("entered  password");
        Thread.sleep(2000L);
        lp.clickSubmit();
        logger.info("click on the submit button without entering email");
        Thread.sleep(5000L);
		
		
	      WebElement errorMessageemil = driver.findElement(By.xpath("(//div[@id= 'form-email-error'])[1]"));
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
	}
	
	@Test
	public void verifyLoginFailureWithEmptyPassword() throws InterruptedException {
		test.info("Verify login failure with empty password");
		// Test Case 3: Verify login failure with empty email and password
		if(openBrowserandClickSignInButtonset) {

         loginPage lp = new loginPage(driver);

        Thread.sleep(2000L);
        lp.setEmail(name);
        logger.info("entered email");
        Thread.sleep(2000L);
        lp.setPassword("");
        logger.info("entered empty password");
        Thread.sleep(2000L);
        lp.clickSubmit();
        logger.info("click on the submit button without entering password");
        Thread.sleep(5000L);

	        WebElement errorMessagepwd = driver.findElement(By.xpath("(//div[@id= 'form-password-error'])[1]"));
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
	}
	
	private void reclikwhenthesubmitbutton() throws InterruptedException {
		
		
		loginPage lp = new loginPage(driver);
		
		lp.clickSubmit();
        logger.info("click on the submit button without entering password");
        Thread.sleep(5000L);
        
        WebElement errorMessageemil = driver.findElement(By.xpath("(//div[@id= 'form-email-error'])[1]"));
        boolean isDisplayedemail = errorMessageemil.isDisplayed();
        logger.info(isDisplayedemail);
        Thread.sleep(5000L);
        WebElement errorMessagepwd = driver.findElement(By.xpath("(//div[@id= 'form-password-error'])[1]"));
        boolean isDisplayedpwd = errorMessagepwd.isDisplayed();
        logger.info(isDisplayedpwd);

        if(isDisplayedemail && isDisplayedpwd) {
        	test.pass("User clicked the submit button with out entering the user name and pwd and  error displayed successfully");         
            logger.info("User clicked the submit button with out entering the user name and pwd and  error displayed successfully");
        }else {
        	test.fail("User clicked the submit button with out entering the user name and pwd and error not displayed");         
            logger.info("User clicked the submit button with out entering the user name and pwd and error not displayed");
        }

	}
	
	//incorrectpassword
	
	private void reclicksubmitbuttonincorrectpwd() throws InterruptedException {
		
		loginPage lp = new loginPage(driver);
		
		lp.clickSubmit();
        logger.info("click on the submit button");
        //Thread.sleep(5000);


		WebElement errorMessageInvalidCred = driver.findElement(By.xpath("//div[contains(@class, 'alert') and contains(@class, 'alert-danger')]"));
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


}
