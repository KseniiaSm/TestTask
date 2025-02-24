package Search_AnkeyIDM.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Search_AnkeyIDM.tests.TestsBase.driver;
import static Search_AnkeyIDM.tests.TestsBase.wait;
import static Search_AnkeyIDM.selectors.Elements.*;

public class YandexSearchPage {
    public static String yandexSearchURL = "https://www.yandex.ru/";

    public static void sendKeysToSearchInput(String keys) {
        driver.switchTo().frame(iframe);
        yandexSearchBar.click();
        yandexSearchBar.sendKeys(keys);
        yandexSearchBar.sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
    }

    public static void openPageFromSearch(String newWindow, WebElement element) {
        driver.switchTo().window(newWindow);

        wait.until(ExpectedConditions.visibilityOf(closeButton));
        closeButton.click();

        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
}