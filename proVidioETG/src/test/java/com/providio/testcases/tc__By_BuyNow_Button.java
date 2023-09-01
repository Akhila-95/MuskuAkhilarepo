package com.providio.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.providio.pageObjects.homePage;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.pageObjects.productListingPage;
import com.providio.paymentProccess.tc__CheckOutProcess;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;

public class tc__By_BuyNow_Button extends baseClass{
	@Test
	public void byNowButton() throws InterruptedException {
		
	//step2 1: site url
		driver.get(baseURL);
		
		
    //Home page 
		 navigationPage navPage =new navigationPage(driver);
    	 navPage.selectRandomMenu(driver);
    	 
    	 productListingPage plp = new productListingPage(driver);
    	 plp.selectProductRandom(driver);
    	 
    	 size s =new size();
    	 s.clickOnBuyNow(driver);
    	 //buy now validation
//	    	 test.info("Verifying buy now button");
//	    	 WebElement buyNowEnabled =driver.findElement(By.xpath("//button[contains(@class,'buy-now')]"));
//		    	 if(buyNowEnabled.isEnabled()&& buyNowEnabled.isDisplayed()) {
//		    		 test.pass("Selected size and Clicked on buy now button");
//		    	 }else {
//		    		 test.fail("Not Clicked on buy now button");
//		    	 }

     //checkoutProcess       
        tc__CheckOutProcess cp = new tc__CheckOutProcess();            
        cp.checkoutprocess();
        
     //payment process
        tc__CreditCardPaymentProcess tc = new tc__CreditCardPaymentProcess();			              
        tc.paymentByCreditCard();
        
        

        
        
	}
}
