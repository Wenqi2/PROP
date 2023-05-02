/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacio;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Classe feta per Joban
 */
public class vistaResultatConsultaDS extends javax.swing.JFrame {
    private DefaultListModel listModel;
    private String titol, autor;
    int k;
    private int selecti = -1;
    ArrayList<String> docs;
    
    /**
     * @constructor Crea una instancia de la vistaResultatConsultaDS
     */
    public vistaResultatConsultaDS() {
        initComponents();
    }
    
    /**
     * @constructor Crea una instancia de la vistaResultatConsultaDS
     * @param t És el titol seleccionat a la vistaConsultaDocSemblants
     * @param a És l'autor seleccionat a la vistaConsultaDocSemblants
     * @param ki És el nombre de documents seleccionat a la vistaConsultaDocSemblants
     */
    public vistaResultatConsultaDS(String t, String a, int ki) {
        initComponents();
        this.listModel = new DefaultListModel();
        this.titol = t;
        this.autor = a;
        this.k = ki;
        iniLabel();
        mostraRes();
        this.setLocationRelativeTo(null);
    }
    
    /**
     * Inicia els labels
     */
    public void iniLabel() {
        if (k == 1) jLabel1.setText("El doucument més semblant és:");
        else jLabel1.setText("Els " + k + " doucuments més semblants són:");
    }
    
    /**
     * Afageix a la llista el resultat de fer la consulta amb documents semblants
     */
    /*
    public void mostraRes() {
        try{
            listModel = CtrlPresentacio.docsSemblantsVista(titol, autor, k);
            jList1.setModel(listModel);
        }
        catch(Exception ex) {
            System.out.println("error imprimir");
        }
    }
    */
    
    public void mostraRes() {
        try{
            docs = CtrlPresentacio.docsSemblantsVistaArray(titol, autor, k);           
            int mida = docs.size();
            for (int i = 0 ; i < mida; i+=2 ){
                listModel.addElement("<html>Títol: {" + docs.get(i) + "}" + "<br/>Autor: {" + docs.get(i+1) + "}");
            }
            jList1.setModel(listModel);
        }
        catch(Exception ex) {
            System.out.println("error imprimir");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Resultat");
        setResizable(false);

        jButton1.setText("<-");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        jLabel1.setText("jLabel1");

        jButton3.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        jButton3.setText("Copiar Document");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        jButton4.setText("Modificar Document");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        jButton5.setText("Exportar Document");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        jButton2.setText("Eliminar Document");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Crida la vistaConsultaDocSemblants
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        vistaConsultaDocSemblants vistaCDS = new vistaConsultaDocSemblants();
        vistaCDS.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        selecti = jList1.getSelectedIndex();
        if (selecti == -1) JOptionPane.showMessageDialog(null,"Escull un document");
               
        else {
            String t = docs.get(2*selecti);
            String a = docs.get((2*selecti)+1);
            vistaConsultaCopiarDoc vistaCCD = new vistaConsultaCopiarDoc(t, a, 2);
            vistaCCD.setVisible(true);
            this.dispose();
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        selecti = jList1.getSelectedIndex();
        if (selecti == -1) JOptionPane.showMessageDialog(null,"Escull un document");
               
        else {
            String t = docs.get(2*selecti);
            String a = docs.get((2*selecti)+1);
            vistaConsultaModificaDoc vistaCMD = new vistaConsultaModificaDoc(t, a, 2);
            vistaCMD.setVisible(true);
            this.dispose();  
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        selecti = jList1.getSelectedIndex();
        if (selecti == -1) JOptionPane.showMessageDialog(null,"Escull una document");              
        else {
            String t = docs.get(2*selecti);
            String a = docs.get((2*selecti)+1);
            System.out.println("El titol es: " + t +"i l'autor es: " + a);
            vistaConsultaExportar vistaCE = new vistaConsultaExportar(t, a, 2);
            vistaCE.setVisible(true);
            this.dispose();
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        selecti = jList1.getSelectedIndex();
        if (selecti == -1) JOptionPane.showMessageDialog(null,"Escull un document");              
        else {
            String t = docs.get(2*selecti);
            String a = docs.get((2*selecti)+1);
            
            if(CtrlPresentacio.ExisteixDoc(t, a)){
                CtrlPresentacio.bajaDoc(t,a);
                JOptionPane.showMessageDialog(null,"Document Eliminat");
            }
            else JOptionPane.showMessageDialog(null,"Document no existeix");
            
            mostraRes();
        }
        vistaConsultaDocSemblants vistaCDS = new vistaConsultaDocSemblants();
        vistaCDS.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(vistaResultatConsultaDS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaResultatConsultaDS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaResultatConsultaDS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaResultatConsultaDS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaResultatConsultaDS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
