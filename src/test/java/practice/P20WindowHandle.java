package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P20WindowHandle extends TestBase {

    @Test
    public void test01() {
        // 1- https://www.amazon.com sayfasına gidin
        driver.get("https://www.amazon.com");
        String firstHandle = driver.getWindowHandle();

        // 2- nutella icin arama yapın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("nutella", Keys.ENTER);

        // 3- yeni bir tab'da ilk urunun resmine tıklayınız
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("nutella", Keys.ENTER);
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();

        // 4- yeni tab'da acilan urunun basligini yazdirin
        System.out.println(driver.getTitle());

        // 5- ilk sayfaya gecip url'i yazdırın
        driver.switchTo().window(firstHandle);
        System.out.println(driver.getCurrentUrl());
    }

}
