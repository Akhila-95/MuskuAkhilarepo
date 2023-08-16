package com.providio.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

public class contactUsCustomerSupport {
	
	
	Faker faker = new Faker();
	
WebDriver lDriver;
	
	public contactUsCustomerSupport(WebDriver rDriver ){
		
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}

	//contact us button
	@FindBy(xpath="//div[@class='embeddedServiceHelpButton']//button")
	WebElement customerSupportButton;
	public void clickcustomerSupportButton(WebDriver driver) throws InterruptedException{
		
		customerSupportButton.click();

	}
	
	//Nameofthe customer	
	@FindBy(xpath="//input[@id='SuppliedName']")
	WebElement NameoftheCustomer;
	public void sendNameoftheCustomer(WebDriver driver) throws InterruptedException{
		
		NameoftheCustomer.sendKeys(faker.name().firstName());


	}
	
	//subject
	@FindBy(xpath="//input[@id='Subject']")
	WebElement subject;
	public void sendSubject(WebDriver driver) throws InterruptedException{
		
		subject.sendKeys(faker.lorem().sentence());
		
	}
	
	//Email of the coustamer
	@FindBy(xpath="//input[@id='SuppliedEmail']")
	WebElement emailofTheCustomer;
	public void sendEmailofTheCustomer(WebDriver driver) throws InterruptedException{
		
		emailofTheCustomer.sendKeys(faker.internet().emailAddress());

	}
	
	//issue of the customer
	@FindBy(xpath="//select[@id='Reason']")
	WebElement selecttheIssuesoftheCustomer;
	public void selecttheIssuesoftheCustomer(WebDriver driver) throws InterruptedException{
		
		Select select = new Select(selecttheIssuesoftheCustomer);

        // Select an option by visible text
        select.selectByVisibleText("Order Related");

	}
	
	//submit Button
		@FindBy(xpath="//button[contains(@class, 'submitButton') and contains(@class, 'uiButton--default') and contains(@class, 'embeddedServiceSidebarButton')]")
		WebElement submitButton;
		public void clicksubmitButton(WebDriver driver) throws InterruptedException{
			
			submitButton.click();

		}
		
		//done button
		
		//submit Button
		@FindBy(xpath="//button[contains(@class, 'dialogButton') and contains(@class, 'dialog-button-0') and contains(@class, 'uiButton--default') and contains(@class, 'uiButton') and contains(@class, 'embeddedServiceSidebarButton')]")
		WebElement doneButton;
		public void clickdoneButton(WebDriver driver) throws InterruptedException{
			Thread.sleep(5000);
			doneButton.click();

		}
	
}
