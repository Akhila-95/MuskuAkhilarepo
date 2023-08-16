package com.providio.Validations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.providio.pageObjects.checkOutPage;
import com.providio.pageObjects.miniCartPage;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productListingPage;
import com.providio.pageObjects.viewCartPage;
import com.providio.paymentProccess.tc__CheckOutProcess;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;
import com.providio.testcases.size;

public class CheckoutPage2_Validation extends baseClass {
	@Test
	public void checkoutPage() throws InterruptedException {
		driver.get(baseURL);
        navigationPage navMenu = new navigationPage(driver);
        navMenu.clickwoMensMenubaritems(driver);
        logger.info("hovered on Womens");
        
        navMenu.ClickwoMensofBraceletss(driver);
        logger.info("clicked on Braceletss  sub menu");
        
        //validate the Television
        WebElement braclets = driver.findElement(By.xpath("//h1[@class ='page-title']"));
        String ActualTitleofBraclets =braclets.getText();
        String ExpectedTitleofBraclets = "BRACELETS";
        logger.info(braclets .isDisplayed());
        if (ActualTitleofBraclets.equals(ExpectedTitleofBraclets)) {
            test.pass( "Successfully clicked on the womens of  " + ActualTitleofBraclets + " ");
            logger.info("Successfully clicked on the womens of  " + ActualTitleofBraclets + " ");
        } else {
            test.fail( "The page Title does not match expected " + ExpectedTitleofBraclets + " " + "  but found" + " " + ActualTitleofBraclets + " ");
            logger.info( "The page Title does not match expected " + ExpectedTitleofBraclets + " " + "  but found" + " " + ActualTitleofBraclets + " ");
        }

        
        productListingPage plp = new productListingPage(driver);
        plp.clickOnProduct(driver);
       // plp.selectProductRandom(driver);
        logger.info("clicked on earings product");
        

        //pdp page
      Thread.sleep(2000);
      WebElement minicartcount = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
      String countOfMinicart = minicartcount.getText();
      int minicartCountValue = Integer.parseInt(countOfMinicart);
      logger.info(minicartCountValue);
      
      size s = new size();
      s.selectSize(driver);
      

      WebElement minicartcountafteradding = driver.findElement(By.xpath("//span[@class ='minicart-quantity ml-1']"));
      String countOfMinicartafteradding = minicartcountafteradding.getText();
      int minicartCountValueafteradding = Integer.parseInt(countOfMinicartafteradding);

      logger.info(minicartCountValueafteradding);

     //validation for product add to cart
        test.info("Verifying the product is added to cart or not ");

	        if( minicartCountValueafteradding!= minicartCountValue) {
	            test.pass("Product added to cart");
	            logger.info("Product is  added to cart");
	        }else {
	            test.fail("Product is not added to cart");
	            logger.info("Product is not added to cart");
	        }
        
	        List <WebElement> minicartcounts = driver.findElements(By.xpath("//span[contains(@class,'minicart')]"));	       
		      
	 	       if(minicartcounts.size()>0) {
	 		    	   WebElement minicartcount1 = driver.findElement(By.xpath("//span[contains(@class,'minicart')]"));
	 		    	   String countOfMinicarts = minicartcount1.getText();
	 		    	   int minicartCountValue1 = Integer.parseInt(countOfMinicarts);
	 		
	 		        if (minicartCountValue1 > 0) {
	 		
	 		            miniCartPage mc = new miniCartPage(driver);
	 		            
	 		            Thread.sleep(4000);
	 		               
	 		            //click on the cart button
	 		            mc.clickcartbutton(driver);
	 		            Thread.sleep(2000);
	 		            
	 		            //validate the button click 
	 		           miniCartAndCartValidation validation =new miniCartAndCartValidation();
	 		           validation.validateMiniCartClick();
	 		            
	 		            //validate quantity in minicart
	 		            QuantityValidation quaValidation= new QuantityValidation();
	 		            //quaValidation.quantityValidationInMinicart();
	 		            Thread.sleep(5000);
	 		            //click review order
	 		            mc.clickviewCartButton(driver);
	 					logger.info("clicked the view cart button in the minicart");
	 					
	 					//validate the view cart button click
	 					validation.validateViewCartClick();
	 					Thread.sleep(5000);
	 					//Validating the quanity in view cart page
	 					//quaValidation.quantityValidationInViewCart();
	 		
	 		            viewCartPage vcp = new viewCartPage(driver);
	 		            //click the checkout button
	 		            vcp.clickCheckout(driver);
	 		            Thread.sleep(5000);
	 		            
	 		           List<WebElement> continueasAGuest = driver.findElements(By.xpath("//button[contains(text(),'Guest Checkout')]"));
	 			        logger.info(continueasAGuest.size());
	 			        if(continueasAGuest.size()>0) {
	 			        	
	 			        	tc__CheckOutProcess cop = new tc__CheckOutProcess();
	 			        	cop.clickContinueAsGuest();
	 			        	
	 			        	toVerifyTheDisplayOfAllElements();
	 			        	
	 			        	emptyText();
	 			        	
	 			        	invalidAddress();
	 			        	
	 			        	Thread.sleep(2000);
	 			        	
	 			        	validAddress();
	 			        	
	 			        	
	 			        }else {
	 			        	toVerifyTheDisplayOfAllElements();
	 			        	
	 			        	emptyText();

	 			        	invalidAddress();
	 			        	
	 			        	validAddress();
	 			        	
	 			        	
	 			        }
	 		             
	 		        }
	 	       }
	}
	
