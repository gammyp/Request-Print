/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestPrintShop;

import RequestPrintDatabase.ConnectionBuilder;
import RequestPrintLogin.LoginEPrinting;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class RegisterShop extends javax.swing.JFrame {

    /**
     * Creates new form RegisterShop
     */
    public RegisterShop() {
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

        registerTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        surnameField = new javax.swing.JTextField();
        surname = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        email = new javax.swing.JLabel();
        Telephone = new javax.swing.JLabel();
        telephoneField = new javax.swing.JTextField();
        shopNameField = new javax.swing.JTextField();
        shopName = new javax.swing.JLabel();
        userName = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();
        passField = new javax.swing.JPasswordField();
        password = new javax.swing.JLabel();
        confirmPassword = new javax.swing.JLabel();
        confirmField = new javax.swing.JPasswordField();
        passwordCheck = new javax.swing.JLabel();
        errorPassText = new javax.swing.JLabel();
        userNameCheck = new javax.swing.JLabel();
        emailCheck = new javax.swing.JLabel();
        submitBG = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        submitButton = new javax.swing.JLabel();
        backBG = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        backButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        registerTitle.setFont(new java.awt.Font("Moon", 1, 24)); // NOI18N
        registerTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registerTitle.setText("Register");
        getContentPane().add(registerTitle);
        registerTitle.setBounds(0, 10, 630, 40);

        jPanel1.setBackground(new java.awt.Color(228, 228, 228));
        jPanel1.setLayout(null);

        jPanel2.setLayout(null);

        name.setFont(new java.awt.Font("Moon", 1, 16)); // NOI18N
        name.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        name.setText("Name :");
        jPanel2.add(name);
        name.setBounds(140, 20, 60, 30);

        nameField.setFont(new java.awt.Font("Cloud Light", 0, 14)); // NOI18N
        jPanel2.add(nameField);
        nameField.setBounds(220, 20, 220, 30);

        surnameField.setFont(new java.awt.Font("Cloud Light", 0, 14)); // NOI18N
        jPanel2.add(surnameField);
        surnameField.setBounds(220, 60, 220, 30);

        surname.setFont(new java.awt.Font("Moon", 1, 16)); // NOI18N
        surname.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        surname.setText("Surname :");
        jPanel2.add(surname);
        surname.setBounds(110, 60, 90, 30);

        address.setFont(new java.awt.Font("Moon", 1, 16)); // NOI18N
        address.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        address.setText("Address :");
        jPanel2.add(address);
        address.setBounds(100, 100, 100, 30);

        addressField.setFont(new java.awt.Font("Cloud Light", 0, 14)); // NOI18N
        jPanel2.add(addressField);
        addressField.setBounds(220, 100, 220, 30);

        emailField.setFont(new java.awt.Font("Cloud Light", 0, 14)); // NOI18N
        emailField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFieldFocusLost(evt);
            }
        });
        jPanel2.add(emailField);
        emailField.setBounds(220, 140, 220, 30);

        email.setFont(new java.awt.Font("Moon", 1, 16)); // NOI18N
        email.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        email.setText("Email :");
        jPanel2.add(email);
        email.setBounds(120, 140, 80, 30);

        Telephone.setFont(new java.awt.Font("Moon", 1, 16)); // NOI18N
        Telephone.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Telephone.setText("Telephone :");
        jPanel2.add(Telephone);
        Telephone.setBounds(90, 180, 110, 30);

        telephoneField.setFont(new java.awt.Font("Cloud Light", 0, 14)); // NOI18N
        jPanel2.add(telephoneField);
        telephoneField.setBounds(220, 180, 220, 30);

        shopNameField.setFont(new java.awt.Font("Cloud Light", 0, 14)); // NOI18N
        jPanel2.add(shopNameField);
        shopNameField.setBounds(220, 220, 220, 30);

        shopName.setFont(new java.awt.Font("Moon", 1, 16)); // NOI18N
        shopName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        shopName.setText("Shop Name :");
        jPanel2.add(shopName);
        shopName.setBounds(90, 220, 110, 30);

        userName.setFont(new java.awt.Font("Moon", 1, 16)); // NOI18N
        userName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        userName.setText("Username :");
        jPanel2.add(userName);
        userName.setBounds(100, 260, 100, 30);

        userNameField.setFont(new java.awt.Font("Cloud Light", 0, 14)); // NOI18N
        userNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                userNameFieldFocusLost(evt);
            }
        });
        jPanel2.add(userNameField);
        userNameField.setBounds(220, 260, 220, 30);

        passField.setFont(new java.awt.Font("Cloud Light", 0, 14)); // NOI18N
        passField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passFieldFocusLost(evt);
            }
        });
        jPanel2.add(passField);
        passField.setBounds(220, 300, 220, 30);

        password.setFont(new java.awt.Font("Moon", 1, 16)); // NOI18N
        password.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        password.setText("Password :");
        jPanel2.add(password);
        password.setBounds(100, 300, 100, 30);

        confirmPassword.setFont(new java.awt.Font("Moon", 1, 16)); // NOI18N
        confirmPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        confirmPassword.setText("Confirm password :");
        jPanel2.add(confirmPassword);
        confirmPassword.setBounds(20, 340, 181, 30);

        confirmField.setFont(new java.awt.Font("Cloud Light", 0, 14)); // NOI18N
        confirmField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                confirmFieldFocusLost(evt);
            }
        });
        jPanel2.add(confirmField);
        confirmField.setBounds(220, 340, 220, 30);
        jPanel2.add(passwordCheck);
        passwordCheck.setBounds(450, 340, 30, 30);

        errorPassText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        errorPassText.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(errorPassText);
        errorPassText.setBounds(450, 300, 120, 30);
        jPanel2.add(userNameCheck);
        userNameCheck.setBounds(450, 260, 30, 30);
        jPanel2.add(emailCheck);
        emailCheck.setBounds(450, 140, 30, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 50, 590, 400);

        submitBG.setBackground(new java.awt.Color(153, 255, 153));
        submitBG.setLayout(null);

        jPanel4.setLayout(null);
        submitBG.add(jPanel4);
        jPanel4.setBounds(20, 460, 230, 40);

        submitButton.setFont(new java.awt.Font("Cloud Light", 0, 18)); // NOI18N
        submitButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        submitButton.setText("Submit");
        submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                submitButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                submitButtonMouseExited(evt);
            }
        });
        submitBG.add(submitButton);
        submitButton.setBounds(0, 0, 290, 40);

        jPanel1.add(submitBG);
        submitBG.setBounds(320, 460, 290, 40);

        backBG.setBackground(new java.awt.Color(255, 255, 153));
        backBG.setLayout(null);

        jPanel6.setLayout(null);
        backBG.add(jPanel6);
        jPanel6.setBounds(20, 460, 230, 40);

        backButton.setFont(new java.awt.Font("Cloud Light", 0, 18)); // NOI18N
        backButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backButton.setText("Back");
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButtonMouseExited(evt);
            }
        });
        backBG.add(backButton);
        backButton.setBounds(0, 0, 290, 40);

        jPanel1.add(backBG);
        backBG.setBounds(20, 460, 290, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 730, 590);

        setSize(new java.awt.Dimension(634, 547));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void emailFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFieldFocusLost
        Image trueIcon = new ImageIcon(this.getClass().getResource("../icon/correct.png")).getImage();
        Image wrongIcon = new ImageIcon(this.getClass().getResource("../icon/wrong.png")).getImage();
        if (emailField.getText().indexOf("@") > 0) {
            emailField.setBackground(null);
            emailCheck.setIcon(new ImageIcon(trueIcon.getScaledInstance(emailCheck.getWidth(), emailCheck.getHeight(), 0)));
        } else {
            emailCheck.setIcon(new ImageIcon(wrongIcon.getScaledInstance(emailCheck.getWidth(), emailCheck.getHeight(), 0)));
            emailField.setBackground(Color.PINK);
        }
    }//GEN-LAST:event_emailFieldFocusLost

    private void userNameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userNameFieldFocusLost
        try {
            Connection con = ConnectionBuilder.getConnection();
            Image trueIcon = new ImageIcon(this.getClass().getResource("../icon/correct.png")).getImage();
            Image wrongIcon = new ImageIcon(this.getClass().getResource("../icon/wrong.png")).getImage();
            PreparedStatement pstm = con.prepareStatement("SELECT username FROM ShopProfile WHERE username = ?");
            pstm.setString(1, userNameField.getText());
            ResultSet rs = pstm.executeQuery();
            if (userNameField.getText().length() > 0) {
                if (rs.next()) {
                    userNameCheck.setIcon(new ImageIcon(wrongIcon.getScaledInstance(userNameCheck.getWidth(), userNameCheck.getHeight(), 0)));
                    userNameField.setBackground(Color.PINK);
                } else {
                    userNameField.setBackground(null);
                    userNameCheck.setIcon(new ImageIcon(trueIcon.getScaledInstance(userNameCheck.getWidth(), userNameCheck.getHeight(), 0)));
                }
            } else {
                userNameCheck.setIcon(new ImageIcon(wrongIcon.getScaledInstance(userNameCheck.getWidth(), userNameCheck.getHeight(), 0)));
                userNameField.setBackground(Color.PINK);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterShop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_userNameFieldFocusLost

    private void passFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passFieldFocusLost
        if (passField.getText().length() >= 0 & passField.getText().length() <= 5) {
            errorPassText.setText("Password weak");
            passField.setBackground(Color.PINK);
        } else if (passField.getText().length() <= 10) {
            passField.setBackground(null);
            errorPassText.setText("Password medium");
        } else if (passField.getText().length() <= 45) {
            passField.setBackground(null);
            errorPassText.setText("Password Strong");
        } else {
            errorPassText.setText("Error");
            passField.setBackground(Color.PINK);
        }
    }//GEN-LAST:event_passFieldFocusLost

    private void confirmFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirmFieldFocusLost
        Image trueIcon = new ImageIcon(this.getClass().getResource("../icon/correct.png")).getImage();
        Image wrongIcon = new ImageIcon(this.getClass().getResource("../icon/wrong.png")).getImage();
        if (passField.getText().length() <= 5 || passField.getText().length() > 45) {
            passwordCheck.setIcon(new ImageIcon(wrongIcon.getScaledInstance(passwordCheck.getWidth(), passwordCheck.getHeight(), 0)));
            passField.setBackground(Color.PINK);
        } else if (confirmField.getText().equals(passField.getText())) {
            passField.setBackground(null);
            passwordCheck.setIcon(new ImageIcon(trueIcon.getScaledInstance(passwordCheck.getWidth(), passwordCheck.getHeight(), 0)));
        } else {
            passwordCheck.setIcon(new ImageIcon(wrongIcon.getScaledInstance(passwordCheck.getWidth(), passwordCheck.getHeight(), 0)));
            passField.setBackground(Color.PINK);
        }
    }//GEN-LAST:event_confirmFieldFocusLost

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        LoginEPrinting login = new LoginEPrinting();
        login.setVisible(false);
    }//GEN-LAST:event_formWindowActivated

    private void submitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButtonMouseClicked
        try {
            Connection con = ConnectionBuilder.getConnection();
            if ((passField.getText().length() > 5) & (userNameField.getText().length() > 0) & (emailField.getText().indexOf("@") > 0)) {
                if (passField.getText().equals(confirmField.getText())) {
                    PreparedStatement pstmInsertProf = con.prepareStatement("INSERT INTO ShopProfile (username, password, shopName, ownerName, "
                            + "ownerSurname, address, phone, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                    pstmInsertProf.setString(1, userNameField.getText());
                    pstmInsertProf.setString(2, passField.getText());
                    pstmInsertProf.setString(3, shopNameField.getText());
                    pstmInsertProf.setString(4, nameField.getText());
                    pstmInsertProf.setString(5, surnameField.getText());
                    pstmInsertProf.setString(6, addressField.getText());
                    pstmInsertProf.setString(7, telephoneField.getText());
                    pstmInsertProf.setString(8, emailField.getText());
                    pstmInsertProf.executeUpdate();
                    //add Product link
                    PreparedStatement pstmSelect = con.prepareStatement("SELECT * FROM ShopProfile WHERE Username = ?");
                    pstmSelect.setString(1, userNameField.getText());
                   // System.out.println("test "+userNameField.getText());
                    ResultSet rsProf = pstmSelect.executeQuery();
                    if (rsProf.next()) {
                        int profileID = rsProf.getInt("shopID");
                        PreparedStatement pstmInsert = con.prepareStatement("INSERT INTO Product (ProductName,TotalOfPrint,ShopProfile_shopID) VALUES (?,?,?)");
                        pstmInsert.setString(1, "link product shop" + rsProf.getInt("shopID"));
                        pstmInsert.setInt(2, 0);
                        pstmInsert.setInt(3, profileID);
                        pstmInsert.executeUpdate();
                    }
                    JOptionPane.showMessageDialog(null, "Register Successful.");
                    //SET FIELD NULL
                    userNameField.setText("");
                    passField.setText("");
                    shopNameField.setText("");
                    nameField.setText("");
                    surnameField.setText("");
                    addressField.setText("");
                    telephoneField.setText("");
                    emailField.setText("");
                    confirmField.setText("");
                    errorPassText.setText(null);
                    emailCheck.setIcon(null);
                    passwordCheck.setIcon(null);
                    userNameCheck.setIcon(null);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegisterShop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_submitButtonMouseClicked

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        setVisible(false);
    }//GEN-LAST:event_backButtonMouseClicked

    private void submitButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButtonMouseEntered
        submitBG.setBackground(new java.awt.Color(102, 255, 102));
    }//GEN-LAST:event_submitButtonMouseEntered

    private void submitButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButtonMouseExited
        submitBG.setBackground(new java.awt.Color(153, 255, 153));
    }//GEN-LAST:event_submitButtonMouseExited

    private void backButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseEntered
        backBG.setBackground(new java.awt.Color(255,255,102));
    }//GEN-LAST:event_backButtonMouseEntered

    private void backButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseExited
        backBG.setBackground(new java.awt.Color(255,255,153));
    }//GEN-LAST:event_backButtonMouseExited

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
            java.util.logging.Logger.getLogger(RegisterShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegisterShop().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Telephone;
    private javax.swing.JLabel address;
    private javax.swing.JTextField addressField;
    private javax.swing.JPanel backBG;
    private javax.swing.JLabel backButton;
    private javax.swing.JPasswordField confirmField;
    private javax.swing.JLabel confirmPassword;
    private javax.swing.JLabel email;
    private javax.swing.JLabel emailCheck;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel errorPassText;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel name;
    private javax.swing.JTextField nameField;
    private javax.swing.JPasswordField passField;
    private javax.swing.JLabel password;
    private javax.swing.JLabel passwordCheck;
    private javax.swing.JLabel registerTitle;
    private javax.swing.JLabel shopName;
    private javax.swing.JTextField shopNameField;
    private javax.swing.JPanel submitBG;
    private javax.swing.JLabel submitButton;
    private javax.swing.JLabel surname;
    private javax.swing.JTextField surnameField;
    private javax.swing.JTextField telephoneField;
    private javax.swing.JLabel userName;
    private javax.swing.JLabel userNameCheck;
    private javax.swing.JTextField userNameField;
    // End of variables declaration//GEN-END:variables
}
