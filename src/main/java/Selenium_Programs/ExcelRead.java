package Selenium_Programs;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {

    public static void main (String [] args) throws IOException {

        String file_path = System.getProperty("user.dir")+"\\Files\\ExcelWriteRead.xlsx";
        File file = new File (file_path);
        FileInputStream fis = new FileInputStream(file);
        Workbook wb = null;
        Sheet sheet = null;
        String sheet_name = "Sheet1";
        int ind = file_path.lastIndexOf(".");
        String ext = file_path.substring(ind+1);
        if (ext.contains("xlsx"))
        {
            wb = new XSSFWorkbook(fis);
        }
        else if (ext.contains("xls"))
        {
            wb = new HSSFWorkbook(fis);
        }

        sheet = wb.getSheet(sheet_name);
        Row row = sheet.getRow(0);
        //Cell cell = row.getCell(0);

        int total_rows = sheet.getLastRowNum()+1;
        System.out.println("Total No of Rows in sheet are "+total_rows);
        int cell_count = row.getLastCellNum()-row.getFirstCellNum();
        System.out.println("Total No of col in each rows are "+cell_count);

        for (int i = 0;i<total_rows;i++)
        {
            row = sheet.getRow(i);
            for (int j = 0;j<cell_count;j++ )
            {
                Cell cell = row.getCell(j);
                String cell_data = cell.getStringCellValue();
                System.out.println(" The Value of Row "+(i+1)+" and cell "+(j+1)+" = " +cell_data);
            }

        }

        fis.close();




    }
}
