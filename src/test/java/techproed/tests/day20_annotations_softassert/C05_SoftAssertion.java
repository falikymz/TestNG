package techproed.tests.day20_annotations_softassert;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C05_SoftAssertion {

    @Test
    public void softAssertionTest() {

        // Öncelikle SoftAssert classindan bir object oluşturmalıyız
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(2,2,"2 eşittir 2 ye bu kontrol başarılı");
        softAssert.assertTrue(2>3,"2, 3 den büyük olmalıydı bu kontrol başarısız");
        softAssert.assertFalse(3>2,"3, 2 den bütük olmamalıydı bu kontrol başarısız");
        softAssert.assertNotEquals("java","java","iki string farklı olmalıydı bu kontrol başarısız");

        softAssert.assertAll(); //assertAll() methodu olmadan softAssert ler çalışmayacaktır

        //asserttAll methodu kendisinden once yapilan tum soft assertion lari degerlendirir,
        //eger herhangi bir method fali olduysa test basarisiz olur ve classın kalan kısmı calıstırılmaz
        //bu method cagrilmazsa soft assertion basarisiz olup olmadigi anlasilmaz

    }

    @Test
    public void hardAssertion() {

        System.out.println("bu kod hard assertion dan once ");

        Assert.assertTrue(false);
        Assert.assertTrue(true); // burda softta ki gibi 2.assert ü çalıştırmıyor

        System.out.println("bu kod hard assertion dan sonra ");


    }
}
