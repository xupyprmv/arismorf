/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ricoko.arismorf.extractors;

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
public class ExtractorOsh5 {

    private static ResultSet[] rs;
    private static Statement[] s;
    private static ExcelExport ee;
    private static int STCOUNT = 5;
    private static JTextArea log;

    public static void extract(Connection c, JTextArea log, ExcelExport ee) throws SQLException, FileNotFoundException, IOException {
        ExtractorOsh5.ee = ee;
        ExtractorOsh5.log = log;
        if (log != null) {
            log.append("Заполняю форму ОШ 5.\n");
        }
        rs = new ResultSet[STCOUNT];
        s = new Statement[STCOUNT];
        for (int i = 0; i < STCOUNT; i++) {
            s[i] = c.createStatement();
        }

        extractPart1();
        extractPart2();
        extractPart3();
        extractPart4();
        extractPart7();
        extractPart9();
        extractPart10();

        for (int i = 0; i < STCOUNT; i++) {
            s[i].close();
        }
    }

    private static void extractPart1() throws SQLException, IOException {

        if (log != null) {
            log.append("Заполняю раздел 1\n");
        }

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/1/L3.txt"));
        rs[1].first();

        ee.setValue("osh5", 2, "L", 3, rs[1].getString(1));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/1/L6.txt"));
        rs[1].first();

        ee.setValue("osh5", 2, "L", 6, rs[1].getString(1));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/1/P21.txt"));
        rs[1].first();

        ee.setValue("osh5", 2, "P", 21, rs[1].getInt(1));
    }

    private static void extractPart2() throws SQLException, IOException {

        if (log != null) {
            log.append("Заполняю раздел 2\n");
        }

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/2/P21-P22.txt"));
        rs[1].first();

        ee.setValue("osh5", 3, "P", 21, rs[1].getInt(1));
        ee.setValue("osh5", 3, "P", 22, rs[1].getInt(2));
    }

    private static void extractPart3() throws SQLException, IOException {

        if (log != null) {
            log.append("Заполняю раздел 3\n");
        }

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/3/P21-P25.txt"));
        rs[1].first();

        ee.setValue("osh5", 4, "P", 21, rs[1].getInt(1));
        ee.setValue("osh5", 4, "P", 22, rs[1].getInt(2));
        ee.setValue("osh5", 4, "P", 23, rs[1].getInt(3));
        ee.setValue("osh5", 4, "P", 24, rs[1].getInt(4));
        ee.setValue("osh5", 4, "P", 25, rs[1].getInt(5));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/3/Q21-Q25.txt"));
        rs[1].first();

        ee.setValue("osh5", 4, "Q", 21, rs[1].getInt(1));
        ee.setValue("osh5", 4, "Q", 22, rs[1].getInt(2));
        ee.setValue("osh5", 4, "Q", 23, rs[1].getInt(3));
        ee.setValue("osh5", 4, "Q", 24, rs[1].getInt(4));
        ee.setValue("osh5", 4, "Q", 25, rs[1].getInt(5));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/3/R21-R25.txt"));
        rs[1].first();

        ee.setValue("osh5", 4, "R", 21, rs[1].getInt(1));
        ee.setValue("osh5", 4, "R", 22, rs[1].getInt(2));
        ee.setValue("osh5", 4, "R", 23, rs[1].getInt(3));
        ee.setValue("osh5", 4, "R", 24, rs[1].getInt(4));
        ee.setValue("osh5", 4, "R", 25, rs[1].getInt(5));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/3/S21-S25.txt"));
        rs[1].first();

        ee.setValue("osh5", 4, "S", 21, rs[1].getInt(1));
        ee.setValue("osh5", 4, "S", 22, rs[1].getInt(2));
        ee.setValue("osh5", 4, "S", 23, rs[1].getInt(3));
        ee.setValue("osh5", 4, "S", 24, rs[1].getInt(4));
        ee.setValue("osh5", 4, "S", 25, rs[1].getInt(5));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/3/U21-U25.txt"));
        rs[1].first();

        ee.setValue("osh5", 4, "U", 21, rs[1].getInt(1));
        ee.setValue("osh5", 4, "U", 22, rs[1].getInt(2));
        ee.setValue("osh5", 4, "U", 23, rs[1].getInt(3));
        ee.setValue("osh5", 4, "U", 24, rs[1].getInt(4));
        ee.setValue("osh5", 4, "U", 25, rs[1].getInt(5));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/3/V21-V25.txt"));
        rs[1].first();

        ee.setValue("osh5", 4, "V", 21, rs[1].getInt(1));
        ee.setValue("osh5", 4, "V", 22, rs[1].getInt(2));
        ee.setValue("osh5", 4, "V", 23, rs[1].getInt(3));
        ee.setValue("osh5", 4, "V", 24, rs[1].getInt(4));
        ee.setValue("osh5", 4, "V", 25, rs[1].getInt(5));
    }

    private static void extractPart4() throws SQLException, IOException {

        if (log != null) {
            log.append("Заполняю раздел 4\n");
        }

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/4/P22.txt"));
        rs[1].first();

        ee.setValue("osh5", 5, "P", 22, rs[1].getInt(1));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/4/P24.txt"));
        rs[1].first();

        ee.setValue("osh5", 5, "P", 24, rs[1].getInt(1));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/4/P26.txt"));
        rs[1].first();

        ee.setValue("osh5", 5, "P", 26, rs[1].getInt(1));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/4/P33.txt"));
        rs[1].first();

        ee.setValue("osh5", 5, "P", 33, rs[1].getInt(1));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/4/P34.txt"));
        rs[1].first();

        ee.setValue("osh5", 5, "P", 34, rs[1].getInt(1));
    }

    private static void extractPart7() throws SQLException, IOException {

        if (log != null) {
            log.append("Заполняю раздел 7\n");
        }

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/7/P21-P25_P27-P33_P40-P41.txt"));
        rs[1].first();

        ee.setValue("osh5", 8, "P", 21, rs[1].getInt(1));
        ee.setValue("osh5", 8, "P", 22, rs[1].getInt(2));
        ee.setValue("osh5", 8, "P", 23, rs[1].getInt(3));
        ee.setValue("osh5", 8, "P", 24, rs[1].getInt(4));
        ee.setValue("osh5", 8, "P", 25, rs[1].getInt(5));
        ee.setValue("osh5", 8, "P", 27, rs[1].getInt(6));
        ee.setValue("osh5", 8, "P", 28, rs[1].getInt(7));
        ee.setValue("osh5", 8, "P", 29, rs[1].getInt(8));
        ee.setValue("osh5", 8, "P", 30, rs[1].getInt(9));
        ee.setValue("osh5", 8, "P", 31, rs[1].getInt(10));
        ee.setValue("osh5", 8, "P", 32, rs[1].getInt(11));
        ee.setValue("osh5", 8, "P", 33, rs[1].getInt(12));
        ee.setValue("osh5", 8, "P", 40, rs[1].getInt(13));
        ee.setValue("osh5", 8, "P", 41, rs[1].getInt(14));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/7/P34-P39.txt"));
        rs[1].first();

        ee.setValue("osh5", 8, "P", 34, rs[1].getInt(1));
        ee.setValue("osh5", 8, "P", 35, rs[1].getInt(2));
        ee.setValue("osh5", 8, "P", 36, rs[1].getInt(3));
        ee.setValue("osh5", 8, "P", 37, rs[1].getInt(4));
        ee.setValue("osh5", 8, "P", 38, rs[1].getInt(5));
        ee.setValue("osh5", 8, "P", 39, rs[1].getInt(6));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/7/P42.txt"));
        rs[1].first();

        ee.setValue("osh5", 8, "P", 42, rs[1].getInt(1));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/7/P43.txt"));
        rs[1].first();

        ee.setValue("osh5", 8, "P", 43, rs[1].getInt(1));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/7/P44.txt"));
        rs[1].first();

        ee.setValue("osh5", 8, "P", 44, rs[1].getInt(1));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/7/P45.txt"));
        rs[1].first();

        ee.setValue("osh5", 8, "P", 45, rs[1].getInt(1));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/7/P46-P53.txt"));
        rs[1].first();

        ee.setValue("osh5", 8, "P", 46, rs[1].getInt(1));
        ee.setValue("osh5", 8, "P", 47, rs[1].getInt(2));
        ee.setValue("osh5", 8, "P", 48, rs[1].getInt(3));
        ee.setValue("osh5", 8, "P", 49, rs[1].getInt(4));
        ee.setValue("osh5", 8, "P", 50, rs[1].getInt(5));
        ee.setValue("osh5", 8, "P", 51, rs[1].getInt(6));
        ee.setValue("osh5", 8, "P", 52, rs[1].getInt(7));
        ee.setValue("osh5", 8, "P", 53, rs[1].getInt(8));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/7/P73-P74.txt"));
        rs[1].first();

        ee.setValue("osh5", 8, "P", 73, rs[1].getInt(1));
        ee.setValue("osh5", 8, "P", 74, rs[1].getInt(2));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/7/P78-P84.txt"));
        rs[1].first();

        ee.setValue("osh5", 8, "P", 78, rs[1].getInt(1));
        ee.setValue("osh5", 8, "P", 79, rs[1].getInt(2));
        ee.setValue("osh5", 8, "P", 80, rs[1].getInt(3));
        ee.setValue("osh5", 8, "P", 81, rs[1].getInt(4));
        ee.setValue("osh5", 8, "P", 82, rs[1].getInt(5));
        ee.setValue("osh5", 8, "P", 83, rs[1].getInt(6));
        ee.setValue("osh5", 8, "P", 84, rs[1].getInt(7));
    }

