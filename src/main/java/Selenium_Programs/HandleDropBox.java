package Selenium_Programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class HandleDropBox {

    public static void main (String[] args) throws InterruptedException {
        WebDriver driver;
        String path = System.getProperty("user.dir");
        System.out.println (path);
        System.setProperty( "webdriver.chrome.driver", path+"\\support\\chromedriver_2.41.exe" );
        ChromeOptions options = new ChromeOptions();
        options.addArguments( "--no-sandbox" );
        driver = new ChromeDriver( options );
        driver.manage().window().maximize();
        driver.navigate().to( "https://myjohndeereq.tal.deere.com/wps/portal/myjd/registration?requestFlow=myjdlogin&SRC=/mjd/my/login&TARGET=https:%2F%2Faxiomqa.tal.deere.com" );
        Thread.sleep( 10000 );


        //Handle a Drop Box

        Select select = new Select( driver.findElement( By.id("countryList") ) );
        select.selectByVisibleText( "India (India)" );
        Thread.sleep( 10000 );

        driver.quit();



    }
}
