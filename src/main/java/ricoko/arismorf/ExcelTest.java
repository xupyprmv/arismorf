/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ricoko.arismorf;

import ricoko.arismorf.extractors.ExtractorOsh1;

/**
 *
 * @author XupyprMV
 */
public class ExcelTest {
    public static void main(String[] args) {
        ExcelExport ee = new ExcelExport();
        try {
            ExtractorOsh1.extract(MySQL.getConnection(), null, ee);
            ee.saveExportedWorkBooks(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
