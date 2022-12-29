package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P07 {

    /*
       https://www.google.com/ adresine gidin
       cookies uyarisini kabul ederek kapatin
       Sayfa basliginin “Google” ifadesi icerdigini test edin
       Arama cubuguna “Nutella” yazip aratin
       Bulunan sonuc sayisini yazdirin
       sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
       Sayfayi kapatin
     */
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        //https://www.google.com/ adresine gidin
        driver.get("https://google.com");

        //cookies uyarisini kabul ederek kapatin

        //Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);

        //Bulunan sonuc sayisini yazdirin
        String[] sonucSayisi = driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" ");
        String sonuc = sonucSayisi[1];
        System.out.println("sonuc = " + sonuc);

        //sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        sonuc = sonuc.replaceAll("[^0-9]","");  //     \\D de kullanilabilirdi
        System.out.println("sonuc = " + sonuc);
        int istenenSayi = 10000000;
        Assert.assertTrue(Integer.parseInt(sonuc)>istenenSayi);

        //Sayfayi kapatin
        driver.close();
    }
}
