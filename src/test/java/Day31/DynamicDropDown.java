package Day31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;


import java.time.Duration;
import java.util.List;

public class DynamicDropDown {


public static void main (String[] args) throws InterruptedException{
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    driver.get("https://bjs-materiel-tp.fr/");
    driver.manage().window().maximize();


    Thread.sleep(5000);

   WebElement google = driver.findElement(By.name("s"));
   google.click();
   google.sendKeys("chantier");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    List<WebElement> lists = driver.findElements(By.xpath("//div[@class='col pt-3 pb-3']"));
    for(WebElement list :lists){
       String itemListe =list.getText();
       System.out.println(itemListe);

        Assert.assertEquals(itemListe,"Barrière de chantier rouge Ø 25 mm petite plaque\n" +
                "18,50 €","le text est éroné");
        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(list));
        clickableElement.click();

    }

}
}
