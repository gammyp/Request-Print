/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestPrintUser;

import RequestPrintDatabase.ConnectionBuilder;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Game
 */
public class UserRequest extends javax.swing.JFrame {
    
    private String request = "";
    private String Username;
    
    public void setUsername(String Username) {
        this.Username = Username;
    }
    
    public String getUsername() {
        return Username;
    }
    /**
     * Creates new form UserProfile
     */
    public UserRequest() {
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

        Request = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        DocumentLink = new javax.swing.JTextField();
        LocationLink = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        RequestHaed = new javax.swing.JLabel();
        AttachFile = new javax.swing.JLabel();
        ChooseFile = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ChooseBookLabel = new javax.swing.JLabel();
        NumberofCopies = new javax.swing.JSpinner();
        Copies = new javax.swing.JLabel();
        BookList = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        MessageLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        YourRequest = new javax.swing.JLabel();
        YourProfile = new javax.swing.JLabel();
        DocumnetStatus = new javax.swing.JLabel();
        Logout = new javax.swing.JLabel();
        Headder = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Request.setText("Request");
        Request.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequestActionPerformed(evt);
            }
        });
        getContentPane().add(Request, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 520, -1, -1));

        jLabel1.setText("beta 2");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, -1, -1));
        getContentPane().add(DocumentLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 410, -1));

        LocationLink.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LocationLink.setText("Location link");
        getContentPane().add(LocationLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

        jLabel3.setText("Require cloud service (Google Drive , Onedrive , etc.)");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, -1));

        RequestHaed.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        RequestHaed.setText("Request to print your document");
        getContentPane().add(RequestHaed, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, -1, -1));

        AttachFile.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AttachFile.setText("Attach your file");
        getContentPane().add(AttachFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        ChooseFile.setText("Choose File");
        ChooseFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChooseFileMouseClicked(evt);
            }
        });
        getContentPane().add(ChooseFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, -1, -1));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 400, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("OR");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, -1, -1));

        ChooseBookLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ChooseBookLabel.setText("Choose book from list.");
        getContentPane().add(ChooseBookLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 140, 30));
        getContentPane().add(NumberofCopies, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, -1, -1));

        Copies.setText("Copies");
        getContentPane().add(Copies, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, -1, -1));

        BookList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(BookList, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 390, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 520, 170));

        MessageLabel.setText("Message to shop.");
        getContentPane().add(MessageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, -1, -1));

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        YourRequest.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        YourRequest.setText("Your Request");

        YourProfile.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        YourProfile.setText("Your Profile");

        DocumnetStatus.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        DocumnetStatus.setText("Check Status");

        Logout.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Logout.setText("Logout");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(YourRequest, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(YourProfile)
                            .addComponent(DocumnetStatus)
                            .addComponent(Logout))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(YourRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(YourProfile)
                .addGap(67, 67, 67)
                .addComponent(DocumnetStatus)
                .addGap(85, 85, 85)
                .addComponent(Logout)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 570));

        Headder.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(Headder, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 500, 30));

        setSize(new java.awt.Dimension(778, 591));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void RequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RequestActionPerformed
        // TODO add your handling code here:
        SelectShop selc = new SelectShop();
        setVisible(false);
        selc.setVisible(true);
    }//GEN-LAST:event_RequestActionPerformed

    private void ChooseFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChooseFileMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ChooseFileMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
            YourRequest.setBackground(Color.black);
            YourRequest.setForeground(Color.white);
            Headder.setText("Welcome , "+Username);
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(UserRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserRequest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserRequest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AttachFile;
    private javax.swing.JComboBox<String> BookList;
    private javax.swing.JLabel ChooseBookLabel;
    private javax.swing.JButton ChooseFile;
    private javax.swing.JLabel Copies;
    private javax.swing.JTextField DocumentLink;
    private javax.swing.JLabel DocumnetStatus;
    private javax.swing.JLabel Headder;
    private javax.swing.JLabel LocationLink;
    private javax.swing.JLabel Logout;
    private javax.swing.JLabel MessageLabel;
    private javax.swing.JSpinner NumberofCopies;
    private javax.swing.JButton Request;
    private javax.swing.JLabel RequestHaed;
    private javax.swing.JLabel YourProfile;
    private javax.swing.JLabel YourRequest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
