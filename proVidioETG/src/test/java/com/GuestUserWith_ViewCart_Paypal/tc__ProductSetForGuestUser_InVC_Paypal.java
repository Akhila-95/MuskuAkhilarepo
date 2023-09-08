package com.GuestUserWith_ViewCart_Paypal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.pageObjects.ProductSetFromExcel;
import com.providio.pageObjects.SizeSelectionForProductSet;
import com.providio.paymentProccess.tc__CheckOutProcess;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.testcases.baseClass;
public class tc__ProductSetForGuestUser_InVC_Paypal extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	int minicartCountValue;
	 @Test
	public void productSet() throws InterruptedException {

		 	driver.get(baseURL);
		 	logger.info("Entered into url");
		 	
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
		
		 	//searching the product set from excel sheet
			ProductSetFromExcel fromExcel= new ProductSetFromExcel();
			fromExcel.performRandomOperations(driver);	
			logger.info("Searched for a productset");
			
			
			//selecting size for product
			SizeSelectionForProductSet set =new SizeSelectionForProductSet();
			set.sizeSelection(driver);
			logger.info("Selected size and added to cart");
			
			
			// minicart count
	 	 	if(minicartcountList.size()>0) {
	          WebElement minicartcountafteradding = driver.findElement(By.cssSelector(".minicart-quantity"));
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
		  
	            
	         //paypal checkout form view cart page
	 	         tc__CheckOutProcessByPayPal paypal= new tc__CheckOutProcessByPayPal();	         
	 	         paypal.checkoutprocessFromViewCart();

	        } 
}

