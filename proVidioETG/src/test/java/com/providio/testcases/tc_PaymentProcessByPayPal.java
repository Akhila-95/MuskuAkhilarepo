package com.providio.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.providio.pageObjects.paymentpPage;
import com.providio.pageObjects.reviewOrderPage;

public class tc_PaymentProcessByPayPal extends baseClass{
	
	public void paymentByPaypal() throws InterruptedException {
		
	//payment page
		
		List<WebElement> continueasAGuest = driver.findElements(By.xpath("//button[contains(text(),'Guest Checkout')]"));
        logger.info(" Logged in as guest :  "  +continueasAGuest.size());
		paymentpPage pp = new paymentpPage(driver);		
		//pp.clickOnPaypal(driver);		
		logger.info("Clicked on payapal ");		
		List<WebElement> savedPaypalAcc = driver.findElements(By.xpath("//option[@id ='braintreePaypalAccount']"));   	
    	System.out.println(savedPaypalAcc.size());   	
	    	if(savedPaypalAcc.size()>0) {
	    		
	    			logger.info("Account is already added,select it ");
	    		
	    	}else {
	    		
			Thread.sleep(5000);
	    	}
	    		if(continueasAGuest.size()>0) {
	    		
		    		pp.braintreePaypal(driver);
		    		
		    		logger.info("clicked on paypal button");
		    		
		    		pp.paypalPopup(driver);
		    		
		    		logger.info("popped up the paypal window");
	    		
	    		}
	    		
 
    	// review order page
    		reviewOrderPage rop = new reviewOrderPage(driver);
    		if(driver.findElements(By.xpath("//button[contains(text(), 'Next: Review Order')]")).size()!=0) {
	    	//	rop.clickonplaceorder(driver);
	    		logger.info("Clicked on review order button");
	    		Thread.sleep(2000);
    		}else {
    			logger.info("Paypal checkout as reg user");
    		}
    		
    		if (driver.findElements(By.xpath("//button[contains(text(), 'Place Order')]")).size()!=0) {   		
	    		rop.clickonplaceorderwithJsExuter(driver);		
	    		logger.info("successfully click on the place order button");
	    		}
		
		Thread.sleep(10000);
		
		//validate the orderstatus
	    WebElement PlacetheOrder = driver.findElement(By.xpath("//h2[@class ='order-thank-you-msg']"));
	    
	    String ActualTitleofPlacetheOrder = PlacetheOrder.getText();
	    
	    String ExpectedTitlePlacetheOrder = "Thank you for your order.";
	    
	    logger.info(PlacetheOrder.getText());
	    
	    if (ActualTitleofPlacetheOrder.equals(ExpectedTitlePlacetheOrder)) {
	        test.pass("Successfully Order is Placed");
	        logger.info("Successfully Order is Placed");
	    } else {
	        test.fail( "The page Title does not match expected " + ExpectedTitlePlacetheOrder + " " + "  but found" + " " + ActualTitleofPlacetheOrder + " ");
	        logger.info("Click failed");
	    }
	    
	    Thread.sleep(5000);
	    
	    //displayordernumberandplaceddate
	    
	    WebElement orderNumeber = driver.findElement(By.xpath("//span[@class ='summary-details order-number']"));
	    
	    String Ordernumber = orderNumeber.getText();
	    
        test.pass("Successfully Order is Placed and the Order number is "+ Ordernumber);
        logger.info("Successfully Order is Placed and the Order number is "+ Ordernumber);
	    
	    
	    
	    WebElement OrderDate = driver.findElement(By.xpath("//span[@class ='summary-details order-date']"));
	    
        String Orderdate = OrderDate.getText();
	    
        test.pass("Successfully Order is Placed and the Ordered date is "+ Orderdate);
        logger.info("Successfully Order is Placed and the Ordered date is "+ Orderdate);

		
	}
}
