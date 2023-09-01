package com.providio.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productListingPage;
import com.providio.pageObjects.quickShopPage;


public class tc__QuickShopPage extends baseClass{
	SoftAssert softAssert = new SoftAssert();

	 @Test(
		        dependsOnMethods = {"com.providio.testcases.tc__Login.loginTest"}
		    )
	public void QucikShop() throws InterruptedException{
		
		//validate login
        if (isLoggedIn) {	
		
		//Navigation
		navigationPage NM = new navigationPage(driver);
		
		NM.clickwoMensMenubaritems(driver);
	    logger.info("Howered womens menu");
	    Thread.sleep(5000);
	  //clothing
	    NM.ClickwoMensofOutfits();
	    logger.info("Clicked womens of outfits");
	    Thread.sleep(5000);
	    
	  //validate womens of outFits
        WebElement outfits = driver.findElement(By.xpath("//h1[@class ='page-title']"));
        String ActualTitleofoutfits = outfits.getText();
        String ExpectedTitleofoutfits = "OUTFITS";
        logger.info(outfits.getText());
        if (ActualTitleofoutfits.equals(ExpectedTitleofoutfits)) {
            test.pass( "Successfully clicked on the Womens of  " + ActualTitleofoutfits + " ");
            logger.info("click Success Womens of outfits");
        } else {
            test.fail( "The page Title does not match expected " + ExpectedTitleofoutfits + " " + "  but found" + " " + ActualTitleofoutfits + " ");
            logger.info("Click failed");
        }
        
        //soft assertions new arrival womens
//      
//      softAssert.assertEquals(ActualTitleofoutfits, ExpectedTitleofoutfits, "Page title does not match expected value");
//      
//      //Hard assertions new arrival mens
//      
//      Assert.assertEquals(ActualTitleofoutfits, ExpectedTitleofoutfits, "Page title does not match expected value");
        
	    
	    
	    productListingPage plp = new productListingPage(driver);
	    
	    plp.selecttheFilters(2, driver);
	    logger.info("Selected the Filter");
	    
	    plp.selecttheWishlist();
	    logger.info("Add to the wishlist");
	    Thread.sleep(10000);
	    
	    plp.selectthecolorBlack(driver);
	    logger.info("Select the color Black");
	    
	    plp.selecttheResetButton();
	    logger.info("Cleard the filter");
	    
	    //plp.selectthesizes(driver);
	    logger.info("Select the sizes");
	    Thread.sleep(10000);
	    
	    plp.selectthePrice(driver);
	    logger.info("Select the Pricerange");
	    //Thread.sleep(10000);
	    
	    plp.selectthequickshope(driver);
	    
	  //Validation Quickshop
		
	       WebElement Quickshop = driver.findElement(By.xpath("//button[@class ='add-to-cart-global btn btn-primary']"));

	       String ActualTitleofquickshop = Quickshop.getText();     
	       String ExpectedTitleofquickshop = "ADD TO CART";
	       logger.info(Quickshop.getText());
	       
	       if (ActualTitleofquickshop.equals(ExpectedTitleofquickshop)) {
	           test.pass( "Successfully clicked on the mens of  " + ActualTitleofquickshop + " ");
	           logger.info("click Success Womens of Dresses");
	       } else {
	           test.fail( "The page Title does not match expected " + ExpectedTitleofquickshop + " " + "  but found" + " " + ActualTitleofquickshop + " ");
	           logger.info("Click failed");
	       }
			
	    
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
		
		qs.clickCloseButton();
		logger.info("Close the item");
		
		
		plp.selectthequickshope(driver);
		
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
		
		qs.clickPdpPageView();
		logger.info("Clicked on the view page");
		
//		qs.clickAddtocartbutton();
//		logger.info("clicked addtocart button");
		
		qs.clickAddtocartbuttoninplp();
		logger.info("clicked addtocart button");
		
		//Validation add to cart displayed
		
	       String ActualTitleofaddtothecart = driver.getTitle();  
	       String ExpectedTitleofaddtothecart = "Men's Pants Including Khakis, Cargos, Trousers, Jeans & More | RefArch";
	       logger.info(driver.getTitle());

	       
	       if (ActualTitleofaddtothecart.equals(ExpectedTitleofaddtothecart)) {
            test.pass( "Successfully clicked on the mens of  " + ActualTitleofaddtothecart + " ");
            logger.info("click Success Womens of Dresses");
        } else {
            test.fail( "The page Title does not match expected " + ExpectedTitleofaddtothecart + " " + "  but found" + " " + ActualTitleofaddtothecart + " ");
            logger.info("Click failed");
        }
        
        //soft assertions mens of pants
//      
//      softAssert.assertEquals(ActualTitleofaddtothecart, ExpectedTitleofDresses, "Page title does not match expected value");
//      
//      //Hard assertions womens of tops
//      
//      Assert.assertEquals(ActualTitleofaddtothecart, ExpectedTitleofDresses, "Page title does not match expected value");
	       
	       //softAssert.assertAll();

        } else {
            Assert.fail("User not logged in");
        }
        
        // Assert all the soft assertions
        softAssert.assertAll();

	}

}