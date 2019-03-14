package Selenium_Programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleFileUploadPopUp {

    public static void main (String [] args) throws InterruptedException {
        WebDriver driver;
        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\mm18780\\Desktop\\Mayank\\Automation\\Selenium_Practice\\support\\chromedriver_2.41.exe" );
        ChromeOptions options = new ChromeOptions();
        options.addArguments( "--no-sandbox" );
        driver = new ChromeDriver( options );
        driver.manage().window().maximize();
        driver.navigate().to( "https://html.com/input-type-file/" );
        Thread.sleep( 10000 );
        driver.findElement( By.xpath( "//*[@id=\'fileupload\']" )).sendKeys("C:\\Users\\mm18780\\Desktop\\Sample.txt"  );


    }
}
