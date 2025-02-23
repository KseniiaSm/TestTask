package Search_AnkeyIDM.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.List;

import static Search_AnkeyIDM.TestsBase.driver;
import static Search_AnkeyIDM.TestsBase.wait;

public class AnkeyIDM {
    @FindBy(css = "#tab-materialy")
    public static WebElement materials;

    @FindBy(css = "#materialy tr")
    public static WebElement documents;
    public static By documentsCss = By.cssSelector("#materialy tr");

    public static String downloadPath = "C:\\Users\\Ксения\\Downloads";
    public static String fileName = "ankey-idm-manual-user.pdf";



    public static void searchAndDownloadAnkeyIDM(){
        wait.until(ExpectedConditions.visibilityOf(materials));
        wait.until(ExpectedConditions.elementToBeClickable(materials));
        materials.click();

        wait.until(ExpectedConditions.visibilityOf(documents));
        wait.until(ExpectedConditions.elementToBeClickable(documents));

        List <WebElement> documents = driver.findElements(documentsCss);
        for (WebElement e:documents) {
            if(e.getText().contains("Руководство пользователя Ankey IDM")) {
                e.click();
            }
        }
    }

    public static boolean waitForFileToDownload () {
        File file = new File(downloadPath, fileName);
        int waitedTime = 0;

        while (waitedTime < 60) {
            if (file.exists()) {
                System.out.println("Файл успешно загружен!");
                return true;
            }
            try {
                Thread.sleep(1000);
                waitedTime++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Ошибка: файл не загрузился.");
        return false;
    }

}
