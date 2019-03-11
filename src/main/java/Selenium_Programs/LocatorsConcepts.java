package Selenium_Programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsConcepts {

    public static void main (String[] args)
    {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mm18780\\Desktop\\Mayank\\Automation\\Selenium_Practice\\support\\chromedriver_2.41.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String title = driver.getTitle();
        if (title.equals( "Sign in or Register | eBay" ))
        {
            System.out.println( "Correct Page" );

        }
        else
        {
            System.out.println( "Incorrect Page" );
        }

        System.out.print( "Current URL " +driver.getCurrentUrl());

        //1 - Using Xpath
        // Absolute xpath should not be use.
        //Relative Xpath  should be use.

        /*driver.findElement( By.xpath("//*[@id=\'firstname\']") ).sendKeys( "Tom" );
        driver.findElement( (By.xpath( "//*[@id=\'lastname\']" )) ).sendKeys( "Peter" );
        driver.findElement( By.xpath( "//*[@id=\'email\']" ) ).sendKeys( "tom.peter@gmail.com" );
        driver.findElement( By.xpath( "//*[@id=\'PASSWORD\']" ) ) .sendKeys( "abc123456" );*/

        //2 - Using ID

        /*driver.findElement( By.id( "firstname" ) ).sendKeys( "Tom" );
        driver.findElement( By.id( "lastname" ) ).sendKeys( "Peter" );
        driver.findElement( By.id( "email" ) ).sendKeys( "tom.peter@gmail.com" );
        driver.findElement( By.id( "PASSWORD" ) ).sendKeys( "abc123456" );*/

        //3 - Using name

        driver.findElement( By.name( "firstname" ) ).sendKeys( "Tom" );
        //driver.findElement( By.name( "lastname" ) ).sendKeys( "Peter" );
        //driver.findElement( By.name( "email" ) ).sendKeys( "tom.peter@gmail.com" );
        /*driver.findElement( By.name( "PASSWORD" ) ).sendKeys( "abc123456" );*/

        //4 - Using linkText

        //driver.findElement( By.linkText( "Sign in" ) ).click();

        //5 - Using partial link text (Generally not in use)

        //driver.findElement( By.partialLinkText( "Create a business" ) ).click();

        //6 - Using CSSSelector
        //If ID is present the CSSSelector will br "#<id>
        //If CLASS is present the CSSSelector will be ".<Class>

        driver.findElement( By.cssSelector( "#lastname" ) ).sendKeys( "Peter" );

        //7 - Using Class Name (Should not use)

        driver.findElement( By.className( ". wide fld regular-text bold-text float-box" ) ).sendKeys("tom.peter@gmail.com"  );


        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
