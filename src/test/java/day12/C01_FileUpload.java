package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_FileUpload extends TestBase {
    @Test
    public void fileUploadTest() {
        //Tests packagenin altina bir class oluşturun : C05_UploadFile
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        WebElement dosyaSec = driver.findElement(By.id("file-upload"));

        //Yuklemek istediginiz dosyayi secelim.
        String path =System.getProperty("user.home")+"\\OneDrive\\Masaüstü\\logo.jpeg";
        dosyaSec.sendKeys(path);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //"File Uploaded!" textinin goruntulendigini test edelim.
        String uploadYazisi= driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("File Uploaded!",uploadYazisi);
        waitFor(3);

    }
}