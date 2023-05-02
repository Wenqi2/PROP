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
public class vistaConsultaCopiarDoc extends javax.swing.JFrame {
    private String titol;
    private String autor;
    private int ret;
    
    /**
     * @constructor Crea una instancia de la vistaConsultaCopiarDoc
     */ 
    public vistaConsultaCopiarDoc() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    /**
     * @constructor Crea una instancia de la vistaConsultaCopiarDoc
     * @param t És el titol seleccionat a la vistaResultatConsultaTA
     * @param a És l'autor seleccionat a  la vistaResultatConsultaTA 
     * @param r És el número de la vista de rotrn
     */
    public vistaConsultaCopiarDoc(String t, String a, int r) {
        initComponents();
        this.titol = t;
        this.autor = a;
        this.ret = r;
        iniLabel();
        this.setLocationRelativeTo(null);
    }
    
    /**
     * Inicia els Labels
     */
    public void iniLabel() {
        jLabel4.setText(titol);
        jLabel5.setText(autor);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Copiar document");
        setResizable(false);

        jButton1.setText("<-");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        jLabel1.setText("Titol:");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        jLabel2.setText("Autor:");

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        jLabel3.setText("Nou Titol:");

        jTextField3.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N

        jButton2.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        jButton2.setText("Copiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        jLabel4.setText("jLabel4");

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 0, 17)); // NOI18N
        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel2)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jButton2)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(112, Short.MAX_VALUE))
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

    /**
     * Funció que copia el document
     * @param evt 
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //String titul =  jTexttiul.getText();
        //String autor =  jTextautor.getText();
        String newtitul = jTextField3.getText();
       
        if(newtitul.length() == 0){
         JOptionPane.showMessageDialog(null,"New titul buit");
        }
        else if(titol.length() != 0 && autor.length() != 0 && newtitul.length() != 0){
              if(CtrlPresentacio.ExisteixDoc(titol, autor)){
                     if (CtrlPresentacio.ExisteixDoc(newtitul, autor)){
                         JOptionPane.showMessageDialog(null,"Canviar el titol del document");
                     }
                     else {
                        CtrlPresentacio.copiarDocument(titol, autor,newtitul);
                        JOptionPane.showMessageDialog(null,"Document copiat");
                     }

                 }
                 else JOptionPane.showMessageDialog(null,"Document no existeix");
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
            java.util.logging.Logger.getLogger(vistaConsultaCopiarDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaConsultaCopiarDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaConsultaCopiarDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaConsultaCopiarDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaConsultaCopiarDoc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
