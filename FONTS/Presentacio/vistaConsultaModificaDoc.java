/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacio;

import javax.swing.JOptionPane;

/**
 *
 * @author Classe feta per Joban
 */
public class vistaConsultaModificaDoc extends javax.swing.JFrame {
    private String titol;
    private String autor;
    private int ret;
    private String NouTitol = "";
    private String NouAutor = "";
    private String NouContingut = "";
    
    /**
     * @constructor Crea una instancia de la vistaConsultaModificaDoc
     */
    public vistaConsultaModificaDoc() {
        initComponents();
    }
    
    /**
     * @constructor Crea una instancia de la vistaConsultaModificaDoc
     * @param t És el titol seleccionat a la vistaResultatConsultaTA
     * @param a És l'autor seleccionat a  la vistaResultatConsultaTA 
     * @param r És el número de la vista de rotrn
     */
    public vistaConsultaModificaDoc(String t, String a, int r) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.titol = t;
        this.autor = a;
        this.ret = r;
        iniLabel();
        iniRadio();
    }
    
    /**
     * Inicia els Labels
     */
    void iniLabel() {
        jLabel1.setText("Títol: " + titol);
        jLabel2.setText("Autor: " + autor);
    }
    
    /**
     * Inicia els radioButtons i desactiva els camps
     */
    void iniRadio() {
       //jTextField1.setEnabled(false);
       jTextField1.setEnabled(false);
       jTextField2.setEnabled(false);
       jTextArea2.setEnabled(false);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jRadioButton3 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modificar Document");
        setResizable(false);

        jRadioButton1.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        jRadioButton1.setText("Modifica el títol");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        jLabel1.setText("jLabel1");

        jButton1.setText("<-");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        jRadioButton2.setText("Modifica l'autor");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N

        jTextField2.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jRadioButton3.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        jRadioButton3.setText("Modifica el contigut");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        jButton2.setText("Aceptar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jButton3.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        jButton3.setText("Obte contingut");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(73, 73, 73)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jRadioButton3)
                                                .addGap(81, 81, 81)
                                                .addComponent(jButton3))
                                            .addComponent(jRadioButton1)
                                            .addComponent(jRadioButton2)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jButton1)))
                                .addGap(8, 8, 8)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(226, 226, 226)
                            .addComponent(jButton2))))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton3)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Retornar a la vista ResultatConsultaTA
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (ret == 0) {
            vistaConsultaTitolAutor vistaCTA = new vistaConsultaTitolAutor();
            vistaCTA.setVisible(true);
            this.dispose();
        }
        else if (ret == 1) {
            vistaConsultaContingut vistaCC = new vistaConsultaContingut();
            vistaCC.setVisible(true);
            this.dispose();
        }
        else {
            vistaConsultaDocSemblants vistaCDS = new vistaConsultaDocSemblants();
            vistaCDS.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed
    
    /**
     * Funció que modifica el document
     * @param evt 
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Boolean a = false;
        Boolean b = false;
        Boolean c = false;
        if (jTextField1.isEnabled()) {
            NouTitol = jTextField1.getText();
            a = true;
        }
        if (jTextField2.isEnabled()) {
            NouAutor = jTextField2.getText();
            b = true;
        }
        if (jTextArea2.isEnabled()) {
            NouContingut = jTextArea2.getText();
            c= true;
        }
        if (a) {
            if(NouTitol.length() == 0){
             JOptionPane.showMessageDialog(null,"New titul buit");
            }
            if(NouTitol.length() != 0){
                 if(CtrlPresentacio.ExisteixDoc(titol, autor)){
                    CtrlPresentacio.modifTitol(titol,autor,NouTitol);
                    JOptionPane.showMessageDialog(null,"Titol canviat");
                 }
                 else JOptionPane.showMessageDialog(null,"Document no existeix");
             }
            titol = NouTitol;
        }
        if (b) {
            if(NouAutor.length() == 0){
             JOptionPane.showMessageDialog(null,"New titul buit");
            }
            if(NouAutor.length() != 0){
                  if(CtrlPresentacio.ExisteixDoc(titol, autor)){
                     CtrlPresentacio.modifAutor(titol,autor,NouAutor);
                     JOptionPane.showMessageDialog(null,"Autor canviat");
                  }
                  else JOptionPane.showMessageDialog(null,"Document no existeix");
             }
            autor = NouAutor;  
        }
        if (c) {
            if(autor.length() != 0){
                  if(CtrlPresentacio.ExisteixDoc(titol, autor)){
                     CtrlPresentacio.modifContingut(titol,autor,NouContingut);
                     JOptionPane.showMessageDialog(null,"Contingut canviat");
                  }
                  else JOptionPane.showMessageDialog(null,"Document no existeix");
            }
        }
        if (ret == 0) {
            vistaConsultaTitolAutor vistaCTA = new vistaConsultaTitolAutor();
            vistaCTA.setVisible(true);
            this.dispose();
        }
        else if (ret == 1) {
            vistaConsultaContingut vistaCC = new vistaConsultaContingut();
            vistaCC.setVisible(true);
            this.dispose();
        }
        else {
            vistaConsultaDocSemblants vistaCDS = new vistaConsultaDocSemblants();
            vistaCDS.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Funció activa o desactiva un camp de text
     * @param evt 
     */
    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        if (!jTextField2.isEnabled()) {
            jTextField2.setEnabled(true);
        }
        else {
            jTextField2.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    /**
     * Funció activa o desactiva un camp de text
     * @param evt 
     */
    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed

        if (!jTextArea2.isEnabled()) {
            jTextArea2.setEnabled(true);
        }
        else {
            jTextArea2.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    /**
     * Funció activa o desactiva un camp de text
     * @param evt 
     */
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        if (!jTextField1.isEnabled()) {
            jTextField1.setEnabled(true);
        }
        else {
            jTextField1.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String contingut = CtrlPresentacio.getContingut(titol, autor);
        jTextArea2.setText(contingut);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(vistaConsultaModificaDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaConsultaModificaDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaConsultaModificaDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaConsultaModificaDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaConsultaModificaDoc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
