import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class HandlesFrame {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Frame1");
        driver.switchTo().defaultContent();
          WebElement fram2 =driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
          driver.switchTo().frame(fram2);

        driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Frame2");
        driver.switchTo().defaultContent();
        WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
        driver.switchTo().frame(frame3);
        driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Frame3");
        driver.switchTo().frame(0);


        WebElement iframeInSide = driver.findElement(By.xpath("//div[@id='i8']//div[@class='AB7Lab Id5V1']"));
        iframeInSide.click();
    }


}
