package com.providio.testcases;

import org.testng.annotations.Test;

public class tc__AddProductFromWishlist extends baseClass{

	@Test//( dependsOnMethods = {"com.providio.testcases.tc__Login.loginTest"})
	public void addProductFromWishlist() throws InterruptedException {

		//if (isLoggedIn) {
        driver.get(this.baseURL);        
        logger.info("enterd into url");
       
        tc__WishlistProccess  wishlist = new tc__WishlistProccess();
        wishlist.wishlistPage(driver);
		}
	}

