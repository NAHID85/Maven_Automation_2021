package Action_Iteams_2021;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Action_Iteam_split_loop_Array {

    public static void main(String[] args) throws InterruptedException {
        String[] Name= new String[3];
        Name[0]="Ayman";
        Name[1]="Atif";
        Name[2]="Aslam";

        //set the property and path to your chromedriver
       // System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        //set up webdriver manager to handle dynamic browser versions
        WebDriverManager.chromedriver().setup();
        //Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("Incognito");
        options.addArguments("Headless");
        //define the chrome driver basically what driver I am going to use for automation
        WebDriver driver = new ChromeDriver();

        for(int i = 0; i < Name.length; i++){
            //navigate to bing search page
            driver.navigate().to("https://www.bing.com");

            //maximize the browser
            driver.manage().window().maximize();

            //put few seconds wait
            Thread.sleep(3000);

            //identify the search field and enter a keyword 'Name'
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Name[i]);

            //hit submit on the search icon
            driver.findElement(By.xpath("//*[@id='sb_form_q']")).submit();

            //every time you interact with a new page you should put sleep statement
            Thread.sleep(2000);

            //capture the search result and only print out the number
            String result = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();

            System.out.println("My full result is " + result);

            //extract out the number from the search result and print it using split
            String[] arrayResult = result.split(" ");
            System.out.println("My search number for name " + Name[i] + " is " + arrayResult[0]);
        }//end of loop
        driver.quit();

    }//end of main method

    }//end of java class
