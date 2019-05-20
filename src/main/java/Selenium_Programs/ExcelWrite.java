package Selenium_Programs;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;


public class ExcelWrite {

    public static void main (String [] args) throws IOException {
        String path = System.getProperty("user.dir");
        String file_path = path + "\\Files\\ExcelWriteRead.xlsx";
        System.out.println(file_path);
        int ind = file_path.lastIndexOf(".");
        String file_ext = file_path.substring(ind+1);
        String sheetname = "Sheet1";
        System.out.println(file_ext);
        //Create an object of File class to open xlsx file
        File file = new File (file_path);
        //Create an object of FileOutputStream class to read excel file
        FileInputStream fin = new FileInputStream(file);
        Workbook wb = null;
        if (file_ext.contains("xlsx"))
        {
            //If it is xlsx file then create object of XSSFWorkbook class
            wb = new XSSFWorkbook(fin);

        }
        else if (file_ext.contains("xlx"))
        {
            //If it is xls file then create object of HSSFWorkbook class
            wb = new HSSFWorkbook(fin);
        }
        //Read excel sheet by sheet name
        Sheet sheet=wb.getSheet(sheetname);
        //Get the current count of rows in excel file
        int rowcount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        System.out.println("Total rows are " +rowcount);
        for (int i = 0;i<10;i++) {
            //Get the first row from the sheet
            Row row = sheet.getRow(1);
            //Create a new row and append it at last of sheet
            Row newrow = sheet.createRow(rowcount + i);
            //int totalcell = row.getLastCellNum();
            //Create a loop over the cell of newly created Row

            for (int j = 0; j < 10; j++) {
                //Fill Data in Row
                Cell cell = newrow.createCell(j);
                cell.setCellValue("This is Row No " + (i+1)+ " and col no "+ (j+1));
            }
        }
        //Close input stream
        fin.close();
        //Create an object of FileOutputStream class to create write data in excel file
        FileOutputStream fio = new FileOutputStream(file_path);
        //write data in the excel file
        wb.write(fio);
        //close output stream
        fio.close();
    }
}
