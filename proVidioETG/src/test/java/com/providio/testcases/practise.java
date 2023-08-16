package com.providio.testcases;

import org.testng.annotations.Test;

import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productListingPage;

public class practise  extends baseClass{
@Test
	public void practice() throws InterruptedException {
		
		driver.get("https://zzqi-002.dx.commercecloud.salesforce.com/s/RefArch/electronics/ipod%20%26%20mp3%20players/apple-ipod-shuffleM.html?lang=en_US");
		
//        navigationPage navMenu = new navigationPage(driver);
//        navMenu.clickwoMensMenubaritems(driver);
//        logger.info("hovered on Womens");
//        
//        navMenu.ClickMensofShirts();
//        logger.info("clicked on Braceletss  sub menu");
//        Thread.sleep(4000);
//        
//        productListingPage plp = new productListingPage(driver);
//        plp.selectProductRandom(driver);
//        
        Thread.sleep(4000);
        size s = new size();
        s.selectSize(driver);
	}
}
