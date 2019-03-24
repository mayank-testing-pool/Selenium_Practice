package Selenium_Programs;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AlertPopUpHandle {

    public static void main (String [] args) throws InterruptedException {
        WebDriver driver;
        String path = System.getProperty("user.dir");
        System.out.println (path);
        System.setProperty( "webdriver.chrome.driver", path+"\\support\\chromedriver_2.41.exe" );
        ChromeOptions options = new ChromeOptions();
        options.addArguments( "--no-sandbox" );
        driver = new ChromeDriver( options );
        driver.manage().window().maximize();
        driver.navigate().to( "https://mail.rediff.com/cgi-bin/login.cgi" );
        Thread.sleep( 10000 );
        driver.findElement( By.name("proceed") ).click();

        // Handle Alert

        Alert alert = driver.switchTo().alert();

        System.out.println( alert.getText());
        Thread.sleep( 1000);
        alert.accept();     //Click on Ok button

        //alert.dismiss();    // Click on cancel button
    }
}
