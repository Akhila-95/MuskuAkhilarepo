package com.GuestUserWith_Minicart_Paypal;

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

public class tc__PaypalCheckout_MiniCart_GuestUser extends baseClass {
	int  minicartCountValue=0;
@Test
	public void paypalCheckout_MiniCart() throws InterruptedException {
		
			     driver.get(baseURL);
		         logger.info("enterd into url");
		       
		     //selects a random catgory and product add to cart
		         navigationProccess navProccess = new navigationProccess();
		         navProccess.commonNavigationProccess();
		    
	         //checkout from mini cart by paypal	        
		        tc__CheckOutProcessByPayPal checkOutProcessByPayPal= new tc__CheckOutProcessByPayPal();
		        checkOutProcessByPayPal. checkoutprocessFromMiniCart();
	}

}
