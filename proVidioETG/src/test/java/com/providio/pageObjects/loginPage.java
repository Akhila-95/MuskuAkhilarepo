package com.providio.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

WebDriver lDriver;
	
	public loginPage(WebDriver rDriver ){
		
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
		@FindBy(xpath="//span[contains(text(), 'Sign In')]")
		WebElement signIn;
		public void clickSign() 
		{
			signIn.click();
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
		//jsclick
		@FindBy(xpath="//button [contains(text(), 'Login')]")
		WebElement btnLoginjs;
		public void clickSubmitjs(WebDriver driver ) throws InterruptedException
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("arguments[0].click();", btnLoginjs);
			btnLogin.click();
			Thread.sleep(10000);
		}
		
        //Home page return
		@FindBy(xpath = "//img[@class='logo']")
		WebElement forHomePage;
		public void clickOnLogo(WebDriver driver) throws InterruptedException {
			Thread.sleep(5000);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("arguments[0].click();", forHomePage);
			
			//forHomePage.click();
			
		}
		
}	