package Search_AnkeyIDM.page;

import Search_AnkeyIDM.helpers.HelpersBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.List;

import static Search_AnkeyIDM.TestsBase.driver;
import static Search_AnkeyIDM.TestsBase.wait;
import static Search_AnkeyIDM.selectors.Elements.*;

public class AnkeyIDM {
    public static String downloadPath = "C:\\Users\\Ксения\\Downloads";
    public static String fileName = "ankey-idm-manual-user.pdf";


    public static void searchAndDownloadAnkeyIDM() {
        HelpersBase.scrollPage();

        wait.until(ExpectedConditions.visibilityOf(materials));
        wait.until(ExpectedConditions.elementToBeClickable(materials));
        materials.click();

        wait.until(ExpectedConditions.visibilityOf(documents));
        wait.until(ExpectedConditions.elementToBeClickable(documents));

        List<WebElement> documents = driver.findElements(documentsCss);
        for (WebElement e : documents) {
            if (e.getText().contains("Руководство пользователя Ankey IDM")) {
                e.click();
            }
        }
    }

    public static void waitForFileToDownload() {
        File file = new File(downloadPath, fileName);
        int waitedTime = 0;

        while (waitedTime < 60) {
            if (file.exists()) {
                System.out.println("Файл успешно загружен!");
                break;
            }
            try {
                Thread.sleep(1000);
                waitedTime++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (!file.exists()) {
            System.out.println("Ошибка: файл не загрузился.");
        }
    }
}
