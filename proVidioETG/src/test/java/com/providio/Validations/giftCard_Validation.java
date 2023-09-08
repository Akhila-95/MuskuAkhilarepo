package com.providio.Validations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.providio.pageObjects.GiftCertificate;
import com.providio.testcases.baseClass;

public class giftCard_Validation extends baseClass {

	boolean openGiftCertificatePage= false;
	 @Test//(dependsOnMethods = {"com.providio.testcases.Tc_Login.loginTest"} )
	public void  giftCard() throws InterruptedException {
		 
		 	driver.get(this.baseURL);
	        logger.info("enterd into url");
			Thread.sleep(4000);		
			GiftCertificate gc= new  GiftCertificate(driver);
			gc.giftCertificatePage(driver);
			
			openGiftCertificatePage= true;
		

	}
	 Faker faker =new Faker();
	 @Test(priority = 1, dependsOnMethods = {"com.providio.testCases.Tc_GiftCard.giftCard"})
	 	public void verifyByEmptyText() throws InterruptedException {
			
		 if(openGiftCertificatePage) {
			 
			 GiftCertificate  gc= new GiftCertificate (driver);
			 
			 gc.enterFriendsName("");
			 logger.info("Entered empty text");
			 
			 gc.enterFromName("");
			 logger.info("Entered empty text");
			
			 gc.enterFriendsMail("");
			 logger.info("Entered empty text");
			 
			 gc.enterConfirmFriendsMail("");
			 logger.info("Entered empty text");
			 
			 gc.addToCartButton();
			 
			 WebElement recipientNameError= driver.findElement(By.xpath("//div[@id='form-recipient-error']"));			
			 WebElement nameError = driver.findElement(By.xpath("//div[@id='form-from-error']"));			 
			 WebElement recipientMailError= driver.findElement(By.xpath("//div[@id='form-recipientEmail-error']"));			
			 WebElement confirmRecipientMail= driver.findElement(By.xpath("//div[@id='form-email-confirm-error']"));
			 test.info("Verifying by passing the empty text");
			 Thread.sleep(3000);
			 if(recipientNameError.isDisplayed() && nameError.isDisplayed() && recipientMailError.isDisplayed() && confirmRecipientMail.isDisplayed()) {
				 test.pass("Succesfully errors are displayed when empty text is entered");
				 logger.info("Succesfully errors are displayed when empty text is entered");
			 }else {
				 test.fail(" Errors are not displayed when empty text is entered");
				 logger.info(" errors are not displayed when empty text is entered");
			 }
		  }	
		 	Thread.sleep(5000);
		}
	 @Test(priority = 2,dependsOnMethods = {"com.providio.testCases.Tc_GiftCard.giftCard"})
	 public void verifyFriendsNameNotPassed() throws InterruptedException {
		 
		 if(openGiftCertificatePage) {
			 
			 GiftCertificate  gc= new GiftCertificate (driver);
			 
			 gc.enterFriendsName("");
			 logger.info("Entered empty text");
			 
			 gc.enterFromName(faker.name().firstName());
			 logger.info("Entered name");
			
			 String email =faker.internet().emailAddress();
			 gc.enterFriendsMail( email);
			 logger.info("Entered email");
			 
			 gc.enterConfirmFriendsMail(email);
			 logger.info("Entered email");
			 
			 gc.addToCartButton();
			 
			 WebElement recipientNameError= driver.findElement(By.xpath("//div[@id='form-recipient-error']"));	
			 test.info("Verify if recipient name is not passed");
			 if(recipientNameError.isDisplayed()) {
				 test.pass("Successfully the error message is dispalyed when no recipient name is passed");
				 
			 }else {
				 test.fail("No message is dispalyed when no recipient name is passed");
			 }
		 }
		 Thread.sleep(5000);
	 }
	 
	 
	 @Test(priority = 3,dependsOnMethods = {"com.providio.testCases.Tc_GiftCard.giftCard"})
	 public void verifyNamesNotPassed() throws InterruptedException {
		 
		 if(openGiftCertificatePage) {
			 
			 GiftCertificate  gc= new GiftCertificate (driver);
			 
			 gc.enterFriendsName("");
			 logger.info("Entered empty text");
			 
			 gc.enterFromName("");
			 logger.info("Entered empty text");
			
			 String email =faker.internet().emailAddress();
			 gc.enterFriendsMail( email);
			 logger.info("Entered email");
			 
			 gc.enterConfirmFriendsMail(email);
			 logger.info("Entered email");
			 
			 gc.addToCartButton();
			 
			 WebElement recipientNameError= driver.findElement(By.xpath("//div[@id='form-recipient-error']"));	
			 WebElement nameError = driver.findElement(By.xpath("//div[@id='form-from-error']"));
			 
			 test.info("Verify if both the names is not passed");
			 if(recipientNameError.isDisplayed() &&  nameError.isDisplayed()) {
				 test.pass("Successfully the error message is dispalyed when no  names are passed");
				 
			 }else {
				 test.fail("No message is dispalyed when no name is passed");
			 }
		 }
		 Thread.sleep(5000);
	 }
	 
