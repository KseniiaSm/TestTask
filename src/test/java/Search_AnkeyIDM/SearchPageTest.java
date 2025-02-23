package Search_AnkeyIDM;


import Search_AnkeyIDM.helpers.HelpersBase;
import Search_AnkeyIDM.page.AnkeyIDM;
import Search_AnkeyIDM.page.Gazinformservice;
import Search_AnkeyIDM.page.Yandex;
import Search_AnkeyIDM.selectors.Elements;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static Search_AnkeyIDM.page.Yandex.baseURL;

public class SearchPageTest extends TestsBase {
    @BeforeMethod
    public void setUp() {
        Elements searchElements = new Elements();
        initElements(searchElements);
    }

    @Test
    public static void findGazIs() throws InterruptedException {
        HelpersBase.openURL(baseURL);

        Set<String> oldWindows = driver.getWindowHandles();

        Yandex.searchPageGazIsRu();
        String newWindow = HelpersBase.getNewWindow(oldWindows);

        oldWindows = driver.getWindowHandles();
        Yandex.openPageGazIsRuFromSearch(newWindow);
        newWindow = HelpersBase.getNewWindow(oldWindows);

        Gazinformservice.seachAnkeyIDM(newWindow);

        AnkeyIDM.searchAndDownloadAnkeyIDM();
        AnkeyIDM.waitForFileToDownload();
    }
}

