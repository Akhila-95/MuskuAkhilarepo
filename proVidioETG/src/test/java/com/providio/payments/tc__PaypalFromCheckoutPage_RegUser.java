package com.providio.payments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productListingPage;
import com.providio.paymentProccess.tc__CheckOutProcess;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.testcases.baseClass;
import com.providio.testcases.size;

public class tc__PaypalFromCheckoutPage_RegUser extends baseClass {
	int minicartCountValue;
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void paypalFromCheckoutPage() throws InterruptedException {
	
	     if(isLoggedIn) { 

	          navigationPage navPage =new navigationPage(driver);
	    	  navPage.selectRandomMenu(driver);
	    	 
	    	  productListingPage plp = new productListingPage(driver);
	    	  plp.selectProductRandom(driver);
   
	    	  //The cart value before adding the product to cart
	    	    Thread.sleep(2000);
	    		 List<WebElement> minicartcountList = driver.findElements(By.cssSelector(".minicart-quantity"));
	    		 if(minicartcountList.size()>0) {
	    			 WebElement minicartcount = driver.findElement(By.cssSelector(".minicart-quantity"));
	    			 String countOfMinicart = minicartcount.getText();

	             // Check if the string is not empty and contains only digits
	             if (!countOfMinicart.isEmpty() && countOfMinicart.matches("\\d+")) {
	                minicartCountValue = Integer.parseInt(countOfMinicart);
	                 System.out.println("The minicart count before adding the product is " + minicartCountValue);    		
	              }
	    		 }
          
	    		 List<WebElement> pdpPage = driver.findElements(By.xpath("//button[contains(@class,'add-to-cart btn btn-primary')]"));
	    		 if( pdpPage.size()>0) {
			          size s = new size();
			          s.selectSize(driver);
		    		 }
          
	    		 if(minicartcountList.size()>0) {
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
		        
		    		 }        
		    // common checkoutProcess	         
				tc__CheckOutProcess cp = new tc__CheckOutProcess();         
				cp.checkoutprocess();
	         
			//paypal process from chechout
				tc__CheckOutProcessByPayPal cpp = new tc__CheckOutProcessByPayPal();
				cpp.checkoutprocessFromCheckout();
	     }else {
	    	 Assert.fail("User not logged in");
	     }
	}
}
