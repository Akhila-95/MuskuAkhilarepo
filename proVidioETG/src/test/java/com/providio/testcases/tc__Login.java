

package com.providio.testcases;

import com.providio.pageObjects.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tc__Login extends baseClass {
	SoftAssert softAssert = new SoftAssert();

    @Test
    public void loginTest() throws InterruptedException {
    	
        //test.log(LogStatus.INFO, "Test case Validation started");
    	test.info("Test case Validation started");
        driver.get(baseURL);
        logger.info("enterd into url");
        Thread.sleep(2000L);
        loginPage lp = new loginPage(driver);
        lp.clickSign();
        logger.info("clicked on sign in");
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
        
        
        WebElement Login = driver.findElement(By.xpath(" //h1[@class ='account-page-title']"));
        String expectedTitle = "Dashboard";
        String actualTitle = Login.getText();
        
        if (actualTitle.equals(expectedTitle)) {
        	test.pass("User logged in successfully");
            //test.pass( "Successfully clicked on the NewArrival of  " + actualTitle + " ");
            logger.info("User logged in successfully");
            isLoggedIn = true;
        } else {
        	test.fail("The page Title does not match expected " + expectedTitle + " but found " + actualTitle);
            //test.log(LogStatus.FAIL, "The page Title does not match expected " + expectedTitle + " " + "  but found" + " " + actualTitle + " ");
            logger.info("Click failed");
            isLoggedIn = true;
        }
        
      
        // Assert all the soft assertions
        softAssert.assertAll();
    }
}