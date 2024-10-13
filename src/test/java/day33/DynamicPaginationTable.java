package day33;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DynamicPaginationTable {

    public static void main (String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

     List<WebElement> nombre = driver.findElements(By.xpath("//ul[@id='pagination']//li"));

     int nomberint = nombre.size();
        int rows = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();
        int cols = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr//td")).size();
     for (int p=1;p<=nomberint;p++){

          driver.findElement(By.xpath("//ul[@id='pagination']//*[text()=" + p + "]")).click();
        Thread.sleep(2000);
         for (int r=1;r<=rows;r++){
             driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+r+"]//td[4]//input[@type='checkbox']")).click();

         }
      }








    }
}
