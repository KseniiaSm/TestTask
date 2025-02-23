package Search_AnkeyIDM.page;

import Search_AnkeyIDM.helpers.HelpersBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Search_AnkeyIDM.TestsBase.driver;
import static Search_AnkeyIDM.TestsBase.wait;

public class Yandex {

    public static String baseURL = "https://www.yandex.ru/";

    public static String gazinformservice = "Газинформсервис";
    @FindBy(css = "#ya-search-container-uri0hf")
    public static WebElement yandexSearchBar;

    @FindBy(css = "a[href*='gaz-is.ru']")
    public static WebElement gazIsRu;


    public static void searchPageGazIsRu(){
        HelpersBase.waitForPageLoad(driver);

        wait.until(ExpectedConditions.visibilityOf(yandexSearchBar));
        wait.until(ExpectedConditions.elementToBeClickable(yandexSearchBar));
        yandexSearchBar.sendKeys(gazinformservice);

        wait.until(ExpectedConditions.visibilityOf(gazIsRu));
        wait.until(ExpectedConditions.elementToBeClickable(gazIsRu));
        gazIsRu.click();
    }
}
