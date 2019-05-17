package Selenium_Programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ReadPropFile {
    static WebDriver driver;
    public static void main (String [] args) throws IOException {
        String path = System.getProperty("user.dir");
        System.out.println (path);
        Properties prop = new Properties();
        FileInputStream ip = new FileInputStream(path +"Files\\config.properties");
        prop.load(ip);
        System.out.println(prop.getProperty("Name"));
        System.out.println (prop.getProperty("Age"));

        String url = prop.getProperty("URL");
        System.out.println (url);

        String browser_name = prop.getProperty("Browser");
        System.out.println (browser_name);

        if (browser_name.equals("chrome"))
        {
            System.setProperty( "webdriver.chrome.driver", path+"\\support\\chromedriver_2.41.exe" );
            ChromeOptions options = new ChromeOptions();
            options.addArguments( "--no-sandbox" );
            driver = new ChromeDriver( options );

        } else if (browser_name.equals("firefox"))
        {
            System.setProperty( "webdriver.gecko.driver", path+"\\support\\geckodriver_0.23.exe" );
            driver = new FirefoxDriver( );
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.get(url);

        driver.findElement(By.xpath(prop.getProperty("Firstname_xpath"))).sendKeys(prop.getProperty("FirstName"));
        driver.findElement(By.xpath(prop.getProperty("Lastname_xpath"))).sendKeys(prop.getProperty("LastName"));
        driver.findElement(By.xpath(prop.getProperty("Email_xpath"))).sendKeys(prop.getProperty("Email"));
        driver.findElement(By.xpath(prop.getProperty("Password_xpath"))).sendKeys(prop.getProperty("Password"));




    }
}
