package ricoko.arismorf;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextArea;

/**
 * Экстрактор - достаёт заранее импортированные из АРИСМО данные
 * и вставляет их в формы МОРФ
 * 
 * @author maksimenkov (xupypr@xupypr.com) 
 */
public class Extractor {

    private static String getSQLFromFile(String path) throws IOException {
        FileInputStream stream = new FileInputStream(new File(path));
        try {
            FileChannel fc = stream.getChannel();
            MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
            fc.close();
            stream.close();
            return Charset.defaultCharset().decode(bb).toString();
        } finally {
            stream.close();
        }
    }

    public static void extract(Connection c, JTextArea log) throws SQLException, FileNotFoundException, IOException {
        ExcelExport ee = new ExcelExport();

        if (log != null) {
            log.append("Заполняю форму ОШ 1.\n");
        }
        ResultSet[] rs = new ResultSet[20];
        Statement[] s = new Statement[20];
        for (int i = 0; i < 20; i++) {
            s[i] = c.createStatement();
        }

        // ФОРМА ОШ 1

        // РАЗДЕЛ 3
        rs[1] = s[1].executeQuery(getSQLFromFile("./resources/sql/osh1/3/grades.txt"));
        rs[1].first();
        rs[2] = s[2].executeQuery(getSQLFromFile("./resources/sql/osh1/3/grades_complete_1-4.txt"));
        rs[2].first();
        rs[3] = s[3].executeQuery(getSQLFromFile("./resources/sql/osh1/3/grades_complete_5-9.txt"));
        rs[3].first();
        rs[4] = s[4].executeQuery(getSQLFromFile("./resources/sql/osh1/3/podgot_class.txt"));
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
        
        rs[1] = s[1].executeQuery(getSQLFromFile("./resources/sql/osh1/3/grades_complete_less14.txt"));
        rs[1].first();
        rs[2] = s[2].executeQuery(getSQLFromFile("./resources/sql/osh1/3/grades_complete_less25.txt"));
        rs[2].first();
        rs[3] = s[3].executeQuery(getSQLFromFile("./resources/sql/osh1/3/grades_less_14.txt"));
        rs[3].first();
        rs[4] = s[4].executeQuery(getSQLFromFile("./resources/sql/osh1/3/grades_less_25.txt"));
        rs[4].first();
        ee.setValue("osh1", 4, "P", 25, rs[1].getInt(1) + rs[2].getInt(1) + rs[3].getInt(1) + rs[4].getInt(1));

        if (log != null) {
            log.append("Выполнено 9/9.\n");
        }



        ee.saveExportedWorkBooks(log);

        if (log != null) {
            log.append("Экпорт завершен. Результаты экспорта располагаются в папке export.\n");
        }
        for (int i = 0; i < 20; i++) {
            s[i].close();
        }
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(new File("export"));
	}
    }
}
