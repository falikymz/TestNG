package techpored.tests.day20_annotations_softassert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C06_SoftAssertion {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        SoftAssert softAssert=new SoftAssert();
        // 1- amazon anasayfaya gidin
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();

        // 2- title'in Amazon icerdigini test edin
        String actualTitle = driver.getTitle();
        softAssert.assertTrue(actualTitle.contains("Amazon"),"title amazon içermiyor");
        // 3- Arama kutusunun erisilebilir oldugunu test edin
        WebElement searchBox =driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(searchBox.isEnabled(),"Arama kutusuna erişilemiyor");

        // 4- arama kutusuna selenium yazip aratin
        searchBox.sendKeys("selenium",Keys.ENTER);

        // 5- arama yapildigini test edin
        String resultText=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();
        softAssert.assertTrue(resultText.contains("results"),"");

        // 6- arama sonucunun selenium icerdigini test edin
      softAssert.assertTrue(resultText.contains("selenium"));

      softAssert.assertAll();
      driver.close();

    }

}
