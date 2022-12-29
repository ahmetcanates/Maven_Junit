package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_DismissAlert extends TestBase {

    @Test
    public void dismissAlertTest() throws InterruptedException {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts  adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //2. butona tıklayın,
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();
        Thread.sleep(2000);

        // uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss();    // CANCEL secenegine tikliyoruz.

        // ve result mesajının “You clicked: Cancel” oldugunu test edin.
        String actualResult = driver.findElement(By.xpath("//*[@id='result']")).getText();  //gercek deger
        String expectedResult = "You clicked: Cancel";  //beklenen deger

        Assert.assertEquals(expectedResult,actualResult);

    }

}
