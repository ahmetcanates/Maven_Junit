package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_Screenshot2 extends TestBase {

    @Test
    public void screenshotOfSpecificElements() throws IOException {
        //techproeducation'a git
        driver.get("https://www.techproeducation.com");

        //sosyal medya elemanlarinin ekran goruntusunu al
        WebElement sosyalMedyaIconlari = driver.findElement(By.xpath("(//*[@class='elementor-widget-container'])[1]"));
        File image = sosyalMedyaIconlari.getScreenshotAs(OutputType.FILE);

        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+"image.png";
        FileUtils.copyFile(image,new File(path));

        //LOGONUN EKRAN GORUNTUSUNU ALMAK ICIN
        takeScreenshotOfElement(driver.findElement(By.xpath("//div[@data-id='898ce2e']")));
    }
}
