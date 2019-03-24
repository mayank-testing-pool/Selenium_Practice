package Selenium_Programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElementsConcepts {
    public static void main (String [] args) throws InterruptedException {
        WebDriver driver;
        String path = System.getProperty("user.dir");
        System.out.println (path);
        System.setProperty( "webdriver.chrome.driver", path+"\\support\\chromedriver_2.41.exe" );
        ChromeOptions options = new ChromeOptions();
        options.addArguments( "--no-sandbox" );
        driver = new ChromeDriver( options );
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout( 30, TimeUnit.SECONDS );
        driver.manage().timeouts().implicitlyWait( 30, TimeUnit.SECONDS );
        driver.navigate().to( "https://www.ebay.com" );


        // Find all the link on the page
        // Get the text of the link
        List<WebElement> linklist = driver.findElements( By.tagName("a") );
        System.out.println( "Total available link on the page are = "+linklist.size() );

        for (int i = 0; i<=linklist.size();i++)
        {
            String linktext = linklist.get( i ).getText();
            System.out.println( i+1 + " - Link - " +linktext );
        }



    }
}
