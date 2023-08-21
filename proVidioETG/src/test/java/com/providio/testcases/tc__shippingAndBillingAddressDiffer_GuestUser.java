package com.providio.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productListingPage;

public class tc__shippingAndBillingAddressDiffer_GuestUser extends baseClass{

	public void shippingAndBillingAddressDiffer() throws InterruptedException {
		 
		driver.get(baseURL);
		  //naviagated into random menu
		navigationPage navPage= new navigationPage(driver);
		navPage.selectRandomMenu(driver);
		logger.info("Entered into menu");
	
	//plp page	
		productListingPage plp = new productListingPage(driver);
		plp.selectProductRandom(driver);
		logger.info("Entered into plp page");

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
        
	}
}
