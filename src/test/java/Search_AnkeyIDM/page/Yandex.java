package Search_AnkeyIDM.page;

import Search_AnkeyIDM.helpers.HelpersBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Search_AnkeyIDM.TestsBase.driver;
import static Search_AnkeyIDM.TestsBase.wait;
import static Search_AnkeyIDM.selectors.Elements.*;

public class Yandex {
    public static String baseURL = "https://www.yandex.ru/";
    public static String gazinformservice = "Газинформсервис";

    public static void searchPageGazIsRu() throws InterruptedException {
        HelpersBase.waitForPageLoad(driver);
        Thread.sleep(50000);


        driver.switchTo().frame(iframe);
        yandexSearchBar.click();
        yandexSearchBar.sendKeys(gazinformservice);
        yandexSearchBar.sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
    }

    public static void openPageGazIsRuFromSearch(String newWindow) {
        driver.switchTo().window(newWindow);

        wait.until(ExpectedConditions.visibilityOf(closeButton));
        closeButton.click();
        wait.until(ExpectedConditions.visibilityOf(gazIsRu));
        wait.until(ExpectedConditions.elementToBeClickable(gazIsRu));
        gazIsRu.click();
    }
}
