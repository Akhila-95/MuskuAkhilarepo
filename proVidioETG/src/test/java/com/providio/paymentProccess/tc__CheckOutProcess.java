package com.providio.paymentProccess;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.providio.Validations.QuantityValidation;
import com.providio.Validations.miniCartAndCartValidation;
import com.providio.pageObjects.checkOutPage;
import com.providio.pageObjects.guestUserLoginPage;
import com.providio.pageObjects.miniCartPage;
import com.providio.pageObjects.viewCartPage;
import com.providio.testcases.baseClass;

public class tc__CheckOutProcess extends baseClass {

    public void checkoutprocess() throws InterruptedException {

       List <WebElement> minicartcount = driver.findElements(By.xpath("//span[contains(@class,'minicart')]"));
       List<WebElement> byBuyNow = driver.findElements(By.xpath("//span[contains(@class,'order-receipt-label grand-total-label')]"));
     
	       if(minicartcount.size()>0) {
		    	   WebElement minicartcount1 = driver.findElement(By.xpath("//span[contains(@class,'minicart')]"));
		    	   String countOfMinicart = minicartcount1.getText();
		    	   int minicartCountValue = Integer.parseInt(countOfMinicart);
		
		        if (minicartCountValue > 0) {
		
		            miniCartPage mc = new miniCartPage(driver);
		            
		            Thread.sleep(5000);
		               
		            //click on the cart button
		            mc.clickcartbutton(driver);
		            Thread.sleep(1000);
		            
		            //validate the button click 
		            miniCartAndCartValidation validation= new miniCartAndCartValidation();
		            validation.validateMiniCartClick();
         
		            Thread.sleep(1000);
		            //click review order
		            mc.clickviewCartButton(driver);
					logger.info("clicked the view cart button in the minicart");
					
					//validate the view cart button click
					validation.validateViewCartClick();
					Thread.sleep(1000);

		
		            viewCartPage vcp = new viewCartPage(driver);
		            //click the checkout button
		            vcp.clickCheckout(driver);
		            Thread.sleep(1000);
		
		            //Taxcalculation
		            
		          //  tc__TaxCalculationCheckoutPage tc = new tc__TaxCalculationCheckoutPage();           
		           // tc.taxCalculation();
		            
		           //if any guest user means guest checkout
		            clickContinueAsGuest();
		            Thread.sleep(1000);
		            List<WebElement> checkoutPage1= driver.findElements(By.xpath("(//h2[contains(text(),'Shipping')])[2]"));		
		            System.out.println(" shh"+checkoutPage1.size());
		            if(checkoutPage1.size()>0) {
		            	checkOutPage cp = new checkOutPage(driver);
		            	//selecting shipping address
			            selectShippingAddress(cp);
			            selectPaymentMethod(cp);
			            
		            }else {
		            	 List<WebElement> billingAddress= driver.findElements(By.xpath("//label[contains(text(),'Billing Address')]"));
		            	 System.out.println(" bill"+ billingAddress.size());
		            	 checkOutPage cp = new checkOutPage(driver);
		            	 if(billingAddress.size()>0) {
		            		 selectBillingAddress(cp);
			            	 selectPaymentMethod(cp);
		            	 }
		            }
		          
		        } else {
		            logger.info("The cart value is empty");
		            test.fail("The cart value is empty");
		        }
	       }
	       
	       if(byBuyNow.size()>0){
	    	   
	    	   //Taxcalculation
	            
		          //  tc__TaxCalculationCheckoutPage tc = new tc__TaxCalculationCheckoutPage();           
		           // tc.taxCalculation();
		            
		           //if any guest user means guest checkout
		            clickContinueAsGuest();
		            
		
		            checkOutPage cp = new checkOutPage(driver);
		          //selecting shipping address
		            selectShippingAddress(cp);
		            selectPaymentMethod(cp);
		            
		            if(driver.findElements(By.xpath("//div[contains(text(),'Please enter a City')]")).size()>0 ) {
		            	 
		            	 WebElement addresss= driver.findElement(By.id("#shippingAddressOnedefault"));		            	 
		            	 addresss.clear();		
		            	 selectShippingAddress(cp);
		            	 selectPaymentMethod(cp);
		            }if(driver.findElements(By.xpath("//div[contains(text(),'Please enter a valid Phone Number.')]")).size()>0 ) {
		            	 cp.setPhone(phonenumber);
		                 logger.info("Entered phone number");
		                 
		            }
		            if(driver.findElements(By.xpath("//button[@name ='submit' and @class ='btn btn-primary btn-block submit-shipping']")).size()>0 ) {
		            	selectPaymentMethod(cp);
		            }
		            
		            
	       }
    }

    
    public void clickContinueAsGuest() throws InterruptedException {
        List<WebElement> continueasAGuest = driver.findElements(By.xpath("//button[contains(text(),'Guest Checkout')]"));
        logger.info(continueasAGuest.size());

        if (continueasAGuest.size() > 0) {
            guestUserLoginPage guestLoginPage = new guestUserLoginPage(driver);
            guestLoginPage.clickOnGuestCheckOut();
            logger.info("Guest checkout");
            guestLoginPage.clickOnEmail(reEnterMail);
            logger.info("Guest mail again");
            guestLoginPage.clickOnContinueAsGuest();
            logger.info("Guest continue as guest");
            Thread.sleep(5000L);
          
        }
  
    }

