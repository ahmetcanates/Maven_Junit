package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_NoSuchElementException extends  TestBase {
    @Test
    public void nuSuchElementException(){
        /*
​
         */

        driver.get("https://techproeducation.com");
        // driver.findElement(By.xpath("//input[@type='searchh']")).sendKeys("QA"+ Keys.ENTER);
        //YANLIS LOCATE EDILDIGI ICIN org.openqa.selenium.NoSuchElementException HATASI ALDIK
        //org.openqa.selenium.NoSuchElementException bu exception javadan degil seleniumdan geliyor.

    }
}