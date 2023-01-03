package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class IFrameHomeWork extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //Bir class olusturun: IframeOdev
        //https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
        //sayfadaki toplam iframe sayısını bulunuz.
        List<WebElement> iframeNumber = driver.findElements(By.xpath("//iframe"));
        int iframeSayisi = iframeNumber.size();
        System.out.println(iframeSayisi);

        //Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
        String actualTitle = driver.findElement(By.xpath("//h3")).getText();
        String expectedTitle = "Editor";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //Paragrafdaki yaziyi silelim
        WebElement iframe = driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);
        WebElement iframeParagraph = driver.findElement(By.xpath("//*[@id='tinymce']"));
        iframeParagraph.clear();

        //Sonrasinda paragrafa “framein icindeyim” yazisini yazdıralım
        iframeParagraph.sendKeys("framein icindeyim");

        //Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
        driver.switchTo().parentFrame();
        String actualBottomText = driver.findElement(By.xpath("//*[@id='page-footer']")).getText();
        String expectedBottomText = "Elemental Selenium";
        Assert.assertTrue(actualBottomText.contains(expectedBottomText));
    }


}
