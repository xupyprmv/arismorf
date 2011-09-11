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
        
        extractPart1();

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

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/AA21-AA55_AA58_AA60.txt"));
        rs[1].first();

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
        
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/AB21-AB55_AB58_AB60.txt"));
        rs[1].first();

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
        
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/AD21-AD55_AD58_AD60.txt"));
        rs[1].first();

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
        
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/AF21-AF55_AF58_AF60.txt"));
        rs[1].first();

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
        
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/AG21-AG55_AG58_AG60.txt"));
        rs[1].first();

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
        
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/AH21-AH55_AH58_AH60.txt"));
        rs[1].first();

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
        
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/AI21-AI55_AI58-AI60.txt"));
        rs[1].first();

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
        
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/AJ21-AJ55_AJ58_AJ60.txt"));
        rs[1].first();

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
        
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/AK21-AK55_AK58_AK60.txt"));
        rs[1].first();

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
        
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/AL21-AL55_AL58_AL60.txt"));
        rs[1].first();

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
        
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/P21-P55_P58_P60.txt"));
        rs[1].first();

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
        
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/P61.txt"));
        rs[1].first();

        ee.setValue("83rikp", 2, "P", 61, rs[1].getInt(1));
        
        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/P62.txt"));
        rs[1].first();

        ee.setValue("83rikp", 2, "P", 62, rs[1].getInt(1));

        rs[1] = s[1].executeQuery(ExcelExport.getSQLFromFile("./resources/sql/83rikp/1/R21-R55_R58_R60.txt"));
        rs[1].first();

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
}
