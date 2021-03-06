package Selenium_Programs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Navigations {

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
        //driver.manage().timeouts().implicitlyWait( 30, TimeUnit.SECONDS );

        driver.navigate().to( "https://www.google.com" );
        Thread.sleep( 5000 );
        driver.navigate().to( "https://www.ebay.com" );
        Thread.sleep( 5000 );

        driver.navigate().back();
        Thread.sleep( 5000 );
        driver.navigate().forward();
        Thread.sleep( 5000 );
        driver.navigate().refresh();


    }
}
