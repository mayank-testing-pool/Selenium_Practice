package Selenium_Programs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ImpliciteWaitConcept {
        // Implicit wait is dynamic wait

    public static void main (String [] args) throws InterruptedException {
        WebDriver driver;
        String path = System.getProperty("user.dir");
        System.out.println (path);
        System.setProperty( "webdriver.chrome.driver", path+"\\support\\chromedriver_2.41.exe" );
        ChromeOptions options = new ChromeOptions();
        options.addArguments( "--no-sandbox" );
        driver = new ChromeDriver( options );
        driver.manage().window().maximize();
        //Dynamic wait
        driver.manage().timeouts().pageLoadTimeout( 30,TimeUnit.SECONDS );
        driver.manage().timeouts().implicitlyWait( 30,TimeUnit.SECONDS );
        driver.navigate().to( "https://jqueryui.com/droppable/" );
        //Global wait.
        // Applicable for all the elements available on page.
        //Thread.sleep( 3000 );

    }
}
