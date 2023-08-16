package com.providio.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
WebDriver lDriver;
	
	public homePage(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	
	//profile

			@FindBy(xpath = "(//span[@class='registered-user-message dropdown-toggle'])[1]")
			WebElement profile;
			public void hoverOnProfile(WebDriver driver) throws InterruptedException {
				Thread.sleep(2000);
				Actions action = new Actions(driver);
		    	action.moveToElement(profile).build().perform();
			}
			
			//drop down my account
			@FindBy(xpath = "(//a[contains(text(),'My Account')])[1]")
			WebElement myAccount;
			public void clickOnMyAccount() throws InterruptedException {
				Thread.sleep(2000);
				myAccount.click();
				
			}
			//my orders
			@FindBy(xpath = "(//a[contains(text(),'My Orders')])[1]")
			WebElement myOrders;
			public void clickOnMyOrders() {
				myOrders.click();
			}
			
			//logout
			@FindBy(xpath = "(//a[contains(text(),'Logout')])[1]")
			WebElement logout;
			public void clickOnLogout() {
				logout.click();
			}
			
			//wishlist
			@FindBy(xpath = "(//span[contains(text(),'Wishlist')])[1]")
			WebElement wishlist;
			public void clickOnWishlist(WebDriver driver) throws InterruptedException {
				Thread.sleep(5000);
				JavascriptExecutor js = (JavascriptExecutor)driver;
				 js.executeScript("arguments[0].click();", wishlist);
			}
			
			//search bar
			@FindBy(xpath = "//input[@name='q']")
			WebElement searchBar;
			public void clickOnSearchBar(String typeSomething) throws InterruptedException {
				Thread.sleep(2000);
				searchBar.sendKeys(typeSomething);
			}
			//clicked on searched product
			@FindBy(xpath = "(//span[@class='name'])[2]")
			WebElement searchProduct;
			public void clickOnSearchedProduct() throws InterruptedException {
				Thread.sleep(3000);
				searchProduct.click();
				
			}
	
	
			
		//to get back to homepage 
			@FindBy(xpath = "//img[@class='logo']")
			WebElement forHomePage;
			public void clickOnLogo() throws InterruptedException {
				Thread.sleep(5000);
				forHomePage.click();
				
			}
	//carousel left click
			@FindBy(xpath = "//div[@class='slick-prev d-none d-md-block slick-arrow']")
			WebElement leftCarousel;

			public void clickOnLeftCarousel() throws InterruptedException {
					
							for(int j=1;j<=3;j++) {
								leftCarousel.click();
								}
							Thread.sleep(2000);
			}
			
			//carousel right click
			@FindBy(xpath = "//div[@class='slick-next d-none d-md-block slick-arrow']")
			WebElement rightCarousel;

			public void clickOnRightCarousel() {
					
					for(int i=1;i<=3;i++)
						{
						rightCarousel.click();
						}
					
			}
	 //2nd womencategory
		@FindBy(xpath = "(//a[@href='/s/RefArch/womens/?lang=en_US'])[2]")
		WebElement womens;
		public void clickOnWomens() throws InterruptedException {
			Thread.sleep(2000);
			womens.click();
		}
			//clothing
				@FindBy(xpath="//a[@title='Clothing']")
				WebElement clothing;
				public void clickOnClothing() throws InterruptedException {
					Thread.sleep(2000);
					clothing.click();
				}
				

				//jewellery
				@FindBy(xpath = "//a[@title='Jewelry']")
				WebElement jewellery;
				public void clickOnJewellery() throws InterruptedException {
					Thread.sleep(2000);
					jewellery.click();
				}
				
				//accessories
				
				@FindBy(xpath = "//a[@title='Accessories']")
				WebElement accessoriesInWomens;
				public void clickOnAccessoriesInWomens() throws InterruptedException {
					Thread.sleep(2000);
					accessoriesInWomens.click();
				}
			
				
		// mens
		@FindBy(xpath = "(//a[@href='/s/RefArch/mens/?lang=en_US'])[2]")
		WebElement mens;
		public void clickOnMens() throws InterruptedException {
			Thread.sleep(2000);
			mens.click();
		}
		
				//suits
				@FindBy(xpath = "//a[@title='Suits']")
				WebElement suits;
				public void clickOnSuits() throws InterruptedException {
					Thread.sleep(2000);
					suits.click();
				}
				//jackets and coats
				@FindBy(xpath = "//a[@title='Jackets & Coats']")
				WebElement jacketsAndCoats;
				public void clickOnJacketsAndCoats() throws InterruptedException {
					Thread.sleep(2000);
					jacketsAndCoats.click();
				}
				//shorts
				@FindBy(xpath = "//a[@title='Shorts']")
				WebElement shorts;
				public void clickOnShorts() throws InterruptedException {
					Thread.sleep(2000);
					shorts.click();
				}
				//dress shirts
				@FindBy(xpath = "//a[@title='Dress Shirts']")
				WebElement dressShirts;
				public void clickOnDressShirts() throws InterruptedException {
					Thread.sleep(2000);
					dressShirts.click();
				}
				//pants
				@FindBy(xpath = "//a[@title='Pants']")
				WebElement pants;
				public void clickOnPants() throws InterruptedException {
					Thread.sleep(2000);
					pants.click();
				}
				//accessories 
				@FindBy(xpath = "//a[@title='Accessories']")
				WebElement accessoriesInMens;
				public void clickOnAccessoriesInMens() throws InterruptedException {
					Thread.sleep(2000);
					accessoriesInMens.click();
				}
			
			
			
	
		
		//OnlyAccessories
		@FindBy(xpath = "/s/RefArch/mens/accessories/?lang=en_US")
		WebElement onlyAccesories;
		public void clickOnOnlyAccesories() throws InterruptedException {
			Thread.sleep(2000);
			onlyAccesories.click();
		}
		
				
			
		//luggage
		@FindBy(xpath = "(//a[@href='/s/RefArch/mens/?lang=en_US'])[2]")
		WebElement luggage;
		public void clickOnLuggage() throws InterruptedException {
			Thread.sleep(2000);
			luggage.click();
		}
}
