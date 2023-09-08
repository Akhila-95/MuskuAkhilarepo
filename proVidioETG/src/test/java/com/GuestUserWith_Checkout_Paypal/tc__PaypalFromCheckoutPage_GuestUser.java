package com.GuestUserWith_Checkout_Paypal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.providio.commonfunctionality.navigationProccess;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productListingPage;
import com.providio.paymentProccess.tc__CheckOutProcess;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.testcases.baseClass;
import com.providio.testcases.size;

public class tc__PaypalFromCheckoutPage_GuestUser extends baseClass {
	int  minicartCountValue=0;
	@Test
	public void paypalFromCheckoutPage() throws InterruptedException {
	
	       
			  driver.get(baseURL);	
			  test.info("Entered into url");
		   
		  // selects a random catgory and product add to cart
	          navigationProccess navProccess = new navigationProccess();
	          navProccess.commonNavigationProccess();
	          
	        
		  // common checkoutProcess	         
			 tc__CheckOutProcess cp = new tc__CheckOutProcess();         
			 cp.checkoutprocess();
	         
		 //paypal process from checkout page
			 tc__CheckOutProcessByPayPal cpp = new tc__CheckOutProcessByPayPal();
			 cpp.checkoutprocessFromCheckout();
		
	}
}
