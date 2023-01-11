package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void isExistTest() {
        String userDIR = System.getProperty("user.dir");
        System.out.println(userDIR);//C:\Users\ahmet\IdeaProjects\B103Maven_Junit

        String userHOME = System.getProperty("user.home");
        System.out.println(userHOME);//C:\Users\ahmet

        //logo.jpeg indirip MASAUSTUNE kaydedin

        String dosyaYolu = userHOME + "\\OneDrive\\Masaüstü";
        System.out.println(dosyaYolu);

        boolean isExist = Files.exists(Paths.get(dosyaYolu));
        Assert.assertTrue(isExist);
        /*
        1. fail -> PATH YANLIS : dosya masa ustunde degil, dosya adi yanlis, yada arada onedrive gibi ex dosyalar olarak
         */
    }
}
