package Day4_071821;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Google_Search_With_for_loop {

    public static void main(String[] args) throws InterruptedException {
        String[] cities = new String[3];
        cities[0] = "Brooklyn";
        cities[1] = "Queens";
        cities[2] = "Manhattan";

//set the property and path to your chromedriver
        // System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        //set up webdriver manager to handle dynamic browser versions
        WebDriverManager.chromedriver().setup();
        //Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        options.addArguments("Headless");
        //define the chrome driver basically what driver I am going to use for automation
        WebDriver driver = new ChromeDriver();

        for (int i = 0; i< cities.length; i++){
           // System.out.println(" My city is " + cities[i]);


      //  for (String city : cities) {
            //navigate to google search page
            driver.navigate().to("https://www.google.com");
            //maximize the browser
            // driver.manage().window().maximize();

            //put few seconds wait
            Thread.sleep(3000);

            //identify the search field and enter a keyword 'City'
            driver.findElement(By.xpath("//*[@id='input']")).sendKeys(cities);

            //hit submit on the search icon
            driver.findElement(By.xpath("//*[@name='q']")).submit();

            //every time you interact with a new page you should put sleep statement
            Thread.sleep(2000);

            //capture the search result and only print out the number
            String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();

            //extract out the number from the search result and print it using split
            String[] arrayResult = result.split(" ");
           System.out.println(" city " + cities + " is " + arrayResult[2]);

            System.out.println("My full result is " + result);

        }//end of loop

        driver.quit();

    }//end of main method
}//end of java class
