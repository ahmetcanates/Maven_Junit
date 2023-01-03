package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class P08 extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");
        //Dropdown menuyu yazdiralim
        WebElement dropdown = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(dropdown);
        for(WebElement w: select.getOptions()) {
            System.out.println(w.getText());
        }

        //Dropdown menuden baby secelim
        //arama bolumunden milk aratalim
        driver.findElement(By.xpath("//*[@id='searchDropdownBox']")).sendKeys("Baby", Keys.TAB,"Milk",Keys.ENTER);
        Thread.sleep(2000);


    }
}
