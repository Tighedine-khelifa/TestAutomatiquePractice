import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class BaseTest {
    static WebDriver driver;
@BeforeClass
 public static void setUp(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
     driver.get("https://testautomationpractice.blogspot.com/");
     driver.manage().window().maximize();

 }
 @Test
    void remplirLeFormulaire () throws InterruptedException {
    PageObject pageObject = new PageObject(driver);
    pageObject.setFormulaire();
    pageObject.clickCheckBoxGender();
    pageObject.clickCheckboxDays();
    pageObject.clickLastCheckbox();
    pageObject.clickAlert();
    pageObject.promptAlertText();
    pageObject.choseOption();
 }
}
