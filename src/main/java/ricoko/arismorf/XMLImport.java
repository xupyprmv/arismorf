package ricoko.arismorf;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Парсер входных данных из АРИСМО в Формате XML
 * 
 * @author maksimenkov (xupypr@xupypr.com)
 */
public class XMLImport extends DefaultHandler {

    private String tempVal;
    private Map<String, String> tempEl;
    private List<String> sql;

    public XMLImport() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        super();
        sql = new ArrayList<String>();
    }

    public void parseDocument() throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        sp.parse("./arismo/sch6_class.xml", this);

        Connection dbConnection = MySQL.getConnection();
        Statement statement = dbConnection.createStatement();
        StringBuilder start = new StringBuilder();
        start.append("INSERT INTO sch6_class (");
        for (String att : atts) {
            if (att.equals(atts[0])) {
                start.append(att);
            } else {
                start.append(", ").append(att);
            }
        }
        start.append(") VALUES( ");
        String sb = start.toString();
        String se = ");";
        for (String s : sql) {
            statement.addBatch(String.format("%s%s%s", sb,s,se));
        }
        statement.executeBatch();
    }
    // Поля которые нужно вытаскивать
    private String[] atts = {
        "SYS_FLDORDER",
        "SYS_GUID",
        "SYS_STATE",
        "SYS_REV",
        "SYS_CREATED"};

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        tempVal = "";
        if (qName.equalsIgnoreCase("GRADES")) {
            tempEl = new HashMap<String, String>();
            for (String att : atts) {
                tempEl.put(att, attributes.getValue(att));
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
        if (qName.equalsIgnoreCase("GRADES")) {
            StringBuilder insert = new StringBuilder();
            for (String att : atts) {
                if (att.equals(atts[0])) {
                    insert.append("'").append(tempEl.get(att)).append("'");
                } else {
                    insert.append(", '").append(tempEl.get(att)).append("'");
                }
            }
            sql.add(insert.toString());
        }
    }
}
