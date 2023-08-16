package com.providio.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.pageObjects.ProductSetFromExcel;
import com.providio.pageObjects.SizeSelectionForProductSet;
import com.providio.paymentProccess.tc__CheckOutProcess;


public class tc__ProductSetForGuestUser extends baseClass{
	SoftAssert softAssert = new SoftAssert();

	 @Test
	public void productSet() throws InterruptedException {

		 	driver.get(baseURL);
		 	logger.info("Entered into url");
		 	
		 	Thread.sleep(2000);
		 	
		 	 WebElement minicartcount = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
		        String countOfMinicart = minicartcount.getText();
		        int minicartCountValue = Integer.parseInt(countOfMinicart);
		        
		        logger.info(minicartCountValue);
		
		 	//searching the product set from excel sheet
			ProductSetFromExcel fromExcel= new ProductSetFromExcel();
			fromExcel.performRandomOperations(driver);	
			logger.info("Searched for a productset");
			
			
			//selecting size for product
			SizeSelectionForProductSet set =new SizeSelectionForProductSet();
			set.sizeSelection(driver);
			logger.info("Selected size and added to cart");
			
			
			//validation for product add to cart			
			test.info("Verifying the product is added to cart or not ");	
			
			 WebElement minicartcountafteradding = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
		        String countOfMinicartafteradding = minicartcountafteradding.getText();
		        int minicartCountValueafteradding = Integer.parseInt(countOfMinicartafteradding);
		        
		        logger.info(minicartCountValueafteradding);
		        
		        logger.info(minicartCountValue);
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));		
	        WebElement productAddToCartMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success add-to-basket-alert text-center']"))); 
	        String messageText = productAddToCartMsg.getText();
	        System.out.println(messageText);
				if( productAddToCartMsg.isDisplayed()) {
					test.pass("Product added to cart");
					logger.info("Product is  added to cart");
				}else {
					test.fail("Product is not added to cart");
					logger.info("Product is not added to cart");
				}

				
		    //checkoutProcess		        
				tc__CheckOutProcess cp = new tc__CheckOutProcess();	         
	             cp.checkoutprocess();
	             
	             //pyament process
	        
	        

    
//			//validation of paypal window is working or not			  
//	    	WebElement ActualPaypalElement= driver.findElement(By.xpath("//div[@class='bt-credit-paypal']"));
//	    	String expectedPaypalWindow = "PayPal Credit";  		
//		    		if(ActualPaypalElement.getText().equals(expectedPaypalWindow)) {
//		    			test.pass("Paypal payment is proccessed");
//		    			logger.info("Paypal payment is proccessed");
//		    		}else {
//		    			test.fail("Paypal payment is stopped to   procces");
//		    			logger.info("Paypal payment is stopped to   procces");
//		    		}
	        } 
}

