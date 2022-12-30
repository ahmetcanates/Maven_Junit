package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_IFrame extends TestBase {

    @Test
    public void iframeTest() {
        //Iframe nedir?
        //https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //Ana sayfadaki An iframe with a thin black border: metnin black border yazisinin oldugunu test edelim
        WebElement anIframetext = driver.findElement(By.xpath("//*[text()='An iframe with a thin black border:']"));
        Assert.assertTrue(anIframetext.isDisplayed());

        //Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@style='border:1px solid black;']")));
        WebElement appListText = driver.findElement(By.xpath("//*[text()='Applications lists']"));
        Assert.assertTrue(appListText.isDisplayed());

        //Son olarak footer daki ‘Powered By’ yazisini varligini test edilip
        driver.switchTo().parentFrame();
        WebElement poveredBy = driver.findElement(By.xpath("//*[text()='Povered By']"));
        Assert.assertTrue(poveredBy.isDisplayed());
    }
}
