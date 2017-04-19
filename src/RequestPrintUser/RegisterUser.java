package RequestPrintUser;

import RequestPrintDatabase.ConnectionBuilder;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class RegisterUser extends javax.swing.JFrame {

    boolean checkall = true;

    public RegisterUser() {
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

        Register = new javax.swing.JLabel();
        surname = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        userName = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        CreatePassword = new javax.swing.JTextField();
        namelabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        surnameLabel = new javax.swing.JLabel();
        telephoneLabel = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        passwordLabel1 = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        checkUsername = new javax.swing.JLabel();
        checkPassword = new javax.swing.JLabel();
        error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        Register.setFont(new java.awt.Font("supermarket", 0, 24)); // NOI18N
        Register.setText("Register");
        getContentPane().add(Register);
<<<<<<< HEAD
        Register.setBounds(253, 13, 94, 43);

        surname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surnameActionPerformed(evt);
            }
        });
=======
        Register.setBounds(253, 13, 104, 43);
>>>>>>> master
        getContentPane().add(surname);
        surname.setBounds(262, 135, 228, 33);
        getContentPane().add(name);
        name.setBounds(262, 84, 228, 33);
        getContentPane().add(Email);
        Email.setBounds(262, 188, 228, 33);
        getContentPane().add(phone);
        phone.setBounds(262, 241, 228, 33);
        getContentPane().add(userName);
        userName.setBounds(262, 294, 228, 33);
        getContentPane().add(password);
        password.setBounds(262, 347, 228, 33);
        getContentPane().add(CreatePassword);
        CreatePassword.setBounds(262, 400, 228, 33);

        namelabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        namelabel.setText("Name :");
        getContentPane().add(namelabel);
        namelabel.setBounds(176, 88, 81, 29);

        emailLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        emailLabel.setText("Email :");
        getContentPane().add(emailLabel);
        emailLabel.setBounds(179, 186, 78, 33);

        surnameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        surnameLabel.setText("Surname :");
        getContentPane().add(surnameLabel);
        surnameLabel.setBounds(152, 135, 105, 33);

        telephoneLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        telephoneLabel.setText("Telephone :");
        getContentPane().add(telephoneLabel);
        telephoneLabel.setBounds(138, 239, 119, 33);

        userNameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        userNameLabel.setText("Username :");
        getContentPane().add(userNameLabel);
        userNameLabel.setBounds(138, 292, 119, 33);

        passwordLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordLabel.setText("Password :");
        getContentPane().add(passwordLabel);
        passwordLabel.setBounds(146, 345, 111, 33);

        passwordLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordLabel1.setText("Confirm password :");
        getContentPane().add(passwordLabel1);
        passwordLabel1.setBounds(77, 398, 180, 33);

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(submitButton);
        submitButton.setBounds(325, 451, 100, 36);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton);
        backButton.setBounds(184, 451, 100, 36);
        getContentPane().add(checkUsername);
        checkUsername.setBounds(500, 300, 80, 30);
        getContentPane().add(checkPassword);
        checkPassword.setBounds(500, 410, 90, 20);
        getContentPane().add(error);
        error.setBounds(500, 350, 90, 30);

        setSize(new java.awt.Dimension(600, 546));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed

        try {
            System.out.println(name.getText());

            if (name.getText() != "" && surname.getText() != "" && userName.getText() != ""
                    && password.getText() != "" && Email.getText() != "" && phone.getText() != "") {
                if (checkall) {
                    //   JOptionPane.showConfirmDialog(null, "Do you confirm?", "Message", JOptionPane.YES_NO_OPTION);
                    int confirm = JOptionPane.showOptionDialog(this, "Are You confirm?", "CONFIRM", JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null, null, null);
                    if (confirm == JOptionPane.YES_OPTION) {
                        Connection con = ConnectionBuilder.getConnection();
                        String sql = "INSERT INTO UserProfile(id,username,password,name,surname,address,phone,email) VALUES (null,?,?,?,?,null,?,?)";
                        PreparedStatement pstm = con.prepareStatement(sql);
                        pstm.setString(3, name.getText());
                        pstm.setString(4, surname.getText());
                        pstm.setString(6, Email.getText());
                        pstm.setString(5, phone.getText());
                        pstm.setString(1, userName.getText());
                        pstm.setString(2, password.getText());
                        pstm.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Registered Successfully.");
                        name.setText("");
                        surname.setText("");
                        Email.setText("");
                        phone.setText("");
                        userName.setText("");
                        password.setText("");
                        checkPassword.setIcon(null);
                        checkUsername.setIcon(null);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void UsernameFocusLost(java.awt.event.FocusEvent evt) throws SQLException {
        Connection con = ConnectionBuilder.getConnection();
        Image trueIcon = new ImageIcon(this.getClass().getResource("icon/check.png")).getImage();
        Image falseIcon = new ImageIcon(this.getClass().getResource("icon/uncheck.png")).getImage();

        try {
            PreparedStatement pstm = con.prepareStatement("SELECT USERNAME FROM userProfile WHERE USERNAME = ? ");
            pstm.setString(1, userName.getText());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                checkall = false;
                checkUsername.setIcon(new ImageIcon(falseIcon.getScaledInstance(checkUsername.getWidth(), checkUsername.getHeight(), 0)));
            } else {
                checkall = true;
                checkUsername.setIcon(new ImageIcon(trueIcon.getScaledInstance(checkUsername.getWidth(), checkUsername.getHeight(), 0)));

            }

//        checkUsername.hide();
        } catch (SQLException ex) {
            Logger.getLogger(RegisterUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void PassFocusLost(java.awt.event.FocusEvent evt) {
        if (password.getText().length() < 6 || password.getText().length() > 45) {
            error.setText("** Password 6-45 charecter ");
            checkall = false;
        } else {
            error.setText("");
            checkall = true;
        }

    }

    private void RePassFocusLost(java.awt.event.FocusEvent evt) {
        Image trueIcon = new ImageIcon(this.getClass().getResource("icon/check.png")).getImage();
        Image falseIcon = new ImageIcon(this.getClass().getResource("icon/uncheck.png")).getImage();

        if (CreatePassword.getText().length() < 6 || CreatePassword.getText().length() > 12) {
            checkall = false;
        } else {
            if (password.getText().equals(CreatePassword.getText())) {
                checkall = true;
                checkPassword.setIcon(new ImageIcon(trueIcon.getScaledInstance(checkPassword.getWidth(), checkPassword.getHeight(), 0)));
            } else {
                checkall = false;
                checkPassword.setIcon(new ImageIcon(falseIcon.getScaledInstance(checkPassword.getWidth(), checkPassword.getHeight(), 0)));
            }

        }
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CreatePassword;
    private javax.swing.JTextField Email;
    private javax.swing.JLabel Register;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel checkPassword;
    private javax.swing.JLabel checkUsername;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel error;
    private javax.swing.JTextField name;
    private javax.swing.JLabel namelabel;
    private javax.swing.JTextField password;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel passwordLabel1;
    private javax.swing.JTextField phone;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField surname;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JLabel telephoneLabel;
    private javax.swing.JTextField userName;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration//GEN-END:variables
}
