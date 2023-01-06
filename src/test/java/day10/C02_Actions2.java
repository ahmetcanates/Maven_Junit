package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions2 extends TestBase {
        /*
          MANUAL:
            Amazon Home sayfasina git
            Account & List uzerinde bekle   -mouse over - hover over
            Acilan pencerede Account linkine tikla
            Acilan sayfanin title'inin Your Account icerdigini dogrula
         */
    @Test
    public void hoverOverTest() {
        driver.get("https://www.amazon.com");

        //1.  ACTIONS OBJESI
        Actions actions = new Actions(driver);

        //2.ELEMANI BUL
        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));

        //3.UYGUN ACTIONS METHODUNU KULLAN. EN SONDA PERFORM KULLANMAYI UNUTMA
        actions.moveToElement(accountList).perform();

        //Acilan pencerede Account linkine tikla
        driver.findElement(By.linkText("Account")).click();

        //Acilan sayfanin title'inin Your Account icerdigini dogrula
        Assert.assertTrue(driver.getTitle().contains("Your Account"));
    }
}
