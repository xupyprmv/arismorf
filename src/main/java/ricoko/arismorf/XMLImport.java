package ricoko.arismorf;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ricoko.arismorf.DatabaseStructure.Field;

/**
 * Парсер входных данных из АР�?СМО в Формате XML
 * 
 * @author maksimenkov (xupypr@xupypr.com)
 */
public class XMLImport extends DefaultHandler {

    private String tempVal;
    private DatabaseStructure dbs;
    private Statement statement;
    private int counter = 0;
    private JTextArea log;
    private static XMLImport instance;
    private boolean dictionaries = false;

    private XMLImport() {
        super();
    }

    public static XMLImport getInstance(JTextArea logTextArea, boolean needInit) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, ParserConfigurationException, SAXException, IOException {
        if (instance == null) {
            instance = new XMLImport();
            instance.log = logTextArea;
            if (instance.log != null) {
                instance.log.append("Подключаюсь к базе данных.\n");
            }
            instance.statement = MySQL.getConnection().createStatement();
            instance.dbs = DatabaseStructure.getInstance();
            if (!instance.dbs.initialized && needInit) {
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
        if (file.getName().equals("dirs-openschool.xml")) {
            dictionaries = true;
        }
                
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        sp.parse(file, this);
        if (counter > 0) {
            statement.executeBatch();
            if (instance.log != null) {
                instance.log.append("Записей проимпортировано : " + counter + "\n");
            }
            counter = 0;
        }
        if (instance.log!=null) {
            instance.log.append("Удаление записей не относящихся к году: " + MainForm.YEAR + "\n");
        }
        statement.execute("DELETE FROM EGEEXTPARTICIPANTS WHERE `SYS_GUIDFK` IN (SELECT SYS_GUID FROM PARTICIPANTS WHERE `SYS_GUIDFK` NOT IN (SELECT `SYS_GUID` FROM GRADES));");
        statement.execute("DELETE FROM PARTICIPANTS WHERE `SYS_GUIDFK` NOT IN (SELECT `SYS_GUID` FROM GRADES);");
//        statement.execute("DELETE FROM PARTICIPANTS LEFT JOIN GRADES ON (PARTICIPANTS.SYS_GUIDFK = GRADES.SYS_GUID) WHERE (GRADES.SYS_GUID IS NULL)");

        if (instance.log != null) {
            instance.log.append("�?мпорт завершен.\n");
        }
        dictionaries = false;
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

        instance.dbs.createAllTables(MySQL.getConnection(), instance.log);

        if (instance.log != null) {
            instance.log.append("�?нициализация завершена.\n");
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
        } else if (qName.equalsIgnoreCase("SYS_FIELDS")) {
            String tableName = dbs.tableGUIDMap.get(attributes.getValue("SYS_GUIDFK"));
            Field f = new Field(attributes.getValue("NAME"), attributes.getValue("TYPE"));
            if (f.type != null) {
                dbs.structure.get(tableName).add(f);
            }
        } else if (qName.equalsIgnoreCase("SYS_INDEXES")) {
             dbs.indexGUIDMap.put(attributes.getValue("SYS_GUID"), attributes.getValue("SYS_GUIDFK"));
        } else if (qName.equalsIgnoreCase("SYS_INDEXFLDS")) {
             String index =dbs.indexGUIDMap.get(attributes.getValue("SYS_GUIDFK"));
             String tablename = dbs.tableGUIDMap.get(index);
             for (Field f:dbs.structure.get(tablename)) {
                 if (f.name.equals(attributes.getValue("FNAME"))) {
                     f.index = true;
                 }
             }
        } else {
            // Данные по записям таблиц
            for (String tableName : dbs.structure.keySet()) {
                if (qName.equalsIgnoreCase(tableName)) {
                    // �?мпорт записей
                    if (dictionaries 
                            || tableName.equals("PARTICIPANTS")
                            || tableName.equals("EGEEXTPARTICIPANTS")
                            || (attributes.getValue("SYS_GUIDFK") != null && attributes.getValue("SYS_GUIDFK").startsWith(MainForm.YEAR))
                            || (attributes.getValue("SYS_GUID") != null && attributes.getValue("SYS_GUID").startsWith(MainForm.YEAR))) {
                        try {
                            String sql = dbs.getInsertScript(qName, attributes);
                                statement.addBatch(sql);
                                counter++;
                                if (counter % 100 == 0) {
                                    if (instance.log != null) {
                                        instance.log.append("Записей проимпортировано : " + counter + "\n");
                                    }
                                    statement.executeBatch();
                                }
                        } catch (Exception ex) {
                            throw new IllegalStateException(ex);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        tempVal = new String(ch, start, length);
    }
}
