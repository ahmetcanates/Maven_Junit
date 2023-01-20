package day18;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class C02_Log4J {

    //3. Logger object olustur:
//    private static Logger logger = LogManager.getLogger(Demo1.class.getName());
//4. Logger fonksiyonuyla istenilen fonksiyonu kullan
//        logger.debug("Debug logger");
//        logger.info("Info logger");
//        logger.error("Error logger");
//        logger.fatal("Fatal logger");
    private static Logger logger = LogManager.getLogger(C02_Log4J.class.getName());
    @Test
    public void log4JTest(){
//        logger objesi ile yazdirma islemini yap
        logger.fatal("Fatal Log!");
        logger.error("Error Log!");
        logger.warn("Warn Log!");
        logger.debug("Debug Log!");
        logger.info("Info Log!");
    }

    //Log4j Nedir?
    //Loglama yani yazdırma islemi yapmak icin kullanılan bir API dir
    //Cesitli seviyelerde loglama islemi yapılabilir: uyarı, bilgi, debug, hata mesajları icin kullanilabilir
    //Javadaki system.out.println e benzer, ama log4 j ile dosyaya detaylı sekilde yazdırma islemi yapabilir.
    //Su anda projemde log4J2 kullanmaktayım
}