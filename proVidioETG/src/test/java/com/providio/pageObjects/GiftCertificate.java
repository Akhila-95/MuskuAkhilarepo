package com.providio.pageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

public class GiftCertificate {

	 WebDriver lDriver;

	public GiftCertificate(WebDriver rDriver) {
		this.lDriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	
	
	
	//gift card
	@FindBy(xpath = "//a[contains(text(),'Gift Registry')]")
	WebElement giftCardElement;
	
	//amount
	@FindBy(xpath = "//div[@class='giftvalue-update']")
	WebElement amount;
	
	//amounnt drop down
	@FindBy(xpath = "//ul[@class='gift-amount']")
	WebElement amountDropdown;
	
	//friends name
	@FindBy(xpath = "//input[@id='giftcert_purchase_recipient']")
	WebElement friendsNameElement;
	
	//yoursname
	@FindBy(xpath = "//input[@id='giftcert_purchase_from']")
	WebElement fromName;
	
	@FindBy(xpath = "//input[@id='giftcert_purchase_recipientEmail']")
	WebElement friendsMail;
	
	@FindBy(xpath = "//input[@id='giftcert_purchase_confirmRecipientEmail']")
	WebElement confirmFriendsMail;
	
	@FindBy(xpath = "//button[@class='btn btn-block btn-primary addto-cartbtn']")
	WebElement addToCart;
	
	Faker faker =new Faker();

	public void clickAmount() {
	    amount.click();
	    List<WebElement> dropdown = amountDropdown.findElements(By.tagName("li"));
	    int randomIndex = new Random().nextInt(dropdown.size());
	    dropdown.get(randomIndex).click();
	    System.out.println("Selected from dropdown");
	}

	public void enterFriendsName(String friendsName) {
		friendsNameElement.clear();
	    friendsNameElement.sendKeys(friendsName);
	}
	public void enterFromName(String enterName) {
		fromName.clear();	  
	    fromName.sendKeys(enterName);
	}

	public void enterFriendsMail(String email1) {
		friendsMail.clear();
	    friendsMail.sendKeys(email1);
	}

	public void enterConfirmFriendsMail(String email2) {
		confirmFriendsMail.clear();
	    confirmFriendsMail.sendKeys(email2);
	}
	
	public void addToCartButton() {
		addToCart.click();
	}
	public void clickOnGiftCard(WebDriver driver) throws InterruptedException {
	
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", 	giftCardElement);
        //amount
    	//Thread.sleep(1000);
    	amount.click();
    	//dropdown
        List<WebElement> dropdown= amountDropdown.findElements(By.tagName("li"));
        int randomIndex = new Random().nextInt(dropdown.size());
        dropdown.get(randomIndex).click();
        System.out.println("Selected from dropdown");
        
        //Thread.sleep(1000);
        // friendsname
        String fakeName1 = faker.name().fullName();
        friendsNameElement.sendKeys(fakeName1);

        //Thread.sleep(1000);
        //yours name
        String yoursFakeName = faker.name().fullName();
        fromName.sendKeys(yoursFakeName);
        
       // Thread.sleep(1000);
        //friends mail
        String fakeEmail = faker.internet().emailAddress();
        friendsMail.sendKeys(fakeEmail);

       // Thread.sleep(1000);
        confirmFriendsMail.sendKeys(fakeEmail);
	

        addToCart.click();
        Thread.sleep(3000);
	
	}
	
	public void giftCertificatePage(WebDriver driver) throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", 	giftCardElement);
        //amount
    	Thread.sleep(3000);
    	amount.click();
    	//dropdown
        List<WebElement> dropdown= amountDropdown.findElements(By.tagName("li"));
        int randomIndex = new Random().nextInt(dropdown.size());
        dropdown.get(randomIndex).click();
        System.out.println("Selected from dropdown");
	}
	
	
}
