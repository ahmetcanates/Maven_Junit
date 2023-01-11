package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class P22WindowHandle extends TestBase {

    @Test
    public void test() {
        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
        String firstHandle = driver.getWindowHandle();

        // arama motoruna 'oppo' yazıp aratın
        driver.findElement(By.id("searchData")).sendKeys("oppo", Keys.ENTER);

        // ilk ürüne tıklayın
        List<WebElement> urunler = driver.findElements(By.xpath("//*[@class='productName']"));
        urunler.get(0).click();

        // Basligin 'Oppo' icerdigini test edin.
        switchToWindow(1);
        String baslik = driver.findElement(By.xpath("//*[@class='proName']")).getText();
        Assert.assertTrue(baslik.contains("Oppo"));

        // ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(firstHandle);
        System.out.println(driver.getTitle());
    }
}