		public void emptyText() throws InterruptedException {
			
			
				test.info("Verifying the error message by Passing empty address and name ,clicking on payment button");
				checkOutPage cp = new checkOutPage(driver);
		         //selecting shipping address
	            
	            tc__CheckOutProcess cop = new tc__CheckOutProcess();         
	            cop.selectPaymentMethod(cp);
	            
	            WebElement firstNameError = driver.findElement(By.xpath("//div[contains(text(),'Please enter a First name')]"));
	            
	            WebElement lastNameError = driver.findElement(By.xpath("//div[contains(text(),'Please enter a Last name')]"));
	            
	            WebElement addressError= driver.findElement(By.xpath("//div[contains(text(),'Please enter Address information')]"));
	            
	            WebElement stateError= driver.findElement(By.xpath("//div[contains(text(),'Please select a State.')]"));
	            
	            WebElement cityError= driver.findElement(By.xpath("//div[contains(text(),'Please enter a City')]"));
	            
	            WebElement zipcodeError= driver.findElement(By.xpath("//div[contains(text(),'Please enter a ZIP Code')]"));
	            
	            WebElement phoneNumError= driver.findElement(By.xpath("//div[contains(text(),'Please enter a valid Phone Number.')]"));
	            
	            if(firstNameError.isDisplayed() && lastNameError.isDisplayed() && addressError.isDisplayed()&& stateError.isDisplayed()&&  cityError.isDisplayed() && zipcodeError.isDisplayed() && phoneNumError.isDisplayed()) {
	            	test.pass("Successfully error message is displayed  when empty text is given");
	            }else {
	            	test.fail("No error message is displayed when empty text is given");
	            }
	            
		}
		public void invalidAddress() throws InterruptedException {
			
			test.info("Verifying the error message by giving invalid address");
			checkOutPage cop = new checkOutPage(driver);
			cop.setFisrtName(epfname);
			cop.setLastname(eplname);
			cop.setAddress1("3457");
			cop.setcity(cityname);
			cop.setProvince();
			cop.setzipCode("535633");
			cop.setPhone(phonenumber);
			
			checkOutPage cp = new checkOutPage(driver);
			tc__CheckOutProcess cop1 = new tc__CheckOutProcess();         
	        cop1.selectPaymentMethod(cp);
			WebElement invalidCodeError= driver.findElement(By.xpath("//div[contains(text(),'Please enter a valid code')]"));
			
			if(invalidCodeError.isDisplayed()) {
				test.pass("Successfully the error message is displayed when we enter invalid postal code is shows " + invalidCodeError.getText());
				
			}else {
				test.fail("No error message is displayed when we enter invalid postal code");
			}
			
		}
		
		public void validAddress() throws InterruptedException {
			
			test.info("Verifying the pagination when valid address is given");
			checkOutPage cp = new checkOutPage(driver);
			tc__CheckOutProcess cop1 = new tc__CheckOutProcess();       
			cop1.selectShippingAddress(cp);
	        cop1.selectPaymentMethod(cp);
	        
	        WebElement paginationOfGuestUser = driver.findElement(By.xpath("//span[contains(@class,'customer-labe')]"));
	         if(paginationOfGuestUser.isDisplayed()) {
	        	 test.pass("Successfully the page is redirected to checkout page 2");
	         }else {
	        	 test.fail(" The page is not redirected to checkout page 1");
	         }
			
		}
		
		public void toVerifyTheDisplayOfAllElements() {
			
			test.info("To verify the display of elements in checkout page 1");
			WebElement customerInformation = driver.findElement(By.xpath("//span[contains(@class,'customer-labe')]"));
	         if(customerInformation.isDisplayed()) {
	        	 test.pass("Successfully the customer information is displayed");
	         }else {
	        	 test.fail(" The page is not redirected to checkout page 1");
	         }
			
	         
	         WebElement shippingElement = driver.findElement(By.xpath("(//h2[contains(text(),'Shipping')])[2]"));
	         if(shippingElement.isDisplayed()) {
	        	 test.pass("Successfully the shipping address amd shipping method are displayed");
	         }else {
	        	 test.fail("No shipping address amd shipping method are displayed");
	         }
		}
		
}
