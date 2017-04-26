/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestPrintLogin;

import RequestPrintDatabase.ConnectionBuilder;
import RequestPrintShop.ShopProfile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author game_
 */
public class StoreLogin extends javax.swing.JFrame {

    private static int shopId;

    public int getShopId() {
        return shopId;
    }

    /**
     * Creates new form StoreLogin
     */
    public StoreLogin() {
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

        userNameField = new javax.swing.JTextField();
        userName = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        nameProgram = new javax.swing.JLabel();
        errorText = new javax.swing.JLabel();
        noAccount = new javax.swing.JLabel();
        forUserLogin = new javax.swing.JLabel();
        userLogin = new javax.swing.JButton();
        regisButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 274));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(userNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 270, -1));

        userName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        userName.setText("Username : ");
        getContentPane().add(userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 80, 20));

        password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        password.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        password.setText("Password : ");
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));
        getContentPane().add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 270, -1));

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 140, -1));

        nameProgram.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        nameProgram.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameProgram.setText("E - PRINTING");
        getContentPane().add(nameProgram, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 400, 30));

        errorText.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(errorText, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 270, 20));

        noAccount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        noAccount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        noAccount.setText("Don't have an account?");
        getContentPane().add(noAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 160, 30));

        forUserLogin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        forUserLogin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        forUserLogin.setText("For User login.");
        getContentPane().add(forUserLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 110, 30));

        userLogin.setText("Login User");
        userLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userLoginMouseClicked(evt);
            }
        });
        getContentPane().add(userLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 100, 30));

        regisButton.setText("Register");
        regisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regisButtonActionPerformed(evt);
            }
        });
        getContentPane().add(regisButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 100, 30));

        setSize(new java.awt.Dimension(416, 313));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void regisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regisButtonActionPerformed
        SelectRegisUserOrRegisShop selectRegis = new SelectRegisUserOrRegisShop();
        selectRegis.setVisible(true);
    }//GEN-LAST:event_regisButtonActionPerformed

    private void userLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userLoginMouseClicked
        setVisible(false);
        UserLogin usr = new UserLogin();
        usr.setVisible(true);
    }//GEN-LAST:event_userLoginMouseClicked

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        Connection con = null;
        if (userNameField.getText().equals("") && passwordField.getText().equals("")) {
            errorText.setText("Please enter your username and password!");
        } else {
            try {
                con = ConnectionBuilder.getConnection();
                PreparedStatement pstm = con.prepareStatement("SELECT * FROM ShopProfile WHERE username = ? AND password = ?");
                pstm.setString(1, userNameField.getText());
                pstm.setString(2, passwordField.getText());
                ResultSet rs = pstm.executeQuery();
                if (rs.next()) {
                    shopId = Integer.parseInt(rs.getString("shopID"));
                    JOptionPane.showMessageDialog(null, "Success");
                    ShopProfile sProf = new ShopProfile();
                    this.setVisible(false);
                    sProf.setVisible(true);
                } else {
                    userNameField.setText("");
                    passwordField.setText("");
                    errorText.setText("Invalid username or password");
                }
                con.close();
                pstm.close();
            } catch (SQLException ex) {
                Logger.getLogger(StoreLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_loginButtonActionPerformed

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
            java.util.logging.Logger.getLogger(StoreLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StoreLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StoreLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StoreLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StoreLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorText;
    private javax.swing.JLabel forUserLogin;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel nameProgram;
    private javax.swing.JLabel noAccount;
    private javax.swing.JLabel password;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton regisButton;
    private javax.swing.JButton userLogin;
    private javax.swing.JLabel userName;
    private javax.swing.JTextField userNameField;
    // End of variables declaration//GEN-END:variables
}
