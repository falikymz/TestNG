package techproed.tests.day23_excel_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;

public class C03_BlueRentalCarExcelTest {
    BlueRentalPage blueRentalPage;
    ExcelReader excelReader;
    @Test
    public void test01() {

        //BlueRentalCar sayfasina gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        //Excel sayfasındaki tüm email ve passwordler ile login olalım ve login olduğumuzu doğrulayalım
        blueRentalPage = new BlueRentalPage();
        String folderPath="src/test/java/techproed/resources/mysmoketestdata.xlsx";
        String pageName ="customer_info";
        excelReader= new ExcelReader(folderPath,pageName);

        for (int i = 1; i <= 7 ; i++) {
         String email = excelReader.getCellData(i,0);
         String password = excelReader.getCellData(i,1);

            blueRentalPage.loginButton.click();
            blueRentalPage.emailBox.sendKeys(email);
            blueRentalPage.passwordBox.sendKeys(password, Keys.ENTER);
            blueRentalPage.loginverify.click();
            Assert.assertTrue(blueRentalPage.profileButton.isDisplayed());
            blueRentalPage.logoutButton.click();
            blueRentalPage.okButton.click();
            break;
        }

        //sayfayi kapatalim
        Driver.closeDriver();

    }
}
