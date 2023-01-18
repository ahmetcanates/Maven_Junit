package practice;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class P27ScreenShot extends TestBase {
    //Amazon sayfasına gidelim
    //Tüm sayfanın resmini alalım
    //Yeni bir sekmede techproeducation sayfasına gidip sayfanın resmini alalım
    //Tekrar amazon sayfasına dönüp iphone aratalım
    //Arama sonucunun resmini alalım

    String tarih;

    @Test
    public void test() throws IOException {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Tüm sayfanın resmini alalım
        TakesScreenshot ts = (TakesScreenshot)driver;   //casting
        /*
            FILEUTILS CLASS'I FILE NESNELERI ILE BIRLIKTE KULLANABILECEGIMIZ METHODLAR ICERIR.
            BU METHODLARI KULLANARAK DOSYALARDA OKUMA, YAZMA VE KOPYALAMA ISLEMLERINI COK DAHA KOLAY YAPABILIRIZ
         */
        tarih = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResmi/tumSayfa"+tarih+".jpeg"));

        //Yeni bir sekmede techproeducation sayfasına gidip sayfanın resmini alalım
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");
        tarih = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/tumSayfaResmi/tumSayfa"+tarih+".jpeg"));
        //Tekrar amazon sayfasına dönüp iphone aratalım
        //Arama sonucunun resmini alalım
    }
}
