package Search_AnkeyIDM.page;

import Search_AnkeyIDM.TestsBase;
import Search_AnkeyIDM.helpers.HelpersBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Search_AnkeyIDM.selectors.Elements.*;

public class Gazinformservice extends TestsBase {
    public static void seachAnkeyIDM(String newWindow) {
        HelpersBase.waitForPageLoad(driver);
        driver.manage().window().maximize();
        driver.switchTo().window(newWindow);

        wait.until(ExpectedConditions.visibilityOf(productButton));
        wait.until(ExpectedConditions.elementToBeClickable(productButton));
        productButton.click();

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ankeyIDM);
    }
}
