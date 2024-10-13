package day33;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

public class BoostrapTable {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement name = driver.findElement(By.xpath("//input[@name='username']"));
        name.click();
        name.sendKeys("Admin");
        WebElement passeWord = driver.findElement(By.xpath("//input[@name='password']"));
        passeWord.click();
        passeWord.sendKeys("admin123");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//*[name()='svg'][@role='presentation'])[3]")).click();
        Thread.sleep(2000);
        // pages
        List<WebElement> pagesN = driver.findElements(By.xpath("//ul[@class='oxd-pagination__ul']//*[text()='']"));
        int nPage= pagesN.size();
        System.out.println(nPage);

        int rows = driver.findElements(By.xpath("(//div[@role='row'])")).size();
        System.out.println(rows);

       for(int p=1;p<=nPage;p++){
            
            driver.findElement(By.xpath("//ul[@class='oxd-pagination__ul']//*[text()="+p+"]")).click();

           for (int r = rows; r > 1; r--) {
           try {


               WebElement buttons = driver.findElement(By.xpath("(//div[@role='row'])["+r+"]/div[@role='cell'][9]//button[2]"));
               if (buttons.isDisplayed()) { // Vérifier si le deuxième bouton existe



                   buttons.click();
                   Thread.sleep(4000);
               }

           }catch (NoSuchElementException e){
               // Si le bouton n'est pas trouvé, passer à la prochaine itération
               System.out.println("Bouton non trouvé à la ligne " + r + ", passage à la prochaine ligne.");

           }catch (ElementClickInterceptedException e){
               // Si le bouton n'est pas cliquable, passer à la prochaine itération
               System.out.println("Le bouton n'est pas cliquable à la ligne " + r + ", passage à la prochaine ligne.");

               // Passe à l'itération suivante de la boucle
           }
           }
        }



    }
}
