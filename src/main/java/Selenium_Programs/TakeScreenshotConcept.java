package Selenium_Programs;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TakeScreenshotConcept {

    public static void main (String [] args) throws InterruptedException, IOException {
        WebDriver driver;
        System.setProperty( "webdriver.chrome.driver", "C:\\Users\\mm18780\\Desktop\\Mayank\\Automation\\Selenium_Practice\\support\\chromedriver_2.41.exe" );
        ChromeOptions options = new ChromeOptions();
        options.addArguments( "--no-sandbox" );
        driver = new ChromeDriver( options );
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout( 30, TimeUnit.SECONDS );
        //driver.manage().timeouts().implicitlyWait( 30, TimeUnit.SECONDS );

        driver.navigate().to( "https://www.google.com" );
        Thread.sleep( 3000 );

        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs( OutputType.FILE );

        //Move image file to new destination
        File DestFile=new File("C:\\Users\\mm18780\\Desktop\\Mayank\\Automation\\Selenium_Practice\\screenshots\\google_image.png");

        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);




    }
}
