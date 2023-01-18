package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {
    @Test
    public void timeOutException(){
        /*
        TIMEOUTEXCEPTION NE ZAMAN ALIRIM?????

        => TimeOutException ; explicit wait kullanildigi zaman ve element bulunamadiginda alinir

        Explicit wait ve yanlis locator ---> timeoutException
        Explicit wait & dogru locator & sure yeterli degil ---> timeoutException
        Explicit wait & dogru locator & sure yeterli & iframe var ---> timeOutException

        NASIL COZERIZ?
        -Oncelikle sureyi artirabiliriz
        -Farkli explicit wait kullanilabilir.
         orn waitForVisibility yerine presenceOfElementLocator.
         Ya da Javascript executordaki waiter sayfa gecislerini beklemek icin kullanabiliriz
        -Locator i tekrara kontrol edebiliriz
        -Frameworkunde hazir reusable methodlar var. bu durumda timeoutexception aldigimda izlica
         o methodlar yardimiyla problemi cozebiliyoruz
         */
        driver.get("https://techproeducation.com");

//        Explit wait icin olusturdugumuz methodlardan birini kullanalim
//        Parametre 1: beklemek istedigim element, Parametre 2: Max sure
//        waitForVisibility(By.xpath("//input[@type='searchh']"),25)//org.openqa.selenium.TimeoutException:
//                .sendKeys("QA"+ Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("YANLIS ID")));//org.openqa.selenium.TimeoutException:
    }
}
