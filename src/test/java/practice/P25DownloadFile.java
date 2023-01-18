package practice;

import com.beust.ah.A;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class P25DownloadFile extends TestBase {
    //https://www.selenium.dev/downloads/ adresine gidelim
    //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
    //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
    //All versions available in Downloads altında Latest stable release olan linki tıklayalım
    //Açılan pencerede chromedriver'i indirelim
    //Driver'in indiğini doğrulayalım

    @Test
    public void test() {
        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");
        String firstWindow = driver.getWindowHandle();

        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN);

        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        driver.findElement(By.xpath("//*[@data-target='#supported-browsers']")).click();
        driver.findElement(By.xpath("(//a[.='documentation'])[5]")).click();

        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        driver.findElement(By.xpath("(//*[@class=' aw5Odc'])[2]")).click();

        //Açılan pencerede chromedriver'i indirelim
        switchToWindow(1);
        driver.findElement(By.linkText("chromedriver_win32.zip")).click();

        //Driver'in indiğini doğrulayalım
        String filePath = System.getProperty("user.home")+"\\Downloads\\chromedriver_win32";
        boolean isDownloaded = Files.exists(Paths.get(filePath));
        System.out.println(isDownloaded);
    }
}
