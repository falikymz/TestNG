package techproed.tests.day23_excel_POM;

import org.testng.annotations.Test;
import techproed.utilities.ExcelReader;

public class C01_ExcelTest {

    @Test
    public void test01() {
     String folderPath="C:\\Users\\alika\\IdeaProjects\\Batch189TestNGDT\\src\\test\\java\\techproed\\resources\\mysmoketestdata.xlsx";
     String pageName="customer_info";
     ExcelReader excelReader =new ExcelReader(folderPath,pageName);
        System.out.println("excelReader.getCellData(0,0) = " + excelReader.getCellData(0, 0));
        System.out.println("excelReader.getCellData(0,1) = " + excelReader.getCellData(0, 1));
      String email= excelReader.getCellData(1,0);
      String password =excelReader.getCellData(1,1);
        System.out.println(email+" = "+password);
    }
}
