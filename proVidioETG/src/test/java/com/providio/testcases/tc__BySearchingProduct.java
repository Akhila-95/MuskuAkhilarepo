

package com.providio.testcases;

import com.providio.pageObjects.homePage;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.paymentProccess.tc__CheckOutProcess;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tc__BySearchingProduct extends baseClass {
	
	SoftAssert softAssert = new SoftAssert();

	@Test//(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
    public void bySearchingProduct() throws InterruptedException {
    	
    	//validate the user login or not 
    	
    //    if (isLoggedIn) {
        	
		    //step2 1: site url
			driver.get("https://zzqi-002.dx.commercecloud.salesforce.com/s/RefArch/cowl-neck-tweed-pullover-sweater/25502346M.html?lang=en_US");
			
        	//Home page 
            homePage homepage = new homePage(driver);
            homepage.clickOnSearchBar(this.searchBar);
            logger.info("searched a product " + this.searchBar);
            
            homepage.clickOnSearchedProduct();
            logger.info("clicked on searched product");
            
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
		        
	       //checkoutProcess	        
            tc__CheckOutProcess cp = new tc__CheckOutProcess();            
            cp.checkoutprocess();
            
            //payment by credit card

		     tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();	     
		     cc.paymentByCreditCard();

            Thread.sleep(10000L);
   //     } else {
    //        Assert.fail("User not logged in");
    //    }
        
        // Assert all the soft assertions
        softAssert.assertAll();

    }
}