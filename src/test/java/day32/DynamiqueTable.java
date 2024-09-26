package day32;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

public class DynamiqueTable {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ecomdeveloper.com/demo/admin/index.php");
        driver.manage().window().maximize();

      WebElement userName =  driver.findElement(By.xpath("//input[@id='input-username']"));
      userName.clear();
      userName.sendKeys("demoadmin ");
      WebElement motDePass = driver.findElement(By.xpath("//input[@id='input-password']"));
                motDePass.clear();
                motDePass.sendKeys("demopass");
       WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(2));
         wait.until(ExpectedConditions.elementToBeClickable(button));
        Actions actions = new Actions(driver);
        actions.doubleClick(button).perform();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
        driver.findElement(By.xpath("//ul[@id='collapse9']//a[contains(text(),'Customers')]")).click();

// capturer les index des elements via leurs index
 // totalPages = "Showing 1 to 20 of 875 (44 Pages)"
        String text =driver.findElement(By.xpath("//div[contains(text(),('Showing'))]")).getText();

        int totalPages =Integer.parseInt( text.substring( text.indexOf("(")+1,text.indexOf("Pages")-1));

        // parcour les pages
        for (int p =1;p<6;p++){
            if(p>1){
             WebElement activePage = driver.findElement(By.xpath("//ul[@class='pagination']//*[text()="+p+"]"));
                activePage.click();
            }
        }


        //nombre de ligne
        int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
        System.out.println("Nombre de ligne :"+rows);
        // nombre de colonne
        int cols = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tr//td")).size();
        System.out.println("Nombre de colonne :"+cols);

       // lire les information de tableau
        for (int r=1;r<=rows;r++){
            String CostumerName = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[2]")).getText();
            String email =driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[3]")).getText();
            String  dateAdded = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[7]")).getText();


                System.out.println(CostumerName + "\t" + email + "\t" + dateAdded);

        }

    }
}
