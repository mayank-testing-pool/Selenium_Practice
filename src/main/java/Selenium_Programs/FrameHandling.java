package Selenium_Programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class FrameHandling {

    public static void main (String [] args) throws InterruptedException {
        WebDriver driver;
        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\mm18780\\Desktop\\Mayank\\Automation\\Selenium_Practice\\support\\chromedriver_2.41.exe" );
        ChromeOptions options = new ChromeOptions();
        options.addArguments( "--no-sandbox" );
        driver = new ChromeDriver( options );
        driver.manage().window().maximize();
        driver.navigate().to( "http://www.globalsqa.com/demo-site/frames-and-windows/" );
        Thread.sleep( 1000 );

        // Find all the frames on the page
        List<WebElement> frames = driver.findElements( By.tagName( "iframe" ) );
        System.out.println("Total number of frames available on the page are "+ frames.size()  );

        driver.findElement( By.xpath( "//*[@id=\"iFrame\"]" ) ).click();
        driver.switchTo().frame( "globalSqa" );
        Thread.sleep( 1000 );
        driver.findElement( By.xpath( "//*[@id=\'mobile_menu_toggler\']" ) ).click();
        Thread.sleep( 1000 );
        driver.findElement( (By.linkText( "Home" )) ).click();


    }
}
