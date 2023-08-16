//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.providio.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class guestUserLoginPage {
    WebDriver lDriver;
    
   
    @FindBy(xpath = "//button[contains(text(),'Guest Checkout')]")
    WebElement guestCheckOut;
    @FindBy( xpath = "//input[@id='email-guest']")
    WebElement reEnterMailInGuest;
    @FindBy(xpath = "//button[contains(text(),' Continue as guest')]" )
    WebElement continueAsGuest;
   @FindBy(xpath = "//button[contains(@class,'js-cancel-login')]")
    WebElement guestCheckout1;

   @FindBy(xpath = "(//a[contains(text(),'Sign Up')])[2]")
   WebElement signUp;
   
   @FindBy(xpath = "//button[contains(text(),'Sign In')][1]")
   WebElement signIn;
   
   @FindBy( xpath = "//input[@id='email']")
   WebElement guestmail;
   @FindBy( xpath = "//input[@id='password']")
   WebElement guestPassword;
  
   @FindBy(xpath = "//button[@value='submit-login']")
   WebElement loginButton;
   
   @FindBy(xpath = "//a[@id='password-reset']")
   WebElement forgotPwd;
   
   @FindBy(xpath = "//input[@id='reset-password-email']")
   WebElement emailForgotPwd;
   
   @FindBy(xpath = "//button[contains(text(),'Send')]")
   WebElement sendButton;
   
   @FindBy(xpath = "(//button[contains(text(),'Login')])[2]")
   WebElement loginForgotPwd;
   //back to cart 
   @FindBy(xpath = "//a[@class='back-to-cart']")
   WebElement backToCart;
   
    public guestUserLoginPage(WebDriver rDriver) {
        this.lDriver = rDriver;
        PageFactory.initElements(rDriver, this);
    }

    public void clickOnGuestCheckOut() {
        this.guestCheckOut.click();
    }

    public void clickOnEmail(String reEnterMail) {
        this.reEnterMailInGuest.sendKeys(new CharSequence[]{reEnterMail});
      
    }
    public void clickOnEmailClear() {
       reEnterMailInGuest.clear();
      
    }
    public void clickOnContinueAsGuest() {
        this.continueAsGuest.click();
    }
    
    public void clickOnGuest() {
    	guestCheckout1.click();
    }
    
    public void clickOnSignUp() {
    	signUp.click();
    }
    public void clickOnSignIn() {
    	signIn.click();
    }

    public void clickOnGuestMail(String mail) throws InterruptedException {
        guestmail.clear();
    	guestmail.sendKeys( mail);
        Thread.sleep(2000L);
    }

    public void clickOnGuestPassword(String pwd ) throws InterruptedException {
        guestPassword.clear();
    	guestPassword.sendKeys(pwd);
        Thread.sleep(2000L);
    }
    
    public void clickOnLogin() {
    	loginButton.click();
    }
    public void clickOnForgotPwd() {
    	forgotPwd.click();
    }
    public void enterForgotPwdEmail() {
    	emailForgotPwd.sendKeys("akhila.m@etg.digital");
    }
   
    public void clickOnSend(WebDriver driver) {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", sendButton);
    	//sendButton.click();
    }
    
    public void clickOnLoginPwd() {
    	loginForgotPwd.click();
    }
    public void clickOnBackToCart() {
    	backToCart.click();
    }
}
