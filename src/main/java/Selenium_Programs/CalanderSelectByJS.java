package Selenium_Programs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class CalanderSelectByJS {

    public static void main (String [] args) throws InterruptedException {
        WebDriver driver;
        String path = System.getProperty("user.dir");
        System.out.println(path);
        System.setProperty("webdriver.chrome.driver", path + "\\support\\chromedriver_2.41.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.navigate().to("https://www.spicejet.com/");
        WebElement date = driver.findElement(By.name("ctl00$mainContent$txt_Fromdate"));
        String dateval = "30-07-2019";
        Thread.sleep(2000);
        selectDateByJS(driver,date,dateval);

    }

    public static void selectDateByJS (WebDriver driver, WebElement element, String dateval) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].setAttribute('value','" + dateval + "');", element);


    }
}
