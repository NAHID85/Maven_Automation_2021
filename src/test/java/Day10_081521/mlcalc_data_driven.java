package Day10_081521;

import Reusable_Classes.Reusable_Methods;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.File;


public class mlcalc_data_driven {
    public static void main(String[] args) throws Exception {
        //step 1: locate the file path where you saved it
        Workbook readableFile = Workbook.getWorkbook(new File("src/main/resources/mlcal_Exl_081521.xls"));
        //create a writable file that mimics the readable in order to write back your result
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/main/resources/mlcalc_Exl_081521_results.xls"), readableFile);
        //Step 2: accessing the excel sheet from the workbook
        WritableSheet writableSheet = writableFile.getSheet(0);
        //Step 3: row count will return all the rows which is not empty
        int rowCount = writableSheet.getRows();


        //set the driver
        WebDriver driver = Reusable_Methods.setDriver();

        //Call the for loop to iterate   through the test data from excel
        for (int i = 1; i < rowCount; i++) {
            String purchasePrice = writableSheet.getCell(0, i).getContents();
            String dowPayment = writableSheet.getCell(1, i).getContents();
            String morTerm = writableSheet.getCell(2, i).getContents();
            String intRate = writableSheet.getCell(3, i).getContents();
            String starMonth = writableSheet.getCell(4, i).getContents();
            String starYear = writableSheet.getCell(5, i).getContents();

            //navigate to mlcalc
            driver.navigate().to("https://www.mlcalc.com");
            Thread.sleep(2500);
            //enter the purchase price
            Reusable_Methods.sendKeysMethod(driver, "//*[@id='ma']", purchasePrice, "Purchase Price");
            //enter the down payment
            Reusable_Methods.sendKeysMethod(driver, "//*[@id='dp']", dowPayment, "Down Payment");
            //enter the mortgage term
            Reusable_Methods.sendKeysMethod(driver, "//*[@id='mt']", morTerm, "Mortgage Term");
            //enter the interest rate
            Reusable_Methods.sendKeysMethod(driver, "//*[@id='ir']", intRate, "Interest Rate");
            //click on show advance options
            Reusable_Methods.clickMethod(driver, "//*[text()='Show advanced options']", "Show Advance Options");
            //select the start month
            Reusable_Methods.selectMethod(driver, "//*[@name='sm']", starMonth, "Start Month");
            //select the start year
            Reusable_Methods.selectMethod(driver, "//*[@name='sy']", starYear, "Start Year");
            //click on calculate
            Reusable_Methods.clickMethod(driver, "//*[@value='Calculate']", "Calculate");

            //capture the monthly payment and send it back to writable excel sheet
            String result = Reusable_Methods.getTextByIndex(driver, "//div[@style='font-size: 32px']", 0, "Monthly Payment");
            System.out.println("My monthly payment is " + result);

            //capture the monthly payment and send it back to writable excel sheet
           // String message = Reusable_Methods.getText(driver,"//*[//div[text()='Monthly Payment']/preceding::div]","Monthly Payment");

            //send the result back to the writable excel sheet
            Label label = new Label(7, i, result);
            writableSheet.addCell(label);

            //*[@style='font-size: 32px

        }//end of for loop

        //write back to excel
        writableFile.write();
        //close the file
        writableFile.close();

        //outside of loop quit the driver
        driver.quit();


    }//end of main method
}//end of java class


