package ricoko.arismorf.extractors;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextArea;
import ricoko.arismorf.ExcelExport;

/**
 * Экстрактор - достаёт заранее импортированные из АРИСМО данные
 * и вставляет их в формы МОРФ
 * 
 * @author maksimenkov (xupypr@xupypr.com) 
 */
public class ExtractorOsh1 {

    private static ResultSet[] rs;
    private static Statement[] s;
    private static ExcelExport ee;
    private static int STCOUNT = 5;
    private static JTextArea log;

    public static void extract(Connection c, JTextArea log) throws SQLException, FileNotFoundException, IOException {
        ee = new ExcelExport();
        ExtractorOsh1.log = log;
        if (log != null) {
            log.append("Заполняю форму ОШ 1.\n");
        }
        rs = new ResultSet[STCOUNT];
        s = new Statement[STCOUNT];
        for (int i = 0; i < STCOUNT; i++) {
            s[i] = c.createStatement();
        }

        extractPart1();
        extractPart3();

        ee.saveExportedWorkBooks(log);

        if (log != null) {
            log.append("Экпорт завершен. Результаты экспорта располагаются в папке export.\n");
        }
        for (int i = 0; i < STCOUNT; i++) {
            s[i].close();
        }
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(new File("export"));
        }
    }
    
    private static void extractPart1() throws SQLException, IOException {
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/1/Q21-V21.txt"));
        rs[1].first();

        ee.setValue("osh1", 2, "Q", 22, rs[1].getInt(1));
        ee.setValue("osh1", 2, "R", 22, rs[1].getInt(2));
        ee.setValue("osh1", 2, "S", 22, rs[1].getInt(3));
        ee.setValue("osh1", 2, "T", 21, rs[1].getInt(4));
        ee.setValue("osh1", 2, "U", 21, rs[1].getInt(5));
        ee.setValue("osh1", 2, "V", 21, rs[1].getInt(6));

        if (log != null) {
            log.append("Выполнено 6/6.\n");
        }
    }

    private static void extractPart3() throws SQLException, IOException {
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/3/grades.txt"));
        rs[1].first();
        rs[2] = s[2].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/3/grades_complete_1-4.txt"));
        rs[2].first();
        rs[3] = s[3].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/3/grades_complete_5-9.txt"));
        rs[3].first();
        rs[4] = s[4].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/3/podgot_class.txt"));
        rs[4].first();

        ee.setValue("osh1", 4, "P", 21, rs[1].getInt(1) + rs[2].getInt(1) + rs[4].getInt(1));
        ee.setValue("osh1", 4, "P", 22, rs[1].getInt(2) + rs[3].getInt(1));
        ee.setValue("osh1", 4, "P", 23, rs[1].getInt(3));
        ee.setValue("osh1", 4, "Q", 21, rs[1].getInt(4));
        ee.setValue("osh1", 4, "Q", 22, rs[1].getInt(5));
        ee.setValue("osh1", 4, "Q", 23, rs[1].getInt(6));
        ee.setValue("osh1", 4, "P", 24, rs[1].getInt(1) + rs[2].getInt(1) + rs[4].getInt(1) + rs[1].getInt(2) + rs[3].getInt(1) + rs[1].getInt(3)); // сумма первогостолбца
        ee.setValue("osh1", 4, "Q", 24, rs[1].getInt(4) + rs[1].getInt(5) + rs[1].getInt(6));

        if (log != null) {
            log.append("Выполнено 7/9.\n");
        }

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/3/grades_complete_less14.txt"));
        rs[1].first();
        rs[2] = s[2].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/3/grades_complete_less25.txt"));
        rs[2].first();
        rs[3] = s[3].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/3/grades_less_14.txt"));
        rs[3].first();
        rs[4] = s[4].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/3/grades_less_25.txt"));
        rs[4].first();
        ee.setValue("osh1", 4, "P", 25, rs[1].getInt(1) + rs[2].getInt(1) + rs[3].getInt(1) + rs[4].getInt(1));

        if (log != null) {
            log.append("Выполнено 9/9.\n");
        }
    }
}
