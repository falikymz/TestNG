package techproed.tests.day24_dataprovider_xmlfiles;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.DataProviderPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.DataProviderUtils;
import techproed.utilities.Driver;

public class C04_DataProviderUtils {


    @Test(dataProvider ="positiveTestData",dataProviderClass = DataProviderUtils.class )
    public void test01(int age) {

        //https://dataprovider.netlify.app/ adresine gidelim
        Driver.getDriver().get(ConfigReader.getProperty("dataProviderUrl"));

        //BlackBoxTesting techniques ile otomasyon test yapalim
        DataProviderPage dataProviderPage =new DataProviderPage();
        dataProviderPage.ageBox.sendKeys(String.valueOf(age),Keys.TAB,Keys.ENTER);

        Assert.assertTrue(dataProviderPage.positiveVerifyMessage.isDisplayed());

        //Driveri kapatalim
        Driver.closeDriver();
    }

    @Test(dataProvider ="negativeTestData",dataProviderClass = DataProviderUtils.class )
    public void test02(int age) {

        //https://dataprovider.netlify.app/ adresine gidelim
        Driver.getDriver().get(ConfigReader.getProperty("dataProviderUrl"));

        //BlackBoxTesting techniques ile otomasyon test yapalim
        DataProviderPage dataProviderPage =new DataProviderPage();
        dataProviderPage.ageBox.sendKeys(String.valueOf(age),Keys.TAB,Keys.ENTER);

        Assert.assertTrue(dataProviderPage.negativeVerifyMessage.isDisplayed());

        //Driveri kapatalim
        Driver.closeDriver();
    }

}
