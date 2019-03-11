package Selenium_Programs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


import java.util.logging.Level;

public class WebDriverBasics {

    //1. Launch Firefox
    public static void main(String[] args)
    {
        WebDriver driver;
        String url = "https://www.google.com";
        //System.setProperty( "webdriver.gecko.driver","C:\\Users\\mm18780\\Desktop\\Mayank\\Automation\\Selenium_Practice\\support\\geckodriver_0.23.exe" );
        //driver = new FirefoxDriver(  );
       // driver.manage().window().maximize();
        //driver.get( url );

        /*LoggingPreferences preferences = new LoggingPreferences();
		preferences.enable(LogType.BROWSER, Level.OFF);
		preferences.enable(LogType.CLIENT, Level.OFF);
		preferences.enable(LogType.DRIVER, Level.OFF);
		preferences.enable(LogType.PROFILER, Level.OFF);
		preferences.enable(LogType.PERFORMANCE, Level.OFF);
		preferences.enable(LogType.SERVER, Level.OFF);
		DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(CapabilityType.LOGGING_PREFS, preferences);
		FirefoxOptions opt = new FirefoxOptions();
		opt.merge(dc);
		WebDriver driver =  new FirefoxDriver(opt);
	    driver.get("https://www.google.co.in");*/



    //1. Launch Chrome

        System.setProperty("webdriver.chrome.driver","C:\\Users\\mm18780\\Desktop\\Mayank\\Automation\\Selenium_Practice\\support\\chromedriver_2.45.exe");


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);


        //driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com");
        //driver.get(url);


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





