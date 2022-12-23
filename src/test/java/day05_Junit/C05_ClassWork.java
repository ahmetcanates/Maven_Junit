package day05_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_ClassWork {
    WebDriver driver;
    //Verilen web sayfasına gidin.
    //https://the-internet.herokuapp.com/checkboxes
    //Checkbox1 ve checkbox2 elementlerini locate edin.
    //Checkbox1 seçili değilse onay kutusunu tıklayın
    //Checkbox2 seçili değilse onay kutusunu tıklayın
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
          driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        //Verilen web sayfasına gidin.
        //https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkbox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));

        //Checkbox1 seçili değilse onay kutusunu tıklayın
        Thread.sleep(3000);
        if(!checkbox1.isSelected()) {   //Eger secili degilse
            checkbox1.click();
        }

        //Checkbox2 seçili ise onay kutusunu tıklayın
        if(checkbox2.isSelected()) {
            checkbox2.click();
        }
    }
}
