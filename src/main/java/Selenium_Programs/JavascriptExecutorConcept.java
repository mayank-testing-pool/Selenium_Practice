package Selenium_Programs;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

/**
 * Created by maheshwari.mayank on 24-03-2019.
 */
public class JavascriptExecutorConcept {

    public static void main (String[] args) throws InterruptedException, IOException {
        WebDriver driver;
        String path = System.getProperty("user.dir");
        System.out.println(path);
        System.setProperty("webdriver.chrome.driver", path + "\\support\\chromedriver_2.41.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.in/ap/signin?_encoding=UTF8&ignoreAuthState=1&openid.assoc_handle=inflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fie%3DUTF8%26tag%3Dgooginabkkenshoo-21%26ascsubtag%3D_k_EAIaIQobChMIr6asz6-a4QIVRouPCh1J8wLyEAAYASAAEgLNGPD_BwE_k_%26gclid%3DEAIaIQobChMIr6asz6-a4QIVRouPCh1J8wLyEAAYASAAEgLNGPD_BwE%26ref_%3Dnav_signin&switch_account=");
        WebElement element = driver.findElement(By.xpath("//*[@id=\'createAccountSubmit\']"));
        Thread.sleep(20000);

        /*//Heighlight Element
        flash(element,driver);
        Thread.sleep(10000);

        // Draw border on element
        drawBorder( element, driver);
        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs( OutputType.FILE );
        //Move image file to new destination
        File DestFile=new File(System.getProperty("user.dir")+"\\Screenshots\\drawborder_image.png");
        //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);
        Thread.sleep(10000);

        // Generate alert on page
        //generateAlert(driver, "There is an issue with this button");
        //Thread.sleep(10000);
        // Click on an element using JavascriptExecutor
        clickElementByJS(driver,element);
        Thread.sleep(10000);

        //Refresh the page by using JavascriptExecutor
        refreshBrowserByJS(driver);
        Thread.sleep(10000);

        // Get title of page using JavaScriptExecutor
        String title = getTitleByJS(driver);
        System.out.println("Title of current page is " +title);
        Thread.sleep(10000);*/

        //Get inner Text of page using JavaScriptExecutor
        String pagetext = getPageInnerTextByJS(driver);
        System.out.println("All Text available on the page are " +pagetext);
        Thread.sleep(5000);

        //Scroll down the page
        driver.get("https://www.amazon.in");
        //scrollPageDown(driver);
        //Thread.sleep(5000);

        WebElement backtotop = driver.findElement(By.xpath("//*[@id=\'navBackToTop\']/div/span"));
        scrollIntoView(driver, backtotop);
        Thread.sleep(5000);
        backtotop.click();


        //driver.quit();


        //executeScript - to use to execute JavaScript Code
    }

        public static void flash (WebElement element, WebDriver driver)
        {
            JavascriptExecutor js = ((JavascriptExecutor)driver);
            String bgcolor = element.getCssValue("background-color");
            for (int i = 0;i<100;i++)
                {
                changeColor ("rgb(255,0,0)",element,driver);
                changeColor (bgcolor, element,driver);
                }
        }

        public static void changeColor (String color, WebElement element, WebDriver driver)
        {
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",element);

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {

            }
        }

        public static void drawBorder (WebElement element, WebDriver driver)
        {
            JavascriptExecutor js = ((JavascriptExecutor)driver);
            js.executeScript("arguments[0].style.border='3px solid red'", element);
        }

        public static void generateAlert (WebDriver driver, String message)
        {
            JavascriptExecutor js = ((JavascriptExecutor)driver);
            js.executeScript("alert('"+message+"')");
        }

        public static  void clickElementByJS (WebDriver driver, WebElement element)
        {
            JavascriptExecutor js = ((JavascriptExecutor)driver);
            js.executeScript("arguments[0].click();", element);
        }

        public  static  void refreshBrowserByJS (WebDriver driver)
        {
            JavascriptExecutor js = ((JavascriptExecutor)driver);
            js.executeScript("history.go(0)");
        }

        public static String getTitleByJS (WebDriver driver)
        {
            JavascriptExecutor js = ((JavascriptExecutor)driver);
            String title = js.executeScript("return document.title;").toString();
            return title;
        }

        public static String getPageInnerTextByJS (WebDriver driver)
        {
            JavascriptExecutor js = ((JavascriptExecutor)driver);
            String pagetext = js.executeScript("return document.documentElement.innerText;").toString();
            return  pagetext;
        }

        public static void scrollPageDown (WebDriver driver)
        {
            JavascriptExecutor js = ((JavascriptExecutor)driver);
            js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        }

        public static void scrollIntoView (WebDriver driver, WebElement element)
        {
            JavascriptExecutor js = ((JavascriptExecutor)driver);
            js.executeScript("arguments[0].scrollIntoView(true);",element);
        }

}
