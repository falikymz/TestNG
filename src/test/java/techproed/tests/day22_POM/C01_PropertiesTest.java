package techproed.tests.day22_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C01_PropertiesTest {

    @Test
    public void test01() {
        String amazonUrl= ConfigReader.getProperty("amazonUrl");
        System.out.println("amazonUrl = " + amazonUrl);
        Driver.getDriver().get(amazonUrl);
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        
    }


    @Test
    public void test02() {
      //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get(ConfigReader.getProperty("OpenSourceUrl"));

      // kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim login olalım
        OpenSourcePage openSourcePage =new OpenSourcePage();
        openSourcePage.userName.sendKeys(ConfigReader.getProperty("OpenSourceUserName"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("OpenSourcePassword"));
        openSourcePage.loginButton.click();
      //kullanici=Admin
      //kullaniciSifre=admin123
      //Login Testinin basarili oldugunu test edelim
      Assert.assertTrue(openSourcePage.dashBoard.isDisplayed());

      //sayfayı kapatalim
       Driver.closeDriver();

    }

    //Reusable Methods kullanimi
    @Test
    public void test03() {
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get(ConfigReader.getProperty("OpenSourceUrl"));

        // kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim login olalım
        OpenSourcePage openSourcePage =new OpenSourcePage();
        openSourcePage.userName.sendKeys(ConfigReader.getProperty("OpenSourceUserName"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("OpenSourcePassword"));
        openSourcePage.loginButton.click();

        ReusableMethods.visibleWait(openSourcePage.dashBoard,15);
        ReusableMethods.screenShot("OpenSource");
        ReusableMethods.screenShotOfWebElement(openSourcePage.dashBoard);

        //kullanici=Admin
        //kullaniciSifre=admin123
        //Login Testinin basarili oldugunu test edelim
        Assert.assertTrue(openSourcePage.dashBoard.isDisplayed());

        //sayfayı kapatalim
        Driver.closeDriver();

    }



}
