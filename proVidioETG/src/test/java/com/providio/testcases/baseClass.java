package com.providio.testcases;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.providio.pageObjects.homePage;
import com.providio.utilities.readConfig;
import com.providio.utilities.reportToMail;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;


public class baseClass {
	
	
	readConfig readconfig = new readConfig();
	
	//logindetails
	public String baseURL=readconfig.getApplicationURL();
	public String name=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public String reemail = readconfig.getReEnterMail();
	

	//shippingdetails
	public String fname =readconfig.getFName() ;
	public String lname = readconfig.getLName();
	public String address = readconfig.getAddress();
	public String cityname = readconfig.getCity();
	public String zipcode = readconfig.getzipcode();
	public String phonenumber =readconfig.getphone();
	
	//editpageDetails
	public String epfname =readconfig.getepFName() ;
	public String eplname = readconfig.getepLName();
	public String epconfirmEmail = readconfig.getepconformMail();
	public String eppassword = readconfig.getepconformpassword();
	
	//ProfilePaswordChange
	public String epcurrentPassword = readconfig.getepcurrentPassword();
	public String epnewPassword = readconfig.getepnewPassword();
	public String epnewPasswordConfirm = readconfig.getepnewPasswordConfirm();
	

	// to write a review
	public String  headline=readconfig.getWriteAReview();
	public String comment =readconfig.getComments();
	public String nickName =readconfig.getNickName();
	public String location=readconfig.getLocation();
	
	
	// In Find a store
	public String zipcodeStore =readconfig.getZipcodeInStore();
	
	//search bar
	public String searchBar =readconfig.searchSomething();
	
	//footer mail
	public String footerMail =readconfig.getFooterMail();
	
	//guest login details
	public String  guestmail =readconfig.getGuestMail();
	public String guestPassword = readconfig.getGuestPassword();
	public String reEnterMail=readconfig.getReEnterMail();

	
	public static WebDriver driver;
	public static   Logger logger ;
	protected static boolean isLoggedIn=false;
	
	private static ExtentReports report = new ExtentReports();
    private ExtentSparkReporter reporter = new ExtentSparkReporter("C:\\Users\\user\\eclipse-workspace\\Providio_25th\\AutomationsScripts-Etg-by-upendra-main\\proVidioETG_25th\\Reports\\ProvidioTestReport.html");
	
	//Reporting
	//static ExtentReports report;
	protected static ExtentTest test;

	@BeforeSuite
    public void setUpforReport() {
        report = new ExtentReports();
        report.attachReporter(reporter);
        
        initializeDriver() ;

	}
	@BeforeClass
	public void setUp() throws InterruptedException{
		
		Thread.sleep(2000);		
		test = report.createTest(getClass().getSimpleName());

	    logger = Logger.getLogger("Providio");
	    PropertyConfigurator.configure("log4j.properties");
	    
	    //logger.info(test);
		
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws InterruptedException {
		
		
		//Browser crashes
		if (!isBrowserRunning()) {
			
			logger.info("Relauching the browsesr");
			//testsuitRunner();    
        }

		
		//Taking screen short when error occurs
	    if (result.getStatus() == ITestResult.FAILURE) {

	    	test.fail(result.getThrowable().getClass().getSimpleName());
	    	test.fail(result.getThrowable());

	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        String fileName = result.getMethod().getMethodName() + "_" + ".png";

	            try {

	                System.out.println("Screenshot taken for test case: " + result.getMethod().getMethodName());  
	            	File destination = new File("./Screenshots/" + fileName);
	                FileUtils.copyFile(source, destination);
	                
	                String screenshotPath = destination.getAbsolutePath();
	                //test.addScreenCaptureFromPath(destination.getAbsolutePath()); // Add the screenshot to the test case report
	                //test.fail("Screenshot: " + test.addScreenCaptureFromPath(destination.getAbsolutePath()));
	                
	                test.fail("Screenshot",
	                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

	                
	        } catch (IOException e) {
	            System.out.println("Exception while taking screenshot: " + e.getMessage());
	        }
	    }
	    
	       /*     if(result.getStatus() == ITestResult.FAILURE) {
	    	  homePage hp =new homePage(driver);
              hp.clickOnLogo();
              logger.info("Test case failed and returned into homepage");
              Thread.sleep(3000);
	    }*/
	}
	
//	@AfterClass
//	public void afterClass() {
//		//report.removeTest(test);
//	   // report.endTest(test);
//	   
//	  
//	}
	
	
	   @AfterSuite
	    public void tearDown() throws IOException, EmailException, InterruptedException {
		  
		  
		   //Change the view  of the report
		   reporter.viewConfigurer().viewOrder().as(new ViewName[]{ViewName.DASHBOARD, ViewName.TEST}).apply();
		   report.flush();
		   

		   driver.get("C:\\Users\\user\\eclipse-workspace\\Providio_25th\\AutomationsScripts-Etg-by-upendra-main\\proVidioETG_25th\\Reports\\ProvidioTestReport.html");
			driver.manage().window().maximize();
			Thread.sleep(5000);
			// Take a screenshot of the entire browser window
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			// Define the destination path for the screenshot
			String screenshotPath = "C:\\Users\\user\\eclipse-workspace\\Providio_25th\\AutomationsScripts-Etg-by-upendra-main\\proVidioETG_25th\\Reports\\ReportsScreenshot.png";
			// Save the screenshot to the specified path
			FileUtils.copyFile(screenshot, new File(screenshotPath));

	      
	      //Report send to mail
		 reportToMail.Reporttomail();
	    }
	   
	   //Invoking the web chrome driver
	   /*
	    *  webdriver manager is a library which will manage and set up the specific browser and download  the executable driver 
	    *  driver:- by creating this instance we creating connection with specific browser
	    */
	   private void initializeDriver() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	    }
		
	   
	   //validate the browser is running or not
	   private boolean isBrowserRunning() {
		   try {
		        driver.getTitle();
		        return true;
		    } catch (NoSuchWindowException e) {
		        return false;
		    } catch (Exception e) {
		        // Handle any other exceptions
		        return false;
		    }
	    }
	   
	   
      //Invoking the test suit when ever browser crashes
	   public void executeTestSuite(String... suiteFiles) {
		   
		   logger.info("Coming here");
	        TestNG testng = new TestNG();
	        XmlSuite suite = new XmlSuite();
	        List<String> suiteFileList = new ArrayList<>();
	        Collections.addAll(suiteFileList, suiteFiles);
	        suite.setSuiteFiles(suiteFileList);
	        testng.setXmlSuites(Collections.singletonList(suite));
	        testng.run();
	    }
	   
	   //Browser crashes
	   public  void testsuitRunner() {
		   
			if (!isBrowserRunning()) {
				
				 String[] suiteFiles = {
				            "C:\\Users\\upendra\\git\\AutomationsScripts-Etg\\proVidioETG\\Excutingalltestcases.xml",

				            // Add more suite file paths if needed
				        };
				        executeTestSuite(suiteFiles);
	            
	        }
		   
	   }

	


	

	
}