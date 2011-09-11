/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author accepted
 */
public class Extractor83rikp {

    private static ResultSet[] rs;
    private static Statement[] s;
    private static ExcelExport ee;
    private static int STCOUNT = 5;
    private static JTextArea log;

    public static void extract(Connection c, JTextArea log) throws SQLException, FileNotFoundException, IOException {
        ee = new ExcelExport();
        Extractor83rikp.log = log;
        if (log != null) {
            log.append("Заполняю форму ОШ 5.\n");
        }
        rs = new ResultSet[STCOUNT];
        s = new Statement[STCOUNT];
        for (int i = 0; i < STCOUNT; i++) {
            s[i] = c.createStatement();
        }

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

        if (log != null) {
            log.append("Заполняю раздел 1\n");
        }

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/9/AA21-AA54_AA57-AA58.txt"));
        rs[1].first();

        ee.setValue("osh5", 10, "AA", 21, rs[1].getInt(1));
        ee.setValue("osh5", 10, "AA", 22, rs[1].getInt(2));
        ee.setValue("osh5", 10, "AA", 23, rs[1].getInt(3));
        ee.setValue("osh5", 10, "AA", 24, rs[1].getInt(4));
        ee.setValue("osh5", 10, "AA", 25, rs[1].getInt(5));
        ee.setValue("osh5", 10, "AA", 26, rs[1].getInt(6));
        ee.setValue("osh5", 10, "AA", 27, rs[1].getInt(7));
        ee.setValue("osh5", 10, "AA", 28, rs[1].getInt(8));
        ee.setValue("osh5", 10, "AA", 29, rs[1].getInt(9));
        ee.setValue("osh5", 10, "AA", 30, rs[1].getInt(10));
        ee.setValue("osh5", 10, "AA", 31, rs[1].getInt(11));
        ee.setValue("osh5", 10, "AA", 32, rs[1].getInt(12));
        ee.setValue("osh5", 10, "AA", 33, rs[1].getInt(13));
        ee.setValue("osh5", 10, "AA", 34, rs[1].getInt(14));
        ee.setValue("osh5", 10, "AA", 35, rs[1].getInt(15));
        ee.setValue("osh5", 10, "AA", 36, rs[1].getInt(16));
        ee.setValue("osh5", 10, "AA", 37, rs[1].getInt(17));
        ee.setValue("osh5", 10, "AA", 38, rs[1].getInt(18));
        ee.setValue("osh5", 10, "AA", 39, rs[1].getInt(19));
        ee.setValue("osh5", 10, "AA", 40, rs[1].getInt(20));
        ee.setValue("osh5", 10, "AA", 41, rs[1].getInt(21));
        ee.setValue("osh5", 10, "AA", 42, rs[1].getInt(22));
        ee.setValue("osh5", 10, "AA", 43, rs[1].getInt(23));
        ee.setValue("osh5", 10, "AA", 44, rs[1].getInt(24));
        ee.setValue("osh5", 10, "AA", 45, rs[1].getInt(25));
        ee.setValue("osh5", 10, "AA", 46, rs[1].getInt(26));
        ee.setValue("osh5", 10, "AA", 47, rs[1].getInt(27));
        ee.setValue("osh5", 10, "AA", 48, rs[1].getInt(28));
        ee.setValue("osh5", 10, "AA", 49, rs[1].getInt(29));
        ee.setValue("osh5", 10, "AA", 50, rs[1].getInt(30));
        ee.setValue("osh5", 10, "AA", 51, rs[1].getInt(31));
        ee.setValue("osh5", 10, "AA", 52, rs[1].getInt(32));
        ee.setValue("osh5", 10, "AA", 53, rs[1].getInt(33));
        ee.setValue("osh5", 10, "AA", 54, rs[1].getInt(34));
        ee.setValue("osh5", 10, "AA", 57, rs[1].getInt(35));
        ee.setValue("osh5", 10, "AA", 58, rs[1].getInt(36));
    }
}
