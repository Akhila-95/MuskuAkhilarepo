

package com.providio.testcases;

import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.pageObjects.productListingPage;
import com.providio.paymentProccess.tc__CheckOutProcess;
import com.providio.paymentProccess.tc__CreditCardPaymentProcess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tc__GuestUser extends baseClass {
	SoftAssert softAssert = new SoftAssert();


    @Test
    public void guestlogin() throws InterruptedException {
    	
        driver.get(this.baseURL);
        logger.info("enterd into url");
        
        navigationPage navMenu = new navigationPage(driver);
        navMenu.clickelectronicsMenu(driver);
        logger.info("hovered on electronics");
        
        navMenu.ClickelectronicsofTelevisions(driver);
        logger.info("clicked on television sub menu");
        
        //validate the Television
        WebElement Televisions = driver.findElement(By.xpath("//h1[@class ='header page-title text-uppercase m-0 p-0']"));
        String ActualTitleofTelevisions = Televisions.getText();
        String ExpectedTitleofTelevisions = "TELEVISIONS";
        logger.info(Televisions.getText());
        if (ActualTitleofTelevisions.equals(ExpectedTitleofTelevisions)) {
            test.pass( "Successfully clicked on the electronics of  " + ActualTitleofTelevisions + " ");
            logger.info("Successfully clicked on the electronics of  " + ActualTitleofTelevisions + " ");
        } else {
            test.fail( "The page Title does not match expected " + ExpectedTitleofTelevisions + " " + "  but found" + " " + ActualTitleofTelevisions + " ");
            logger.info( "The page Title does not match expected " + ExpectedTitleofTelevisions + " " + "  but found" + " " + ActualTitleofTelevisions + " ");
        }

        productListingPage plp = new productListingPage(driver);
        
        plp.selectProductRandom(driver);
        logger.info("clicked on television product");
        
        productDescriptionPage pdp = new productDescriptionPage(driver);
        pdp.clickcartbutton(driver);
        logger.info("click on the add to cart button");
        
        //validate the productname
        String actualProductName = driver.getTitle();
        String expectedProductName = driver.getTitle();
        if (actualProductName.equals(expectedProductName)) {
            test.pass( "Successfully clicked on the electronics of  " + actualProductName + " ");
            logger.info("click Success Womens of Dresses");
        } else {
            test.fail( "The page Title does not match expected " + expectedProductName + " " + "  but found" + " " + actualProductName + " ");
            logger.info("Click failed");
        }

        		Thread.sleep(5000);
			     //checkoutProcess
			        
			     tc__CheckOutProcess cp = new tc__CheckOutProcess();			     
			     cp.checkoutprocess();
			     
			     //Payment process
		     
			     tc__CreditCardPaymentProcess cc = new tc__CreditCardPaymentProcess();			     
			     cc.paymentByCreditCard();
    }
}