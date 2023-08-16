package com.providio.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.pageObjects.SizeSelectioForVariation;
import com.providio.pageObjects.VariationProductFromExcel;
import com.providio.paymentProccess.tc__CheckOutProcess;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;


public class tc__VariationProductForGuestUser extends baseClass{
	SoftAssert softAssert = new SoftAssert();

	 @Test
	public void variationProduct() throws InterruptedException {
		 
			 driver.get(baseURL);
			 logger.info("Entered into url");
			 
			 
			 Thread.sleep(2000);
			 WebElement minicartcount = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
	         String countOfMinicart = minicartcount.getText();
	         int minicartCountValue = Integer.parseInt(countOfMinicart);	        
	         logger.info(minicartCountValue);
	         
			 //searched for variation product
			 VariationProductFromExcel fromExcel = new VariationProductFromExcel();
			 fromExcel.performRandomOperations(driver);
			 logger.info("searched for Variation product");

			 WebElement minicartcountafteradding = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
	         String countOfMinicartafteradding = minicartcountafteradding.getText();
	         int minicartCountValueafteradding = Integer.parseInt(countOfMinicartafteradding);	        
	         logger.info(minicartCountValueafteradding);

			//validation for product add to cart
			test.info("Verifying the product is added to cart or not ");

			if( minicartCountValueafteradding!= minicartCountValue) {
				test.pass("Product added to cart");
				logger.info("Product is  added to cart");
			}else {
				test.fail("Product is not added to cart");
				logger.info("Product is not added to cart");
			}
	        
			
		     //checkoutProcess	        
				tc__CheckOutProcess cp = new tc__CheckOutProcess();         
				cp.checkoutprocess();
	         
			//paypal process	
				tc__CheckOutProcessByPayPal cpp = new tc__CheckOutProcessByPayPal();
				cpp.checkoutprocessFromCheckout();
				
				
	         //payment by credit card

//		     tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();	     
//		     cc.paymentByCreditCard();


	 }
}

