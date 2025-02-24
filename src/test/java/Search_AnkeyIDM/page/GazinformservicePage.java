package Search_AnkeyIDM.page;

import Search_AnkeyIDM.tests.TestsBase;
import Search_AnkeyIDM.helpers.CommonWebHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Search_AnkeyIDM.selectors.Elements.*;

public class GazinformservicePage extends TestsBase {
    public static void findCompany(String newWindow, WebElement element) {
        CommonWebHelper.waitForPageLoad(driver);
        driver.manage().window().maximize();
        driver.switchTo().window(newWindow);

        wait.until(ExpectedConditions.visibilityOf(productButton));
        wait.until(ExpectedConditions.elementToBeClickable(productButton));
        productButton.click();

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}