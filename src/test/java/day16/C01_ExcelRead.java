package day16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {

    @Test
    public void readExcelTest() throws Exception {
        //  WORKBOOK(EXCEL DOSYASI) > WORKSHEET/SHEET(SAYFA) > ROW(SATIR) > CELL(VERI HUCRESI)
        String path = "./src/test/java/resources/Capitals.xlsx";

        //DOSYAYI AC
        FileInputStream fileInputStream = new FileInputStream(path);

        //EXCEL DOSYASINI AC/ WORKBOOK AC
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //SAYFAYI AC / Sheet1
//        Sheet sheet1 = workbook.getSheetAt(0);    //calisma sayfasinin indexi. index 0'dan baslar. ilk sayfayi ac
        Sheet sheet1 = workbook.getSheet("Sheet1");//calisma sayfasinin ismi    //Sheet1 isimli sayfayi ac

        //ILK SATIRA GIT / ROW
        Row row1 = sheet1.getRow(0);// ILK SATIRA GIT

        //ILK SATIRDAKI ILK VERIYI AL
        Cell cell1 = row1.getCell(0);// ILK HUCREDEKI DATAYI VER

        //O VERIYI YAZDIR
        System.out.println(cell1);

        //1.SATIR 2.SUTUN
        Cell cell12 = sheet1.getRow(0).getCell(1);
        System.out.println(cell12);

        //3.satir 1.sutun yazdir ve o verinin France oldugunu test et      //toString methoduyla String'e cevirebiliriz
        String cell31 = sheet1.getRow(2).getCell(0).toString();
        System.out.println(cell31);
        Assert.assertEquals("France",cell31);

        //Excel'deki toplam satir sayisini bul
        int toplamSatirSayisi = sheet1.getLastRowNum()+1; //son satir numarasi --- int return eder. index 0'dan basliyor sayma sayilari 1 den. +1 ekle
        System.out.println(toplamSatirSayisi);

        //Kullanilan toplam satir sayisini bul
        int kullanilanToplamSatirSayisi = sheet1.getPhysicalNumberOfRows();
        System.out.println(kullanilanToplamSatirSayisi);//1edn basliyor

        //COUNTRY, CAPITALS key ve value leri map'a alip print et
        //{{USA, D.C}, {FRANCE, PARIS}, ...}

        //Variable olusturalim. Bu variable exceldeki country, capital verilerini tutacak
        Map<String, String> ulkeBaskentleri = new HashMap<>();

        for(int satirSayisi=1; satirSayisi<kullanilanToplamSatirSayisi; satirSayisi++) {//country keyword unu almamak icin satirsayisini 1'den basladik
            String country = sheet1.getRow(satirSayisi).getCell(0).toString();
            String capital = sheet1.getRow(satirSayisi).getCell(1).toString();
            ulkeBaskentleri.put(country,capital);
            //ulkeBaskentleri.put(sheet1.getRow(satirSayisi).getCell(0).toString(),sheet1.getRow(satirSayisi).getCell(1).toString());
        }
        System.out.println(ulkeBaskentleri);

    }
}
