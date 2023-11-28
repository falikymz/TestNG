package techproed.tests.day22_POM;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.pages.TestCenterPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C02_ClassWork {

    @Test
    public void test01() {

        //https://testcenter.techproeducation.com/index.php?page=form-authentication
        Driver.getDriver().get(ConfigReader.getProperty("testCenterUrl"));

        //Page object Model kullanarak sayfaya giriş yapildigini test edin
        TestCenterPage testCenterPage = new TestCenterPage();
        testCenterPage.usernameBox.sendKeys(ConfigReader.getProperty("techpro_test_username"));
        testCenterPage.passwordBox.sendKeys(ConfigReader.getProperty("techpro_test_password"));
        testCenterPage.submitButton.click();

        ReusableMethods.visibleWait(testCenterPage.logoutButton,15);
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(testCenterPage.logoutButton.isDisplayed());



        //Sayfadan cikis yap ve cikis yapildigini test et
        testCenterPage.logoutButton.click();
        softAssert.assertEquals(Driver.getDriver().getTitle(),"Login");
        softAssert.assertAll();

        //sayfayı kapatınız
        Driver.closeDriver();

    }
}