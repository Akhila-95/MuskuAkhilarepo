package com.RegUserWith_CreditCard;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.pageObjects.SimpleProductFromExcel;
import com.providio.paymentProccess.tc__CheckOutProcess;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;


public class tc__SimpleProductRegUser extends baseClass{
	SoftAssert softAssert = new SoftAssert();

	 @Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void simpleProduct() throws InterruptedException {
		 
		 
	if(isLoggedIn) {
		
		 WebElement minicartcount = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
	        String countOfMinicart = minicartcount.getText();
	        int minicartCountValue = Integer.parseInt(countOfMinicart);
	        
	        logger.info(minicartCountValue);
		
		
		SimpleProductFromExcel  simpleProduct = new SimpleProductFromExcel ();	
		
		simpleProduct.performRandomOperations(driver);
		
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
        
        //checkoutProcess
        
        tc__CheckOutProcess cp = new tc__CheckOutProcess();
        
        cp.checkoutprocess();

        
        //payment process
        
	     tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();
	     
	     cc.paymentByCreditCard();
        

	
	        }

	  else {
	        Assert.fail("User not logged in");
	    }
	 }
}

