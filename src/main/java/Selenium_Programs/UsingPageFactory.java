package Selenium_Programs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class UsingPageFactory {
    static WebDriver driver;
    @FindBy (name ="email")
    static WebElement username_text;
    @FindBy (how = How.NAME, using ="password")
    static WebElement password_text;
    @FindBy (how = How.XPATH, using = "//div[contains (text(),'Login')]")
    static WebElement login_btn;
    public static void main(String[] args) {

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
        driver.navigate().to("https://ui.cogmento.com/");
        PageFactory.initElements(driver, UsingPageFactory.class);
        username_text.sendKeys(username);
        password_text.sendKeys(password);
        login_btn.click();
    }





}
