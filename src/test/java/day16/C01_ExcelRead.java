package day16;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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
    }
}
