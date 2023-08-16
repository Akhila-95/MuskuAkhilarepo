package com.providio.payments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productListingPage;
import com.providio.paymentProccess.tc__CheckOutProcess;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.testcases.baseClass;
import com.providio.testcases.size;

public class tc__PaypalFromCheckoutPage_GuestUser extends baseClass {

	@Test
	public void paypalFromCheckoutPage() throws InterruptedException {
	
	       
			driver.get(baseURL);
	        navigationPage navMenu = new navigationPage(driver);
	        navMenu.clickwoMensMenubaritems(driver);
	        logger.info("hovered on Womens");
	        
	        navMenu.ClickwoMensofBraceletss(driver);
	        logger.info("clicked on Braceletss  sub menu");
	        
	        //validate the Television
	        WebElement braclets = driver.findElement(By.xpath("//h1[@class ='page-title']"));
	        String ActualTitleofBraclets =braclets.getText();
	        String ExpectedTitleofBraclets = "BRACELETS";
	        logger.info(braclets .getText());
	        if (ActualTitleofBraclets.equals(ExpectedTitleofBraclets)) {
	            test.pass( "Successfully clicked on the womens of  " + ActualTitleofBraclets + " ");
	            logger.info("Successfully clicked on the womens of  " + ActualTitleofBraclets + " ");
	        } else {
	            test.fail( "The page Title does not match expected " + ExpectedTitleofBraclets + " " + "  but found" + " " + ActualTitleofBraclets + " ");
	            logger.info( "The page Title does not match expected " + ExpectedTitleofBraclets + " " + "  but found" + " " + ActualTitleofBraclets + " ");
	        }

	        
	        productListingPage plp = new productListingPage(driver);
	        plp.clickOnProduct(driver);
	       // plp.selectProductRandom(driver);
	        logger.info("clicked on earings product");
	        
    
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
	         
			//paypal process from chechout
				tc__CheckOutProcessByPayPal cpp = new tc__CheckOutProcessByPayPal();
				cpp.checkoutprocessFromCheckout();
		
	}
}
