package ricoko.arismorf;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JTextArea;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ricoko.arismorf.DatabaseStructure.Field;

/**
 * Парсер входных данных из АРИСМО в Формате XML
 * 
 * @author maksimenkov (xupypr@xupypr.com)
 */
public class XMLImport extends DefaultHandler {

    private String tempVal;
    private Map<String, String> tempEl;
    private String table;
    private DatabaseStructure dbs;
    private Statement statement;
    private int counter = 0;
    private int zcounter = 0;
    private JTextArea log;
    private static XMLImport instance;

    private XMLImport() {
        super();
    }

    public static XMLImport getInstance(JTextArea logTextArea) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, ParserConfigurationException, SAXException, IOException {
        if (instance == null) {
            instance = new XMLImport();
            instance.log = logTextArea;
            if (instance.log != null) {
                instance.log.append("Подключаюсь к базе данных.\n");
            }
            instance.statement = MySQL.getConnection().createStatement();
            instance.dbs = DatabaseStructure.getInstance();
            if (!instance.dbs.initialized) {
                // Считываем структуру только при первой инициализации
                instance.parseInit();
                instance.dbs.initialized = true;
            }
        }
        return instance;
    }

    void parseDocument(File file) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        if (instance.log != null) {
            instance.log.append("Начинаю импорт.\n");
        }
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        sp.parse(file, this);
        if (counter > 0) {
            statement.executeBatch();
            if (instance.log != null) {
                instance.log.append("Записей проимпортировано : " + zcounter + "\n");
            }
        }
        instance.log.append("Удаление записей не относящихся к году: " + MainForm.YEAR + "\n");
        statement.execute("DELETE FROM PARTICIPANTS WHERE `SYS_GUIDFK` NOT IN (SELECT `SYS_GUID` FROM GRADES);");
//        statement.execute("DELETE FROM PARTICIPANTS LEFT JOIN GRADES ON (PARTICIPANTS.SYS_GUIDFK = GRADES.SYS_GUID) WHERE (GRADES.SYS_GUID IS NULL)");

        if (instance.log != null) {
            instance.log.append("Импорт завершен.\n");
        }
    }

    void parseInit() throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        if (instance.log != null) {
            instance.log.append("Начинаю инициализацию.\n");
        }
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        sp.parse(new File("./resources/db/init.xml"), this);
        
        if (instance.log != null) {
            instance.log.append("Конфигурация считана. Начинаю проверку таблиц.\n");
        }
        
        instance.dbs.createAllTables(MySQL.getConnection());

        if (instance.log != null) {
            instance.log.append("Инициализация завершена.\n");
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        tempVal = "";
        // Данные по структуре таблиц
        if (qName.equalsIgnoreCase("SYS_TABLES")) {
            dbs.structure.put(attributes.getValue("NAME"), new ArrayList<Field>());
            dbs.tableGUIDMap.put(attributes.getValue("SYS_GUID"), attributes.getValue("NAME"));
            dbs.structure.get(attributes.getValue("NAME")).add(new Field("SYS_FLDORDER", DatabaseStructure.FieldType.BIGINT));
            dbs.structure.get(attributes.getValue("NAME")).add(new Field("SYS_GUID", DatabaseStructure.FieldType.VARCHAR));
            dbs.structure.get(attributes.getValue("NAME")).add(new Field("SYS_STATE", DatabaseStructure.FieldType.BIGINT));
            dbs.structure.get(attributes.getValue("NAME")).add(new Field("SYS_REV", DatabaseStructure.FieldType.BIGINT));
            dbs.structure.get(attributes.getValue("NAME")).add(new Field("SYS_CREATED", DatabaseStructure.FieldType.DATETIME));
            dbs.structure.get(attributes.getValue("NAME")).add(new Field("SYS_UPDATED", DatabaseStructure.FieldType.DATETIME));
            dbs.structure.get(attributes.getValue("NAME")).add(new Field("SYS_CREATOR", DatabaseStructure.FieldType.VARCHAR));
            dbs.structure.get(attributes.getValue("NAME")).add(new Field("SYS_USER", DatabaseStructure.FieldType.VARCHAR));
            dbs.structure.get(attributes.getValue("NAME")).add(new Field("SYS_GUIDFK", DatabaseStructure.FieldType.VARCHAR));
            dbs.structure.get(attributes.getValue("NAME")).add(new Field("SYS_PARENTGUID", DatabaseStructure.FieldType.VARCHAR));
        }
        if (qName.equalsIgnoreCase("SYS_FIELDS")) {
            String tableName = dbs.tableGUIDMap.get(attributes.getValue("SYS_GUIDFK"));
            Field f = new Field(attributes.getValue("NAME"), attributes.getValue("TYPE"));
            if (f.type != null) {
                dbs.structure.get(tableName).add(f);
            }
        }

        // Данные по записям таблиц
        for (String tableName : dbs.structure.keySet()) {
            if (qName.equalsIgnoreCase(tableName)) {
                table = qName;
                tempEl = new HashMap<String, String>();
                for (Field f : dbs.structure.get(tableName)) {
                    tempEl.put(f.name, attributes.getValue(f.name));
                }
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        tempVal = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName,
            String qName) throws SAXException {
        // Импорт записей
        for (String tableName : dbs.structure.keySet()) {
            if (qName.equalsIgnoreCase(tableName)) {
                if (tableName.equals("PARTICIPANTS") || (tempEl.get("SYS_GUIDFK") != null && tempEl.get("SYS_GUIDFK").startsWith(MainForm.YEAR))
                        || (tempEl.get("SYS_GUID") != null && tempEl.get("SYS_GUID").startsWith(MainForm.YEAR))) {
                    try {
                        String sql = dbs.getInsertScript(tableName, tempEl);
                        try {
                            statement.addBatch(sql);
                            counter++;
                            zcounter++;
                            if (counter == 1) {
                                if (instance.log != null) {
                                    instance.log.append("Записей проимпортировано : " + zcounter + "\n");
                                }
                                counter = 0;
                                statement.executeBatch();
                            }
                        } catch (SQLException ex) {
                            throw new IllegalStateException(ex);
                        }
                    } catch (ParseException ex) {
                        throw new IllegalStateException(ex);
                    }
                }
            }
        }
    }
}
