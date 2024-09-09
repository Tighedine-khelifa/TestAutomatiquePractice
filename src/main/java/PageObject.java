
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;
import java.util.List;
public class PageObject {
    @FindBy(id = "name")
    private WebElement nameInput;
    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "phone")
    private WebElement phoneInput;
    @FindBy(id = "textarea")
    private WebElement addressInput;
    @FindBy(id = "cookieChoiceDismiss")
    private WebElement cookie;

    @FindBy(xpath = "//input[@name='gender']")
    List<WebElement> genders;
    @FindBy(xpath = "//input[@class='form-check-input' and @type='checkbox']")
    List<WebElement> checkBoxDays;
    @FindBy(xpath = "//button[normalize-space()='Alert']")
    private WebElement alert;
    @FindBy(xpath = "//button[normalize-space()='Prompt']")
    private WebElement prompt;
    WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void setFormulaire() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(cookie));
        cookie.click();
        nameInput.click();
        nameInput.sendKeys("Tighedine KHleifa");
        emailInput.sendKeys("tighedinekhelifa18@gmail.com");
        phoneInput.sendKeys("000000000");
        addressInput.sendKeys("villeJuif");
    }

    public void clickCheckBoxGender() {
        for (WebElement gender : genders) {
            gender.click();

        }
    }

    public void clickCheckboxDays() {
        for (WebElement checkbox : checkBoxDays) {
            checkbox.click();

        }
    }

    public void clickLastCheckbox() {
        for (int i = 6; i < checkBoxDays.size(); i++) {
            if (checkBoxDays.get(6).isSelected()) {
                checkBoxDays.get(6).click();
            }
        }
    }

    public void clickAlert() {
        alert.click();
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        System.out.println(text);
        Assert.assertEquals("I am an alert box!", "I am an alert box!");
        alert.dismiss();

    }

    public void promptAlertText() throws InterruptedException {
        prompt.click();

        Thread.sleep(3000);
        Alert alt = driver.switchTo().alert();
        System.out.println(alt.getText());

        alt.sendKeys("khelifa");
        alt.accept();

    }

}
