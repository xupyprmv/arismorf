/*
 * Экспорт в эксель. 
 */
package ricoko.arismorf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author XupyprMV
 */
public class ExcelExport {
    
    public Map<String, Workbook> loadedXLT = new HashMap<String, Workbook>();
    
    /**
     * Получить рабочую книгу по имени
     * 
     * @param xltFileName - имя рабочей книги
     * @return рабочая книга
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public Workbook getWorkBook(String xltFileName) throws FileNotFoundException, IOException {
        if (loadedXLT.get(xltFileName)==null) {
             InputStream inp = new FileInputStream("./resources/xlt/"+xltFileName+".xlt");
             Workbook wb = new HSSFWorkbook(inp);
             loadedXLT.put(xltFileName, wb);
        }
        return loadedXLT.get(xltFileName);
    }
    
    /**
     * Экспортировать все обработанные xlt файлы
     * 
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void saveExportedWorkBooks() throws FileNotFoundException, IOException {
        for (Entry<String,Workbook> e:loadedXLT.entrySet()) {
            FileOutputStream fileOut = new FileOutputStream("./export/"+e.getKey()+".xlt");
            e.getValue().write(fileOut);
            fileOut.close();
        }
    }
    
    public Cell getCell(String xltFileName, int sheet, int col, int row) throws FileNotFoundException, IOException {
        Workbook wb = getWorkBook(xltFileName);
        Sheet s = wb.getSheetAt(sheet);
        Row r = s.getRow(row-1);
        Cell cell = r.getCell(col);
        return cell;
        //cell.setCellValue(value); 
    }
    
    public void setValue(String xltFileName, int sheet, String col, int row, String value) throws FileNotFoundException, IOException {
        Cell cell = getCell(xltFileName, sheet, convertColumnmIndex(col), row);
        cell.setCellValue(value);
    }
    
    public void setValue(String xltFileName, int sheet, String col, int row, boolean value) throws FileNotFoundException, IOException {
        Cell cell = getCell(xltFileName, sheet, convertColumnmIndex(col), row);
        cell.setCellValue(value);
    }
    
    public void setValue(String xltFileName, int sheet, String col, int row, double value) throws FileNotFoundException, IOException {
        Cell cell = getCell(xltFileName, sheet, convertColumnmIndex(col), row);
        cell.setCellValue(value);
    }
    
    public void setValue(String xltFileName, int sheet, String col, int row, Date value) throws FileNotFoundException, IOException {
        Cell cell = getCell(xltFileName, sheet, convertColumnmIndex(col), row);
        cell.setCellValue(value);
    }

    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private int convertColumnmIndex(String col) {
        int result=0;
        for (int i=0; i<col.length(); i++) {
           result=result*26+alphabet.indexOf(col.substring(i, i+1));
        }
        return result;
    }
}
