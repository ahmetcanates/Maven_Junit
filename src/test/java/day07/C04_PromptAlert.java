package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04_PromptAlert extends TestBase {


    @Test
    public void sendKeysMethod() throws InterruptedException {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts  adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //3. butona tıklayın,
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        Thread.sleep(3000);
        // uyarıdaki metin kutusuna isminizi yazin,
        driver.switchTo().alert().sendKeys("Ahmet");
        Thread.sleep(3000);
        // OK butonuna tıklayın
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        // ve result mesajında isminizin görüntülendiğini doğrulayın.
        String actualResult = driver.findElement(By.id("result")).getText();
        String expectedResult = "Ahmet";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
