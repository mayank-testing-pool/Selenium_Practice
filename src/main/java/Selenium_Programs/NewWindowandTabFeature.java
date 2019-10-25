package Selenium_Programs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/*n Selenium 4.0, you can open new window & tab using "newWindow" command. Please note: Selenium 4.0 is
yet to be released. However, you can try this feature using Firefox 66 & Selenium 4.0.0-alpha-1 versions.*/

public class NewWindowandTabFeature {

    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver;
        String path = System.getProperty("user.dir");
        System.out.println(path);
        System.setProperty("webdriver.chrome.driver", path + "\\support\\chromedriver_2.41.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        /*System.setProperty("webdriver.gecko.driver", path + "\\support\\geckodriver_0.23.exe");
        driver = new FirefoxDriver();*/
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait( 30, TimeUnit.SECONDS );

        driver.get("https://www.google.com");
        Thread.sleep(3000);
        String title = driver.getTitle();

        // Will open new Blank tab
        //driver.switchTo().newWindow(WindowType.TAB);

        // Will open new blank Window
        //driver.switchTo().newWindow(WindowType.WINDOW);

        Set<String> handles =  driver.getWindowHandles();
        List<String> ls=new ArrayList<String>(handles);
        String parentwinid = ls.get(0);
        String childwinid = ls.get(1);
        System.out.println("Parent Window Id = "+parentwinid );
        System.out.println("Child Window Id = "+childwinid );
        String new_tab_title = driver.getTitle();
        driver.get("https://www.facebook.com");
        String new_title = driver.getTitle();
        driver.close(); //Will close the open tab.
        driver.switchTo().window(parentwinid);
        String old_title = driver.getTitle();


    }

}
