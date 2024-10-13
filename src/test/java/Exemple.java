import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exemple {


    public static void main(String[] args) {
        // Configuration de WebDriverManager pour télécharger et configurer ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Créer une instance de ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Utiliser WebDriver pour automatiser votre tâche
        driver.get("https://google.com");

        // Fermer le driver après utilisation
        driver.quit();
    }
}
