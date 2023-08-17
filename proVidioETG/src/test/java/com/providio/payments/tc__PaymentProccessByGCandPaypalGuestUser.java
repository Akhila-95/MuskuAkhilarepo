package com.providio.payments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productListingPage;
import com.providio.paymentProccess.tc__CheckOutProcess;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.paymentProccess.tc__PaymentProccessByGC;
import com.providio.testcases.baseClass;
import com.providio.testcases.size;

public class tc__PaymentProccessByGCandPaypalGuestUser extends baseClass {

	@Test
	public void paypalFromCheckoutPage() throws InterruptedException {	
	       
			driver.get(baseURL);
	       
	        navigationPage navPage =new navigationPage(driver);
	    	 navPage.selectRandomMenu(driver);
	    	 
	    	 productListingPage plp = new productListingPage(driver);
	    	 plp.selectProductRandom(driver);
 
    
	        //pdp page
          Thread.sleep(2000);
          WebElement minicartcount = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
          String countOfMinicart = minicartcount.getText();
          int minicartCountValue = Integer.parseInt(countOfMinicart);
          logger.info(minicartCountValue);
          
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
	        
		    // common checkoutProcess	         
				tc__CheckOutProcess cp = new tc__CheckOutProcess();         
				cp.checkoutprocess();
			//semi gc 
				tc__PaymentProccessByGC code= new tc__PaymentProccessByGC();				
				code.paymentBySemiGC();					
				logger.info("applied gift card code ");

			//paypal process from chechout
				tc__CheckOutProcessByPayPal cpp = new tc__CheckOutProcessByPayPal();
				cpp.checkoutprocessFromCheckout();
		
	}
}
