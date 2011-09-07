package ricoko.arismorf;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author maksimenkov (xupypr@xupypr.com) 
 */
public class XMLTest {
    public static void main(String[] args) {
        try {
            MySQL.startMySQL(); 
            XMLImport i = new XMLImport();
            i.parseDocument(); 
            Connection dbConnection = MySQL.getConnection();
            Statement statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM sch6_class;");
            rs.first();
            System.out.println("Записей в таблице: "+rs.getInt(1));
            MySQL.stopMySQL();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }    
}
