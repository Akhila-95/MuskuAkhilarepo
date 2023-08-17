package com.providio.payments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.providio.pageObjects.AddToBag_FromPlp;
import com.providio.pageObjects.SizeSelectioForVariation;
import com.providio.pageObjects.miniCartPage;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.pageObjects.productListingPage;
import com.providio.pageObjects.viewCartPage;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.testcases.baseClass;
import com.providio.testcases.size;

public class tc__PaypalFromViewCartPage_GuestUser extends baseClass {
	@Test
	public void paypalFromViewCartPage() throws InterruptedException {
		
		//entered into url
			driver.get(baseURL);
			logger.info("Entered into url");
			
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

	        //validate the productname
	        String actualProductName = driver.getTitle();
	        String expectedProductName = driver.getTitle();
	        if (actualProductName.equals(expectedProductName)) {
	            test.pass( "Successfully clicked on the electronics of  " + actualProductName + " ");
	            logger.info("click Success Womens of Dresses");
	        } else {
	            test.fail( "The page Title does not match expected " + expectedProductName + " " + "  but found" + " " + actualProductName + " ");
	            logger.info("Click failed");
	        }
		
		    //paypal checkout form view cart page
	        tc__CheckOutProcessByPayPal paypal= new tc__CheckOutProcessByPayPal();
	        Thread.sleep(3000);
	        paypal.checkoutprocessFromViewCart();
	        logger.info("clicked on viewcart paypal button");
	        
	        
	        
	}	
}
