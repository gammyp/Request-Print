/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestPrintUser;

/**
 *
 * @author Game
 */
public class SelectShop extends javax.swing.JFrame {

    /**
     * Creates new form SelectShop
     */
    public SelectShop() {
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

        CancleButton = new javax.swing.JButton();
        Request = new javax.swing.JButton();
        ShopName = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CancleButton.setText("Cancel");
        CancleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancleButtonMouseClicked(evt);
            }
        });
        CancleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancleButtonActionPerformed(evt);
            }
        });
        getContentPane().add(CancleButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

        Request.setText("Next");
        getContentPane().add(Request, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, -1, -1));

        ShopName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(ShopName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 350, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Select shop to request.");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 19, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancleButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CancleButtonActionPerformed

    private void CancleButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancleButtonMouseClicked
        // TODO add your handling code here:
        UserRequest usrreq = new UserRequest();
        setVisible(false);
        usrreq.setVisible(true);
    }//GEN-LAST:event_CancleButtonMouseClicked

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
            java.util.logging.Logger.getLogger(SelectShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectShop().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancleButton;
    private javax.swing.JButton Request;
    private javax.swing.JComboBox<String> ShopName;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}