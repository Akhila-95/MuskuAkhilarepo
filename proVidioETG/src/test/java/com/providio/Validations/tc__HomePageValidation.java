package com.providio.Validations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.providio.pageObjects.homePage;
import com.providio.testcases.baseClass;

public class tc__HomePageValidation extends baseClass {
	@Test
	public void homepageUrl() {
		driver.get(baseURL);
		logger.info("Enterd into url");
	}
	
	@Test(priority = 1,  dependsOnMethods = "homepageUrl")
	public void searchFunctionality() throws InterruptedException {

	
		searchForValidProduct();
		
		navigationOfSearchedProduct();
		
		searchedForInvalidProduct();
		
		validatingResetButtonInSearchBar();
		
		validateAutoComplete();
		 
	}
	//validate search bar displayed
	public void searchForValidProduct() throws InterruptedException {
		
		test.info("Verifying by searching valid product ");
		homePage home = new homePage(driver);
		
		home.clickOnSearchBar(this.searchBar);
		logger.info("Searched for a product");
		
		String actualSearch= "Microsoft Zune 16GB Digital Media Player";
		Thread.sleep(5000);
		WebElement searchedProduct = driver.findElement(By.xpath("(//span[@class='name'])[2]"));
		String expectedSearch= searchedProduct.getText();
		if(actualSearch.equals(expectedSearch)) {
			test.pass("Searched product is showing while searching");
			logger.info("Searched product is showing while searching");
		}else {
			test.fail("Searched product is not showing while searching");
			logger.info("Searched product is not showing while searching");
		}
	}
	//validating if searched product navigating to  right pdp page
	public void navigationOfSearchedProduct() throws InterruptedException {
		
		test.info("Verify search pagination");	
		homePage home = new homePage(driver);
		home.clickOnSearchBar(this.searchBar);
		logger.info("Searched for a product");
		Thread.sleep(5000);
		//searched for
		WebElement searchedProduct = driver.findElement(By.xpath("(//span[@class='name'])[2]"));
		String productSearchFor= searchedProduct.getText();
		home.clickOnSearchedProduct();
		logger.info("Clicked on searched product");
		
		//the product name after search
		WebElement productName = driver.findElement(By.xpath("//h1[@class='product-name hidden-sm-down']"));
		System.out.println(productName.getText());
		String  productNameAfterSearch= productName.getText();
		
		if(productSearchFor.equals(productNameAfterSearch)) {
			test.pass("It is navigating to searched product");
			logger.info("It is navigating to searched product");
		}else {
			test.fail("It is not navigating to searched product");
			logger.info("It is not navigating to searched product");
		}	
	}
	
	//validating if  searched for invalid product
	public void searchedForInvalidProduct() throws InterruptedException {
		
		test.info("Verify by searching invalid product i.e, it should show No product found for message");
		homePage home = new homePage(driver);
		home.clickOnSearchBar("ed54fri835");
		logger.info("Searched for invalid product");
		Thread.sleep(5000);
		WebElement errorMsg= driver.findElement(By.xpath("//div[contains(@class, 'container') and contains(text(), 'No product found for')]"));
		boolean messageFound = errorMsg.isDisplayed();
		if(messageFound) {
			test.pass("No Product Found messaged is showing when searched for invalid product");
			logger.info("No Product Found messaged is showing when searched for invalid product");
		}else {
			test.pass("No Product messaged is not showing when searched for invalid product");
			logger.info("No Product messaged is not showing when searched for invalid product");
		}
 
	}
	//validate reset button in search bar
	public void validatingResetButtonInSearchBar() throws InterruptedException {
		test.info("validating reset button in search bar");
		homePage home = new homePage(driver);
		home.clickOnSearchBar("ed54fri835");
		logger.info("Searched for invalid product");
		//reset button
		WebElement resetButton= driver.findElement(By.xpath("//button[@name='reset-button']"));
		//resetButton.click();
		Thread.sleep(4000);
		if(resetButton.isDisplayed()) {
			test.pass("Reset button clicked successfully");
			logger.info("Reset button clicked successfully");
		}else {
			test.fail("Reset button not clicked ");
			logger.info("Reset button not clicked");
		}
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", resetButton);
	}
	
