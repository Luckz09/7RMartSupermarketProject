package ultilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constants;

public class ExcelUtility {
	
	static FileInputStream f; // Excel file input stream
    static XSSFWorkbook w;    // Workbook
    static XSSFSheet s;       // Sheet

    // Method to get string data from Excel
    public static String getStringData(int a, int b,String sheet) throws IOException {
        f = new FileInputStream(Constants.TESTDATAFILE);
        w = new XSSFWorkbook(f);
        s = w.getSheet(sheet);
        XSSFRow r = s.getRow(a);
        XSSFCell c = r.getCell(b);
        return c.getStringCellValue();
    }

    // Method to get numeric data from Excel (returns as String)
    public static String getIntegerData(int a, int b,String sheet) throws IOException {
        f = new FileInputStream(Constants.TESTDATAFILE);
        w = new XSSFWorkbook(f);
        s = w.getSheet(sheet);
        XSSFRow r = s.getRow(a);
        XSSFCell c = r.getCell(b); //integer- bcz return type string
        int y=(int) c.getNumericCellValue();
        return String.valueOf(y);
    }

}
