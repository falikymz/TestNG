package techproed.tests.day20_annotations_softassert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C04_DependsOnMethods {

    /*
    Test NG de DependsOnMethods ozelligini kullanarak bazi testlerin bagimli oldugu
        diger testlerin basarili olmasi durumuna göre calistirabilirsiniz
        DependsOnMethods baglandigi testin sonucuna bakar, passed olursa calisir fail olursa hic calismaz

     TestNG de tum  @Test metotlar bitbirlerinden bagimsiz olarak calisirlar
    Eger methodlari bagimli hale getirmek istersem, dependsOnMethods parametresi kullanilir
    Burdaki ornekde, test02 methodu test01 methoduna bagimlidir
    test02 den once test01 calisir
    Eger test01 basarili ise test02 calisir.
    Eget test01 basarisiz ise, test02 IGNORE edilir
     */

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        //amazona sayfasına gidiniz
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();

        //arama kutusunda iphone aratınız
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

       // ilk olarak test02 çalıştırıldğında Assert.assertEquals(2,3); burada test01 pass olmazsa test02 çalışmayacak

    }

    @Test(dependsOnMethods = "test01")
    public void test02() {
        //sonuc yazısını iphone içerdiğini test edelim
        String resultText =driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();
        Assert.assertTrue(resultText.contains("iphone"));
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
