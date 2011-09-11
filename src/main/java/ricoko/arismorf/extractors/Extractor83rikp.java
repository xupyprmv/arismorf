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
    
}
