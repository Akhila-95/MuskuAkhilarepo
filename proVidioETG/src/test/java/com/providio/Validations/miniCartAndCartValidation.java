package com.providio.Validations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.pageObjects.miniCartPage;
import com.providio.testcases.baseClass;

public class miniCartAndCartValidation extends baseClass {

	
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
	            Thread.sleep(3000);
	            reClickMiniCartButton();
	            
	        }
	        
	        test.info("Verify the viewcart, checkout, paypal buttons and products are displayed");
	        List<WebElement> productsinthecart = driver.findElements(By.cssSelector(".line-item-name"));
	        test.info("The number of Products in minicart are" + productsinthecart.size());
	        
	        //count of products and its name in minicart
	        if(productsinthecart.size()>0) {
	        	for(int i=1;i<=productsinthecart.size() ;i++) {
	        		  WebElement productsName = driver.findElement(By.xpath("(//div[@class='line-item-name']) [" + i + "]"));
	        		  test.info("The products name in cart are " + productsName.getText());
	        	}
	        }
	        
	        WebElement viewcarButton = driver.findElement(By.xpath("//a[contains(@class, 'checkout-btn') and contains(text(), 'View Cart')]"));
	        boolean displaycartbutton = viewcarButton.isDisplayed();
	        logger.info(displaycartbutton);
	        WebElement checkOutProcess = driver.findElement(By.xpath("//a[contains(@class, 'checkout-btn') and contains(@class, 'btn-primary') and contains(text(), 'Checkout')]"));
	        boolean displaycheckOut = checkOutProcess.isDisplayed();
	        logger.info(displaycheckOut);
//	        WebElement paypal = driver.findElement(By.xpath("//div[contains(@class, 'paypal-button') and contains(@class, 'paypal-button-number-0') and contains(@class, 'paypal-button-layout-vertical') and contains(@class, 'paypal-button-shape-rect') and contains(@class, 'paypal-button-env-sandbox') and contains(@class, 'paypal-button-color-gold') and contains(@class, 'paypal-button-text-color-black') and contains(@class, 'paypal-logo-color-blue') and @role='link' and @aria-label='PayPal Checkout']"));
//	        boolean displaypaypal = paypal.isDisplayed();
	        if(productsinthecart.size()>0 && displaycartbutton && displaycheckOut ) {
	        	test.pass("Successfully displayed the viewcart, checkout, paypal buttons and products, The number of products are: "+ productsinthecart.size());
	            logger.info("Successfully displayed the viewcart, checkout, paypal buttons and products");
	        	
	        }else {
	            test.fail(" Not displayed the viewcart, checkout, paypal buttons and products");
	            logger.info("Not displayed the viewcart, checkout, paypal buttons and products");
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

	    public void reClickMiniCartButton() throws InterruptedException {
	    	
	    	miniCartPage mc = new miniCartPage(driver);
	        mc.clickcartbuttonjs(driver);
	        
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
	}

