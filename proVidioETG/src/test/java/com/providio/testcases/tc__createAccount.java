		package com.providio.testcases;
		
		import org.openqa.selenium.By;
		import org.openqa.selenium.JavascriptExecutor;
		import org.openqa.selenium.WebElement;
		import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.providio.pageObjects.CreateAccount;
import com.providio.pageObjects.guestUserLoginPage;
import com.providio.pageObjects.loginPage;
		
		public class tc__createAccount extends baseClass{
			boolean openBrowserandClickSignInButtonset = false;
			 Faker faker = new Faker();
			
			@Test
			public void openBrowserandClickSignInButton() throws InterruptedException {
			    test.info("Open browser");
			    // Test Case 0: Open browser
			    driver.get(baseURL);
			    logger.info("Opened browser");
			    Thread.sleep(2000L);
			    loginPage lp = new loginPage(driver);
			    lp.clickSign();
			    logger.info("clicked on sign in");
			    
		        CreateAccount createAcc= new CreateAccount(driver);
		        
				createAcc.clickOnCreateAcc(driver);		
				logger.info("Clicked on create Account");
			   openBrowserandClickSignInButtonset = true;
			}
		
			
			@Test(priority = 1,dependsOnMethods = "openBrowserandClickSignInButton")
			public void  validateEmailAndConfirmEmail() throws InterruptedException {
				test.info("validating the Email And ConfirmEmail");
			if( openBrowserandClickSignInButtonset) {
				
				
				Thread.sleep(5000);
		        CreateAccount createAcc= new CreateAccount(driver);
		        	
				createAcc.enterFirstName(faker.name().firstName());		
				logger.info("Entered first Name");
				
				createAcc.enterLastName(faker.name().lastName());		
				logger.info("Entered lastName");
				
				createAcc.enterPhone(phonenumber);		
				logger.info("Entered phonenumber");
				
				createAcc.enterEmail("akhila@gmail.com");		
				logger.info("Enter email");
				
				createAcc.enterConfirmEmail("akhila@gmail.comm");		
				logger.info("Enter invalid confirmed email");
				
				createAcc.enterPassword(epnewPassword);		
				logger.info("Entered password");
						
				createAcc.enterConfirmPassword(epnewPasswordConfirm);		
				logger.info("Confirmed password");
				
				createAcc.clickCreateAccountButton(driver);		
				logger.info("Clicked on create account");
				Thread.sleep(5000);
				
				WebElement errorEmailElement = driver.findElement(By.xpath("//div[contains(text(),'Please enter the same value again.')]"));
				boolean isDisplayedinvalidEmail = errorEmailElement.isDisplayed();
				
				if( isDisplayedinvalidEmail ) {		
					test.pass("Test case passed and Error message is dispalyed as "+ errorEmailElement.getText());
					logger.info("Error message is dispalyed");
				}
				else {
					//Assert.fail("Error message is not dispalyed");
					test.fail("Test case failed and Error message is not dispalyed as "+ errorEmailElement.getText() );
					logger.info("Error message is not dispalyed");
				}
			}
			
		}
		@Test(priority = 2,dependsOnMethods = "openBrowserandClickSignInButton")
		public void passwordMismatch() throws InterruptedException {
			test.info("Validating the passwprd mismatch error");
			
		if(openBrowserandClickSignInButtonset)	{
		
				Thread.sleep(5000);
		        CreateAccount createAcc= new CreateAccount(driver);
		        
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("window.scrollBy(0, -500);");
		        
		     
				createAcc.enterFirstName(faker.name().firstName());		
				logger.info("Entered first Name");
				
				createAcc.enterLastName(faker.name().lastName());		
				logger.info("Entered lastName");
				
				createAcc.enterPhone(phonenumber);		
				logger.info("Entered phonenumber");
				
				createAcc.enterEmail("akhila@gmail.com");		
				logger.info("Enter email");
				
				createAcc.enterConfirmEmail("akhila@gmail.com");		
				logger.info("Entered  confirmed email");
				
				createAcc.enterPassword("Akhila@07");		
				logger.info("Entered password");
						
				createAcc.enterConfirmPassword("Akhila@077");		
				logger.info("incorrectPassword");
				
				createAcc.clickCreateAccountButton(driver);		
				logger.info("Clicked on create account");
				Thread.sleep(5000);
				
				WebElement passwordErrorElement = driver.findElement(By.xpath("//div[contains(text(),'Does not match password')]"));
				boolean isDisplayedErrorEmail = passwordErrorElement.isDisplayed();
				if(isDisplayedErrorEmail) {
					test.pass("Test case passed and Error message is dispalyed as  "+passwordErrorElement .getText());
					logger.info(" Showing this --Does not match password");
				}else {
					test.fail("Test case failed and Error message is not dispalyed as "+ passwordErrorElement .getText() );
					logger.info(" Not Showing this-- error Does not match password");
				}
			}
		}
			
			
		@Test(priority = 3,dependsOnMethods = "openBrowserandClickSignInButton")
		public void emptyText() throws InterruptedException {
			
			test.info("validating the error if empty text is passed");
				if( openBrowserandClickSignInButtonset)	{
					Thread.sleep(5000);
					CreateAccount createAcc= new CreateAccount(driver);
			        
			        JavascriptExecutor js = (JavascriptExecutor) driver;
			        js.executeScript("window.scrollBy(0, -500);");

					createAcc.enterFirstName("");		
					logger.info("Entered first Name");
					
					createAcc.enterLastName("");		
					logger.info("Entered lastName");
					
					createAcc.enterPhone("");		
					logger.info("Entered phonenumber");
					
					createAcc.enterEmail("");		
					logger.info("Enter email");
					
					createAcc.enterConfirmEmail("");		
					logger.info("Enter invalid confirmed email");
					
					createAcc.enterPassword("");		
					logger.info("Entered password");
							
					createAcc.enterConfirmPassword("");		
					logger.info("incorrectPassword");
					
					createAcc.clickCreateAccountButton(driver);		
					logger.info("Clicked on create account");
					Thread.sleep(3000);
					
					WebElement errorForEmptyText= driver.findElement(By.xpath("(//div[contains(text(),'This field is required.')])[7]"));
					boolean isDisplayedErrorForEmpty= errorForEmptyText.isDisplayed();
					if(isDisplayedErrorForEmpty) {
						test.pass(errorForEmptyText.getText() +" This Error is displaying if empty text is send " );
						logger.info(" This Error is displaying as "+ errorForEmptyText.getText());
					}else {
						test.fail(errorForEmptyText.getText() +" this Error is not displaying if empty text is send");
						logger.info(" This Error is not displaying as "+ errorForEmptyText.getText());
					}			
			}
		}
		
			@Test(priority = 4,dependsOnMethods = "openBrowserandClickSignInButton")
			public void validatePasswordStrength() throws InterruptedException {
				test.info("Validating password strength");
				
			if( openBrowserandClickSignInButtonset)	{
							
				Thread.sleep(5000);
				CreateAccount createAcc= new CreateAccount(driver);
		        
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("window.scrollBy(0, -500);");
		        

				createAcc.enterFirstName(faker.name().firstName());		
				logger.info("Entered first Name");
				
				createAcc.enterLastName(faker.name().lastName());		
				logger.info("Entered lastName");
				
				createAcc.enterPhone(phonenumber);		
				logger.info("Entered phonenumber");
				
				createAcc.enterEmail("akhil@gmail.com");		
				logger.info("Enter email");
				
				createAcc.enterConfirmEmail("akhil@gmail.com");		
				logger.info("Enter invalid confirmed email");
				
				createAcc.enterPassword("asddfdgd");		
				logger.info("Entered password");
						
				createAcc.enterConfirmPassword("asddfgsd");		
				logger.info("incorrectPassword");
				
				createAcc.clickCreateAccountButton(driver);		
				logger.info("Clicked on create account");
				Thread.sleep(5000);
		     
				
				WebElement errorForPasswordStrength= driver.findElement(By.xpath("//div[contains(text(),'This field needs at least 8 characters, 1 number, 1 lowercase letter, 1 uppercase letter, & 1 special character.')]"));
				boolean isDisplayedErrorForEmpty= errorForPasswordStrength.isDisplayed();
				if(isDisplayedErrorForEmpty) {
					test.pass(errorForPasswordStrength.getText() +" this Error is displaying" );
					logger.info(" This Error is displaying as "+ errorForPasswordStrength.getText());
				}else {
					test.fail(errorForPasswordStrength.getText() +" this Error is not displaying");
					logger.info(" This Error is not displaying as "+ errorForPasswordStrength.getText());
				}			
			}
		}
			
			@Test(priority = 5,dependsOnMethods = "openBrowserandClickSignInButton")
			public void validatingWithExistingAccount() throws InterruptedException {
			        test.info("Verifying the error with already created account");
			        
				if( openBrowserandClickSignInButtonset){
				
					CreateAccount createAcc= new CreateAccount(driver);
					logger.info("Creating account with valid credientials");
										
					createAcc.enterFirstName(faker.name().firstName());
					
					logger.info("Entered first Name");
					
					createAcc.enterLastName(faker.name().lastName());
					
					logger.info("Entered lastName");
					
					createAcc.enterPhone(phonenumber);
					
					logger.info("Entered phonenumber");
					
					createAcc.enterEmail("akhil@gmail.com");
					
					logger.info("Enter email");
					
					createAcc.enterConfirmEmail("akhil@gmail.com");
					
					logger.info("confirmed email");
					
					createAcc.enterPassword("Akhireddy@07");
					
					logger.info("Entered password");
							
					createAcc.enterConfirmPassword("Akhireddy@07");
					
					logger.info("Confirmed password");
					
					createAcc.clickCreateAccountButton(driver);		
					logger.info("Clicked on create account");
					Thread.sleep(5000);
			     
					}
	
			WebElement errorEmailAlreadyExists= driver.findElement(By.xpath("//div[contains(text(),'Already exists, Please enter another value.')]"));
			boolean textErrorEmailAlreadyExists= errorEmailAlreadyExists.isDisplayed();
			if( textErrorEmailAlreadyExists) {
				test.pass("Test case passed and Error message is displayed as" +errorEmailAlreadyExists.getText() );
				logger.info("Test case passed");
			}else {
				test.pass("Test case failed and Error message is not  displayed as" +errorEmailAlreadyExists.getText() );
				logger.info("Test case failed");
			}
		}
			
			@Test(priority = 6,dependsOnMethods = "openBrowserandClickSignInButton")
			public void validatingPhoneNumError() throws InterruptedException {
			        test.info("Verifying Phone number error");
			        
				if( openBrowserandClickSignInButtonset){
				
					CreateAccount createAcc= new CreateAccount(driver);
					logger.info("Creating account with valid credientials");
										
					createAcc.enterFirstName(faker.name().firstName());
					
					logger.info("Entered first Name");
					
					createAcc.enterLastName(faker.name().lastName());
					
					logger.info("Entered lastName");
					
					createAcc.enterPhone("124533");
					
					logger.info("Entered phonenumber");
					
					createAcc.enterEmail("akhil@gmail.com");
					
					logger.info("Enter email");
					
					createAcc.enterConfirmEmail("akhil@gmail.com");
					
					logger.info("confirmed email");
					
					createAcc.enterPassword("Akhireddy@07");
					
					logger.info("Entered password");
							
					createAcc.enterConfirmPassword("Akhireddy@07");
					
					logger.info("Confirmed password");
					
					createAcc.clickCreateAccountButton(driver);		
					logger.info("Clicked on create account");
					Thread.sleep(5000);
			     
					}
	
			WebElement phoneNumError= driver.findElement(By.xpath("//div[contains(text(),'Please enter a valid phone number')]"));
			boolean isDisplayedphoneNumError= phoneNumError.isDisplayed();
			if( isDisplayedphoneNumError) {
				test.pass("Test case passed and Error message is displayed as" + phoneNumError.getText() );
				logger.info("Test case passed");
			}else {
				test.pass("Test case failed and Error message is not  displayed as" + phoneNumError.getText() );
				logger.info("Test case failed");
			}
		}
			
			@Test(priority = 6,dependsOnMethods = "openBrowserandClickSignInButton")
			public void ValidatingEmailformatError() throws InterruptedException {
			        test.info("Verifying Email format  error");
			        
				if( openBrowserandClickSignInButtonset){
				
					CreateAccount createAcc= new CreateAccount(driver);
					logger.info("Creating account with valid credientials");
										
					createAcc.enterFirstName(faker.name().firstName());
					
					logger.info("Entered first Name");
					
					createAcc.enterLastName(faker.name().lastName());
					
					logger.info("Entered lastName");
					
					createAcc.enterPhone("124533");
					
					logger.info("Entered phonenumber");
					
					createAcc.enterEmail("akhilgmail.com");
					
					logger.info("Enter email");
					
					createAcc.enterConfirmEmail("akhil@gmail.com");
					
					logger.info("confirmed email");
					
					createAcc.enterPassword("Akhireddy@07");
					
					logger.info("Entered password");
							
					createAcc.enterConfirmPassword("Akhireddy@07");
					
					logger.info("Confirmed password");
					
					createAcc.clickCreateAccountButton(driver);		
					logger.info("Clicked on create account");
					Thread.sleep(5000);
			     
					}
	
			WebElement emailFormatError= driver.findElement(By.xpath("(//div[@id='form-email-error'])[2]"));
			boolean isDisplayedemailFormatError= emailFormatError.isDisplayed();
			if( isDisplayedemailFormatError) {
				test.pass("Test case passed and Error message is displayed as" + emailFormatError.getText() );
				logger.info("Test case passed");
			}else {
				test.pass("Test case failed and Error message is not  displayed as" + emailFormatError.getText() );
				logger.info("Test case failed");
			}
		}
			/*
			@Test(priority = 7,dependsOnMethods = "openBrowserandClickSignInButton")
			public void createAccountWithValidCredientials() throws InterruptedException {
			        test.info("Verifying  with valid data");
			        
				if( openBrowserandClickSignInButtonset){
				
					CreateAccount createAcc= new CreateAccount(driver);
					logger.info("Creating account with valid credientials");
										
					createAcc.enterFirstName(firstName);
					
					logger.info("Entered first Name");
					
					createAcc.enterLastName(lastName);
					
					logger.info("Entered lastName");
					
					createAcc.enterPhone(phoneNumber);
					
					logger.info("Entered phonenumber");
					
					createAcc.enterEmail("akhillla@gmail.com");
					
					logger.info("Enter email");
					
					createAcc.enterConfirmEmail("akhillla@gmail.com");
					
					logger.info("confirmed email");
					
					createAcc.enterPassword("Akhireddy@07");
					
					logger.info("Entered password");
							
					createAcc.enterConfirmPassword("Akhireddy@07");
					
					logger.info("Confirmed password");
					
					createAcc.clickCreateAccountButton(driver);		
					logger.info("Clicked on create account");
					Thread.sleep(10000);
			     
					}
	
				WebElement loginTitle = driver.findElement(By.xpath("//h1[@class='account-page-title']"));
				String expectedTitle = "Dashboard";
				String actualTitle = loginTitle.getText();

		        
		        if (actualTitle.equals(expectedTitle)) {
		        	test.pass("Account created sucessfully");         
		            logger.info("Account created sucessfully");
		            isLoggedIn = true;
		        } else {
		        	test.fail("The page Title does not match expected " + expectedTitle + " but found " + actualTitle);
		            logger.info("Click failed and account not created");
		            
		        }
		}*/
			
			public void createAccountFromCheckOut() throws InterruptedException {
				
				
				
				test.info("Verifying the by clicking on sign up in checkout");
				guestUserLoginPage guestLoginPage = new guestUserLoginPage(driver);
				guestLoginPage.clickOnSignUp();
				
				logger.info("Clicked on sign up button");
				 validateEmailAndConfirmEmail1() ;
				 passwordMismatch1();
				 emptyText1();
				 validatePasswordStrength1();
				 validatingWithExistingAccount1();
				 validatingPhoneNumError1();
				 ValidatingEmailformatError1();
				 createAccountWithValidCredientials();
			}
			@Test
			public void  validateEmailAndConfirmEmail1() throws InterruptedException {
				test.info("validating the Email And ConfirmEmail");
			
				
				Thread.sleep(5000);
		        CreateAccount createAcc= new CreateAccount(driver);
		        	
				createAcc.enterFirstName(faker.name().firstName());		
				logger.info("Entered first Name");
				
				createAcc.enterLastName(faker.name().lastName());		
				logger.info("Entered lastName");
				
				createAcc.enterPhone(phonenumber);		
				logger.info("Entered phonenumber");
				
				createAcc.enterEmail("akhila@gmail.com");		
				logger.info("Enter email");
				
				createAcc.enterConfirmEmail("akhila@gmail.comm");		
				logger.info("Enter invalid confirmed email");
				
				createAcc.enterPassword(epnewPassword);		
				logger.info("Entered password");
						
				createAcc.enterConfirmPassword(epnewPasswordConfirm);		
				logger.info("Confirmed password");
				
				createAcc.clickCreateAccountButton(driver);		
				logger.info("Clicked on create account");
				Thread.sleep(5000);
				
				WebElement errorEmailElement = driver.findElement(By.xpath("//div[contains(text(),'Please enter the same value again.')]"));
				boolean isDisplayedinvalidEmail = errorEmailElement.isDisplayed();
				
				if( isDisplayedinvalidEmail ) {		
					test.pass("Test case passed and Error message is dispalyed as "+ errorEmailElement.getText());
					logger.info("Error message is dispalyed");
				}
				else {
					//Assert.fail("Error message is not dispalyed");
					test.fail("Test case failed and Error message is not dispalyed as "+ errorEmailElement.getText() );
					logger.info("Error message is not dispalyed");
				}
			}
			
		
		@Test
		public void passwordMismatch1() throws InterruptedException {
			test.info("Validating the passwprd mismatch error");
			
		
				Thread.sleep(5000);
		        CreateAccount createAcc= new CreateAccount(driver);
		        
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("window.scrollBy(0, -500);");
		        
		     
				createAcc.enterFirstName(faker.name().firstName());		
				logger.info("Entered first Name");
				
				createAcc.enterLastName(faker.name().lastName());		
				logger.info("Entered lastName");
				
				createAcc.enterPhone(phonenumber);		
				logger.info("Entered phonenumber");
				
				createAcc.enterEmail("akhila@gmail.com");		
				logger.info("Enter email");
				
				createAcc.enterConfirmEmail("akhila@gmail.com");		
				logger.info("Entered  confirmed email");
				
				createAcc.enterPassword("Akhila@07");		
				logger.info("Entered password");
						
				createAcc.enterConfirmPassword("Akhila@077");		
				logger.info("incorrectPassword");
				
				createAcc.clickCreateAccountButton(driver);		
				logger.info("Clicked on create account");
				Thread.sleep(5000);
				
				WebElement passwordErrorElement = driver.findElement(By.xpath("//div[contains(text(),'Does not match password')]"));
				boolean isDisplayedErrorEmail = passwordErrorElement.isDisplayed();
				if(isDisplayedErrorEmail) {
					test.pass("Test case passed and Error message is dispalyed as  "+passwordErrorElement .getText());
					logger.info(" Showing this --Does not match password");
				}else {
					test.fail("Test case failed and Error message is not dispalyed as "+ passwordErrorElement .getText() );
					logger.info(" Not Showing this-- error Does not match password");
				}
			}
		
			
			
		@Test
		public void emptyText1() throws InterruptedException {
			
			test.info("validating the error if empty text is passed");
				
					Thread.sleep(5000);
					CreateAccount createAcc= new CreateAccount(driver);
			        
			        JavascriptExecutor js = (JavascriptExecutor) driver;
			        js.executeScript("window.scrollBy(0, -500);");

					createAcc.enterFirstName("");		
					logger.info("Entered first Name");
					
					createAcc.enterLastName("");		
					logger.info("Entered lastName");
					
					createAcc.enterPhone("");		
					logger.info("Entered phonenumber");
					
					createAcc.enterEmail("");		
					logger.info("Enter email");
					
					createAcc.enterConfirmEmail("");		
					logger.info("Enter invalid confirmed email");
					
					createAcc.enterPassword("");		
					logger.info("Entered password");
							
					createAcc.enterConfirmPassword("");		
					logger.info("incorrectPassword");
					
					createAcc.clickCreateAccountButton(driver);		
					logger.info("Clicked on create account");
					Thread.sleep(3000);
					
					WebElement errorForEmptyText= driver.findElement(By.xpath("(//div[contains(text(),'This field is required.')])[7]"));
					boolean isDisplayedErrorForEmpty= errorForEmptyText.isDisplayed();
					if(isDisplayedErrorForEmpty) {
						test.pass(errorForEmptyText.getText() +" This Error is displaying if empty text is send " );
						logger.info(" This Error is displaying as "+ errorForEmptyText.getText());
					}else {
						test.fail(errorForEmptyText.getText() +" this Error is not displaying if empty text is send");
						logger.info(" This Error is not displaying as "+ errorForEmptyText.getText());
					}			
			}
		
		
			@Test
			public void validatePasswordStrength1() throws InterruptedException {
				test.info("Validating password strength");
				
			
							
				Thread.sleep(5000);
				CreateAccount createAcc= new CreateAccount(driver);
		        
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("window.scrollBy(0, -500);");
		        

				createAcc.enterFirstName(faker.name().firstName());		
				logger.info("Entered first Name");
				
				createAcc.enterLastName(faker.name().lastName());		
				logger.info("Entered lastName");
				
				createAcc.enterPhone(phonenumber);		
				logger.info("Entered phonenumber");
				
				createAcc.enterEmail("akhil@gmail.com");		
				logger.info("Enter email");
				
				createAcc.enterConfirmEmail("akhil@gmail.com");		
				logger.info("Enter invalid confirmed email");
				
				createAcc.enterPassword("asddfdgd");		
				logger.info("Entered password");
						
				createAcc.enterConfirmPassword("asddfgsd");		
				logger.info("incorrectPassword");
				
				createAcc.clickCreateAccountButton(driver);		
				logger.info("Clicked on create account");
				Thread.sleep(5000);
		     
				
				WebElement errorForPasswordStrength= driver.findElement(By.xpath("//div[contains(text(),'This field needs at least 8 characters, 1 number, 1 lowercase letter, 1 uppercase letter, & 1 special character.')]"));
				boolean isDisplayedErrorForEmpty= errorForPasswordStrength.isDisplayed();
				if(isDisplayedErrorForEmpty) {
					test.pass(errorForPasswordStrength.getText() +" this Error is displaying" );
					logger.info(" This Error is displaying as "+ errorForPasswordStrength.getText());
				}else {
					test.fail(errorForPasswordStrength.getText() +" this Error is not displaying");
					logger.info(" This Error is not displaying as "+ errorForPasswordStrength.getText());
				}			
			}
	
			
			@Test
			public void validatingWithExistingAccount1() throws InterruptedException {
				
			        test.info("Verifying the error with already created account");	
				
					CreateAccount createAcc= new CreateAccount(driver);
					logger.info("Creating account with valid credientials");
										
					createAcc.enterFirstName(faker.name().firstName());
					
					logger.info("Entered first Name");
					
					createAcc.enterLastName(faker.name().lastName());
					
					logger.info("Entered lastName");
					
					createAcc.enterPhone(phonenumber);
					
					logger.info("Entered phonenumber");
					
					createAcc.enterEmail("akhil@gmail.com");
					
					logger.info("Enter email");
					
					createAcc.enterConfirmEmail("akhil@gmail.com");
					
					logger.info("confirmed email");
					
					createAcc.enterPassword("Akhireddy@07");
					
					logger.info("Entered password");
							
					createAcc.enterConfirmPassword("Akhireddy@07");
					
					logger.info("Confirmed password");
					
					createAcc.clickCreateAccountButton(driver);		
					logger.info("Clicked on create account");
					Thread.sleep(5000);
			     
					
	
			WebElement errorEmailAlreadyExists= driver.findElement(By.xpath("//div[contains(text(),'Already exists, Please enter another value.')]"));
			boolean textErrorEmailAlreadyExists= errorEmailAlreadyExists.isDisplayed();
			if( textErrorEmailAlreadyExists) {
				test.pass("Test case passed and Error message is displayed as" +errorEmailAlreadyExists.getText() );
				logger.info("Test case passed");
			}else {
				test.pass("Test case failed and Error message is not  displayed as" +errorEmailAlreadyExists.getText() );
				logger.info("Test case failed");
			}
		}
			
			@Test
			public void validatingPhoneNumError1() throws InterruptedException {
			        test.info("Verifying Phone number error");
			        
			
				
					CreateAccount createAcc= new CreateAccount(driver);
					logger.info("Creating account with valid credientials");
										
					createAcc.enterFirstName(faker.name().firstName());
					
					logger.info("Entered first Name");
					
					createAcc.enterLastName(faker.name().lastName());
					
					logger.info("Entered lastName");
					
					createAcc.enterPhone("124533");
					
					logger.info("Entered phonenumber");
					
					createAcc.enterEmail("akhil@gmail.com");
					
					logger.info("Enter email");
					
					createAcc.enterConfirmEmail("akhil@gmail.com");
					
					logger.info("confirmed email");
					
					createAcc.enterPassword("Akhireddy@07");
					
					logger.info("Entered password");
							
					createAcc.enterConfirmPassword("Akhireddy@07");
					
					logger.info("Confirmed password");
					
					createAcc.clickCreateAccountButton(driver);		
					logger.info("Clicked on create account");
					Thread.sleep(5000);
			     
					
	
			WebElement phoneNumError= driver.findElement(By.xpath("//div[contains(text(),'Please enter a valid phone number')]"));
			boolean isDisplayedphoneNumError= phoneNumError.isDisplayed();
			if( isDisplayedphoneNumError) {
				test.pass("Test case passed and Error message is displayed as" + phoneNumError.getText() );
				logger.info("Test case passed");
			}else {
				test.pass("Test case failed and Error message is not  displayed as" + phoneNumError.getText() );
				logger.info("Test case failed");
			}
		}		
			
		
			
			@Test
			public void ValidatingEmailformatError1() throws InterruptedException {
			        test.info("Verifying Email format  error");
			        
			
				
					CreateAccount createAcc= new CreateAccount(driver);
					logger.info("Creating account with valid credientials");
										
					createAcc.enterFirstName(faker.name().firstName());
					
					logger.info("Entered first Name");
					
					createAcc.enterLastName(faker.name().lastName());
					
					logger.info("Entered lastName");
					
					createAcc.enterPhone("9876543235");
					
					logger.info("Entered phonenumber");
					
					createAcc.enterEmail("akhilgmail.com");
					
					logger.info("Enter email");
					
					createAcc.enterConfirmEmail("akhil@gmail.com");
					
					logger.info("confirmed email");
					
					createAcc.enterPassword("Akhireddy@07");
					
					logger.info("Entered password");
							
					createAcc.enterConfirmPassword("Akhireddy@07");
					
					logger.info("Confirmed password");
					
					createAcc.clickCreateAccountButton(driver);		
					logger.info("Clicked on create account");
					Thread.sleep(5000);
			     
					
	
			WebElement emailFormatError= driver.findElement(By.xpath("//div[@id='form-email-error']"));
			boolean isDisplayedemailFormatError= emailFormatError.isDisplayed();
			if( isDisplayedemailFormatError) {
				test.pass("Test case passed and Error message is displayed as" + emailFormatError.getText() );
				logger.info("Test case passed");
			}else {
				test.pass("Test case failed and Error message is not  displayed as" + emailFormatError.getText() );
				logger.info("Test case failed");
			}
		}
			
			@Test
			public void createAccountWithValidCredientials() throws InterruptedException {
			        test.info("Verifying  with valid data");
			        
				
			        Faker faker = new Faker();
					CreateAccount createAcc= new CreateAccount(driver);
					logger.info("Creating account with valid credientials");
					String fakeName = faker.name().fullName();		
					createAcc.enterFirstName(fakeName);
					
					String fakeName1 = faker.name().name();
					logger.info("Entered first Name");
					
					createAcc.enterLastName(fakeName1);
					
					logger.info("Entered lastName");
					
					createAcc.enterPhone("9876543213");
					
					logger.info("Entered phonenumber");
					  String fakeEmail = faker.internet().emailAddress();
					  
					createAcc.enterEmail(fakeEmail);
					
					logger.info("Enter email");
					
					createAcc.enterConfirmEmail(fakeEmail);
					
					logger.info("confirmed email");
					String fakePassword = faker.internet().password();
					
				
					createAcc.enterPassword("AkhilaReddy@97");
					
					logger.info("Entered password");
							
					createAcc.enterConfirmPassword("AkhilaReddy@97");
					
					logger.info("Confirmed password");
					
					createAcc.clickCreateAccountButton(driver);		
					logger.info("Clicked on create account");
					Thread.sleep(10000);

			}
		}



