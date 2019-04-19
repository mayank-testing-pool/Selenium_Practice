package Selenium_Programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class CalanderSelectConcept {

    public static void main (String [] args) throws InterruptedException {
        WebDriver driver;
        String username = "m.mayank0211@gmail.com";
        String password = "m.m@y@nk02111986";
        String path = System.getProperty("user.dir");
        String cal_header_text;
        String cal_header_array[];
        int yeardiff;
        int header_year;
        int selected_year;

        System.out.println(path);
        System.setProperty("webdriver.chrome.driver", path + "\\support\\chromedriver_2.41.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.navigate().to("https://ui.cogmento.com/");

        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//div[contains (text(),'Login')]")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//span[contains(text(),'Calendar')]")).click();

        String date = "18-September-2018";
        String datearray[]=date.split("-");
        String day = datearray[0];
        String month = datearray[1];
        String year = datearray[2];
        System.out.println("Day " +day+" Month "+month+" Year "+year);

        //Get the value of current month selected on calander
        WebElement cal_header = driver.findElement(By.xpath("//span[@class='rbc-toolbar-label']"));

        // Get the xpath of previous month button
        WebElement prev_month_button = driver.findElement(By.xpath("//button//i[contains(@class,'chevron left icon')]"));

        // Get the xpath of previous month button
        WebElement next_month_button = driver.findElement(By.xpath("//button//i[contains(@class,'chevron right icon')]"));

        // Get the xpath of Today button
        WebElement today_date = driver.findElement(By.xpath("//button//span[contains(@class,'today-button')]"));
        do {
                //Get the value of calender header
                cal_header_text = cal_header.getText();
                System.out.println(cal_header_text);
                cal_header_array = cal_header_text.split(" ");
                yeardiff = Integer.parseInt(year) - Integer.parseInt(cal_header_array[1]) ;
                System.out.println("Difference between header year and selected year "+yeardiff) ;
                header_year = Integer.parseInt(cal_header_array[1]);
                selected_year = Integer.parseInt(year);
                Thread.sleep(3000);
                    if (selected_year < header_year || !(cal_header_array[0].equals(month)))
                    {
                       prev_month_button.click();
                    }
                    else if (selected_year > header_year)
                    {
                        next_month_button.click();
                    }
                System.out.println("Current Year " + header_year);
                System.out.println("Expected Year " + selected_year);
                System.out.println("Current Month " + cal_header_array[0]);
                System.out.println("Expected Month " + month);

        }
        while (!(cal_header_array[1].equals(year)) || !(cal_header_array[0].equals(month)));
    }
}
