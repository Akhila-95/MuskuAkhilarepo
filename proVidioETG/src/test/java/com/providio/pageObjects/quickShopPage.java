package com.providio.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class quickShopPage {
	
WebDriver lDriver;
	
	public quickShopPage(WebDriver rDriver ){
		
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	//Select size
	@FindBy(xpath="//select[@class='custom-select form-control select-size']")
	WebElement sizeDropdown;	
	public void selectthesize() throws InterruptedException{
		Select sizeSelect = new Select(sizeDropdown);
		
		List<WebElement> options = sizeSelect.getOptions();
	    
	    List<String> enabledSizes = new ArrayList<>();
	    
	    int optionIndex = 0;
	    
	    System.out.println(options.size());

	    for (WebElement option : options) {

	    	if (optionIndex > 0 && option.isEnabled()) {
	    		
	    		String text = option.getText();
	    		  //System.out.println(text);

	            if (!text.isEmpty()) {      	
	            	String value = option.getAttribute("data-attr-value");
	                enabledSizes.add(value);
	                //System.out.println(value);
	                option.click();
	                break; 
	                // Select the first enabled size and exit the loop
	            }
	            
	    	}
	    	
	    }
	            
        //sizeSelect.selectByIndex(1);
        Thread.sleep(3000);
	}
	
	//selectwidth
	@FindBy(xpath="//select[@id='width-null']")
	WebElement widthDropdown;		
	public void selectwidthDropdown() throws InterruptedException{
        Select widthSelect = new Select(widthDropdown);
        widthSelect.selectByIndex(1);
        Thread.sleep(3000);
	}
	
	//Addtocartbutton
	@FindBy(xpath="//button[@class ='add-to-cart-global btn btn-primary']")
	WebElement Addtocartbutton;
	public void clickAddtocartbutton() throws InterruptedException{
		
		 Addtocartbutton.click();	
	     Thread.sleep(5000);
	}
	
	
			
	//Addtocartbutton
	@FindBy(xpath="(//button[@class = 'add-to-cart btn btn-primary flex-grow-1'])[1]")
	WebElement AddtocartButtoninPlp;
	public void clickAddtocartbuttoninplp() throws InterruptedException{
		
		AddtocartButtoninPlp.click();	
	     Thread.sleep(5000);
	}
	//BackCarosoul
	@FindBy(xpath="//button[@class ='slick-prev slick-arrow']")
	WebElement BCarasol;
	public void clickBCarasol() throws InterruptedException{
		BCarasol.click();	
	    Thread.sleep(2000);
	    BCarasol.click();	
	    Thread.sleep(2000);
	}
	//ForwardCarosoul
	@FindBy(xpath="//button[@class ='slick-next slick-arrow']")
	WebElement FCarasol;
	public void clickFCarasol() throws InterruptedException{
		FCarasol.click();	
	    Thread.sleep(2000);
	    FCarasol.click();	
	    Thread.sleep(2000);
	}
	//PlusQuantity
	@FindBy(xpath="//span[@class ='qty-plus']")
	WebElement inCreaseQuantity;
	public void clickIncQuantity() throws InterruptedException{
		inCreaseQuantity.click();	
	    Thread.sleep(2000);
	    inCreaseQuantity.click();		
	    Thread.sleep(2000);
	}
	
	//MinusQuantity
	@FindBy(xpath="//span[@class ='qty-minus']")
	WebElement MinusQuantity;
	public void clickMinusQuantity() throws InterruptedException{
		MinusQuantity.click();	
	    Thread.sleep(2000);
//	    MinusQuantity.click();		
//	    Thread.sleep(2000);
	}
	
	//CloseButton
	@FindBy(xpath="//button[@class ='close pull-right' and @type ='button']")
	WebElement CloseButton;
	public void clickCloseButton() throws InterruptedException{
		CloseButton.click();	
	    Thread.sleep(2000);

	}
	
	//PDP page view
	@FindBy(xpath="//a[@class ='full-pdp-link']")
	WebElement PdpPageView;
	public void clickPdpPageView() throws InterruptedException{
		PdpPageView.click();	
	    Thread.sleep(2000);

	}
	
	//color (//button[@class ='color-attribute swatch-attr-style selectable'])[2]
	
//	@FindBy(xpath="//button[@aria-label ='Select Color Navy']")
//	WebElement color;
//	public void clickcolor() throws InterruptedException{
//		
//		
//		
//		color.click();	
//	    Thread.sleep(2000);
//
//	}
//	
	public void clickcolor(WebDriver driver) throws InterruptedException {
		
        Random random = new Random();
        List<WebElement> products = driver.findElements(By.xpath("//button[contains(@class, 'color-attribute') and contains(@class, 'swatch-attr-style') and contains(@class, 'selectable') ]"));
        int totalProductcount = products.size();
        System.out.println(totalProductcount);
        int randomselectProduct = random.nextInt(totalProductcount);
        System.out.println(randomselectProduct);
//        ScrollBarfuctions sbf = new ScrollBarfuctions();
//        sbf.scrollmedium(driver);
        WebElement RandomSelectProductFormPLP = driver.findElement(By.xpath("(//button[contains(@class, 'color-attribute') and contains(@class, 'swatch-attr-style') and contains(@class, 'selectable') ])[" + randomselectProduct + "]"));
        
        RandomSelectProductFormPLP.click();
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("arguments[0].click();", RandomSelectProductFormPLP);
        //RandomSelectProductFormPLP.click();
    }
	
//	public void clickcolor(WebDriver driver) throws InterruptedException {
//	    Random random = new Random();
//	    List<WebElement> products = driver.findElements(By.xpath("//button[@class='color-attribute swatch-attr-style selectable']"));
//	    int totalProductcount = products.size();
//	    
//	    if (totalProductcount > 0) {
//	        int randomSelectProduct = random.nextInt(totalProductcount);
//	        WebElement randomSelectProductFormPLP = products.get(randomSelectProduct);
//	        randomSelectProductFormPLP.click();
//	    } else {
//	        System.out.println("No products found.");
//	    }
//	}

	
	
	
	
}
