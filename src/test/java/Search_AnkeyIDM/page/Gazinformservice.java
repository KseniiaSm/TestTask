package Search_AnkeyIDM.page;

import Search_AnkeyIDM.helpers.HelpersBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Search_AnkeyIDM.TestsBase.driver;
import static Search_AnkeyIDM.TestsBase.wait;

public class Gazinformservice {

    @FindBy(css = "#div109")
    public static WebElement productButton;

    @FindBy(css = "#div172 .main-menu__item-text")
    public static WebElement controlIB;

    @FindBy(css = "#div431")
    public static WebElement ankeyIDM;


    public static void seachAnkeyIDM(){
        wait.until(ExpectedConditions.visibilityOf(productButton));
        wait.until(ExpectedConditions.elementToBeClickable(productButton));
        productButton.click();

        wait.until(ExpectedConditions.visibilityOf(controlIB));
        wait.until(ExpectedConditions.elementToBeClickable(controlIB));
        controlIB.click();

        wait.until(ExpectedConditions.visibilityOf(ankeyIDM));
        wait.until(ExpectedConditions.elementToBeClickable(ankeyIDM));
        ankeyIDM.click();
    }
}
