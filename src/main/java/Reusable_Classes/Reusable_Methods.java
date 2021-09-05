package Reusable_Classes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Reusable_Methods {

    //reusable method for setDriver (chrome driver)
    public static  WebDriver setDriver() {
        //killing all the chrome instance that you have opened
        //Runtime.getRuntime().exec("taskkill /im chrome.exe /f");
        //setup your driver
        WebDriverManager.chromedriver().setup();
        //set the conditions for chromeoptions before the webdriver is defined
        ChromeOptions options = new ChromeOptions();
        //set arguments to maximize the driver and make it incognito
        options.addArguments("start-maximized");
        //options.addArguments("headless");
        //options.addArguments("incognito");
        //define the webdriver
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }//end of set driver method

    //verifying the title using if else
//method to compare expected title with actual
    public static void verifyPageTitle(WebDriver driver, String expectedTitle){
        //verifying the title using if else condition
        String actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title matches");
        } else {
            System.out.println("Title doesn't match " + actualTitle);
        }//end of get title condition
    }//end of verifyPageTitle


    //reusable method for sendKeys method
    public static void sendKeysMethod(WebDriver driver, String xpath, String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            System.out.println("Entering a value on " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.clear();
            element.sendKeys(userValue);
        } catch (Exception err) {
            System.out.println("Unable to enter a value on " + elementName + err);
        }//end of exception
    }//end of sendKeysMethod

    // reusable method for click method
    public static void clickMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            System.out.println("Clicking on " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
        } catch (Exception err) {
            System.out.println("Unable to click on " + elementName + err);
        }//end of exception
    }//end of clickMethod

    // reusable method for Get Text Method
    public static String getText(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        String Message = "";
        try {
            System.out.println(" Getting Text " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Message = element.getText();
        } catch (Exception err) {
            System.out.println("Unable to Get Text " + elementName + err);
        }
        return Message;
    }//End Of Get Text Method

    //method to verify if checkbox is selected or not
    public static void verifyStatusOfCheckbox(WebDriver driver,String xpath,boolean checkStatus, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,15);
        try{
            System.out.println("Verifying checkbox status of " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            boolean checkboxStatus = element.isSelected();
            if (checkboxStatus == checkStatus) {
                System.out.println("Checkbox is selected as expected on " + elementName);
            } else {
                System.out.println("Checkbox is not selected for " + elementName);
            }//end of condition
        } catch (Exception err) {
            System.out.println("Unable to click on " + elementName);
        }
    }//end of verifyStatusOfCheckbox

   /* //slider by SendKeys method
    public static void sliderSendKeysMethod(WebDriver driver, String xpath, int resetPoint, int desiredPoint, String elementName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 15);

        try {

            //storing the WebElement as a variable
            WebElement slider = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

            //calling mouse action to click on the slider
            Actions action = new Actions(driver);
            action.click(slider).build().perform();
            Thread.sleep(1500);

            //reset loop
            for (int i = 0; i < resetPoint; i++) {
                action.sendKeys(Keys.ARROW_LEFT).build().perform();
            }//end of reset

            Thread.sleep(1500);

            //desired loop
            for (int i = 0; i < desiredPoint; i++) {
                action.sendKeys(Keys.ARROW_RIGHT).build().perform();
                        Thread.sleep(1500);

            } catch (Exception e) {

                System.out.println("Unable to move the slider " +elementName + " " + e);

            }//end of slider by SendKeys method

    */

    //reusable method for mouse hover
    public static void mouseHover(WebDriver driver,String xpath, int indexNumber,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,15);
        Actions mouseMove = new Actions(driver);
        try {
            System.out.println("Hovering to Send tab"+elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            mouseMove.moveToElement(element).perform();
        } catch (Exception err){
            System.out.println(" Unable to hover to Send tab" + err);
        }//end of send tab exception
    }//end of mouseHover


    //slider by SendKeys method
    //if we want it for use in exl sheet then have to change int desiredPoint to String desiredPoint
    public static void sliderSendKeysMethod(WebDriver driver, String xpath, int resetPoint, int desiredPoint, String elementName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            //storing the WebElement as a variable
            WebElement slider = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

            //calling mouse action to click on the slider
            Actions action = new Actions(driver);
            action.click(slider).build().perform();
            Thread.sleep(1500);

            //reset loop
            for (int i = 0; i < resetPoint; i++) {
                action.sendKeys(Keys.ARROW_LEFT).build().perform();
            }//end of reset
            Thread.sleep(1500);

            //desired loop
            //converting String desired Point to integer
            //int intDesiredPoint =Integer.parseInt(desiredPoint);//for excel
            for (int i = 0; i < desiredPoint; i++) {
                action.sendKeys(Keys.ARROW_RIGHT).build().perform();
            }//end of desired
            Thread.sleep(1500);
        } catch (Exception e) {
            System.out.println("Unable to move the slider " + elementName + " " + e);
        }//end of slider by SendKeys method
    }//end of slider method



    public static String clickMethodByIndex(WebDriver driver, String xpath, int indexNumber, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        String Message = "";
        try {
            System.out.println("Getting number as a text " + "+indexNumber" + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        } catch (Exception err) {
            System.out.println("Unable to get text as index");

        }//end of exception
        return Message;
    }//end of get text by index number


    public static String getTextByIndex(WebDriver driver, String xpath, int indexNumber, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        String Result = "";
        try {
            System.out.println(" Getting Text " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            Result = element.getText();
            System.out.println("Result is " + Result);
        } catch (Exception err) {
            System.out.println("Unable to Get Text " + elementName);
        }
        return Result;
    }//end of getTextBy Index


    //reusable method for getTextByIndex
   /* public static String getTextByIndex(WebDriver driver, String xpath,String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        String Message = "";
        try {
            System.out.println("Getting number as a text " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        } catch (Exception err) {
            System.out.println("Unable to get text as index");

        }//end of exception
        return Message;
    } //end of get text by index number

    */


    //reusable method for selectMethod
    public static void selectMethod(WebDriver driver, String xpath, String choice, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            System.out.println("Selecting from dropdown menu " + elementName);
            //define object for the dropdown WebElement
            WebElement element = wait.until(presenceOfElementLocated(By.xpath(xpath)));
            //define object for selection and pass it the dropdown object
            Select choiceSelect = new Select(element);
            //use selectByVisbibleText method on to the selection object and pass it the choice
            choiceSelect.selectByVisibleText(choice);
        } catch (Exception err) {
            System.out.println("Unable to select from " + elementName + " " + err);
        }//end of try catch
    }//end of selectMethod


    //submit on element
    public static void submitMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            System.out.println("Submitting on " + elementName);
            WebElement element = wait.until(presenceOfElementLocated(By.xpath(xpath)));
            element.submit();
        } catch (Exception err) {
            System.out.println("Unable to submit on " + elementName + err);
        }//end of exception
    }//end of submit Method


    // reusable method for  scrolling
    public static void scrollingMethod(WebDriver driver,String coordinates ){
        WebDriverWait wait = new WebDriverWait(driver,15);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript(coordinates);
    }//end of scrolling



    //reusable method for drop down
    public static void dropDownMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            System.out.println("Clicking on dropdown button" + elementName);
            WebElement element = wait.until(presenceOfElementLocated(By.xpath(xpath)));
            element.click();
        } catch (Exception err) {
            System.out.println("Unable to click dropdown button" + elementName + err);
        }//end of exception
    }//end of dropDown method

}//end of java class



