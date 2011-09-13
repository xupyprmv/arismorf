/*
 * Встроенный MySQL
 */
package ricoko.arismorf;

import com.mysql.management.MysqldResource;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author maksimenkov (xupypr@xupypr.com)
 */
public class MySQL {

    private static MysqldResource mysql;
    private static File dbFile;
    private static Connection dbConnection;

    public static Connection getConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        if (dbConnection == null) {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Properties properties = new Properties();
            properties.setProperty("user", "root");
            properties.setProperty("password", "");
            properties.setProperty("useUnicode", "false");
            properties.setProperty("characterEncoding", "cp1251");
            
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3307/", properties);
            
            Statement armf = dbConnection.createStatement();
            armf.execute("GRANT ALL PRIVILEGES ON *.* TO arismorf@localhost IDENTIFIED BY 'arismorf' WITH GRANT OPTION;");
            armf.execute("GRANT ALL PRIVILEGES ON *.* TO arismorf@\"%\" IDENTIFIED BY 'arismorf' WITH GRANT OPTION;");

            armf.close();
            dbConnection.close();
            
            // Переконнектимся другим пользователем (для корректной работы кодировки)
            properties.setProperty("user", "arismorf");
            properties.setProperty("password", "arismorf");
            
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3307/", properties);
            
            Statement statement = dbConnection.createStatement();
            statement.execute("CREATE DATABASE IF NOT EXISTS arismorf CHARACTER SET=cp1251;");
            statement.execute("SET NAMES cp1251;");
            statement.execute("USE arismorf;");
            statement.close();
            //DatabaseStructure.getInstance().createAllTables(dbConnection);
        }
        return dbConnection;
    }

    public static void startMySQL() throws Exception {
        if (mysql == null) {
            dbFile = new File("./db/arismorf");

            Map<Object, Object> options = new HashMap<Object, Object>();
            options.put("port", "3307");
            options.put("basedir", dbFile.getAbsolutePath());
            options.put("datadir", dbFile.getAbsolutePath()+"/data");
            options.put("socket", dbFile.getAbsolutePath()+"/mysql.sock");
            mysql = new MysqldResource(dbFile);
            mysql.start("arismorf", options);
            //Thread.sleep(2000);
        }
    }

    public static void stopMySQL() throws Exception {
        if (mysql != null) {
            mysql.shutdown();
            mysql = null;
        }
    }
}
