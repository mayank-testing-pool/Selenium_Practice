package Selenium_Programs;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HTMLUnitDriverConcept {
    public static void main (String [] args) throws InterruptedException {
        WebDriver driver;
        String path = System.getProperty("user.dir");
        System.out.println(path);
        System.setProperty("webdriver.chrome.driver", path + "\\support\\chromedriver_2.41.exe");
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);*/
        // HTMLUnit Driver is not part of selenium 3.X
        // Need to download external Jar files for this
        //Advantages
        // It is very fast - execution of test case - Performence of script
        // will not open any browser
        // Not suitable for Action Class - user Action - mousemovement, doubleclick drag and drop
        // Also Called Ghost Driver - Headless Driver
            // 1 - HTMLUnit Driver - Java
            // 2 - FantomJS - JavaScript

        driver  = new HtmlUnitDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait( 30, TimeUnit.SECONDS );

        driver.navigate().to("https://www.amazon.in/ap/register?showRememberMe=true&openid.pape.max_auth_age=" +
                "0&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=inflex&ignoreAuthState=1&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fie%3DUTF8%26tag%3Dgooginabkkenshoo-21%26ascsubtag%3D_k_EAIaIQobChMI4LuAzuyX4QIVAh4rCh3eNgxCEAAYASAAEgKCW_D_BwE_k_%26gclid%3DEAIaIQobChMI4LuAzuyX4QIVAh4rCh3eNgxCEAAYASAAEgKCW_D_BwE%26ref_%3Dnav_signin&prevRID=PPWJJBG7K1VQFCP7E017&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&prepopulatedLoginId=&failedSignInCount=0&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        String title = driver.getTitle();
        System.out.println("Current Title is " +title );
        driver.findElement(By.name("customerName")).sendKeys("John");
        Select sel = new Select(driver.findElement((By.id("auth-country-picker"))));
        sel.selectByVisibleText("US +1");
        driver.findElement(By.id("ap_phone_number")).sendKeys("9876543210");
        driver.findElement(By.id("ap_password")).sendKeys("test1234");
        driver.findElement(By.id("continue")).click();


    }

}
