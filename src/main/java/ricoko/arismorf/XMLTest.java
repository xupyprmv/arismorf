package ricoko.arismorf;

import java.io.File;
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
            XMLImport i = XMLImport.getInstance(null, true);
            i.parseDocument(new File("./arismo/openschool_07.09.2011.xml")); 
            Connection dbConnection = MySQL.getConnection();
            Statement statement = dbConnection.createStatement();
            statement.execute("SET NAMES cp1251;");
            ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM ADDITIONALDATA;");
            rs.first();
            System.out.println("Записей в таблице: "+rs.getInt(1));
            ResultSet rs2 = statement.executeQuery("SELECT COUNT(*) FROM PARTICIPANTS WHERE SEX='Ж';");
            rs2.first();
            System.out.println("Записей в таблице: "+rs2.getInt(1));
            ResultSet rs3 = statement.executeQuery("SELECT * FROM PARTICIPANTS LIMIT 1;");
            rs3.first();
            System.out.println("Записей в таблице: "+rs3.getInt(1));
            MySQL.stopMySQL();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }    
}
