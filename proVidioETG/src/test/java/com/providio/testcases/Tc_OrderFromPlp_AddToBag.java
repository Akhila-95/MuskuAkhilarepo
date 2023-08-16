package com.providio.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.providio.pageObjects.AddToBag_FromPlp;
import com.providio.pageObjects.navigateAllTheMenusWithValidation;
import com.providio.pageObjects.navigationPage;
import com.providio.paymentProccess.tc__CheckOutProcess;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;

public class Tc_OrderFromPlp_AddToBag extends baseClass{
@Test
	public void orderFromPlp_AddToBag() throws InterruptedException {
	
	//entered into url
		driver.get(baseURL);
		logger.info("Entered into url");
		
	//navigated to random page	
		navigationPage navPage =new navigationPage(driver);
		navPage.selectRandomMenu(driver);
		logger.info("Entered into plp page");
		
   //validate the landed plp page
//		navigateAllTheMenusWithValidation navValidation = new navigateAllTheMenusWithValidation(driver);
//		navValidation.goingThroughAlltheMenus(driver);
//		
		
	//The cart value before adding the product to cart
		Thread.sleep(2000);
        WebElement minicartcount = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
        String countOfMinicart = minicartcount.getText();
        int minicartCountValue = Integer.parseInt(countOfMinicart);
        logger.info("The minicart count before adding the product is "+minicartCountValue);
		
    //to know which plp page 
        	if(driver.findElements(By.xpath("//h1[@class ='page-title']")).size()!=0) {
        		  WebElement categoryPage = driver.findElement(By.xpath("//h1[@class ='page-title']"));
        		  System.out.println("Navigated to "+categoryPage.getText());
        	}else if(driver.findElements(By.xpath("//h1[@class ='header page-title text-uppercase m-0 p-0']")).size()!=0) {
        		 WebElement categoryPage2 = driver.findElement(By.xpath("//h1[@class ='header page-title text-uppercase m-0 p-0']"));
        		 System.out.println("Navigated to "+categoryPage2.getText() );
        	}
        
        
	
		 AddToBag_FromPlp  addToBag=new  AddToBag_FromPlp ();
		 addToBag.addToBag_FromPlp(driver);
		 
	//adding product from plp to cart by Add to bag button	 
		 WebElement minicartcountafteradding = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
         String countOfMinicartafteradding = minicartcountafteradding.getText();
         int minicartCountValueafteradding = Integer.parseInt(countOfMinicartafteradding);

         logger.info("Minicart count after the product is "+minicartCountValueafteradding);



	  //validation for product add to cart
	      test.info("Verifying the product is added to cart or not ");
	
	
	
	      if( minicartCountValueafteradding!= minicartCountValue) {
	          test.pass("Product added to cart");
	          logger.info("Product is  added to cart");
	      }else {
	          test.fail("Product is out of stock ");
	          logger.info("Product is not added to cart");
	      }
	      
	      tc__CheckOutProcess checkout = new  tc__CheckOutProcess();
	      checkout.checkoutprocess();
	      
	      tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();
	      cc.paymentByCreditCard();
	      
	      
	}
}
