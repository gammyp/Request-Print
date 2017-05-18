/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestPrintShop;

import RequestPrintDatabase.ConnectionBuilder;
import RequestPrintLogin.LoginEPrinting;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class HomeShop extends javax.swing.JFrame {

    DefaultTableModel model;

    /**
     * Creates new form Home
     */
    public HomeShop() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        home = new javax.swing.JLabel();
        bgMenu = new javax.swing.JPanel();
        profile = new javax.swing.JLabel();
        manageBook = new javax.swing.JLabel();
        respondPrint = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        signout = new javax.swing.JLabel();
        update = new javax.swing.JLabel();
        topHit = new javax.swing.JLabel();
        topOneBG = new javax.swing.JPanel();
        topOne = new javax.swing.JLabel();
        topOneBG1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        topTwoBG = new javax.swing.JPanel();
        topTwo = new javax.swing.JLabel();
        topThreeBG = new javax.swing.JPanel();
        topThree = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        updateTable = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        home.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        home.setText("Home");
        home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(home);
        home.setBounds(0, 100, 190, 30);

        bgMenu.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout bgMenuLayout = new javax.swing.GroupLayout(bgMenu);
        bgMenu.setLayout(bgMenuLayout);
        bgMenuLayout.setHorizontalGroup(
            bgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        bgMenuLayout.setVerticalGroup(
            bgMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(bgMenu);
        bgMenu.setBounds(0, 100, 190, 30);

        profile.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        profile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profile.setText("Profile");
        profile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileMouseClicked(evt);
            }
        });
        getContentPane().add(profile);
        profile.setBounds(0, 150, 190, 30);

        manageBook.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        manageBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        manageBook.setText("Manage Book");
        manageBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manageBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageBookMouseClicked(evt);
            }
        });
        getContentPane().add(manageBook);
        manageBook.setBounds(0, 200, 190, 30);

        respondPrint.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        respondPrint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        respondPrint.setText("Respond Print");
        respondPrint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        respondPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                respondPrintMouseClicked(evt);
            }
        });
        getContentPane().add(respondPrint);
        respondPrint.setBounds(0, 250, 190, 30);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(null);

        signout.setText("Sign out");
        signout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signoutMouseClicked(evt);
            }
        });
        jPanel1.add(signout);
        signout.setBounds(7, 421, 50, 16);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 190, 450);

        update.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        update.setText("Update");
        getContentPane().add(update);
        update.setBounds(220, 230, 60, 20);

        topHit.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        topHit.setText("Top 3 Book");
        getContentPane().add(topHit);
        topHit.setBounds(220, 20, 100, 20);

        topOneBG.setBackground(new java.awt.Color(225, 225, 225));
        topOneBG.setLayout(null);

        topOne.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        topOne.setText("test b1");
        topOneBG.add(topOne);
        topOne.setBounds(0, 0, 130, 160);

        topOneBG1.setBackground(new java.awt.Color(225, 225, 225));
        topOneBG1.setLayout(null);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        topOneBG1.add(jLabel3);
        jLabel3.setBounds(-20, 30, 130, 160);

        topOneBG.add(topOneBG1);
        topOneBG1.setBounds(230, 50, 130, 160);

        getContentPane().add(topOneBG);
        topOneBG.setBounds(230, 50, 130, 160);

        topTwoBG.setBackground(new java.awt.Color(225, 225, 225));
        topTwoBG.setLayout(null);

        topTwo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        topTwoBG.add(topTwo);
        topTwo.setBounds(0, 0, 130, 160);

        getContentPane().add(topTwoBG);
        topTwoBG.setBounds(390, 50, 130, 160);

        topThreeBG.setBackground(new java.awt.Color(225, 225, 225));
        topThreeBG.setLayout(null);

        topThree.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        topThreeBG.add(topThree);
        topThree.setBounds(0, 0, 130, 160);

        getContentPane().add(topThreeBG);
        topThreeBG.setBounds(550, 50, 130, 160);

        updateTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Order ID", "Name", "Date", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(updateTable);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(230, 260, 452, 170);

        setSize(new java.awt.Dimension(737, 491));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        bgMenu.setBackground(Color.DARK_GRAY);
        home.setBackground(Color.DARK_GRAY);
        home.setForeground(Color.WHITE);
        updateTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        updateTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        updateTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        updateTable.getColumnModel().getColumn(2).setPreferredWidth(30);
        updateTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
    }//GEN-LAST:event_formComponentShown

    private void signoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signoutMouseClicked
        LoginEPrinting login = new LoginEPrinting();
        this.setVisible(false);
        login.setVisible(true);
    }//GEN-LAST:event_signoutMouseClicked

    private void profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseClicked
        ShopProfile sProf = new ShopProfile();
        this.setVisible(false);
        sProf.setVisible(true);
    }//GEN-LAST:event_profileMouseClicked

    private void manageBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageBookMouseClicked
        ManageListBook manageBook = new ManageListBook();
        this.setVisible(false);
        manageBook.setVisible(true);
    }//GEN-LAST:event_manageBookMouseClicked

    private void respondPrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_respondPrintMouseClicked
        RespondPrint respond = new RespondPrint();
        this.setVisible(false);
        respond.setVisible(true);
    }//GEN-LAST:event_respondPrintMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        model = (DefaultTableModel) updateTable.getModel();
        model.setRowCount(0);
        Connection con = null;
        try {
            con = ConnectionBuilder.getConnection();
            LoginEPrinting login = new LoginEPrinting();
            PreparedStatement pstmOrder = con.prepareStatement("SELECT * FROM mydb.Order "
                    + "WHERE ShopProfile_shopID = " + login.getShopId());
            ResultSet rsOrder = pstmOrder.executeQuery();

            while (rsOrder.next()) {
                PreparedStatement pstmUser = con.prepareStatement("SELECT * FROM UserProfile "
                        + "WHERE id = " + rsOrder.getInt("UserProfile_id"));
                ResultSet rsUser = pstmUser.executeQuery();
                rsUser.next();
                Vector v = new Vector();
                v.add(rsOrder.getInt("orderID"));
                v.add(rsUser.getString("name") + " " + rsUser.getString("surname"));
                v.add(rsOrder.getDate("datetime"));
                if (rsOrder.getString("status").equals("Pending Responding")) {
                    v.add("Pending Responding");
                }
                model.addRow(v);
                
                //Sort Top 3 Hit
                PreparedStatement pstmProduct = con.prepareStatement("SELECT productName FROM Product "
                        + "WHERE ShopProfile_shopID = " + login.getShopId() + " AND NOT productName = 'link product shop" + login.getShopId() +
                        "' ORDER BY TotalOfPrint LIMIT 3");
                ResultSet rsProduct = pstmProduct.executeQuery();
                if (rsProduct.next()) {
                    topOne.setText(rsProduct.getString("productName"));
                    if (rsProduct.next()) {
                        topTwo.setText(rsProduct.getString("productName"));
                        if (rsProduct.next()) {
                            topThree.setText(rsProduct.getString("productName"));
                        } else {
                            topThree.setText("No Data");
                        }
                    } else {
                        topTwo.setText("No Data");
                        topThree.setText("No Data");
                    }
                } else {
                    topOne.setText("No Data");
                    topTwo.setText("No Data");
                    topThree.setText("No Data");
                }
                pstmProduct.close();
                pstmUser.close();
            }
            pstmOrder.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(HomeShop.class.getName()).log(Level.SEVERE, null, ex);
        }

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
            java.util.logging.Logger.getLogger(HomeShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeShop().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgMenu;
    private javax.swing.JLabel home;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel manageBook;
    private javax.swing.JLabel profile;
    private javax.swing.JLabel respondPrint;
    private javax.swing.JLabel signout;
    private javax.swing.JLabel topHit;
    private javax.swing.JLabel topOne;
    private javax.swing.JPanel topOneBG;
    private javax.swing.JPanel topOneBG1;
    private javax.swing.JLabel topThree;
    private javax.swing.JPanel topThreeBG;
    private javax.swing.JLabel topTwo;
    private javax.swing.JPanel topTwoBG;
    private javax.swing.JLabel update;
    private javax.swing.JTable updateTable;
    // End of variables declaration//GEN-END:variables
}
