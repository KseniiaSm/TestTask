package Search_AnkeyIDM.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestsBase {
    public static WebDriver driver;
    public static WebDriverWait wait;
    Duration timeout = Duration.ofSeconds(60);

    public void initElements(Object page) {
        PageFactory.initElements(driver, page);
    }

    @BeforeMethod
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, timeout);
    }

    @AfterMethod
    public void stop() {
        driver.quit();
        driver = null;
    }
}