    private static void extractPart9() throws SQLException, IOException {

        if (log != null) {
            log.append("Заполняю раздел 9\n");
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

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/9/AB21-AB54_AB57-AB58.txt"));
        rs[1].first();

        ee.setValue("osh5", 10, "AB", 21, rs[1].getInt(1));
        ee.setValue("osh5", 10, "AB", 22, rs[1].getInt(2));
        ee.setValue("osh5", 10, "AB", 23, rs[1].getInt(3));
        ee.setValue("osh5", 10, "AB", 24, rs[1].getInt(4));
        ee.setValue("osh5", 10, "AB", 25, rs[1].getInt(5));
        ee.setValue("osh5", 10, "AB", 26, rs[1].getInt(6));
        ee.setValue("osh5", 10, "AB", 27, rs[1].getInt(7));
        ee.setValue("osh5", 10, "AB", 28, rs[1].getInt(8));
        ee.setValue("osh5", 10, "AB", 29, rs[1].getInt(9));
        ee.setValue("osh5", 10, "AB", 30, rs[1].getInt(10));
        ee.setValue("osh5", 10, "AB", 31, rs[1].getInt(11));
        ee.setValue("osh5", 10, "AB", 32, rs[1].getInt(12));
        ee.setValue("osh5", 10, "AB", 33, rs[1].getInt(13));
        ee.setValue("osh5", 10, "AB", 34, rs[1].getInt(14));
        ee.setValue("osh5", 10, "AB", 35, rs[1].getInt(15));
        ee.setValue("osh5", 10, "AB", 36, rs[1].getInt(16));
        ee.setValue("osh5", 10, "AB", 37, rs[1].getInt(17));
        ee.setValue("osh5", 10, "AB", 38, rs[1].getInt(18));
        ee.setValue("osh5", 10, "AB", 39, rs[1].getInt(19));
        ee.setValue("osh5", 10, "AB", 40, rs[1].getInt(20));
        ee.setValue("osh5", 10, "AB", 41, rs[1].getInt(21));
        ee.setValue("osh5", 10, "AB", 42, rs[1].getInt(22));
        ee.setValue("osh5", 10, "AB", 43, rs[1].getInt(23));
        ee.setValue("osh5", 10, "AB", 44, rs[1].getInt(24));
        ee.setValue("osh5", 10, "AB", 45, rs[1].getInt(25));
        ee.setValue("osh5", 10, "AB", 46, rs[1].getInt(26));
        ee.setValue("osh5", 10, "AB", 47, rs[1].getInt(27));
        ee.setValue("osh5", 10, "AB", 48, rs[1].getInt(28));
        ee.setValue("osh5", 10, "AB", 49, rs[1].getInt(29));
        ee.setValue("osh5", 10, "AB", 50, rs[1].getInt(30));
        ee.setValue("osh5", 10, "AB", 51, rs[1].getInt(31));
        ee.setValue("osh5", 10, "AB", 52, rs[1].getInt(32));
        ee.setValue("osh5", 10, "AB", 53, rs[1].getInt(33));
        ee.setValue("osh5", 10, "AB", 54, rs[1].getInt(34));
        ee.setValue("osh5", 10, "AB", 57, rs[1].getInt(35));
        ee.setValue("osh5", 10, "AB", 58, rs[1].getInt(36));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/9/AD21-AD54_AD57-AD58.txt"));
        rs[1].first();

        ee.setValue("osh5", 10, "AD", 21, rs[1].getInt(1));
        ee.setValue("osh5", 10, "AD", 22, rs[1].getInt(2));
        ee.setValue("osh5", 10, "AD", 23, rs[1].getInt(3));
        ee.setValue("osh5", 10, "AD", 24, rs[1].getInt(4));
        ee.setValue("osh5", 10, "AD", 25, rs[1].getInt(5));
        ee.setValue("osh5", 10, "AD", 26, rs[1].getInt(6));
        ee.setValue("osh5", 10, "AD", 27, rs[1].getInt(7));
        ee.setValue("osh5", 10, "AD", 28, rs[1].getInt(8));
        ee.setValue("osh5", 10, "AD", 29, rs[1].getInt(9));
        ee.setValue("osh5", 10, "AD", 30, rs[1].getInt(10));
        ee.setValue("osh5", 10, "AD", 31, rs[1].getInt(11));
        ee.setValue("osh5", 10, "AD", 32, rs[1].getInt(12));
        ee.setValue("osh5", 10, "AD", 33, rs[1].getInt(13));
        ee.setValue("osh5", 10, "AD", 34, rs[1].getInt(14));
        ee.setValue("osh5", 10, "AD", 35, rs[1].getInt(15));
        ee.setValue("osh5", 10, "AD", 36, rs[1].getInt(16));
        ee.setValue("osh5", 10, "AD", 37, rs[1].getInt(17));
        ee.setValue("osh5", 10, "AD", 38, rs[1].getInt(18));
        ee.setValue("osh5", 10, "AD", 39, rs[1].getInt(19));
        ee.setValue("osh5", 10, "AD", 40, rs[1].getInt(20));
        ee.setValue("osh5", 10, "AD", 41, rs[1].getInt(21));
        ee.setValue("osh5", 10, "AD", 42, rs[1].getInt(22));
        ee.setValue("osh5", 10, "AD", 43, rs[1].getInt(23));
        ee.setValue("osh5", 10, "AD", 44, rs[1].getInt(24));
        ee.setValue("osh5", 10, "AD", 45, rs[1].getInt(25));
        ee.setValue("osh5", 10, "AD", 46, rs[1].getInt(26));
        ee.setValue("osh5", 10, "AD", 47, rs[1].getInt(27));
        ee.setValue("osh5", 10, "AD", 48, rs[1].getInt(28));
        ee.setValue("osh5", 10, "AD", 49, rs[1].getInt(29));
        ee.setValue("osh5", 10, "AD", 50, rs[1].getInt(30));
        ee.setValue("osh5", 10, "AD", 51, rs[1].getInt(31));
        ee.setValue("osh5", 10, "AD", 52, rs[1].getInt(32));
        ee.setValue("osh5", 10, "AD", 53, rs[1].getInt(33));
        ee.setValue("osh5", 10, "AD", 54, rs[1].getInt(34));
        ee.setValue("osh5", 10, "AD", 57, rs[1].getInt(35));
        ee.setValue("osh5", 10, "AD", 58, rs[1].getInt(36));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/9/AF21-AF54_AF57-AF58.txt"));
        rs[1].first();

        ee.setValue("osh5", 10, "AF", 21, rs[1].getInt(1));
        ee.setValue("osh5", 10, "AF", 22, rs[1].getInt(2));
        ee.setValue("osh5", 10, "AF", 23, rs[1].getInt(3));
        ee.setValue("osh5", 10, "AF", 24, rs[1].getInt(4));
        ee.setValue("osh5", 10, "AF", 25, rs[1].getInt(5));
        ee.setValue("osh5", 10, "AF", 26, rs[1].getInt(6));
        ee.setValue("osh5", 10, "AF", 27, rs[1].getInt(7));
        ee.setValue("osh5", 10, "AF", 28, rs[1].getInt(8));
        ee.setValue("osh5", 10, "AF", 29, rs[1].getInt(9));
        ee.setValue("osh5", 10, "AF", 30, rs[1].getInt(10));
        ee.setValue("osh5", 10, "AF", 31, rs[1].getInt(11));
        ee.setValue("osh5", 10, "AF", 32, rs[1].getInt(12));
        ee.setValue("osh5", 10, "AF", 33, rs[1].getInt(13));
        ee.setValue("osh5", 10, "AF", 34, rs[1].getInt(14));
        ee.setValue("osh5", 10, "AF", 35, rs[1].getInt(15));
        ee.setValue("osh5", 10, "AF", 36, rs[1].getInt(16));
        ee.setValue("osh5", 10, "AF", 37, rs[1].getInt(17));
        ee.setValue("osh5", 10, "AF", 38, rs[1].getInt(18));
        ee.setValue("osh5", 10, "AF", 39, rs[1].getInt(19));
        ee.setValue("osh5", 10, "AF", 40, rs[1].getInt(20));
        ee.setValue("osh5", 10, "AF", 41, rs[1].getInt(21));
        ee.setValue("osh5", 10, "AF", 42, rs[1].getInt(22));
        ee.setValue("osh5", 10, "AF", 43, rs[1].getInt(23));
        ee.setValue("osh5", 10, "AF", 44, rs[1].getInt(24));
        ee.setValue("osh5", 10, "AF", 45, rs[1].getInt(25));
        ee.setValue("osh5", 10, "AF", 46, rs[1].getInt(26));
        ee.setValue("osh5", 10, "AF", 47, rs[1].getInt(27));
        ee.setValue("osh5", 10, "AF", 48, rs[1].getInt(28));
        ee.setValue("osh5", 10, "AF", 49, rs[1].getInt(29));
        ee.setValue("osh5", 10, "AF", 50, rs[1].getInt(30));
        ee.setValue("osh5", 10, "AF", 51, rs[1].getInt(31));
        ee.setValue("osh5", 10, "AF", 52, rs[1].getInt(32));
        ee.setValue("osh5", 10, "AF", 53, rs[1].getInt(33));
        ee.setValue("osh5", 10, "AF", 54, rs[1].getInt(34));
        ee.setValue("osh5", 10, "AF", 57, rs[1].getInt(35));
        ee.setValue("osh5", 10, "AF", 58, rs[1].getInt(36));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/9/AG21-AG54_AG57-AG58.txt"));
        rs[1].first();

        ee.setValue("osh5", 10, "AG", 21, rs[1].getInt(1));
        ee.setValue("osh5", 10, "AG", 22, rs[1].getInt(2));
        ee.setValue("osh5", 10, "AG", 23, rs[1].getInt(3));
        ee.setValue("osh5", 10, "AG", 24, rs[1].getInt(4));
        ee.setValue("osh5", 10, "AG", 25, rs[1].getInt(5));
        ee.setValue("osh5", 10, "AG", 26, rs[1].getInt(6));
        ee.setValue("osh5", 10, "AG", 27, rs[1].getInt(7));
        ee.setValue("osh5", 10, "AG", 28, rs[1].getInt(8));
        ee.setValue("osh5", 10, "AG", 29, rs[1].getInt(9));
        ee.setValue("osh5", 10, "AG", 30, rs[1].getInt(10));
        ee.setValue("osh5", 10, "AG", 31, rs[1].getInt(11));
        ee.setValue("osh5", 10, "AG", 32, rs[1].getInt(12));
        ee.setValue("osh5", 10, "AG", 33, rs[1].getInt(13));
        ee.setValue("osh5", 10, "AG", 34, rs[1].getInt(14));
        ee.setValue("osh5", 10, "AG", 35, rs[1].getInt(15));
        ee.setValue("osh5", 10, "AG", 36, rs[1].getInt(16));
        ee.setValue("osh5", 10, "AG", 37, rs[1].getInt(17));
        ee.setValue("osh5", 10, "AG", 38, rs[1].getInt(18));
        ee.setValue("osh5", 10, "AG", 39, rs[1].getInt(19));
        ee.setValue("osh5", 10, "AG", 40, rs[1].getInt(20));
        ee.setValue("osh5", 10, "AG", 41, rs[1].getInt(21));
        ee.setValue("osh5", 10, "AG", 42, rs[1].getInt(22));
        ee.setValue("osh5", 10, "AG", 43, rs[1].getInt(23));
        ee.setValue("osh5", 10, "AG", 44, rs[1].getInt(24));
        ee.setValue("osh5", 10, "AG", 45, rs[1].getInt(25));
        ee.setValue("osh5", 10, "AG", 46, rs[1].getInt(26));
        ee.setValue("osh5", 10, "AG", 47, rs[1].getInt(27));
        ee.setValue("osh5", 10, "AG", 48, rs[1].getInt(28));
        ee.setValue("osh5", 10, "AG", 49, rs[1].getInt(29));
        ee.setValue("osh5", 10, "AG", 50, rs[1].getInt(30));
        ee.setValue("osh5", 10, "AG", 51, rs[1].getInt(31));
        ee.setValue("osh5", 10, "AG", 52, rs[1].getInt(32));
        ee.setValue("osh5", 10, "AG", 53, rs[1].getInt(33));
        ee.setValue("osh5", 10, "AG", 54, rs[1].getInt(34));
        ee.setValue("osh5", 10, "AG", 57, rs[1].getInt(35));
        ee.setValue("osh5", 10, "AG", 58, rs[1].getInt(36));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/9/AH21-AH54_AH57-AH58.txt"));
        rs[1].first();

        ee.setValue("osh5", 10, "AH", 21, rs[1].getInt(1));
        ee.setValue("osh5", 10, "AH", 22, rs[1].getInt(2));
        ee.setValue("osh5", 10, "AH", 23, rs[1].getInt(3));
        ee.setValue("osh5", 10, "AH", 24, rs[1].getInt(4));
        ee.setValue("osh5", 10, "AH", 25, rs[1].getInt(5));
        ee.setValue("osh5", 10, "AH", 26, rs[1].getInt(6));
        ee.setValue("osh5", 10, "AH", 27, rs[1].getInt(7));
        ee.setValue("osh5", 10, "AH", 28, rs[1].getInt(8));
        ee.setValue("osh5", 10, "AH", 29, rs[1].getInt(9));
        ee.setValue("osh5", 10, "AH", 30, rs[1].getInt(10));
        ee.setValue("osh5", 10, "AH", 31, rs[1].getInt(11));
        ee.setValue("osh5", 10, "AH", 32, rs[1].getInt(12));
        ee.setValue("osh5", 10, "AH", 33, rs[1].getInt(13));
        ee.setValue("osh5", 10, "AH", 34, rs[1].getInt(14));
        ee.setValue("osh5", 10, "AH", 35, rs[1].getInt(15));
        ee.setValue("osh5", 10, "AH", 36, rs[1].getInt(16));
        ee.setValue("osh5", 10, "AH", 37, rs[1].getInt(17));
        ee.setValue("osh5", 10, "AH", 38, rs[1].getInt(18));
        ee.setValue("osh5", 10, "AH", 39, rs[1].getInt(19));
        ee.setValue("osh5", 10, "AH", 40, rs[1].getInt(20));
        ee.setValue("osh5", 10, "AH", 41, rs[1].getInt(21));
        ee.setValue("osh5", 10, "AH", 42, rs[1].getInt(22));
        ee.setValue("osh5", 10, "AH", 43, rs[1].getInt(23));
        ee.setValue("osh5", 10, "AH", 44, rs[1].getInt(24));
        ee.setValue("osh5", 10, "AH", 45, rs[1].getInt(25));
        ee.setValue("osh5", 10, "AH", 46, rs[1].getInt(26));
        ee.setValue("osh5", 10, "AH", 47, rs[1].getInt(27));
        ee.setValue("osh5", 10, "AH", 48, rs[1].getInt(28));
        ee.setValue("osh5", 10, "AH", 49, rs[1].getInt(29));
        ee.setValue("osh5", 10, "AH", 50, rs[1].getInt(30));
        ee.setValue("osh5", 10, "AH", 51, rs[1].getInt(31));
        ee.setValue("osh5", 10, "AH", 52, rs[1].getInt(32));
        ee.setValue("osh5", 10, "AH", 53, rs[1].getInt(33));
        ee.setValue("osh5", 10, "AH", 54, rs[1].getInt(34));
        ee.setValue("osh5", 10, "AH", 57, rs[1].getInt(35));
        ee.setValue("osh5", 10, "AH", 58, rs[1].getInt(36));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/9/AI21-AI54_AI57-AI58.txt"));
        rs[1].first();

        ee.setValue("osh5", 10, "AI", 21, rs[1].getInt(1));
        ee.setValue("osh5", 10, "AI", 22, rs[1].getInt(2));
        ee.setValue("osh5", 10, "AI", 23, rs[1].getInt(3));
        ee.setValue("osh5", 10, "AI", 24, rs[1].getInt(4));
        ee.setValue("osh5", 10, "AI", 25, rs[1].getInt(5));
        ee.setValue("osh5", 10, "AI", 26, rs[1].getInt(6));
        ee.setValue("osh5", 10, "AI", 27, rs[1].getInt(7));
        ee.setValue("osh5", 10, "AI", 28, rs[1].getInt(8));
        ee.setValue("osh5", 10, "AI", 29, rs[1].getInt(9));
        ee.setValue("osh5", 10, "AI", 30, rs[1].getInt(10));
        ee.setValue("osh5", 10, "AI", 31, rs[1].getInt(11));
        ee.setValue("osh5", 10, "AI", 32, rs[1].getInt(12));
        ee.setValue("osh5", 10, "AI", 33, rs[1].getInt(13));
        ee.setValue("osh5", 10, "AI", 34, rs[1].getInt(14));
        ee.setValue("osh5", 10, "AI", 35, rs[1].getInt(15));
        ee.setValue("osh5", 10, "AI", 36, rs[1].getInt(16));
        ee.setValue("osh5", 10, "AI", 37, rs[1].getInt(17));
        ee.setValue("osh5", 10, "AI", 38, rs[1].getInt(18));
        ee.setValue("osh5", 10, "AI", 39, rs[1].getInt(19));
        ee.setValue("osh5", 10, "AI", 40, rs[1].getInt(20));
        ee.setValue("osh5", 10, "AI", 41, rs[1].getInt(21));
        ee.setValue("osh5", 10, "AI", 42, rs[1].getInt(22));
        ee.setValue("osh5", 10, "AI", 43, rs[1].getInt(23));
        ee.setValue("osh5", 10, "AI", 44, rs[1].getInt(24));
        ee.setValue("osh5", 10, "AI", 45, rs[1].getInt(25));
        ee.setValue("osh5", 10, "AI", 46, rs[1].getInt(26));
        ee.setValue("osh5", 10, "AI", 47, rs[1].getInt(27));
        ee.setValue("osh5", 10, "AI", 48, rs[1].getInt(28));
        ee.setValue("osh5", 10, "AI", 49, rs[1].getInt(29));
        ee.setValue("osh5", 10, "AI", 50, rs[1].getInt(30));
        ee.setValue("osh5", 10, "AI", 51, rs[1].getInt(31));
        ee.setValue("osh5", 10, "AI", 52, rs[1].getInt(32));
        ee.setValue("osh5", 10, "AI", 53, rs[1].getInt(33));
        ee.setValue("osh5", 10, "AI", 54, rs[1].getInt(34));
        ee.setValue("osh5", 10, "AI", 57, rs[1].getInt(35));
        ee.setValue("osh5", 10, "AI", 58, rs[1].getInt(36));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/9/AJ21-AJ54_AJ57-AJ58.txt"));
        rs[1].first();

        ee.setValue("osh5", 10, "AJ", 21, rs[1].getInt(1));
        ee.setValue("osh5", 10, "AJ", 22, rs[1].getInt(2));
        ee.setValue("osh5", 10, "AJ", 23, rs[1].getInt(3));
        ee.setValue("osh5", 10, "AJ", 24, rs[1].getInt(4));
        ee.setValue("osh5", 10, "AJ", 25, rs[1].getInt(5));
        ee.setValue("osh5", 10, "AJ", 26, rs[1].getInt(6));
        ee.setValue("osh5", 10, "AJ", 27, rs[1].getInt(7));
        ee.setValue("osh5", 10, "AJ", 28, rs[1].getInt(8));
        ee.setValue("osh5", 10, "AJ", 29, rs[1].getInt(9));
        ee.setValue("osh5", 10, "AJ", 30, rs[1].getInt(10));
        ee.setValue("osh5", 10, "AJ", 31, rs[1].getInt(11));
        ee.setValue("osh5", 10, "AJ", 32, rs[1].getInt(12));
        ee.setValue("osh5", 10, "AJ", 33, rs[1].getInt(13));
        ee.setValue("osh5", 10, "AJ", 34, rs[1].getInt(14));
        ee.setValue("osh5", 10, "AJ", 35, rs[1].getInt(15));
        ee.setValue("osh5", 10, "AJ", 36, rs[1].getInt(16));
        ee.setValue("osh5", 10, "AJ", 37, rs[1].getInt(17));
        ee.setValue("osh5", 10, "AJ", 38, rs[1].getInt(18));
        ee.setValue("osh5", 10, "AJ", 39, rs[1].getInt(19));
        ee.setValue("osh5", 10, "AJ", 40, rs[1].getInt(20));
        ee.setValue("osh5", 10, "AJ", 41, rs[1].getInt(21));
        ee.setValue("osh5", 10, "AJ", 42, rs[1].getInt(22));
        ee.setValue("osh5", 10, "AJ", 43, rs[1].getInt(23));
        ee.setValue("osh5", 10, "AJ", 44, rs[1].getInt(24));
        ee.setValue("osh5", 10, "AJ", 45, rs[1].getInt(25));
        ee.setValue("osh5", 10, "AJ", 46, rs[1].getInt(26));
        ee.setValue("osh5", 10, "AJ", 47, rs[1].getInt(27));
        ee.setValue("osh5", 10, "AJ", 48, rs[1].getInt(28));
        ee.setValue("osh5", 10, "AJ", 49, rs[1].getInt(29));
        ee.setValue("osh5", 10, "AJ", 50, rs[1].getInt(30));
        ee.setValue("osh5", 10, "AJ", 51, rs[1].getInt(31));
        ee.setValue("osh5", 10, "AJ", 52, rs[1].getInt(32));
        ee.setValue("osh5", 10, "AJ", 53, rs[1].getInt(33));
        ee.setValue("osh5", 10, "AJ", 54, rs[1].getInt(34));
        ee.setValue("osh5", 10, "AJ", 57, rs[1].getInt(35));
        ee.setValue("osh5", 10, "AJ", 58, rs[1].getInt(36));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/9/AK21-AK54_AK57-AK58.txt"));
        rs[1].first();

        ee.setValue("osh5", 10, "AK", 21, rs[1].getInt(1));
        ee.setValue("osh5", 10, "AK", 22, rs[1].getInt(2));
        ee.setValue("osh5", 10, "AK", 23, rs[1].getInt(3));
        ee.setValue("osh5", 10, "AK", 24, rs[1].getInt(4));
        ee.setValue("osh5", 10, "AK", 25, rs[1].getInt(5));
        ee.setValue("osh5", 10, "AK", 26, rs[1].getInt(6));
        ee.setValue("osh5", 10, "AK", 27, rs[1].getInt(7));
        ee.setValue("osh5", 10, "AK", 28, rs[1].getInt(8));
        ee.setValue("osh5", 10, "AK", 29, rs[1].getInt(9));
        ee.setValue("osh5", 10, "AK", 30, rs[1].getInt(10));
        ee.setValue("osh5", 10, "AK", 31, rs[1].getInt(11));
        ee.setValue("osh5", 10, "AK", 32, rs[1].getInt(12));
        ee.setValue("osh5", 10, "AK", 33, rs[1].getInt(13));
        ee.setValue("osh5", 10, "AK", 34, rs[1].getInt(14));
        ee.setValue("osh5", 10, "AK", 35, rs[1].getInt(15));
        ee.setValue("osh5", 10, "AK", 36, rs[1].getInt(16));
        ee.setValue("osh5", 10, "AK", 37, rs[1].getInt(17));
        ee.setValue("osh5", 10, "AK", 38, rs[1].getInt(18));
        ee.setValue("osh5", 10, "AK", 39, rs[1].getInt(19));
        ee.setValue("osh5", 10, "AK", 40, rs[1].getInt(20));
        ee.setValue("osh5", 10, "AK", 41, rs[1].getInt(21));
        ee.setValue("osh5", 10, "AK", 42, rs[1].getInt(22));
        ee.setValue("osh5", 10, "AK", 43, rs[1].getInt(23));
        ee.setValue("osh5", 10, "AK", 44, rs[1].getInt(24));
        ee.setValue("osh5", 10, "AK", 45, rs[1].getInt(25));
        ee.setValue("osh5", 10, "AK", 46, rs[1].getInt(26));
        ee.setValue("osh5", 10, "AK", 47, rs[1].getInt(27));
        ee.setValue("osh5", 10, "AK", 48, rs[1].getInt(28));
        ee.setValue("osh5", 10, "AK", 49, rs[1].getInt(29));
        ee.setValue("osh5", 10, "AK", 50, rs[1].getInt(30));
        ee.setValue("osh5", 10, "AK", 51, rs[1].getInt(31));
        ee.setValue("osh5", 10, "AK", 52, rs[1].getInt(32));
        ee.setValue("osh5", 10, "AK", 53, rs[1].getInt(33));
        ee.setValue("osh5", 10, "AK", 54, rs[1].getInt(34));
        ee.setValue("osh5", 10, "AK", 57, rs[1].getInt(35));
        ee.setValue("osh5", 10, "AK", 58, rs[1].getInt(36));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/9/AL21-AL54_AL57-AL58.txt"));
        rs[1].first();

        ee.setValue("osh5", 10, "AL", 21, rs[1].getInt(1));
        ee.setValue("osh5", 10, "AL", 22, rs[1].getInt(2));
        ee.setValue("osh5", 10, "AL", 23, rs[1].getInt(3));
        ee.setValue("osh5", 10, "AL", 24, rs[1].getInt(4));
        ee.setValue("osh5", 10, "AL", 25, rs[1].getInt(5));
        ee.setValue("osh5", 10, "AL", 26, rs[1].getInt(6));
        ee.setValue("osh5", 10, "AL", 27, rs[1].getInt(7));
        ee.setValue("osh5", 10, "AL", 28, rs[1].getInt(8));
        ee.setValue("osh5", 10, "AL", 29, rs[1].getInt(9));
        ee.setValue("osh5", 10, "AL", 30, rs[1].getInt(10));
        ee.setValue("osh5", 10, "AL", 31, rs[1].getInt(11));
        ee.setValue("osh5", 10, "AL", 32, rs[1].getInt(12));
        ee.setValue("osh5", 10, "AL", 33, rs[1].getInt(13));
        ee.setValue("osh5", 10, "AL", 34, rs[1].getInt(14));
        ee.setValue("osh5", 10, "AL", 35, rs[1].getInt(15));
        ee.setValue("osh5", 10, "AL", 36, rs[1].getInt(16));
        ee.setValue("osh5", 10, "AL", 37, rs[1].getInt(17));
        ee.setValue("osh5", 10, "AL", 38, rs[1].getInt(18));
        ee.setValue("osh5", 10, "AL", 39, rs[1].getInt(19));
        ee.setValue("osh5", 10, "AL", 40, rs[1].getInt(20));
        ee.setValue("osh5", 10, "AL", 41, rs[1].getInt(21));
        ee.setValue("osh5", 10, "AL", 42, rs[1].getInt(22));
        ee.setValue("osh5", 10, "AL", 43, rs[1].getInt(23));
        ee.setValue("osh5", 10, "AL", 44, rs[1].getInt(24));
        ee.setValue("osh5", 10, "AL", 45, rs[1].getInt(25));
        ee.setValue("osh5", 10, "AL", 46, rs[1].getInt(26));
        ee.setValue("osh5", 10, "AL", 47, rs[1].getInt(27));
        ee.setValue("osh5", 10, "AL", 48, rs[1].getInt(28));
        ee.setValue("osh5", 10, "AL", 49, rs[1].getInt(29));
        ee.setValue("osh5", 10, "AL", 50, rs[1].getInt(30));
        ee.setValue("osh5", 10, "AL", 51, rs[1].getInt(31));
        ee.setValue("osh5", 10, "AL", 52, rs[1].getInt(32));
        ee.setValue("osh5", 10, "AL", 53, rs[1].getInt(33));
        ee.setValue("osh5", 10, "AL", 54, rs[1].getInt(34));
        ee.setValue("osh5", 10, "AL", 57, rs[1].getInt(35));
        ee.setValue("osh5", 10, "AL", 58, rs[1].getInt(36));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/9/P21-P54_P57-P58.txt"));
        rs[1].first();

        ee.setValue("osh5", 10, "P", 21, rs[1].getInt(1));
        ee.setValue("osh5", 10, "P", 22, rs[1].getInt(2));
        ee.setValue("osh5", 10, "P", 23, rs[1].getInt(3));
        ee.setValue("osh5", 10, "P", 24, rs[1].getInt(4));
        ee.setValue("osh5", 10, "P", 25, rs[1].getInt(5));
        ee.setValue("osh5", 10, "P", 26, rs[1].getInt(6));
        ee.setValue("osh5", 10, "P", 27, rs[1].getInt(7));
        ee.setValue("osh5", 10, "P", 28, rs[1].getInt(8));
        ee.setValue("osh5", 10, "P", 29, rs[1].getInt(9));
        ee.setValue("osh5", 10, "P", 30, rs[1].getInt(10));
        ee.setValue("osh5", 10, "P", 31, rs[1].getInt(11));
        ee.setValue("osh5", 10, "P", 32, rs[1].getInt(12));
        ee.setValue("osh5", 10, "P", 33, rs[1].getInt(13));
        ee.setValue("osh5", 10, "P", 34, rs[1].getInt(14));
        ee.setValue("osh5", 10, "P", 35, rs[1].getInt(15));
        ee.setValue("osh5", 10, "P", 36, rs[1].getInt(16));
        ee.setValue("osh5", 10, "P", 37, rs[1].getInt(17));
        ee.setValue("osh5", 10, "P", 38, rs[1].getInt(18));
        ee.setValue("osh5", 10, "P", 39, rs[1].getInt(19));
        ee.setValue("osh5", 10, "P", 40, rs[1].getInt(20));
        ee.setValue("osh5", 10, "P", 41, rs[1].getInt(21));
        ee.setValue("osh5", 10, "P", 42, rs[1].getInt(22));
        ee.setValue("osh5", 10, "P", 43, rs[1].getInt(23));
        ee.setValue("osh5", 10, "P", 44, rs[1].getInt(24));
        ee.setValue("osh5", 10, "P", 45, rs[1].getInt(25));
        ee.setValue("osh5", 10, "P", 46, rs[1].getInt(26));
        ee.setValue("osh5", 10, "P", 47, rs[1].getInt(27));
        ee.setValue("osh5", 10, "P", 48, rs[1].getInt(28));
        ee.setValue("osh5", 10, "P", 49, rs[1].getInt(29));
        ee.setValue("osh5", 10, "P", 50, rs[1].getInt(30));
        ee.setValue("osh5", 10, "P", 51, rs[1].getInt(31));
        ee.setValue("osh5", 10, "P", 52, rs[1].getInt(32));
        ee.setValue("osh5", 10, "P", 53, rs[1].getInt(33));
        ee.setValue("osh5", 10, "P", 54, rs[1].getInt(34));
        ee.setValue("osh5", 10, "P", 57, rs[1].getInt(35));
        ee.setValue("osh5", 10, "P", 58, rs[1].getInt(36));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/9/P59.txt"));
        rs[1].first();

        ee.setValue("osh5", 10, "P", 59, rs[1].getInt(1));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/9/P60.txt"));
        rs[1].first();

        ee.setValue("osh5", 10, "P", 60, rs[1].getInt(1));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/9/R21-R54_R57-R58.txt"));
        rs[1].first();

        ee.setValue("osh5", 10, "R", 21, rs[1].getInt(1));
        ee.setValue("osh5", 10, "R", 22, rs[1].getInt(2));
        ee.setValue("osh5", 10, "R", 23, rs[1].getInt(3));
        ee.setValue("osh5", 10, "R", 24, rs[1].getInt(4));
        ee.setValue("osh5", 10, "R", 25, rs[1].getInt(5));
        ee.setValue("osh5", 10, "R", 26, rs[1].getInt(6));
        ee.setValue("osh5", 10, "R", 27, rs[1].getInt(7));
        ee.setValue("osh5", 10, "R", 28, rs[1].getInt(8));
        ee.setValue("osh5", 10, "R", 29, rs[1].getInt(9));
        ee.setValue("osh5", 10, "R", 30, rs[1].getInt(10));
        ee.setValue("osh5", 10, "R", 31, rs[1].getInt(11));
        ee.setValue("osh5", 10, "R", 32, rs[1].getInt(12));
        ee.setValue("osh5", 10, "R", 33, rs[1].getInt(13));
        ee.setValue("osh5", 10, "R", 34, rs[1].getInt(14));
        ee.setValue("osh5", 10, "R", 35, rs[1].getInt(15));
        ee.setValue("osh5", 10, "R", 36, rs[1].getInt(16));
        ee.setValue("osh5", 10, "R", 37, rs[1].getInt(17));
        ee.setValue("osh5", 10, "R", 38, rs[1].getInt(18));
        ee.setValue("osh5", 10, "R", 39, rs[1].getInt(19));
        ee.setValue("osh5", 10, "R", 40, rs[1].getInt(20));
        ee.setValue("osh5", 10, "R", 41, rs[1].getInt(21));
        ee.setValue("osh5", 10, "R", 42, rs[1].getInt(22));
        ee.setValue("osh5", 10, "R", 43, rs[1].getInt(23));
        ee.setValue("osh5", 10, "R", 44, rs[1].getInt(24));
        ee.setValue("osh5", 10, "R", 45, rs[1].getInt(25));
        ee.setValue("osh5", 10, "R", 46, rs[1].getInt(26));
        ee.setValue("osh5", 10, "R", 47, rs[1].getInt(27));
        ee.setValue("osh5", 10, "R", 48, rs[1].getInt(28));
        ee.setValue("osh5", 10, "R", 49, rs[1].getInt(29));
        ee.setValue("osh5", 10, "R", 50, rs[1].getInt(30));
        ee.setValue("osh5", 10, "R", 51, rs[1].getInt(31));
        ee.setValue("osh5", 10, "R", 52, rs[1].getInt(32));
        ee.setValue("osh5", 10, "R", 53, rs[1].getInt(33));
        ee.setValue("osh5", 10, "R", 54, rs[1].getInt(34));
        ee.setValue("osh5", 10, "R", 57, rs[1].getInt(35));
        ee.setValue("osh5", 10, "R", 58, rs[1].getInt(36));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/9/S21-S54_S57-S58.txt"));
        rs[1].first();

        ee.setValue("osh5", 10, "S", 21, rs[1].getInt(1));
        ee.setValue("osh5", 10, "S", 22, rs[1].getInt(2));
        ee.setValue("osh5", 10, "S", 23, rs[1].getInt(3));
        ee.setValue("osh5", 10, "S", 24, rs[1].getInt(4));
        ee.setValue("osh5", 10, "S", 25, rs[1].getInt(5));
        ee.setValue("osh5", 10, "S", 26, rs[1].getInt(6));
        ee.setValue("osh5", 10, "S", 27, rs[1].getInt(7));
        ee.setValue("osh5", 10, "S", 28, rs[1].getInt(8));
        ee.setValue("osh5", 10, "S", 29, rs[1].getInt(9));
        ee.setValue("osh5", 10, "S", 30, rs[1].getInt(10));
        ee.setValue("osh5", 10, "S", 31, rs[1].getInt(11));
        ee.setValue("osh5", 10, "S", 32, rs[1].getInt(12));
        ee.setValue("osh5", 10, "S", 33, rs[1].getInt(13));
        ee.setValue("osh5", 10, "S", 34, rs[1].getInt(14));
        ee.setValue("osh5", 10, "S", 35, rs[1].getInt(15));
        ee.setValue("osh5", 10, "S", 36, rs[1].getInt(16));
        ee.setValue("osh5", 10, "S", 37, rs[1].getInt(17));
        ee.setValue("osh5", 10, "S", 38, rs[1].getInt(18));
        ee.setValue("osh5", 10, "S", 39, rs[1].getInt(19));
        ee.setValue("osh5", 10, "S", 40, rs[1].getInt(20));
        ee.setValue("osh5", 10, "S", 41, rs[1].getInt(21));
        ee.setValue("osh5", 10, "S", 42, rs[1].getInt(22));
        ee.setValue("osh5", 10, "S", 43, rs[1].getInt(23));
        ee.setValue("osh5", 10, "S", 44, rs[1].getInt(24));
        ee.setValue("osh5", 10, "S", 45, rs[1].getInt(25));
        ee.setValue("osh5", 10, "S", 46, rs[1].getInt(26));
        ee.setValue("osh5", 10, "S", 47, rs[1].getInt(27));
        ee.setValue("osh5", 10, "S", 48, rs[1].getInt(28));
        ee.setValue("osh5", 10, "S", 49, rs[1].getInt(29));
        ee.setValue("osh5", 10, "S", 50, rs[1].getInt(30));
        ee.setValue("osh5", 10, "S", 51, rs[1].getInt(31));
        ee.setValue("osh5", 10, "S", 52, rs[1].getInt(32));
        ee.setValue("osh5", 10, "S", 53, rs[1].getInt(33));
        ee.setValue("osh5", 10, "S", 54, rs[1].getInt(34));
        ee.setValue("osh5", 10, "S", 57, rs[1].getInt(35));
        ee.setValue("osh5", 10, "S", 58, rs[1].getInt(36));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/9/T21-T54_T57-T58.txt"));
        rs[1].first();

        ee.setValue("osh5", 10, "T", 21, rs[1].getInt(1));
        ee.setValue("osh5", 10, "T", 22, rs[1].getInt(2));
        ee.setValue("osh5", 10, "T", 23, rs[1].getInt(3));
        ee.setValue("osh5", 10, "T", 24, rs[1].getInt(4));
        ee.setValue("osh5", 10, "T", 25, rs[1].getInt(5));
        ee.setValue("osh5", 10, "T", 26, rs[1].getInt(6));
        ee.setValue("osh5", 10, "T", 27, rs[1].getInt(7));
        ee.setValue("osh5", 10, "T", 28, rs[1].getInt(8));
        ee.setValue("osh5", 10, "T", 29, rs[1].getInt(9));
        ee.setValue("osh5", 10, "T", 30, rs[1].getInt(10));
        ee.setValue("osh5", 10, "T", 31, rs[1].getInt(11));
        ee.setValue("osh5", 10, "T", 32, rs[1].getInt(12));
        ee.setValue("osh5", 10, "T", 33, rs[1].getInt(13));
        ee.setValue("osh5", 10, "T", 34, rs[1].getInt(14));
        ee.setValue("osh5", 10, "T", 35, rs[1].getInt(15));
        ee.setValue("osh5", 10, "T", 36, rs[1].getInt(16));
        ee.setValue("osh5", 10, "T", 37, rs[1].getInt(17));
        ee.setValue("osh5", 10, "T", 38, rs[1].getInt(18));
        ee.setValue("osh5", 10, "T", 39, rs[1].getInt(19));
        ee.setValue("osh5", 10, "T", 40, rs[1].getInt(20));
        ee.setValue("osh5", 10, "T", 41, rs[1].getInt(21));
        ee.setValue("osh5", 10, "T", 42, rs[1].getInt(22));
        ee.setValue("osh5", 10, "T", 43, rs[1].getInt(23));
        ee.setValue("osh5", 10, "T", 44, rs[1].getInt(24));
        ee.setValue("osh5", 10, "T", 45, rs[1].getInt(25));
        ee.setValue("osh5", 10, "T", 46, rs[1].getInt(26));
        ee.setValue("osh5", 10, "T", 47, rs[1].getInt(27));
        ee.setValue("osh5", 10, "T", 48, rs[1].getInt(28));
        ee.setValue("osh5", 10, "T", 49, rs[1].getInt(29));
        ee.setValue("osh5", 10, "T", 50, rs[1].getInt(30));
        ee.setValue("osh5", 10, "T", 51, rs[1].getInt(31));
        ee.setValue("osh5", 10, "T", 52, rs[1].getInt(32));
        ee.setValue("osh5", 10, "T", 53, rs[1].getInt(33));
        ee.setValue("osh5", 10, "T", 54, rs[1].getInt(34));
        ee.setValue("osh5", 10, "T", 57, rs[1].getInt(35));
        ee.setValue("osh5", 10, "T", 58, rs[1].getInt(36));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/9/U21-U54_U57-U58.txt"));
        rs[1].first();

        ee.setValue("osh5", 10, "U", 21, rs[1].getInt(1));
        ee.setValue("osh5", 10, "U", 22, rs[1].getInt(2));
        ee.setValue("osh5", 10, "U", 23, rs[1].getInt(3));
        ee.setValue("osh5", 10, "U", 24, rs[1].getInt(4));
        ee.setValue("osh5", 10, "U", 25, rs[1].getInt(5));
        ee.setValue("osh5", 10, "U", 26, rs[1].getInt(6));
        ee.setValue("osh5", 10, "U", 27, rs[1].getInt(7));
        ee.setValue("osh5", 10, "U", 28, rs[1].getInt(8));
        ee.setValue("osh5", 10, "U", 29, rs[1].getInt(9));
        ee.setValue("osh5", 10, "U", 30, rs[1].getInt(10));
        ee.setValue("osh5", 10, "U", 31, rs[1].getInt(11));
        ee.setValue("osh5", 10, "U", 32, rs[1].getInt(12));
        ee.setValue("osh5", 10, "U", 33, rs[1].getInt(13));
        ee.setValue("osh5", 10, "U", 34, rs[1].getInt(14));
        ee.setValue("osh5", 10, "U", 35, rs[1].getInt(15));
        ee.setValue("osh5", 10, "U", 36, rs[1].getInt(16));
        ee.setValue("osh5", 10, "U", 37, rs[1].getInt(17));
        ee.setValue("osh5", 10, "U", 38, rs[1].getInt(18));
        ee.setValue("osh5", 10, "U", 39, rs[1].getInt(19));
        ee.setValue("osh5", 10, "U", 40, rs[1].getInt(20));
        ee.setValue("osh5", 10, "U", 41, rs[1].getInt(21));
        ee.setValue("osh5", 10, "U", 42, rs[1].getInt(22));
        ee.setValue("osh5", 10, "U", 43, rs[1].getInt(23));
        ee.setValue("osh5", 10, "U", 44, rs[1].getInt(24));
        ee.setValue("osh5", 10, "U", 45, rs[1].getInt(25));
        ee.setValue("osh5", 10, "U", 46, rs[1].getInt(26));
        ee.setValue("osh5", 10, "U", 47, rs[1].getInt(27));
        ee.setValue("osh5", 10, "U", 48, rs[1].getInt(28));
        ee.setValue("osh5", 10, "U", 49, rs[1].getInt(29));
        ee.setValue("osh5", 10, "U", 50, rs[1].getInt(30));
        ee.setValue("osh5", 10, "U", 51, rs[1].getInt(31));
        ee.setValue("osh5", 10, "U", 52, rs[1].getInt(32));
        ee.setValue("osh5", 10, "U", 53, rs[1].getInt(33));
        ee.setValue("osh5", 10, "U", 54, rs[1].getInt(34));
        ee.setValue("osh5", 10, "U", 57, rs[1].getInt(35));
        ee.setValue("osh5", 10, "U", 58, rs[1].getInt(36));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/9/V21-V54.txt"));
        rs[1].first();

        ee.setValue("osh5", 10, "V", 21, rs[1].getInt(1));
        ee.setValue("osh5", 10, "V", 22, rs[1].getInt(2));
        ee.setValue("osh5", 10, "V", 23, rs[1].getInt(3));
        ee.setValue("osh5", 10, "V", 24, rs[1].getInt(4));
        ee.setValue("osh5", 10, "V", 25, rs[1].getInt(5));
        ee.setValue("osh5", 10, "V", 26, rs[1].getInt(6));
        ee.setValue("osh5", 10, "V", 27, rs[1].getInt(7));
        ee.setValue("osh5", 10, "V", 28, rs[1].getInt(8));
        ee.setValue("osh5", 10, "V", 29, rs[1].getInt(9));
        ee.setValue("osh5", 10, "V", 30, rs[1].getInt(10));
        ee.setValue("osh5", 10, "V", 31, rs[1].getInt(11));
        ee.setValue("osh5", 10, "V", 32, rs[1].getInt(12));
        ee.setValue("osh5", 10, "V", 33, rs[1].getInt(13));
        ee.setValue("osh5", 10, "V", 34, rs[1].getInt(14));
        ee.setValue("osh5", 10, "V", 35, rs[1].getInt(15));
        ee.setValue("osh5", 10, "V", 36, rs[1].getInt(16));
        ee.setValue("osh5", 10, "V", 37, rs[1].getInt(17));
        ee.setValue("osh5", 10, "V", 38, rs[1].getInt(18));
        ee.setValue("osh5", 10, "V", 39, rs[1].getInt(19));
        ee.setValue("osh5", 10, "V", 40, rs[1].getInt(20));
        ee.setValue("osh5", 10, "V", 41, rs[1].getInt(21));
        ee.setValue("osh5", 10, "V", 42, rs[1].getInt(22));
        ee.setValue("osh5", 10, "V", 43, rs[1].getInt(23));
        ee.setValue("osh5", 10, "V", 44, rs[1].getInt(24));
        ee.setValue("osh5", 10, "V", 45, rs[1].getInt(25));
        ee.setValue("osh5", 10, "V", 46, rs[1].getInt(26));
        ee.setValue("osh5", 10, "V", 47, rs[1].getInt(27));
        ee.setValue("osh5", 10, "V", 48, rs[1].getInt(28));
        ee.setValue("osh5", 10, "V", 49, rs[1].getInt(29));
        ee.setValue("osh5", 10, "V", 50, rs[1].getInt(30));
        ee.setValue("osh5", 10, "V", 51, rs[1].getInt(31));
        ee.setValue("osh5", 10, "V", 52, rs[1].getInt(32));
        ee.setValue("osh5", 10, "V", 53, rs[1].getInt(33));
        ee.setValue("osh5", 10, "V", 54, rs[1].getInt(34));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/9/W21-W54.txt"));
        rs[1].first();

        ee.setValue("osh5", 10, "W", 21, rs[1].getInt(1));
        ee.setValue("osh5", 10, "W", 22, rs[1].getInt(2));
        ee.setValue("osh5", 10, "W", 23, rs[1].getInt(3));
        ee.setValue("osh5", 10, "W", 24, rs[1].getInt(4));
        ee.setValue("osh5", 10, "W", 25, rs[1].getInt(5));
        ee.setValue("osh5", 10, "W", 26, rs[1].getInt(6));
        ee.setValue("osh5", 10, "W", 27, rs[1].getInt(7));
        ee.setValue("osh5", 10, "W", 28, rs[1].getInt(8));
        ee.setValue("osh5", 10, "W", 29, rs[1].getInt(9));
        ee.setValue("osh5", 10, "W", 30, rs[1].getInt(10));
        ee.setValue("osh5", 10, "W", 31, rs[1].getInt(11));
        ee.setValue("osh5", 10, "W", 32, rs[1].getInt(12));
        ee.setValue("osh5", 10, "W", 33, rs[1].getInt(13));
        ee.setValue("osh5", 10, "W", 34, rs[1].getInt(14));
        ee.setValue("osh5", 10, "W", 35, rs[1].getInt(15));
        ee.setValue("osh5", 10, "W", 36, rs[1].getInt(16));
        ee.setValue("osh5", 10, "W", 37, rs[1].getInt(17));
        ee.setValue("osh5", 10, "W", 38, rs[1].getInt(18));
        ee.setValue("osh5", 10, "W", 39, rs[1].getInt(19));
        ee.setValue("osh5", 10, "W", 40, rs[1].getInt(20));
        ee.setValue("osh5", 10, "W", 41, rs[1].getInt(21));
        ee.setValue("osh5", 10, "W", 42, rs[1].getInt(22));
        ee.setValue("osh5", 10, "W", 43, rs[1].getInt(23));
        ee.setValue("osh5", 10, "W", 44, rs[1].getInt(24));
        ee.setValue("osh5", 10, "W", 45, rs[1].getInt(25));
        ee.setValue("osh5", 10, "W", 46, rs[1].getInt(26));
        ee.setValue("osh5", 10, "W", 47, rs[1].getInt(27));
        ee.setValue("osh5", 10, "W", 48, rs[1].getInt(28));
        ee.setValue("osh5", 10, "W", 49, rs[1].getInt(29));
        ee.setValue("osh5", 10, "W", 50, rs[1].getInt(30));
        ee.setValue("osh5", 10, "W", 51, rs[1].getInt(31));
        ee.setValue("osh5", 10, "W", 52, rs[1].getInt(32));
        ee.setValue("osh5", 10, "W", 53, rs[1].getInt(33));
        ee.setValue("osh5", 10, "W", 54, rs[1].getInt(34));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/9/X21_X27-X54.txt"));
        rs[1].first();

        ee.setValue("osh5", 10, "X", 21, rs[1].getInt(1));
        ee.setValue("osh5", 10, "X", 27, rs[1].getInt(2));
        ee.setValue("osh5", 10, "X", 28, rs[1].getInt(3));
        ee.setValue("osh5", 10, "X", 29, rs[1].getInt(4));
        ee.setValue("osh5", 10, "X", 30, rs[1].getInt(5));
        ee.setValue("osh5", 10, "X", 31, rs[1].getInt(6));
        ee.setValue("osh5", 10, "X", 32, rs[1].getInt(7));
        ee.setValue("osh5", 10, "X", 33, rs[1].getInt(8));
        ee.setValue("osh5", 10, "X", 34, rs[1].getInt(9));
        ee.setValue("osh5", 10, "X", 35, rs[1].getInt(10));
        ee.setValue("osh5", 10, "X", 36, rs[1].getInt(11));
        ee.setValue("osh5", 10, "X", 37, rs[1].getInt(12));
        ee.setValue("osh5", 10, "X", 38, rs[1].getInt(13));
        ee.setValue("osh5", 10, "X", 39, rs[1].getInt(14));
        ee.setValue("osh5", 10, "X", 40, rs[1].getInt(15));
        ee.setValue("osh5", 10, "X", 41, rs[1].getInt(16));
        ee.setValue("osh5", 10, "X", 42, rs[1].getInt(17));
        ee.setValue("osh5", 10, "X", 43, rs[1].getInt(18));
        ee.setValue("osh5", 10, "X", 44, rs[1].getInt(19));
        ee.setValue("osh5", 10, "X", 45, rs[1].getInt(20));
        ee.setValue("osh5", 10, "X", 46, rs[1].getInt(21));
        ee.setValue("osh5", 10, "X", 47, rs[1].getInt(22));
        ee.setValue("osh5", 10, "X", 48, rs[1].getInt(23));
        ee.setValue("osh5", 10, "X", 49, rs[1].getInt(24));
        ee.setValue("osh5", 10, "X", 50, rs[1].getInt(25));
        ee.setValue("osh5", 10, "X", 51, rs[1].getInt(26));
        ee.setValue("osh5", 10, "X", 52, rs[1].getInt(27));
        ee.setValue("osh5", 10, "X", 53, rs[1].getInt(28));
        ee.setValue("osh5", 10, "X", 54, rs[1].getInt(29));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/9/Y21_Y27-Y54.txt"));
        rs[1].first();

        ee.setValue("osh5", 10, "Y", 21, rs[1].getInt(1));
        ee.setValue("osh5", 10, "Y", 27, rs[1].getInt(2));
        ee.setValue("osh5", 10, "Y", 28, rs[1].getInt(3));
        ee.setValue("osh5", 10, "Y", 29, rs[1].getInt(4));
        ee.setValue("osh5", 10, "Y", 30, rs[1].getInt(5));
        ee.setValue("osh5", 10, "Y", 31, rs[1].getInt(6));
        ee.setValue("osh5", 10, "Y", 32, rs[1].getInt(7));
        ee.setValue("osh5", 10, "Y", 33, rs[1].getInt(8));
        ee.setValue("osh5", 10, "Y", 34, rs[1].getInt(9));
        ee.setValue("osh5", 10, "Y", 35, rs[1].getInt(10));
        ee.setValue("osh5", 10, "Y", 36, rs[1].getInt(11));
        ee.setValue("osh5", 10, "Y", 37, rs[1].getInt(12));
        ee.setValue("osh5", 10, "Y", 38, rs[1].getInt(13));
        ee.setValue("osh5", 10, "Y", 39, rs[1].getInt(14));
        ee.setValue("osh5", 10, "Y", 40, rs[1].getInt(15));
        ee.setValue("osh5", 10, "Y", 41, rs[1].getInt(16));
        ee.setValue("osh5", 10, "Y", 42, rs[1].getInt(17));
        ee.setValue("osh5", 10, "Y", 43, rs[1].getInt(18));
        ee.setValue("osh5", 10, "Y", 44, rs[1].getInt(19));
        ee.setValue("osh5", 10, "Y", 45, rs[1].getInt(20));
        ee.setValue("osh5", 10, "Y", 46, rs[1].getInt(21));
        ee.setValue("osh5", 10, "Y", 47, rs[1].getInt(22));
        ee.setValue("osh5", 10, "Y", 48, rs[1].getInt(23));
        ee.setValue("osh5", 10, "Y", 49, rs[1].getInt(24));
        ee.setValue("osh5", 10, "Y", 50, rs[1].getInt(25));
        ee.setValue("osh5", 10, "Y", 51, rs[1].getInt(26));
        ee.setValue("osh5", 10, "Y", 52, rs[1].getInt(27));
        ee.setValue("osh5", 10, "Y", 53, rs[1].getInt(28));
        ee.setValue("osh5", 10, "Y", 54, rs[1].getInt(29));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/9/Z21-Z54_Z57-Z58.txt"));
        rs[1].first();

        ee.setValue("osh5", 10, "Z", 21, rs[1].getInt(1));
        ee.setValue("osh5", 10, "Z", 22, rs[1].getInt(2));
        ee.setValue("osh5", 10, "Z", 23, rs[1].getInt(3));
        ee.setValue("osh5", 10, "Z", 24, rs[1].getInt(4));
        ee.setValue("osh5", 10, "Z", 25, rs[1].getInt(5));
        ee.setValue("osh5", 10, "Z", 26, rs[1].getInt(6));
        ee.setValue("osh5", 10, "Z", 27, rs[1].getInt(7));
        ee.setValue("osh5", 10, "Z", 28, rs[1].getInt(8));
        ee.setValue("osh5", 10, "Z", 29, rs[1].getInt(9));
        ee.setValue("osh5", 10, "Z", 30, rs[1].getInt(10));
        ee.setValue("osh5", 10, "Z", 31, rs[1].getInt(11));
        ee.setValue("osh5", 10, "Z", 32, rs[1].getInt(12));
        ee.setValue("osh5", 10, "Z", 33, rs[1].getInt(13));
        ee.setValue("osh5", 10, "Z", 34, rs[1].getInt(14));
        ee.setValue("osh5", 10, "Z", 35, rs[1].getInt(15));
        ee.setValue("osh5", 10, "Z", 36, rs[1].getInt(16));
        ee.setValue("osh5", 10, "Z", 37, rs[1].getInt(17));
        ee.setValue("osh5", 10, "Z", 38, rs[1].getInt(18));
        ee.setValue("osh5", 10, "Z", 39, rs[1].getInt(19));
        ee.setValue("osh5", 10, "Z", 40, rs[1].getInt(20));
        ee.setValue("osh5", 10, "Z", 41, rs[1].getInt(21));
        ee.setValue("osh5", 10, "Z", 42, rs[1].getInt(22));
        ee.setValue("osh5", 10, "Z", 43, rs[1].getInt(23));
        ee.setValue("osh5", 10, "Z", 44, rs[1].getInt(24));
        ee.setValue("osh5", 10, "Z", 45, rs[1].getInt(25));
        ee.setValue("osh5", 10, "Z", 46, rs[1].getInt(26));
        ee.setValue("osh5", 10, "Z", 47, rs[1].getInt(27));
        ee.setValue("osh5", 10, "Z", 48, rs[1].getInt(28));
        ee.setValue("osh5", 10, "Z", 49, rs[1].getInt(29));
        ee.setValue("osh5", 10, "Z", 50, rs[1].getInt(30));
        ee.setValue("osh5", 10, "Z", 51, rs[1].getInt(31));
        ee.setValue("osh5", 10, "Z", 52, rs[1].getInt(32));
        ee.setValue("osh5", 10, "Z", 53, rs[1].getInt(33));
        ee.setValue("osh5", 10, "Z", 54, rs[1].getInt(34));
    }

    private static void extractPart10() throws SQLException, IOException {

        if (log != null) {
            log.append("Заполняю раздел 10\n");
        }

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/10/P21.txt"));
        rs[1].first();

        ee.setValue("osh5", 11, "P", 21, rs[1].getInt(1));
        
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/osh5/10/S21.txt"));
        rs[1].first();

        ee.setValue("osh5", 11, "S", 21, rs[1].getInt(1));
    }
}
