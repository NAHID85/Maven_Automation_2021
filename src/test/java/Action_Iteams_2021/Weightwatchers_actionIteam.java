package Action_Iteams_2021;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class Weightwatchers_actionIteam {
    public static void main(String[] args) throws InterruptedException {
        //String location, address, schedule;

        String[] Zipcodes = new String[3];
        Zipcodes[0] = "11217";
        Zipcodes[1] = "11209";
        Zipcodes[2] = "11223";

        //set up webdriver manager to handle dynamic browser versions
        WebDriverManager.chromedriver().setup();
        //set up Chrome options for various properties for the driver
        ChromeOptions options = new ChromeOptions();
        //to maximized the screen
        options.addArguments("start-maximized");
        //to put it on private mode
        //options.addArguments("incognito");
        //to use driver as webdriver
        WebDriver driver = new ChromeDriver(options);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // Using for loop to iterate through these values
        for (int i = 0; i < Zipcodes.length; i++) {
            //navigate to weightwatchers webpage page
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop");
            //few seconds to wait
            Thread.sleep(2000);
            //to click on the weightwatchers studio link  icon
            driver.findElement(By.xpath("//*[@class='studioIcon-2TdMR']")).click();
            //click on search button by submit

            //store search field as a webelement for shortcut so we can reuse the locator again
            WebElement searchField = driver.findElement(By.xpath("//*[@id='location-search']"));

            // enter the zipcode to the search field & submit
            searchField.clear();
            searchField.sendKeys(Zipcodes[i]);
            searchField.submit();
            Thread.sleep(1000);
            //store the location button as a webelement
            WebElement location_clickButton = driver.findElement(By.xpath("//*[@id='location-search-cta']"));
            location_clickButton.submit();
            Thread.sleep(1000);
            List<WebElement> address = driver.findElements(By.xpath("//*[@class='container-3SE46']"));
            List<WebElement> schedule = driver.findElements(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']"));


           if (i == 0) {
                System.out.println(" zipcode " + Zipcodes[0]);
                Thread.sleep(1000);
            }
            if (i == 1) {
                System.out.println(" zipcode " + Zipcodes[1]);
                Thread.sleep(1000);
            }
            if (i == 2) {
                System.out.println(" zipcode  " + Zipcodes[2]);
                Thread.sleep(1000);
            } else

                //TO scroll down
                jse.executeAsyncScript("o+300");

                //To get the address for the zipcode 1
            if (i == 0)

                address.get(0).click();
            Thread.sleep(1000);

            if (i == 1)
                address.get(1).click();
            Thread.sleep(1000);

            if (i == 2)
                address.get(2).click();
            Thread.sleep(1000);

            // to scroll down
            jse.executeAsyncScript("scroll(-0,500");
            Thread.sleep(1000);

            schedule.get(i).submit();
            System.out.println(schedule.get(0));
            System.out.println(schedule.get(1));
            System.out.println(schedule.get(2));
            driver.quit();

        }//end of loop



    }//end of main method
}//end of java class
