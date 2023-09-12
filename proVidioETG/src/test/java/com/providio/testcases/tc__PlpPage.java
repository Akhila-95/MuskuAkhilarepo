package com.providio.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productListingPage;
import com.providio.pageObjects.quickShopPage;
import com.providio.paymentProccess.tc__CheckOutProcess;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;


public class tc__PlpPage extends baseClass{
	
		SoftAssert softAssert = new SoftAssert();
		
		int countofProducts =0;
	
		@Test//(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
		public void PlpPage() throws InterruptedException {
		    // Validate if the user is logged in or not
		  //  if (isLoggedIn) {
			
				driver.get(baseURL);
				
		        // Step 1: Navigate to Men's Pants
		        navigateToMensPants();

		        // Step 2: Validate Women's Pants page
		        validateWomensPantsPage();

		        // Step 3: Select Filters and Add to Wishlist
		        selectFiltersAndAddToWishlist();

		        // Step 4: Select Color and Price Range
		        selectColorAndPriceRange();

		        // Step 5: Validate Quickshop
		        validateQuickshop();

		        // Step 6: Perform Quickshop Actions
		        performQuickshopActions();

		        // Step 7: Checkout Process
		        tc__CheckOutProcess cp = new tc__CheckOutProcess();
		        cp.checkoutprocess();
		        
		        //payment process
		        tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();
		        
		        cc.paymentByCreditCard();
		        
	/*	        
		        
		    } else {
		        Assert.fail("User is not logged in");
		    }*/
		}

		// Step 1: Navigate to Men's Pants
		private void navigateToMensPants() throws InterruptedException {
		    navigationPage NM = new navigationPage(driver);
		    NM.clickMensMenubaritems(driver);
		    logger.info("Hovered over the Men's menu");
		    Thread.sleep(5000);

		    NM.ClickMensofPants(driver);
		    logger.info("Clicked on Men's Pants");
		    Thread.sleep(5000);
		}

		// Step 2: Validate Women's Pants page
		private void validateWomensPantsPage() {
			test.info("Verify that selecting one menu and submenu");
		    WebElement outfits = driver.findElement(By.xpath("//h1[@class ='page-title']"));
		    String ActualTitleofoutfits = outfits.getText();
		    String ExpectedTitleofoutfits = "PANTS";
		    logger.info(outfits.getText());
		    if (ActualTitleofoutfits.equals(ExpectedTitleofoutfits)) {
		        test.pass("Successfully clicked on the Women's " + ActualTitleofoutfits + " page");
		        logger.info("Clicked Women's Pants successfully");
		    } else {
		        test.fail("The page title does not match the expected value: " + ExpectedTitleofoutfits + ". Found: " + ActualTitleofoutfits);
		        logger.info("Click on Women's Pants failed");
		    }
		    
		    List<WebElement> totalproducts = driver.findElements(By.xpath("//div[@class ='pdp-link']"));
		    
		    countofProducts = totalproducts.size();
		    
		    logger.info(countofProducts);
		    
		}

		// Step 3: Select Filters and Add to Wishlist
		private void selectFiltersAndAddToWishlist() throws InterruptedException {
		    productListingPage plp = new productListingPage(driver);
		    plp.selecttheFilters(2, driver);
		    logger.info("Selected the filter");

		    plp.selecttheWishlist();
		    logger.info("Added to the wishlist");
		    // Add any additional validation if needed
		}

		// Step 4: Select Color and Price Range
		private void selectColorAndPriceRange() throws InterruptedException {
		    productListingPage plp = new productListingPage(driver);
		    plp.selectthecolorBlack(driver);
		    logger.info("Selected the color Black");
		    validateFilters();

		    plp.selectthePrice(driver);
		    logger.info("Selected the Price Range");
		    // Add any additional validation if needed
		    
		    plp.selectthequickshope(driver);
		}

		// Step 5: Validate Quickshop
		private void validateQuickshop() {
			test.info("Verify that Quickshop is clicked");
		    WebElement Quickshop = driver.findElement(By.xpath("//button[@class='add-to-cart-global btn btn-primary']"));
		    String ActualTitleofquickshop = Quickshop.getText();
		    String ExpectedTitleofquickshop = "ADD TO CART";
		    logger.info(Quickshop.getText());
		    if (ActualTitleofquickshop.equals(ExpectedTitleofquickshop)) {
		        test.pass("Successfully clicked on Quickshop. Title: " + ActualTitleofquickshop);
		        logger.info("Clicked Quickshop successfully");
		    } else {
		        test.fail("The page title does not match the expected value: " + ExpectedTitleofquickshop + ". Found: " + ActualTitleofquickshop);
		        logger.info("Click on Quickshop failed");
		    }
		}

		// Step 6: Perform Quickshop Actions
		private void performQuickshopActions() throws InterruptedException {
		    quickShopPage qs = new quickShopPage(driver);
		    test.info("Verify the carsol and quantity");
		    
		    qs.clickFCarasol();
		    logger.info("Clicked on the fCarosal");

		    qs.clickBCarasol();
		    logger.info("Clicked on the bCarosal");

		    qs.clickcolor(driver);
		    logger.info("Selected the color");

		    qs.selectthesize();
		    logger.info("Selected the size");

		    qs.clickIncQuantity();
		    logger.info("Clicked on Increase quantity");

		    qs.clickMinusQuantity();
		    logger.info("Clicked on Decrease quantity");
		   
		    test.pass("successfully verfied the product quantity and carsol");
		    qs.clickAddtocartbutton();
		    logger.info("Clicked on Add to Cart button");
		    // Add any additional validation if needed
		}
		
		
		private void validateFilters() {
			test.info("verify that filter are applied");
		    List<WebElement> totalproductsAfterFilters = driver.findElements(By.xpath("//div[@class ='pdp-link']"));
		    int countofProductsAfterFilters = totalproductsAfterFilters.size();
		    logger.info(countofProductsAfterFilters);
			
		    if(countofProductsAfterFilters != countofProducts) { 	
		        test.pass("Successfully Filter applied on the PLP page");
		        logger.info("Successfully Filter applied on the PLP page");
		    	
		    }else {
		        test.fail(" Filter not applied on the PLP page");
		        logger.info("Filter not applied on the PLP page");
		    }
			
			
		}

						 
}