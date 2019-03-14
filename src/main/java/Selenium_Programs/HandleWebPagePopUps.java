package Selenium_Programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Iterator;
import java.util.Set;

public class HandleWebPagePopUps {
    public static void main (String [] args) throws InterruptedException {
        WebDriver driver;
        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\mm18780\\Desktop\\Mayank\\Automation\\Selenium_Practice\\support\\chromedriver_2.41.exe" );
        ChromeOptions options = new ChromeOptions();
        options.addArguments( "--no-sandbox" );
        driver = new ChromeDriver( options );
        driver.manage().window().maximize();
        driver.navigate().to( "http://popuptest.com/goodpopups.html" );
        Thread.sleep( 10000 );
        driver.findElement( By.xpath( "/html/body/table[2]/tbody/tr/td/font/b/a[2]" )).click();
        Set<String> handler  = driver.getWindowHandles();   //Set object does not store value based on indexes
        Iterator<String> it =handler.iterator();

        String parentwindowid = it.next();
        System.out.println("Parent Window Id = "+parentwindowid);

        String childwindowid = it.next();
        System.out.println("Parent Window Id = "+childwindowid);

        driver.switchTo().window( childwindowid );
        Thread.sleep( 10000 );
        System.out.println("Child Window Pop Up Title " +driver.getTitle()  );
        driver.close();

        driver.switchTo().window( parentwindowid );
        System.out.println("Parent Window Title " +driver.getTitle()  );



    }


}
