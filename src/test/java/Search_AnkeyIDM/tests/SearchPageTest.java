package Search_AnkeyIDM.tests;

import Search_AnkeyIDM.helpers.CommonWebHelper;
import Search_AnkeyIDM.page.AnkeyIDMPage;
import Search_AnkeyIDM.page.GazinformservicePage;
import Search_AnkeyIDM.page.YandexSearchPage;
import Search_AnkeyIDM.selectors.Elements;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static Search_AnkeyIDM.page.YandexSearchPage.yandexSearchURL;

public class SearchPageTest extends TestsBase {

    @BeforeMethod
    public void setUp() {
        initElements(new Elements());
    }

    @Test
    public static void findGazIs() {
        CommonWebHelper.openURL(yandexSearchURL);

        Set<String> oldWindows = driver.getWindowHandles();

        YandexSearchPage.sendKeysToSearchInput("Газинформсервис");
        String newWindow = CommonWebHelper.getNewWindow(oldWindows);

        oldWindows = driver.getWindowHandles();
        YandexSearchPage.openPageFromSearch(newWindow, Elements.gazIsRu);
        newWindow = CommonWebHelper.getNewWindow(oldWindows);

        GazinformservicePage.findCompany(newWindow, Elements.ankeyIDM);

        AnkeyIDMPage.searchAnkeyIDM();
        AnkeyIDMPage.downloadAnkeyIDM();
        AnkeyIDMPage.waitForFileIsDownloaded();
    }
}