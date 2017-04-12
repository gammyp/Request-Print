/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestPrintShop;

import RequestPrintDatabase.ConnectionBuilder;
import RequestPrintLogin.StoreLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class EditShopProfile extends javax.swing.JFrame {

    /**
     * Creates new form EditShopProfile
     */
    public EditShopProfile() {
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

        editProfileTitls = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        surname = new javax.swing.JLabel();
        surnameField = new javax.swing.JTextField();
        address = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        shopName = new javax.swing.JLabel();
        shopNameField = new javax.swing.JTextField();
        phone = new javax.swing.JLabel();
        phoneField = new javax.swing.JTextField();
        email = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(null);

        editProfileTitls.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        editProfileTitls.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editProfileTitls.setText("Edit Profile");
        getContentPane().add(editProfileTitls);
        editProfileTitls.setBounds(-1, 13, 460, 30);

        name.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        name.setText("Name :");
        getContentPane().add(name);
        name.setBounds(60, 60, 50, 30);
        getContentPane().add(nameField);
        nameField.setBounds(120, 60, 280, 30);

        surname.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        surname.setText("Surname :");
        getContentPane().add(surname);
        surname.setBounds(20, 100, 90, 30);
        getContentPane().add(surnameField);
        surnameField.setBounds(120, 100, 280, 30);

        address.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        address.setText("Address :");
        getContentPane().add(address);
        address.setBounds(20, 180, 90, 30);
        getContentPane().add(addressField);
        addressField.setBounds(120, 180, 280, 30);

        shopName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        shopName.setText("Shop name :");
        getContentPane().add(shopName);
        shopName.setBounds(20, 140, 90, 30);
        getContentPane().add(shopNameField);
        shopNameField.setBounds(120, 140, 280, 30);

        phone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        phone.setText("Phone :");
        getContentPane().add(phone);
        phone.setBounds(20, 220, 90, 30);
        getContentPane().add(phoneField);
        phoneField.setBounds(120, 220, 280, 30);

        email.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        email.setText("Email :");
        getContentPane().add(email);
        email.setBounds(20, 260, 90, 30);
        getContentPane().add(emailField);
        emailField.setBounds(120, 260, 280, 30);

        saveButton.setText("save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        getContentPane().add(saveButton);
        saveButton.setBounds(190, 310, 79, 25);

        setSize(new java.awt.Dimension(470, 399));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        Connection con = null;
        try {
            con = ConnectionBuilder.getConnection();
            StoreLogin sLogin = new StoreLogin();
            System.out.println(sLogin.getShopId());
            PreparedStatement pstm = con.prepareStatement("UPDATE ShopProfile SET "
                    + "ownerName=?, ownerSurname=?, shopName=?, address=?, phone=?, email=?"
                    + " WHERE shopID = " + sLogin.getShopId());
            pstm.setString(1, nameField.getText());
            pstm.setString(2, surnameField.getText());
            pstm.setString(3, shopNameField.getText());
            pstm.setString(4, addressField.getText());
            pstm.setString(5, phoneField.getText());
            pstm.setString(6, emailField.getText());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Save Successful");
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(EditShopProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        Connection con = null;
        try {
            con = ConnectionBuilder.getConnection();
            StoreLogin sLogin = new StoreLogin();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM ShopProfile WHERE shopID = " + sLogin.getShopId());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                nameField.setText(rs.getString("ownerName"));
                surnameField.setText(rs.getString("ownerSurname"));
                shopNameField.setText(rs.getString("shopName"));
                addressField.setText(rs.getString("address"));
                phoneField.setText(rs.getString("phone"));
                emailField.setText(rs.getString("email"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditShopProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formComponentShown

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
            java.util.logging.Logger.getLogger(EditShopProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditShopProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditShopProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditShopProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditShopProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JTextField addressField;
    private javax.swing.JLabel editProfileTitls;
    private javax.swing.JLabel email;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel name;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel phone;
    private javax.swing.JTextField phoneField;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel shopName;
    private javax.swing.JTextField shopNameField;
    private javax.swing.JLabel surname;
    private javax.swing.JTextField surnameField;
    // End of variables declaration//GEN-END:variables
}
