												package com.providio.payments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productListingPage;
import com.providio.paymentProccess.tc__CheckOutProcess;
import com.providio.paymentProccess.tc__PaymentProccessByGC;
import com.providio.testcases.baseClass;
import com.providio.testcases.size;

public class tc__OrderByGc_GuestUser extends baseClass {
	int minicartCountValue;
	@Test
	public void paymentByGiftCardInGuestUser() throws InterruptedException  {
	
		      driver.get(this.baseURL);
	          logger.info("enterd into url");	       
	          navigationPage navPage =new navigationPage(driver);
	    	  navPage.selectRandomMenu(driver);
	    	 
	    	  productListingPage plp = new productListingPage(driver);
	    	  plp.selectProductRandom(driver);
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
    
		    //checkoutProcess				        
			     tc__CheckOutProcess cp = new tc__CheckOutProcess();				     
			     cp.checkoutprocess();
 
		     //payment by GC 				     
			     tc__PaymentProccessByGC code= new tc__PaymentProccessByGC();
			     //code.performRandomOperations(driver);				     
				 code.performSequentialOperations(driver);						
				 logger.info("applied gift card code");
				 test.info("Gc code applied");
			 
		     
		}
}
