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

    public static void extract(Connection c, JTextArea log, ExcelExport ee) throws SQLException, FileNotFoundException, IOException {
        ExtractorOsh1.ee = ee;
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
        extractPart4();
        extractPart6();
        extractPart7();
        extractPart11();
        extractPart12();
        extractPart13();
        extractPart16();
        extractPart17();
        extractPart18();
        extractPart20();
        extractPart21();

        for (int i = 0; i < STCOUNT; i++) {
            s[i].close();
        }
    }

    private static void extractPart1() throws SQLException, IOException {

        if (log != null) {
            log.append("Заполняю раздел 1\n");
        }

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/1/Q21-V21.txt"));
        rs[1].first();

        ee.setValue("osh1", 2, "Q", 22, rs[1].getInt(1));
        ee.setValue("osh1", 2, "R", 22, rs[1].getInt(2));
        ee.setValue("osh1", 2, "S", 22, rs[1].getInt(3));
        ee.setValue("osh1", 2, "T", 21, rs[1].getInt(4));
        ee.setValue("osh1", 2, "U", 21, rs[1].getInt(5));
        ee.setValue("osh1", 2, "V", 21, rs[1].getInt(6));
    }

    private static void extractPart3() throws SQLException, IOException {

        if (log != null) {
            log.append("Заполняю раздел 3\n");
        }

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

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/3/grades_complete_less14.txt"));
        rs[1].first();
        rs[2] = s[2].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/3/grades_complete_less25.txt"));
        rs[2].first();
        rs[3] = s[3].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/3/grades_less_14.txt"));
        rs[3].first();
        rs[4] = s[4].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/3/grades_less_25.txt"));
        rs[4].first();
        ee.setValue("osh1", 4, "P", 25, rs[1].getInt(1) + rs[2].getInt(1) + rs[3].getInt(1) + rs[4].getInt(1));
    }

    private static void extractPart4() throws SQLException, IOException {

        if (log != null) {
            log.append("Заполняю раздел 4\n");
        }

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/4/P21_P22_P24-P34.txt"));
        rs[1].first();

        ee.setValue("osh1", 5, "P", 21, rs[1].getInt(1));
        ee.setValue("osh1", 5, "P", 22, rs[1].getInt(2));
        ee.setValue("osh1", 5, "P", 24, rs[1].getInt(3));
        ee.setValue("osh1", 5, "P", 25, rs[1].getInt(4));
        ee.setValue("osh1", 5, "P", 26, rs[1].getInt(5));
        ee.setValue("osh1", 5, "P", 27, rs[1].getInt(6));
        ee.setValue("osh1", 5, "P", 28, rs[1].getInt(7));
        ee.setValue("osh1", 5, "P", 29, rs[1].getInt(8));
        ee.setValue("osh1", 5, "P", 30, rs[1].getInt(9));
        ee.setValue("osh1", 5, "P", 31, rs[1].getInt(10));
        ee.setValue("osh1", 5, "P", 32, rs[1].getInt(11));
        ee.setValue("osh1", 5, "P", 33, rs[1].getInt(12));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/4/Q22_Q24-Q34.txt"));
        rs[1].first();

        ee.setValue("osh1", 5, "Q", 22, rs[1].getInt(1));
        ee.setValue("osh1", 5, "Q", 24, rs[1].getInt(2));
        ee.setValue("osh1", 5, "Q", 25, rs[1].getInt(3));
        ee.setValue("osh1", 5, "Q", 26, rs[1].getInt(4));
        ee.setValue("osh1", 5, "Q", 27, rs[1].getInt(5));
        ee.setValue("osh1", 5, "Q", 28, rs[1].getInt(6));
        ee.setValue("osh1", 5, "Q", 29, rs[1].getInt(7));
        ee.setValue("osh1", 5, "Q", 30, rs[1].getInt(8));
        ee.setValue("osh1", 5, "Q", 31, rs[1].getInt(9));
        ee.setValue("osh1", 5, "Q", 32, rs[1].getInt(10));
        ee.setValue("osh1", 5, "Q", 33, rs[1].getInt(11));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/4/R22_R24-R34.txt"));
        rs[1].first();

        ee.setValue("osh1", 5, "R", 22, rs[1].getInt(1));
        ee.setValue("osh1", 5, "R", 24, rs[1].getInt(2));
        ee.setValue("osh1", 5, "R", 25, rs[1].getInt(3));
        ee.setValue("osh1", 5, "R", 26, rs[1].getInt(4));
        ee.setValue("osh1", 5, "R", 27, rs[1].getInt(5));
        ee.setValue("osh1", 5, "R", 28, rs[1].getInt(6));
        ee.setValue("osh1", 5, "R", 29, rs[1].getInt(7));
        ee.setValue("osh1", 5, "R", 30, rs[1].getInt(8));
        ee.setValue("osh1", 5, "R", 31, rs[1].getInt(9));
        ee.setValue("osh1", 5, "R", 32, rs[1].getInt(10));
        ee.setValue("osh1", 5, "R", 33, rs[1].getInt(11));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/4/T22_T24-T34.txt"));
        rs[1].first();

        ee.setValue("osh1", 5, "T", 22, rs[1].getInt(1));
        ee.setValue("osh1", 5, "T", 24, rs[1].getInt(2));
        ee.setValue("osh1", 5, "T", 25, rs[1].getInt(3));
        ee.setValue("osh1", 5, "T", 26, rs[1].getInt(4));
        ee.setValue("osh1", 5, "T", 27, rs[1].getInt(5));
        ee.setValue("osh1", 5, "T", 28, rs[1].getInt(6));
        ee.setValue("osh1", 5, "T", 29, rs[1].getInt(7));
        ee.setValue("osh1", 5, "T", 30, rs[1].getInt(8));
        ee.setValue("osh1", 5, "T", 31, rs[1].getInt(9));
        ee.setValue("osh1", 5, "T", 32, rs[1].getInt(10));
        ee.setValue("osh1", 5, "T", 33, rs[1].getInt(11));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/4/P46.txt"));
        rs[1].first();

        ee.setValue("osh1", 5, "P", 46, rs[1].getInt(1));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/4/P47.txt"));
        rs[1].first();

        ee.setValue("osh1", 5, "P", 47, rs[1].getInt(1));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/4/P49.txt"));
        rs[1].first();

        ee.setValue("osh1", 5, "P", 49, rs[1].getInt(1));
    }

    private static void extractPart6() throws SQLException, IOException {

        if (log != null) {
            log.append("Заполняю раздел 6\n");
        }

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/6/P21.txt"));
        rs[1].first();

        ee.setValue("osh1", 7, "P", 21, rs[1].getInt(1));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/6/P31.txt"));
        rs[1].first();

        ee.setValue("osh1", 7, "P", 31, rs[1].getInt(1));
    }

    private static void extractPart7() throws SQLException, IOException {

        if (log != null) {
            log.append("Заполняю раздел 7\n");
        }

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/7/Q21_S21.txt"));
        rs[1].first();

        ee.setValue("osh1", 8, "Q", 21, rs[1].getInt(1));
        ee.setValue("osh1", 8, "S", 21, rs[1].getInt(2));
    }

    private static void extractPart11() throws SQLException, IOException {

        if (log != null) {
            log.append("Заполняю раздел 11\n");
        }

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/11/P21.txt"));
        rs[1].first();

        ee.setValue("osh1", 12, "P", 21, rs[1].getInt(1));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/11/P22.txt"));
        rs[1].first();

        ee.setValue("osh1", 12, "P", 22, rs[1].getInt(1));
    }

    private static void extractPart12() throws SQLException, IOException {

        if (log != null) {
            log.append("Заполняю раздел 12\n");
        }

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/12/P21.txt"));
        rs[1].first();

        ee.setValue("osh1", 12, "P", 21, rs[1].getInt(1));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/12/P22.txt"));
        rs[1].first();

        ee.setValue("osh1", 12, "P", 22, rs[1].getInt(1));
    }

    private static void extractPart13() throws SQLException, IOException {

        if (log != null) {
            log.append("Заполняю раздел 13\n");
        }

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/13/P21-P25_P27-P33_P40-P41.txt"));
        rs[1].first();

        ee.setValue("osh1", 14, "P", 21, rs[1].getInt(1));
        ee.setValue("osh1", 14, "P", 22, rs[1].getInt(2));
        ee.setValue("osh1", 14, "P", 23, rs[1].getInt(3));
        ee.setValue("osh1", 14, "P", 24, rs[1].getInt(4));
        ee.setValue("osh1", 14, "P", 25, rs[1].getInt(5));
        ee.setValue("osh1", 14, "P", 27, rs[1].getInt(6));
        ee.setValue("osh1", 14, "P", 28, rs[1].getInt(7));
        ee.setValue("osh1", 14, "P", 29, rs[1].getInt(8));
        ee.setValue("osh1", 14, "P", 30, rs[1].getInt(9));
        ee.setValue("osh1", 14, "P", 31, rs[1].getInt(10));
        ee.setValue("osh1", 14, "P", 32, rs[1].getInt(11));
        ee.setValue("osh1", 14, "P", 33, rs[1].getInt(12));
        ee.setValue("osh1", 14, "P", 40, rs[1].getInt(13));
        ee.setValue("osh1", 14, "P", 41, rs[1].getInt(14));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/13/P34-P39.txt"));
        rs[1].first();

        ee.setValue("osh1", 14, "P", 34, rs[1].getInt(1));
        ee.setValue("osh1", 14, "P", 35, rs[1].getInt(2));
        ee.setValue("osh1", 14, "P", 36, rs[1].getInt(3));
        ee.setValue("osh1", 14, "P", 37, rs[1].getInt(4));
        ee.setValue("osh1", 14, "P", 38, rs[1].getInt(5));
        ee.setValue("osh1", 14, "P", 39, rs[1].getInt(6));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/13/P42.txt"));
        rs[1].first();

        ee.setValue("osh1", 14, "P", 42, rs[1].getInt(1));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/13/P43.txt"));
        rs[1].first();

        ee.setValue("osh1", 14, "P", 43, rs[1].getInt(1));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/13/P44.txt"));
        rs[1].first();

        ee.setValue("osh1", 14, "P", 44, rs[1].getInt(1));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/13/P45.txt"));
        rs[1].first();

        ee.setValue("osh1", 14, "P", 45, rs[1].getInt(1));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/13/P46-P53.txt"));
        rs[1].first();

        ee.setValue("osh1", 14, "P", 46, rs[1].getInt(1));
        ee.setValue("osh1", 14, "P", 47, rs[1].getInt(2));
        ee.setValue("osh1", 14, "P", 48, rs[1].getInt(3));
        ee.setValue("osh1", 14, "P", 49, rs[1].getInt(4));
        ee.setValue("osh1", 14, "P", 50, rs[1].getInt(5));
        ee.setValue("osh1", 14, "P", 51, rs[1].getInt(6));
        ee.setValue("osh1", 14, "P", 52, rs[1].getInt(7));
        ee.setValue("osh1", 14, "P", 53, rs[1].getInt(8));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/13/P73-P74.txt"));
        rs[1].first();

        ee.setValue("osh1", 14, "P", 73, rs[1].getInt(1));
        ee.setValue("osh1", 14, "P", 74, rs[1].getInt(2));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/13/P78-P84.txt"));
        rs[1].first();

        ee.setValue("osh1", 14, "P", 78, rs[1].getInt(1));
        ee.setValue("osh1", 14, "P", 79, rs[1].getInt(2));
        ee.setValue("osh1", 14, "P", 80, rs[1].getInt(3));
        ee.setValue("osh1", 14, "P", 81, rs[1].getInt(4));
        ee.setValue("osh1", 14, "P", 82, rs[1].getInt(5));
        ee.setValue("osh1", 14, "P", 83, rs[1].getInt(6));
        ee.setValue("osh1", 14, "P", 84, rs[1].getInt(7));
    }

    private static void extractPart16() throws SQLException, IOException {

        if (log != null) {
            log.append("Заполняю раздел 16\n");
        }

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/16/P21-U21.txt"));
        rs[1].first();

        ee.setValue("osh1", 17, "P", 21, rs[1].getInt(1));
        ee.setValue("osh1", 17, "Q", 21, rs[1].getInt(2));
        ee.setValue("osh1", 17, "R", 21, rs[1].getInt(3));
        ee.setValue("osh1", 17, "S", 21, rs[1].getInt(4));
        ee.setValue("osh1", 17, "T", 21, rs[1].getInt(5));
        ee.setValue("osh1", 17, "U", 21, rs[1].getInt(6));
    }

    private static void extractPart17() throws SQLException, IOException {

        if (log != null) {
            log.append("Заполняю раздел 17\n");
        }

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/17/P21-W21_P27-W27_P28-W28_P30-W30.txt"));
        rs[1].first();

        ee.setValue("osh1", 18, "P", 21, rs[1].getInt(1));
        ee.setValue("osh1", 18, "Q", 21, rs[1].getInt(2));
        ee.setValue("osh1", 18, "R", 21, rs[1].getInt(3));
        ee.setValue("osh1", 18, "S", 21, rs[1].getInt(4));
        ee.setValue("osh1", 18, "T", 21, rs[1].getInt(5));
        ee.setValue("osh1", 18, "U", 21, rs[1].getInt(6));
        ee.setValue("osh1", 18, "V", 21, rs[1].getInt(7));
        ee.setValue("osh1", 18, "W", 21, rs[1].getInt(8));
        ee.setValue("osh1", 18, "P", 27, rs[1].getInt(9));
        ee.setValue("osh1", 18, "Q", 27, rs[1].getInt(10));
        ee.setValue("osh1", 18, "R", 27, rs[1].getInt(11));
        ee.setValue("osh1", 18, "S", 27, rs[1].getInt(12));
        ee.setValue("osh1", 18, "T", 27, rs[1].getInt(13));
        ee.setValue("osh1", 18, "U", 27, rs[1].getInt(14));
        ee.setValue("osh1", 18, "V", 27, rs[1].getInt(15));
        ee.setValue("osh1", 18, "W", 27, rs[1].getInt(16));
        ee.setValue("osh1", 18, "P", 28, rs[1].getInt(17));
        ee.setValue("osh1", 18, "Q", 28, rs[1].getInt(18));
        ee.setValue("osh1", 18, "R", 28, rs[1].getInt(19));
        ee.setValue("osh1", 18, "S", 28, rs[1].getInt(20));
        ee.setValue("osh1", 18, "T", 28, rs[1].getInt(21));
        ee.setValue("osh1", 18, "U", 28, rs[1].getInt(22));
        ee.setValue("osh1", 18, "V", 28, rs[1].getInt(23));
        ee.setValue("osh1", 18, "W", 28, rs[1].getInt(24));
        ee.setValue("osh1", 18, "P", 30, rs[1].getInt(25));
        ee.setValue("osh1", 18, "Q", 30, rs[1].getInt(26));
        ee.setValue("osh1", 18, "R", 30, rs[1].getInt(27));
        ee.setValue("osh1", 18, "S", 30, rs[1].getInt(28));
        ee.setValue("osh1", 18, "T", 30, rs[1].getInt(29));
        ee.setValue("osh1", 18, "U", 30, rs[1].getInt(30));
        ee.setValue("osh1", 18, "V", 30, rs[1].getInt(31));
        ee.setValue("osh1", 18, "W", 30, rs[1].getInt(32));
    }

    private static void extractPart18() throws SQLException, IOException {

        if (log != null) {
            log.append("Заполняю раздел 18\n");
        }

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/18/P22_P27-P36_Q22_Q27-Q36.txt"));
        rs[1].first();

        ee.setValue("osh1", 19, "P", 22, rs[1].getInt(1));
        ee.setValue("osh1", 19, "P", 27, rs[1].getInt(2));
        ee.setValue("osh1", 19, "P", 28, rs[1].getInt(3));
        ee.setValue("osh1", 19, "P", 29, rs[1].getInt(4));
        ee.setValue("osh1", 19, "P", 30, rs[1].getInt(5));
        ee.setValue("osh1", 19, "P", 31, rs[1].getInt(6));
        ee.setValue("osh1", 19, "P", 32, rs[1].getInt(7));
        ee.setValue("osh1", 19, "P", 33, rs[1].getInt(8));
        ee.setValue("osh1", 19, "P", 34, rs[1].getInt(9));
        ee.setValue("osh1", 19, "P", 35, rs[1].getInt(10));
        ee.setValue("osh1", 19, "P", 36, rs[1].getInt(11));

        ee.setValue("osh1", 19, "Q", 22, rs[1].getInt(12));
        ee.setValue("osh1", 19, "Q", 27, rs[1].getInt(13));
        ee.setValue("osh1", 19, "Q", 28, rs[1].getInt(14));
        ee.setValue("osh1", 19, "Q", 29, rs[1].getInt(15));
        ee.setValue("osh1", 19, "Q", 30, rs[1].getInt(16));
        ee.setValue("osh1", 19, "Q", 31, rs[1].getInt(17));
        ee.setValue("osh1", 19, "Q", 32, rs[1].getInt(18));
        ee.setValue("osh1", 19, "Q", 33, rs[1].getInt(19));
        ee.setValue("osh1", 19, "Q", 34, rs[1].getInt(20));
        ee.setValue("osh1", 19, "Q", 35, rs[1].getInt(21));
        ee.setValue("osh1", 19, "Q", 36, rs[1].getInt(22));
    }
    
    private static void extractPart20() throws SQLException, IOException {

        if (log != null) {
            log.append("Заполняю раздел 20\n");
        }

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/20/P22_P24-P34.txt"));
        rs[1].first();

        ee.setValue("osh1", 21, "P", 22, rs[1].getInt(1));
        ee.setValue("osh1", 21, "P", 24, rs[1].getInt(2));
        ee.setValue("osh1", 21, "P", 25, rs[1].getInt(3));
        ee.setValue("osh1", 21, "P", 26, rs[1].getInt(4));
        ee.setValue("osh1", 21, "P", 27, rs[1].getInt(5));
        ee.setValue("osh1", 21, "P", 28, rs[1].getInt(6));
        ee.setValue("osh1", 21, "P", 29, rs[1].getInt(7));
        ee.setValue("osh1", 21, "P", 30, rs[1].getInt(8));
        ee.setValue("osh1", 21, "P", 31, rs[1].getInt(9));
        ee.setValue("osh1", 21, "P", 32, rs[1].getInt(10));
        ee.setValue("osh1", 21, "P", 33, rs[1].getInt(11));
        ee.setValue("osh1", 21, "P", 34, rs[1].getInt(12));
    }
    
    private static void extractPart21() throws SQLException, IOException {

        if (log != null) {
            log.append("Заполняю раздел 21\n");
        }

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh1/21/P22_P24-P34_Q22_Q24-Q34.txt"));
        rs[1].first();

        ee.setValue("osh1", 22, "P", 22, rs[1].getInt(1));
        ee.setValue("osh1", 22, "P", 24, rs[1].getInt(2));
        ee.setValue("osh1", 22, "P", 25, rs[1].getInt(3));
        ee.setValue("osh1", 22, "P", 26, rs[1].getInt(4));
        ee.setValue("osh1", 22, "P", 27, rs[1].getInt(5));
        ee.setValue("osh1", 22, "P", 28, rs[1].getInt(6));
        ee.setValue("osh1", 22, "P", 29, rs[1].getInt(7));
        ee.setValue("osh1", 22, "P", 30, rs[1].getInt(8));
        ee.setValue("osh1", 22, "P", 31, rs[1].getInt(9));
        ee.setValue("osh1", 22, "P", 32, rs[1].getInt(10));
        ee.setValue("osh1", 22, "P", 33, rs[1].getInt(11));
        ee.setValue("osh1", 22, "P", 34, rs[1].getInt(12));
        
        ee.setValue("osh1", 22, "Q", 22, rs[1].getInt(13));
        ee.setValue("osh1", 22, "Q", 24, rs[1].getInt(14));
        ee.setValue("osh1", 22, "Q", 25, rs[1].getInt(15));
        ee.setValue("osh1", 22, "Q", 26, rs[1].getInt(16));
        ee.setValue("osh1", 22, "Q", 27, rs[1].getInt(17));
        ee.setValue("osh1", 22, "Q", 28, rs[1].getInt(18));
        ee.setValue("osh1", 22, "Q", 29, rs[1].getInt(19));
        ee.setValue("osh1", 22, "Q", 30, rs[1].getInt(10));
        ee.setValue("osh1", 22, "Q", 31, rs[1].getInt(21));
        ee.setValue("osh1", 22, "Q", 32, rs[1].getInt(22));
        ee.setValue("osh1", 22, "Q", 33, rs[1].getInt(23));
        ee.setValue("osh1", 22, "Q", 34, rs[1].getInt(24));
    }

}