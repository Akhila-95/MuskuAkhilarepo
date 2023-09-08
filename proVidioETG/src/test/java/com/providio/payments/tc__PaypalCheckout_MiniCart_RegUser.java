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

public class tc__PaypalCheckout_MiniCart_RegUser extends baseClass {
	 int  minicartCountValue;
@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void paypalCheckout_MiniCart() throws InterruptedException {

	if(isLoggedIn) {
	     
		 // selects a random catgory and product add to cart
	        navigationProccess navProccess = new navigationProccess();
	        navProccess.commonNavigationProccess();
        
	     //checkout from mini cart by paypal	        
	        tc__CheckOutProcessByPayPal checkOutProcessByPayPal= new tc__CheckOutProcessByPayPal();
	        checkOutProcessByPayPal. checkoutprocessFromMiniCart() ;

		}  else {
			 Assert.fail("User not logged in");
		}
	        
	}

}
