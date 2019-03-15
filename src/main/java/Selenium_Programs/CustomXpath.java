package Selenium_Programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class CustomXpath {

    public static void main (String [] args) throws InterruptedException {
        WebDriver driver;
        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\mm18780\\Desktop\\Mayank\\Automation\\Selenium_Practice\\support\\chromedriver_2.41.exe" );
        ChromeOptions options = new ChromeOptions();
        options.addArguments( "--no-sandbox" );
        driver = new ChromeDriver( options );
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout( 30,TimeUnit.SECONDS );
        driver.manage().timeouts().implicitlyWait( 30,TimeUnit.SECONDS );
        driver.navigate().to( "https://www.ebay.com" );

        //Absolute xpath
        //1 - Performance issue
        //2 - not reliable
        //3 - can be change at any time in future.

        //driver.findElement( By.xpath("//input[@class='gh-tb ui-autocomplete-input']") ).sendKeys( "Java" );

        //driver.findElement( By.xpath( "//input[@name='_nkw']" ) ).sendKeys( "Java" );

        // Customize xpath
        //1 - Fast in performance
        //2 - Syntex is simple
        //3 - its Generic

        //Using Contains function
        //driver.findElement( By.xpath( "//input[contains(@class,'gh-tb ui-autocomplete-input')]" )).sendKeys( "Java" );
        //driver.findElement( By.xpath( "//input[contains(@name,'_nkw')]" )).sendKeys( "Java" );

        //Using Starts-with
        //driver.findElement( By.xpath( "//input[starts-with(@class,'gh-tb ui')]" ) ).sendKeys( "Java" );

        //Using Ends-with
        //driver.findElement( By.xpath( "//input[ends-with(@class,'input')]" ) ).sendKeys( "Java" );

        //For Link

        driver.findElement( By.xpath( "//a[contains(text(),'Daily Deals')]") ).click();


    }
}
