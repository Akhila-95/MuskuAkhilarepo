package com.RegUserWith_CreditCard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.pageObjects.BundleProductFromEXcel;
import com.providio.paymentProccess.tc__CheckOutProcess;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;


public class tc__BundleProductRegUser_InCC extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	int  minicartCountValue;
	 @Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void bundleProduct() throws InterruptedException {
		
	if(isLoggedIn) {
		//the count of the cart before adding the product into cart
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
		//searching the bundle product from excel sheet
		     BundleProductFromEXcel bundleProduct = new  BundleProductFromEXcel();		 
			 bundleProduct.performRandomOperations(driver);
			 test.info("Searched a bundle product");

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
		 	 //common checkout process
             tc__CheckOutProcess cp = new tc__CheckOutProcess();        
             cp.checkoutprocess();
             
             //payment process             
		     tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();		     
		     cc.paymentByCreditCard();

	 } else {
	        Assert.fail("User not logged in");
	    }
	 }
}

