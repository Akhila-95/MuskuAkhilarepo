package com.providio.payments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.commonfunctionality.navigationProccess;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productListingPage;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.testcases.baseClass;
import com.providio.testcases.size;

public class tc__PaypalFromViewCartPage_RegUser extends baseClass {
	
	int minicartCountValue =0;
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void paypalFromViewCartPage() throws InterruptedException {
		
		if(isLoggedIn) {
			
		// selects a random catgory and product add to cart
	          navigationProccess navProccess = new navigationProccess();
	          navProccess.commonNavigationProccess();
	          
		 //paypal checkout form view cart page
	        tc__CheckOutProcessByPayPal paypal= new tc__CheckOutProcessByPayPal();	        
	        paypal.checkoutprocessFromViewCart();
	        logger.info("clicked on viewcart paypal button");	
	        
		}else{			 
			   Assert.fail("User not logged in");
			}		
	}	
}
