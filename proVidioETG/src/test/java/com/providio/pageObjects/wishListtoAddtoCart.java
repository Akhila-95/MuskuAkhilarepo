package com.providio.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class wishListtoAddtoCart {

WebDriver lDriver;
	
	public wishListtoAddtoCart(WebDriver rDriver ){
		
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	   //Wishlist button
	
		@FindBy(xpath="(//span[@class = 'sr-only' and text() ='Wishlist'])[1]")
		WebElement Wishlist;
		public void clickonWishlistButton(WebDriver driver) 
		{
			
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].click();", Wishlist);
			Wishlist.click();
		}
		
		@FindBy(name="loginEmail")
		WebElement email;
		public void setEmail(String name )
		{
			email.clear();
			email.sendKeys(name);
		}
		
		@FindBy(name="loginPassword")
		WebElement Password;
		public void setPassword(String password )
		{
			Password.clear();
			Password.sendKeys(password);
		}
		
		@FindBy(xpath="//button [contains(text(), 'Login')]")
		WebElement btnLogin;
		public void clickSubmit( ) throws InterruptedException
		{
			btnLogin.click();
			Thread.sleep(10000);
		}
        //Home page return
		@FindBy(xpath = "//img[@class='logo']")
		WebElement forHomePage;
		public void clickOnLogo() throws InterruptedException {
			Thread.sleep(5000);
			forHomePage.click();
			
		}
		
}	