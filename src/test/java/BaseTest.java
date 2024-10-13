import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class BaseTest {
    static EventFiringWebDriver driver;
@Parameters("browser")
@BeforeClass
 public static void setUp(@Optional("chrome")String browser){

    if (browser.equalsIgnoreCase("chrome")){
        WebDriverManager.chromedriver().setup();
        driver = new EventFiringWebDriver(new ChromeDriver());
    } else if (browser.equalsIgnoreCase("firefox")) {
        WebDriverManager.firefoxdriver().setup();
        driver = new EventFiringWebDriver( new FirefoxDriver());
    }

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
