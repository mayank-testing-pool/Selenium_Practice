package Selenium_Programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DragnDropConcept {

    public static void main (String [] args) throws InterruptedException {
        WebDriver driver;
        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\mm18780\\Desktop\\Mayank\\Automation\\Selenium_Practice\\support\\chromedriver_2.41.exe" );
        ChromeOptions options = new ChromeOptions();
        options.addArguments( "--no-sandbox" );
        driver = new ChromeDriver( options );
        driver.manage().window().maximize();
        driver.navigate().to( "https://jqueryui.com/droppable/" );
        Thread.sleep( 3000 );

        driver.switchTo().frame( 0 );
        Thread.sleep( 3000 );
        Actions action = new Actions( driver);
        action.clickAndHold( driver.findElement( By.xpath("//*[@id=\'draggable\']") ) )
                .moveToElement( driver.findElement( By.xpath( "//*[@id=\'droppable\']" ) ) )
                .release()
                .build()
                .perform();

    }
}
