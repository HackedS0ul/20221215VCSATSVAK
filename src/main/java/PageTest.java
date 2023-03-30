import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class PageTest {
    private static WebDriver driver;
    private static HomePage homePage;


    @Before
    public void setUp(){
        //Logging webdriver is initializing correctly
        System.out.println("initialize Webdriver");
        System.setProperty("webdriver.chrome.driver", "Your/path");
        //creating ChromeDriver object
        driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        System.out.println("Webdriver initialized");
    }
    //write your test
    @Test
    public void cookieNotice() throws IOException {
        homePage.goTo();
        homePage.cookiesNotice();

        //make a screenshot
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Path destinationPath = Paths.get("screenshot.png");
        Files.copy(screenshotFile.toPath(), destinationPath);
    }
    //close window
    @AfterClass
    public static void tearDown(){

        driver.close();
    }
}
