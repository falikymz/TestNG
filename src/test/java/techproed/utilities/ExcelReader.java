package techproed.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    Workbook workbook;
    Sheet sheet;


    //Bu classtan object oluşturulmasının amaci excel dosyası okumaktır
    public ExcelReader(String folderPath,String pageName){

        try {
            FileInputStream fis= new FileInputStream(folderPath);
            workbook=WorkbookFactory.create(fis);
            sheet=workbook.getSheet(pageName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //satir ve sutun indexleri verdigimizde ilgili hücredeki datayı string olarak return eder
    public String getCellData (int row, int column){
        Cell cell = sheet.getRow(row).getCell(column);
        return cell.toString();
    }

    public int rowCount(){
        return sheet.getLastRowNum();
    }

}
