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
	int minicartCountValue;
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
			
			//The cart value before adding the product to cart
			 //The cart value before adding the product to cart
    		Thread.sleep(2000);
    		 WebElement minicartcount = driver.findElement(By.xpath("//span[@class='minicart-quantity ml-1']"));
             String countOfMinicart = minicartcount.getText();

             // Check if the string is not empty and contains only digits
             if (!countOfMinicart.isEmpty() && countOfMinicart.matches("\\d+")) {
                minicartCountValue = Integer.parseInt(countOfMinicart);
                 System.out.println("The minicart count before adding the product is " + minicartCountValue);    		
             }
    		
	
	        size s = new size();
	        s.selectSize(driver);

	      

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
	        
		    //paypal checkout form view cart page
	        tc__CheckOutProcessByPayPal paypal= new tc__CheckOutProcessByPayPal();
	        Thread.sleep(3000);
	        paypal.checkoutprocessFromViewCart();
	        logger.info("clicked on viewcart paypal button");
	        
	        
	        
	}	
}
