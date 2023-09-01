package com.providio.pageObjects;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.providio.testcases.baseClass;
import com.providio.testcases.size;


public class VariationProductFromExcel extends baseClass{
	public List<String> readDataFromExcel(String filePath, String sheetName) throws IOException {

		List<String> data = new ArrayList<String>();
		FileInputStream file = new FileInputStream(new File(filePath));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetName);

		boolean isFirstRow = true; // Flag to skip the first row

	    for (Row row : sheet) {
	        // Skip the first row
	        if (isFirstRow) {
	            isFirstRow = false;
	            continue;
	        }

	        for (Cell cell : row) {
	            String stringValue = cell.toString();
	            data.add(stringValue);
	        }
	    }

		
		 
		workbook.close();
		return data;
	}

	
	public String pickRandomValueWithoutDuplicate(List<String> dataList) {
		if (dataList.isEmpty()) {
			return null; 
		}

		Random random = new Random();
		int index = random.nextInt(dataList.size());
		String randomValue = dataList.get(index);
		dataList.remove(index);

		return randomValue;
	}

	
	public void performRandomOperations(WebDriver driver) throws InterruptedException {
		
		String filePath = "C:\\Users\\user\\git\\MuskuAkhilaRepo16\\proVidioETG\\testDate\\VariationProductSkew.xlsx";
		String sheetName = "SkewId";

		try {
			List<String> dataList = readDataFromExcel(filePath, sheetName);
			int totalProducts = dataList.size();
			// Remove spaces from each element in the dataList
		    for (int i = 0; i < dataList.size(); i++) {
		        String element = dataList.get(i);
		        element = element.replace(" ", "");
		        dataList.set(i, element);
		    }

		    // Print the updated dataList
		 
			System.out.println(dataList);
			int operations = 0;

			while (true) {
				String randomValue = pickRandomValueWithoutDuplicate(dataList);
				System.out.println("Searched for "+randomValue+ " product Id");
				if (randomValue == null) {
					System.out.println("No data found");
					break; // No more values to pick
				}
				if (randomValue != null) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					try {
						WebElement element1 = driver.findElement(By.xpath("//input[@name='q']"));
						element1.sendKeys(randomValue);
					} catch (NoSuchElementException e) {

						System.out.println("Element not found: " + e.getMessage());
					}
					Thread.sleep(2000);
					// clicked the product searched product
					try {
						WebElement element = driver.findElement(By.xpath("//span[@class='name']"));
						Thread.sleep(2000);
						js.executeScript("arguments[0].click();", element);
						
				//validation of product by the skew id
						Thread.sleep(2000);
						WebElement searchedForProduct= driver.findElement(By.xpath("//div[@class='product-number d-flex align-items-center ']/span"));
						String searchedForText= searchedForProduct.getText();
						System.out.println("The product ID in PDP is "+ searchedForText);
						if(randomValue.equals(searchedForText)) {
							test.pass(" searched for for the right product and product id is " +randomValue );
							logger.info("Searched for right product");
							
							 size s = new size();
							 s.selectSize(driver);
						}
						else {
							test.fail("Searched product and the product after search are not matching");
							logger.info("Searched product and the product after search are not matching");
						}

					}catch (NoSuchElementException e) {
						System.out.println("Element not found: " + e.getMessage());
					}
					
					dataList.remove(randomValue);
					System.out.println(" After searching the product we have this in datalist"+ dataList);	
								
					Thread.sleep(5000);
					operations++;
					//break;
				  }
				}

				System.out.println("Total data: " + totalProducts);
				System.out.println("Total operations performed: " + operations);
			}
		
	catch (IOException e) {
	
			e.printStackTrace();
		}
		
	}
}

