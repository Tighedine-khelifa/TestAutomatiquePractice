package day34;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DatePickerDemo {

    public static void main (String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();

        driver.switchTo().frame(0).manage();
// method1 send keys
      /* WebElement date = driver.findElement(By.id("datepicker"));
       date.click();
       date.sendKeys("19/09/1994");*/
  // method2 using date picker
        String years = "2026";
        String month = "March";
        String day = "10";
          driver.findElement(By.id("datepicker")).click();

          while (true){
            String month1=  driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();

            String years1= driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
                      if (month1.equals(month)&&years1.equals(years)){
                        break;
                      }
                      driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();

                  int tableau = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td")).size();

                
          }


    }
}
