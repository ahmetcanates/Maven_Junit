package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_AlertsAccept extends TestBase {

    @Test
    public void acceptAlertTest() throws InterruptedException {
       //Bir class olusturun: Alerts
       //https://testcenter.techproeducation.com/index.php?page=javascript-alerts  adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
       //1. butona tıklayın,
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
        // uyarıdaki OK butonuna tıklayın
        driver.switchTo().  //degistir
                alert().    //alert'e degistir
                accept();   //OK secenegine tiklanir
        Thread.sleep(3000);
        // ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        String actualResult = driver.findElement(By.id("result")).getText();
        String expectedResult = "You successfully clicked an alert";
        Assert.assertEquals(expectedResult,actualResult);

       //Bir metod olusturun: sendKeysAlert
       //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    }
    /*
        Alert'leri nasil automate edersin? How to handle alerts in selenium?
        -Alert'ler javascript ile olusur. Inspect edilemezler. Oncelikle alerte switch etmeniz gerekir.
     */
}
