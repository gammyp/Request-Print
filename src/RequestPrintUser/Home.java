/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestPrintUser;

import RequestPrintDatabase.ConnectionBuilder;
import RequestPrintLogin.LoginEPrinting;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Phornlert
 */
public class Home extends javax.swing.JFrame {
    
    private String Username;
    private int UserId;
    private int CopiesofDoc;
    DefaultTableModel model;
    Connection con = null;

    /**
     * Creates new form StatusCheck
     */
    public Home() {
        initComponents();
    }
    
    public void setUsername(String Username) {
        this.Username = Username;
    }
    
    public void setUserId(int UserId) {
        this.UserId = UserId;
    }
    
    public void Logout() throws SQLException {
        System.exit(0);
        con.close();
    }
    
    public void callRequestPage() throws SQLException {
        UserRequest userreq = new UserRequest();
        userreq.setUserId(UserId);
        userreq.setUsername(Username);
        setVisible(false);
        userreq.setVisible(true);
        con.close();
    }
    
    public void callProfile() throws SQLException {
        Userprofile userpro = new Userprofile();
        userpro.setUserId(UserId);
        userpro.setUsername(Username);
        userpro.setVisible(true);
        setVisible(false);
        con.close();
    }
    
    public void callBookList() throws SQLException {
        BookList book = new BookList();
        book.setUserId(UserId);
        book.setUsername(Username);
        book.setVisible(true);
        setVisible(false);
        con.close();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NavBar = new javax.swing.JPanel();
        RequestBox = new javax.swing.JPanel();
        RequestPrint = new javax.swing.JLabel();
        BookListBox = new javax.swing.JPanel();
        BookList = new javax.swing.JLabel();
        YourProfileBox = new javax.swing.JPanel();
        YourProfile = new javax.swing.JLabel();
        LogoutBox = new javax.swing.JPanel();
        Logout = new javax.swing.JLabel();
        HomeBox = new javax.swing.JPanel();
        HomeLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Header = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(720, 503));
        setPreferredSize(new java.awt.Dimension(640, 480));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NavBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        NavBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RequestBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RequestBoxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RequestBoxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RequestBoxMouseExited(evt);
            }
        });

        RequestPrint.setFont(new java.awt.Font("Moon", 0, 24)); // NOI18N
        RequestPrint.setText("Request to Print");

        javax.swing.GroupLayout RequestBoxLayout = new javax.swing.GroupLayout(RequestBox);
        RequestBox.setLayout(RequestBoxLayout);
        RequestBoxLayout.setHorizontalGroup(
            RequestBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RequestBoxLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(RequestPrint)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        RequestBoxLayout.setVerticalGroup(
            RequestBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RequestBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RequestPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        NavBar.add(RequestBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 220, -1));

        BookListBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookListBoxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BookListBoxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BookListBoxMouseExited(evt);
            }
        });

        BookList.setFont(new java.awt.Font("Moon", 0, 24)); // NOI18N
        BookList.setText("Book List");

        javax.swing.GroupLayout BookListBoxLayout = new javax.swing.GroupLayout(BookListBox);
        BookListBox.setLayout(BookListBoxLayout);
        BookListBoxLayout.setHorizontalGroup(
            BookListBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BookListBoxLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(BookList)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        BookListBoxLayout.setVerticalGroup(
            BookListBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BookListBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BookList)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        NavBar.add(BookListBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 220, -1));

        YourProfileBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                YourProfileBoxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                YourProfileBoxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                YourProfileBoxMouseExited(evt);
            }
        });

        YourProfile.setFont(new java.awt.Font("Moon", 0, 24)); // NOI18N
        YourProfile.setText("Your Profile");

        javax.swing.GroupLayout YourProfileBoxLayout = new javax.swing.GroupLayout(YourProfileBox);
        YourProfileBox.setLayout(YourProfileBoxLayout);
        YourProfileBoxLayout.setHorizontalGroup(
            YourProfileBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(YourProfileBoxLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(YourProfile)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        YourProfileBoxLayout.setVerticalGroup(
            YourProfileBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(YourProfileBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(YourProfile)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        NavBar.add(YourProfileBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 102, 220, 40));

        LogoutBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutBoxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LogoutBoxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LogoutBoxMouseExited(evt);
            }
        });

        Logout.setFont(new java.awt.Font("Moon", 0, 24)); // NOI18N
        Logout.setText("Logout");

        javax.swing.GroupLayout LogoutBoxLayout = new javax.swing.GroupLayout(LogoutBox);
        LogoutBox.setLayout(LogoutBoxLayout);
        LogoutBoxLayout.setHorizontalGroup(
            LogoutBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoutBoxLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(Logout)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        LogoutBoxLayout.setVerticalGroup(
            LogoutBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoutBoxLayout.createSequentialGroup()
                .addComponent(Logout)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        NavBar.add(LogoutBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 220, 50));

        HomeLabel.setFont(new java.awt.Font("Moon", 0, 24)); // NOI18N
        HomeLabel.setText("Home");

        javax.swing.GroupLayout HomeBoxLayout = new javax.swing.GroupLayout(HomeBox);
        HomeBox.setLayout(HomeBoxLayout);
        HomeBoxLayout.setHorizontalGroup(
            HomeBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeBoxLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(HomeLabel)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        HomeBoxLayout.setVerticalGroup(
            HomeBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        NavBar.add(HomeBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 220, 50));

        getContentPane().add(NavBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 480));

        jLabel1.setFont(new java.awt.Font("supermarket", 0, 22)); // NOI18N
        jLabel1.setText("This is your document status.");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

        Header.setFont(new java.awt.Font("supermarket", 0, 24)); // NOI18N
        getContentPane().add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 380, 40));

        jTable1.setFont(new java.awt.Font("Cloud Light", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Document", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 440, 310));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Header.setText("Welcome , "+Username);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        HomeLabel.setForeground(Color.white);
        HomeBox.setBackground(new java.awt.Color(56, 51, 57));
        RequestBox.setBackground(null);
        LogoutBox.setBackground(null);
        BookListBox.setBackground(null);
        YourProfileBox.setBackground(null);
        NavBar.setBackground(Color.LIGHT_GRAY);
        try {
            con = ConnectionBuilder.getConnection();
            LoginEPrinting login = new LoginEPrinting();

            PreparedStatement pstm = con.prepareStatement(" SELECT orderID, status FROM Orders WHERE UserProfile_id = "+ login.getUserId());     

            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getString("orderID"));
                v.add(rs.getString("status"));
                model.addRow(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowActivated

    private void RequestBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RequestBoxMouseEntered
        // TODO add your handling code here:
        RequestPrint.setForeground(Color.white);
        RequestBox.setBackground(new java.awt.Color(22, 85, 101));
    }//GEN-LAST:event_RequestBoxMouseEntered

    private void RequestBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RequestBoxMouseExited
        // TODO add your handling code here:
        RequestPrint.setForeground(new java.awt.Color(22, 85, 101));
        RequestBox.setBackground(null);
    }//GEN-LAST:event_RequestBoxMouseExited

    private void LogoutBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutBoxMouseEntered
        // TODO add your handling code here:
        Logout.setForeground(Color.white);
        LogoutBox.setBackground(new java.awt.Color(22, 85, 101));
    }//GEN-LAST:event_LogoutBoxMouseEntered

    private void LogoutBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutBoxMouseExited
        // TODO add your handling code here:
        Logout.setForeground(Color.black);
        LogoutBox.setBackground(null);
    }//GEN-LAST:event_LogoutBoxMouseExited

    private void LogoutBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutBoxMouseClicked
        try {
            // TODO add your handling code here:
            Logout();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_LogoutBoxMouseClicked

    private void RequestBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RequestBoxMouseClicked
        try {
            // TODO add your handling code here:
            callRequestPage();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_RequestBoxMouseClicked

    private void YourProfileBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YourProfileBoxMouseEntered
        // TODO add your handling code here:
        YourProfile.setForeground(Color.white);
        YourProfileBox.setBackground(new java.awt.Color(56, 51, 57));
    }//GEN-LAST:event_YourProfileBoxMouseEntered

    private void YourProfileBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YourProfileBoxMouseExited
        // TODO add your handling code here:
        YourProfile.setForeground(Color.BLACK);
        YourProfileBox.setBackground(null);
    }//GEN-LAST:event_YourProfileBoxMouseExited

    private void YourProfileBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YourProfileBoxMouseClicked
        try {
            // TODO add your handling code here:
            callProfile();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_YourProfileBoxMouseClicked

    private void BookListBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookListBoxMouseEntered
        // TODO add your handling code here:
        BookList.setForeground(Color.white);
        BookListBox.setBackground(new java.awt.Color(56, 51, 57));
    }//GEN-LAST:event_BookListBoxMouseEntered

    private void BookListBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookListBoxMouseExited
        // TODO add your handling code here:
        BookList.setForeground(Color.black);
        BookListBox.setBackground(null);
    }//GEN-LAST:event_BookListBoxMouseExited

    private void BookListBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookListBoxMouseClicked
        try {
            // TODO add your handling code here:
            callBookList();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BookListBoxMouseClicked

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BookList;
    private javax.swing.JPanel BookListBox;
    private javax.swing.JLabel Header;
    private javax.swing.JPanel HomeBox;
    private javax.swing.JLabel HomeLabel;
    private javax.swing.JLabel Logout;
    private javax.swing.JPanel LogoutBox;
    private javax.swing.JPanel NavBar;
    private javax.swing.JPanel RequestBox;
    private javax.swing.JLabel RequestPrint;
    private javax.swing.JLabel YourProfile;
    private javax.swing.JPanel YourProfileBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
