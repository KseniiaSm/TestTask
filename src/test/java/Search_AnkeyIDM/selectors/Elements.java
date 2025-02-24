package Search_AnkeyIDM.selectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Elements {
    @FindBy(css = "#ya-search-iframe-283dku")
    public static WebElement iframe;
    @FindBy(css = "input.arrow__input.mini-suggest__input")
    public static WebElement yandexSearchBar;
    @FindBy(css = ".Distribution-Close")
    public static WebElement closeButton;

    @FindBy(css = "a[href*='gaz-is.ru']")
    public static WebElement gazIsRu;
    @FindBy(css = "#item-109")
    public static WebElement productButton;

    @FindBy(css = "#div431 a")
    public static WebElement ankeyIDM;

    @FindBy(css = "#tab-materialy")
    public static WebElement materials;

    @FindBy(css = "#materialy tr")
    public static WebElement documents;
    public static By documentsCss = By.cssSelector("#materialy tr");
}