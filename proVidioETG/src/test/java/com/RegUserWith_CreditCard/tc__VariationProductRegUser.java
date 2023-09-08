package com.RegUserWith_CreditCard;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.pageObjects.SizeSelectioForVariation;
import com.providio.pageObjects.VariationProductFromExcel;
import com.providio.paymentProccess.tc__CheckOutProcess;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;


public class tc__VariationProductRegUser extends baseClass{
	SoftAssert softAssert = new SoftAssert();

	 @Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void variationProduct() throws InterruptedException {
		 
		 if(isLoggedIn) {

			 Thread.sleep(3000);
			 //serached for variation product
			VariationProductFromExcel fromExcel = new VariationProductFromExcel();
			fromExcel.performRandomOperations(driver);
			logger.info("searched for Variation product");
	
	
			SizeSelectioForVariation ss= new SizeSelectioForVariation();
			ss.sizeSelection(driver);
			logger.info("Product added to cart");
			
			//validation for product add to cart
			
			test.info("Verifying the product is added to cart or not ");
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));		
	        WebElement productAddToCartMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success add-to-basket-alert text-center']")));
	        String messageText = productAddToCartMsg.getText();
	        System.out.println(messageText);
				if( productAddToCartMsg.isDisplayed()) {
					test.pass("Product added to cart");
					logger.info("Product is  added to cart");
				}else {
					test.fail("Product is not added to cart");
					logger.info("Product is not added to cart");
				}
			
         //checkoutProcess
	        
            tc__CheckOutProcess cp = new tc__CheckOutProcess();          
            cp.checkoutprocess();
            
            //payment process
//            
		     tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();
		     
		     cc.paymentByCreditCard();


		 }
		 
		  else {
		        Assert.fail("User not logged in");
		    }
	 }
}

