/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ricoko.arismorf;

/**
 *
 * @author XupyprMV
 */
public class ExcelTest {
    public static void main(String[] args) {
        ExcelExport ee = new ExcelExport();
        try {
            ee.setValue("76rik", 0, "X", 29, "111!!! Ку");
            ee.setValue("76rik", 2, "P", 22, 123);
            ee.saveExportedWorkBooks();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
