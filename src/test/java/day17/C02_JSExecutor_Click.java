package day17;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_JSExecutor_Click extends TestBase {

    //clickByJSTest
    //Techpro education ana sayfasina git
    //LMS LOGIN elementine tikla
    //Cikan sayfayinin URL inin “https://lms.techproeducation.com/” oldugunu test et


    @Test
    public void clickByJSTest() {
        driver.get("https://techproeducation.com");
        waitFor(3);
        clickByJS(driver.findElement(By.linkText("LMS LOGIN")));
        Assert.assertEquals("https://lms.techproeducation.com/",driver.getCurrentUrl());
    }
}
