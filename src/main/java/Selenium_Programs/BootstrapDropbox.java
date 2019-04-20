package Selenium_Programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by maheshwari.mayank on 20-04-2019.
 */
public class BootstrapDropbox {
    public static void main (String [] args)
    {
        WebDriver driver;
        String path = System.getProperty("user.dir");
        System.out.println (path);
        System.setProperty( "webdriver.chrome.driver", path+"\\support\\chromedriver_2.41.exe" );
        ChromeOptions options = new ChromeOptions();
        options.addArguments( "--no-sandbox" );
        driver = new ChromeDriver( options );
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.navigate().to( "https://www.jquery-az.com/boots/demo.php?ex=63.0_6" );

        driver.findElement(By.xpath("//button[contains(@class ,'multiselect dropdown-toggle btn btn-default')]")).click();
        List<WebElement> list = driver.findElements((By.xpath("//ul[contains(@class,'multiselect-container dropdown-menu')]//li//a//label")));
        System.out.println (list.size());

        //Selecting Angular
        /* for (int i = 0;i<list.size();i++)
        {
            System.out.println(list.get(i).getText());
            if (list.get(i).getText().contains("Angular"))
            {
                list.get(i).click();
                break;
            }
        }*/

        //Selecting All the Values
        for (int i = 0;i<list.size();i++)
        {
            System.out.println(list.get(i).getText());
            list.get(i).click();
        }
    }

}
