package com.providio.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {

	WebDriver lDriver;
	public CreateAccount(WebDriver rDriver ){
			
			lDriver=rDriver;
			PageFactory.initElements(rDriver, this);
		}

		@FindBy(xpath = "//a[contains(text(),'Create Account')]")
		WebElement createAcc;
		
		@FindBy(id = "registration-form-fname")
		 WebElement firstNameInput;
		
		@FindBy(id = "registration-form-lname")
		 WebElement lastNameInput;
		
		@FindBy(id = "registration-form-phone")
		 WebElement phoneInput;
		
		@FindBy(id = "registration-form-email")
		 WebElement emailInput;
		
		@FindBy(id = "registration-form-email-confirm")
		 WebElement confirmEmailInput;
		
		@FindBy(id = "registration-form-password")
		 WebElement passwordInput;
		
		@FindBy(id = "registration-form-password-confirm")
		 WebElement confirmPasswordInput;
		
		@FindBy(xpath = "//button[contains(text(), 'Create Account')]")
		 WebElement createAccountButton;

		
		    public void clickOnCreateAcc(WebDriver driver) throws InterruptedException {
		        Thread.sleep(2000);
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("arguments[0].click();", createAcc);
		    }

		    public void enterFirstName(String firstName) {
		        firstNameInput.clear();
		        firstNameInput.sendKeys(firstName);
		    }

		    public void enterLastName(String lastName) {
		        lastNameInput.clear();
		        lastNameInput.sendKeys(lastName);
		    }

		    public void enterPhone(String phone) {
		        phoneInput.clear();
		        phoneInput.sendKeys(phone);
		    }

		    public void enterEmail(String email) {
		        emailInput.clear();
		        emailInput.sendKeys(email);
		    }

		    public void enterConfirmEmail(String confirmEmail) {
		        confirmEmailInput.clear();
		        confirmEmailInput.sendKeys(confirmEmail);
		    }

		    public void enterPassword(String passwordCreateAcc) {
		        passwordInput.clear();
		        passwordInput.sendKeys(passwordCreateAcc);
		    }

		    public void enterConfirmPassword(String ConfirmPasswordCreateAcc) {
		        confirmPasswordInput.clear();
		        confirmPasswordInput.sendKeys(ConfirmPasswordCreateAcc);
		    }

		    public void clickCreateAccountButton(WebDriver driver) throws InterruptedException {
		        Thread.sleep(2000);
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("arguments[0].scrollIntoView(true);", createAccountButton);
		        js.executeScript("arguments[0].click();", createAccountButton);
		    }


}
