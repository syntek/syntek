/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testdocx4j;

import java.io.File;
import java.util.Vector;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ABC
 */
public class ChooseFile extends javax.swing.JFrame {

    /**
     * Creates new form ChooseFile
     */
    public static Vector<String> pathFile = new Vector<>();
    public static Vector<String> fileName = new Vector<>();

    public ChooseFile() {
        initComponents();
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter(".docx", "docx");
        fileChoose.setFileFilter(extensionFilter);
    }

    public void getPathandName() {
        File[] file = fileChoose.getSelectedFiles();
        for (int i = 0; i < file.length; i++) {
            pathFile.add(file[i].getPath());
            fileName.add(file[i].getName());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChoose = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileChoose.setSelectedFile(new java.io.File("E:\\"));
            fileChoose.setMultiSelectionEnabled(true);
            fileChoose.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    fileChooseActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(fileChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(fileChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void fileChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooseActionPerformed
        // TODO add your handling code here:
        getPathandName();
        Them t = new Them();
        t.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_fileChooseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChooseFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChooseFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChooseFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChooseFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChooseFile().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser fileChoose;
    // End of variables declaration//GEN-END:variables
}
