package Action_Iteams_2021;

import Reusable_Classes.Reusable_Methods;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Express_ActionItem_081721 {
    public static void main(String[] args) throws BiffException, IOException, InterruptedException, WriteException {

        //step 1: locate the file path where you saved it
        Workbook readableFile = Workbook.getWorkbook(new File("src/main/resources/Book1.xls"));
        //create a writable file that mimics the readable in order to write back your result
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/main/resources/Book1_results.xls"), readableFile);
        //Step 2: accessing the excel sheet from the workbook
        WritableSheet writableSheet = writableFile.getSheet(0);
        //Step 3: row count will return all the rows which is not empty
        int rowCount = writableSheet.getRows();


        //set the driver
        WebDriver driver = Reusable_Methods.setDriver();

        //Call the for loop to iterate   through the test data from excel
        for (int i = 1; i < rowCount; i++) {
            String desireSize = writableSheet.getCell(0, i).getContents();
            String quantity = writableSheet.getCell(1, i).getContents();
            String firstName = writableSheet.getCell(2, i).getContents();
            String lastName = writableSheet.getCell(3, i).getContents();
            String email = writableSheet.getCell(4, i).getContents();
            String phoNumber = writableSheet.getCell(5, i).getContents();
            String address = writableSheet.getCell(6, i).getContents();
            String address1 = writableSheet.getCell(7, i).getContents();
            String postalCode = writableSheet.getCell(8, i).getContents();
            String city = writableSheet.getCell(9, i).getContents();
            String state = writableSheet.getCell(10, i).getContents();

            //navigate to mlcalc
            driver.navigate().to("https://www.express.com");
            Thread.sleep(2500);

            //close pop up
            Reusable_Methods.clickMethod(driver, "//*[@id='closeModal']", "closePopUp");

            Thread.sleep(2500);

            Reusable_Methods.mouseHover(driver, "//*[@class='MegaMenu_primaryNav__3G5fm']", 1, "Man Tab");

            Reusable_Methods.clickMethod(driver, "//*[text()='Polos')]", "Polos");
            Thread.sleep(2000);
            //click on first polo
            Reusable_Methods.clickMethod(driver, "//*[@class='cdS1D9eKI7bXTMHp5xeAA']", "First Polo");
            Thread.sleep(2000);
            // Reusable_Methods.scrollingMethod(driver,"coordinates");
            //click on a size
            Reusable_Methods.clickMethod(driver, "//*[text()='" + desireSize + "']", "Sizes");
           /* Reusable_Methods.selectMethod(driver, "//*[@class='_2lcJtgWzF0q05mVFExRmDq']", desireSize, "size xs");
            //Thread.sleep(2000);
            Reusable_Methods.selectMethod(driver, "//*[@class='_29GwyLL9tJIABAZ0llJMdA']", desireSize, "size s");
            // Thread.sleep(2000);
            Reusable_Methods.selectMethod(driver, "//*[@class='_2lcJtgWzF0q05mVFExRmDq']", desireSize, "size m");
            // Thread.sleep(2000);

            */
            Reusable_Methods.clickMethod(driver, "//*[text()='Add to Bag']", "add to bag button");
            Thread.sleep(2000);
            Reusable_Methods.clickMethod(driver, "//*[@class='btn _9yfmt _194FD _2tFXQ']", "view bag button");
            Thread.sleep(2000);
            Reusable_Methods.clickMethod(driver, "//*[@id='qdd-0-quantity']", quantity);
           // Reusable_Methods.scrollingMethod(driver, "coordinator");
            Reusable_Methods.clickMethod(driver, "//*[@id='continue-to-checkout]", "CHECKOUT");
            Thread.sleep(200);
            Reusable_Methods.clickMethod(driver, "//*[@class='_1UFak _2YpK4 _1f9t- _2UzsqcoIQ8eUCvNG8QMTC7']", "check as guest");
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='firstname]", firstName, "First Name");
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='lastname']", lastName, "Last Name");
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='email']", email, "Email ID");
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='confirmEmail']", email, "Email ID");
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='phone']", phoNumber, "Phone Number");
            Reusable_Methods.clickMethod(driver, "//*[@type='submit']", "Continue button");
            Reusable_Methods.clickMethod(driver, "//*[@name='bluecoreCloseButton']", "close popup window");
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='shipping.line1']", address, "Address ");
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='shipping.line2']", address1, "Address for apt#");
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='shipping.postalCode']", postalCode, "Address ");
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='shipping.city']", city, "Address ");
            Reusable_Methods.selectMethod(driver, "//*[@name='shipping.state']", state, "new york");
            Reusable_Methods.clickMethod(driver, "//*[@type='submit']", "continue button");
            Thread.sleep(200);
            Reusable_Methods.clickMethod(driver, "//tagname[tex()='Continue']", "continue again");
            // Reusable_Methods.getText(driver,"//*[@class='_3hBmqHvu4lSjezHO1LfNwP _2Kgt1QRvRl-FndtrKjVT2_']","delivery option");
            // Reusable_Methods.getText(driver,"//*[@id='delivery-and-pickup']","delivery option");
            //ReUsableMethods.scrolling(driver,"scrollBy(0,5000)");


            //capture the delivery option and send it back to writable excel sheet
            String deliveryContent= Reusable_Methods.getText(driver,"//*[@class='_1Q4iDku_IopeC7OgnKsdoD]","Delivery text");
            System.out.println("delivery options are" +deliveryContent);
            //send the result back to the writable excel sheet
            Label label = new Label(12, i, deliveryContent);
            System.out.println(deliveryContent);
            writableSheet.addCell(label);

            //delete cookies
            driver.manage().deleteAllCookies();

        }//end of loop

        //write back to excel
        writableFile.write();
        //close the file
        writableFile.close();

        //outside of loop quit the driver
        driver.quit();

    }//end of main method
}//end of java class
