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

        driver.findElement( By.xpath("//input[@class='gh-tb ui-autocomplete-input']") ).sendKeys( "Java" );


    }
}
