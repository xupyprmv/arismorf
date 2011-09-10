/*
 * MainForm.java
 *
 * Основная форма приложения
 */
package ricoko.arismorf;

import java.io.File;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.text.DefaultCaret;

/**
 * @author maksimenkov (xupypr@xupypr.com)
 */
public class MainForm extends javax.swing.JFrame {

    public static final String YEAR = "2010";

    /** Creates new form MainForm */
    public MainForm() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logScrollPane = new javax.swing.JScrollPane();
        logTextArea = new javax.swing.JTextArea();
        logLabel = new javax.swing.JLabel();
        mainMenu = new javax.swing.JMenuBar();
        convAtoMButton = new javax.swing.JMenu();
        importARISMO = new javax.swing.JMenuItem();
        exportMORF = new javax.swing.JMenuItem();
        separator1 = new javax.swing.JMenu();
        convMtoAButton = new javax.swing.JMenu();
        separator2 = new javax.swing.JMenu();
        databaseButton = new javax.swing.JMenu();
        reloadDictionariesButton = new javax.swing.JMenuItem();
        refreshDatabaseButton = new javax.swing.JMenuItem();
        separator3 = new javax.swing.JMenu();
        helpButton = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Конвертатор: АРИСМО <-> МОРФ");

        logTextArea.setColumns(20);
        logTextArea.setEditable(false);
        logTextArea.setRows(5);
        logTextArea.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                logTextAreaInputMethodTextChanged(evt);
            }
        });
        logScrollPane.setViewportView(logTextArea);
        DefaultCaret caret = (DefaultCaret)logTextArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        logLabel.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        logLabel.setText("Журнал :");

        mainMenu.setName("MainMenu"); // NOI18N

        convAtoMButton.setText("АРИСМО -> МОРФ");

        importARISMO.setText("Импорт из АРИСМО (xml)");
        importARISMO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                importARISMOMouseClicked(evt);
            }
        });
        importARISMO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importARISMOActionPerformed(evt);
            }
        });
        convAtoMButton.add(importARISMO);

        exportMORF.setText("Экспорт в МОРФ (xls)");
        exportMORF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exportMORFMouseClicked(evt);
            }
        });
        exportMORF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportMORFActionPerformed(evt);
            }
        });
        convAtoMButton.add(exportMORF);

        mainMenu.add(convAtoMButton);

        separator1.setText("|");
        separator1.setEnabled(false);
        mainMenu.add(separator1);

        convMtoAButton.setText("МОРФ -> АРИСМО");
        convMtoAButton.setEnabled(false);
        mainMenu.add(convMtoAButton);

        separator2.setText("|");
        separator2.setEnabled(false);
        mainMenu.add(separator2);

        databaseButton.setText("База данных");

        reloadDictionariesButton.setText("Обновить справочники");
        reloadDictionariesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadDictionariesButtonActionPerformed(evt);
            }
        });
        databaseButton.add(reloadDictionariesButton);

        refreshDatabaseButton.setText("Очистить базу");
        refreshDatabaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshDatabaseButtonActionPerformed(evt);
            }
        });
        databaseButton.add(refreshDatabaseButton);

        mainMenu.add(databaseButton);

        separator3.setText("|");
        separator3.setEnabled(false);
        mainMenu.add(separator3);

        helpButton.setText("Помощь");
        mainMenu.add(helpButton);

        setJMenuBar(mainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
                    .addComponent(logLabel, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void exportMORFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportMORFMouseClicked
}//GEN-LAST:event_exportMORFMouseClicked

private void importARISMOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_importARISMOMouseClicked
}//GEN-LAST:event_importARISMOMouseClicked

private void importARISMOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importARISMOActionPerformed
    final JFrame jf = this;
    Thread t = new Thread(new Runnable() {

        @Override
        public void run() {
            try {
                JFileChooser fc = new JFileChooser();
                int returnVal = fc.showOpenDialog(jf);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    XMLImport.getInstance(logTextArea, true).parseDocument(file);
                }
            } catch (Exception e) {
                logTextArea.append("Ошибка импорта: " + e.getMessage() + "\n");
                for (StackTraceElement ste : e.getStackTrace()) {
                    logTextArea.append(ste.toString() + "\n");
                }
            }
        }
    });
    t.start();
}//GEN-LAST:event_importARISMOActionPerformed

private void exportMORFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportMORFActionPerformed
    Thread t = new Thread(new Runnable() {

        @Override
        public void run() {
            try {
                Extractor.extract(MySQL.getConnection(), logTextArea);
            } catch (Exception e) {
                logTextArea.append("Ошибка экспорта: " + e.getMessage() + "\n");
                for (StackTraceElement ste : e.getStackTrace()) {
                    logTextArea.append(ste.toString() + "\n");
                }
            }
        }
    });
    t.start();
}//GEN-LAST:event_exportMORFActionPerformed

private void logTextAreaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_logTextAreaInputMethodTextChanged
// TODO add your handling code here:
}//GEN-LAST:event_logTextAreaInputMethodTextChanged

private void refreshDatabaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshDatabaseButtonActionPerformed

    final JFrame jf = this;
    Thread t = new Thread(new Runnable() {

        @Override
        public void run() {
            try {
                Connection connection = MySQL.getConnection();
                Statement statement = connection.createStatement();
                logTextArea.append("Очищаю базу данных \n");
                statement.execute("DROP DATABASE arismorf;");
                statement.execute("CREATE DATABASE arismorf;");
                statement.execute("USE arismorf;");
                logTextArea.append("База данных очищена \n");
                statement.close();
                DatabaseStructure.dispose();
                logTextArea.append("Восстанавливаю структуру таблиц \n");
                XMLImport.getInstance(logTextArea, false).parseInit();
                logTextArea.append("Структура таблиц восстановлена \n");
                logTextArea.append("Восстанавливаю справочники \n");
                XMLImport.getInstance(logTextArea, false).parseDocument(new File("./resources/db/dirs-openschool.xml"));
                logTextArea.append("Справочники восстановлены \n");
            } catch (Exception e) {
                logTextArea.append("Ошибка: " + e.getMessage() + "\n");
                for (StackTraceElement ste : e.getStackTrace()) {
                    logTextArea.append(ste.toString() + "\n");
                }
            }
        }
    });
    t.start();
}//GEN-LAST:event_refreshDatabaseButtonActionPerformed

private void reloadDictionariesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadDictionariesButtonActionPerformed
    importARISMOActionPerformed(evt);
}//GEN-LAST:event_reloadDictionariesButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {
        MySQL.startMySQL();
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu convAtoMButton;
    private javax.swing.JMenu convMtoAButton;
    private javax.swing.JMenu databaseButton;
    private javax.swing.JMenuItem exportMORF;
    private javax.swing.JMenu helpButton;
    private javax.swing.JMenuItem importARISMO;
    private javax.swing.JLabel logLabel;
    private javax.swing.JScrollPane logScrollPane;
    private javax.swing.JTextArea logTextArea;
    private javax.swing.JMenuBar mainMenu;
    private javax.swing.JMenuItem refreshDatabaseButton;
    private javax.swing.JMenuItem reloadDictionariesButton;
    private javax.swing.JMenu separator1;
    private javax.swing.JMenu separator2;
    private javax.swing.JMenu separator3;
    // End of variables declaration//GEN-END:variables
}
