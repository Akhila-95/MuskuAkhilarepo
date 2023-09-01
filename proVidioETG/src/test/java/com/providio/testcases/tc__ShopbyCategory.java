//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.providio.testcases;

import com.providio.pageObjects.checkOutPage;
import com.providio.pageObjects.homePage;
import com.providio.pageObjects.loginPage;
import com.providio.pageObjects.miniCartPage;
import com.providio.pageObjects.paymentpPage;
import com.providio.pageObjects.productListingPage;
import com.providio.pageObjects.quickShopPage;
import com.providio.pageObjects.reviewOrderPage;
import com.providio.pageObjects.viewCartPage;
import com.providio.paymentProccess.tc__CheckOutProcess;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tc__ShopbyCategory extends baseClass {
	
	SoftAssert softAssert = new SoftAssert();


    @Test(
        dependsOnMethods = {"com.providio.testcases.tc__Login.loginTest"}
    )
    public void Shopbycategory() throws InterruptedException {
    	
    	
        if (isLoggedIn) {
        	
            homePage homepage = new homePage(driver);
            homepage.clickOnLogo(); 
            homepage.clickOnMens();
            logger.info("clicked on memns category in shop by category");
            
            homepage.clickOnJacketsAndCoats();
            logger.info("clciked on JacketsAndCoats");
            
            productListingPage plp = new productListingPage(driver);
            plp.selectthequickshope(driver);
            logger.info("clciked on quick shop");
            
            quickShopPage qs = new quickShopPage(driver);
            qs.clickFCarasol();
            logger.info("Click on the fCarosal");
            
            qs.clickBCarasol();
            logger.info("Click on the bCarosal");
            
            qs.selectthesize();
            logger.info("Selected the size");
            
            qs.clickIncQuantity();
            logger.info("Clicked on the Increase");
            
            qs.clickMinusQuantity();
            logger.info("Clicked on the minus");
            
            qs.clickAddtocartbutton();
            logger.info("clicked addtocart button");
            
            
	        //checkoutProcess
	        
         tc__CheckOutProcess cp = new tc__CheckOutProcess();
         
         cp.checkoutprocess();
         
        } else {
            Assert.fail("User not logged in");
        }

        // Assert all the soft assertions
        softAssert.assertAll();
    }
}