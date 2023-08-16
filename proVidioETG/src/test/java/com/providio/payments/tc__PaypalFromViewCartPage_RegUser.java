package com.providio.payments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productListingPage;
import com.providio.paymentProccess.tc__CheckOutProcessByPayPal;
import com.providio.testcases.baseClass;
import com.providio.testcases.size;

public class tc__PaypalFromViewCartPage_RegUser extends baseClass {
	
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void paypalFromViewCartPage() throws InterruptedException {
		
		if(isLoggedIn) {
		    //into categories
	        navigationPage navMenu = new navigationPage(driver);
	        navMenu.clickwoMensMenubaritems(driver);
	        logger.info("hovered on Womens");
	        
	        navMenu.ClickwoMensofBraceletss(driver);
	        logger.info("clicked on Braceletss  sub menu");

//			navigationPage navPage =new navigationPage(driver);
//			navPage.selectRandomMenu(driver);
//			
			productListingPage plp = new productListingPage(driver);
//			plp.selectProductRandom(driver);
//			
    	//The cart value before adding the product to cart
    		Thread.sleep(2000);
            WebElement minicartcount = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
            String countOfMinicart = minicartcount.getText();
            int minicartCountValue = Integer.parseInt(countOfMinicart);
            logger.info("The minicart count before adding the product is "+minicartCountValue);
    		

	        plp.clickOnProduct(driver);
	       // plp.selectProductRandom(driver);
	        logger.info("clicked on earings product");
	        
	        size s = new size();
	        s.selectSize(driver);
	        		
//	        productDescriptionPage pdp = new productDescriptionPage(driver);
//	        pdp.clickcartbutton(driver);
	        logger.info("click on the add to cart button");
	        	     
	      
		    //paypal checkout form view cart page
	        tc__CheckOutProcessByPayPal paypal= new tc__CheckOutProcessByPayPal();
	        Thread.sleep(3000);
	        paypal.checkoutprocessFromViewCart();
	        logger.info("clicked on viewcart paypal button");	
	        
		} else {			 
			        Assert.fail("User not logged in");
			}		
	}	
}
