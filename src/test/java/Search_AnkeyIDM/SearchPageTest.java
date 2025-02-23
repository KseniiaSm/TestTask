package Search_AnkeyIDM;


import Search_AnkeyIDM.helpers.HelpersBase;
import Search_AnkeyIDM.page.AnkeyIDM;
import Search_AnkeyIDM.page.Gazinformservice;
import Search_AnkeyIDM.page.Yandex;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Search_AnkeyIDM.page.Yandex.baseURL;

public class SearchPageTest extends TestsBase {
    @BeforeMethod
    public void setUp() {
        Yandex searchElementsYandex = new Yandex();
        initElements(searchElementsYandex);

        Gazinformservice searchElementsGazinformservice = new Gazinformservice();
        initElements(searchElementsGazinformservice);

        AnkeyIDM searchElementsAnkeyIDM = new AnkeyIDM();
        initElements(searchElementsAnkeyIDM);
    }

    @Test
    public static void findGazIs() {
        HelpersBase.openURL(baseURL);

        Yandex.searchPageGazIsRu();

        Gazinformservice.seachAnkeyIDM();

        AnkeyIDM.searchAndDownloadAnkeyIDM();
        AnkeyIDM.waitForFileToDownload();
       }
}

