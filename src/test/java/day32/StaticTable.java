package day32;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {

    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
        System.out.println("Nmobre de ligne : "+rows);

        int cols = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
        System.out.println("Number of columns :" +cols);

        //Chercher un element precis dans une table avec une columns et ligne

        String element1 = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[3]")).getText();
        System.out.println(element1);

        // imprimer tout les valeurs de tableau

        /*for (int r=2;r<=rows;r++){
            for(int c=1;c<=cols;c++){

             String table =   driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
             System.out.print(table+"\t");
            }
            System.out.println();
        }*/


        // imprimer une column avec condition

        for (int r=2;r<=rows;r++){
            String authorNam = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
            if (authorNam.equals("Mukesh")){
                String bookNam = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
                System.out.println(authorNam +"\t"+bookNam);
            }
        }

        // total price in table
        int total = 0;
        for (int r=2;r<=rows;r++){
            String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
            System.out.println(price);
            total = total+Integer.parseInt(price);

        }
        System.out.println("Total price :" +total);
    }
}
