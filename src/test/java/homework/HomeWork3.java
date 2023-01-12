package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class HomeWork3 extends TestBase {

    static Select select;
    static WebElement amazonDropdown;
    List<WebElement> amazonDropdownOptions;

    String anaHedefTitle;

    String anaHedefFiyat;
    String babyTitle;
    String babyFiyat;

    @Test
    public void test() {
        //Test01 :  1- amazon gidin
        driver.get("https://amazon.com");

        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        amazonDropdown = driver.findElement(By.id("searchDropdownBox"));
        select = new Select(amazonDropdown);
        amazonDropdownOptions =  select.getOptions();
        for(WebElement w : amazonDropdownOptions) {
            System.out.println(w.getText());
        }

        //dropdown menude 40 eleman olduğunu-olmadigini doğrulayın
        int amazonDropdownSize = amazonDropdownOptions.size();
        Assert.assertNotEquals(40,amazonDropdownSize);
    }


    //Test02
    //dropdown menuden elektronik bölümü seçin
    //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
    //sonuc sayisi bildiren yazinin iphone icerdigini test edin
    //ikinci ürüne relative locater kullanarak tıklayin
    //ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim

    @Test
    public void test2() {
        driver.get("https://amazon.com");
        amazonDropdown = driver.findElement(By.id("searchDropdownBox"));
        select = new Select(amazonDropdown);
        select.selectByVisibleText("Electronics");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        WebElement result = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String resultText = result.getText();
        System.out.println(resultText);
        Assert.assertTrue(resultText.contains("iphone"));

        List<WebElement> iphoneResults = driver.findElements(By.xpath("//*[@class='a-section a-spacing-base']"));
        WebElement anaHedefinSolu = iphoneResults.get(0);
        WebElement anaHedefinAlti = iphoneResults.get(6);
        WebElement anaHedef = driver.findElement(with(By.xpath("//*[@class='a-section a-spacing-base']")).toRightOf(anaHedefinSolu).above(anaHedefinAlti));
        anaHedef.click();

        anaHedefTitle = driver.findElement(By.id("productTitle")).getText();
        anaHedefFiyat = driver.findElement(By.xpath("//*[@class='a-section a-spacing-micro']")).getText();
        System.out.println("anaHedefTitle = " + anaHedefTitle);
        System.out.println("anaHedefFiyat = " + anaHedefFiyat);

        driver.findElement(By.id("add-to-cart-button")).click();//sepete ekledik
    }

    @Test
    public void test3() {
        //Test03
        //yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");

        //dropdown’dan bebek bölümüne secin
        amazonDropdown = driver.findElement(By.id("searchDropdownBox"));
        select = new Select(amazonDropdown);
        select.selectByVisibleText("Baby");

        //bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bebek puset", Keys.ENTER);
        WebElement result = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String resultText = result.getText();
        System.out.println(resultText);

        //sonuç yazsının puset içerdiğini test edin
        Assert.assertTrue(resultText.contains("puset"));

        //5-üçüncü ürüne relative locater kullanarak tıklayin
        List<WebElement> babyResults = driver.findElements(By.xpath("//*[@class='a-size-medium a-color-base a-text-normal']"));
        WebElement anaHedefinAlti = babyResults.get(3);
        WebElement anaHedef = driver.findElement(with(By.xpath("//*[@class='a-size-medium a-color-base a-text-normal']")).above(anaHedefinAlti));
        anaHedef.click();

        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        babyTitle = driver.findElement(By.id("productTitle")).getText();
        babyFiyat = driver.findElement(By.xpath("//*[@class='a-section a-spacing-micro']")).getText();
        System.out.println("anaHedefTitle = " + anaHedefTitle);
        System.out.println("anaHedefFiyat = " + anaHedefFiyat);
        driver.findElement(By.id("add-to-cart-button")).click();//sepete ekledik

        driver.findElement(By.xpath("//a[@id='nav-cart']")).click();//sepete tikladik

        String cartTitle = driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base sc-product-title sc-grid-item-product-title']")).
                getText();
        String cartPrice = driver.
                findElement(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")).
                getText();
    }




    // Test 4
    //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın



}
