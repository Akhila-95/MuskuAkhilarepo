package com.RegUserWith_GcAndCC;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.commonfunctionality.Gc__CC_Paypal;
import com.providio.commonfunctionality.navigationProccess;
import com.providio.paymentProccess.tc__CheckOutProcess;
import com.providio.testcases.baseClass;

public class tc__OrderByGCandCC_RegUser extends baseClass {
	int minicartCountValue;
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void paypalFromCheckoutPage() throws InterruptedException {	

			// enters into url
		  if(isLoggedIn) {      
	    	 	

			// selects a random catgory and product add to cart
				navigationProccess navProccess = new navigationProccess();
				navProccess.commonNavigationProccess();
        
		    //common checkoutProcess	         
				tc__CheckOutProcess cp = new tc__CheckOutProcess();         
				cp.checkoutprocess();
				
			//semi gc and cc 
				Gc__CC_Paypal gCandCC = new Gc__CC_Paypal();
				gCandCC.paymentProccessByGCandCC(driver);
			     
		    }else {
		    	 Assert.fail("User not logged in");
		    }
	}
}