    public void selectShippingAddress(checkOutPage cp) throws InterruptedException {
        //List<WebElement> existingAddress = driver.findElements(By.xpath("//select[@name='shipmentSelector' and @id='shipmentSelector-default']"));        
        //if(existingAddress.size()>0) {
	        WebElement existingAddress1 = driver.findElement(By.xpath("//select[@name='shipmentSelector' and @id='shipmentSelector-default']"));
	        List<WebElement> options1 = existingAddress1.findElements(By.xpath("./option"));
	        System.out.println(options1.size());
	
		        if (options1.size() > 1) {
		            logger.info("Address already exists");
		       // }
	        }else {
	        	
	        	Thread.sleep(1000);
	        		        	
	            cp.setFisrtName(fname);
	
	            logger.info("Entered fname");
	
	            Thread.sleep(1000);
	
	            cp.setLastname(lname);
	
	            logger.info("Entered lname");
	
	            WebElement Address1 = driver.findElement(By.xpath("//input[@id='shippingAddressOnedefault']"));
	
	            Random random = new Random();
	
	            int randomNumber = random.nextInt(900) + 100; // Generates a random number between 100 and 999
	
	            address = String.valueOf(randomNumber);
	
	            Address1.clear();
	
	            Address1.sendKeys(address);
	
	            WebElement Address11 = driver.switchTo().activeElement();
	
	          
	
	            Thread.sleep(1000);
	
	            Address11.sendKeys(Keys.ARROW_DOWN);
	
	            Thread.sleep(1000);
	
	            Address11.sendKeys(Keys.ARROW_DOWN);
	
	            Address11.sendKeys(Keys.ENTER);
	
	            Thread.sleep(2000);
	
	            cp.setPhone(phonenumber);
	
	            logger.info("Entered phone number");
	            
	            Thread.sleep(2000);
	            
            
        }
    }

    public void selectBillingAddress(checkOutPage cp) throws InterruptedException {
    	
		    	Thread.sleep(1000);
		    	
		        cp.setBillingFName();
		
		        logger.info("Entered fname");
		
		        Thread.sleep(1000);
		
		        cp.setBillingLName();
		
		        logger.info("Entered lname");
		
		        WebElement Address1 = driver.findElement(By.xpath("//input[@id='billingAddressOne']"));
		
		        Random random = new Random();
		
		        int randomNumber = random.nextInt(900) + 100; // Generates a random number between 100 and 999
		
		        address = String.valueOf(randomNumber);
		
		        Address1.clear();
		
		        Address1.sendKeys(address);
		
		        WebElement Address11 = driver.switchTo().activeElement();
		        Thread.sleep(1000);
		
		        Address11.sendKeys(Keys.ARROW_DOWN);
		
		        Thread.sleep(1000);
		
		        Address11.sendKeys(Keys.ARROW_DOWN);
		
		        Address11.sendKeys(Keys.ENTER);
		
		        Thread.sleep(2000);
		
		        cp.setBillingPhoneNum();
		
		        logger.info("Entered phone number");
		        
		        Thread.sleep(2000);
	        
    }
   public void selectPaymentMethod(checkOutPage cp) throws InterruptedException {
	   
        cp.clickpaymentbutton(driver);
        logger.info("Clicked on the payment button");
        Thread.sleep(2000);
//        homePage hm = new homePage(driver);
//        hm.clickOnLogo();
        // Additional payment method steps...
    }
    
   
}
