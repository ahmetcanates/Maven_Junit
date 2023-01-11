package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P21WindowHandle extends TestBase {

    @Test
    public void test() {
        // ...Exercise 2..
        // 1- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        String amazonHandle = driver.getWindowHandle();
        System.out.println("amazonHandle = " + amazonHandle);

        // 2- url'in 'amazon' icerdigini test edelim
        String actualUrl = driver.getCurrentUrl();
        String expectedWord = "amazon";
        Assert.assertTrue(actualUrl.contains(expectedWord));

        // 3- yeni bir pencere acip https://www.bestbuy.com sayfasina gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");

        // 4- title'in 'Best Buy' icerdigini test edelim
        String bestBuyTitle = driver.getTitle();
        String expectedWord2 = "Best Buy";
        Assert.assertTrue(bestBuyTitle.contains(expectedWord2));
        String bestBuyHandle = driver.getWindowHandle();
        System.out.println("bestBuyHandle = " + bestBuyHandle);

        // 5- ilk sayfaya(amazon) donup sayfada java aratalım
        driver.switchTo().window(amazonHandle);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java", Keys.ENTER);

        // 6- arama sonuclarının 'Java' icerdigini test edelim
        String aramaSonucYazisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        Assert.assertTrue(aramaSonucYazisi.contains("java"));

        // 7- ikinci sayfaya(bestbuy) donelim
        driver.switchTo().window(bestBuyHandle);

        // 8- logonun gorundugunu test edelim
        WebElement bestBuyLogo = driver.findElement(By.xpath("(//*[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue(bestBuyLogo.isDisplayed());
    }
}
