package day32;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class StaticTableEx {




    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://blazedemo.com/");
        driver.manage().window().maximize();

        WebElement departCity = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select listDepartCity = new Select(departCity);
        List<WebElement> lisDepartCityOption = listDepartCity.getOptions();
        System.out.println(lisDepartCityOption.size());

        for(WebElement optionDep : lisDepartCityOption){
            if (optionDep.getText().equals("Boston")){
                optionDep.click();
            }
        }

        WebElement destinationCity = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select listDestinationCity = new Select(destinationCity);
        List<WebElement> listDestinationCityOption = listDestinationCity.getOptions();
        System.out.println(listDestinationCityOption.size());

        for (WebElement optionDes : listDestinationCityOption ){
            if(optionDes.getText().equals("Rome")){
                optionDes.click();
            }
        }

        driver.findElement(By.xpath("//input[@value='Find Flights']")).click();


        int rows = driver.findElements(By.xpath("//table[@class='table']//tr")).size();
        System.out.println("Nombre de ligne : " +rows);

        int cols = driver.findElements(By.xpath("//table[@class='table']//tr//th")).size();
        System.out.println("Nombre de column : " +cols);

        int minPrice = Integer.MAX_VALUE;
        for (int c=1;c<=6;c++){
          String header = driver.findElement(By.xpath("//table[@class='table']//tr[1]//th["+c+"]")).getText();
          System.out.println("list header : " +header);
          if(header.equals("Price")){
              for(int r=1;r<=5;r++) {
                  String prix = driver.findElement(By.xpath("//table[@class='table']//tr["+r+"]//td[6]")).getText();
                  System.out.println("Tout les prix :"+prix);

                  String numbers = prix.replaceAll("[^0-9]", "");
                  int  Number= Integer.parseInt(numbers);
                  if (Number<minPrice){
                    minPrice =Number;
                    System.out.println("le prix le plus bas "+Number);
                  }
              }
          }
        }

    }
}
