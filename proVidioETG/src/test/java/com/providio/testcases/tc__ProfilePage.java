package com.providio.testcases;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.pageObjects.profilePage;

public class tc__ProfilePage extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	
	 @Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void profilePage() throws InterruptedException {
	    // Validate login
	    if (isLoggedIn) {
	    	
	        Thread.sleep(5000);
	        profilePage pp = new profilePage(driver);
	        pp.howeraccount(driver);
	        
	        pp.scrolldown(driver);
	        
	        //edit personal info
	        pp.clickEditPage();
			logger.info("Clicked on the editprofile");
			Thread.sleep(10000);
			
			pp.setFisrtName(epfname);
			logger.info("Entered the firstName");
			
		    pp.setLastname(eplname);
		    logger.info("Entered the lastName");
		    
		    pp.scrolldown(driver);
			logger.info("Clicked on the Scrolldown");
			Thread.sleep(5000);
			
		    pp.setconfirmEmail(epconfirmEmail);
		    logger.info("Entered the Email");
		    
		    pp.setpassword(eppassword);
		    logger.info("Entered the password");
		    
		    //verifythepage
		    validateSucessfullyEdit();

		    pp.clickSaveButtoninEditpage(driver);
		    logger.info("Clicked on the savebutton in the edit page");
	   
		    
		    //change password
		    pp.clickChangePassword();
		    logger.info("Clicked on the changepassword");
		    
		    pp.setcurrentPassword(epcurrentPassword);
		    logger.info("Enterd the currnet Password");
		    
		    pp.setnewPassword(epnewPassword);
		    logger.info("Entered the new password");
		    
		    pp.setnewPasswordConfirm(epnewPasswordConfirm);
		    logger.info("Enterd the newpassword conform");
		    
		    //validatethechangepasswordpage
		    validateSucessfullyChangePassword();
		    
		    
			pp.clicksavebuttonPasswordChange(driver);
			logger.info("Clicked on the save button on the change password page");
	    
			
	        //add new address
	    	pp.clickAddNewAddress();
			logger.info("Clicked on the AddnewAddress");
			Thread.sleep(5000);
			
			pp.setAddressTitle("NewAddressHome");
			
			pp.setFirstNameofAddress("TMX");
			
			pp.setLastNameofAddress("MORE");

			WebElement Address1 = driver.findElement(By.xpath("//form[@id='dwfrm_address']//input[@id='address1']"));
            Random random = new Random();
            int randomNumber = random.nextInt(900) + 100; // Generates a random number between 100 and 999
            address = String.valueOf(randomNumber);
            Address1.sendKeys(address);
            WebElement Address11 = driver.switchTo().activeElement();
            Actions actions = new Actions(driver);
            Thread.sleep(1000);
            Address11.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(1000);
            Address11.sendKeys(Keys.ARROW_DOWN);
            Address11.sendKeys(Keys.ENTER);
           
            pp.phonenumber();
            
            logger.info("Entered phone number");
            Thread.sleep(10000L);
			
			pp.scrolldown(driver);
			logger.info("Clicked on the Scrolldown");
			
			//validate the add new address page
			validateSucessfullyaddtheNewAddress();
			
			pp.saveButton(driver);
			
			pp.clickReturntomyAccount(driver);
			logger.info("Clicked on the Returntomyaccount");
			Thread.sleep(5000);
	        // Perform the steps to add a new address
	        // Add assertions or verifications to validate the add new address functionality


	        //order history
	        pp.clickViewOrderHistory(driver);
			logger.info("Clicked on the vieworderhistory");
			Thread.sleep(5000);
			
			pp.scrolldown(driver);
			logger.info("Clicked on the Scrolldown");
			Thread.sleep(10000);
			
			//validate the orderhistory page
			validateSucessfullyViewedThewishList();
			
			pp.clickReturntomyAccountinViewOrder(driver);
			logger.info("Clicked on the Returntomyaccount");
			Thread.sleep(5000);
	        // Perform the steps to view the order history
	        // Add assertions or verifications to validate the view order history functionality



		

//		//creditcard
//		
//		pp.clickaddCreditCard();
//
//		pp.setcardholdername(driver);
//		logger.info("entered card name");
//		
//		pp.setcardnumber(driver);
//		logger.info("entered card number");
//		
//		pp.setcardcvv(driver);
//		logger.info("entered cvv");
//		
//		pp.setcardexp(driver);
//		logger.info("entered exp");
//		
//		pp.clicksavebuttoncc(driver);
//        logger.info("Saved succesfully");	
        
		Thread.sleep(5000);

	        } else {
	            Assert.fail("User is not logged in");
	        }

		
        // Assert all the soft assertions
        softAssert.assertAll();
		
   }
	
	private void validateSucessfullyEdit() {
		test.info("Verify that Edited the user information");
		
		WebElement editProfileHeading = driver.findElement(By.xpath("//h2[text()='Edit Profile']"));
		boolean isDisplayed = editProfileHeading.isDisplayed();

		if (isDisplayed) {
			test.pass("Successfully eited the profile infomation");
	        logger.info("Successfully eited the profile infomation");
		} else {
			test.fail("Not eited the profile infomation");
	        logger.info("Not eited the profile infomation");
		}

		
	}
	
	private void validateSucessfullyChangePassword() {
		test.info("Verify that Edited the ChangePassword");
		
		WebElement editProfileHeading = driver.findElement(By.xpath("//h2[text()='Change Password']"));
		boolean isDisplayed = editProfileHeading.isDisplayed();

		if (isDisplayed) {
			test.pass("Successfully eited the profile infomation of ChangePassword");
	        logger.info("Successfully eited the profile infomation of ChangePassword");
		} else {
			test.fail("Not eited the profile infomation of ChangePassword");
	        logger.info("Not eited the profile infomation of ChangePassword");
		}

		
	}
	
	private void validateSucessfullyaddtheNewAddress() {
		test.info("Verify that Edited the user information");
		
		WebElement editProfileHeading = driver.findElement(By.xpath("//h2[text()='Add New Address']"));
		boolean isDisplayed = editProfileHeading.isDisplayed();

		if (isDisplayed) {
			test.pass("Successfully eited the profile infomation of addtheNewAddress");
	        logger.info("Successfully eited the profile infomation of addtheNewAddress");
		} else {
			test.fail("Not eited the profile infomation of addtheNewAddress");
	        logger.info("Not eited the profile infomation of addtheNewAddress");
		}

		
	}
	
	private void validateSucessfullyViewedThewishList() {
		test.info("Verify that Edited the user information");
		
		WebElement editProfileHeading = driver.findElement(By.xpath("//h2[text()='Order History']"));
		boolean isDisplayed = editProfileHeading.isDisplayed();

		if (isDisplayed) {
			test.pass("Successfully eited the profile infomation of Order History");
	        logger.info("Successfully eited the profile infomation of Order History");
		} else {
			test.fail("Not eited the profile infomation of Order History");
	        logger.info("Not eited the profile infomation of Order History");
		}

		
	}


}