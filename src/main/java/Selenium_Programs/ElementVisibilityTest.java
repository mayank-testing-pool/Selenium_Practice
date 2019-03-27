package Selenium_Programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ElementVisibilityTest {

    public static void main (String [] args) throws InterruptedException {
        WebDriver driver;
        String path = System.getProperty( "user.dir" );
        System.out.println( path );
        System.setProperty( "webdriver.chrome.driver", path + "\\support\\chromedriver_2.41.exe" );
        ChromeOptions options = new ChromeOptions();
        options.addArguments( "--no-sandbox" );
        driver = new ChromeDriver( options );
        driver.manage().timeouts().pageLoadTimeout( 30,TimeUnit.SECONDS );
        driver.manage().timeouts().implicitlyWait( 30, TimeUnit.SECONDS );
        driver.manage().window().maximize();
        driver.navigate().to( "http://register.rediff.com/register/register.php?FormName=user_details" );


        //1. isDisplayed() method: applicable for all the elements
        boolean b1 = driver.findElement(By.xpath( "//input[contains(@class,'btn_checkavail')]")).isDisplayed();

        //( By.xpath( "//input[contains(@class,'gh-tb ui-autocomplete-input')]" ))

        System.out.println(b1); //true

        //2. isEnabled() method:
        boolean b2 = driver.findElement(By.id("Register")).isEnabled();
        System.out.println(b2);//false

        //select checkbox:

        boolean b3 = driver.findElement(By.xpath( "//input[contains (@class,'nomargin')]" )).isEnabled();
        System.out.println(b3);//true


        //3. isSelected() method: only applicable for checkbox, dropdown, radiobutton
        boolean b4 = driver.findElement(By.xpath( "//input[contains (@class,'nomargin')]" )).isEnabled();
        System.out.println(b4);//true


        //de-select the checkbox:
       /* driver.findElement(By.name("agreeTerms")).click();
        boolean b5 = driver.findElement(By.name("agreeTerms")).isSelected();
        System.out.println(b5);//false*/






    }
}
