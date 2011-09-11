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

/**
 * @author maksimenkov (xupypr@xupypr.com)
 */
public class MySQL {

    private static MysqldResource mysql;
    private static File dbFile;
    private static Connection dbConnection;
        
    public static Connection getConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
            if (dbConnection==null) {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3307/", "root", "");
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

            Map<Object,Object> options = new HashMap<Object,Object>();
            options.put("port", "3307");
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
