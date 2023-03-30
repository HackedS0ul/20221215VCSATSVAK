import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{
    private final By cookies = By.id("onetrust-accept-btn-handler");
    public HomePage(WebDriver driver) {

        super(driver);
    }
    public void goTo(){
        driver.get("https://1a.lt");
    }
    public void cookiesNotice(){
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement cookie;
            cookie = wait.until(ExpectedConditions.elementToBeClickable(cookies));
            cookie.click();
        } catch (Exception e){
            System.out.println("Elementas nerastas" + e.getMessage());

        }
    }
}
