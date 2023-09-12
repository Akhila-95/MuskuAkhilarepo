package com.RegUserWith_MiniCart_Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.commonfunctionality.navigationProccess;
import com.providio.paymentProccess.tc__CheckOutProcess;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__PaypalReg_InMC_Paypal extends baseClass {
	int  minicartCountValue=0;
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void paypalFromCheckoutPage() throws InterruptedException {
	
		if(isLoggedIn) {      

		  // selects a random catgory and product add to cart
	          navigationProccess navProccess = new navigationProccess();
	          navProccess.commonNavigationProccess();
	          
	  
		 //checkout from mini cart by paypal	        
	         tc__CheckOutProcessByPayPal checkOutProcessByPayPal= new tc__CheckOutProcessByPayPal();
	         checkOutProcessByPayPal. checkoutprocessFromMiniCart();
	    }else {
	   	 Assert.fail("User not logged in");
	   }
	}
}
