package com.providio.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.pageObjects.homePage;
import com.providio.paymentProccess.tc__CheckOutProcess;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;

public class tc__WishListtoAddtoCart extends baseClass {
	
	SoftAssert softAssert = new SoftAssert();

	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
    public void wishListtoCart() throws InterruptedException {

    	tc__WishlistProccess wsh = new tc__WishlistProccess();
    	
    	wsh.wishlistPage(driver);
    	
        //checkout process
    	Thread.sleep(5000);
    	
        tc__CheckOutProcess cp = new tc__CheckOutProcess();
        
        cp.checkoutprocess();
        
        //payment process
        
        tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();
        
        cc.paymentByCreditCard(); 
    	
    }
	
}