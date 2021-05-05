package data;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    static FileInputStream fis = null;

    public FileInputStream getFileInputStream() {

        String filePath = System.getProperty("user.dir") + "/src/test/java/data/UserData.xlsx";
        File file = new File(filePath);

        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("Test Data file not found. terminating Process !! : Check file path of TestData");
            System.exit(0);
        }

        return fis;
    }

    public Object[][] getExcelData() throws IOException {

        fis = getFileInputStream();
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sh = wb.getSheetAt(0);

        int totalNoOfRows = (sh.getLastRowNum() + 1);
        int totalNoOfColumn = 2;

        String[][] excelArray = new String[totalNoOfRows][totalNoOfColumn];

        for (int i = 0; i < totalNoOfRows; i++) {
            for (int j = 0; j < totalNoOfColumn; j++) {
                XSSFRow row = sh.getRow(i); // get all the row
                excelArray[i][j] = row.getCell(j).toString();
            }
        }
        wb.close(); //close it because it has steam data from fis
        return excelArray;
    }
}
