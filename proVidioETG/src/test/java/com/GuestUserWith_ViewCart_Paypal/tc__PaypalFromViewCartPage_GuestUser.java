package com.GuestUserWith_ViewCart_Paypal;

import org.testng.annotations.Test;

import com.providio.commonfunctionality.navigationProccess;
import com.providio.paymentProccess.tc__CheckOutProcess;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__PaypalFromViewCartPage_GuestUser extends baseClass {
	int minicartCountValue;
	@Test
	public void paypalFromViewCartPage() throws InterruptedException {
		
		 //entered into url
			  driver.get(baseURL);
			  logger.info("Entered into url");
			  
		  // selects a random catgory and product add to cart
	          navigationProccess navProccess = new navigationProccess();
	          navProccess.commonNavigationProccess();
	          
	     
    	 //paypal checkout form view cart page
 	          tc__CheckOutProcessByPayPal paypal= new tc__CheckOutProcessByPayPal();	         
 	          paypal.checkoutprocessFromViewCart();
   
		        }

}
