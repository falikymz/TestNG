package techpored.tests.day21_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import techpored.pages.OpenSourcePage;
import techpored.utilities.Driver;

public class C03_PageKullanimi {

    @Test
    public void test01() throws InterruptedException {
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim login olalım
        OpenSourcePage orangeHRMPage= new OpenSourcePage();

        //kullanici=Admin
        orangeHRMPage.userName.sendKeys("Admin");

        //kullaniciSifre=admin123
        orangeHRMPage.password.sendKeys("admin123");

        orangeHRMPage.loginButton.submit();

        Thread.sleep(2000);

        //Login Testinin basarili oldugunu test edelim
        Assert.assertTrue(orangeHRMPage.dashBoard.isDisplayed());

        //sayfayı kapatalim
        Driver.closeDriver();


    }
}
