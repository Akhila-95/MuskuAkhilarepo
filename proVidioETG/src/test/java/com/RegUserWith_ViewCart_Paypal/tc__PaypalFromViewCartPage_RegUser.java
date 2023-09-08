package com.RegUserWith_ViewCart_Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.commonfunctionality.navigationProccess;
import com.providio.paymentProccess.tc__CheckOutProcess;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__PaypalFromViewCartPage_RegUser extends baseClass {
	int minicartCountValue;
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void paypalFromViewCartPage() throws InterruptedException {
		
		  if(isLoggedIn) {    
			  
		// selects a random catgory and product add to cart
	          navigationProccess navProccess = new navigationProccess();
	          navProccess.commonNavigationProccess();
	          

 		 //checkoutProcess				        
	 	     tc__CheckOutProcess cp = new tc__CheckOutProcess();				     
	 	     cp.checkoutprocess();
	 	     
    	 //paypal checkout form view cart page
 	          tc__CheckOutProcessByPayPal paypal= new tc__CheckOutProcessByPayPal();	         
 	          paypal.checkoutprocessFromViewCart();   
		  }
		 else {
	    	 Assert.fail("User not logged in");
	    }
	}
}
