/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formularios;

import proyectol.usuarios;

/**
 *
 * @author Amado
 */
public class Creacionusuarios extends javax.swing.JFrame {
    

    /**
     * Creates new form Creacionusuario
     */
    public Creacionusuarios() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BtnSalir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtApellidou = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtUsuariou = new javax.swing.JTextField();
        txtTelefonou = new javax.swing.JTextField();
        Btnguardaru = new javax.swing.JButton();
        txtComfirmarcontra = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtEmailu = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtContra = new javax.swing.JPasswordField();
        txtNombreu = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 204));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(207, 238, 230));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnSalir.setText("Salir");
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(BtnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 317, 172, -1));

        jLabel4.setFont(new java.awt.Font("Siemens Sans Black", 0, 14)); // NOI18N
        jLabel4.setText("Telefono");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 173, -1, -1));
        jPanel1.add(txtApellidou, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 203, -1));

        jLabel2.setFont(new java.awt.Font("Siemens Sans Black", 0, 14)); // NOI18N
        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 93, -1, -1));

        txtUsuariou.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuariouActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsuariou, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 203, -1));

        txtTelefonou.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonouActionPerformed(evt);
            }
        });
        jPanel1.add(txtTelefonou, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 203, -1));

        Btnguardaru.setText("Crear usuario");
        Btnguardaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnguardaruActionPerformed(evt);
            }
        });
        jPanel1.add(Btnguardaru, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 317, 171, -1));

        txtComfirmarcontra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComfirmarcontraActionPerformed(evt);
            }
        });
        jPanel1.add(txtComfirmarcontra, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, 203, -1));

        jLabel5.setFont(new java.awt.Font("Siemens Sans Black", 0, 14)); // NOI18N
        jLabel5.setText("Email");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 207, -1, -1));

        jLabel8.setFont(new java.awt.Font("Siemens Sans Black", 0, 14)); // NOI18N
        jLabel8.setText("Comfirmar Contraseña");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, -1, -1));

        jLabel6.setFont(new java.awt.Font("Siemens Sans Black", 0, 14)); // NOI18N
        jLabel6.setText("Contraseña");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 238, 90, -1));

        jLabel1.setFont(new java.awt.Font("Siemens Sans Black", 0, 14)); // NOI18N
        jLabel1.setText("Usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 53, -1, -1));
        jPanel1.add(txtEmailu, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 203, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/283234 (1).png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, 283));

        jLabel3.setFont(new java.awt.Font("Siemens Sans Black", 0, 14)); // NOI18N
        jLabel3.setText("Apellido");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 133, -1, -1));

        txtContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraActionPerformed(evt);
            }
        });
        jPanel1.add(txtContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 203, -1));

        txtNombreu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreuActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombreu, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 203, -1));

        jLabel7.setFont(new java.awt.Font("Siemens Sans SC Black", 1, 24)); // NOI18N
        jLabel7.setText("Crear tu usuario ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, 26));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuariouActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuariouActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuariouActionPerformed

    private void txtNombreuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreuActionPerformed

    private void BtnguardaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnguardaruActionPerformed
        usuarios ru = new usuarios();
        ru.insertardatos(txtUsuariou, txtNombreu, txtApellidou, txtEmailu, txtTelefonou, txtContra, txtComfirmarcontra);
       
    }//GEN-LAST:event_BtnguardaruActionPerformed

    private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BtnSalirActionPerformed

    private void txtContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraActionPerformed

    private void txtComfirmarcontraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComfirmarcontraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComfirmarcontraActionPerformed

    private void txtTelefonouActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonouActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonouActionPerformed

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
            java.util.logging.Logger.getLogger(Creacionusuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Creacionusuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Creacionusuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Creacionusuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Creacionusuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSalir;
    private javax.swing.JButton Btnguardaru;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtApellidou;
    private javax.swing.JPasswordField txtComfirmarcontra;
    private javax.swing.JPasswordField txtContra;
    private javax.swing.JTextField txtEmailu;
    private javax.swing.JTextField txtNombreu;
    private javax.swing.JTextField txtTelefonou;
    private javax.swing.JTextField txtUsuariou;
    // End of variables declaration//GEN-END:variables
}
