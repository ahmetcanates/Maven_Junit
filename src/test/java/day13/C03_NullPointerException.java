package day13;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class C03_NullPointerException{
    /*
    NULLPOINTEREXCEPTION ne zaman aliriz????
    => Degiskenleri olusturup instantiate etmedigimizde aliriz.(new kelimesini kullanmadigimizda)
    instantiate= deger atamak gibi dusunebiliriz
     */
    WebDriver driver; // = new ChromeDriver demedigimiz icin NullPointerException verdi
    Faker faker; // =new Faker demedigimiz icin NullPointerException verdi
    @Test
    public void nullPointerExceptionTest(){
        driver.get("https://www.techproeducation.com");//java.lang.NullPointerException
    }
    @Test
    public void nullPointerExceptionTest2(){

//        faker=new Faker(); > çözüm olur ama biz NullPointExp almak istiyoruz
        System.out.println(faker.name().fullName());//java.lang.NullPointerException
    }
}