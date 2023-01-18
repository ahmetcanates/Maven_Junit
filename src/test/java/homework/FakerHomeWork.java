package homework;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class FakerHomeWork extends TestBase {

    @Test
    public void fakerTest() {
        //Faker class’i testlerimizi yaparken ihtiyav duydugumuz isim, soyisim, adres vb bilgiler icin fake
        //degerler uretmemize imkan tanir.
        //Faker degerler uretmek icin Faker class’indan bir obje uretir ve var olan method’lari kullaniriz.
        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");

        //“create new account”  butonuna basin
        WebElement createButton = driver.findElement(By.id("u_0_0_5b"));
        createButton.click();
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        //“firstName” giris kutusuna bir isim yazin

        driver.findElement(By.name("firstname")).sendKeys(firstName, Keys.TAB,lastName, Keys.TAB,email, Keys.TAB,email, Keys.TAB,
                password, Keys.TAB);//soyad kismina gecmek icin TAB kullandik

        //“surname” giris kutusuna bir soyisim yazin

        //“email” giris kutusuna bir email yazin
        //“email” onay kutusuna emaili tekrar yazin
        //Bir sifre girin
        WebElement day = driver.findElement(By.xpath("//*[@id='day']"));
        day.sendKeys("10",Keys.TAB,"10",Keys.TAB,"2010");
        //Tarih icin gun secin
        //Tarih icin ay secin
        //Tarih icin yil secin
        //Cinsiyeti secin
        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        //Sayfayi kapatin
    }
}
