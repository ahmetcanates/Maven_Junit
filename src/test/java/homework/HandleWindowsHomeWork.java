package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class HandleWindowsHomeWork extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");
        String window1 = driver.getWindowHandle();
        System.out.println("window1 = " + window1);

        //Title'in "Windows" oldugunu test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Windows";
        Assert.assertEquals(actualTitle,expectedTitle);

        //Click here a tiklayin
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(2000);

        //Sonra acilan sayfadaki title in "New Window" oldugunu dogrulayin
        Set<String> pencereler = driver.getWindowHandles();     //     {window1, window2}
        System.out.println(pencereler);
        for(String eachWindow : pencereler) {
            if (!eachWindow.equals(window1)) {
                driver.switchTo().window(eachWindow);
                break;
            }
        }
            String window2Title = driver.getTitle();
            Assert.assertEquals("New Window",window2Title);
    }




}
