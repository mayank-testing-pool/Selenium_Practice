package Selenium_Programs;
/*How to perform Dynamic Search by Using Dynamic Xpath
        1 - Google Search - pick a value from suggestions
        2 - Search using Xpath
        3 - Got the Total Count of Suggestions
        4 - Use if condition to match the value
        5 - click on matched value*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;
import java.util.List;


public class GoogleSearchTest {

    public static void main (String [] args) throws InterruptedException {
        WebDriver driver;
        String username = "m.mayank0211@gmail.com";
        String password = "m.m@y@nk02111986";
        String path = System.getProperty("user.dir");
        System.out.println(path);
        System.setProperty("webdriver.chrome.driver", path + "\\support\\chromedriver_2.41.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.navigate().to("https://www.google.com/");
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")).sendKeys("Testing");

        List <WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li//descendant::span"));
        //ul[@role='listbox']//li/descendant::dev[@class = 'sbl1 sbl1p']
        System.out.println ("Total no of suggestions are = "+list.size());
        for (int i = 0;i<list.size();i++)
        {
            System.out.println(list.get(i).getText());
            if (list.get(i).getText().contains("testing life cycle"))
            {
                list.get(i).click();
                break;
            }
        }


    }
}
