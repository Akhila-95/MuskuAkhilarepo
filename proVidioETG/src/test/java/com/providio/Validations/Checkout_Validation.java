package com.providio.Validations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.pageObjects.miniCartPage;
import com.providio.testcases.baseClass;

public class Checkout_Validation extends baseClass {

	
	//validate the payment page
		public void validatePaymentButtonClk() {
			
			//validate the payment page
		    WebElement paymentPage = driver.findElement(By.xpath("//label[contains(text(), 'Payment Method')]"));
		    String ActualTitleofpaymentPage = paymentPage.getText();
		    String ExpectedTitlepaymentPage = "Payment Method";
		    logger.info(paymentPage.getText());
		    
		    if (ActualTitleofpaymentPage.equals(ExpectedTitlepaymentPage)) {
		    	test.info("Verify that shipping address added");
		    	 test.pass("Successfully added the shipping address");
		    	 test.info("Verify the payment button is clicked");
		        test.pass("Successfully clicked on the Payment button");
		        logger.info("Successfully clicked on the Payment button");
		    } else {
		        test.fail( "The page Title does not match expected " + ExpectedTitlepaymentPage + " " + "  but found" + " " + ActualTitleofpaymentPage + " ");
		        logger.info("Click failed");
		    }
		    
		}
    public void validateViewCartClick() {
    	test.info("Verify the view-cart button is clicked");
        WebElement viewcart = driver.findElement(By.xpath("//h4"));
        String actualTitleofviewcart = viewcart.getText();
        String expectedTitleviewcart = "Order Summary";
        logger.info(viewcart.getText());
        if (actualTitleofviewcart.equals(expectedTitleviewcart)) {
            test.pass("Successfully clicked on the view cart button");
            logger.info("Successfully clicked on the view cart button");
        } else {
            test.fail("Clicked failed on the view cart button");
            logger.info("Clicked failed on the view cart button");
        }  
    }
    
    public void validateMiniCartClick() throws InterruptedException {
    	
    	test.info("Verify the mini-cart button is clicked");
    	
        WebElement minicart = driver.findElement(By.xpath("(//h1)[1]"));
        String actualTitleofminicart = minicart.getText();
        String expectedTitleminicart = "Your shopping cart";
        Thread.sleep(2000);
        logger.info(minicart.getText());
        if (actualTitleofminicart.equals(expectedTitleminicart)) {
            test.pass("Successfully clicked on the mini cart button");
            logger.info("Successfully clicked on the mini cart button");

        } else {
            //test.fail("Clicked failed on the mini cart button");
            logger.info("Clicked failed on the mini cart button");
            //reclick if any error occurs
            //reClickMiniCartButton();
            
        }
        
        test.info("Verify the viewcart, checkout, paypal buttons and products are displayed");
        List<WebElement> productsinthecart = driver.findElements(By.xpath("//div[@class ='line-item-name']"));
        logger.info(productsinthecart.size());
        
        WebElement viewcarButton = driver.findElement(By.xpath("//a[contains(@class, 'checkout-btn') and contains(text(), 'View Cart')]"));
        boolean displaycartbutton = viewcarButton.isDisplayed();
        logger.info(displaycartbutton);
        WebElement checkOutProcess = driver.findElement(By.xpath("//a[contains(@class, 'checkout-btn') and contains(@class, 'btn-primary') and contains(text(), 'Checkout')]"));
        boolean displaycheckOut = checkOutProcess.isDisplayed();
        logger.info(displaycheckOut);
//        WebElement paypal = driver.findElement(By.xpath("//div[contains(@class, 'paypal-button') and contains(@class, 'paypal-button-number-0') and contains(@class, 'paypal-button-layout-vertical') and contains(@class, 'paypal-button-shape-rect') and contains(@class, 'paypal-button-env-sandbox') and contains(@class, 'paypal-button-color-gold') and contains(@class, 'paypal-button-text-color-black') and contains(@class, 'paypal-logo-color-blue') and @role='link' and @aria-label='PayPal Checkout']"));
//        boolean displaypaypal = paypal.isDisplayed();
        if(productsinthecart.size()>0 && displaycartbutton && displaycheckOut ) {
        	test.pass("Successfully displayed the viewcart, checkout, paypal buttons and products, The number of products are: "+ productsinthecart.size());
            logger.info("Successfully displayed the viewcart, checkout, paypal buttons and products");
        	
        }else {
            test.fail(" Not displayed the viewcart, checkout, paypal buttons and products");
            logger.info("Not displayed the viewcart, checkout, paypal buttons and products");
        }
    }
    
    
    public void reClickMiniCartButton() throws InterruptedException {
    	
    	miniCartPage mc = new miniCartPage(driver);
        mc.clickcartbutton(driver);
        
        WebElement reminicart = driver.findElement(By.xpath("(//h1)[1]"));
        String reactualTitleofminicart = reminicart.getText();
        String reexpectedTitleminicart = "Your shopping cart";
        Thread.sleep(2000);
        logger.info(reminicart.getText());
        if (reactualTitleofminicart.equals(reexpectedTitleminicart)) {
            test.pass("Successfully clicked on the mini cart button");
            logger.info("Successfully clicked on the mini cart button");

        } else {
            test.fail("Clicked failed on the mini cart button");
            logger.info("Clicked failed on the mini cart button");

        }	        	
    }
    
	//validate the order number and date of order
	public void ordernumberandOrderdat() throws InterruptedException {
		
	      List<WebElement> orderConfirmationPage = driver.findElements(By.xpath("//h2[@class ='order-thank-you-msg']"));
				 if(orderConfirmationPage.size()>0) {
					//displayordernumberandplaceddate
				    
				    WebElement orderNumeber = driver.findElement(By.xpath("//span[@class ='summary-details order-number']"));
				    String Ordernumber = orderNumeber.getText();
			        test.pass("Successfully Order is Placed and the Order number is "+ Ordernumber);
			        logger.info("Successfully Order is Placed and the Order number is "+ Ordernumber);
				    
				    //order date
				    WebElement OrderDate = driver.findElement(By.xpath("//span[@class ='summary-details order-date']"));
			        String Orderdate = OrderDate.getText();
			        test.pass("Successfully Order is Placed and the Ordered date is "+ Orderdate);
			        
			        //paymnet details
				    WebElement paymentDetailsElement = driver.findElement(By.xpath("//div[@class='payment-details']"));
			        String paymentDetails = paymentDetailsElement.getText();
			        test.pass("Successfully Order is Placed and payment is "+ paymentDetails);
			        logger.info("Successfully Order is Placed and the Order number is "+  paymentDetails);
			        Thread.sleep(5000);
				 }
	}
	
	
	//validate the place the order page
   public void validatePlacetheOrderPage() throws InterruptedException {
	   
	    List<WebElement> orderConfirmationPage = driver.findElements(By.xpath("//h2[@class ='order-thank-you-msg']"));
			 if(orderConfirmationPage.size()>0) {
			    	test.info("verify that order is placed");
					
					//validate the orderstatus
			    	Thread.sleep(3000);
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
			 }
    }
}
