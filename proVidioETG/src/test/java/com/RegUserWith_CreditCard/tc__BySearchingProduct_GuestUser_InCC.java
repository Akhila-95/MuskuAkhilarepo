

package com.RegUserWith_CreditCard;

import com.providio.pageObjects.homePage;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.paymentProccess.tc__CheckOutProcess;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;
import com.providio.testcases.baseClass;
import com.providio.testcases.size;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tc__BySearchingProduct_GuestUser_InCC extends baseClass {
	int minicartCountValue;
	SoftAssert softAssert = new SoftAssert();

	@Test//(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
    public void bySearchingProduct() throws InterruptedException {
		    //step2 1: site url
			driver.get(baseURL);
			
        	//searching a product 
            homePage homepage = new homePage(driver);
            homepage.clickOnSearchBar(this.searchBar);
           test.info("searched a product " + this.searchBar);
            
            //clicked on searched product
            homepage.clickOnSearchedProduct();
            test.info("clicked on searched product");
            
            //count of cart before adding the product in cart 
            Thread.sleep(2000);
			List<WebElement> minicartcountList = driver.findElements(By.cssSelector(".minicart-quantity"));
			if(minicartcountList.size()>0) {
				 WebElement minicartcount = driver.findElement(By.cssSelector(".minicart-quantity"));
			    	String countOfMinicart = minicartcount.getText();
			   
			// Check if the string is not empty and contains only digits
			 if (!countOfMinicart.isEmpty() && countOfMinicart.matches("\\d+")) {
			        minicartCountValue = Integer.parseInt(countOfMinicart);
			        System.out.println("The minicart count before adding the product is " + minicartCountValue);    		
			      }
			 }
			
			 List<WebElement> pdpPage = driver.findElements(By.xpath("//button[contains(@class,'add-to-cart btn btn-primary')]"));
    		 if( pdpPage.size()>0) {
		          size s = new size();
		          s.selectSize(driver);
	    		 }
           // cart count after adding the product		 
            WebElement minicartcountafteradding =driver.findElement(By.cssSelector(".minicart-quantity"));
            String countOfMinicartafteradding = minicartcountafteradding.getText();
            int minicartCountValueafteradding = Integer.parseInt(countOfMinicartafteradding);

            logger.info("The minicart count after adding the product is"+minicartCountValueafteradding);

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
    }
}