package com.providio.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.pageObjects.checkOutPage;
import com.providio.pageObjects.loginPage;
import com.providio.pageObjects.miniCartPage;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.paymentpPage;
import com.providio.pageObjects.productListingPage;
import com.providio.pageObjects.quickShopPage;
import com.providio.pageObjects.reviewOrderPage;
import com.providio.pageObjects.viewCartPage;
import com.providio.paymentProccess.tc__CheckOutProcess;


public class tc__PlaceTheOrder extends baseClass{

	SoftAssert softAssert = new SoftAssert();

	 @Test(
		        dependsOnMethods = {"com.providio.testcases.tc__Login.loginTest"}
		    )
	public void Placetheorder() throws InterruptedException
	{
		 
		 
	//validate login
        if (isLoggedIn) {	
		
      //Navigate to the mens menu
		
		navigationPage n = new navigationPage(driver);
		
		n.clickMensMenubaritems(driver);
		logger.info("clicked menus");
		
		n.ClickMensofPants(driver);
		logger.info("clickd submenus");
		
		//validate mens of pants
        WebElement pants = driver.findElement(By.xpath("//h1[@class ='page-title']"));
        String ActualTitleofpants = pants.getText();
        String ExpectedTitleofpants = "PANTS";
        logger.info(pants.getText());
        if (ActualTitleofpants.equals(ExpectedTitleofpants)) {
            test.pass("Successfully clicked on the mens of  " + ActualTitleofpants + " ");
            logger.info("click Success Womens of Dresses");
        } else {
            test.fail( "The page Title does not match expected " + ExpectedTitleofpants + " " + "  but found" + " " + ActualTitleofpants + " ");
            logger.info("Click failed");
        }
        
        //soft assertions mens of pants
//      
//      softAssert.assertEquals(ActualTitleofDresses, ExpectedTitleofDresses, "Page title does not match expected value");
//      
//      //Hard assertions womens of tops
//      
//      Assert.assertEquals(ActualTitleofDresses, ExpectedTitleofDresses, "Page title does not match expected value");
        
		
		productListingPage plp = new productListingPage(driver);
		
		plp.selectthequickshope(driver);
		logger.info("selected the quick shop");
		
		//Validation Quickshop
		
       WebElement Quickshop = driver.findElement(By.xpath("//button[@class ='add-to-cart-global btn btn-primary']"));

       String ActualTitleofquickshop = Quickshop.getText();     
       String ExpectedTitleofquickshop = "ADD TO CART";
       logger.info(Quickshop.getText());
       
       if (ActualTitleofquickshop.equals(ExpectedTitleofquickshop)) {
           test.pass("Successfully clicked on the mens of  " + ActualTitleofquickshop + " ");
           logger.info("click Success Womens of Dresses");
       } else {
           test.fail( "The page Title does not match expected " + ExpectedTitleofquickshop + " " + "  but found" + " " + ActualTitleofquickshop + " ");
           logger.info("Click failed");
       }
		
		//soft assertions quick shop
//      
//      softAssert.assertEquals(ActualTitleofquickshop, ExpectedTitleofquickshop, "Page title does not match expected value");
//      
//      //Hard assertions womens of tops
//      
//      Assert.assertEquals(ActualTitleofquickshop, ExpectedTitleofquickshop, "Page title does not match expected value");
 
		
		quickShopPage qs = new quickShopPage(driver);
		
		qs.selectthesize();
		logger.info("Selected the size");
		
//		pto.selectwidthDropdown();
//		logger.info("selected the width");
		
		qs.clickAddtocartbutton();
		logger.info("clicked addtocart button");
		
		//Validation add to cart displayed
		
	       String ActualTitleofaddtothecart = driver.getTitle();  
	       String ExpectedTitleofaddtothecart = "Men's Pants Including Khakis, Cargos, Trousers, Jeans & More | RefArch";
	       logger.info(driver.getTitle());

	       
	       if (ActualTitleofaddtothecart.equals(ExpectedTitleofaddtothecart)) {
               test.pass("Successfully clicked on the mens of  " + ActualTitleofaddtothecart + " ");
               logger.info("click Success Womens of Dresses");
           } else {
               test.fail( "The page Title does not match expected " + ExpectedTitleofaddtothecart + " " + "  but found" + " " + ActualTitleofaddtothecart + " ");
               logger.info("Click failed");
           }
           
           //soft assertions mens of pants
//         
//         softAssert.assertEquals(ActualTitleofaddtothecart, ExpectedTitleofDresses, "Page title does not match expected value");
//         
//         //Hard assertions womens of tops
//         
//         Assert.assertEquals(ActualTitleofaddtothecart, ExpectedTitleofDresses, "Page title does not match expected value");


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