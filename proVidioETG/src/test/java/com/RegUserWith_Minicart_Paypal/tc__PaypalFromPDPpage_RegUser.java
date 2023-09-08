package com.RegUserWith_Minicart_Paypal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productListingPage;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.testcases.baseClass;
import com.providio.testcases.size;

public class tc__PaypalFromPDPpage_RegUser  extends baseClass{
	int minicartCountValue;
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
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
	   //paypal buy now button
	        
	    		 List<WebElement> paypalbuyNowPdp =driver.findElements(By.xpath("//div[contains(@class,'salesforce-buynow-element ')]"));
	    		 if( paypalbuyNowPdp.size()>0) {
	    			 
	    			    size s = new size();	    			    
	    				s.paypalBuyNowFromPDP(driver);	    				

    				//paypal checkout procces
    					tc__CheckOutProcessByPayPal paypal= new tc__CheckOutProcessByPayPal();
    			        Thread.sleep(5000);
    			        paypal.paypalCheckoutFromPDP();
		    		 }
	    		 else {
	    			 test.pass("Paypal buy now is only in salsforce payment not in cybersource and brain tree");
	    		 }
	       
		  }else {
		    	 Assert.fail("User not logged in");
		    }
	}
}
