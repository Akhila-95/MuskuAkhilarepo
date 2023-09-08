//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.RegUserWith_CreditCard;

import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.pageObjects.productListingPage;
import com.providio.paymentProccess.tc__CheckOutProcess;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;
import com.providio.testcases.size;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tc__PdpPagewithGuestuser extends baseClass {

	SoftAssert softAssert = new SoftAssert();

	@Test
	public void PDPpage() throws InterruptedException {
		
		test.info("Open browser");
        // Test Case 0: Open browser
        driver.get(baseURL);
        logger.info("Opened browser");
	    // Validate if the user is logged in or not
	 
	        // Step 1: Navigate to Women's New Arrivals
        	navigateRandomMenu();
        	
	        // Step 2: Select a Product from the Listing Page
	        selectProductFromListingPage();

	        // Step 3: Perform actions on Product Description Page
	        performActionsOnProductDescriptionPage();

	        // Step 4: Write a Review for the Product
	        writeReviewForProduct();

	        // Step 5: Add the Product to Cart
	        addProductToCart();

	        // Step 6: Proceed to Checkout
	        tc__CheckOutProcess cp = new tc__CheckOutProcess();
	        cp.checkoutprocess();
            //payment process
            
            tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();          
            cc.paymentByCreditCard(); 

	    // Assert all the soft assertions
	    softAssert.assertAll();
	}

	// Step 1: Navigate to Women's New Arrivals
	private void navigateRandomMenu() throws InterruptedException {
		navigationPage navPage =new navigationPage(driver);
  	  	navPage.selectRandomMenu(driver);
  	  	test.info("Randomly selected a Menu");
  	  List<WebElement> pageTitle = driver.findElements(By.cssSelector("h1.page-title"));
 	 if(pageTitle.size()>0)
 	 {
 		 WebElement pageTitle1 = driver.findElement(By.cssSelector("h1.page-title"));
 		 test.info("Entered into random menu" + pageTitle1.getText());
 	 }
	}

	// Step 2: Select a Product from the Listing Page
	private void selectProductFromListingPage() throws InterruptedException {
	    productListingPage plp = new productListingPage(driver);
	    plp.selectProductRandom(driver);
	    test.info("Clicked on a product from the listing page");
	    List<WebElement> productName1 = driver.findElements(By.xpath("//h1[@class='product-name hidden-sm-down']"));
  	     if(productName1.size()>0) {
  	    	 WebElement productName = driver.findElement(By.xpath("//h1[@class='product-name hidden-sm-down']"));
  	    	 test.info("productName is " +productName.getText());
  	     }
	    
	    //validate the product selected
	    validateproductselect();
	}

	// Step 3: Perform actions on Product Description Page
	private void performActionsOnProductDescriptionPage() throws InterruptedException {
	    productDescriptionPage pdp = new productDescriptionPage(driver);
	    pdp.clickOnSize(driver);
	    logger.info("Clicked on Size");
//	    pdp.clickOnLeftCarousel(driver);
//	    logger.info("Clicked on Left Carousel");
//	    pdp.clickOnRightCarousel(driver);
//	    logger.info("Clicked on Right Carousel");
	    // Add any additional actions on the Product Description Page
	}

	// Step 4: Write a Review for the Product
	private void writeReviewForProduct() throws InterruptedException {
		List<WebElement> bopis =driver.findElements(By.xpath("(//span[@class='write-question-review-button-text font-color-gray-darker'])[1]"));
		productDescriptionPage pdp = new productDescriptionPage(driver);
		if(!(bopis.size()>0)) {
		    
		    pdp.clickOnWriteAReviewAtTop(driver);
		    logger.info("Clicked on Write a Review at the top");
		    pdp.clickOnRating(driver);
		    logger.info("Clicked on Rating");
		    pdp.clickOnReviewHeadline(driver, headline);
		    logger.info("Entered Review Headline");
		    pdp.clickOnComments(comment);
		    logger.info("Entered Comments");
		    pdp.clickOnYes();
		    logger.info("Clicked on Yes");
		    pdp.clicknickName(nickName);
		    logger.info("Entered Nickname");
		    pdp.clickOnLoc(location);
		    logger.info("Entered Location");
		    pdp.clickOnSubmitReview(driver);
		    logger.info("Clicked on Submit Review");
		    // Add any additional steps for writing a review
		    validateReviewProduct();
		    pdp.clickOncontinueShoping(driver);
		    logger.info("clicked on the clickOncontinueShoping button");
		}else {
			logger.info("Another review is activated");
			test.info("Another review is activated");
		}
	    
	    
	}

	// Step 5: Add the Product to Cart
	private void addProductToCart() throws InterruptedException {
	     List<WebElement> pdpPage = driver.findElements(By.xpath("//button[contains(@class,'add-to-cart btn btn-primary')]"));
   		 if( pdpPage.size()>0) {	    			 
		          size s = new size();			          
		          s.selectSize(driver);
	    		 };
	    // Add any additional steps for adding the product to the cart
	}
	
	/*//validation for the new arrivals of womens
	private void validatiionNewArrivalWomens() {
		//validate new arrival womens
		test.info("verify that menu is selected");
        WebElement NewwoMens = driver.findElement(By.xpath("//h1[@class ='header page-title text-uppercase m-0 p-0']"));
        String ActualTitleofwoMens = NewwoMens.getText();
        String ExpectedTitleofwoMens = "WOMENS";
        logger.info(NewwoMens.getText());
        if (ActualTitleofwoMens.equals(ExpectedTitleofwoMens)) {
            test.pass("Successfully clicked on the NewArrival of  " + ActualTitleofwoMens + " " + " ");
            logger.info("click Success New arrival womens");
        } else {
            test.fail("The page Title does not match expected " + ExpectedTitleofwoMens + " " + "  but found" + " " + ActualTitleofwoMens + " ");
            logger.info("Click failed");
        }
        
	}*/
	
	private void validateproductselect() {
		
		//validate the product is selected
		test.info("verify that product is selected");
		
        List<WebElement> pdpHeader = driver.findElements(By.xpath("//h1[@class ='product-name hidden-sm-down']"));
          

        if (pdpHeader.size()>0) {
        	WebElement pdpHeader1 = driver.findElement(By.xpath("//h1[@class ='product-name hidden-sm-down']"));
        	System.out.println("The product name is " +pdpHeader1);
            test.pass("Successfully clicked on the product from the product listing page");
            logger.info("Successfully clicked on the product from the product listing page");
        } else {
            test.fail("Product is not selected from the product listing page");
            logger.info("Product is not selected from the product listing page");
        }
		 
	}
	
	private void validateReviewProduct() {
		
		test.info("validate the Review of the product");
		// Find the element using XPath
		WebElement thankYouText = driver.findElement(By.xpath("//div[@class='header col-sm-12']/h1[contains(text(), 'Thank you!')]"));
		// Get the text value of the element
		String actualText = thankYouText.getText();
		// Define the expected text
		String expectedText = "Thank you!";
		// Validate if the text is displayed using a basic if condition
		if (actualText.equals(expectedText)) {
		    logger.info("The 'Thank you!' text is displayed on the page.");
		    test.pass("successfully writen the review");
		} else {
		    logger.info("The 'Thank you!' text is not displayed on the page.");
		    test.fail("Review is not done");
		}

		
	}

}