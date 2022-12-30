package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBase {
    //TestBase'i abstract yapmamizin sebebi bu sinifin objesini olusturmak istemiyorum
    //  TestBase t = new TestBase();    -> YAPILAMAZ
    //Amacim bu sinifi extend etmek ve icindeki hazir methodlari kullanmak

    //driver objesini olustur. Driver ya public ya protected olmali
    //Sebebi child classlarda gorulebilir olmasi
    protected static WebDriver driver;

    //setUp
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    //tearDown

    @After
    public void tearDown() {
        driver.quit();
    }

    //    MULTIPLE WINDOW:
    // Bir parametre alir: Gecis yapmak istedigim sayfanin title'i
    //ORNEK: switchToWindow("New Window")
    public static void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;//CIK. break;
            }
        }
        driver.switchTo().window(origin);
    }

}
