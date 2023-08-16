package com.providio.payments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productListingPage;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.testcases.baseClass;
import com.providio.testcases.size;

public class tc__PaypalFromPDPpage_RegUser extends baseClass{

	@Test
	public void paypalFromPDPpage() throws InterruptedException {
		
	if(isLoggedIn) {
			
		//naviagated into random menu
			navigationPage navPage= new navigationPage(driver);
			navPage.selectRandomMenu(driver);
			logger.info("Entered into menu");
		
		//plp page	
			productListingPage plp = new productListingPage(driver);
			plp.selectProductRandom(driver);
			logger.info("Entered into plp page");
			
		//minicart count
			//The cart value before adding the product to cart
			Thread.sleep(2000);
	        WebElement minicartcount = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
	        String countOfMinicart = minicartcount.getText();
	        int minicartCountValue = Integer.parseInt(countOfMinicart);
	        logger.info("The minicart count before adding the product is "+minicartCountValue);
			

	  //paypal buy now button
	        
	        size s = new size();
			s.paypalBuyNowFromPDP(driver);
		
		//paypal checkout procces
			tc__CheckOutProcessByPayPal paypal= new tc__CheckOutProcessByPayPal();
	        Thread.sleep(5000);
	        paypal.paypalCheckoutFromPDP();
	        logger.info("clicked on PDP  paypal BUY NOW button");

		}else {
			 Assert.fail("User not logged in");
		}
	}
}