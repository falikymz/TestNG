package techproed.tests.day24_dataprovider_xmlfiles;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C01_DataProvider {


    @DataProvider
    public static Object[][] names() {
        return new Object[][]{
                {"mustafa"},{"ibrahim"},{"furkan"},{"ali"}
        };
    }

    @Test(dataProvider = "names" )
    public void test01(String data) {
        System.out.println(data);
    }

//************************************************

    @DataProvider
    public static Object[][] isimlervesoyisimler() {
        return new Object[][]{
                {"ali","can"},
                {"veli","han"},
                {"ahmet","san"},
        };
    }

    @Test(dataProvider = "isimlervesoyisimler")
    public void test02(String isim , String soyisim) {
        System.out.println(isim+" "+soyisim);
    }
}
