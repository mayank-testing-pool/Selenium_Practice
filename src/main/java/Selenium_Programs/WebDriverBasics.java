package Selenium_Programs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBasics {

    //1. Launch Firefox
    public static void main(String[] args)
    {
        WebDriver driver;
        String url = "https://www.google.com";
        /*System.setProperty( "webdriver.gecko.driver","C:\\Users\\mm18780\\Desktop\\Mayank\\Automation\\Selenium_Practice\\support\\geckodriver_0.19.exe" );
        driver = new FirefoxDriver(  );
        driver.get( "https://www.google.com" );
        driver.manage().window().maximize();*/



    //1. Launch Chrome

        System.setProperty("webdriver.chrome.driver","C:\\Users\\mm18780\\Desktop\\Mayank\\Automation\\Selenium_Practice\\support\\chromedriver_2.41.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String title = driver.getTitle();
        if (title.equals( "Google" ))
        {
            System.out.println( "Correct Page" );

        }
        else
        {
            System.out.println( "Incorrect Page" );
        }

        System.out.print( "Current URL " +driver.getCurrentUrl());

        driver.quit();



    }
}





