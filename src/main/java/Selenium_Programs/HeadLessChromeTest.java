package Selenium_Programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class HeadLessChromeTest {

    public static void main (String [] args) throws InterruptedException {
        WebDriver driver;
        String username = "m.mayank0211@gmail.com";
        String password = "m.m@y@nk02111986";
        String path = System.getProperty("user.dir");
        System.out.println (path);
        System.setProperty( "webdriver.chrome.driver", path+"\\support\\chromedriver_2.41.exe" );
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1400,800");
        options.addArguments("headless");
        driver = new ChromeDriver( options );
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.navigate().to("https://ui.cogmento.com/");

        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//div[contains (text(),'Login')]")).click();
        Thread.sleep(5000);
    }
}