	 @Test(priority = 4,dependsOnMethods = {"com.providio.testCases.Tc_GiftCard.giftCard"})
	 public void verifyConfirmMail() throws InterruptedException {
		 
		 if(openGiftCertificatePage) {
			 
			 GiftCertificate  gc= new GiftCertificate (driver);
			 
			 gc.enterFriendsName(faker.name().firstName());
			 logger.info("Entered friends  name text");
			 
			 gc.enterFromName(faker.name().firstName());
			 logger.info("Entered  name text");
			
			
			 gc.enterFriendsMail("akhila@gmail.com");
			 logger.info("Entered email id");
			 
			 gc.enterConfirmFriendsMail("akhila@gmail.co");
			 logger.info("Entered email id");
			 
			 gc.addToCartButton();
			 
			 Thread.sleep(3000);
			 WebElement confirmEmailError = driver.findElement(By.xpath("//div[@id='form-email-confirm-error']"));
			 
			 test.info("Verify Confirm Mail");
			 if(confirmEmailError.isDisplayed()) {
				 
				 test.pass("Successfully the error message is dispalyed when different emails are passed");
				 
			 }else {
				 test.fail("No message is dispalyed when different emails are  passed");
			 }
		 }
		 Thread.sleep(5000);
	 }
	 
	 @Test(priority = 5,dependsOnMethods = {"com.providio.testCases.Tc_GiftCard.giftCard"})
	 public void verifyingEmailFormat() throws InterruptedException {
		 
		 if(openGiftCertificatePage) {
			 
			 GiftCertificate  gc= new GiftCertificate (driver);
			 
			 gc.enterFriendsName(faker.name().firstName());
			 logger.info("Entered friends  name text");
			 
			 gc.enterFromName(faker.name().firstName());
			 logger.info("Entered  name text");
			
			
			 gc.enterFriendsMail("Akhigmail.com");
			 logger.info("Entered email id");
			 
			 gc.enterConfirmFriendsMail("Akhigmail.com");
			 logger.info("Entered email id");
			 
			 gc.addToCartButton();
			

			 WebElement emailFormatError1= driver.findElement(By.xpath("//div[@id='form-recipientEmail-error']"));	
			 WebElement emailFormatError2= driver.findElement(By.xpath("//div[@id='form-email-confirm-error']"));	
			 
			 test.info("Verify email formats");
			 if(emailFormatError1.isDisplayed() && emailFormatError2.isDisplayed()) {
				 
				 test.pass("Successfully the error message is dispalyed when invalid email are passed");
				 
			 }else {
				 test.fail("No message is dispalyed when invalid email are  passed");
			 }
		 }
		 Thread.sleep(5000);
	 }
	
	 @Test(priority = 6,dependsOnMethods = {"com.providio.testCases.Tc_GiftCard.giftCard"})
	 public void addGiftCertificateToCart() throws InterruptedException {
		 
		 GiftCertificate gc= new GiftCertificate(driver);
		 gc.clickOnGiftCard(driver);
		 
		 //validating the gc add to car
		 test.info("Verifying the Gc add to cart ");
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));	
		 WebElement giftcerticatePopUp= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success add-to-basket-alert text-center']")));	
		   if(giftcerticatePopUp.isDisplayed()) {
				test.pass("Gift cetificate Product added to cart");
				logger.info("Product is  added to cart");
		    }else {
				test.fail("Product is not added to cart");
				logger.info("Product is not added to cart");
			}
	 }
	 
	 
}

