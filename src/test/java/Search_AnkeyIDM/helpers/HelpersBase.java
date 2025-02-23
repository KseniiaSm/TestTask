package Search_AnkeyIDM.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static Search_AnkeyIDM.TestsBase.driver;
import static Search_AnkeyIDM.TestsBase.wait;

public class HelpersBase {

    public static void openURL(String URL) {
        driver.get(URL);
        waitForPageLoad(driver);
    }


    public static void waitForPageLoad(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(webDriver ->
                ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public static void scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public static String getNewWindow(Set<String> oldWindows) {
        return wait.until(driver1 -> {
            Set<String> newWindows = driver1.getWindowHandles();
            newWindows.removeAll(oldWindows);
            return !newWindows.isEmpty() ? newWindows.iterator().next() : null;
        });
    }
}
