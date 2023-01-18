package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P26Practice extends TestBase {
    //Amazon sayfasına gidelim
    //iphone aratalım
    //Çıkan ürünlerde sadece Apple iPhone yazanları tıklayalım


    @Test
    public void test() {
        //Amazon sayfasına gidelim
        driver.get("https://www.amazon.com");

        //iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Çıkan ürünlerde sadece Apple iPhone yazanları tıklayalım
        List<WebElement> urunler = driver.findElements(By.partialLinkText("Apple iPhone"));
        //TEXT ICINDE APPLE IPHONE YAZISI GECENLERI ALICAK
        for (int i = 0; i < urunler.size(); i++) {
            urunler = driver.findElements(By.partialLinkText("Apple iPhone"));
            urunler.get(i).click();
            driver.navigate().back();
        }
    }
    //StaleElementReferansException hatasını handle etmek için loop içine webelementlerden oluşturduğumuz
    //list'i koymalıyız
}
