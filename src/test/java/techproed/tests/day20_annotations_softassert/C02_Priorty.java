package techproed.tests.day20_annotations_softassert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_Priorty {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    //Default olarak sıfır old için ikinci olarak bu method çalıştı
    @Test
    public void youtubeTest() {
        driver.get("https://youtube.com");
    }

    //priority 2 old icin en son bu çalıştı
    @Test(priority = 2)
    public void amazonTest() {
        driver.get("https://amazon.com");
    }


    //prioritysi en küçük olan test method bu old için ilk olarak bu test methodu çalıştı
    @Test(priority = -1)
    public void facebookTest() {
        driver.get("https://facebook.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
