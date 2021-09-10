package Action_Iteams_2021;

import Reusable_Classes.Reusable_Methods;
import Reusable_Classes.Reusable_Methods_With_Logger;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class uhc_actionItem_with_reusableMethod {

    public static void main(String[] args) throws InterruptedException {
        /*
        //set up the driver as web driver manager
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.chromdriver().setup();
        //WebDriverManager.chromdriver().setup();
        ChromeOptions options= new ChromeOptions();
        //ChromeOptions options=new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("incognito");

        WebDriver driver = new ChromeDri er(options);

         */
        WebDriver driver = Reusable_Methods.setDriver();
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
            //click on find a doctor button
            try {
                System.out.println("click on find a doctor button");
                Reusable_Methods.clickMethod(driver,"//*[@aria-label='Find a doctor']","click doctor");

            }catch(Exception err){
                System.out.println("didn't click find a doctor"+err);
                Thread.sleep(5000);
            }//end of exception

                //close popup window
                try{
                    System.out.println("closed popup window");
                    Reusable_Methods.clickMethod(driver,"//*[@aid='ip-close']","popup button");

                }catch(Exception e){
                    System.out.println("didn't Closed popup"+e);
                }//end of exception
                //to scroll and click on select your plan
                jse.executeScript("scroll0,550");
                Thread.sleep(1000);

                //click on select your plan
            //ExtentTest logger;
            //logger = null;
          //  Reusable_Methods_With_Logger.clickMethod(driver,"//*[@aria-label='Find a doctor']","plan select",logger);
            Reusable_Methods.clickMethod(driver,"//*[@aria-labelledby='Select your plan to sign in']","select plan");
            Thread.sleep(1000);
            //Click on medicare link
            
        }//end of forloop


    }// end of main method
}//end of java class
