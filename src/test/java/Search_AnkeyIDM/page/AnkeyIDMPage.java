package Search_AnkeyIDM.page;

import Search_AnkeyIDM.helpers.CommonWebHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.List;

import static Search_AnkeyIDM.tests.TestsBase.driver;
import static Search_AnkeyIDM.tests.TestsBase.wait;
import static Search_AnkeyIDM.selectors.Elements.*;

public class AnkeyIDMPage {
    public static void searchAnkeyIDM() {
        CommonWebHelper.scrollPage();

        wait.until(ExpectedConditions.visibilityOf(materials));
        wait.until(ExpectedConditions.elementToBeClickable(materials));
        materials.click();

        wait.until(ExpectedConditions.visibilityOf(documents));
        wait.until(ExpectedConditions.elementToBeClickable(documents));
    }

    public static void downloadAnkeyIDM() {
        List<WebElement> documents = driver.findElements(documentsCss);
        for (WebElement e : documents) {
            if (e.getText().contains("Руководство пользователя Ankey IDM")) {
                e.click();
            }
        }
    }

    public static void waitForFileIsDownloaded() {
        String downloadPath = "C:\\Users\\Ксения\\Downloads";
        String fileName = "ankey-idm-manual-user.pdf";
        File file = new File(downloadPath, fileName);
        int time = 0;

        while (time < 60) {
            if (file.exists()) {
                System.out.println("Файл успешно загружен!");
                break;
            }
            try {
                Thread.sleep(1000);
                time++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (!file.exists()) {
            System.out.println("Ошибка: файл не загрузился.");
        }
    }
}