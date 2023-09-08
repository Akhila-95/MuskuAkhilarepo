												package com.GuestUserWith_GiftCard;

import org.testng.annotations.Test;

import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.commonfunctionality.navigationProccess;
import com.providio.paymentProccess.tc__CheckOutProcess;
import com.providio.testcases.baseClass;

public class tc__OrderByGc_GuestUser extends baseClass {
	int minicartCountValue;
	@Test
	public void paymentByGiftCardInGuestUser() throws InterruptedException  {
			  // enters into url
			      driver.get(baseURL);		      
		          logger.info("enterd into url");	
	          
	          // selects a random catgory and product add to cart
		          navigationProccess navProccess = new navigationProccess();
		          navProccess.commonNavigationProccess();
	          
	          //checkoutProcess				        
			     tc__CheckOutProcess cp = new tc__CheckOutProcess();				     
			     cp.checkoutprocess();
			     
			  //gc payment 
			     Gc__CC_Paypal gc = new Gc__CC_Paypal ();
			     gc.paymentByGiftCard();
			   
			     
		}
}
