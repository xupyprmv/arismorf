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
public class Extractor83rikp {

    private static ResultSet[] rs;
    private static Statement[] s;
    private static ExcelExport ee;
    private static int STCOUNT = 5;
    private static JTextArea log;

    public static void extract(Connection c, JTextArea log, ExcelExport ee) throws SQLException, FileNotFoundException, IOException {
        Extractor83rikp.ee = ee;
        Extractor83rikp.log = log;
        if (log != null) {
            log.append("Заполняю форму 83-рик первичный.\n");
        }
        rs = new ResultSet[STCOUNT];
        s = new Statement[STCOUNT];
        for (int i = 0; i < STCOUNT; i++) {
            s[i] = c.createStatement();
        }

        extractPart1();

        for (int i = 0; i < STCOUNT; i++) {
            s[i].close();
        }
    }

    private static void extractPart1() throws SQLException, IOException {

        if (log != null) {
            log.append("Заполняю раздел 1\n");
        }

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/AA21-AA55_AA58_AA60.txt"));
        if (rs[1].first()) {

            ee.setValue("83rikp", 2, "AA", 21, rs[1].getInt(1));
            ee.setValue("83rikp", 2, "AA", 22, rs[1].getInt(2));
            ee.setValue("83rikp", 2, "AA", 23, rs[1].getInt(3));
            ee.setValue("83rikp", 2, "AA", 24, rs[1].getInt(4));
            ee.setValue("83rikp", 2, "AA", 25, rs[1].getInt(5));
            ee.setValue("83rikp", 2, "AA", 26, rs[1].getInt(6));
            ee.setValue("83rikp", 2, "AA", 27, rs[1].getInt(7));
            ee.setValue("83rikp", 2, "AA", 28, rs[1].getInt(8));
            ee.setValue("83rikp", 2, "AA", 29, rs[1].getInt(9));
            ee.setValue("83rikp", 2, "AA", 30, rs[1].getInt(10));
            ee.setValue("83rikp", 2, "AA", 31, rs[1].getInt(11));
            ee.setValue("83rikp", 2, "AA", 32, rs[1].getInt(12));
            ee.setValue("83rikp", 2, "AA", 33, rs[1].getInt(13));
            ee.setValue("83rikp", 2, "AA", 34, rs[1].getInt(14));
            ee.setValue("83rikp", 2, "AA", 35, rs[1].getInt(15));
            ee.setValue("83rikp", 2, "AA", 36, rs[1].getInt(16));
            ee.setValue("83rikp", 2, "AA", 37, rs[1].getInt(17));
            ee.setValue("83rikp", 2, "AA", 38, rs[1].getInt(18));
            ee.setValue("83rikp", 2, "AA", 39, rs[1].getInt(19));
            ee.setValue("83rikp", 2, "AA", 40, rs[1].getInt(20));
            ee.setValue("83rikp", 2, "AA", 41, rs[1].getInt(21));
            ee.setValue("83rikp", 2, "AA", 42, rs[1].getInt(22));
            ee.setValue("83rikp", 2, "AA", 43, rs[1].getInt(23));
            ee.setValue("83rikp", 2, "AA", 44, rs[1].getInt(24));
            ee.setValue("83rikp", 2, "AA", 45, rs[1].getInt(25));
            ee.setValue("83rikp", 2, "AA", 46, rs[1].getInt(26));
            ee.setValue("83rikp", 2, "AA", 47, rs[1].getInt(27));
            ee.setValue("83rikp", 2, "AA", 48, rs[1].getInt(28));
            ee.setValue("83rikp", 2, "AA", 49, rs[1].getInt(29));
            ee.setValue("83rikp", 2, "AA", 50, rs[1].getInt(30));
            ee.setValue("83rikp", 2, "AA", 51, rs[1].getInt(31));
            ee.setValue("83rikp", 2, "AA", 52, rs[1].getInt(32));
            ee.setValue("83rikp", 2, "AA", 53, rs[1].getInt(33));
            ee.setValue("83rikp", 2, "AA", 54, rs[1].getInt(34));
            ee.setValue("83rikp", 2, "AA", 55, rs[1].getInt(35));
            ee.setValue("83rikp", 2, "AA", 58, rs[1].getInt(36));
            ee.setValue("83rikp", 2, "AA", 60, rs[1].getInt(37));
        }
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/AB21-AB55_AB58_AB60.txt"));
        if (rs[1].first()) {

            ee.setValue("83rikp", 2, "AB", 21, rs[1].getInt(1));
            ee.setValue("83rikp", 2, "AB", 22, rs[1].getInt(2));
            ee.setValue("83rikp", 2, "AB", 23, rs[1].getInt(3));
            ee.setValue("83rikp", 2, "AB", 24, rs[1].getInt(4));
            ee.setValue("83rikp", 2, "AB", 25, rs[1].getInt(5));
            ee.setValue("83rikp", 2, "AB", 26, rs[1].getInt(6));
            ee.setValue("83rikp", 2, "AB", 27, rs[1].getInt(7));
            ee.setValue("83rikp", 2, "AB", 28, rs[1].getInt(8));
            ee.setValue("83rikp", 2, "AB", 29, rs[1].getInt(9));
            ee.setValue("83rikp", 2, "AB", 30, rs[1].getInt(10));
            ee.setValue("83rikp", 2, "AB", 31, rs[1].getInt(11));
            ee.setValue("83rikp", 2, "AB", 32, rs[1].getInt(12));
            ee.setValue("83rikp", 2, "AB", 33, rs[1].getInt(13));
            ee.setValue("83rikp", 2, "AB", 34, rs[1].getInt(14));
            ee.setValue("83rikp", 2, "AB", 35, rs[1].getInt(15));
            ee.setValue("83rikp", 2, "AB", 36, rs[1].getInt(16));
            ee.setValue("83rikp", 2, "AB", 37, rs[1].getInt(17));
            ee.setValue("83rikp", 2, "AB", 38, rs[1].getInt(18));
            ee.setValue("83rikp", 2, "AB", 39, rs[1].getInt(19));
            ee.setValue("83rikp", 2, "AB", 40, rs[1].getInt(20));
            ee.setValue("83rikp", 2, "AB", 41, rs[1].getInt(21));
            ee.setValue("83rikp", 2, "AB", 42, rs[1].getInt(22));
            ee.setValue("83rikp", 2, "AB", 43, rs[1].getInt(23));
            ee.setValue("83rikp", 2, "AB", 44, rs[1].getInt(24));
            ee.setValue("83rikp", 2, "AB", 45, rs[1].getInt(25));
            ee.setValue("83rikp", 2, "AB", 46, rs[1].getInt(26));
            ee.setValue("83rikp", 2, "AB", 47, rs[1].getInt(27));
            ee.setValue("83rikp", 2, "AB", 48, rs[1].getInt(28));
            ee.setValue("83rikp", 2, "AB", 49, rs[1].getInt(29));
            ee.setValue("83rikp", 2, "AB", 50, rs[1].getInt(30));
            ee.setValue("83rikp", 2, "AB", 51, rs[1].getInt(31));
            ee.setValue("83rikp", 2, "AB", 52, rs[1].getInt(32));
            ee.setValue("83rikp", 2, "AB", 53, rs[1].getInt(33));
            ee.setValue("83rikp", 2, "AB", 54, rs[1].getInt(34));
            ee.setValue("83rikp", 2, "AB", 55, rs[1].getInt(35));
            ee.setValue("83rikp", 2, "AB", 58, rs[1].getInt(36));
            ee.setValue("83rikp", 2, "AB", 60, rs[1].getInt(37));
        }
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/AD21-AD55_AD58_AD60.txt"));
        if (rs[1].first()) {

            ee.setValue("83rikp", 2, "AD", 21, rs[1].getInt(1));
            ee.setValue("83rikp", 2, "AD", 22, rs[1].getInt(2));
            ee.setValue("83rikp", 2, "AD", 23, rs[1].getInt(3));
            ee.setValue("83rikp", 2, "AD", 24, rs[1].getInt(4));
            ee.setValue("83rikp", 2, "AD", 25, rs[1].getInt(5));
            ee.setValue("83rikp", 2, "AD", 26, rs[1].getInt(6));
            ee.setValue("83rikp", 2, "AD", 27, rs[1].getInt(7));
            ee.setValue("83rikp", 2, "AD", 28, rs[1].getInt(8));
            ee.setValue("83rikp", 2, "AD", 29, rs[1].getInt(9));
            ee.setValue("83rikp", 2, "AD", 30, rs[1].getInt(10));
            ee.setValue("83rikp", 2, "AD", 31, rs[1].getInt(11));
            ee.setValue("83rikp", 2, "AD", 32, rs[1].getInt(12));
            ee.setValue("83rikp", 2, "AD", 33, rs[1].getInt(13));
            ee.setValue("83rikp", 2, "AD", 34, rs[1].getInt(14));
            ee.setValue("83rikp", 2, "AD", 35, rs[1].getInt(15));
            ee.setValue("83rikp", 2, "AD", 36, rs[1].getInt(16));
            ee.setValue("83rikp", 2, "AD", 37, rs[1].getInt(17));
            ee.setValue("83rikp", 2, "AD", 38, rs[1].getInt(18));
            ee.setValue("83rikp", 2, "AD", 39, rs[1].getInt(19));
            ee.setValue("83rikp", 2, "AD", 40, rs[1].getInt(20));
            ee.setValue("83rikp", 2, "AD", 41, rs[1].getInt(21));
            ee.setValue("83rikp", 2, "AD", 42, rs[1].getInt(22));
            ee.setValue("83rikp", 2, "AD", 43, rs[1].getInt(23));
            ee.setValue("83rikp", 2, "AD", 44, rs[1].getInt(24));
            ee.setValue("83rikp", 2, "AD", 45, rs[1].getInt(25));
            ee.setValue("83rikp", 2, "AD", 46, rs[1].getInt(26));
            ee.setValue("83rikp", 2, "AD", 47, rs[1].getInt(27));
            ee.setValue("83rikp", 2, "AD", 48, rs[1].getInt(28));
            ee.setValue("83rikp", 2, "AD", 49, rs[1].getInt(29));
            ee.setValue("83rikp", 2, "AD", 50, rs[1].getInt(30));
            ee.setValue("83rikp", 2, "AD", 51, rs[1].getInt(31));
            ee.setValue("83rikp", 2, "AD", 52, rs[1].getInt(32));
            ee.setValue("83rikp", 2, "AD", 53, rs[1].getInt(33));
            ee.setValue("83rikp", 2, "AD", 54, rs[1].getInt(34));
            ee.setValue("83rikp", 2, "AD", 55, rs[1].getInt(35));
            ee.setValue("83rikp", 2, "AD", 58, rs[1].getInt(36));
            ee.setValue("83rikp", 2, "AD", 60, rs[1].getInt(37));
        }
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/AF21-AF55_AF58_AF60.txt"));
        if (rs[1].first()) {

            ee.setValue("83rikp", 2, "AF", 21, rs[1].getInt(1));
            ee.setValue("83rikp", 2, "AF", 22, rs[1].getInt(2));
            ee.setValue("83rikp", 2, "AF", 23, rs[1].getInt(3));
            ee.setValue("83rikp", 2, "AF", 24, rs[1].getInt(4));
            ee.setValue("83rikp", 2, "AF", 25, rs[1].getInt(5));
            ee.setValue("83rikp", 2, "AF", 26, rs[1].getInt(6));
            ee.setValue("83rikp", 2, "AF", 27, rs[1].getInt(7));
            ee.setValue("83rikp", 2, "AF", 28, rs[1].getInt(8));
            ee.setValue("83rikp", 2, "AF", 29, rs[1].getInt(9));
            ee.setValue("83rikp", 2, "AF", 30, rs[1].getInt(10));
            ee.setValue("83rikp", 2, "AF", 31, rs[1].getInt(11));
            ee.setValue("83rikp", 2, "AF", 32, rs[1].getInt(12));
            ee.setValue("83rikp", 2, "AF", 33, rs[1].getInt(13));
            ee.setValue("83rikp", 2, "AF", 34, rs[1].getInt(14));
            ee.setValue("83rikp", 2, "AF", 35, rs[1].getInt(15));
            ee.setValue("83rikp", 2, "AF", 36, rs[1].getInt(16));
            ee.setValue("83rikp", 2, "AF", 37, rs[1].getInt(17));
            ee.setValue("83rikp", 2, "AF", 38, rs[1].getInt(18));
            ee.setValue("83rikp", 2, "AF", 39, rs[1].getInt(19));
            ee.setValue("83rikp", 2, "AF", 40, rs[1].getInt(20));
            ee.setValue("83rikp", 2, "AF", 41, rs[1].getInt(21));
            ee.setValue("83rikp", 2, "AF", 42, rs[1].getInt(22));
            ee.setValue("83rikp", 2, "AF", 43, rs[1].getInt(23));
            ee.setValue("83rikp", 2, "AF", 44, rs[1].getInt(24));
            ee.setValue("83rikp", 2, "AF", 45, rs[1].getInt(25));
            ee.setValue("83rikp", 2, "AF", 46, rs[1].getInt(26));
            ee.setValue("83rikp", 2, "AF", 47, rs[1].getInt(27));
            ee.setValue("83rikp", 2, "AF", 48, rs[1].getInt(28));
            ee.setValue("83rikp", 2, "AF", 49, rs[1].getInt(29));
            ee.setValue("83rikp", 2, "AF", 50, rs[1].getInt(30));
            ee.setValue("83rikp", 2, "AF", 51, rs[1].getInt(31));
            ee.setValue("83rikp", 2, "AF", 52, rs[1].getInt(32));
            ee.setValue("83rikp", 2, "AF", 53, rs[1].getInt(33));
            ee.setValue("83rikp", 2, "AF", 54, rs[1].getInt(34));
            ee.setValue("83rikp", 2, "AF", 55, rs[1].getInt(35));
            ee.setValue("83rikp", 2, "AF", 58, rs[1].getInt(36));
            ee.setValue("83rikp", 2, "AF", 60, rs[1].getInt(37));
        }
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/AG21-AG55_AG58_AG60.txt"));
        if (rs[1].first()) {

            ee.setValue("83rikp", 2, "AG", 21, rs[1].getInt(1));
            ee.setValue("83rikp", 2, "AG", 22, rs[1].getInt(2));
            ee.setValue("83rikp", 2, "AG", 23, rs[1].getInt(3));
            ee.setValue("83rikp", 2, "AG", 24, rs[1].getInt(4));
            ee.setValue("83rikp", 2, "AG", 25, rs[1].getInt(5));
            ee.setValue("83rikp", 2, "AG", 26, rs[1].getInt(6));
            ee.setValue("83rikp", 2, "AG", 27, rs[1].getInt(7));
            ee.setValue("83rikp", 2, "AG", 28, rs[1].getInt(8));
            ee.setValue("83rikp", 2, "AG", 29, rs[1].getInt(9));
            ee.setValue("83rikp", 2, "AG", 30, rs[1].getInt(10));
            ee.setValue("83rikp", 2, "AG", 31, rs[1].getInt(11));
            ee.setValue("83rikp", 2, "AG", 32, rs[1].getInt(12));
            ee.setValue("83rikp", 2, "AG", 33, rs[1].getInt(13));
            ee.setValue("83rikp", 2, "AG", 34, rs[1].getInt(14));
            ee.setValue("83rikp", 2, "AG", 35, rs[1].getInt(15));
            ee.setValue("83rikp", 2, "AG", 36, rs[1].getInt(16));
            ee.setValue("83rikp", 2, "AG", 37, rs[1].getInt(17));
            ee.setValue("83rikp", 2, "AG", 38, rs[1].getInt(18));
            ee.setValue("83rikp", 2, "AG", 39, rs[1].getInt(19));
            ee.setValue("83rikp", 2, "AG", 40, rs[1].getInt(20));
            ee.setValue("83rikp", 2, "AG", 41, rs[1].getInt(21));
            ee.setValue("83rikp", 2, "AG", 42, rs[1].getInt(22));
            ee.setValue("83rikp", 2, "AG", 43, rs[1].getInt(23));
            ee.setValue("83rikp", 2, "AG", 44, rs[1].getInt(24));
            ee.setValue("83rikp", 2, "AG", 45, rs[1].getInt(25));
            ee.setValue("83rikp", 2, "AG", 46, rs[1].getInt(26));
            ee.setValue("83rikp", 2, "AG", 47, rs[1].getInt(27));
            ee.setValue("83rikp", 2, "AG", 48, rs[1].getInt(28));
            ee.setValue("83rikp", 2, "AG", 49, rs[1].getInt(29));
            ee.setValue("83rikp", 2, "AG", 50, rs[1].getInt(30));
            ee.setValue("83rikp", 2, "AG", 51, rs[1].getInt(31));
            ee.setValue("83rikp", 2, "AG", 52, rs[1].getInt(32));
            ee.setValue("83rikp", 2, "AG", 53, rs[1].getInt(33));
            ee.setValue("83rikp", 2, "AG", 54, rs[1].getInt(34));
            ee.setValue("83rikp", 2, "AG", 55, rs[1].getInt(35));
            ee.setValue("83rikp", 2, "AG", 58, rs[1].getInt(36));
            ee.setValue("83rikp", 2, "AG", 60, rs[1].getInt(37));
        }
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/AH21-AH55_AH58_AH60.txt"));
        if (rs[1].first()) {

            ee.setValue("83rikp", 2, "AH", 21, rs[1].getInt(1));
            ee.setValue("83rikp", 2, "AH", 22, rs[1].getInt(2));
            ee.setValue("83rikp", 2, "AH", 23, rs[1].getInt(3));
            ee.setValue("83rikp", 2, "AH", 24, rs[1].getInt(4));
            ee.setValue("83rikp", 2, "AH", 25, rs[1].getInt(5));
            ee.setValue("83rikp", 2, "AH", 26, rs[1].getInt(6));
            ee.setValue("83rikp", 2, "AH", 27, rs[1].getInt(7));
            ee.setValue("83rikp", 2, "AH", 28, rs[1].getInt(8));
            ee.setValue("83rikp", 2, "AH", 29, rs[1].getInt(9));
            ee.setValue("83rikp", 2, "AH", 30, rs[1].getInt(10));
            ee.setValue("83rikp", 2, "AH", 31, rs[1].getInt(11));
            ee.setValue("83rikp", 2, "AH", 32, rs[1].getInt(12));
            ee.setValue("83rikp", 2, "AH", 33, rs[1].getInt(13));
            ee.setValue("83rikp", 2, "AH", 34, rs[1].getInt(14));
            ee.setValue("83rikp", 2, "AH", 35, rs[1].getInt(15));
            ee.setValue("83rikp", 2, "AH", 36, rs[1].getInt(16));
            ee.setValue("83rikp", 2, "AH", 37, rs[1].getInt(17));
            ee.setValue("83rikp", 2, "AH", 38, rs[1].getInt(18));
            ee.setValue("83rikp", 2, "AH", 39, rs[1].getInt(19));
            ee.setValue("83rikp", 2, "AH", 40, rs[1].getInt(20));
            ee.setValue("83rikp", 2, "AH", 41, rs[1].getInt(21));
            ee.setValue("83rikp", 2, "AH", 42, rs[1].getInt(22));
            ee.setValue("83rikp", 2, "AH", 43, rs[1].getInt(23));
            ee.setValue("83rikp", 2, "AH", 44, rs[1].getInt(24));
            ee.setValue("83rikp", 2, "AH", 45, rs[1].getInt(25));
            ee.setValue("83rikp", 2, "AH", 46, rs[1].getInt(26));
            ee.setValue("83rikp", 2, "AH", 47, rs[1].getInt(27));
            ee.setValue("83rikp", 2, "AH", 48, rs[1].getInt(28));
            ee.setValue("83rikp", 2, "AH", 49, rs[1].getInt(29));
            ee.setValue("83rikp", 2, "AH", 50, rs[1].getInt(30));
            ee.setValue("83rikp", 2, "AH", 51, rs[1].getInt(31));
            ee.setValue("83rikp", 2, "AH", 52, rs[1].getInt(32));
            ee.setValue("83rikp", 2, "AH", 53, rs[1].getInt(33));
            ee.setValue("83rikp", 2, "AH", 54, rs[1].getInt(34));
            ee.setValue("83rikp", 2, "AH", 55, rs[1].getInt(35));
            ee.setValue("83rikp", 2, "AH", 58, rs[1].getInt(36));
            ee.setValue("83rikp", 2, "AH", 60, rs[1].getInt(37));
        }
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/AI21-AI55_AI58-AI60.txt"));
        if (rs[1].first()) {

            ee.setValue("83rikp", 2, "AI", 21, rs[1].getInt(1));
            ee.setValue("83rikp", 2, "AI", 22, rs[1].getInt(2));
            ee.setValue("83rikp", 2, "AI", 23, rs[1].getInt(3));
            ee.setValue("83rikp", 2, "AI", 24, rs[1].getInt(4));
            ee.setValue("83rikp", 2, "AI", 25, rs[1].getInt(5));
            ee.setValue("83rikp", 2, "AI", 26, rs[1].getInt(6));
            ee.setValue("83rikp", 2, "AI", 27, rs[1].getInt(7));
            ee.setValue("83rikp", 2, "AI", 28, rs[1].getInt(8));
            ee.setValue("83rikp", 2, "AI", 29, rs[1].getInt(9));
            ee.setValue("83rikp", 2, "AI", 30, rs[1].getInt(10));
            ee.setValue("83rikp", 2, "AI", 31, rs[1].getInt(11));
            ee.setValue("83rikp", 2, "AI", 32, rs[1].getInt(12));
            ee.setValue("83rikp", 2, "AI", 33, rs[1].getInt(13));
            ee.setValue("83rikp", 2, "AI", 34, rs[1].getInt(14));
            ee.setValue("83rikp", 2, "AI", 35, rs[1].getInt(15));
            ee.setValue("83rikp", 2, "AI", 36, rs[1].getInt(16));
            ee.setValue("83rikp", 2, "AI", 37, rs[1].getInt(17));
            ee.setValue("83rikp", 2, "AI", 38, rs[1].getInt(18));
            ee.setValue("83rikp", 2, "AI", 39, rs[1].getInt(19));
            ee.setValue("83rikp", 2, "AI", 40, rs[1].getInt(20));
            ee.setValue("83rikp", 2, "AI", 41, rs[1].getInt(21));
            ee.setValue("83rikp", 2, "AI", 42, rs[1].getInt(22));
            ee.setValue("83rikp", 2, "AI", 43, rs[1].getInt(23));
            ee.setValue("83rikp", 2, "AI", 44, rs[1].getInt(24));
            ee.setValue("83rikp", 2, "AI", 45, rs[1].getInt(25));
            ee.setValue("83rikp", 2, "AI", 46, rs[1].getInt(26));
            ee.setValue("83rikp", 2, "AI", 47, rs[1].getInt(27));
            ee.setValue("83rikp", 2, "AI", 48, rs[1].getInt(28));
            ee.setValue("83rikp", 2, "AI", 49, rs[1].getInt(29));
            ee.setValue("83rikp", 2, "AI", 50, rs[1].getInt(30));
            ee.setValue("83rikp", 2, "AI", 51, rs[1].getInt(31));
            ee.setValue("83rikp", 2, "AI", 52, rs[1].getInt(32));
            ee.setValue("83rikp", 2, "AI", 53, rs[1].getInt(33));
            ee.setValue("83rikp", 2, "AI", 54, rs[1].getInt(34));
            ee.setValue("83rikp", 2, "AI", 55, rs[1].getInt(35));
            ee.setValue("83rikp", 2, "AI", 58, rs[1].getInt(36));
            ee.setValue("83rikp", 2, "AI", 60, rs[1].getInt(37));
        }
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/AJ21-AJ55_AJ58_AJ60.txt"));
        if (rs[1].first()) {

            ee.setValue("83rikp", 2, "AJ", 21, rs[1].getInt(1));
            ee.setValue("83rikp", 2, "AJ", 22, rs[1].getInt(2));
            ee.setValue("83rikp", 2, "AJ", 23, rs[1].getInt(3));
            ee.setValue("83rikp", 2, "AJ", 24, rs[1].getInt(4));
            ee.setValue("83rikp", 2, "AJ", 25, rs[1].getInt(5));
            ee.setValue("83rikp", 2, "AJ", 26, rs[1].getInt(6));
            ee.setValue("83rikp", 2, "AJ", 27, rs[1].getInt(7));
            ee.setValue("83rikp", 2, "AJ", 28, rs[1].getInt(8));
            ee.setValue("83rikp", 2, "AJ", 29, rs[1].getInt(9));
            ee.setValue("83rikp", 2, "AJ", 30, rs[1].getInt(10));
            ee.setValue("83rikp", 2, "AJ", 31, rs[1].getInt(11));
            ee.setValue("83rikp", 2, "AJ", 32, rs[1].getInt(12));
            ee.setValue("83rikp", 2, "AJ", 33, rs[1].getInt(13));
            ee.setValue("83rikp", 2, "AJ", 34, rs[1].getInt(14));
            ee.setValue("83rikp", 2, "AJ", 35, rs[1].getInt(15));
            ee.setValue("83rikp", 2, "AJ", 36, rs[1].getInt(16));
            ee.setValue("83rikp", 2, "AJ", 37, rs[1].getInt(17));
            ee.setValue("83rikp", 2, "AJ", 38, rs[1].getInt(18));
            ee.setValue("83rikp", 2, "AJ", 39, rs[1].getInt(19));
            ee.setValue("83rikp", 2, "AJ", 40, rs[1].getInt(20));
            ee.setValue("83rikp", 2, "AJ", 41, rs[1].getInt(21));
            ee.setValue("83rikp", 2, "AJ", 42, rs[1].getInt(22));
            ee.setValue("83rikp", 2, "AJ", 43, rs[1].getInt(23));
            ee.setValue("83rikp", 2, "AJ", 44, rs[1].getInt(24));
            ee.setValue("83rikp", 2, "AJ", 45, rs[1].getInt(25));
            ee.setValue("83rikp", 2, "AJ", 46, rs[1].getInt(26));
            ee.setValue("83rikp", 2, "AJ", 47, rs[1].getInt(27));
            ee.setValue("83rikp", 2, "AJ", 48, rs[1].getInt(28));
            ee.setValue("83rikp", 2, "AJ", 49, rs[1].getInt(29));
            ee.setValue("83rikp", 2, "AJ", 50, rs[1].getInt(30));
            ee.setValue("83rikp", 2, "AJ", 51, rs[1].getInt(31));
            ee.setValue("83rikp", 2, "AJ", 52, rs[1].getInt(32));
            ee.setValue("83rikp", 2, "AJ", 53, rs[1].getInt(33));
            ee.setValue("83rikp", 2, "AJ", 54, rs[1].getInt(34));
            ee.setValue("83rikp", 2, "AJ", 55, rs[1].getInt(35));
            ee.setValue("83rikp", 2, "AJ", 58, rs[1].getInt(36));
            ee.setValue("83rikp", 2, "AJ", 60, rs[1].getInt(37));
        }
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/AK21-AK55_AK58_AK60.txt"));
        if (rs[1].first()) {

            ee.setValue("83rikp", 2, "AK", 21, rs[1].getInt(1));
            ee.setValue("83rikp", 2, "AK", 22, rs[1].getInt(2));
            ee.setValue("83rikp", 2, "AK", 23, rs[1].getInt(3));
            ee.setValue("83rikp", 2, "AK", 24, rs[1].getInt(4));
            ee.setValue("83rikp", 2, "AK", 25, rs[1].getInt(5));
            ee.setValue("83rikp", 2, "AK", 26, rs[1].getInt(6));
            ee.setValue("83rikp", 2, "AK", 27, rs[1].getInt(7));
            ee.setValue("83rikp", 2, "AK", 28, rs[1].getInt(8));
            ee.setValue("83rikp", 2, "AK", 29, rs[1].getInt(9));
            ee.setValue("83rikp", 2, "AK", 30, rs[1].getInt(10));
            ee.setValue("83rikp", 2, "AK", 31, rs[1].getInt(11));
            ee.setValue("83rikp", 2, "AK", 32, rs[1].getInt(12));
            ee.setValue("83rikp", 2, "AK", 33, rs[1].getInt(13));
            ee.setValue("83rikp", 2, "AK", 34, rs[1].getInt(14));
            ee.setValue("83rikp", 2, "AK", 35, rs[1].getInt(15));
            ee.setValue("83rikp", 2, "AK", 36, rs[1].getInt(16));
            ee.setValue("83rikp", 2, "AK", 37, rs[1].getInt(17));
            ee.setValue("83rikp", 2, "AK", 38, rs[1].getInt(18));
            ee.setValue("83rikp", 2, "AK", 39, rs[1].getInt(19));
            ee.setValue("83rikp", 2, "AK", 40, rs[1].getInt(20));
            ee.setValue("83rikp", 2, "AK", 41, rs[1].getInt(21));
            ee.setValue("83rikp", 2, "AK", 42, rs[1].getInt(22));
            ee.setValue("83rikp", 2, "AK", 43, rs[1].getInt(23));
            ee.setValue("83rikp", 2, "AK", 44, rs[1].getInt(24));
            ee.setValue("83rikp", 2, "AK", 45, rs[1].getInt(25));
            ee.setValue("83rikp", 2, "AK", 46, rs[1].getInt(26));
            ee.setValue("83rikp", 2, "AK", 47, rs[1].getInt(27));
            ee.setValue("83rikp", 2, "AK", 48, rs[1].getInt(28));
            ee.setValue("83rikp", 2, "AK", 49, rs[1].getInt(29));
            ee.setValue("83rikp", 2, "AK", 50, rs[1].getInt(30));
            ee.setValue("83rikp", 2, "AK", 51, rs[1].getInt(31));
            ee.setValue("83rikp", 2, "AK", 52, rs[1].getInt(32));
            ee.setValue("83rikp", 2, "AK", 53, rs[1].getInt(33));
            ee.setValue("83rikp", 2, "AK", 54, rs[1].getInt(34));
            ee.setValue("83rikp", 2, "AK", 55, rs[1].getInt(35));
            ee.setValue("83rikp", 2, "AK", 58, rs[1].getInt(36));
            ee.setValue("83rikp", 2, "AK", 60, rs[1].getInt(37));
        }
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/AL21-AL55_AL58_AL60.txt"));
        if (rs[1].first()) {

            ee.setValue("83rikp", 2, "AL", 21, rs[1].getInt(1));
            ee.setValue("83rikp", 2, "AL", 22, rs[1].getInt(2));
            ee.setValue("83rikp", 2, "AL", 23, rs[1].getInt(3));
            ee.setValue("83rikp", 2, "AL", 24, rs[1].getInt(4));
            ee.setValue("83rikp", 2, "AL", 25, rs[1].getInt(5));
            ee.setValue("83rikp", 2, "AL", 26, rs[1].getInt(6));
            ee.setValue("83rikp", 2, "AL", 27, rs[1].getInt(7));
            ee.setValue("83rikp", 2, "AL", 28, rs[1].getInt(8));
            ee.setValue("83rikp", 2, "AL", 29, rs[1].getInt(9));
            ee.setValue("83rikp", 2, "AL", 30, rs[1].getInt(10));
            ee.setValue("83rikp", 2, "AL", 31, rs[1].getInt(11));
            ee.setValue("83rikp", 2, "AL", 32, rs[1].getInt(12));
            ee.setValue("83rikp", 2, "AL", 33, rs[1].getInt(13));
            ee.setValue("83rikp", 2, "AL", 34, rs[1].getInt(14));
            ee.setValue("83rikp", 2, "AL", 35, rs[1].getInt(15));
            ee.setValue("83rikp", 2, "AL", 36, rs[1].getInt(16));
            ee.setValue("83rikp", 2, "AL", 37, rs[1].getInt(17));
            ee.setValue("83rikp", 2, "AL", 38, rs[1].getInt(18));
            ee.setValue("83rikp", 2, "AL", 39, rs[1].getInt(19));
            ee.setValue("83rikp", 2, "AL", 40, rs[1].getInt(20));
            ee.setValue("83rikp", 2, "AL", 41, rs[1].getInt(21));
            ee.setValue("83rikp", 2, "AL", 42, rs[1].getInt(22));
            ee.setValue("83rikp", 2, "AL", 43, rs[1].getInt(23));
            ee.setValue("83rikp", 2, "AL", 44, rs[1].getInt(24));
            ee.setValue("83rikp", 2, "AL", 45, rs[1].getInt(25));
            ee.setValue("83rikp", 2, "AL", 46, rs[1].getInt(26));
            ee.setValue("83rikp", 2, "AL", 47, rs[1].getInt(27));
            ee.setValue("83rikp", 2, "AL", 48, rs[1].getInt(28));
            ee.setValue("83rikp", 2, "AL", 49, rs[1].getInt(29));
            ee.setValue("83rikp", 2, "AL", 50, rs[1].getInt(30));
            ee.setValue("83rikp", 2, "AL", 51, rs[1].getInt(31));
            ee.setValue("83rikp", 2, "AL", 52, rs[1].getInt(32));
            ee.setValue("83rikp", 2, "AL", 53, rs[1].getInt(33));
            ee.setValue("83rikp", 2, "AL", 54, rs[1].getInt(34));
            ee.setValue("83rikp", 2, "AL", 55, rs[1].getInt(35));
            ee.setValue("83rikp", 2, "AL", 58, rs[1].getInt(36));
            ee.setValue("83rikp", 2, "AL", 60, rs[1].getInt(37));
        }
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/P21-P55_P58_P60.txt"));
        if (rs[1].first()) {

            ee.setValue("83rikp", 2, "P", 21, rs[1].getInt(1));
            ee.setValue("83rikp", 2, "P", 22, rs[1].getInt(2));
            ee.setValue("83rikp", 2, "P", 23, rs[1].getInt(3));
            ee.setValue("83rikp", 2, "P", 24, rs[1].getInt(4));
            ee.setValue("83rikp", 2, "P", 25, rs[1].getInt(5));
            ee.setValue("83rikp", 2, "P", 26, rs[1].getInt(6));
            ee.setValue("83rikp", 2, "P", 27, rs[1].getInt(7));
            ee.setValue("83rikp", 2, "P", 28, rs[1].getInt(8));
            ee.setValue("83rikp", 2, "P", 29, rs[1].getInt(9));
            ee.setValue("83rikp", 2, "P", 30, rs[1].getInt(10));
            ee.setValue("83rikp", 2, "P", 31, rs[1].getInt(11));
            ee.setValue("83rikp", 2, "P", 32, rs[1].getInt(12));
            ee.setValue("83rikp", 2, "P", 33, rs[1].getInt(13));
            ee.setValue("83rikp", 2, "P", 34, rs[1].getInt(14));
            ee.setValue("83rikp", 2, "P", 35, rs[1].getInt(15));
            ee.setValue("83rikp", 2, "P", 36, rs[1].getInt(16));
            ee.setValue("83rikp", 2, "P", 37, rs[1].getInt(17));
            ee.setValue("83rikp", 2, "P", 38, rs[1].getInt(18));
            ee.setValue("83rikp", 2, "P", 39, rs[1].getInt(19));
            ee.setValue("83rikp", 2, "P", 40, rs[1].getInt(20));
            ee.setValue("83rikp", 2, "P", 41, rs[1].getInt(21));
            ee.setValue("83rikp", 2, "P", 42, rs[1].getInt(22));
            ee.setValue("83rikp", 2, "P", 43, rs[1].getInt(23));
            ee.setValue("83rikp", 2, "P", 44, rs[1].getInt(24));
            ee.setValue("83rikp", 2, "P", 45, rs[1].getInt(25));
            ee.setValue("83rikp", 2, "P", 46, rs[1].getInt(26));
            ee.setValue("83rikp", 2, "P", 47, rs[1].getInt(27));
            ee.setValue("83rikp", 2, "P", 48, rs[1].getInt(28));
            ee.setValue("83rikp", 2, "P", 49, rs[1].getInt(29));
            ee.setValue("83rikp", 2, "P", 50, rs[1].getInt(30));
            ee.setValue("83rikp", 2, "P", 51, rs[1].getInt(31));
            ee.setValue("83rikp", 2, "P", 52, rs[1].getInt(32));
            ee.setValue("83rikp", 2, "P", 53, rs[1].getInt(33));
            ee.setValue("83rikp", 2, "P", 54, rs[1].getInt(34));
            ee.setValue("83rikp", 2, "P", 55, rs[1].getInt(35));
            ee.setValue("83rikp", 2, "P", 58, rs[1].getInt(36));
            ee.setValue("83rikp", 2, "P", 60, rs[1].getInt(37));
        }
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/P61.txt"));
        if (rs[1].first()) {

            ee.setValue("83rikp", 2, "P", 61, rs[1].getInt(1));
        }
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/P62.txt"));
        if (rs[1].first()) {

            ee.setValue("83rikp", 2, "P", 62, rs[1].getInt(1));
        }
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/R21-R55_R58_R60.txt"));
        if (rs[1].first()) {

            ee.setValue("83rikp", 2, "R", 21, rs[1].getInt(1));
            ee.setValue("83rikp", 2, "R", 22, rs[1].getInt(2));
            ee.setValue("83rikp", 2, "R", 23, rs[1].getInt(3));
            ee.setValue("83rikp", 2, "R", 24, rs[1].getInt(4));
            ee.setValue("83rikp", 2, "R", 25, rs[1].getInt(5));
            ee.setValue("83rikp", 2, "R", 26, rs[1].getInt(6));
            ee.setValue("83rikp", 2, "R", 27, rs[1].getInt(7));
            ee.setValue("83rikp", 2, "R", 28, rs[1].getInt(8));
            ee.setValue("83rikp", 2, "R", 29, rs[1].getInt(9));
            ee.setValue("83rikp", 2, "R", 30, rs[1].getInt(10));
            ee.setValue("83rikp", 2, "R", 31, rs[1].getInt(11));
            ee.setValue("83rikp", 2, "R", 32, rs[1].getInt(12));
            ee.setValue("83rikp", 2, "R", 33, rs[1].getInt(13));
            ee.setValue("83rikp", 2, "R", 34, rs[1].getInt(14));
            ee.setValue("83rikp", 2, "R", 35, rs[1].getInt(15));
            ee.setValue("83rikp", 2, "R", 36, rs[1].getInt(16));
            ee.setValue("83rikp", 2, "R", 37, rs[1].getInt(17));
            ee.setValue("83rikp", 2, "R", 38, rs[1].getInt(18));
            ee.setValue("83rikp", 2, "R", 39, rs[1].getInt(19));
            ee.setValue("83rikp", 2, "R", 40, rs[1].getInt(20));
            ee.setValue("83rikp", 2, "R", 41, rs[1].getInt(21));
            ee.setValue("83rikp", 2, "R", 42, rs[1].getInt(22));
            ee.setValue("83rikp", 2, "R", 43, rs[1].getInt(23));
            ee.setValue("83rikp", 2, "R", 44, rs[1].getInt(24));
            ee.setValue("83rikp", 2, "R", 45, rs[1].getInt(25));
            ee.setValue("83rikp", 2, "R", 46, rs[1].getInt(26));
            ee.setValue("83rikp", 2, "R", 47, rs[1].getInt(27));
            ee.setValue("83rikp", 2, "R", 48, rs[1].getInt(28));
            ee.setValue("83rikp", 2, "R", 49, rs[1].getInt(29));
            ee.setValue("83rikp", 2, "R", 50, rs[1].getInt(30));
            ee.setValue("83rikp", 2, "R", 51, rs[1].getInt(31));
            ee.setValue("83rikp", 2, "R", 52, rs[1].getInt(32));
            ee.setValue("83rikp", 2, "R", 53, rs[1].getInt(33));
            ee.setValue("83rikp", 2, "R", 54, rs[1].getInt(34));
            ee.setValue("83rikp", 2, "R", 55, rs[1].getInt(35));
            ee.setValue("83rikp", 2, "R", 58, rs[1].getInt(36));
            ee.setValue("83rikp", 2, "R", 60, rs[1].getInt(37));
        }
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/S21-S55_S58_S60.txt"));
        if (rs[1].first()) {

            ee.setValue("83rikp", 2, "S", 21, rs[1].getInt(1));
            ee.setValue("83rikp", 2, "S", 22, rs[1].getInt(2));
            ee.setValue("83rikp", 2, "S", 23, rs[1].getInt(3));
            ee.setValue("83rikp", 2, "S", 24, rs[1].getInt(4));
            ee.setValue("83rikp", 2, "S", 25, rs[1].getInt(5));
            ee.setValue("83rikp", 2, "S", 26, rs[1].getInt(6));
            ee.setValue("83rikp", 2, "S", 27, rs[1].getInt(7));
            ee.setValue("83rikp", 2, "S", 28, rs[1].getInt(8));
            ee.setValue("83rikp", 2, "S", 29, rs[1].getInt(9));
            ee.setValue("83rikp", 2, "S", 30, rs[1].getInt(10));
            ee.setValue("83rikp", 2, "S", 31, rs[1].getInt(11));
            ee.setValue("83rikp", 2, "S", 32, rs[1].getInt(12));
            ee.setValue("83rikp", 2, "S", 33, rs[1].getInt(13));
            ee.setValue("83rikp", 2, "S", 34, rs[1].getInt(14));
            ee.setValue("83rikp", 2, "S", 35, rs[1].getInt(15));
            ee.setValue("83rikp", 2, "S", 36, rs[1].getInt(16));
            ee.setValue("83rikp", 2, "S", 37, rs[1].getInt(17));
            ee.setValue("83rikp", 2, "S", 38, rs[1].getInt(18));
            ee.setValue("83rikp", 2, "S", 39, rs[1].getInt(19));
            ee.setValue("83rikp", 2, "S", 40, rs[1].getInt(20));
            ee.setValue("83rikp", 2, "S", 41, rs[1].getInt(21));
            ee.setValue("83rikp", 2, "S", 42, rs[1].getInt(22));
            ee.setValue("83rikp", 2, "S", 43, rs[1].getInt(23));
            ee.setValue("83rikp", 2, "S", 44, rs[1].getInt(24));
            ee.setValue("83rikp", 2, "S", 45, rs[1].getInt(25));
            ee.setValue("83rikp", 2, "S", 46, rs[1].getInt(26));
            ee.setValue("83rikp", 2, "S", 47, rs[1].getInt(27));
            ee.setValue("83rikp", 2, "S", 48, rs[1].getInt(28));
            ee.setValue("83rikp", 2, "S", 49, rs[1].getInt(29));
            ee.setValue("83rikp", 2, "S", 50, rs[1].getInt(30));
            ee.setValue("83rikp", 2, "S", 51, rs[1].getInt(31));
            ee.setValue("83rikp", 2, "S", 52, rs[1].getInt(32));
            ee.setValue("83rikp", 2, "S", 53, rs[1].getInt(33));
            ee.setValue("83rikp", 2, "S", 54, rs[1].getInt(34));
            ee.setValue("83rikp", 2, "S", 55, rs[1].getInt(35));
            ee.setValue("83rikp", 2, "S", 58, rs[1].getInt(36));
            ee.setValue("83rikp", 2, "S", 60, rs[1].getInt(37));
        }
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/T21-T55_T58_T60.txt"));
        if (rs[1].first()) {

            ee.setValue("83rikp", 2, "T", 21, rs[1].getInt(1));
            ee.setValue("83rikp", 2, "T", 22, rs[1].getInt(2));
            ee.setValue("83rikp", 2, "T", 23, rs[1].getInt(3));
            ee.setValue("83rikp", 2, "T", 24, rs[1].getInt(4));
            ee.setValue("83rikp", 2, "T", 25, rs[1].getInt(5));
            ee.setValue("83rikp", 2, "T", 26, rs[1].getInt(6));
            ee.setValue("83rikp", 2, "T", 27, rs[1].getInt(7));
            ee.setValue("83rikp", 2, "T", 28, rs[1].getInt(8));
            ee.setValue("83rikp", 2, "T", 29, rs[1].getInt(9));
            ee.setValue("83rikp", 2, "T", 30, rs[1].getInt(10));
            ee.setValue("83rikp", 2, "T", 31, rs[1].getInt(11));
            ee.setValue("83rikp", 2, "T", 32, rs[1].getInt(12));
            ee.setValue("83rikp", 2, "T", 33, rs[1].getInt(13));
            ee.setValue("83rikp", 2, "T", 34, rs[1].getInt(14));
            ee.setValue("83rikp", 2, "T", 35, rs[1].getInt(15));
            ee.setValue("83rikp", 2, "T", 36, rs[1].getInt(16));
            ee.setValue("83rikp", 2, "T", 37, rs[1].getInt(17));
            ee.setValue("83rikp", 2, "T", 38, rs[1].getInt(18));
            ee.setValue("83rikp", 2, "T", 39, rs[1].getInt(19));
            ee.setValue("83rikp", 2, "T", 40, rs[1].getInt(20));
            ee.setValue("83rikp", 2, "T", 41, rs[1].getInt(21));
            ee.setValue("83rikp", 2, "T", 42, rs[1].getInt(22));
            ee.setValue("83rikp", 2, "T", 43, rs[1].getInt(23));
            ee.setValue("83rikp", 2, "T", 44, rs[1].getInt(24));
            ee.setValue("83rikp", 2, "T", 45, rs[1].getInt(25));
            ee.setValue("83rikp", 2, "T", 46, rs[1].getInt(26));
            ee.setValue("83rikp", 2, "T", 47, rs[1].getInt(27));
            ee.setValue("83rikp", 2, "T", 48, rs[1].getInt(28));
            ee.setValue("83rikp", 2, "T", 49, rs[1].getInt(29));
            ee.setValue("83rikp", 2, "T", 50, rs[1].getInt(30));
            ee.setValue("83rikp", 2, "T", 51, rs[1].getInt(31));
            ee.setValue("83rikp", 2, "T", 52, rs[1].getInt(32));
            ee.setValue("83rikp", 2, "T", 53, rs[1].getInt(33));
            ee.setValue("83rikp", 2, "T", 54, rs[1].getInt(34));
            ee.setValue("83rikp", 2, "T", 55, rs[1].getInt(35));
            ee.setValue("83rikp", 2, "T", 58, rs[1].getInt(36));
            ee.setValue("83rikp", 2, "T", 60, rs[1].getInt(37));
        }
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/U21-U55_U58_U60.txt"));
        if (rs[1].first()) {

            ee.setValue("83rikp", 2, "U", 21, rs[1].getInt(1));
            ee.setValue("83rikp", 2, "U", 22, rs[1].getInt(2));
            ee.setValue("83rikp", 2, "U", 23, rs[1].getInt(3));
            ee.setValue("83rikp", 2, "U", 24, rs[1].getInt(4));
            ee.setValue("83rikp", 2, "U", 25, rs[1].getInt(5));
            ee.setValue("83rikp", 2, "U", 26, rs[1].getInt(6));
            ee.setValue("83rikp", 2, "U", 27, rs[1].getInt(7));
            ee.setValue("83rikp", 2, "U", 28, rs[1].getInt(8));
            ee.setValue("83rikp", 2, "U", 29, rs[1].getInt(9));
            ee.setValue("83rikp", 2, "U", 30, rs[1].getInt(10));
            ee.setValue("83rikp", 2, "U", 31, rs[1].getInt(11));
            ee.setValue("83rikp", 2, "U", 32, rs[1].getInt(12));
            ee.setValue("83rikp", 2, "U", 33, rs[1].getInt(13));
            ee.setValue("83rikp", 2, "U", 34, rs[1].getInt(14));
            ee.setValue("83rikp", 2, "U", 35, rs[1].getInt(15));
            ee.setValue("83rikp", 2, "U", 36, rs[1].getInt(16));
            ee.setValue("83rikp", 2, "U", 37, rs[1].getInt(17));
            ee.setValue("83rikp", 2, "U", 38, rs[1].getInt(18));
            ee.setValue("83rikp", 2, "U", 39, rs[1].getInt(19));
            ee.setValue("83rikp", 2, "U", 40, rs[1].getInt(20));
            ee.setValue("83rikp", 2, "U", 41, rs[1].getInt(21));
            ee.setValue("83rikp", 2, "U", 42, rs[1].getInt(22));
            ee.setValue("83rikp", 2, "U", 43, rs[1].getInt(23));
            ee.setValue("83rikp", 2, "U", 44, rs[1].getInt(24));
            ee.setValue("83rikp", 2, "U", 45, rs[1].getInt(25));
            ee.setValue("83rikp", 2, "U", 46, rs[1].getInt(26));
            ee.setValue("83rikp", 2, "U", 47, rs[1].getInt(27));
            ee.setValue("83rikp", 2, "U", 48, rs[1].getInt(28));
            ee.setValue("83rikp", 2, "U", 49, rs[1].getInt(29));
            ee.setValue("83rikp", 2, "U", 50, rs[1].getInt(30));
            ee.setValue("83rikp", 2, "U", 51, rs[1].getInt(31));
            ee.setValue("83rikp", 2, "U", 52, rs[1].getInt(32));
            ee.setValue("83rikp", 2, "U", 53, rs[1].getInt(33));
            ee.setValue("83rikp", 2, "U", 54, rs[1].getInt(34));
            ee.setValue("83rikp", 2, "U", 55, rs[1].getInt(35));
            ee.setValue("83rikp", 2, "U", 58, rs[1].getInt(36));
            ee.setValue("83rikp", 2, "U", 60, rs[1].getInt(37));
        }
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/V21-V55.txt"));
        if (rs[1].first()) {

            ee.setValue("83rikp", 2, "V", 21, rs[1].getInt(1));
            ee.setValue("83rikp", 2, "V", 22, rs[1].getInt(2));
            ee.setValue("83rikp", 2, "V", 23, rs[1].getInt(3));
            ee.setValue("83rikp", 2, "V", 24, rs[1].getInt(4));
            ee.setValue("83rikp", 2, "V", 25, rs[1].getInt(5));
            ee.setValue("83rikp", 2, "V", 26, rs[1].getInt(6));
            ee.setValue("83rikp", 2, "V", 27, rs[1].getInt(7));
            ee.setValue("83rikp", 2, "V", 28, rs[1].getInt(8));
            ee.setValue("83rikp", 2, "V", 29, rs[1].getInt(9));
            ee.setValue("83rikp", 2, "V", 30, rs[1].getInt(10));
            ee.setValue("83rikp", 2, "V", 31, rs[1].getInt(11));
            ee.setValue("83rikp", 2, "V", 32, rs[1].getInt(12));
            ee.setValue("83rikp", 2, "V", 33, rs[1].getInt(13));
            ee.setValue("83rikp", 2, "V", 34, rs[1].getInt(14));
            ee.setValue("83rikp", 2, "V", 35, rs[1].getInt(15));
            ee.setValue("83rikp", 2, "V", 36, rs[1].getInt(16));
            ee.setValue("83rikp", 2, "V", 37, rs[1].getInt(17));
            ee.setValue("83rikp", 2, "V", 38, rs[1].getInt(18));
            ee.setValue("83rikp", 2, "V", 39, rs[1].getInt(19));
            ee.setValue("83rikp", 2, "V", 40, rs[1].getInt(20));
            ee.setValue("83rikp", 2, "V", 41, rs[1].getInt(21));
            ee.setValue("83rikp", 2, "V", 42, rs[1].getInt(22));
            ee.setValue("83rikp", 2, "V", 43, rs[1].getInt(23));
            ee.setValue("83rikp", 2, "V", 44, rs[1].getInt(24));
            ee.setValue("83rikp", 2, "V", 45, rs[1].getInt(25));
            ee.setValue("83rikp", 2, "V", 46, rs[1].getInt(26));
            ee.setValue("83rikp", 2, "V", 47, rs[1].getInt(27));
            ee.setValue("83rikp", 2, "V", 48, rs[1].getInt(28));
            ee.setValue("83rikp", 2, "V", 49, rs[1].getInt(29));
            ee.setValue("83rikp", 2, "V", 50, rs[1].getInt(30));
            ee.setValue("83rikp", 2, "V", 51, rs[1].getInt(31));
            ee.setValue("83rikp", 2, "V", 52, rs[1].getInt(32));
            ee.setValue("83rikp", 2, "V", 53, rs[1].getInt(33));
            ee.setValue("83rikp", 2, "V", 54, rs[1].getInt(34));
            ee.setValue("83rikp", 2, "V", 55, rs[1].getInt(35));
        }
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/W21-W55.txt"));
        if (rs[1].first()) {

            ee.setValue("83rikp", 2, "W", 21, rs[1].getInt(1));
            ee.setValue("83rikp", 2, "W", 22, rs[1].getInt(2));
            ee.setValue("83rikp", 2, "W", 23, rs[1].getInt(3));
            ee.setValue("83rikp", 2, "W", 24, rs[1].getInt(4));
            ee.setValue("83rikp", 2, "W", 25, rs[1].getInt(5));
            ee.setValue("83rikp", 2, "W", 26, rs[1].getInt(6));
            ee.setValue("83rikp", 2, "W", 27, rs[1].getInt(7));
            ee.setValue("83rikp", 2, "W", 28, rs[1].getInt(8));
            ee.setValue("83rikp", 2, "W", 29, rs[1].getInt(9));
            ee.setValue("83rikp", 2, "W", 30, rs[1].getInt(10));
            ee.setValue("83rikp", 2, "W", 31, rs[1].getInt(11));
            ee.setValue("83rikp", 2, "W", 32, rs[1].getInt(12));
            ee.setValue("83rikp", 2, "W", 33, rs[1].getInt(13));
            ee.setValue("83rikp", 2, "W", 34, rs[1].getInt(14));
            ee.setValue("83rikp", 2, "W", 35, rs[1].getInt(15));
            ee.setValue("83rikp", 2, "W", 36, rs[1].getInt(16));
            ee.setValue("83rikp", 2, "W", 37, rs[1].getInt(17));
            ee.setValue("83rikp", 2, "W", 38, rs[1].getInt(18));
            ee.setValue("83rikp", 2, "W", 39, rs[1].getInt(19));
            ee.setValue("83rikp", 2, "W", 40, rs[1].getInt(20));
            ee.setValue("83rikp", 2, "W", 41, rs[1].getInt(21));
            ee.setValue("83rikp", 2, "W", 42, rs[1].getInt(22));
            ee.setValue("83rikp", 2, "W", 43, rs[1].getInt(23));
            ee.setValue("83rikp", 2, "W", 44, rs[1].getInt(24));
            ee.setValue("83rikp", 2, "W", 45, rs[1].getInt(25));
            ee.setValue("83rikp", 2, "W", 46, rs[1].getInt(26));
            ee.setValue("83rikp", 2, "W", 47, rs[1].getInt(27));
            ee.setValue("83rikp", 2, "W", 48, rs[1].getInt(28));
            ee.setValue("83rikp", 2, "W", 49, rs[1].getInt(29));
            ee.setValue("83rikp", 2, "W", 50, rs[1].getInt(30));
            ee.setValue("83rikp", 2, "W", 51, rs[1].getInt(31));
            ee.setValue("83rikp", 2, "W", 52, rs[1].getInt(32));
            ee.setValue("83rikp", 2, "W", 53, rs[1].getInt(33));
            ee.setValue("83rikp", 2, "W", 54, rs[1].getInt(34));
            ee.setValue("83rikp", 2, "W", 55, rs[1].getInt(35));
        }
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/X21_X27-X55.txt"));
        if (rs[1].first()) {

            ee.setValue("83rikp", 2, "X", 21, rs[1].getInt(1));
            ee.setValue("83rikp", 2, "X", 27, rs[1].getInt(2));
            ee.setValue("83rikp", 2, "X", 28, rs[1].getInt(3));
            ee.setValue("83rikp", 2, "X", 29, rs[1].getInt(4));
            ee.setValue("83rikp", 2, "X", 30, rs[1].getInt(5));
            ee.setValue("83rikp", 2, "X", 31, rs[1].getInt(6));
            ee.setValue("83rikp", 2, "X", 32, rs[1].getInt(7));
            ee.setValue("83rikp", 2, "X", 33, rs[1].getInt(8));
            ee.setValue("83rikp", 2, "X", 34, rs[1].getInt(9));
            ee.setValue("83rikp", 2, "X", 35, rs[1].getInt(10));
            ee.setValue("83rikp", 2, "X", 36, rs[1].getInt(11));
            ee.setValue("83rikp", 2, "X", 37, rs[1].getInt(12));
            ee.setValue("83rikp", 2, "X", 38, rs[1].getInt(13));
            ee.setValue("83rikp", 2, "X", 39, rs[1].getInt(14));
            ee.setValue("83rikp", 2, "X", 40, rs[1].getInt(15));
            ee.setValue("83rikp", 2, "X", 41, rs[1].getInt(16));
            ee.setValue("83rikp", 2, "X", 42, rs[1].getInt(17));
            ee.setValue("83rikp", 2, "X", 43, rs[1].getInt(18));
            ee.setValue("83rikp", 2, "X", 44, rs[1].getInt(19));
            ee.setValue("83rikp", 2, "X", 45, rs[1].getInt(20));
            ee.setValue("83rikp", 2, "X", 46, rs[1].getInt(21));
            ee.setValue("83rikp", 2, "X", 47, rs[1].getInt(22));
            ee.setValue("83rikp", 2, "X", 48, rs[1].getInt(23));
            ee.setValue("83rikp", 2, "X", 49, rs[1].getInt(24));
            ee.setValue("83rikp", 2, "X", 50, rs[1].getInt(25));
            ee.setValue("83rikp", 2, "X", 51, rs[1].getInt(26));
            ee.setValue("83rikp", 2, "X", 52, rs[1].getInt(27));
            ee.setValue("83rikp", 2, "X", 53, rs[1].getInt(28));
            ee.setValue("83rikp", 2, "X", 54, rs[1].getInt(29));
            ee.setValue("83rikp", 2, "X", 55, rs[1].getInt(30));
        }
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/Y21_Y27-Y55.txt"));
        if (rs[1].first()) {

            ee.setValue("83rikp", 2, "Y", 21, rs[1].getInt(1));
            ee.setValue("83rikp", 2, "Y", 27, rs[1].getInt(2));
            ee.setValue("83rikp", 2, "Y", 28, rs[1].getInt(3));
            ee.setValue("83rikp", 2, "Y", 29, rs[1].getInt(4));
            ee.setValue("83rikp", 2, "Y", 30, rs[1].getInt(5));
            ee.setValue("83rikp", 2, "Y", 31, rs[1].getInt(6));
            ee.setValue("83rikp", 2, "Y", 32, rs[1].getInt(7));
            ee.setValue("83rikp", 2, "Y", 33, rs[1].getInt(8));
            ee.setValue("83rikp", 2, "Y", 34, rs[1].getInt(9));
            ee.setValue("83rikp", 2, "Y", 35, rs[1].getInt(10));
            ee.setValue("83rikp", 2, "Y", 36, rs[1].getInt(11));
            ee.setValue("83rikp", 2, "Y", 37, rs[1].getInt(12));
            ee.setValue("83rikp", 2, "Y", 38, rs[1].getInt(13));
            ee.setValue("83rikp", 2, "Y", 39, rs[1].getInt(14));
            ee.setValue("83rikp", 2, "Y", 40, rs[1].getInt(15));
            ee.setValue("83rikp", 2, "Y", 41, rs[1].getInt(16));
            ee.setValue("83rikp", 2, "Y", 42, rs[1].getInt(17));
            ee.setValue("83rikp", 2, "Y", 43, rs[1].getInt(18));
            ee.setValue("83rikp", 2, "Y", 44, rs[1].getInt(19));
            ee.setValue("83rikp", 2, "Y", 45, rs[1].getInt(20));
            ee.setValue("83rikp", 2, "Y", 46, rs[1].getInt(21));
            ee.setValue("83rikp", 2, "Y", 47, rs[1].getInt(22));
            ee.setValue("83rikp", 2, "Y", 48, rs[1].getInt(23));
            ee.setValue("83rikp", 2, "Y", 49, rs[1].getInt(24));
            ee.setValue("83rikp", 2, "Y", 50, rs[1].getInt(25));
            ee.setValue("83rikp", 2, "Y", 51, rs[1].getInt(26));
            ee.setValue("83rikp", 2, "Y", 52, rs[1].getInt(27));
            ee.setValue("83rikp", 2, "Y", 53, rs[1].getInt(28));
            ee.setValue("83rikp", 2, "Y", 54, rs[1].getInt(29));
            ee.setValue("83rikp", 2, "Y", 55, rs[1].getInt(30));
        }
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/Z21-Z55_Z58_Z60.txt"));
        if (rs[1].first()) {

            ee.setValue("83rikp", 2, "Z", 21, rs[1].getInt(1));
            ee.setValue("83rikp", 2, "Z", 22, rs[1].getInt(2));
            ee.setValue("83rikp", 2, "Z", 23, rs[1].getInt(3));
            ee.setValue("83rikp", 2, "Z", 24, rs[1].getInt(4));
            ee.setValue("83rikp", 2, "Z", 25, rs[1].getInt(5));
            ee.setValue("83rikp", 2, "Z", 26, rs[1].getInt(6));
            ee.setValue("83rikp", 2, "Z", 27, rs[1].getInt(7));
            ee.setValue("83rikp", 2, "Z", 28, rs[1].getInt(8));
            ee.setValue("83rikp", 2, "Z", 29, rs[1].getInt(9));
            ee.setValue("83rikp", 2, "Z", 30, rs[1].getInt(10));
            ee.setValue("83rikp", 2, "Z", 31, rs[1].getInt(11));
            ee.setValue("83rikp", 2, "Z", 32, rs[1].getInt(12));
            ee.setValue("83rikp", 2, "Z", 33, rs[1].getInt(13));
            ee.setValue("83rikp", 2, "Z", 34, rs[1].getInt(14));
            ee.setValue("83rikp", 2, "Z", 35, rs[1].getInt(15));
            ee.setValue("83rikp", 2, "Z", 36, rs[1].getInt(16));
            ee.setValue("83rikp", 2, "Z", 37, rs[1].getInt(17));
            ee.setValue("83rikp", 2, "Z", 38, rs[1].getInt(18));
            ee.setValue("83rikp", 2, "Z", 39, rs[1].getInt(19));
            ee.setValue("83rikp", 2, "Z", 40, rs[1].getInt(20));
            ee.setValue("83rikp", 2, "Z", 41, rs[1].getInt(21));
            ee.setValue("83rikp", 2, "Z", 42, rs[1].getInt(22));
            ee.setValue("83rikp", 2, "Z", 43, rs[1].getInt(23));
            ee.setValue("83rikp", 2, "Z", 44, rs[1].getInt(24));
            ee.setValue("83rikp", 2, "Z", 45, rs[1].getInt(25));
            ee.setValue("83rikp", 2, "Z", 46, rs[1].getInt(26));
            ee.setValue("83rikp", 2, "Z", 47, rs[1].getInt(27));
            ee.setValue("83rikp", 2, "Z", 48, rs[1].getInt(28));
            ee.setValue("83rikp", 2, "Z", 49, rs[1].getInt(29));
            ee.setValue("83rikp", 2, "Z", 50, rs[1].getInt(30));
            ee.setValue("83rikp", 2, "Z", 51, rs[1].getInt(31));
            ee.setValue("83rikp", 2, "Z", 52, rs[1].getInt(32));
            ee.setValue("83rikp", 2, "Z", 53, rs[1].getInt(33));
            ee.setValue("83rikp", 2, "Z", 54, rs[1].getInt(34));
            ee.setValue("83rikp", 2, "Z", 55, rs[1].getInt(35));
            ee.setValue("83rikp", 2, "Z", 58, rs[1].getInt(36));
            ee.setValue("83rikp", 2, "Z", 60, rs[1].getInt(37));
        }
    }
}
