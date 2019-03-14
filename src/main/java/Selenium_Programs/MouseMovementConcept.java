package Selenium_Programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementConcept {

    public static void main (String [] args) throws InterruptedException {
        WebDriver driver;
        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\mm18780\\Desktop\\Mayank\\Automation\\Selenium_Practice\\support\\chromedriver_2.41.exe" );
        ChromeOptions options = new ChromeOptions();
        options.addArguments( "--no-sandbox" );
        driver = new ChromeDriver( options );
        driver.manage().window().maximize();
        driver.navigate().to( "https://www.spicejet.com/" );
        Thread.sleep( 3000 );

        Actions action = new Actions(driver);
        action.moveToElement( driver.findElement( By.xpath("//*[@id=\'highlight-addons\']") ) ).build().perform();
        Thread.sleep( 3000 );
        driver.findElement( By.linkText( "Priority Check-in" ) ).click();


    }
}