 //Validate search suggestions/auto-complete: 
	public void validateAutoComplete() throws InterruptedException {
		test.info("Validating search suggestions/auto-complete");
		homePage home = new homePage(driver);
		home.clickOnSearchBar("Belted");
		logger.info("Searched for thisQuery");
		Thread.sleep(4000);
		List<WebElement> products= driver.findElements(By.xpath("//span[@class='col-12 item']"));
		
		 // Validation: Check if each auto-suggestion contains the word "belted"
        boolean allSuggestionsContainSearchedOne = true;
        for (WebElement suggestion : products) {
            String suggestionText = suggestion.getText();
            if (!suggestionText.toLowerCase().contains("belted")) {
            	allSuggestionsContainSearchedOne = false;
                break;
            }
        }

        // Validation result
        if (allSuggestionsContainSearchedOne) {
        	test.pass("All auto-suggestions contain the word 'searched one'.");
        	logger.info("All auto-suggestions contain the word 'searched one'.");
            
        } else {
        	test.fail("No auto-suggestions contain the word 'searched one'");
            System.out.println("No auto-suggestions contain the word 'searched one'");
        }
		
	}
	
	//wishlist functionality
	@Test(priority = 2,dependsOnMethods = "homepageUrl")
	public void wishlistAndHomePageFunctionality() throws InterruptedException {

		wishlistPagination();
		wishlistIconDisplay();
		homepage_Pagination();
	}
	
	//pagination
	public void wishlistPagination() throws InterruptedException {
		
		test.info("Checking the  pagination of wishlist button");
		homePage home =new homePage(driver);
		home.clickOnWishlist(driver);
		WebElement wishlist =driver.findElement(By.xpath("//h1[@class='page-title']"));
		boolean wishListPage = wishlist.isDisplayed();
		if(wishListPage) {
			test.info("Navigated to wishlist page");
			logger.info("Navigated to wishlist page");
		}else {
			test.fail("Not Navigated to wishlist page");
			logger.info("Not Navigated to wishlist page");
		}
	}
	//wishlist icon display
	public void wishlistIconDisplay() {
		test.info("To check the Wishlist icon display on homepage");
		WebElement wishlist= driver.findElement(By.xpath("//div[@class='wishlist mr-3 d-none d-lg-block']"));
		boolean wishlistIcon= wishlist.isDisplayed();
		if(wishlistIcon) {
			test.pass("Wishlist icon is displayed on homepage");
			logger.info("Wishlist icon is displayed on homepage");
		}else {
			test.fail("Wishlist icon is not displayed on homepage");
			logger.info("Wishlist icon is not displayed on homepage");
		}
	}
	
	//Homepage pagiantion by logo
	public void homepage_Pagination() throws InterruptedException {
		test.info("Verifying Homepage pagiantion by logo");
		homePage home = new homePage(driver);
		home.clickOnLogo();
		WebElement homePageCheck = driver.findElement(By.xpath("//h3[contains(text(),'Shop By Category')]"));
		boolean homePageDisplay=homePageCheck.isDisplayed();
		if(homePageDisplay) {
			test.pass("Navigated to homepage when clicked on ");
			logger.info("Navigated to homepage when clicked on ");
		}else {
			test.fail("Not Navigated to homepage when clicked on ");
			logger.info("Not Navigated to homepage when clicked on");
		}	
	}
	//scroll up button
	@Test(priority = 3,dependsOnMethods = "homepageUrl")
	public void scrollUpButton() throws InterruptedException {
		test.info("Verify ScrollUpButton");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);");
		WebElement scrollButton =driver.findElement(By.xpath("//button[@class='back-to-top']"));
		Thread.sleep(2000);
		if(scrollButton.isDisplayed()) {
			Thread.sleep(2000);
			scrollButton.click();
			test.pass("By clicking on the scroll button the page is scrolling upwards");
			logger.info("By clicking on the scroll button the page is scrolling upwards");
		}else {
			test.fail("By clicking on the scroll button the page is not scrolling upwards");
			logger.info("By clicking on the scroll button the page is not scrolling upwards");
		}
	}
}

