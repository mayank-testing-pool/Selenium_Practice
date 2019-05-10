package Selenium_Programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrokenLinksTest {

    public static void main (String [] args) throws InterruptedException, IOException {
        String username = "m.mayank0211@gmail.com";
        String password = "m.m@y@nk02111986";
        WebDriver driver;
        String path = System.getProperty("user.dir");
        System.out.println(path);
        System.setProperty("webdriver.chrome.driver", path + "\\support\\chromedriver_2.41.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        /*driver.navigate().to("https://ui.cogmento.com/");
        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//div[contains (text(),'Login')]")).click();*/
        driver.navigate().to("https://www.amazon.in/");
        Thread.sleep(3000);

        //links -- /a href  //www.google.com
        //images -- /img href  // www.test.com

        //1- Get the list of all the images and links
        List<WebElement> links = driver.findElements(By.tagName("a"));
        links.addAll(driver.findElements(By.tagName("img")));
        System.out.println("Size of all links and images-----> " +links.size());
        List<WebElement> activelinks = new ArrayList<WebElement>();
        Thread.sleep(5000);
        //2 - Iterate link list:: Exclude all the links/Images doesn't have href attribute.

        for (int i=0;i<links.size();i++)
        {
            System.out.println("Href are ----->"+links.get(i).getAttribute("href"));
            if (links.get(i).getAttribute("href")!=null)
            {
                activelinks.add(links.get(i));
            }
        }

        //Get the size on Active links list

        System.out.println("Size of active links and images-----> " +activelinks.size());

        // check the href url with httpconnection api

        for (int j = 0;j<activelinks.size();j++)
        {
            HttpURLConnection connection = (HttpURLConnection) new URL(activelinks.get(j).getAttribute("href")).openConnection();
            //HttpURLConnection connection = (HttpURLConnection) new URL("https://ui.cogmento.com/home").openConnection();
            connection.connect();
            String response = connection.getResponseMessage();
            connection.disconnect();
            System.out.println(activelinks.get(j).getAttribute("href") +"------>" +response);
        }



    }
}
