/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestPrintUser;

import RequestPrintDatabase.ConnectionBuilder;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author jirayupeach
 */
public class BookList extends javax.swing.JFrame {

    private int UserId;
    private String Username;
    private int shopID;
    private int productID;
    private int orderID;
    private static int LastOrderID;
    private static int LastShopID;

    public BookList() {
        initComponents();

    }


    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }
    //Method for call from GUI
    
    public void callList() {
        ShopSelect.removeAllItems();
        BookSelect.removeAllItems();
        Copies.setValue(1);
        try {
            Connection con = ConnectionBuilder.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT shopName FROM ShopProfile");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ShopSelect.addItem(rs.getString("shopName"));
            }
            con.close();
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Connection con = ConnectionBuilder.getConnection();

            //executeQuery ShopProfile Table to use ShopID
            PreparedStatement pstmSelectShopId = con.prepareStatement("SELECT shopID FROM ShopProfile WHERE "
                    + "shopName = '" + ShopSelect.getSelectedItem() + "'");
            ResultSet rsShopId = pstmSelectShopId.executeQuery();
            if (rsShopId.next()) {
                shopID = rsShopId.getInt("shopID");
            }
            
            con.close();
            pstmSelectShopId.close();
            //executeQuery Product Table to use ProductName
            
            con = ConnectionBuilder.getConnection();
            PreparedStatement pstmSelectProduct = con.prepareStatement("SELECT productName,productID FROM Product WHERE ShopProfile_shopID = " + shopID);
            ResultSet rsProductName = pstmSelectProduct.executeQuery();
            if(rsProductName.next()){
                productID = rsProductName.getInt("productID");
            }
            
            //Add intitial text
            BookSelect.addItem("");
        } catch (SQLException ex) {
            Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void callHome() {
        Home h = new Home();
        h.setUserId(UserId);
        h.setUsername(Username);
        h.setVisible(true);
        this.setVisible(false);
    }
    public void callUserProfile() {
        Userprofile userpro = new Userprofile();
        userpro.setUserId(UserId);
        userpro.setUsername(Username);
        userpro.setVisible(true);
        setVisible(false);
    }
    
    public void callRequestPage() {
        UserRequest userreq = new UserRequest();
        userreq.setUserId(UserId);
        userreq.setUsername(Username);
        userreq.setVisible(true);
        setVisible(false);
    }
    
    public void PrintBook() {
        BookSelect.removeAllItems();
        try {
            Connection con = ConnectionBuilder.getConnection();

            //executeQuery ShopProfile Table to use ShopID
            PreparedStatement pstmSelectShopId = con.prepareStatement("SELECT shopID FROM ShopProfile WHERE "
                    + "shopName = '" + ShopSelect.getSelectedItem() + "'");
            ResultSet rsShopId = pstmSelectShopId.executeQuery();
            if(rsShopId.next()){
                LastShopID = rsShopId.getInt("shopID");
            }
              

            //executeQuery Product Table to use ProductName
            PreparedStatement pstmSelectProduct = con.prepareStatement("SELECT productName FROM Product WHERE "
                    + "ShopProfile_shopID = "+ LastShopID);
            ResultSet rsProductName = pstmSelectProduct.executeQuery();

            //Add intitial text
            BookSelect.addItem("");
            while (rsProductName.next()) {
                BookSelect.addItem(rsProductName.getString("productName"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void Logout() {
        System.exit(0);
    }
    
    public void RequestBook() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            String datestr = sdf.format(date);
            Connection con = ConnectionBuilder.getConnection();
            
            PreparedStatement pstmInsert1 = con.prepareStatement("INSERT INTO Orders(orderID,priceOrder,status,datetime,description,url,UserProfile_id,ShopProfile_shopID)"
                    + "VALUES (null,?,?,?,?,null,?,?)");
            pstmInsert1.setInt(1, productID);
            if ((int) Copies.getValue() > 0) {
                pstmInsert1.setString(2, "Pending Responding");
            } else if ((int) Copies.getValue() > 100) {
                pstmInsert1.setString(2, "Pending Payment");
            }
            pstmInsert1.setString(3, datestr);
            pstmInsert1.setString(4, description.getText());
            pstmInsert1.setInt(5, UserId);
            pstmInsert1.setInt(6, shopID);
            pstmInsert1.executeUpdate();

            PreparedStatement pstmSel = con.prepareStatement("SELECT orderID FROM Orders WHERE orderID = ?");
            pstmSel.setInt(1, getOrderID());
            ResultSet rs = pstmSel.executeQuery();
            while (rs.next()) {
                orderID = rs.getInt("orderID");
            }

            PreparedStatement pstmInsert2 = con.prepareStatement("INSERT INTO SheetOrder(sheetID,productAmount,Order_orderID,Product_productID)"
                    + "VALUES(null,?,?,?)");
            pstmInsert2.setInt(1, (int) Copies.getValue());
            pstmInsert2.setInt(2, orderID);
            pstmInsert2.setInt(3, productID);
            pstmInsert2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Success");
                    } catch (SQLException ex) {
            Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //End Method for call
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NavBar = new javax.swing.JPanel();
        YourProfileBox = new javax.swing.JPanel();
        YourProfile = new javax.swing.JLabel();
        RequestPrintBox = new javax.swing.JPanel();
        RequestPrint = new javax.swing.JLabel();
        HomeBox = new javax.swing.JPanel();
        Home = new javax.swing.JLabel();
        LogoutBox = new javax.swing.JPanel();
        Logout = new javax.swing.JLabel();
        BookListBox = new javax.swing.JPanel();
        BookList = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Copies = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        ShopSelect = new javax.swing.JComboBox<>();
        BookSelect = new javax.swing.JComboBox<>();
        PrintBox = new javax.swing.JPanel();
        Print = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(721, 503));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NavBar.setForeground(new java.awt.Color(255, 255, 255));
        NavBar.setLayout(null);

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
        YourProfileBox.setLayout(null);

        YourProfile.setFont(new java.awt.Font("Cloud Light", 1, 18)); // NOI18N
        YourProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        YourProfile.setText("Your Profile");
        YourProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        YourProfileBox.add(YourProfile);
        YourProfile.setBounds(0, 0, 220, 40);

        NavBar.add(YourProfileBox);
        YourProfileBox.setBounds(0, 150, 220, 40);

        RequestPrintBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RequestPrintBoxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RequestPrintBoxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RequestPrintBoxMouseExited(evt);
            }
        });
        RequestPrintBox.setLayout(null);

        RequestPrint.setFont(new java.awt.Font("Cloud Light", 1, 18)); // NOI18N
        RequestPrint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RequestPrint.setText("Request to Print");
        RequestPrint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RequestPrintBox.add(RequestPrint);
        RequestPrint.setBounds(0, 0, 220, 40);

        NavBar.add(RequestPrintBox);
        RequestPrintBox.setBounds(0, 200, 220, 40);

        HomeBox.setPreferredSize(new java.awt.Dimension(210, 51));
        HomeBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeBoxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HomeBoxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HomeBoxMouseExited(evt);
            }
        });
        HomeBox.setLayout(null);

        Home.setFont(new java.awt.Font("Cloud Light", 1, 18)); // NOI18N
        Home.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Home.setText("Home");
        Home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HomeBox.add(Home);
        Home.setBounds(0, 0, 220, 40);

        NavBar.add(HomeBox);
        HomeBox.setBounds(0, 100, 220, 40);

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
        LogoutBox.setLayout(null);

        Logout.setFont(new java.awt.Font("Cloud Light", 1, 18)); // NOI18N
        Logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Logout.setText("Log out");
        Logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogoutBox.add(Logout);
        Logout.setBounds(0, 0, 220, 40);

        NavBar.add(LogoutBox);
        LogoutBox.setBounds(0, 300, 220, 40);

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
        BookListBox.setLayout(null);

        BookList.setFont(new java.awt.Font("Cloud Light", 1, 18)); // NOI18N
        BookList.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BookList.setText("Book List");
        BookList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BookListBox.add(BookList);
        BookList.setBounds(0, 0, 220, 40);

        NavBar.add(BookListBox);
        BookListBox.setBounds(0, 250, 220, 40);

        getContentPane().add(NavBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 500));

        jLabel8.setFont(new java.awt.Font("Moon", 1, 16)); // NOI18N
        jLabel8.setText("Select Shop");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, -1, -1));

        jLabel9.setFont(new java.awt.Font("Moon", 1, 16)); // NOI18N
        jLabel9.setText("Book List");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, -1, -1));

        jLabel10.setFont(new java.awt.Font("Moon", 1, 16)); // NOI18N
        jLabel10.setText("Copies");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, -1, 30));

        Copies.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        getContentPane().add(Copies, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 50, 30));

        jLabel11.setFont(new java.awt.Font("Moon", 1, 16)); // NOI18N
        jLabel11.setText("Message to Shop");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, -1, -1));

        description.setColumns(20);
        description.setRows(5);
        jScrollPane1.setViewportView(description);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 400, 110));

        ShopSelect.setFont(new java.awt.Font("supermarket", 0, 14)); // NOI18N
        ShopSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        ShopSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShopSelectActionPerformed(evt);
            }
        });
        getContentPane().add(ShopSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 402, 30));

        BookSelect.setFont(new java.awt.Font("supermarket", 0, 14)); // NOI18N
        BookSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        BookSelect.setToolTipText("");
        BookSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookSelectActionPerformed(evt);
            }
        });
        getContentPane().add(BookSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 402, 30));

        PrintBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrintBoxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PrintBoxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PrintBoxMouseExited(evt);
            }
        });
        PrintBox.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Print.setFont(new java.awt.Font("Cloud Light", 0, 18)); // NOI18N
        Print.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Print.setText("Request");
        Print.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PrintBox.add(Print, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 40));

        getContentPane().add(PrintBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 400, 40));

        jLabel7.setFont(new java.awt.Font("Moon", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Book List");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 460, 40));

        setSize(new java.awt.Dimension(683, 524));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        callList();
        getContentPane().setBackground(new java.awt.Color(228,228,228));
        BookList.setForeground(Color.black);
        HomeBox.setBackground(new java.awt.Color(102,102,102));
        RequestPrintBox.setBackground(new java.awt.Color(102,102,102));
        BookListBox.setBackground(new java.awt.Color(228,228,228));
        LogoutBox.setBackground(new java.awt.Color(102,102,102));
        YourProfileBox.setBackground(new java.awt.Color(102,102,102));
        NavBar.setBackground(new java.awt.Color(102,102,102));
        PrintBox.setBackground(new java.awt.Color(153,255,153));
        Print.setForeground(Color.black);
        Home.setForeground(Color.white);
        YourProfile.setForeground(Color.white);
        RequestPrint.setForeground(Color.white);
        Logout.setForeground(Color.white);
    }//GEN-LAST:event_formWindowActivated

    private void HomeBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeBoxMouseClicked
        // TODO add your handling code here:
        callHome();
    }//GEN-LAST:event_HomeBoxMouseClicked

    private void HomeBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeBoxMouseEntered
        // TODO add your handling code here:
        Home.setForeground(Color.black);
        HomeBox.setBackground(new java.awt.Color(228,228,228));
    }//GEN-LAST:event_HomeBoxMouseEntered

    private void HomeBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeBoxMouseExited
        // TODO add your handling code here:
        HomeBox.setBackground(null);
        Home.setForeground(Color.white);
    }//GEN-LAST:event_HomeBoxMouseExited

    private void YourProfileBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YourProfileBoxMouseEntered
        // TODO add your handling code here:
        YourProfileBox.setBackground(new java.awt.Color(228,228,228));
        YourProfile.setForeground(Color.black);
    }//GEN-LAST:event_YourProfileBoxMouseEntered

    private void YourProfileBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YourProfileBoxMouseClicked
        // TODO add your handling code here:
        callUserProfile();
    }//GEN-LAST:event_YourProfileBoxMouseClicked

    private void YourProfileBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YourProfileBoxMouseExited
        // TODO add your handling code here:
        YourProfileBox.setBackground(null);
        YourProfile.setForeground(Color.white);
    }//GEN-LAST:event_YourProfileBoxMouseExited

    private void RequestPrintBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RequestPrintBoxMouseClicked
        // TODO add your handling code here:
        callRequestPage();
    }//GEN-LAST:event_RequestPrintBoxMouseClicked

    private void RequestPrintBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RequestPrintBoxMouseEntered
        // TODO add your handling code here:
        RequestPrintBox.setBackground(new java.awt.Color(228,228,228));
        RequestPrint.setForeground(Color.black);
    }//GEN-LAST:event_RequestPrintBoxMouseEntered

    private void RequestPrintBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RequestPrintBoxMouseExited
        // TODO add your handling code here:
        RequestPrint.setForeground(Color.white);
        RequestPrintBox.setBackground(null);
    }//GEN-LAST:event_RequestPrintBoxMouseExited

    private void LogoutBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutBoxMouseClicked
        // TODO add your handling code here:
        Logout();
    }//GEN-LAST:event_LogoutBoxMouseClicked

    private void LogoutBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutBoxMouseEntered
        // TODO add your handling code here:
        Logout.setForeground(Color.black);
        LogoutBox.setBackground(new java.awt.Color(228,228,228));
    }//GEN-LAST:event_LogoutBoxMouseEntered

    private void LogoutBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutBoxMouseExited
        // TODO add your handling code here:
        Logout.setForeground(Color.white);
        LogoutBox.setBackground(null);
    }//GEN-LAST:event_LogoutBoxMouseExited

    private void ShopSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShopSelectActionPerformed
        PrintBook();
    }//GEN-LAST:event_ShopSelectActionPerformed

    private void BookSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookSelectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BookSelectActionPerformed

    private void BookListBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookListBoxMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_BookListBoxMouseEntered

    private void BookListBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookListBoxMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_BookListBoxMouseExited

    private void BookListBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookListBoxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BookListBoxMouseClicked

    private void PrintBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintBoxMouseClicked
        // TODO add your handling code here:
        RequestBook();
    }//GEN-LAST:event_PrintBoxMouseClicked

    private void PrintBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintBoxMouseEntered
        // TODO add your handling code here:
       
    }//GEN-LAST:event_PrintBoxMouseEntered

    private void PrintBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrintBoxMouseExited
        // TODO add your handling code here:
       
    }//GEN-LAST:event_PrintBoxMouseExited

    public static int getOrderID(){
        try {
            Connection con = ConnectionBuilder.getConnection();
            PreparedStatement pstmSel = con.prepareStatement("SELECT orderID FROM Orders;");
            ResultSet rs = pstmSel.executeQuery();
            while(rs.next()){
                LastOrderID = rs.getInt("orderID");
            }
            
            System.out.println("LastOrderId"+LastOrderID);
        } catch (SQLException ex) {
            Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return LastOrderID;
    }

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
            java.util.logging.Logger.getLogger(BookList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BookList;
    private javax.swing.JPanel BookListBox;
    private javax.swing.JComboBox<String> BookSelect;
    private javax.swing.JSpinner Copies;
    private javax.swing.JLabel Home;
    private javax.swing.JPanel HomeBox;
    private javax.swing.JLabel Logout;
    private javax.swing.JPanel LogoutBox;
    private javax.swing.JPanel NavBar;
    private javax.swing.JLabel Print;
    private javax.swing.JPanel PrintBox;
    private javax.swing.JLabel RequestPrint;
    private javax.swing.JPanel RequestPrintBox;
    private javax.swing.JComboBox<String> ShopSelect;
    private javax.swing.JLabel YourProfile;
    private javax.swing.JPanel YourProfileBox;
    private javax.swing.JTextArea description;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
