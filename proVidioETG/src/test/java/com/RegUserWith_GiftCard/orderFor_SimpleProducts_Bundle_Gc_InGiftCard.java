package com.RegUserWith_GiftCard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.pageObjects.BundleProductFromEXcel;
import com.providio.pageObjects.GiftCertificate;
import com.providio.pageObjects.SimpleProductFromExcel;
import com.providio.paymentProccess.tc__CheckOutProcess;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;

public class orderFor_SimpleProducts_Bundle_Gc_InGiftCard extends baseClass {
	int minicartCountValue;
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void simpleProducts_Bundle_Gc() throws InterruptedException {
		
		  if(isLoggedIn) {      
	    	 	
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
		 //adding simple product into cart
		 SimpleProductFromExcel  simpleProduct = new SimpleProductFromExcel();	
		 simpleProduct.performRandomOperations(driver);
		 test.info("Searched for  simple product");
		 
		 //adding GC into cart
		 for(int i=1; i<=1;i++) {
			 GiftCertificate gc= new  GiftCertificate(driver);
			 gc.clickOnGiftCard(driver);
			 test.info("Gift card added to cart");
		 }		
		 //searching the bundle product from excel sheet
		 BundleProductFromEXcel bundleProduct = new  BundleProductFromEXcel();
		 bundleProduct.performRandomOperations(driver);
		 logger.info("Searched a bundle  product");
		
		 
		// minicart count after adding products
		 if(minicartcountList.size()>0) {
          WebElement minicartcountafteradding = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
          String countOfMinicartafteradding = minicartcountafteradding.getText();
          int minicartCountValueafteradding = Integer.parseInt(countOfMinicartafteradding);

	      logger.info("The minicart count after adding the product is "+minicartCountValueafteradding);

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
		
		 //checkoutProcess				        
	     tc__CheckOutProcess cp = new tc__CheckOutProcess();				     
	     cp.checkoutprocess();
	     
	     //gc payment 
	     Gc__CC_Paypal gc = new Gc__CC_Paypal ();
	     gc.paymentByGiftCard();
	     
		    }else {
		    	 Assert.fail("User not logged in");
		    }
  }
}
