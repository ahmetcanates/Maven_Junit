package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P06 {
    /*
    - ebay sayfasına gidiniz
    - electronics bölümüne tıklayınız
    - Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
    - Her sayfanın sayfa başlığını yazdıralım
    - sayfayı kapatalım
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test() {
        //  ebay sayfasına gidiniz
        driver.get("https://www.ebay.com/");
        //  electronics bölümüne tıklayınız
        driver.findElement(By.xpath("(//*[text()='Electronics'])[2]")).click();
        //  Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
        //  Her sayfanın sayfa başlığını yazdıralım

        for (int i = 0; i < 24; i++) {
            List<WebElement> urunler = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
            urunler.get(i).click();
            System.out.println((i+1)+". baslik : "+driver.getTitle());
            driver.navigate().back();
        }

        //  sayfayı kapatalım
    }
    @AfterClass
    public static void afterClass() {
        driver.close();
    }
}
