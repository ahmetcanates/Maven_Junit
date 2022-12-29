package day07;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase{
    /*
        UTILITIES:
        -Utilities tekrar tekrar kullanacagimiz classlari koydugumuz paketin adidir.
            -TestBase -> Bugun
            -Driver -> Sonra
            -ExcelUtil -> Sonra
            -Configuration -> Sonra
        -Utilities paketinde Test Case'ler yazilmaz.
        -Sadece tekrar kullanilabilecek destek siniflari(support class) olusturulur.
     */

    @Test
    public void test1() {
//      techproeducation ana sayfasina git ve title'in Bootcamps kelimesini icerdigini test et.
        driver.get("https://www.techproeducation.com");
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Bootcamps"));
    }
}
