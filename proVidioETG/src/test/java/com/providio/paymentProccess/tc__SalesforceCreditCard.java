package com.providio.paymentProccess;


import java.io.FileInputStream;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.time.Duration;

import java.util.ArrayList;

import java.util.Date;

import java.util.List;

import java.util.Random;

 

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.CellType;

import org.apache.poi.ss.usermodel.DateUtil;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

 

public class tc__SalesforceCreditCard {
    static WebDriver ldriver;
    public  tc__SalesforceCreditCard(WebDriver rdriver) {

        ldriver = rdriver;

        PageFactory.initElements(rdriver, this);

    }

    //from excel

    public static  String selectedCardNumber ;
    public static String selectedCVV;
    public static String selectedExpiryDate;
    public static String  selectedYear; 
         public  static void paymentFromExcel (WebDriver driver) throws IOException, InterruptedException {

            // Path to your Excel file

           // String filePath = ;

            // Sheet name in the Excel file

            String sheetName = "Salesforce Integration";


            // Load the Excel file

            FileInputStream file = new FileInputStream("C:\\Users\\user\\git\\MuskuAkhilaRepo16\\proVidioETG\\testDate\\CreditCardFromExcel.xlsx");

            Workbook workbook = new XSSFWorkbook(file);

            Sheet sheet = workbook.getSheet(sheetName);

            // Get the card details from the Excel sheet

            List<String> cardNumbers = new ArrayList<>();

            List<String> cvvList = new ArrayList<>();

            List<String> expiryDates = new ArrayList<>();

           // List<String> years = new ArrayList<>();


            // Flag to skip the first row

            boolean isFirstRow = true;

 

            for (Row row : sheet) {

                if (isFirstRow) {

                    isFirstRow = false;

                    continue; // Skip the first row

                }

                Cell cardNumberCell = row.getCell(0);

                Cell cvvCell = row.getCell(1);

                Cell expiryDateCell = row.getCell(2);

                // Cell yearCell = row.getCell(3);
                String cardNumber = getCellValueAsString(cardNumberCell);
                String cvv = getCellValueAsString(cvvCell);
                String expiryDate = getMonthAndYearFromCellValue(expiryDateCell);

                //String year = getCellValueAsString(yearCell);

                cardNumbers.add(cardNumber);

                cvvList.add(cvv);

                expiryDates.add(expiryDate);

                // years.add(year);

            }


            Random random = new Random();

            int randomIndex = random.nextInt(cardNumbers.size());

 

            // Get the randomly selected card details

             selectedCardNumber = cardNumbers.get(randomIndex);

             selectedCVV = cvvList.get(randomIndex);

             selectedExpiryDate = expiryDates.get(randomIndex);

            // selectedYear = years.get(randomIndex);


             System.out.println(selectedCardNumber);

             System.out.println(selectedCVV);

             System.out.println(selectedExpiryDate );


             // Switch to the iframe for card number


             WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
             wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card number input frame']")));

             Thread.sleep(2000);
             WebElement cardNumberInput = driver.findElement(By.xpath("//input[@autocomplete='cc-number' and @inputmode='numeric']"));
             cardNumberInput.sendKeys(selectedCardNumber);
             Thread.sleep(2000);
             // Switch back to the main content
             driver.switchTo().defaultContent();
             
             wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure expiration date input frame']")));
             WebElement expiryDate = driver.findElement(By.xpath("//input[@autocomplete='cc-exp' and @inputmode='numeric']"));
             expiryDate.sendKeys(selectedExpiryDate);
             Thread.sleep(2000);
             // Switch back to the main content
             driver.switchTo().defaultContent();
             
             wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure CVC input frame']")));
             WebElement cvv = driver.findElement(By.xpath("//input[@autocomplete='cc-csc' and @inputmode='numeric']"));
             cvv.sendKeys(selectedCVV);
             Thread.sleep(2000);
             // Switch back to the main content
             driver.switchTo().defaultContent();


            // Close the Excel file
            workbook.close();
            file.close();
            }


         private static String getMonthAndYearFromCellValue(Cell cell) {
             if (cell == null) {
                 return "";
             }

             if (cell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell)) {

                 Date dateCellValue = cell.getDateCellValue();

                 SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");

                 SimpleDateFormat outputFormat = new SimpleDateFormat("MM/yy");

                 return outputFormat.format(dateCellValue);

             } else if (cell.getCellType() == CellType.STRING) {

                 return cell.getStringCellValue();

             } else {

                 return "";

             }

         }
        private static String getCellValueAsString(Cell cell) {
            if (cell == null) {
                return "";
            }

            switch (cell.getCellType()) {
                case NUMERIC:
                    return String.valueOf((long) cell.getNumericCellValue());
                case STRING:
                    return cell.getStringCellValue();
                default:
                    return "";
            }
        }

        public static void main(String[] args,WebDriver driver) throws IOException, InterruptedException {
        	tc__SalesforceCreditCard paymentPage = new tc__SalesforceCreditCard(driver);
        	tc__SalesforceCreditCard.paymentFromExcel(driver);
		}
}


 


     