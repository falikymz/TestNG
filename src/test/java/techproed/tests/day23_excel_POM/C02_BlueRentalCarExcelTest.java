package techproed.tests.day23_excel_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;

public class C02_BlueRentalCarExcelTest {

    @Test
    public void test01() {

        //BlueRentalCar sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        //Login buttonuna tıklayalım
        BlueRentalPage blueRentalPage=new BlueRentalPage();
        blueRentalPage.loginButton.click();

        //Excel dosyasındaki herhangi bir email ve password ile login olalım
        String folderPath="src\\test\\java\\techproed\\resources\\mysmoketestdata.xlsx";
        String pageName="customer_info";
        ExcelReader excelReader =new ExcelReader(folderPath,pageName);

        String  emailExcel = excelReader.getCellData(2,0);
        String  pwdExcel = excelReader.getCellData(2,1);

        blueRentalPage.emailBox.sendKeys(emailExcel);
        blueRentalPage.passwordBox.sendKeys(pwdExcel, Keys.ENTER);

        //Girilen email ile giriş yapıldığını doğrulayın
        blueRentalPage.loginverify.click();
        blueRentalPage.profileButton.click();

        String actualEmail = blueRentalPage.profileEmail.getText();

        Assert.assertEquals(actualEmail,emailExcel,"Emaillerde uyumsuzluk var");

        //sayfayı kapatalım
        Driver.closeDriver();

    }
}
