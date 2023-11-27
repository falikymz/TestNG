package techpored.tests.day21_POM;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techpored.pages.AmazonPage;
import techpored.utilities.Driver;

public class C02_PageKullanimi {

    @Test
    public void testName() {
        //amazon sayfasına gidelim
        Driver.getDriver().get("https://amazon.com");
        Driver.getDriver().navigate().refresh();
        Driver.getDriver().navigate().refresh();

        //arama kutusunda iphone aratalım
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.searchBox.sendKeys("iphone", Keys.ENTER);



    }
}
