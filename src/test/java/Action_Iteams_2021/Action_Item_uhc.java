package Action_Iteams_2021;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


import java.util.ArrayList;

public class Action_Item_uhc {
    public static void main(String[] args) throws InterruptedException {

        //set up webdriver manager to handle dynamic browser versions
        WebDriverManager.chromedriver().setup();
        //Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        //options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //move to send tab using mouse Actions
        Actions mouseMove = new Actions(driver);

        //create array lists

        ArrayList<String> FirstName = new ArrayList<>();
        FirstName.add("AYMAN");
        FirstName.add("ARYAN");
        FirstName.add("SAHEIM");

        ArrayList<String> LastName = new ArrayList<>();
        LastName.add("KHAN");
        LastName.add("ALAM");
        LastName.add("ISLAM");

        ArrayList<String> DOB = new ArrayList<>();
        DOB.add("01161995");
        DOB.add("02161997");
        DOB.add("03161999");

        ArrayList<String> Zipcode = new ArrayList<>();
        Zipcode.add("11218");
        Zipcode.add("11206");
        Zipcode.add("11208");

        ArrayList<String> PlanId = new ArrayList<>();
        PlanId.add("1012253872");
        PlanId.add("1012253874");
        PlanId.add("1012253876");

        //iterate through the array list of First Name,Last Name,DOB,Zipcode and Plan Id
        for (int i = 0; i < FirstName.size(); i++) {
            //navigate to uhc website
            driver.navigate().to("https://www.uhc.com");
            //few seconds to wait
            Thread.sleep(3000);

            try {
                System.out.println("Hovering to Find a doctor tab");
                WebElement findaDoctor = driver.findElement(By.xpath("//*[@aria-label='Find a doctor']"));
                findaDoctor.click();
                Thread.sleep(5000);

            } catch (Exception err) {
                System.out.println("Unable to hover find a doctor tab" + err);
            }//end of send exception


            try {
                //to close the popup window
                System.out.println(" close the popup window");
                 driver.findElement(By.xpath("//*[@aid='ip-close']")).click();
                // Thread.sleep(5000);
            } catch (Exception err) {
                System.out.println("Unable to close popup menu"+ err);
            }//end of close popup window exception


            jse.executeScript("scroll(0,500)");
            Thread.sleep(1000);

            //Clicking in Select your plan to sign in button

            try {
                System.out.println("select your plan to sign in");
                WebElement selectPlan = driver.findElement(By.xpath("//*[@aria-labelledby='Select your plan to sign in']"));
                //mouseMove.moveToElement(selectPlan).perform();
                selectPlan.click();
                Thread.sleep(1000);
            } catch (Exception err) {
                System.out.println("Unable to select your plan to sign in tab" + err);
            }//end of SIGN IN  exception

            try {
                //to select and click medicare Plan from dropdown menu
                System.out.println("Click on medicare plan to sign in");
                WebElement medicarePlan = driver.findElement(By.xpath("//*[@aria-label='Medicare plan Opens a new window']"));
                //"//*[contains(@aria-label,'Medicare plan Opens a new window')]"

                //mouseMove.moveToElement(medicarePlan).click().perform();
                medicarePlan.click();
                Thread.sleep(1000);
            } catch (Exception err) {
                System.out.println("Unable to click Medicare plan"+ err);

            }//end of clicking medicare plan exception

            //switch to the new tab
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            Thread.sleep(3000);

            try {
                // click on register now
                System.out.println("Click on register now ");
                //click on register now
                //the * in an xpath makes your script ignore the tag that element is in. if 2 elements have the same xpath locators, but are in different tags
                //you can differentiate between them by putting the tag name instead of ignoring it with a *
                //ReUsableMethods.clickMethod(driver,"//button[contains(text(),'Register Now')]","");

                WebElement registerNow = driver.findElement(By.xpath("//*[@class='uhc-tempo-link uhc-tempo-link--medium registerBtn']"));
               registerNow.click();
               Thread.sleep(2000);
            } catch (Exception err) {
                System.out.println("Unable to click on register now"+ err);
            }//end of click on register now exception

            jse.executeScript("scroll(0,1000)");

            //switch to the new tab
            driver.switchTo().window(tabs.get(2));
            Thread.sleep(2000);

            try {
                //Enter first name
                System.out.println("entering First name on the box");
                WebElement firstName = driver.findElement(By.xpath("//*[@name='firstName']"));
                firstName.sendKeys(FirstName.get(i));
            } catch (Exception err) {
                System.out.println("Unable to click firstname"+ err);

            }//END OF EXCEPTION

            try {
                //Entering  last name on the box
                System.out.println("Entering on last name");
                WebElement lastName = driver.findElement(By.xpath("//*[@name='lastName']"));
               // mouseMove.moveToElement(lastName).click().perform();
                lastName.sendKeys(LastName.get(i));

            } catch (Exception err) {
                System.out.println("Unable to click on last name"+ err);
            }//end of exception
            //Thread.sleep(2000);

            //click on the value from the dropdown
            try {
                System.out.println("Entering DOB on the box");
               WebElement dobField=driver.findElement(By.xpath("//*[@id='piDoB']"));
               dobField.sendKeys(DOB.get(i));
            } catch (Exception err) {
                System.out.println("Unable to enter dob on the box"+ err);
            }//end of exception

            //Entering Zipcode on the box
            try {
                System.out.println("Entering zipcode on the box");
                WebElement zipCodeBox=driver.findElement(By.xpath("//*[@id='piZipCode']"));
                zipCodeBox.sendKeys(Zipcode.get(i));

            }catch (Exception err){
                System.out.println("Unable to enter zipcode on the box");
            }//end of exception

            //Entering plan member id
            try {
                System.out.println("Entering member id on the box");
                WebElement MemPlanId = driver.findElement(By.xpath("//*[*id='piMemberId4Mnr]"));
                MemPlanId.sendKeys(PlanId.get(i));

            } catch (Exception err) {
                System.out.println("Unable to enter member Id on the box"+ err);
            }//end of exception

            try {
                //click on continue button
                System.out.println("Click on continue button");
                WebElement CONbutton = driver.findElement(By.xpath("//*[@id='step1Btn']"));
                CONbutton.click();
                Thread.sleep(2000);
            } catch (Exception err) {
                System.out.println("Unable to click on continue button"+ err);
            }//end of continue exception

            //Capturing the err message from the page
            try {
                System.out.println("Capturing error message from continue");
                String errorMessage = driver.findElement(By.xpath("//*[@class='SummaryError_ErrorContent_body__abuTO']")).getText();
                System.out.println( errorMessage);
            } catch (Exception err) {
                System.out.println("Unable to capture error message " + err);
            }//end of get error message  exception
            driver.close();
            driver.switchTo().window(tabs.get(0));

        }//END OF FORLOOP

    }//end of main method
}//end of java class
