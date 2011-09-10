package ricoko.arismorf;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывыающий структуру данных
 * 
 * @author maksimenkov (xupypr@xupypr.com) 
 */
public class DatabaseStructure {

    public static enum FieldType {
        VARCHAR, BIGINT, DOUBLE, BLOB, DATETIME, DATE
    }

    public static class Field {

        public String name;
        public FieldType type;
        public boolean index = false;

        public Field(String name, FieldType type) {
            this.name = name;
            this.type = type;
        }

        public Field(String name, String dType) {
            this.name = name;
            if (dType.equals("Integer")) {
                this.type = FieldType.BIGINT;
            } else if (dType.equals("HyperLink")) {
                this.type = FieldType.VARCHAR;
            } else if (dType.equals("String")) {
                this.type = FieldType.VARCHAR;
            } else if (dType.equals("Lookup")) {
                this.type = FieldType.BIGINT;
            } else if (dType.equals("Memo")) {
                this.type = FieldType.BLOB;
            } else if (dType.equals("Numeric")) {
                this.type = FieldType.DOUBLE;
            } else if (dType.equals("Boolean")) {
                this.type = FieldType.BIGINT;
            } else if (dType.equals("Date")) {
                this.type = FieldType.DATE;
            } else if (dType.equals("Datetime")) {
                this.type = FieldType.DATETIME;
            } else if (dType.equals("CheckComboBox")) {
                this.type = FieldType.BIGINT;
            } else if (dType.equals("Group")) {
                // Игнорим группы
            } else if (dType.equals("File")) {
                // Игнорим файлы
            } else {
                throw new IllegalStateException("Unknown field type: "+dType);
            }
        }
    }
    
    public Map<String, List<Field>> structure = new HashMap<String, List<Field>>();
    public Map<String, String> tableGUIDMap = new HashMap<String, String>();
    
    public boolean initialized = false;
    public SimpleDateFormat arismoSDF = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
    public SimpleDateFormat mysqlSDF = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public SimpleDateFormat tarismoSDF = new SimpleDateFormat("dd.MM.yyyy");
    public SimpleDateFormat tmysqlSDF = new SimpleDateFormat("yyyy-MM-dd");
    
    private static DatabaseStructure instance;

    private DatabaseStructure() {
    }

    public static DatabaseStructure getInstance() {
        if (instance == null) {
            instance = new DatabaseStructure();
        } 
        return instance;
    }

    public String getCreateScript(String tableName) {
        StringBuilder result = new StringBuilder();
        result.append("CREATE TABLE IF NOT EXISTS `").append(tableName).append("` ("); 
        boolean first = true;
        for (Field f : structure.get(tableName)) {
            result.append((first)?"`":",`").append(f.name).append("` ").append((f.type.equals(FieldType.VARCHAR))?"VARCHAR(255)":f.type);            
            result.append(("SYS_GUID".equals(f.name))?" PRIMARY KEY":"");
            first = false;
        }
        result.append(");");
        return result.toString();
    }
    
    public String getInsertScript(String tableName, Map<String, String> values) throws ParseException {
        StringBuilder result = new StringBuilder();
        result.append("REPLACE INTO ").append(tableName).append(" (");
        boolean first = true;
        for (Field f : structure.get(tableName)) {
            result.append((first)?"`":",`").append(f.name).append("`");
            first = false;
        }
        first = true;
        result.append(" ) VALUES (");
        for (Field f : structure.get(tableName)) {
            if (f.type.equals(FieldType.DATETIME) || f.type.equals(FieldType.DATE)) {
                String date = values.get(f.name);
                if (date==null || date.equals("")) {
                    result.append((first)?"":",").append("NULL");
                } else {
                    if (f.type.equals(FieldType.DATETIME)) {
                        date = mysqlSDF.format(arismoSDF.parse(date));
                    } else {
                        date = tmysqlSDF.format(tarismoSDF.parse(date));
                    }
                    result.append((first)?"":",").append("'").append(date).append("'");
                }
            } else if (f.type.equals(FieldType.VARCHAR) || f.type.equals(FieldType.BLOB)) {
                f.name = f.name.replace("'", "\"");
                result.append((first)?"":",").append("'").append(values.get(f.name)).append("'");
            } else {
                result.append((first)?"":",").append((values.get(f.name)==null || values.get(f.name).equals(""))?"NULL":values.get(f.name));
            }
            first = false;
        }
        result.append(");");
        return result.toString();
    }

    public void createAllTables(Connection connection) throws SQLException {
        for (String tableName:structure.keySet()) {
            Statement statement = connection.createStatement();
            statement.execute(getCreateScript(tableName));
            statement.close();        
        }
    }
}
