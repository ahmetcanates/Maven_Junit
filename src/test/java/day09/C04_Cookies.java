package day09;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C04_Cookies extends TestBase {

    @Test
    public void handleCookiesTest() {
        //Amazona git
        driver.get("https://www.amazon.com");
        waitFor(2);
        //1.toplam cookie sayisini bul
        Set<Cookie> allCookies = driver.manage().getCookies();
        int cookieSayisi = allCookies.size();
        System.out.println("Sayfada "+cookieSayisi+" adet cookie var");

        //tum cookiler'i yazdiralim
        //allCookies.stream().forEach(t -> System.out.println(t.getName()));

        for (Cookie eachCookie : allCookies){
            System.out.println("COOKIE : "+eachCookie);//COOKIENIN TAMAMINI YAZDIR
            System.out.println("COOKIE ISIMLERI : " + eachCookie.getName());
        }

        //3. Bir Cookie yi ismiyle bul
        System.out.println("COOKIEYI ISMIYLE CAGIRIYORUM : "+driver.manage().getCookieNamed("i18n-prefs"));

        //4. Yeni bir cookie ekle
        Cookie favoriCookiem = new Cookie("cikolatam","antep-fistikli-cikolata");
        driver.manage().addCookie(favoriCookiem);
        waitFor(3);
        System.out.println("Yeni cookie sayisi : "+ driver.manage().getCookies().size());

        //5. Bir Cookie yi ismiyle sil
        driver.manage().deleteCookieNamed("session-id");
        //6. Tum cookie leri sil
        driver.manage().deleteAllCookies();
        waitFor(5);
        System.out.println("TUM COOKILERI SILDIM. YENI COOKIE SAYISI : " + driver.manage().getCookies().size());
    }
}
