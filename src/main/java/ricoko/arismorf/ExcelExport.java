/*
 * Экспорт в эксель. 
 */
package ricoko.arismorf;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.JTextArea;
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
        if (loadedXLT.get(xltFileName) == null) {
            InputStream inp;
            try {
                inp = new FileInputStream("./resources/xlt/" + xltFileName + ".xlt");
            } catch (FileNotFoundException e) {
                inp = new FileInputStream("./resources/xlt/" + xltFileName + ".XLT");
            }
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
    public void saveExportedWorkBooks(JTextArea log) throws FileNotFoundException, IOException {
        for (Entry<String, Workbook> e : loadedXLT.entrySet()) {
            if (log != null) {
                log.append("Экпортирую файл шаблона МОРФ: " + e.getKey() + "\n");
            }
            FileOutputStream fileOut = new FileOutputStream("./export/" + e.getKey() + ".xlt");
            e.getValue().write(fileOut);
            fileOut.close();
        }
    }

    public Cell getCell(String xltFileName, int sheet, int col, int row) throws FileNotFoundException, IOException {
        Workbook wb = getWorkBook(xltFileName);
        Sheet s = wb.getSheetAt(sheet - 1);
        Row r = s.getRow(row - 1);
        Cell cell = r.getCell(col);
        return cell;
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

    private static int convertColumnmIndex(String col) {
        if (col.length()==1) {
            return alphabet.indexOf(col.substring(0, 1));
        } else {
            return (alphabet.indexOf(col.substring(0, 1))+1) * 26 + alphabet.indexOf(col.substring(1, 2));
        }
    }

    public static String getSQLFromFile(String path) throws IOException {
        StringBuilder contents = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String text = null;
        while ((text = reader.readLine()) != null) {
            contents.append(text).append(System.getProperty("line.separator"));
        }
        reader.close();
        return contents.toString();
    }
}
