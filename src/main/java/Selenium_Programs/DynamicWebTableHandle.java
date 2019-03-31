package Selenium_Programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Created by maheshwari.mayank on 31-03-2019.
 */
public class DynamicWebTableHandle {

    public static void main (String [] args) throws InterruptedException

    {
        WebDriver driver;
        String username = "m.mayank0211@gmail.com";
        String password = "m.m@y@nk02111986";
        String path = System.getProperty("user.dir");
        System.out.println (path);
        System.setProperty( "webdriver.chrome.driver", path+"\\support\\chromedriver_2.41.exe" );
        ChromeOptions options = new ChromeOptions();
        options.addArguments( "--no-sandbox" );
        driver = new ChromeDriver( options );
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
        driver.navigate().to( "https://ui.cogmento.com/" );

        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//div[contains (text(),'Login')]")).click();

        driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();

        //*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]
        //*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[2]/td[2]
        //*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[3]/td[2]
        //*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[4]/td[2]
        //*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[5]/td[2]
        //*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[6]/td[2]
        Thread.sleep(5000);
        String before_xpath = "//*[@id=\'ui\']/div/div[2]/div[2]/div/div[2]/table/tbody/tr[";
        String after_xpath = "]/td[2]";

        for (int i = 1;i<=6;i++)
        {
            String name = driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
            System.out.println (name);
            Thread.sleep(3000);
            if (name.contains("Test Admin"))
            {
                //*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[4]/td[1]/div/label
                //*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[4]/td[1]/div/label
                //*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[5]/td[1]
                //*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[5]/td[1]/div/input
                //*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[5]/td[1]/div/label
                //*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[3]/td[1]
                driver.findElement(By.xpath("//*[@id=\'ui\']/div/div[2]/div[2]/div/div[2]/table/tbody/tr["+i+"]/td[1]")).click();
            }
        }


        //Method - 2


    }
}
