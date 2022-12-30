package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_IFrame extends TestBase {

    @Test
    public void iframeTest() {
        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki An iframe with a thin black border: metnin black border yazisinin oldugunu test edelim
        String anIframetext = driver.findElement(By.xpath("//*[.='An iframe with a thin black border:']")).getText();
        //tag[.='metin'];    Bana bu tagli metni ver.
        //tag[text()='text']
        String expectedText = "black border";
        Assert.assertTrue(anIframetext.contains(expectedText));

        //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);//index 0'dan baslar ilk iframe'e gecis yapiyoruz.
        String icMetin = driver.findElement(By.xpath("//*[text()='Applications lists']")).getText();
        String expectedText1 = "Applications lists";
        Assert.assertEquals(expectedText1,icMetin);

        //Alternatif olarak alttaki secenekler de kullanilabilir.
        //Assert.assertTrue(icMetin.contains(expectedText1));
        //Assert.assertTrue(driver.findElement(By.xpath("//*[.='Applications lists']")).isDisplayed());

        //Son olarak footer daki ‘Powered By’ yazisini varligini test edilip
        //Ana sayfadaki 'Povered By' yazisini test etmek istiyorum ama driver hala iframe'in icinde
        //iframe'in disina cikmak icin driver.swtichTo().defaultContent/parentFrame
        driver.switchTo().defaultContent();
        String footerText = driver.findElement(By.xpath("(//footer[@class='blog-footer'][1])//p")).getText();
        System.out.println(footerText);
        Assert.assertTrue(footerText.contains("Povered By"));
    }
}
